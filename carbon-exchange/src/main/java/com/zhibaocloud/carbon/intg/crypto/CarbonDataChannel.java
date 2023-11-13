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

import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.SignatureMissMatchException;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
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

  private final CarbonSerializer serializer;

  private final Crypto crypto;

  private final CarbonOption option;

  /**
   * 封装链路请求。HTTP 是作为传输层使用
   *
   * @param type    数据类型
   * @param request 报文详情
   * @return 在链路上传输报文
   */
  @SneakyThrows
  public CarbonEncryptedRequest encodeRequest(CarbonMessageType type, Object request) {
    String payload = serializer.serialize(request);
    CarbonEncryptedRequest message = new CarbonEncryptedRequest();
    message.setType(type);
    message.setTenant(option.getTenant());
    message.setRequestId(UUID.randomUUID());
    message.setSign(crypto.digest(payload));
    message.setPayload(crypto.encrypt(payload));
    return message;
  }

  /**
   * 封装链路响应，用于通知发送方该数据是否已被正常消费
   *
   * @param requestId 请求ID
   * @param response  相应内容
   * @return 在链路上传输报文
   */
  @SneakyThrows
  public CarbonEncryptedResponse encodeResponse(UUID requestId, Object response) {
    String payload = serializer.serialize(response);
    CarbonEncryptedResponse message = new CarbonEncryptedResponse();
    message.setRequestId(requestId);
    message.setTenant(option.getTenant());
    message.setSign(crypto.digest(payload));
    message.setPayload(crypto.encrypt(payload));
    return message;
  }

  /**
   * 校验数据有效性，是否被篡改等
   *
   * @param payload    报文内容
   * @param actualSign 摘要
   */
  private void verify(String payload, String actualSign) {
    String expectedSign = crypto.digest(payload);
    if (!expectedSign.equals(actualSign)) {
      throw new SignatureMissMatchException(expectedSign, actualSign);
    }
  }

  /**
   * 解密收到的推送数据
   *
   * @param request 服务端收到的推送数据
   * @param clz     需要解析的数据类型
   * @param <T>     数据类型
   * @return 解析后的数据
   */
  @SneakyThrows
  public <T> T decodeRequest(CarbonEncryptedRequest request, Class<T> clz) {
    String payload = crypto.decrypt(request.getPayload());
    verify(payload, request.getSign());
    return serializer.deserialize(payload, clz);
  }

  /**
   * 解密收到的响应数据
   *
   * @param response 推送方收到接收方的返回内容
   * @param clz      需要解析的数据类型
   * @param <T>      数据类型
   * @return 解析后的数据
   */
  @SneakyThrows
  public <T> T decodeResponse(CarbonEncryptedResponse response, Class<T> clz) {
    String payload = crypto.decrypt(response.getPayload());
    verify(payload, response.getSign());
    return serializer.deserialize(payload, clz);
  }
}
