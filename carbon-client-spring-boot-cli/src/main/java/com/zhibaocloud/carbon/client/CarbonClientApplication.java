/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 命令行测试工具，向 Mock Server 发送推送数据，验证数据的有效性
 *
 * @author jun
 */
@SpringBootApplication
public class CarbonClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarbonClientApplication.class, args);
  }
}
