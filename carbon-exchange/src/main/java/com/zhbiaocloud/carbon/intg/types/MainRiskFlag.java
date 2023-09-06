/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhbiaocloud.carbon.intg.types;

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