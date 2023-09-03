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

import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.SneakyThrows;

/**
 * 加解密套件
 *
 * @author jun
 */
class CarbonCrypto implements Crypto {

  private final Cipher encryptCipher;

  private final Cipher decryptCipher;

  private final MessageDigest digester;

  private final String salt;

  @SneakyThrows
  CarbonCrypto(CryptoConfiguration config) {
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
  }

  @SneakyThrows
  @Override
  public String encrypt(String plain) {
    byte[] raw = plain.getBytes();
    byte[] cipher = encryptCipher.doFinal(raw);
    return Base64.getEncoder().encodeToString(cipher);
  }

  @SneakyThrows
  @Override
  public String decrypt(String cipher) {
    byte[] raw = Base64.getDecoder().decode(cipher);
    return new String(decryptCipher.doFinal(raw));
  }

  @Override
  public String digest(String payload) {
    byte[] raw = (payload + this.salt).getBytes();
    byte[] digest = this.digester.digest(raw);
    return Base64.getEncoder().encodeToString(digest);
  }
}
