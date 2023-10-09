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

package com.zhibaocloud.carbon.intg;

import com.zhibaocloud.carbon.intg.types.EncodedValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 数据推送类型
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonMessageType implements EncodedValue {

  /**
   * 承保保单数据
   */
  UNDERWRITE("underwrite", "承保保单数据"),

  /**
   * 回执数据
   */
  RECEIPT("receipt", "回执数据"),

  /**
   * 回访数据
   */
  RTN_CALL("rtnCall", "回访数据"),

  /**
   * 保单状态变化数据
   */
  STATUS("status", "保单状态变化数据");

  private final String value;

  private final String description;
}
