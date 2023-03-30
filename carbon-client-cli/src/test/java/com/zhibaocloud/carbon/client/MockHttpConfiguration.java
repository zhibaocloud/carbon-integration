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

package com.zhibaocloud.carbon.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonChannel;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhibaocloud.carbon.demo.DemoConfiguration;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockHttpConfiguration {

  @Bean
  public CloseableHttpClient httpClient() throws IOException, URISyntaxException {
    ClientOption option = new ClientOption();
    option.setEndpoint(new URI("http://localhost:8080"));
    option.setAppId(DemoConfiguration.appId());
    option.setCrypto(DemoConfiguration.crypto());

    CarbonMapperFactory mapperFactory = new CarbonMapperFactory(false);
    ObjectMapper mapper = mapperFactory.create();

    CryptoFactory factory = new CryptoFactory();
    Crypto crypto = factory.create(option.getCrypto());
    CarbonChannel channel = new CarbonChannel(mapper, crypto);

    CarbonResponse message = new CarbonResponse();
    message.setSuccess(true);
    message.setMessage("OK");

    EncryptedResponse encryptedResponse = channel.encodeResponse(UUID.randomUUID(), message);
    String payload = mapper.writeValueAsString(encryptedResponse);

    CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
    CloseableHttpResponse response = mock(CloseableHttpResponse.class);
    StatusLine sl = mock(StatusLine.class);
    when(httpClient.execute(any())).thenReturn(response);
    when(sl.getStatusCode()).thenReturn(200);
    when(response.getStatusLine()).thenReturn(sl);
    when(response.getEntity()).thenReturn(new StringEntity(payload, "UTF-8"));
    return httpClient;
  }
}
