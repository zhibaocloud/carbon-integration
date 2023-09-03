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

package com.zhibaocloud.carbon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import com.zhibaocloud.carbon.server.sdk.CarbonMessageListener;
import com.zhibaocloud.carbon.server.sdk.CarbonMessageMeta;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 将收到的数据打印到控制台，需要由数据接入方实现 CarbonMessageListener 接口
 *
 * @author jun
 */
@Slf4j
@Component
public class ConsoleMessageListener implements CarbonMessageListener {

  private final ObjectMapper mapper;

  public ConsoleMessageListener(CarbonMapperFactory factory) {
    this.mapper = factory.create().copy();
    this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
  }

  @Override
  public void on(Policy event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received policy: {}", json);
  }

  @Override
  public void on(Receipt event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received receipt: {}", json);
  }

  @Override
  public void on(RtnCall event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("received return call: {}", json);
  }

  @Override
  public void on(StatusChanged event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.writeValueAsString(event);
    log.info("status changed: {}", json);
  }
}
