package com.zhibaocloud.carbon.intg.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.CarbonInsuredPeriodAdapter;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.CarbonPaymentPeriodAdapter;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.CarbonVersionAdapter;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.LocalDateAdapter;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.LocalDateTimeAdapter;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory.LocalTimeAdapter;
import com.zhibaocloud.carbon.intg.gson.desensitization.CarbonDesensitizationFactory;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtuo
 */
public class CarbonTypeAdapterFactory implements TypeAdapterFactory {

  private final Map<Type, TypeAdapter<?>> adapters = new HashMap<>();

  {
    adapters.put(CarbonVersion.class, new CarbonVersionAdapter().nullSafe());
    adapters.put(CarbonInsuredPeriod.class, new CarbonInsuredPeriodAdapter().nullSafe());
    adapters.put(CarbonPaymentPeriod.class, new CarbonPaymentPeriodAdapter().nullSafe());
    adapters.put(LocalDate.class, new LocalDateAdapter().nullSafe());
    adapters.put(LocalTime.class, new LocalTimeAdapter().nullSafe());
    adapters.put(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe());
  }

  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

    TypeAdapter<?> adapter = adapters.get(type.getRawType());
    if (adapter != null) {
      //noinspection unchecked
      return (TypeAdapter<T>) adapter;
    }

    TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);

    return new TypeAdapter<T>() {
      @Override
      public void write(JsonWriter out, T value) throws IOException {
        if (value == null) {
          out.nullValue();
          return;
        }
        try {
          out.beginObject(); // 开始写对象

          // 反射遍历所有字段
          for (Field field : value.getClass().getDeclaredFields()) {
            field.setAccessible(true); // 确保可以访问私有字段
            Object fieldValue = field.get(value); // 获取字段的值

            // 检查字段是否有脱敏注解
            if (field.isAnnotationPresent(CarbonDesensitize.class)) {
              CarbonDesensitize desensitizeAnnotation = field.getAnnotation(
                  CarbonDesensitize.class);
              CarbonDesensitization<Object> desensitization = (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(
                  desensitizeAnnotation.using());
              fieldValue = desensitization.desensitize(fieldValue); // 应用脱敏逻辑
            }

            // 序列化字段
            out.name(field.getName());
            delegate.write(out, (T) fieldValue);
          }

          out.endObject(); // 结束写对象
        } catch (IllegalAccessException e) {
          out.nullValue();
        }
      }

      @Override
      public T read(JsonReader in) throws IOException {
        return delegate.read(in);
      }
    };
  }


  @SuppressWarnings("unchecked")
  private CarbonDesensitization<Object> getDesensitization(
      Class<? extends CarbonDesensitization<?>> clazz) {
    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(clazz);
  }
}
