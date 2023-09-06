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

package com.zhbiaocloud.carbon.intg.crypto;

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
