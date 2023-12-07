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
 * 保险期间单位
 *
 * @author jun
 */
public enum CarbonInsuredPeriodUnit {

  /**
   * 保险年数
   */
  Y("保险年数"),
  /**
   * 保险月数
   */
  M("保险月数"),
  /**
   * 保险周数
   */
  W("保险周数"),
  /**
   * 保险天数
   */
  D("保险天数"),
  /**
   * 保至年龄数
   */
  A("保至年龄数"),
  /**
   * 终身
   */
  O("终身"),
  /**
   * 无关
   */
  N("无关");

  /**
   * 码表文字描述
   */
  private final String description;

  public String getDescription() {
    return description;
  }

  CarbonInsuredPeriodUnit(String description) {
    this.description = description;
  }
}
