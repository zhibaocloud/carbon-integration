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

package com.zhibaocloud.carbon.intg.fastjson.modules;

import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaders;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.lang.reflect.Type;

public class CarbonObjectReaderModule implements ObjectReaderModule {

  @Override
  public ObjectReader<?> getObjectReader(Type type) {
    if (type == CarbonVersion.class) {
      return ObjectReaders.ofString(CarbonVersion::new);
    } else if (type == CarbonInsuredPeriod.class) {
      return ObjectReaders.ofString(CarbonInsuredPeriod::new);
    } else if (type == CarbonPaymentPeriod.class) {
      return ObjectReaders.ofString(CarbonPaymentPeriod::new);
    }
    return null;
  }
}