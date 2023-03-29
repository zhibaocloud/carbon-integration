/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import lombok.RequiredArgsConstructor;

/**
 * 使用 SM4 进行加通信数据的加解密
 *
 * @author jun
 */
@RequiredArgsConstructor
public class Sm4Crypto implements Crypto {

  private final CryptoConfiguration configuration;

  @Override
  public String encrypt(String plain) {
    return null;
  }

  @Override
  public String decrypt(String cipher) {
    return null;
  }
}
