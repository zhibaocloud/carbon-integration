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

package com.zhibaocloud.carbon.intg.crypto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.SignatureMissMatchException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * 信道加密
 *
 * @author jun
 */
@RequiredArgsConstructor
public class CarbonDataChannel {

  private final ObjectMapper mapper;

  private final Crypto crypto;

  private final CarbonOption option;

  @SneakyThrows
  public CarbonEncryptedRequest encodeRequest(CarbonMessageType type, Object request) {
    String payload = mapper.writeValueAsString(request);
    CarbonEncryptedRequest message = new CarbonEncryptedRequest();
    message.setType(type);
    message.setTenant(option.getTenant());
    message.setRequestId(UUID.randomUUID());
    message.setSign(crypto.digest(payload));
    message.setPayload(crypto.encrypt(payload));
    return message;
  }

  @SneakyThrows
  public CarbonEncryptedResponse encodeResponse(UUID requestId, Object response) {
    String payload = mapper.writeValueAsString(response);
    CarbonEncryptedResponse message = new CarbonEncryptedResponse();
    message.setRequestId(requestId);
    message.setTenant(option.getTenant());
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
  public <T> T decodeRequest(CarbonEncryptedRequest request, Class<T> clz) {
    String payload = crypto.decrypt(request.getPayload());
    verify(payload, request.getSign());
    return mapper.readValue(payload, clz);
  }

  @SneakyThrows
  public <T> T decodeResponse(CarbonEncryptedResponse response, Class<T> clz) {
    String payload = crypto.decrypt(response.getPayload());
    verify(payload, response.getSign());
    return mapper.readValue(payload, clz);
  }
}
