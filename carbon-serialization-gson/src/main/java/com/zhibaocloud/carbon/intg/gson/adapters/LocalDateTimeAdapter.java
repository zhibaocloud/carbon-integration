package com.zhibaocloud.carbon.intg.gson.adapters;

import static java.time.format.DateTimeFormatter.ofPattern;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

  private static final DateTimeFormatter DATETIME_PTN = ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public void write(JsonWriter out, LocalDateTime value) throws IOException {
    if (value == null) {
      out.nullValue();
    } else {
      out.value(value.format(DATETIME_PTN));
    }
  }

  @Override
  public LocalDateTime read(JsonReader in) throws IOException {
    if (in.peek() == JsonToken.NULL) {
      in.nextNull();
      return null;
    } else {
      return LocalDateTime.parse(in.nextString(), DATETIME_PTN);
    }
  }
}