package com.zhibaocloud.carbon.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class CarbonVersionModule extends SimpleModule {

  {
    addSerializer(CarbonVersion.class, new CarbonVersionSerializer());
    addDeserializer(CarbonVersion.class, new CarbonVersionDeserializer());
  }

  static class CarbonVersionDeserializer extends StdDeserializer<CarbonVersion> {

    protected CarbonVersionDeserializer() {
      super(CarbonVersion.class);
    }

    @Override
    public CarbonVersion deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
      return new CarbonVersion(p.getValueAsString());
    }

  }

  static class CarbonVersionSerializer extends StdSerializer<CarbonVersion> {

    public CarbonVersionSerializer() {
      super(CarbonVersion.class);
    }

    @Override
    public void serialize(CarbonVersion value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      gen.writeString(value.toString());
    }
  }
}
