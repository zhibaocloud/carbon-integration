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

package com.zhibaocloud.carbon.intg.server;

import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.server.sdk.CarbonMessageListener;
import com.zhibaocloud.carbon.intg.server.sdk.CarbonMessageMeta;
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

  private final CarbonSerializer mapper;

  public ConsoleMessageListener(CarbonSerializerFactory factory) {
//    this.mapper = factory.create().copy();
//    this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
    this.mapper = factory.create();
  }

  /**
   * 处理收到的承保数据
   *
   * @param event 承保数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 数据解析处理失败
   */
  @Override
  public void on(CarbonPolicy event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.serialize(event);
    log.info("received policy: {}", json);
  }

  /**
   * 处理收到的回执数据
   *
   * @param event 回执数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 数据解析处理失败
   */
  @Override
  public void on(CarbonReceipt event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.serialize(event);
    log.info("received receipt: {}", json);
  }

  /**
   * 处理收到的回访数据
   *
   * @param event 回访数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 数据解析处理失败
   */
  @Override
  public void on(CarbonRtnCall event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.serialize(event);
    log.info("received return call: {}", json);
  }

  /**
   * 处理收到的保单状态变化数据
   *
   * @param event 保单状态变化数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 数据解析处理失败
   */
  @Override
  public void on(CarbonStatusChanged event, CarbonMessageMeta meta) throws IOException {
    String json = mapper.serialize(event);
    log.info("status changed: {}", json);
  }
}
