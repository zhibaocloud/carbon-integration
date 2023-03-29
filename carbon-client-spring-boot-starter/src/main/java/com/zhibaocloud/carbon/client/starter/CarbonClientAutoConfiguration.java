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
public class CarbonClientAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(CloseableHttpClient.class)
  public CloseableHttpClient httpClient() {
    return HttpClients.createDefault();
  }

  @Bean
  public CarbonClientFactory factory(CloseableHttpClient httpClient, Environment environment) {
    CarbonMapperFactory factory = new CarbonMapperFactory();
    String[] profiles = environment.getActiveProfiles();
    boolean isProd = Arrays.asList(profiles).contains("production");
    ObjectMapper mapper = factory.create(isProd);
    return new CarbonClientFactory(mapper, httpClient);
  }

  @Bean
  public CryptoFactory factory() {
    return new CryptoFactory();
  }
}
