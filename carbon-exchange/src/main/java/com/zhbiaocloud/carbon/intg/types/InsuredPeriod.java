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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <table border="1">
 *   <caption>保险期间</caption>
 *   <tr>
 *     <td>编码</td>
 *     <td>说明</td>
 *   </tr>
 *   <tr>
 *     <td>nY</td>
 *     <td>n在这里代表数字。例如 3Y 表示：保3年</td>
 *   </tr>
 *   <tr>
 *     <td>nA</td>
 *     <td>n在这里代表数字。例如 80A 表示：保至80岁</td>
 *   </tr>
 *   <tr>
 *     <td>nD</td>
 *     <td>n在这里代表数字。例如 10D 表示：保10天</td>
 *   </tr>
 *   <tr>
 *     <td>nM</td>
 *     <td>n在这里代表数字。例如 5M 表示：保5月</td>
 *   </tr>
 *   <tr>
 *     <td>nW</td>
 *     <td>n在这里代表数字。例如 1W 表示：保1周</td>
 *   </tr>
 *   <tr>
 *     <td>O</td>
 *     <td>保终身，如转换为数字则是106</td>
 *   </tr>
 *   <tr>
 *     <td>N</td>
 *     <td>无关</td>
 *   </tr>
 * </table>
 * <p>
 * 保险期间单位参看 {@link InsuredPeriodUnit}
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuredPeriod {

  /**
   * 保终身
   */
  public static final InsuredPeriod LIFE_LONG = new InsuredPeriod("O");
  /**
   * 无关保险期间
   */
  public static final InsuredPeriod NONE = new InsuredPeriod("N");
  private int value = 0;
  private InsuredPeriodUnit unit = InsuredPeriodUnit.Y;

  @JsonCreator
  public InsuredPeriod(String period) {
    if ("N".equals(period)) {
      this.unit = InsuredPeriodUnit.N;
    } else if ("O".equals(period)) {
      this.unit = InsuredPeriodUnit.O;
      this.value = 106;
    } else {
      this.unit = InsuredPeriodUnit.valueOf(period.substring(period.length() - 1));
      this.value = Integer.parseInt(period.substring(0, period.length() - 1));
    }
  }

  public static InsuredPeriod of(String period) {
    return new InsuredPeriod(period);
  }

  @JsonValue
  @Override
  public String toString() {
    if (unit == InsuredPeriodUnit.N || unit == InsuredPeriodUnit.O) {
      return unit.name();
    }
    return value + unit.name();
  }
}
