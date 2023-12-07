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
 * 婚姻状况
 *
 * @author jun
 */
public enum CarbonMarriageType implements EncodedValue {

  /**
   * 未婚
   */
  UNMARRIED("10", "未婚"),
  /**
   * 已婚
   */
  MARRIED("20", "已婚"),
  /**
   * 丧偶
   */
  WIDOWED("30", "丧偶"),
  /**
   * 离婚
   */
  DIVORCED("40", "离婚"),
  /**
   * 未说明的婚姻状况
   */
  OTHER("90", "未说明的婚姻状况");

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

  CarbonMarriageType(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
