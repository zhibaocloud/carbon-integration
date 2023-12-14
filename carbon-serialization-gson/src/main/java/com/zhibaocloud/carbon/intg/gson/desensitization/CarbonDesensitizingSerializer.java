package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.io.IOException;
import java.lang.reflect.Type;

public class CarbonDesensitizingSerializer extends TypeAdapter<Object> {

  @Override
  public void write(JsonWriter out, Object value) throws IOException {
    if (value == null) {
      out.nullValue();
      return;
    }

  }

  @Override
  public Object read(JsonReader in) throws IOException {
    return null;
  }

//  @Override
//  public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
//    try {
//      Field field = o.getClass().getDeclaredField(type.toString());
//      if (field.isAnnotationPresent(CarbonDesensitize.class)) {
//        CarbonDesensitize desensitizeAnnotation = field.getAnnotation(CarbonDesensitize.class);
//        CarbonDesensitization<Object> desensitization = this.getDesensitization(desensitizeAnnotation.using());
//        return jsonSerializationContext.serialize(desensitization.desensitize(field.get(o)));
//      }
//    } catch (IllegalAccessException | NoSuchFieldException e) {
//      return null;
//    }
//    return null;
//  }
//
//  @SuppressWarnings("unchecked")
//  private CarbonDesensitization<Object> getDesensitization(Class<? extends CarbonDesensitization<?>> clazz) {
//    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(clazz);
//  }
}
