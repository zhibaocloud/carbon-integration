/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoAlg;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.CryptoMode;
import org.junit.jupiter.api.Test;

class CryptoTest {

  private final CryptoFactory factory = new CryptoFactory();

  @Test
  void aesCBCTest() {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setIv("dyRnJ6bVxWTdHd64");
    Crypto crypto = factory.create(config);

    String origin = "hello world";
    String cipher = crypto.encrypt(origin);
    String plain = crypto.decrypt(cipher);
    assertThat(plain).isEqualTo(origin);
  }

  @Test
  void aesECBTest() {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setEncryptMode(CryptoMode.AES_ECB_PKCS5Padding);
    Crypto crypto = factory.create(config);

    String origin = "hello world";
    String cipher = crypto.encrypt(origin);
    String plain = crypto.decrypt(cipher);
    assertThat(plain).isEqualTo(origin);
  }

  @Test
  void sm4ECBTest() {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setEncryptMode(CryptoMode.SM4_ECB_PKCS5Padding);
    config.setSecret("g9wuZX5rQKqin9qA");
    Crypto crypto = factory.create(config);

    String origin = "hello world";
    String cipher = crypto.encrypt(origin);
    String plain = crypto.decrypt(cipher);
    assertThat(plain).isEqualTo(origin);
  }
}
