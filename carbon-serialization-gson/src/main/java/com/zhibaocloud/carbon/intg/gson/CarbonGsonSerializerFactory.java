/*
 * Copyright (c) 2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
 * Carbon Integration SDK is licensed under Mulan PSL v2.
 *
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.zhibaocloud.carbon.intg.gson;

import static java.time.format.DateTimeFormatter.ofPattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CarbonGsonSerializerFactory implements CarbonSerializerFactory {

  private final Gson gson = new GsonBuilder()
      .registerTypeAdapter(CarbonVersion.class, new CarbonVersionAdapter().nullSafe())
      .registerTypeAdapter(CarbonInsuredPeriod.class, new CarbonInsuredPeriodAdapter().nullSafe())
      .registerTypeAdapter(CarbonPaymentPeriod.class, new CarbonPaymentPeriodAdapter().nullSafe())
      .registerTypeAdapter(LocalDate.class, new LocalDateAdapter().nullSafe())
      .registerTypeAdapter(LocalTime.class, new LocalTimeAdapter().nullSafe())
      .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
      .create();


  private static final DateTimeFormatter TIME_PTN = ofPattern("HH:mm:ss");
  private static final DateTimeFormatter DATE_PTN = ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter DATETIME_PTN = ofPattern("yyyy-MM-dd HH:mm:ss");

  static class CarbonVersionAdapter extends TypeAdapter<CarbonVersion> {

    @Override
    public void write(JsonWriter out, CarbonVersion value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        out.value(value.toString());
      }
    }

    @Override
    public CarbonVersion read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      } else {
        return new CarbonVersion(in.nextString());
      }
    }
  }

  static class CarbonInsuredPeriodAdapter extends TypeAdapter<CarbonInsuredPeriod> {

    @Override
    public void write(JsonWriter out, CarbonInsuredPeriod value) throws IOException {
      if (value == null) {
        out.nullValue();
      } else {
        out.value(value.toString());
      }
    }

    @Override
    public CarbonInsuredPeriod read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      } else {
        return new CarbonInsuredPeriod(in.nextString());
      }
    }
  }

  static class CarbonPaymentPeriodAdapter extends TypeAdapter<CarbonPaymentPeriod> {

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

  static class LocalDateAdapter extends TypeAdapter<LocalDate> {

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

  static class LocalTimeAdapter extends TypeAdapter<LocalTime> {

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

  static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

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

  @Override
  public CarbonSerializer create(SerializationConfiguration config) {
    return new CarbonGsonSerializer(gson);
  }
}
