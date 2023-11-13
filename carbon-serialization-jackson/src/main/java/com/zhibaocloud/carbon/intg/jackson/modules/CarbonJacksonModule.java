package com.zhibaocloud.carbon.intg.jackson.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;

import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class CarbonJacksonModule extends SimpleModule {

  {
    addSerializer(CarbonVersion.class, new CarbonVersionSerializer());
    addDeserializer(CarbonVersion.class, new CarbonVersionDeserializer());
    addSerializer(CarbonInsuredPeriod.class, new CarbonInsuredPeriodSerializer());
    addDeserializer(CarbonInsuredPeriod.class, new CarbonInsuredPeriodDeserializer());
    addSerializer(CarbonPaymentPeriod.class, new CarbonPaymentPeriodSerializer());
    addDeserializer(CarbonPaymentPeriod.class, new CarbonPaymentPeriodDeserializer());
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
