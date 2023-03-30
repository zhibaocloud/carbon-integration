/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhibaocloud.carbon.client.CarbonClientFactory;
import java.util.Arrays;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 用于配置与智保云投保通道通信的客户端
 *
 * @author jun
 */
@Configuration
public class CarbonClientConfiguration {

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
  public CarbonMapperFactory mapperFactory(Environment environment) {
    String[] profiles = environment.getActiveProfiles();
    boolean isProd = Arrays.asList(profiles).contains("production");
    return new CarbonMapperFactory(isProd);
  }

  @Bean
  public CarbonClientFactory clientFactory(
      CloseableHttpClient httpClient,
      CryptoFactory crypto,
      CarbonMapperFactory factory
  ) {
    ObjectMapper mapper = factory.create();
    return new CarbonClientFactory(mapper, httpClient, crypto);
  }
}
