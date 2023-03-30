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
  AES_CBC_PKCS5PADDING("AES", "CBC", "PKCS5Padding"),

  AES_ECB_PKCS5PADDING("AES", "ECB", "PKCS5Padding"),

  SM4_ECB_PKCS5PADDING("SM4", "ECB", "PKCS5Padding"),

  SM4_CBC_PKCS5PADDING("SM4", "CBC", "PKCS5Padding");

  private final String algorithm;
  
  private final String mode;

  private final String padding;

  public boolean isIvRequired() {
    return "CBC".equals(this.mode);
  }

  public String getTransformation() {
    return algorithm + "/" + mode + "/" + padding;
  }
}
