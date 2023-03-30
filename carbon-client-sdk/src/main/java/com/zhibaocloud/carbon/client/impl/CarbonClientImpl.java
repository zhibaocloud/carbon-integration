/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonChannel;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.model.EncryptedRequest;
import com.zhbiaocloud.carbon.model.EncryptedResponse;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhibaocloud.carbon.client.CarbonClient;
import com.zhibaocloud.carbon.client.ClientMode;
import com.zhibaocloud.carbon.client.ClientOption;
import com.zhbiaocloud.carbon.MessageException;
import com.zhbiaocloud.carbon.CarbonRequest;
import com.zhbiaocloud.carbon.CarbonResponse;
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
  private URI buildTargetUri(String type) {
    ClientMode mode = option.getMode();
    return new URIBuilder(option.getEndpoint())
        .setPathSegments("v2", "callbacks", mode.getValue(), option.getAppId(), type)
        .build();
  }

  private void send(String type, Object request) throws IOException {
    EncryptedRequest encryptedRequest = channel.encodeRequest(request);

    URI target = buildTargetUri(type);
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
    send("underwrite", policy);
  }

  @Override
  public void publish(Receipt receipt) throws IOException {
    send("receipt", receipt);
  }

  @Override
  public void publish(RtnCall rtnCall) throws IOException {
    send("rtncall", rtnCall);
  }
}
