package com.zhibaocloud.carbon.intg.gson.adapters;

import static java.time.format.DateTimeFormatter.ofPattern;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeAdapter extends TypeAdapter<LocalTime> {

  private static final DateTimeFormatter TIME_PTN = ofPattern("HH:mm:ss");

  @Override
  public void write(JsonWriter out, LocalTime value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value.format(TIME_PTN));
    }
  }

  @Override
  public LocalTime read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      return LocalTime.parse(in.nextString(), TIME_PTN);
    }
  }
}