package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collection;

public class CollectionAdapter extends TypeAdapter<Collection<Object>> {

  private final TypeAdapter<Collection<Object>> delegateAdapter;

  public CollectionAdapter(TypeAdapter<Collection<Object>> delegateAdapter) {
    this.delegateAdapter = delegateAdapter;
  }

  @Override
  public void write(JsonWriter out, Collection<Object> value) throws IOException {
    if (value == null || value.isEmpty()) {
      out.nullValue();
    } else {
      delegateAdapter.write(out, value);
    }
  }

  @Override
  public Collection<Object> read(JsonReader in) throws IOException {
    return delegateAdapter.read(in);
  }
}