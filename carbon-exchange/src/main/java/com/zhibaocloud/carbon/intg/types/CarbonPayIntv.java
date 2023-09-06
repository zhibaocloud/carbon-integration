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
 * 交费间隔、交费频率
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonPayIntv implements EncodedValue {

  /**
   * 同一次性交清，交费年期为1年交
   */
  SINGLE("01", "趸交"),

  MONTHLY("02", "月交"),

  QUARTERLY("03", "季交"),

  HALF_YEARLY("04", "半年交"),

  YEARLY("05", "年交"),

  IRREGULAR("06", "不定期交费"),

  OTHER("99", "其他");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
