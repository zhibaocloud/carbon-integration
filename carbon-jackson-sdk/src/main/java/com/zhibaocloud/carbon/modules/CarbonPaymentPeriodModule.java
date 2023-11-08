package com.zhibaocloud.carbon.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class CarbonPaymentPeriodModule extends SimpleModule {

  {
    addSerializer(CarbonPaymentPeriod.class, new CarbonPaymentPeriodSerializer());
    addDeserializer(CarbonPaymentPeriod.class, new CarbonPaymentPeriodDeserializer());
  }

  static class CarbonPaymentPeriodDeserializer extends StdDeserializer<CarbonPaymentPeriod> {

    protected CarbonPaymentPeriodDeserializer() {
      super(CarbonPaymentPeriod.class);
    }

    @Override
    public CarbonPaymentPeriod deserialize(JsonParser p, DeserializationContext ctxt)
        throws IOException {
      return CarbonPaymentPeriod.of(p.getValueAsString());
    }

  }

  static class CarbonPaymentPeriodSerializer extends StdSerializer<CarbonPaymentPeriod> {

    protected CarbonPaymentPeriodSerializer() {
      super(CarbonPaymentPeriod.class);
    }

    @Override
    public void serialize(CarbonPaymentPeriod value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
      gen.writeString(value.toString());
    }
  }
}
