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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 交费期间
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPeriod {

  /**
   * 趸交
   */
  public static final PaymentPeriod SINGLE = new PaymentPeriod("S");
  private int value = 0;
  private PaymentPeriodUnit unit;

  public PaymentPeriod(String period) {
    if ("S".equals(period)) {
      this.unit = PaymentPeriodUnit.S;
      this.value = 1;
    } else {
      this.unit = PaymentPeriodUnit.valueOf(period.substring(period.length() - 1));
      this.value = Integer.parseInt(period.substring(0, period.length() - 1));
    }
  }

  @JsonCreator
  public static PaymentPeriod of(String period) {
    return new PaymentPeriod(period);
  }

  @JsonValue
  @Override
  public String toString() {
    if (unit == PaymentPeriodUnit.S) {
      return unit.name();
    }
    return value + unit.name();
  }
}
