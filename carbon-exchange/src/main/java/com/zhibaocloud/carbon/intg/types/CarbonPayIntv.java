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

/**
 * 交费间隔、交费频率
 *
 * @author jun
 */
public enum CarbonPayIntv implements EncodedValue {

  /**
   * 趸交 同一次性交清，交费年期为1年交
   */
  SINGLE("01", "趸交"),
  /**
   * 月交
   */
  MONTHLY("02", "月交"),
  /**
   * 季交
   */
  QUARTERLY("03", "季交"),
  /**
   * 半年交
   */
  HALF_YEARLY("04", "半年交"),
  /**
   * 年交
   */
  YEARLY("05", "年交"),
  /**
   * 不定期交费
   */
  IRREGULAR("06", "不定期交费"),
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

  public String getValue() {
    return value;
  }

  public String getDescription() {
    return description;
  }

  CarbonPayIntv(String value, String description) {
    this.value = value;
    this.description = description;
  }
}
