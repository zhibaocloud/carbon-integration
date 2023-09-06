/*
 * Copyright (c) 2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
 * Carbon Integration SDK is licensed under Mulan PSL v2.
 *
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.zhibaocloud.carbon.intg.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.intg.CarbonOption;
import com.zhbiaocloud.carbon.intg.CarbonResponse;
import com.zhbiaocloud.carbon.intg.CarbonMessageException;
import com.zhbiaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhbiaocloud.carbon.intg.crypto.Crypto;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.intg.CarbonMessageType;
import com.zhbiaocloud.carbon.intg.model.CarbonPolicy;
import com.zhbiaocloud.carbon.intg.model.CarbonReceipt;
import com.zhbiaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhbiaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.client.CarbonClient;
import java.io.IOException;
import java.net.URI;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 使用 Apache HttpClient 实现的智保云数据平台客户端
 *
 * @author jun
 */
@Slf4j
public class CarbonClientImpl implements CarbonClient {

  private final CarbonOption option;

  private final ObjectMapper mapper;

  private final CloseableHttpClient client;

  private final CarbonDataChannel channel;

  public CarbonClientImpl(
      ObjectMapper mapper,
      CloseableHttpClient client,
      Crypto crypto,
      CarbonOption option
  ) {
    this.option = option;
    this.mapper = mapper;
    this.client = client;
    this.channel = new CarbonDataChannel(mapper, crypto, option);
  }

  private void send(CarbonMessageType type, Object request) throws IOException {
    if (log.isDebugEnabled()) {
      log.debug("request: {}", mapper.writeValueAsString(request));
    }

    EncryptedRequest encryptedRequest = channel.encodeRequest(type, request);

    URI target = option.getEndpoint();
    HttpPost post = new HttpPost(target);
    String body = mapper.writeValueAsString(encryptedRequest);

    post.setHeader("Content-Type", "application/json;charset=utf-8");
    post.setEntity(new StringEntity(body, "UTF-8"));

    try (CloseableHttpResponse response = client.execute(post)) {
      StatusLine sl = response.getStatusLine();
      String encryptedResponse = EntityUtils.toString(response.getEntity());

      int statusCode = sl.getStatusCode();
      if (statusCode >= 200 && statusCode < 300) {
        EncryptedResponse result = mapper.readValue(encryptedResponse, EncryptedResponse.class);
        CarbonResponse res = channel.decodeResponse(result, CarbonResponse.class);
        if (log.isDebugEnabled()) {
          log.debug("response: {}", mapper.writeValueAsString(res));
        }
        if (!res.isSuccess()) {
          throw new CarbonMessageException(res.getMessage());
        }
      } else {
        log.error("request failed: {}, response: {}", sl, encryptedResponse);
        throw new IOException("request failed: " + sl);
      }
    }
  }

  @Override
  public void publish(CarbonPolicy policy) throws IOException {
    send(CarbonMessageType.UNDERWRITE, policy);
  }

  @Override
  public void publish(CarbonReceipt receipt) throws IOException {
    send(CarbonMessageType.RECEIPT, receipt);
  }

  @Override
  public void publish(CarbonRtnCall rtnCall) throws IOException {
    send(CarbonMessageType.RTN_CALL, rtnCall);
  }

  @Override
  public void publish(CarbonStatusChanged status) throws IOException {
    send(CarbonMessageType.STATUS, status);
  }
}
