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
 * <table border="1">
 *   <caption>交费期间</caption>
 *   <tr>
 *     <td>编码</td>
 *     <td>说明</td>
 *   </tr>
 *   <tr>
 *     <td>S</td>
 *     <td>趸交。如读取数值，返回1</td>
 *   </tr>
 *   <tr>
 *     <td>nY</td>
 *     <td>n在这里代表数字。例如 10Y 表示：交10年</td>
 *   </tr>
 *   <tr>
 *     <td>nM</td>
 *     <td>n在这里代表数字。例如 3M 表示：交3月</td>
 *   </tr>
 *   <tr>
 *     <td>nD</td>
 *     <td>n在这里代表数字。例如 5D 表示：交10天</td>
 *   </tr>
 *   <tr>
 *     <td>nA</td>
 *     <td>n在这里代表数字。例如 80A 表示：交至80岁</td>
 *   </tr>
 * </table>
 * <p>
 * 交费期间单位，参看 {@link CarbonPaymentPeriodUnit}
 *
 * @author jun
 */
public class CarbonPaymentPeriod {

  /**
   * 趸交
   */
  public static final CarbonPaymentPeriod SINGLE = new CarbonPaymentPeriod("S");
  private int value = 0;
  private CarbonPaymentPeriodUnit unit;

  public int getValue() {
    return value;
  }

  public CarbonPaymentPeriodUnit getUnit() {
    return unit;
  }

  public CarbonPaymentPeriod(int value, CarbonPaymentPeriodUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  /**
   * 创建交费期间
   *
   * @param period 交费期间
   */
  public CarbonPaymentPeriod(String period) {
    if ("S".equals(period)) {
      this.unit = CarbonPaymentPeriodUnit.S;
      this.value = 1;
    } else {
      this.unit = CarbonPaymentPeriodUnit.valueOf(period.substring(period.length() - 1));
      this.value = Integer.parseInt(period.substring(0, period.length() - 1));
    }
  }

  /**
   * 创建交费期间
   *
   * @param period 交费期间格式化字符串
   * @return 交费期间
   */
  public static CarbonPaymentPeriod of(String period) {
    return new CarbonPaymentPeriod(period);
  }

  /**
   * 序列化为 JSON 时的格式
   *
   * @return 序列化结果
   */
  @Override
  public String toString() {
    if (unit == CarbonPaymentPeriodUnit.S) {
      return unit.name();
    }
    return value + unit.name();
  }
}
