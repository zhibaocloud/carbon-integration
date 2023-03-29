/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhbiaocloud.carbon.crypto.AesCrypto;
import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import org.junit.jupiter.api.Test;

class AesCryptoTest {

  @Test
  void aesCBCTest() {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setAesIv("dyRnJ6bVxWTdHd64");
    Crypto crypto = new AesCrypto(config);

    String origin = "hello world";
    String cipher = crypto.encrypt(origin);
    String plain = crypto.decrypt(cipher);
    assertThat(plain).isEqualTo(origin);
  }

  @Test
  void aesECBTest() {
    CryptoConfiguration config = new CryptoConfiguration();
    config.setSecret("g9wuZX5rQKqin9qA");
    config.setAesMode("AES/ECB/PKCS5Padding");
    Crypto crypto = new AesCrypto(config);

    String origin = "hello world";
    String cipher = crypto.encrypt(origin);
    String plain = crypto.decrypt(cipher);
    assertThat(plain).isEqualTo(origin);
  }
}
