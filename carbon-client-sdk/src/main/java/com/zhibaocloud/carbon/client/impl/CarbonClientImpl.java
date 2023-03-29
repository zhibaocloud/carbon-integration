/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhibaocloud.carbon.client.MessageException;
import com.zhibaocloud.carbon.client.CarbonClient;
import com.zhibaocloud.carbon.client.ClientMode;
import com.zhibaocloud.carbon.client.ClientOption;
import com.zhibaocloud.carbon.client.SignatureMissMatchException;
import com.zhibaocloud.carbon.client.model.CarbonRequest;
import com.zhbiaocloud.carbon.model.EncryptedRequest;
import com.zhbiaocloud.carbon.model.EncryptedResponse;
import com.zhibaocloud.carbon.client.model.CarbonResponse;
import java.io.IOException;
import java.net.URI;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

@Slf4j
@RequiredArgsConstructor
public class CarbonClientImpl implements CarbonClient {

  private final ClientOption option;

  private final ObjectMapper mapper;

  private final CloseableHttpClient client;

  @SneakyThrows
  private URI buildTargetUri(CarbonRequest<?> request) {
    ClientMode mode = option.getMode();
    return new URIBuilder(option.getEndpoint())
        .setPathSegments("v2", "callbacks", mode.getValue(), option.getAppId(), request.getType())
        .build();
  }

  @SneakyThrows
  private String sign(String payload) {
    MessageDigest sha1 = MessageDigest.getInstance(option.getSignAlg());
    byte[] raw = (payload + option.getSalt()).getBytes();
    byte[] sign = sha1.digest(raw);
    return Base64.getEncoder().encodeToString(sign);
  }

  private String encrypt(String payload) {
    return payload;
  }

  private String decrypt(String payload) {
    return payload;
  }

  private void send(CarbonRequest<?> request) throws IOException {
    EncryptedRequest encryptedRequest = createRequest(request);

    URI target = buildTargetUri(request);
    HttpPost post = new HttpPost(target);
    String body = mapper.writeValueAsString(encryptedRequest);
    post.setEntity(new StringEntity(body, "UTF-8"));

    try (CloseableHttpResponse response = client.execute(post)) {
      StatusLine sl = response.getStatusLine();
      String encryptedResponse = EntityUtils.toString(response.getEntity());
      if (sl.getStatusCode() != 200) {
        log.error("request failed: {}, response: {}", sl, encryptedResponse);
        throw new IOException("request failed: " + sl);
      }
      CarbonResponse res = parseResponse(encryptedResponse);
      if (!res.isSuccess()) {
        throw new MessageException(res.getMessage());
      }
    }
  }

  private CarbonResponse parseResponse(String rawResponse) throws IOException {
    EncryptedResponse response = mapper.readValue(rawResponse, EncryptedResponse.class);
    String payload = decrypt(response.getPayload());

    String expectedSign = sign(payload);
    String actualSign = response.getSign();
    if (!expectedSign.equals(actualSign)) {
      throw new SignatureMissMatchException(expectedSign, actualSign);
    }
    return mapper.readValue(payload, CarbonResponse.class);
  }

  private EncryptedRequest createRequest(CarbonRequest<?> request) throws IOException {
    String payload = mapper.writeValueAsString(request);
    return new EncryptedRequest(UUID.randomUUID(), sign(payload), encrypt(payload));
  }

  @Override
  public void publish(Policy policy) throws IOException {
    send(new CarbonRequest<>("underwrite", policy));
  }

  @Override
  public void publish(Receipt receipt) throws IOException {
    send(new CarbonRequest<>("receipt", receipt));
  }

  @Override
  public void publish(RtnCall rtnCall) throws IOException {
    send(new CarbonRequest<>("rtnCall", rtnCall));
  }
}
