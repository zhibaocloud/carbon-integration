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
 * 保险期间单位参看 {@link CarbonInsuredPeriodUnit}
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarbonInsuredPeriod {

  /**
   * 保终身
   */
  public static final CarbonInsuredPeriod LIFE_LONG = new CarbonInsuredPeriod("O");
  /**
   * 无关保险期间
   */
  public static final CarbonInsuredPeriod NONE = new CarbonInsuredPeriod("N");
  private int value = 0;
  private CarbonInsuredPeriodUnit unit = CarbonInsuredPeriodUnit.Y;

  /**
   * 创建保险期间
   *
   * @param period 保险期间格式化字符串
   */
  public CarbonInsuredPeriod(String period) {
    if ("N".equals(period)) {
      this.unit = CarbonInsuredPeriodUnit.N;
    } else if ("O".equals(period)) {
      this.unit = CarbonInsuredPeriodUnit.O;
      this.value = 106;
    } else {
      this.unit = CarbonInsuredPeriodUnit.valueOf(period.substring(period.length() - 1));
      this.value = Integer.parseInt(period.substring(0, period.length() - 1));
    }
  }

  /**
   * 创建保险期间
   *
   * @param period 保险期间格式化字符串
   * @return 保险期间
   */
  public static CarbonInsuredPeriod of(String period) {
    return new CarbonInsuredPeriod(period);
  }

  /**
   * 序列化为 JSON 时的格式
   *
   * @return 序列化结果
   */
  @Override
  public String toString() {
    if (unit == CarbonInsuredPeriodUnit.N || unit == CarbonInsuredPeriodUnit.O) {
      return unit.name();
    }
    return value + unit.name();
  }
}
