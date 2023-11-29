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
 * 人员关系: 保单各人员之间的关系 包括投保人与被保人，被保人与受益人等关系
 *
 * @author jun
 */
public enum CarbonRelationType implements EncodedValue {

  /**
   * 本人
   */
  SELF("00", "本人"),
  /**
   * 配偶
   */
  SPOUSE("01", "配偶"),
  /**
   * 父母
   */
  PARENT("02", "父母"),
  /**
   * 子女
   */
  CHILD("03", "子女"),
  /**
   * 兄弟姐妹
   */
  SIBLING("05", "兄弟姐妹"),
  /**
   * 雇主
   */
  EMPLOYER("06", "雇主"),
  /**
   * 雇员
   */
  EMPLOYEE("07", "雇员"),
  /**
   * 祖父母、外祖父母
   */
  GRANDPARENT("08", "祖父母、外祖父母"),
  /**
   * 祖孙、外祖孙
   */
  GRANDCHILD("09", "祖孙、外祖孙"),
  /**
   * 监护人
   */
  GUARDIAN("10", "监护人"),
  /**
   * 被监护人
   */
  PROTECTOR("11", "被监护人"),
  /**
   * 朋友
   */
  FRIEND("12", "朋友"),
  /**
   * 未知
   */
  UNKNOWN("98", "未知"),
  /**
   * 其他
   */
  OTHER("99", "其他");

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

  CarbonRelationType(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
