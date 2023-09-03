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

package com.zhibaocloud.carbon;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.crypto.CarbonChannel;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.model.MessageType;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
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
    classes = CarbonMockServerApplication.class
)
class IntegrationTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void testSyncApi() throws Exception {
    runDataSync(MessageType.UNDERWRITE, JMockData.mock(Policy.class));
    runDataSync(MessageType.RECEIPT, JMockData.mock(Receipt.class));
    runDataSync(MessageType.RTN_CALL, JMockData.mock(RtnCall.class));
    runDataSync(MessageType.STATUS, JMockData.mock(StatusChanged.class));
  }

  private void runDataSync(MessageType type, Object request) throws Exception {
    ObjectMapper mapper = new CarbonMapperFactory(false).create();
    Crypto crypto = new CryptoFactory().create(DemoConfiguration.crypto());

    String appId = DemoConfiguration.appId();
    CarbonChannel channel = new CarbonChannel(mapper, crypto);

    EncryptedRequest encryptedRequest = channel.encodeRequest(type, request);
    String payload = mapper.writeValueAsString(encryptedRequest);

    MvcResult result = mvc.perform(post("/v2/callbacks/a/" + appId)
            .content(payload)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();
    String responseBody = result.getResponse().getContentAsString();
    EncryptedResponse wrapper = mapper.readValue(responseBody, EncryptedResponse.class);
    CarbonResponse response = channel.decodeResponse(wrapper, CarbonResponse.class);
    assertThat(response.isSuccess()).isTrue();
  }
}
