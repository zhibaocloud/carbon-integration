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

package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.desensitization.CarbonSensitiveData;
import com.zhibaocloud.carbon.intg.gson.desensitization.CarbonSensitiveDataAdapter;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;

/**
 * @author yangtuo
 */
public class CarbonAdapterFactory implements TypeAdapterFactory {

  private final SerializationConfiguration config;

  public CarbonAdapterFactory(SerializationConfiguration config) {
    this.config = config;
  }

  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    return findDelegateAdapter(gson, type);
  }


  @SuppressWarnings("unchecked")
  private <T> TypeAdapter<T> findDelegateAdapter(Gson gson, TypeToken<T> type) {

    if (CarbonVersion.class == type.getRawType()) {
      return (TypeAdapter<T>) new CarbonVersionAdapter().nullSafe();
    }

    if (CarbonInsuredPeriod.class == type.getRawType()) {
      return (TypeAdapter<T>) new CarbonInsuredPeriodAdapter().nullSafe();
    }

    if (CarbonPaymentPeriod.class == type.getRawType()) {
      return (TypeAdapter<T>) new CarbonPaymentPeriodAdapter().nullSafe();
    }

    if (LocalDate.class == type.getRawType()) {
      return (TypeAdapter<T>) new LocalDateAdapter().nullSafe();
    }

    if (LocalTime.class == type.getRawType()) {
      return (TypeAdapter<T>) new LocalTimeAdapter().nullSafe();
    }

    if (LocalDateTime.class == type.getRawType()) {
      return (TypeAdapter<T>) new LocalDateTimeAdapter().nullSafe();
    }

    if (CarbonSensitiveData.class.isAssignableFrom(type.getRawType()) && config.getDesensitization()) {
      TypeAdapter<CarbonSensitiveData> delegate = (TypeAdapter<CarbonSensitiveData>)
          gson.getDelegateAdapter(this, type);
      return (TypeAdapter<T>) new CarbonSensitiveDataAdapter(gson, delegate).nullSafe();
    }

    if (String.class == type.getRawType()) {
      return (TypeAdapter<T>) new StringAdapter().nullSafe();
    }

    if (Map.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
      return (TypeAdapter<T>) new MapAdapter((TypeAdapter<Object>) delegateAdapter).nullSafe();
    }

    if (Object[].class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
      return (TypeAdapter<T>) new ArrayAdapter((TypeAdapter<Object[]>) delegateAdapter).nullSafe();
    }

    if (Collection.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, type);
      return (TypeAdapter<T>) new CollectionAdapter(
          (TypeAdapter<Collection<Object>>) delegateAdapter).nullSafe();
    }

    return null;
  }


}
