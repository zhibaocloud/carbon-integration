/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 交费期间
 *
 * @author jun
 */
@Data
@AllArgsConstructor
public class PaymentPeriod {

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

  public static final PaymentPeriod SINGLE = new PaymentPeriod("S");

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
