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
 * 受益人顺位
 *
 * @author jun
 */
public enum CarbonBnfGrade implements EncodedValue {
  /**
   * 第一受益人
   */
  GRADE_1("1", "第一受益人"),

  /**
   * 第二受益人
   */
  GRADE_2("2", "第二受益人"),

  /**
   * 第三受益人
   */
  GRADE_3("3", "第三受益人"),

  /**
   * 第四受益人
   */
  GRADE_4("4", "第四受益人"),

  /**
   * 第五受益人
   */
  GRADE_5("5", "第五受益人");


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

  CarbonBnfGrade(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
