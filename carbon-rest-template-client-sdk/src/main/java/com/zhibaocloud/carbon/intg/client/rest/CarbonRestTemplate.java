package com.zhibaocloud.carbon.intg.client.rest;

import com.zhibaocloud.carbon.intg.CarbonMessageException;
import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.client.CarbonClient;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import java.io.IOException;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangtuo
 */
public class CarbonRestTemplate implements CarbonClient {

  private static final Logger logger = LoggerFactory.getLogger(CarbonRestTemplate.class);

  private final CarbonOption option;
  private final CarbonSerializer serializer;
  private final RestTemplate restTemplate;
  private final CarbonDataChannel channel;

  public CarbonRestTemplate(CarbonOption option, CarbonSerializer serializer,
      RestTemplate restTemplate, CarbonDataChannel channel) {
    this.option = option;
    this.serializer = serializer;
    this.restTemplate = restTemplate;
    this.channel = channel;
  }

  private void send(CarbonMessageType type, Object request) throws IOException {
    if (logger.isDebugEnabled()) {
      logger.debug("request: {}", serializer.serialize(request));
    }

    CarbonEncryptedRequest encryptedRequest = channel.encodeRequest(type, request);

    URI target = option.getEndpoint();
    String body = serializer.serialize(encryptedRequest);

    RequestEntity<String> requestEntity = RequestEntity.post(target)
        .contentType(MediaType.APPLICATION_JSON)
        .body(body);

    ResponseEntity<String> encryptedResponse = restTemplate.exchange(requestEntity, String.class);
    if (encryptedResponse.getStatusCode().is2xxSuccessful()) {
      CarbonEncryptedResponse result = serializer.deserialize(encryptedResponse.getBody(),
          CarbonEncryptedResponse.class);
      CarbonResponse res = channel.decodeResponse(result, CarbonResponse.class);
      if (logger.isDebugEnabled()) {
        logger.debug("response: {}", serializer.serialize(res));
      }
      if (!res.isSuccess()) {
        throw new CarbonMessageException(res.getMessage());
      }
    } else {
      logger.error("request failed: {}, response: {}", encryptedResponse.getStatusCode(),
          encryptedResponse);
      throw new IOException("request failed: " + encryptedResponse.getStatusCode());
    }
  }

  @Override
  public void publish(CarbonPolicy policy) throws IOException {
    send(CarbonMessageType.UNDERWRITE, policy);
  }

  @Override
  public void publish(CarbonReceipt receipt) throws IOException {
    send(CarbonMessageType.RECEIPT, receipt);
  }

  @Override
  public void publish(CarbonRtnCall rtnCall) throws IOException {
    send(CarbonMessageType.RTN_CALL, rtnCall);
  }

  @Override
  public void publish(CarbonStatusChanged status) throws IOException {
    send(CarbonMessageType.STATUS, status);
  }
}
