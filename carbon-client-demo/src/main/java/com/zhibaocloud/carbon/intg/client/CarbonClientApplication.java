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

package com.zhibaocloud.carbon.intg.client;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.client.starter.CarbonClientProperties;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import java.io.IOException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 命令行测试工具，向 Mock Server 发送推送数据，验证数据的有效性
 *
 * @author jun
 */
@Component
@SpringBootApplication
@RequiredArgsConstructor
public class CarbonClientApplication implements ApplicationRunner {

  private final CarbonClient client;

  private final CarbonClientFactory factory;

  private final CarbonClientProperties config;

  public static void main(String[] args) {
    SpringApplication.run(CarbonClientApplication.class, args);
  }

  /**
   * 单用户模式，根据配置文件创建 SDK 对象
   */
  private void runClient() throws IOException {
    client.publish(JMockData.mock(CarbonPolicy.class));
    client.publish(JMockData.mock(CarbonReceipt.class));
    client.publish(JMockData.mock(CarbonRtnCall.class));
    client.publish(JMockData.mock(CarbonStatusChanged.class));
  }

  /**
   * 多租户模式，根据租户标识符创建不同的 SDK 对象。
   */
  private void runInSaaS() throws IOException {
    // 模拟租户标识符
    String tenant = UUID.randomUUID().toString();
    CarbonOption option = new CarbonOption();
    option.setEndpoint(config.getEndpoint());
    option.setCrypto(config.getCrypto());
    option.setTenant(tenant);
    // 根据租户配置返回不同的 CarbonClient。 可配置内容包括: 是否脱敏，加解密方式，密钥等
    CarbonClient c = factory.create(option);

    c.publish(JMockData.mock(CarbonPolicy.class));
    c.publish(JMockData.mock(CarbonReceipt.class));
    c.publish(JMockData.mock(CarbonRtnCall.class));
    c.publish(JMockData.mock(CarbonStatusChanged.class));
  }

  @Override
  public void run(ApplicationArguments args) throws IOException {
    runClient();
    runInSaaS();
  }
}
