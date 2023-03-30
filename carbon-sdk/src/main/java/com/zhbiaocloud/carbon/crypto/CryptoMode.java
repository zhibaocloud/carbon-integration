/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 对称加密套件
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CryptoMode {

  /**
   * 对称加密算法
   */
  AES_CBC_PKCS5Padding("AES/CBC/PKCS5Padding", "AES"),

  AES_ECB_PKCS5Padding("AES/ECB/PKCS5Padding", "AES"),

  SM4_ECB_PKCS5Padding("SM4/ECB/PKCS5Padding", "SM4"),

  SM4_ECB_NoPadding("SM4/ECB/NoPadding", "SM4"),

  SM4_CBC_PKCS5Padding("SM4/CBC/PKCS5Padding", "SM4"),

  SM4_CBC_NoPadding("SM4/CBC/NoPadding", "SM4");

  private final String algorithm;

  private final String category;
}
