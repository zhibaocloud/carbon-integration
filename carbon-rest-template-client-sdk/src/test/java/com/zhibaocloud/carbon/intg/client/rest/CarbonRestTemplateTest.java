package com.zhibaocloud.carbon.intg.client.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.crypto.Crypto;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.fastjson.CarbonFastjsonSerializerFactory;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.net.URI;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangtuo
 */
class CarbonRestTemplateTest {

  RestTemplate mockRestTemplate(String payload, HttpStatus status) {
    ResponseEntity<String> response = new ResponseEntity<>(payload, status);
    RestTemplate restTemplate = mock(RestTemplate.class);
    when(restTemplate.exchange(any(RequestEntity.class), eq(String.class))).thenReturn(response);

    return restTemplate;
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

    SerializationConfiguration config = new SerializationConfiguration();
    CarbonSerializer serializer = sf.create(config);
    CarbonDataChannel channel = new CarbonDataChannel(serializer, crypto, option);

    CarbonResponse message = new CarbonResponse();
    message.setSuccess(true);
    message.setMessage("OK");

    CarbonEncryptedResponse encryptedResponse = channel.encodeResponse(UUID.randomUUID(), message);
    String payload = serializer.serialize(encryptedResponse);

    RestTemplate restTemplate = mockRestTemplate(payload, HttpStatus.OK);
    CarbonRestTemplate client = new CarbonRestTemplate(option, serializer, restTemplate, channel);
    client.publish(JMockData.mock(CarbonPolicy.class));
    client.publish(JMockData.mock(CarbonReceipt.class));
    client.publish(JMockData.mock(CarbonRtnCall.class));
    client.publish(JMockData.mock(CarbonStatusChanged.class));
    Mockito.verify(restTemplate, times(4)).exchange(any(RequestEntity.class), eq(String.class));
  }

}