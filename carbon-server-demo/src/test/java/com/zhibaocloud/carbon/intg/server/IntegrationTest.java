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

package com.zhibaocloud.carbon.intg.server;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.crypto.Crypto;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import com.zhibaocloud.carbon.intg.server.starter.CarbonServerProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@AutoConfigureMockMvc
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = CarbonServerApplication.class
)
class IntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Autowired
  private CarbonServerProperties config;

  @Test
  void testSyncApi() throws Exception {
    runDataSync(CarbonMessageType.UNDERWRITE, JMockData.mock(CarbonPolicy.class));
    runDataSync(CarbonMessageType.RECEIPT, JMockData.mock(CarbonReceipt.class));
    runDataSync(CarbonMessageType.RTN_CALL, JMockData.mock(CarbonRtnCall.class));
    runDataSync(CarbonMessageType.STATUS, JMockData.mock(CarbonStatusChanged.class));
  }

  private void runDataSync(CarbonMessageType type, Object request) throws Exception {
    CarbonSerializer mapper = new CarbonJacksonSerializerFactory().create(new SerializerConfiguration());
    Crypto crypto = new CryptoFactory().create(config.getCrypto());

    CarbonOption option = new CarbonOption();
    option.setCrypto(config.getCrypto());
    CarbonDataChannel channel = new CarbonDataChannel(mapper, crypto, option);

    CarbonEncryptedRequest encryptedRequest = channel.encodeRequest(type, request);
    String payload = mapper.serialize(encryptedRequest);

    MvcResult result = mvc.perform(post("/v2/callbacks/a/fd3c35de-ca5f-4442-87aa-17edc67f93d0")
            .content(payload)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    String responseBody = result.getResponse().getContentAsString();
    CarbonEncryptedResponse wrapper = mapper.deserialize(responseBody, CarbonEncryptedResponse.class);
    CarbonResponse response = channel.decodeResponse(wrapper, CarbonResponse.class);
    assertThat(response.isSuccess()).isTrue();
  }
}
