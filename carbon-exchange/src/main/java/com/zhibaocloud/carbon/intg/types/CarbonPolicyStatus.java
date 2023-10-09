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

package com.zhibaocloud.carbon.intg.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 保单/险种状态
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonPolicyStatus implements EncodedValue {

  /**
   * 有效
   */
  VALID("01", "有效"),
  /**
   * 中止
   */
  SUSPENDED("02", "中止"),
  /**
   * 终止
   */
  TERMINATED("03", "终止"),
  /**
   * 未生效
   */
  INEFFECTIVE("04", "未生效"),
  /**
   * 其他
   */
  OTHER("99", "其他");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  /**
   * 码表文字描述
   */
  private final String description;
}
