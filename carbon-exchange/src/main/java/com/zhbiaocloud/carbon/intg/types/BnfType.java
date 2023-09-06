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

package com.zhbiaocloud.carbon.intg.types;

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
