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

package com.zhibaocloud.carbon.intg.client.starter;

import com.zhbiaocloud.carbon.intg.crypto.CryptoConfiguration;
import java.net.URI;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "carbon.client")
public class CarbonClientProperties {

  /**
   * 是否启用 Client 注入
   */
  private Boolean enabled = true;

  /**
   * 数据推送地址
   */
  private URI endpoint;

  /**
   * 租户信息
   */
  private String tenant;

  /**
   * 加解密配置信息
   */
  private CryptoConfiguration crypto = new CryptoConfiguration();
}
