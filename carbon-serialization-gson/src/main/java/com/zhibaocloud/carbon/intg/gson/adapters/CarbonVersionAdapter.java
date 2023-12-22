package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import java.io.IOException;

public class CarbonVersionAdapter extends TypeAdapter<CarbonVersion> {

  @Override
  public void write(JsonWriter out, CarbonVersion value) throws IOException {
    out.value(value.toString());
  }

  @Override
  public CarbonVersion read(JsonReader in) throws IOException {
    return new CarbonVersion(in.nextString());
  }
}