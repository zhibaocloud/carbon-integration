/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 交费期间单位
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum PaymentPeriodUnit {
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
