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

package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhibacloud.carbon.mock.CarbonDataMock;
import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.crypto.Crypto;
import com.zhibaocloud.carbon.intg.crypto.CryptoConfiguration;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CryptoTest {

  private final CryptoFactory factory = new CryptoFactory();


  @Test
  void testChannel() throws IOException {

    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setIv("dyRnJ6bVxWTdHd64");
    Crypto crypto = factory.create(config);
    CarbonOption option = new CarbonOption();
    CarbonSerializer mapper = new CarbonJacksonSerializerFactory().create(
        new SerializationConfiguration());
    CarbonDataChannel channel = new CarbonDataChannel(mapper, crypto, option);

    CarbonPolicy originPolicy = CarbonDataMock.mock(CarbonPolicy.class);
    CarbonEncryptedRequest req = channel.encodeRequest(CarbonMessageType.UNDERWRITE, originPolicy);
    CarbonPolicy decryptedPolicy = channel.decodeRequest(req, CarbonPolicy.class);

    // 因为 LocalDateTime 带有毫秒，但是在序列化的时候只携带了秒。序列化后会有精度损失
    String originPolicyJson = mapper.serialize(originPolicy);
    String decryptedPolicyJson = mapper.serialize(decryptedPolicy);
    assertThat(decryptedPolicyJson).isEqualTo(originPolicyJson);

    CarbonResponse originResponse = CarbonDataMock.mock(CarbonResponse.class);
    CarbonEncryptedResponse res = channel.encodeResponse(UUID.randomUUID(), originResponse);
    CarbonResponse decryptedResponse = channel.decodeResponse(res, CarbonResponse.class);
    String originResponseJson = mapper.serialize(originResponse);
    String decryptedResponseJson = mapper.serialize(decryptedResponse);
    assertThat(decryptedResponseJson).isEqualTo(originResponseJson);
  }
}
