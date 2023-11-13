package com.zhibaocloud.carbon.intg.jackson.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;

import java.io.IOException;

/**
 * @author yangtuo
 */
public class CarbonInsuredPeriodModule extends SimpleModule {

  {
    addSerializer(CarbonInsuredPeriod.class, new CarbonInsuredPeriodSerializer());
    addDeserializer(CarbonInsuredPeriod.class, new CarbonInsuredPeriodDeserializer());
  }

  static class CarbonInsuredPeriodSerializer extends StdSerializer<CarbonInsuredPeriod> {

    protected CarbonInsuredPeriodSerializer() {
      super(CarbonInsuredPeriod.class);
    }

    @Override
    public void serialize(CarbonInsuredPeriod value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      gen.writeString(value.toString());
    }
  }

  static class CarbonInsuredPeriodDeserializer extends StdDeserializer<CarbonInsuredPeriod> {

    protected CarbonInsuredPeriodDeserializer() {
      super(CarbonInsuredPeriod.class);
    }

    @Override
    public CarbonInsuredPeriod deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException {
      return new CarbonInsuredPeriod(p.getValueAsString());
    }
  }
}
