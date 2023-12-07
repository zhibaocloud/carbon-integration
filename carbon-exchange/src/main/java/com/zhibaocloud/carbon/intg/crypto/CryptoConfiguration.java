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
 * 使用 AES 加密时使用 AES 支持的key长度可以是 128, 192, 256 等 但是在jdk1.8中如需支持 128 位以上的加密需要安装
 * <a href="https://www.baeldung.com/jce-enable-unlimited-strength">JCE Unlimited Strength
 * Policy</a>
 *
 * @author jun
 */
public class CryptoConfiguration {

  /**
   * 加密算法，与合作方协商后确定
   */
  private SymmetricCrypto symmetricAlg = SymmetricCrypto.AES_CBC_PKCS5PADDING;

  /**
   * 对称加密密钥 用于AES和SM4加密使用
   */
  private String secret;

  /**
   * 使用CBC时的需要额外提供IV向量
   */
  private String iv;

  /**
   * 摘要算法
   */
  private HashAlg digestAlg = HashAlg.SHA256;

  /**
   * 摘要时使用的加盐，避免相同数据的签名摘要相同，避免Hash碰撞
   */
  private String salt;

  public SymmetricCrypto getSymmetricAlg() {
    return symmetricAlg;
  }

  public void setSymmetricAlg(SymmetricCrypto symmetricAlg) {
    this.symmetricAlg = symmetricAlg;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getIv() {
    return iv;
  }

  public void setIv(String iv) {
    this.iv = iv;
  }

  public HashAlg getDigestAlg() {
    return digestAlg;
  }

  public void setDigestAlg(HashAlg digestAlg) {
    this.digestAlg = digestAlg;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }
}
