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
