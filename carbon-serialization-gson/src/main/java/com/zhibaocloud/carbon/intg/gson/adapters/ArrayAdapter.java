package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class ArrayAdapter extends TypeAdapter<Object[]> {

  private final TypeAdapter<Object[]> delegateAdapter;

  public ArrayAdapter(TypeAdapter<Object[]> delegateAdapter) {
    this.delegateAdapter = delegateAdapter;
  }

  @Override
  public void write(JsonWriter out, Object[] value) throws IOException {
    if (value.length == 0) {
      out.nullValue();
    } else {
      delegateAdapter.write(out, value);
    }
  }

  @Override
  public Object[] read(JsonReader in) throws IOException {
    return delegateAdapter.read(in);
  }
}