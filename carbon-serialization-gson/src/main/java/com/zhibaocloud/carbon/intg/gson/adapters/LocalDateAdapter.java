package com.zhibaocloud.carbon.intg.gson.adapters;

import static java.time.format.DateTimeFormatter.ofPattern;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

  private static final DateTimeFormatter DATE_PTN = ofPattern("yyyy-MM-dd");

  @Override
  public void write(JsonWriter out, LocalDate value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value.format(DATE_PTN));
    }
  }

  @Override
  public LocalDate read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      return LocalDate.parse(in.nextString(), DATE_PTN);
    }
  }
}
