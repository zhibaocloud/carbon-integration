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
 * 保单终止原因
 *
 * @author jun
 */
public enum CarbonTerminationReason implements EncodedValue {

  /**
   * 满期终止
   */
  MA("01", "满期终止"),
  /**
   * 理赔终止
   */
  DT("02", "理赔终止"),
  /**
   * 退保终止
   */
  SU("03", "退保终止"),
  /**
   * 转换
   */
  TD("04", "转换"),
  /**
   * 公司解约
   */
  TC("05", "公司解约"),
  /**
   * 拒保终止
   */
  DC("06", "拒保终止"),
  /**
   * 保单迁出
   */
  TO("07", "保单迁出"),
  /**
   * 犹豫期退保
   */
  CF("08", "犹豫期退保"),
  /**
   * 当日撤单
   */
  WD("09", "当日撤单");

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

  CarbonTerminationReason(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
