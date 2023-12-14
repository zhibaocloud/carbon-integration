package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.zhibaocloud.carbon.intg.desensitization.SensitiveData;

/**
 * @author yangtuo
 */
public class CarbonSensitiveDataAdapterFactory implements TypeAdapterFactory {

  @Override
  @SuppressWarnings("unchecked")
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (SensitiveData.class.isAssignableFrom(type.getRawType())) {
      TypeAdapter<SensitiveData> delegate = getDelegateAdapter(gson, type);
      return (TypeAdapter<T>) new CarbonSensitiveDataAdapter(gson, delegate).nullSafe();
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  private <T> TypeAdapter<SensitiveData> getDelegateAdapter(Gson gson, TypeToken<T> type) {
    return (TypeAdapter<SensitiveData>) gson.getDelegateAdapter(this, type);
  }
}
