/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI文档生成
 *
 * @author jun
 */
@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .info(new Info().title("智保云 - 投保通道数据推送 Mock 接口")
            .contact(new Contact()
                .name("Wisefin")
                .url("https://zhibaocloud.com")
                .email("connect@wisefin.tech"))
            .description("投保通道数据推送API")
            .version("v0.0.1")
            .license(new License().name("智保云").url("https://zhibaocloud.com")));
  }
}
