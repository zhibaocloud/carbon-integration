/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhibaocloud.carbon;

import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhbiaocloud.carbon.crypto.HashAlg;
import com.zhbiaocloud.carbon.crypto.SymmetricCrypto;
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
    demo.setSymmetricAlg(SymmetricCrypto.AES_CBC_PKCS5PADDING);
    demo.setSecret("4XgD98eGyMDejLvA");
    demo.setIv("ER2gveZeqYYfj6j8");
    demo.setDigestAlg(HashAlg.SHA256);
    demo.setDigestSalt("LXqF4UX4CiAa9mpm");
    return demo;
  }
}
