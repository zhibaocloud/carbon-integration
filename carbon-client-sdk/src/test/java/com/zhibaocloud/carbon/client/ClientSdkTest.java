/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhibaocloud.carbon.client.impl.CarbonClientImpl;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import lombok.SneakyThrows;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;

class ClientSdkTest {

  private final ObjectMapper mapper = new CarbonMapperFactory().create();

  private String loadResource(String name) throws IOException {
    try (InputStream stream = ClientSdkTest.class.getClassLoader().getResourceAsStream(name)) {
      return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    }
  }

  @SneakyThrows
  private CloseableHttpClient mockResponse(String resource) {
    CloseableHttpClient httpClient = mock(CloseableHttpClient.class);
    CloseableHttpResponse response = mock(CloseableHttpResponse.class);
    StatusLine sl = mock(StatusLine.class);
    String content = loadResource(resource);
    when(httpClient.execute(any())).thenReturn(response);
    when(sl.getStatusCode()).thenReturn(200);
    when(response.getStatusLine()).thenReturn(sl);
    when(response.getEntity()).thenReturn(new StringEntity(content, "UTF-8"));
    return httpClient;
  }

  @Test
  void testMessageSend() throws Exception {
    ClientOption option = new ClientOption();
    option.setEndpoint(new URI("http://localhost:8080"));
    option.setAppId(UUID.randomUUID().toString());
    option.getCrypto().setSecret("wD2Neym2V3ZfpWzR");
    option.getCrypto().setIv("GzZz3LBzALvC6s9i");
    option.setSalt("dZJjh7bMU57zVtSc");

    CryptoFactory factory = new CryptoFactory();
    CloseableHttpClient httpClient = mockResponse("encrypted-policy-sync-response.json");
    CarbonClient client = new CarbonClientImpl(option, mapper, httpClient, factory);
    Policy policy = new Policy();
//    client.publish(policy);
  }
}
