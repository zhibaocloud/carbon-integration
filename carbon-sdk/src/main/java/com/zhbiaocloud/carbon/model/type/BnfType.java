/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 受益人类型
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum BnfType implements EncodedValue {

  /**
   * 受益人类型
   */
  DEATH_BENEFICIARY("1", "身故受益人"),
  SURVIVAL_BENEFICIARY("2", "生存受益人"),
  BONUS_BENEFICIARY("3", "红利受益人（财）"),
  UNKNOWN("4", "未知");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
