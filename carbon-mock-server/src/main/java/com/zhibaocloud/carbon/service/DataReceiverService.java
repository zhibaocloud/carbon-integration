/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoAlg;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.model.EncryptedRequest;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhibaocloud.carbon.domain.Agreement;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataReceiverService {

  private final ApplicationEventPublisher publisher;

  private final CryptoFactory factory;

  private final ObjectMapper mapper;

  public void process(
      Agreement agreement,
      String type,
      EncryptedRequest request
  ) throws IOException {
    String secret = agreement.getSecret();
    String salt = agreement.getSalt();

    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret(secret);
    config.setDigestSalt(salt);

    Crypto crypto = factory.create(config);
    String payload = crypto.decrypt(request.getPayload());
    Policy policy = mapper.readValue(payload, Policy.class);

    publisher.publishEvent(request);
  }
}
