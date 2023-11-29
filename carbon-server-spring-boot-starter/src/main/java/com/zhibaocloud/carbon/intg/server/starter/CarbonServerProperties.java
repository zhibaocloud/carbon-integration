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

package com.zhibaocloud.carbon.intg.server.starter;


import com.zhibaocloud.carbon.intg.crypto.CryptoConfiguration;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "carbon.server")
public class CarbonServerProperties {

  /**
   * 是否启用 Server Bean 注入
   */
  private Boolean enabled = true;

  /**
   * 加解密配置信息
   */
  private CryptoConfiguration crypto = new CryptoConfiguration();

  /**
   * 序列化配置信息
   */
  private SerializationConfiguration serializer = new SerializationConfiguration();


  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public CryptoConfiguration getCrypto() {
    return crypto;
  }

  public void setCrypto(CryptoConfiguration crypto) {
    this.crypto = crypto;
  }

  public SerializationConfiguration getSerializer() {
    return serializer;
  }

  public void setSerializer(SerializationConfiguration serializer) {
    this.serializer = serializer;
  }

  public CarbonServerProperties() {
  }

  public CarbonServerProperties(Boolean enabled, CryptoConfiguration crypto, SerializationConfiguration serializer) {
    this.enabled = enabled;
    this.crypto = crypto;
    this.serializer = serializer;
  }
}
