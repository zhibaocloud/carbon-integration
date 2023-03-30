/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 保险期间单位
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum InsuredPeriodUnit {

  /**
   * 保险期间的单位
   */
  Y("保险年数"),
  M("保险月数"),
  W("保险周数"),
  D("保险天数"),
  A("保至年龄数"),
  O("终身"),
  N("无关");

  private final String description;
}
