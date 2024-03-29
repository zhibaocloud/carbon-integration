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

package com.zhibaocloud.carbon.intg.server.starter;

import com.zhibaocloud.carbon.intg.CarbonOption;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CryptoFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.server.sdk.CarbonMessageListener;
import com.zhibaocloud.carbon.intg.server.sdk.CarbonMessageProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 服务端，支持数据推送
 *
 * @author jun
 */
@Configuration
@EnableConfigurationProperties(CarbonServerProperties.class)
public class CarbonServerConfiguration {

  private final CarbonServerProperties config;

  public CarbonServerConfiguration(CarbonServerProperties config) {
    this.config = config;
  }

  @Bean
  public CryptoFactory cryptoFactory() {
    return new CryptoFactory();
  }


  /**
   * 将解析后的数据发送给 MessageListener 并触发实际的业务逻辑
   *
   * @param listener 当收到数据后回调 listener 的 on 方法，需要应用程序开发方实现该接口
   * @param sf       针对不同的环境，确定不同的反序列化策略
   * @param cf       获取加解密算法
   * @return 注入到 controller 层，处理收到的数据
   */
  @Bean
  @ConditionalOnBean(CarbonMessageListener.class)
  public CarbonMessageProcessor messageProcessor(
      CarbonMessageListener listener,
      CarbonSerializerFactory sf,
      CryptoFactory cf
  ) {
    CarbonOption option = new CarbonOption();
    option.setCrypto(config.getCrypto());
    CarbonDataChannel channel = new CarbonDataChannel(
        sf.create(config.getSerializer()),
        cf.create(config.getCrypto()),
        option
    );
    return new CarbonMessageProcessor(channel, listener);
  }
}
