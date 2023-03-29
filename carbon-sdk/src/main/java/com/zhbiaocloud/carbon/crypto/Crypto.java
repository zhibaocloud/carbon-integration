/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import lombok.RequiredArgsConstructor;

/**
 * 加解密方法
 *
 * @author jun
 */
@RequiredArgsConstructor
public class Crypto {

  private final CryptoConfiguration config;

  public String encrypt(String content) {
    return content;
  }

  public String decrypt(String cipher) {
    return cipher;
  }
}
