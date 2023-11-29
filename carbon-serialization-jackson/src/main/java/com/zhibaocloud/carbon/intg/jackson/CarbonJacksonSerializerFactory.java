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

package com.zhibaocloud.carbon.intg.jackson;

import static java.time.format.DateTimeFormatter.ofPattern;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import com.zhibaocloud.carbon.intg.jackson.modules.CarbonDesensitizationModule;
import com.zhibaocloud.carbon.intg.jackson.modules.CarbonJacksonModule;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 与服务端通信的时的序列化规则
 *
 * @author jun
 */
public class CarbonJacksonSerializerFactory implements CarbonSerializerFactory {

  private static final DateTimeFormatter TIME_PTN = ofPattern("HH:mm:ss");
  private static final DateTimeFormatter DATE_PTN = ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter DATETIME_PTN = ofPattern("yyyy-MM-dd HH:mm:ss");

  public CarbonJacksonSerializerFactory() {
  }


  private static final ObjectMapper origin = JsonMapper.builder()
      .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
      .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
      .build()
      .registerModules(
          new JavaTimeModule()
              .addSerializer(LocalDate.class, new LocalDateSerializer(DATE_PTN))
              .addDeserializer(LocalDate.class, new LocalDateDeserializer(DATE_PTN))

              .addSerializer(LocalTime.class, new LocalTimeSerializer(TIME_PTN))
              .addDeserializer(LocalTime.class, new LocalTimeDeserializer(TIME_PTN))

              .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DATETIME_PTN))
              .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATETIME_PTN)),

          new CarbonJacksonModule()
      )
      .setSerializationInclusion(Include.NON_NULL)
      .setSerializationInclusion(Include.NON_EMPTY);

  public CarbonSerializer create(SerializationConfiguration config) {
    ObjectMapper om = origin.copy();

    // 开发、测试环境则进行报错。识别未知字段，可以及时发现问题
    // 生产环境，则忽略未知字段
    om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
        config.getIgnoreUnknownProperties());

    if (Boolean.TRUE.equals(config.getDesensitization())) {
      om.registerModule(new CarbonDesensitizationModule());
    }

    return new CarbonJacksonSerializer(om);
  }
}
