/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zhibaocloud.carbon.client.impl.CarbonClientImpl;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 构建与智保云投保通道推送数据的SDK。 其中 CloseableHttpClient 有连接池的实现，通过外部次构造函数传入，以便复用。
 *
 * @author jun
 */
@RequiredArgsConstructor
public class CarbonClientFactory {

  /**
   * 序列化规则，有可能序列化的方式和应用程序默认的不一致，可以单独进行定义
   */
  private final ObjectMapper mapper;

  /**
   * 与智保云投保通道的HTTP通信客户端
   */
  private final CloseableHttpClient client;

  public CarbonClientFactory(CloseableHttpClient client) {
    ObjectMapper m = new ObjectMapper();
    m.registerModule(new JavaTimeModule());

    this.mapper = m;
    this.client = client;
  }

  /**
   * 为每一个中介公司推送创建一个客户端。其他配置为系统级配置，可以进行复用
   *
   * @param option 中介公司相关配置
   * @return 客户端
   */
  public CarbonClient create(ClientOption option) {
    return new CarbonClientImpl(option, mapper, client);
  }
}
