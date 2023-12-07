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

import com.zhibaocloud.carbon.intg.CarbonException;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加解密套件
 *
 * @author jun
 */
class CarbonCrypto implements Crypto {

  /**
   * 对称加密加密器
   */
  private final Cipher encryptCipher;

  /**
   * 对称加密解密器
   */
  private final Cipher decryptCipher;

  /**
   * 摘要计算
   */
  private final MessageDigest digester;

  /**
   * 盐值
   */
  private final String salt;

  CarbonCrypto(CryptoConfiguration config) {
    try {
      byte[] secret = config.getSecret().getBytes();
      SymmetricCrypto symAlg = config.getSymmetricAlg();
      SecretKeySpec keySpec = new SecretKeySpec(secret, symAlg.getAlgorithm());

      encryptCipher = Cipher.getInstance(symAlg.getTransformation());
      decryptCipher = Cipher.getInstance(symAlg.getTransformation());

      if (symAlg.isIvRequired()) {
        String iv = config.getIv();
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
        encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
      } else {
        encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec);
        decryptCipher.init(Cipher.DECRYPT_MODE, keySpec);
      }

      digester = MessageDigest.getInstance(config.getDigestAlg().getAlg());
      salt = config.getSalt();
    } catch (Exception e) {
      throw new CarbonException(e);
    }
  }

  /**
   * 对明文数据进行加密
   *
   * @param plain 明文
   * @return 密文
   */
  @Override
  public String encrypt(String plain) {
    try {
      byte[] raw = plain.getBytes();
      byte[] cipher = encryptCipher.doFinal(raw);
      return Base64.getEncoder().encodeToString(cipher);
    } catch (Exception e) {
      throw new CarbonException(e);
    }
  }

  /**
   * 对密文数据进行解密
   *
   * @param cipher 密文
   * @return 明文
   */
  @Override
  public String decrypt(String cipher) {
    try {
      byte[] raw = Base64.getDecoder().decode(cipher);
      return new String(decryptCipher.doFinal(raw));
    } catch (Exception e) {
      throw new CarbonException(e);
    }
  }

  /**
   * 对数据进行摘要计算，验证数据是否损坏
   *
   * @param payload 待计算的内容
   * @return hash 值
   */
  @Override
  public String digest(String payload) {
    byte[] raw = (payload + this.salt).getBytes();
    byte[] digest = this.digester.digest(raw);
    return Base64.getEncoder().encodeToString(digest);
  }
}
