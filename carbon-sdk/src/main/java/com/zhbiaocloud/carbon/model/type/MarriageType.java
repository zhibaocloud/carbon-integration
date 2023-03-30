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
