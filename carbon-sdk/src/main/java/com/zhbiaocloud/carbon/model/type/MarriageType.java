/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 婚姻状况
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum MarriageType implements EncodedValue {

  /**
   * 婚姻状况代码
   */
  UNMARRIED("10", "未婚"),
  MARRIED("20", "已婚"),
  WIDOWED("30", "丧偶"),
  DIVORCED("40", "离婚"),
  OTHER("90", "未说明的婚姻状况");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
