/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 性别代码
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum GenderType implements EncodedValue {

  /**
   * 性别代码
   */
  MALE("1", "男性"),
  FEMALE("2", "女性");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
