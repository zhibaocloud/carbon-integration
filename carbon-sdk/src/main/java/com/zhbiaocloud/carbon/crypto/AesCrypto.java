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
 * 使用AES对通信数据加解密
 *
 * @author jun
 */
public class AesCrypto implements Crypto {

  private final Cipher encryptCipher;

  private final Cipher decryptCipher;

  @SneakyThrows
  public AesCrypto(CryptoConfiguration configuration) {
    byte[] secret = configuration.getSecret().getBytes();
    SecretKeySpec keySpec = new SecretKeySpec(secret, "AES");

    encryptCipher = Cipher.getInstance(configuration.getAesMode());
    decryptCipher = Cipher.getInstance(configuration.getAesMode());

    // 使用 CBC 时可以启用 IV
    String iv = configuration.getAesIv();
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
