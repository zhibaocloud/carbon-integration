/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhibaocloud.carbon.service.CarbonEventListener;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 将收到的数据打印到控制台
 *
 * @author jun
 */
@Slf4j
@Service
public class ConsoleLogDataProcessService implements CarbonEventListener {

  private final ObjectMapper mapper;

  public ConsoleLogDataProcessService(CarbonMapperFactory factory) {
    this.mapper = factory.create().copy();
    this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @Override
  public void onPolicyReceived(Policy event) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received policy: {}", json);
  }

  @Override
  public void onReceiptReceived(Receipt event) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received receipt: {}", json);
  }

  @Override
  public void onRtncallReceived(RtnCall event) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received return call: {}", json);
  }
}
