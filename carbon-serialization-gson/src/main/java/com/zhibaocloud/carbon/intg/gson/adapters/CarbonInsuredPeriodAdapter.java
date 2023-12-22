package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import java.io.IOException;

public class CarbonInsuredPeriodAdapter extends TypeAdapter<CarbonInsuredPeriod> {

  @Override
  public void write(JsonWriter out, CarbonInsuredPeriod value) throws IOException {
    out.value(value.toString());
  }

  @Override
  public CarbonInsuredPeriod read(JsonReader in) throws IOException {
    return new CarbonInsuredPeriod(in.nextString());
  }
}