/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * 加密工厂，根据配置返回不同的加解密工具
 *
 * @author jun
 */
public class CryptoFactory {

  static {
    Security.addProvider(new BouncyCastleProvider());
  }

  public Crypto create(CryptoConfiguration config) {
    return new CarbonCrypto(config);
  }
}
