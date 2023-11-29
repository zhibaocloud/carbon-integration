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

package com.zhibaocloud.carbon.intg.client.starter;

import com.zhibaocloud.carbon.intg.crypto.CryptoConfiguration;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.net.URI;
import org.springframework.boot.context.properties.ConfigurationProperties;

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

  /**
   * 序列化配置信息
   */
  private SerializationConfiguration serialization = new SerializationConfiguration();

  public CarbonClientProperties() {
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public URI getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(URI endpoint) {
    this.endpoint = endpoint;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public CryptoConfiguration getCrypto() {
    return crypto;
  }

  public void setCrypto(CryptoConfiguration crypto) {
    this.crypto = crypto;
  }

  public SerializationConfiguration getSerialization() {
    return serialization;
  }

  public void setSerialization(SerializationConfiguration serialization) {
    this.serialization = serialization;
  }
}
