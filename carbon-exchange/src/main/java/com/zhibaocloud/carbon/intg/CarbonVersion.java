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

package com.zhibaocloud.carbon.intg;


/**
 * SDK版本，用于区分服务器端、客户端是否使用兼容版本SDK 使用 semver 的方式判断是否兼容
 * <p>
 * TODO: 将版本信息通过 Maven 生成
 *
 * @author jun
 */
public class CarbonVersion {

  public static final CarbonVersion CURRENT = new CarbonVersion();
  /**
   * 主版本，如有不兼容更新会增加版本号
   */
  private int major = 1;
  /**
   * 新功能版本，兼容MAJOR
   */
  private int minor = 3;
  /**
   * 问题修正版本
   */
  private int patch = 0;

  public int getMajor() {
    return major;
  }

  public void setMajor(int major) {
    this.major = major;
  }

  public int getMinor() {
    return minor;
  }

  public void setMinor(int minor) {
    this.minor = minor;
  }

  public int getPatch() {
    return patch;
  }

  public void setPatch(int patch) {
    this.patch = patch;
  }

  private CarbonVersion() {
  }


  public CarbonVersion(String version) {
    String[] parts = version.split("\\.");
    if (parts.length != 3) {
      throw new IllegalArgumentException("无效的版本号: " + version);
    }
    this.major = Integer.parseInt(parts[0]);
    this.minor = Integer.parseInt(parts[1]);
    this.patch = Integer.parseInt(parts[2]);
  }

  public boolean isCompatible(CarbonVersion version) {
    // 大版本不匹配
    if (major != version.major) {
      return false;
    }
    // 小版本，有兼容新功能
    return minor >= version.minor;
  }


  @Override
  public String toString() {
    return major + "." + minor + "." + patch;
  }
}
