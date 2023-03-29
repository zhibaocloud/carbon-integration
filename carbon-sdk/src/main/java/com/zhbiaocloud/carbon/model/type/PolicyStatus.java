/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 保单/险种状态
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum PolicyStatus implements EncodedValue {

  /**
   * 默认承保保单的状态都是有效的
   */
  VALID("01", "有效"),

  SUSPENDED("02", "中止"),

  TERMINATED("03", "终止"),

  INEFFECTIVE("04", "未生效"),

  OTHER("99", "其他");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
