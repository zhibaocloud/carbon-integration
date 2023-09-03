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

package com.zhibaocloud.carbon.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.MessageException;
import com.zhbiaocloud.carbon.crypto.CarbonChannel;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.model.MessageType;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import com.zhibaocloud.carbon.client.CarbonClient;
import com.zhibaocloud.carbon.client.ClientOption;
import java.io.IOException;
import java.net.URI;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 使用 Apache HttpClient 实现的智保云投保通道客户端
 *
 * @author jun
 */
@Slf4j
public class CarbonClientImpl implements CarbonClient {

  private final ClientOption option;

  private final ObjectMapper mapper;

  private final CloseableHttpClient client;

  private final CarbonChannel channel;

  public CarbonClientImpl(
      ObjectMapper mapper,
      CloseableHttpClient client,
      Crypto crypto,
      ClientOption option
  ) {
    this.option = option;
    this.mapper = mapper;
    this.client = client;
    this.channel = new CarbonChannel(mapper, crypto);
  }

  @SneakyThrows
  private URI buildTargetUri() {
    return new URIBuilder(option.getEndpoint()).build();
  }

  private void send(MessageType type, Object request) throws IOException {
    EncryptedRequest encryptedRequest = channel.encodeRequest(type, request);

    URI target = buildTargetUri();
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
        if (!res.isSuccess()) {
          throw new MessageException(res.getMessage());
        }
      } else {
        log.error("request failed: {}, response: {}", sl, encryptedResponse);
        throw new IOException("request failed: " + sl);
      }
    }
  }

  @Override
  public void publish(Policy policy) throws IOException {
    send(MessageType.UNDERWRITE, policy);
  }

  @Override
  public void publish(Receipt receipt) throws IOException {
    send(MessageType.RECEIPT, receipt);
  }

  @Override
  public void publish(RtnCall rtnCall) throws IOException {
    send(MessageType.RTN_CALL, rtnCall);
  }

  @Override
  public void publish(StatusChanged status) throws IOException {
    send(MessageType.STATUS, status);
  }
}
