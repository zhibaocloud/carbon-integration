/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;

/**
 * 用于指定和智保云投保通道的连接参数
 *
 * @author jun
 */
@Getter
@Setter
public class ClientOption {

  /**
   * 服务地址，用于区分测试环境、预发布环境和生产环境
   */
  private URI endpoint;

  /**
   * 应用ID，每个中介公司对接时都会分配一个唯一的ID
   */
  private String appId;

  /**
   * 接入方式
   */
  private ClientMode mode = ClientMode.AGREEMENT;

  /**
   * 对称加密配置
   */
  private CryptoConfiguration crypto = new CryptoConfiguration();
}
