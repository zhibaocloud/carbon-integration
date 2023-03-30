/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * 信道加密
 *
 * @author jun
 */
@RequiredArgsConstructor
public class CarbonChannel {

  private final ObjectMapper mapper;

  private final Crypto crypto;

  @SneakyThrows
  public EncryptedRequest encodeRequest(Object request) {
    String payload = mapper.writeValueAsString(request);
    EncryptedRequest message = new EncryptedRequest();
    message.setRequestId(UUID.randomUUID());
    message.setSign(crypto.digest(payload));
    message.setPayload(crypto.encrypt(payload));
    return message;
  }

  @SneakyThrows
  public EncryptedResponse encodeResponse(UUID requestId, Object response) {
    String payload = mapper.writeValueAsString(response);
    EncryptedResponse message = new EncryptedResponse();
    message.setRequestId(requestId);
    message.setSign(crypto.digest(payload));
    message.setPayload(crypto.encrypt(payload));
    return message;
  }

  private void verify(String payload, String actualSign) {
    String expectedSign = crypto.digest(payload);
    if (!expectedSign.equals(actualSign)) {
      throw new SignatureMissMatchException(expectedSign, actualSign);
    }
  }

  @SneakyThrows
  public <T> T decodeRequest(EncryptedRequest request, Class<T> clz) {
    String payload = crypto.decrypt(request.getPayload());
    verify(payload, request.getSign());
    return mapper.readValue(payload, clz);
  }

  @SneakyThrows
  public <T> T decodeResponse(EncryptedResponse response, Class<T> clz) {
    String payload = crypto.decrypt(response.getPayload());
    verify(payload, response.getSign());
    return mapper.readValue(payload, clz);
  }
}
