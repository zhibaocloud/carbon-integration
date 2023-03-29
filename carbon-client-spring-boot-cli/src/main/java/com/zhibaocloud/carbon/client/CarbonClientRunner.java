/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import java.io.IOException;
import java.util.UUID;
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
  public void run(ApplicationArguments args) throws IOException {
    String secret = "";
    String appId = UUID.randomUUID().toString();
    String salt = "";
    ClientOption option = new ClientOption();

    CarbonClient client = factory.create(option);

    client.publish(new Policy());
    client.publish(new Receipt());
    client.publish(new RtnCall());
  }
}
