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

package com.zhibaocloud.carbon.intg.types;


/**
 * 是否有社保标记
 *
 * @author jun
 */
public enum CarbonSocialSecurityFlag implements EncodedValue {

  /**
   * 有社保
   */
  YES("Y", "是"),

  /**
   * 无社保
   */
  NO("N", "否");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  /**
   * 码表文字描述
   */
  private final String description;

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  CarbonSocialSecurityFlag(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
