/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 是否有社保标记
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum SocialSecurityFlag implements EncodedValue {
  /**
   * Y,是 N,否
   */
  YES("Y", "是"),
  NO("N", "否");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
