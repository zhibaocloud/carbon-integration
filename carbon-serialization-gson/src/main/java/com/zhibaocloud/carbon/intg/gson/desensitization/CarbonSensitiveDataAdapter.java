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

package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.CarbonSensitiveData;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CarbonSensitiveDataAdapter extends TypeAdapter<CarbonSensitiveData> {

  private final Gson gson;
  private final TypeAdapter<CarbonSensitiveData> delegate;

  public CarbonSensitiveDataAdapter(Gson gson, TypeAdapter<CarbonSensitiveData> delegate) {
    this.gson = gson;
    this.delegate = delegate;
  }

  @Override
  public void write(JsonWriter out, CarbonSensitiveData value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.beginObject();
      Class<? extends CarbonSensitiveData> valueClass = value.getClass();
      try {
        PropertyDescriptor[] descriptors = getPropertyDescriptors(valueClass);
        for (PropertyDescriptor descriptor : descriptors) {
          Field field = valueClass.getDeclaredField(descriptor.getName());
          field.setAccessible(true);
          Object fieldValue = field.get(value);
          if (fieldValue == null) {
            continue;
          }
          CarbonDesensitize carbonDesensitize = findDesensitizeAnnotation(field);
          if (carbonDesensitize != null) {
            CarbonDesensitization<Object> desensitization = getDesensitization(carbonDesensitize);
            fieldValue = desensitization.desensitize(fieldValue);
          }
          out.name(descriptor.getDisplayName());
          TypeAdapter<Object> fieldTypeAdapter = getFieldTypeAdapter(field);
          fieldTypeAdapter.write(out, fieldValue);
        }
      } catch (Exception e) {
        throw new UnsupportedOperationException(e);
      }
      out.endObject();
    }
  }


  private PropertyDescriptor[] getPropertyDescriptors(Class<? extends CarbonSensitiveData> clazz)
      throws IntrospectionException {
    return Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();
  }

  @SuppressWarnings("unchecked")
  private TypeAdapter<Object> getFieldTypeAdapter(Field field) {
    return (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(field.getGenericType()));
  }

  @SuppressWarnings("unchecked")
  private static CarbonDesensitization<Object> getDesensitization(CarbonDesensitize annotation) {
    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(
        annotation.using());
  }

  @Override
  public CarbonSensitiveData read(JsonReader in) throws IOException {
    return delegate.read(in);
  }

  private CarbonDesensitize findDesensitizeAnnotation(Field field) {
    for (Annotation annotation : field.getDeclaredAnnotations()) {
      if (annotation instanceof CarbonDesensitize) {
        return (CarbonDesensitize) annotation;
      }
      if (annotation.annotationType().isAnnotationPresent(CarbonDesensitize.class)) {
        return annotation.annotationType().getAnnotation(CarbonDesensitize.class);
      }
    }
    return null;
  }


}
