/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

/**
 * 加密工厂，根据配置返回不同的加解密工具
 *
 * @author jun
 */
public class CryptoFactory {

  public static Crypto create(CryptoConfiguration config) {
    CryptoAlg alg = config.getEncryptAlg();
    return switch (alg) {
      case AES -> new AesCrypto(config);
      case SM4 -> new Sm4Crypto(config);
    };
  }
}
