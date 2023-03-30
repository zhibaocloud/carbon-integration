/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.demo;

import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.CryptoMode;
import com.zhbiaocloud.carbon.crypto.HashAlg;
import java.util.UUID;

/**
 * 演示数据，确保客户端和服务端使用配套的密钥
 *
 * @author jun
 */
public class DemoConfiguration {

  private DemoConfiguration() {
  }

  public static String appId() {
    return UUID.fromString("fd3c35de-ca5f-4442-87aa-17edc67f93d0").toString();
  }

  public static CryptoConfiguration crypto() {
    CryptoConfiguration demo = new CryptoConfiguration();
    demo.setEncryptMode(CryptoMode.AES_CBC_PKCS5PADDING);
    demo.setSecret("4XgD98eGyMDejLvA");
    demo.setIv("ER2gveZeqYYfj6j8");
    demo.setDigestAlg(HashAlg.SHA256);
    demo.setDigestSalt("LXqF4UX4CiAa9mpm");
    return demo;
  }
}
