/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

/**
 * 加解密方法
 *
 * @author jun
 */
public interface Crypto {

  /**
   * 对输入内容进行加密
   *
   * @param plain 明文
   * @return 密文
   */
  String encrypt(String plain);

  /**
   * 对收到的内容进行解密
   *
   * @param cipher 密文
   * @return 明文
   */
  String decrypt(String cipher);

  /**
   * 进行信息摘要计算
   *
   * @param payload 待计算的内容
   * @return 摘要
   */
  String digest(String payload);
}
