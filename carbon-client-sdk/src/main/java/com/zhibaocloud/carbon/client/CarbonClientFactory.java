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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhibaocloud.carbon.client.impl.CarbonClientImpl;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 构建与智保云投保通道推送数据的SDK。 其中 CloseableHttpClient 有连接池的实现，通过外部次构造函数传入，以便复用。
 *
 * @author jun
 */
@RequiredArgsConstructor
public class CarbonClientFactory {

  /**
   * 序列化规则，有可能序列化的方式和应用程序默认的不一致，可以单独进行定义
   */
  private final ObjectMapper mapper;

  /**
   * 与智保云投保通道的HTTP通信客户端
   */
  private final CloseableHttpClient client;

  /**
   * 加解密算法工具
   */
  private final CryptoFactory factory;

  /**
   * 为每一个中介公司推送创建一个客户端。其他配置为系统级配置，可以进行复用
   *
   * @param option 中介公司相关配置
   * @return 客户端
   */
  public CarbonClient create(ClientOption option) {
    Crypto crypto = factory.create(option.getCrypto());
    return new CarbonClientImpl(mapper, client, crypto, option);
  }
}
