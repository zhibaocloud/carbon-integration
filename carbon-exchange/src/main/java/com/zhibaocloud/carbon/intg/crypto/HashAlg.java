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
 * 数据摘要，用于校验数据完整性
 *
 * @author jun
 */
public enum HashAlg {

  /**
   * SHA-256 算法
   */
  SHA256("SHA-256"),

  /**
   * SHA-512 算法
   */
  SHA512("SHA-512"),

  /**
   * MD5 算法
   */
  MD5("MD5"),

  /**
   * SM3 算法
   */
  SM3("SM3"),

  /**
   * SHA3-256 算法
   */
  SHA3("SHA3-256"),

  /**
   * SHA3-512 算法
   */
  SHA3_512("SHA3-512");

  private final String alg;

  public String getAlg() {
    return alg;
  }

  HashAlg(String alg) {
    this.alg = alg;
  }
}
