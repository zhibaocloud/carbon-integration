/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhibaocloud.carbon.intg.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jsonzou.jmockdata.JMockData;
import com.zhbiaocloud.carbon.intg.CarbonMapperFactory;
import com.zhbiaocloud.carbon.intg.CarbonOption;
import com.zhbiaocloud.carbon.intg.CarbonResponse;
import com.zhbiaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhbiaocloud.carbon.intg.crypto.Crypto;
import com.zhbiaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.intg.model.CarbonPolicy;
import com.zhbiaocloud.carbon.intg.model.CarbonReceipt;
import com.zhbiaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhbiaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.client.impl.CarbonClientImpl;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClientSdkTest {

  private final ObjectMapper mapper = new CarbonMapperFactory(false).create();

  private CloseableHttpClient mockHttpClient(String payload, int statusCode) throws IOException {
    CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
    CloseableHttpResponse response = mock(CloseableHttpResponse.class);
    StatusLine sl = mock(StatusLine.class);
    when(httpClient.execute(any())).thenReturn(response);
    when(sl.getStatusCode()).thenReturn(statusCode);
    when(response.getStatusLine()).thenReturn(sl);
    when(response.getEntity()).thenReturn(new StringEntity(payload, "UTF-8"));
    return httpClient;
  }

  @Test
  void testMessageSend() throws Exception {
    CarbonOption option = new CarbonOption();
    option.setEndpoint(new URI("http://localhost:8080"));
    option.getCrypto().setSecret("wD2Neym2V3ZfpWzR");
    option.getCrypto().setIv("GzZz3LBzALvC6s9i");
    option.getCrypto().setSalt("dZJjh7bMU57zVtSc");

    CryptoFactory factory = new CryptoFactory();
    Crypto crypto = factory.create(option.getCrypto());
    CarbonDataChannel channel = new CarbonDataChannel(mapper, crypto, option);

    CarbonResponse message = new CarbonResponse();
    message.setSuccess(true);
    message.setMessage("OK");

    EncryptedResponse encryptedResponse = channel.encodeResponse(UUID.randomUUID(), message);
    String payload = mapper.writeValueAsString(encryptedResponse);

    CloseableHttpClient httpClient = mockHttpClient(payload, 200);
    CarbonClient client = new CarbonClientImpl(mapper, httpClient, crypto, option);
    client.publish(JMockData.mock(CarbonPolicy.class));
    client.publish(JMockData.mock(CarbonReceipt.class));
    client.publish(JMockData.mock(CarbonRtnCall.class));
    client.publish(JMockData.mock(CarbonStatusChanged.class));

    Mockito.verify(httpClient, times(4)).execute(any());
  }
}
