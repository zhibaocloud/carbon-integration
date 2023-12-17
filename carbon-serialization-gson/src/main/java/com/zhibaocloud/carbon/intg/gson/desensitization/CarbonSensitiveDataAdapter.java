package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.SensitiveData;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CarbonSensitiveDataAdapter extends TypeAdapter<SensitiveData> {

  private final Gson gson;
  private final TypeAdapter<SensitiveData> delegate;

  public CarbonSensitiveDataAdapter(Gson gson, TypeAdapter<SensitiveData> delegate) {
    this.gson = gson;
    this.delegate = delegate;
  }

  @Override
  public void write(JsonWriter out, SensitiveData value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.beginObject();
      for (Field field : value.getClass().getDeclaredFields()) {
        try {
          field.setAccessible(true);
          Object fieldValue = field.get(value);
          if (fieldValue == null) {
            continue;
          }

          CarbonDesensitize annotation = findDesensitizeAnnotation(field);
          if (annotation != null) {
            CarbonDesensitization<Object> desensitization = getDesensitization(annotation);
            fieldValue = desensitization.desensitize(fieldValue);
          }

          out.name(field.getName());
          TypeAdapter<Object> fieldTypeAdapter = getFieldTypeAdapter(field);
          fieldTypeAdapter.write(out, fieldValue);
        } catch (Exception e) {
          out.nullValue();
        }
      }
      out.endObject();
    }
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
  public SensitiveData read(JsonReader in) throws IOException {
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
