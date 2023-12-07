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
 * 交费期间单位
 *
 * @author jun
 */
public enum CarbonPaymentPeriodUnit {

  /**
   * 交费年数
   */
  Y("交费年数"),
  /**
   * 交费月数
   */
  M("交费月数"),
  /**
   * 交费天数
   */
  D("交费天数"),
  /**
   * 交至年龄数
   */
  A("交至年龄数"),
  /**
   * 趸交
   */
  S("趸交");

  private final String description;

  public String getDescription() {
    return description;
  }

  CarbonPaymentPeriodUnit(String description) {
    this.description = description;
  }
}
