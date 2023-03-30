/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import com.github.jsonzou.jmockdata.JMockData;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhibaocloud.carbon.demo.DemoConfiguration;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 启动后直接发送数据到 Mock Server
 *
 * @author jun
 */
@Component
@RequiredArgsConstructor
public class CarbonClientRunner implements ApplicationRunner {

  private final CarbonClientFactory factory;

  @Override
  public void run(ApplicationArguments args) throws IOException, URISyntaxException {
    ClientOption option = new ClientOption();
    option.setEndpoint(new URI("http://localhost:8080"));
    option.setAppId(DemoConfiguration.appId());
    option.setCrypto(DemoConfiguration.crypto());

    CarbonClient client = factory.create(option);
    Policy policy = JMockData.mock(Policy.class);
    client.publish(policy);
  }
}
