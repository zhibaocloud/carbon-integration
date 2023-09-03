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

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.zhbiaocloud.carbon.CarbonOption;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.crypto.CarbonDataChannel;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.crypto.HashAlg;
import com.zhbiaocloud.carbon.crypto.SymmetricCrypto;
import com.zhbiaocloud.carbon.model.MessageType;
import com.zhbiaocloud.carbon.model.Policy;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CryptoTest {

  private final CryptoFactory factory = new CryptoFactory();

  @Test
  void testSymmetricCrypto() {
    for (SymmetricCrypto mode : SymmetricCrypto.values()) {
      CryptoConfiguration config = new CryptoConfiguration();
      config.setSymmetricAlg(mode);
      config.setSecret("g9wuZX5rQKqin9qA");
      config.setIv("dyRnJ6bVxWTdHd64");

      Crypto crypto = factory.create(config);
      String origin = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n"
          + "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,\n"
          + "when an unknown printer took a galley of type and scrambled it to make a type specimen book.\n"
          + "It has survived not only five centuries, but also the leap into electronic typesetting,\n"
          + "remaining essentially unchanged. It was popularised in the 1960s with the release of\n"
          + "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing\n"
          + "software like Aldus PageMaker including versions of Lorem Ipsum.";

      String cipher = crypto.encrypt(origin);
      String plain = crypto.decrypt(cipher);
      assertThat(plain).isEqualTo(origin);
    }
  }

  @Test
  void testHash() {
    for (HashAlg alg : HashAlg.values()) {
      CryptoConfiguration config = new CryptoConfiguration();
      config.setDigestAlg(alg);
      config.setSecret("g9wuZX5rQKqin9qA");
      config.setIv("dyRnJ6bVxWTdHd64");
      config.setSalt("dyRnJ6bVxWTdHd64");
      Crypto crypto = factory.create(config);
      String hash = crypto.digest("hello world");
      System.out.println(alg.getAlg() + ": " + hash);
      assertThat(hash).isNotNull();
    }
  }

  @Test
  void testChannel() throws IOException {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setIv("dyRnJ6bVxWTdHd64");
    Crypto crypto = factory.create(config);
    CarbonOption option = new CarbonOption();
    ObjectMapper mapper = new CarbonMapperFactory(false).create();
    CarbonDataChannel channel = new CarbonDataChannel(mapper, crypto, option);

    Policy originPolicy = JMockData.mock(Policy.class);
    EncryptedRequest req = channel.encodeRequest(MessageType.UNDERWRITE, originPolicy);
    Policy decryptedPolicy = channel.decodeRequest(req, Policy.class);

    // 因为 LocalDateTime 带有毫秒，但是在序列化的时候只携带了秒。序列化后会有精度损失
    String originPolicyJson = mapper.writeValueAsString(originPolicy);
    String decryptedPolicyJson = mapper.writeValueAsString(decryptedPolicy);
    assertThat(decryptedPolicyJson).isEqualTo(originPolicyJson);

    CarbonResponse originResponse = JMockData.mock(CarbonResponse.class);
    EncryptedResponse res = channel.encodeResponse(UUID.randomUUID(), originResponse);
    CarbonResponse decryptedResponse = channel.decodeResponse(res, CarbonResponse.class);
    String originResponseJson = mapper.writeValueAsString(originResponse);
    String decryptedResponseJson = mapper.writeValueAsString(decryptedResponse);
    assertThat(decryptedResponseJson).isEqualTo(originResponseJson);
  }
}
