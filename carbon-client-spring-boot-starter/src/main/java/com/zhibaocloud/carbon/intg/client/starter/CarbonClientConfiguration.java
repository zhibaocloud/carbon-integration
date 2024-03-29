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

import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.client.CarbonClient;
import com.zhibaocloud.carbon.intg.client.CarbonClientFactory;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用于配置与智保云数据平台通信的客户端
 *
 * @author jun
 */
@Configuration
@EnableConfigurationProperties(CarbonClientProperties.class)
public class CarbonClientConfiguration {

  private final CarbonClientProperties config;

  public CarbonClientConfiguration(CarbonClientProperties config) {
    this.config = config;
  }

  @Bean
  @ConditionalOnClass(CloseableHttpClient.class)
  @ConditionalOnMissingBean(CloseableHttpClient.class)
  public CloseableHttpClient httpClient() {
    return HttpClients.createDefault();
  }

  @Bean
  public CryptoFactory cryptoFactory() {
    return new CryptoFactory();
  }


  @Bean
  public CarbonClientFactory clientFactory(
      CloseableHttpClient httpClient,
      CryptoFactory crypto,
      CarbonSerializerFactory sf
  ) {
    return new CarbonClientFactory(httpClient, sf, crypto);
  }

  @Bean("carbon-client")
  @ConditionalOnProperty(prefix = "carbon.client", name = "enabled", havingValue = "true")
  public CarbonClient create(CarbonClientFactory factory) {
    CarbonOption option = new CarbonOption();
    option.setEndpoint(config.getEndpoint());
    option.setTenant(config.getTenant());
    option.setCrypto(config.getCrypto());
    option.setSerialization(config.getSerialization());
    return factory.create(option);
  }
}
