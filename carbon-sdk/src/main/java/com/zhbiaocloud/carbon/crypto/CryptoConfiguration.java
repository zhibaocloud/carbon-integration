/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoConfiguration {

  private String encryptAlg;

  private String encryptSecret;

  private String signAlg;

  private String signSalt;
}
