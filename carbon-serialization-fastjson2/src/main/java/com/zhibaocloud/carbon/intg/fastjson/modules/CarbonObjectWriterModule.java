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

import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriters;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.lang.reflect.Type;

public class CarbonObjectWriterModule implements ObjectWriterModule {

  @Override
  public ObjectWriter<?> getObjectWriter(Type objectType, Class objectClass) {
    if (objectType == CarbonVersion.class) {
      return ObjectWriters.ofToString(CarbonVersion::toString);
    } else if (objectType == CarbonInsuredPeriod.class) {
      return ObjectWriters.ofToString(CarbonInsuredPeriod::toString);
    } else if (objectType == CarbonPaymentPeriod.class) {
      return ObjectWriters.ofToString(CarbonPaymentPeriod::toString);
    }
    return null;
  }
}
