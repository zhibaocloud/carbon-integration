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
public enum BnfGrade implements EncodedValue {
  /**
   * 受益人类型
   */
  GRADE_1("1", "第一受益人"),
  GRADE_2("2", "第二受益人"),
  GRADE_3("3", "第三受益人"),
  GRADE_4("4", "第四受益人"),
  GRADE_5("5", "第五受益人");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;

}
