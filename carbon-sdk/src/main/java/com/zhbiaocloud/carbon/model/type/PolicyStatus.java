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
