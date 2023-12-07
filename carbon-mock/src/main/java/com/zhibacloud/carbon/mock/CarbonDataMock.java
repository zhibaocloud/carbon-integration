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

package com.zhibacloud.carbon.mock;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;

/**
 * 创建mock数据
 *
 * @author jun
 */
public class CarbonDataMock {
  private static final MockConfig config = MockConfig.newInstance();


  static {
    config.registerMocker(new CarbonInsuredPeriodMocker(), CarbonInsuredPeriod.class);
    config.registerMocker(new CarbonPaymentPeriodMocker(), CarbonPaymentPeriod.class);
  }

  public static <T> T mock(Class<T> clazz) {
    return JMockData.mock(clazz, config);
  }
}
