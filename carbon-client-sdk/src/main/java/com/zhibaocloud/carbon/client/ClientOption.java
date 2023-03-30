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
