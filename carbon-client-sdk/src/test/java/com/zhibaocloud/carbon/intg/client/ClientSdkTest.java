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

package com.zhibaocloud.carbon.intg.client;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhibaocloud.carbon.intg.fastjson.CarbonFastjsonSerializerFactory;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.client.impl.CarbonClientImpl;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.crypto.Crypto;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import java.io.IOException;
import java.net.URI;
import java.util.UUID;
import java.util.stream.Stream;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

class ClientSdkTest {


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

  private static Stream<CarbonSerializerFactory> providerSerializer() {
    return Stream.of(
        new CarbonJacksonSerializerFactory(),
        new CarbonFastjsonSerializerFactory(),
        new CarbonGsonSerializerFactory()
    );
  }


  @ParameterizedTest
  @MethodSource("providerSerializer")
  void testMessageSend(CarbonSerializerFactory sf) throws Exception {
    CarbonOption option = new CarbonOption();
    option.setEndpoint(new URI("http://localhost:8080"));
    option.getCrypto().setSecret("wD2Neym2V3ZfpWzR");
    option.getCrypto().setIv("GzZz3LBzALvC6s9i");
    option.getCrypto().setSalt("dZJjh7bMU57zVtSc");

    CryptoFactory factory = new CryptoFactory();
    Crypto crypto = factory.create(option.getCrypto());

    SerializerConfiguration config = new SerializerConfiguration();
    CarbonSerializer serializer = sf.create(config);
    CarbonDataChannel channel = new CarbonDataChannel(serializer, crypto, option);

    CarbonResponse message = new CarbonResponse();
    message.setSuccess(true);
    message.setMessage("OK");

    CarbonEncryptedResponse encryptedResponse = channel.encodeResponse(UUID.randomUUID(), message);
    String payload = serializer.serialize(encryptedResponse);

    CloseableHttpClient httpClient = mockHttpClient(payload, 200);
    CarbonClient client = new CarbonClientImpl(serializer, httpClient, crypto, option);
    client.publish(JMockData.mock(CarbonPolicy.class));
    client.publish(JMockData.mock(CarbonReceipt.class));
    client.publish(JMockData.mock(CarbonRtnCall.class));
    client.publish(JMockData.mock(CarbonStatusChanged.class));
    Mockito.verify(httpClient, times(4)).execute(any());
  }
}
