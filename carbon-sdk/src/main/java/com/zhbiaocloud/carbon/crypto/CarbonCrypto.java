/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
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
    SecretKeySpec keySpec = new SecretKeySpec(secret, config.getEncryptMode().getCategory());

    encryptCipher = Cipher.getInstance(config.getEncryptMode().getAlgorithm());
    decryptCipher = Cipher.getInstance(config.getEncryptMode().getAlgorithm());

    // 使用 CBC 时可以启用 IV
    String iv = config.getIv();
    if (iv != null) {
      IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
      encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
      decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
    } else {
      encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec);
      decryptCipher.init(Cipher.DECRYPT_MODE, keySpec);
    }

    digester = MessageDigest.getInstance(config.getDigestAlg().name());
    salt = config.getDigestSalt();
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
