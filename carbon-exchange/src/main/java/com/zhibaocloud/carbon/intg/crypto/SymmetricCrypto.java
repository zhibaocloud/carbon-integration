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

package com.zhibaocloud.carbon.intg.crypto;

/**
 * 对称加密套件
 *
 * @author jun
 */
public enum SymmetricCrypto {

  /**
   * AES 算法，CBC 模式，PKCS5Padding 填充
   */
  AES_CBC_PKCS5PADDING("AES", "CBC", "PKCS5Padding"),

  /**
   * AES 算法，ECB 模式，PKCS5Padding 填充
   */
  AES_ECB_PKCS5PADDING("AES", "ECB", "PKCS5Padding"),

  /**
   * SM4 算法，ECB 模式，PKCS5Padding 填充
   */
  SM4_ECB_PKCS5PADDING("SM4", "ECB", "PKCS5Padding"),

  /**
   * SM4 算法，CBC 模式，PKCS5Padding 填充
   */
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

  public String getAlgorithm() {
    return algorithm;
  }

  public String getMode() {
    return mode;
  }

  public String getPadding() {
    return padding;
  }

  SymmetricCrypto(String algorithm, String mode, String padding) {
    this.algorithm = algorithm;
    this.mode = mode;
    this.padding = padding;
  }
}
