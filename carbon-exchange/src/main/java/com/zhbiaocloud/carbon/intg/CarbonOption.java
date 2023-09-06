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

package com.zhbiaocloud.carbon.intg;

import com.zhbiaocloud.carbon.intg.crypto.CryptoConfiguration;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;

/**
 * 用于指定和智保云数据平台的连接参数
 *
 * @author jun
 */
@Getter
@Setter
public class CarbonOption {

  /**
   * 服务地址，用于区分测试环境、预发布环境和生产环境
   */
  private URI endpoint;

  /**
   * 租户标识符。接收方可以根据每个租户的标识符，确定加解密方式
   */
  private String tenant;

  /**
   * 是否对数据进行脱敏处理
   * TODO: 根据配置获取不同的 ObjectMapper
   */
  private Boolean desensitize;

  /**
   * 对称加密配置
   */
  private CryptoConfiguration crypto = new CryptoConfiguration();
}