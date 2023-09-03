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
    String appId = DemoConfiguration.appId();
    option.setEndpoint(new URI("http://localhost:8080/v2/callbacks/a/" + appId));
    option.setCrypto(DemoConfiguration.crypto());

    CarbonClient client = factory.create(option);
    Policy policy = JMockData.mock(Policy.class);
    client.publish(policy);

    Receipt receipt = JMockData.mock(Receipt.class);
    client.publish(receipt);

    RtnCall rtnCall = JMockData.mock(RtnCall.class);
    client.publish(rtnCall);
  }
}
