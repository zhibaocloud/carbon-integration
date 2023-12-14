package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.io.IOException;

public class CarbonPaymentPeriodAdapter extends TypeAdapter<CarbonPaymentPeriod> {

  @Override
  public void write(JsonWriter out, CarbonPaymentPeriod value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value.toString());
    }
  }

  @Override
  public CarbonPaymentPeriod read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      return new CarbonPaymentPeriod(in.nextString());
    }
  }
}