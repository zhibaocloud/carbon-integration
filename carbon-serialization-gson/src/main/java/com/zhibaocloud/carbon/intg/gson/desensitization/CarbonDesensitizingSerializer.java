package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class CarbonDesensitizingSerializer implements JsonSerializer<Object> {

  @Override
  public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
    try {
      Field field = o.getClass().getDeclaredField(type.toString());
      if (field.isAnnotationPresent(CarbonDesensitize.class)) {
        CarbonDesensitize desensitizeAnnotation = field.getAnnotation(CarbonDesensitize.class);
        CarbonDesensitization<Object> desensitization = this.getDesensitization(desensitizeAnnotation.using());
        return jsonSerializationContext.serialize(desensitization.desensitize(field.get(o)));
      }
    } catch (IllegalAccessException | NoSuchFieldException e) {
      return null;
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  private CarbonDesensitization<Object> getDesensitization(Class<? extends CarbonDesensitization<?>> clazz) {
    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(clazz);
  }
}
