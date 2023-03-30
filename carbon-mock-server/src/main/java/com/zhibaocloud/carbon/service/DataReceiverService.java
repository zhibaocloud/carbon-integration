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

package com.zhibaocloud.carbon.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonChannel;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.domain.SaaSAgreement;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * 解析数据，并推送至事件总线
 *
 * @author jun
 */
@Service
public class DataReceiverService {

  private final ApplicationEventPublisher publisher;

  private final CryptoFactory factory;

  private final ObjectMapper mapper;

  public DataReceiverService(
      ApplicationEventPublisher publisher,
      CarbonMapperFactory mapperFactory,
      CryptoFactory factory
  ) {
    this.publisher = publisher;
    this.mapper = mapperFactory.create();
    this.factory = factory;
  }

  public EncryptedResponse process(Agreement agreement, EncryptedRequest request, String type) {
    CryptoConfiguration config = agreement.getConfig();
    Crypto crypto = factory.create(config);
    CarbonChannel channel = new CarbonChannel(mapper, crypto);

    switch (type) {
      case "underwrite":
        Policy policy = channel.decodeRequest(request, Policy.class);
        publisher.publishEvent(policy);
        break;
      case "receipt":
        Receipt receipt = channel.decodeRequest(request, Receipt.class);
        publisher.publishEvent(receipt);
        break;
      case "rtncall":
        RtnCall rtnCall = channel.decodeRequest(request, RtnCall.class);
        publisher.publishEvent(rtnCall);
        break;
      default:
        throw new IllegalArgumentException("不支持的类型：" + type);
    }
    CarbonResponse response = new CarbonResponse();
    response.setSuccess(true);
    response.setMessage("OK");
    return channel.encodeResponse(request.getRequestId(), response);
  }

  public EncryptedResponse process(SaaSAgreement saas, EncryptedRequest request, String type) {
    // TODO:
    throw new UnsupportedOperationException("暂不支持");
  }
}
