/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.infra;

import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarbonSdkConfiguration {

  @Bean
  public CryptoFactory factory() {
    return new CryptoFactory();
  }
}
