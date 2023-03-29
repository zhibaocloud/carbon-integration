/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.SneakyThrows;

/**
 * 使用 对称加密 对通信数据加解密
 *
 * @author jun
 */
class SymmetricCrypto implements Crypto {

  private final Cipher encryptCipher;

  private final Cipher decryptCipher;

  @SneakyThrows
  SymmetricCrypto(CryptoConfiguration config) {
    byte[] secret = config.getSecret().getBytes();
    SecretKeySpec keySpec = new SecretKeySpec(secret, config.getEncryptAlg().name());

    encryptCipher = Cipher.getInstance(config.getEncryptionMode(), "BC");
    decryptCipher = Cipher.getInstance(config.getEncryptionMode(), "BC");

    // 使用 CBC 时可以启用 IV
    String iv = config.getAesIv();
    if (iv != null) {
      IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());
      encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
      decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
    } else {
      encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec);
      decryptCipher.init(Cipher.DECRYPT_MODE, keySpec);
    }
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
}
