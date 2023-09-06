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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 交费期间单位
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonPaymentPeriodUnit {
  /**
   * 交费期间
   */
  Y("交费年数"),
  M("交费月数"),
  D("交费天数"),
  A("交至年龄数"),
  // 一次性交清
  S("趸交");

  private final String description;
}
