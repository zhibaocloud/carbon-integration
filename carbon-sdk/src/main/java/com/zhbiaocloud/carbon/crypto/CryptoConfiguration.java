/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import lombok.Getter;
import lombok.Setter;

/**
 * 加解密配置
 *
 * @author jun
 */
@Getter
@Setter
public class CryptoConfiguration {

  /**
   * 加密算法(对称加密)
   */
  private CryptoAlg encryptAlg = CryptoAlg.AES;

  /**
   * AES的加密模式，与合作方协商后确定
   */
  private String encryptionMode = "AES/CBC/PKCS5Padding";

  /**
   * 使用CBC时的需要额外提供IV向量
   */
  private String aesIv;

  /**
   * 使用 AES 加密时使用
   * AES 支持的key长度可以是 128, 192, 256 等
   * 但是在jdk1.8中如需支持 128 位以上的加密需要安装<a href="https://www.baeldung.com/jce-enable-unlimited-strength">JCE Unlimited Strength Policy</a>
   */
  private int aesKeyLength = 128;

  /**
   * 对称加密密钥
   * 用于AES和SM4加密使用
   */
  private String secret;

  /**
   * 散列算法
   */
  private String signAlg;

  /**
   * 散列加盐
   */
  private String signSalt;
}
