/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.server;

import com.zhbiaocloud.carbon.CarbonMapperFactory;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CarbonServerConfiguration {
  
  @Bean
  public CarbonMapperFactory mapperFactory(Environment environment) {
    String[] profiles = environment.getActiveProfiles();
    boolean isProd = Arrays.asList(profiles).contains("production");
    return new CarbonMapperFactory(isProd);
  }
}
