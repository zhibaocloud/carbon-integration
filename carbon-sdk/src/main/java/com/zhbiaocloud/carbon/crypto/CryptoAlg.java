/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

/**
 * 加密算法
 *
 * @author jun
 */
public enum CryptoAlg {
  /**
   * 使用 AES 进行加解密，默认128位
   */
  AES,

  /**
   * 使用国密进行加解密
   */
  SM4
}
