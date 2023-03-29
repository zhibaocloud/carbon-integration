/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 主附险性质代码
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum MainRiskFlag implements EncodedValue {

  /**
   * 仅支持一个主险
   */
  MAIN("1", "主险"),

  ADDITIONAL("2", "附加险"),

  UNRELATED("3", "不区分");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
