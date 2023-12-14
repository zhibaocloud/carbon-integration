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

package com.zhibaocloud.carbon.intg.gson;

import com.google.gson.GsonBuilder;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.gson.adapters.CarbonInsuredPeriodAdapter;
import com.zhibaocloud.carbon.intg.gson.adapters.CarbonPaymentPeriodAdapter;
import com.zhibaocloud.carbon.intg.gson.adapters.CarbonVersionAdapter;
import com.zhibaocloud.carbon.intg.gson.adapters.LocalDateAdapter;
import com.zhibaocloud.carbon.intg.gson.adapters.LocalDateTimeAdapter;
import com.zhibaocloud.carbon.intg.gson.adapters.LocalTimeAdapter;
import com.zhibaocloud.carbon.intg.gson.desensitization.CarbonSensitiveDataAdapterFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CarbonGsonSerializerFactory implements CarbonSerializerFactory {

  private final GsonBuilder gsonBuilder = new GsonBuilder()
      .registerTypeAdapter(CarbonVersion.class, new CarbonVersionAdapter().nullSafe())
      .registerTypeAdapter(CarbonInsuredPeriod.class, new CarbonInsuredPeriodAdapter().nullSafe())
      .registerTypeAdapter(CarbonPaymentPeriod.class, new CarbonPaymentPeriodAdapter().nullSafe())
      .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
      .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter().nullSafe())
      .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe());

  @Override
  public CarbonSerializer create(SerializationConfiguration config) {
    if (Boolean.TRUE.equals(config.getDesensitization())) {
      gsonBuilder.registerTypeAdapterFactory(new CarbonSensitiveDataAdapterFactory());
    }
    return new CarbonGsonSerializer(gsonBuilder.create());
  }
}
