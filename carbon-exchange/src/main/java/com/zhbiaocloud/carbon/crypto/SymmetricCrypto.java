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
public enum SymmetricCrypto {

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
