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

package com.zhibaocloud.carbon.client;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

  private final CarbonClientFactory factory;

  private static final String ENDPOINT = "http://localhost:8080/v2/callbacks/a/fd3c35de-ca5f-4442-87aa-17edc67f93d0";

  @Override
  public void run(ApplicationArguments args) throws IOException, URISyntaxException {
    ClientOption option = new ClientOption();
    option.setEndpoint(new URI(ENDPOINT));
    option.setCrypto(DemoConfiguration.crypto());

    CarbonClient client = factory.create(option);

    client.publish(JMockData.mock(Policy.class));
    client.publish(JMockData.mock(Receipt.class));
    client.publish(JMockData.mock(RtnCall.class));
    client.publish(JMockData.mock(StatusChanged.class));
  }

  public static void main(String[] args) {
    SpringApplication.run(CarbonClientApplication.class, args);
  }
}
