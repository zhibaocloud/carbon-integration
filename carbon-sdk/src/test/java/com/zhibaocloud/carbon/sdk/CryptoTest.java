/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhbiaocloud.carbon.crypto.Crypto;
import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoFactory;
import com.zhbiaocloud.carbon.crypto.CryptoMode;
import org.junit.jupiter.api.Test;

class CryptoTest {

  private final CryptoFactory factory = new CryptoFactory();

  @Test
  void testSymmetricCrypto() {
    for (CryptoMode mode : CryptoMode.values()) {
      CryptoConfiguration config = new CryptoConfiguration();
      config.setEncryptMode(mode);
      config.setSecret("g9wuZX5rQKqin9qA");
      config.setIv("dyRnJ6bVxWTdHd64");

      Crypto crypto = factory.create(config);
      String origin = """
          Lorem Ipsum is simply dummy text of the printing and typesetting industry.
          Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
          when an unknown printer took a galley of type and scrambled it to make a type specimen book.
          It has survived not only five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged. It was popularised in the 1960s with the release of
          Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing
          software like Aldus PageMaker including versions of Lorem Ipsum.""";

      String cipher = crypto.encrypt(origin);
      String plain = crypto.decrypt(cipher);
      assertThat(plain).isEqualTo(origin);
    }
  }
}
