/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SerializationTest {

  private final ObjectMapper mapper = new CarbonMapperFactory().create();

  /**
   * 测试序列化的为JSON时字段的顺序。需要保证按照字母顺序进行输出，否则计算签名时会出现问题。
   */
  @Test
  void testFieldSerializationOrder() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("b", "b");
    source.put("a", "a");

    String json = mapper.writeValueAsString(source);
    assertThat(json).isEqualTo("{\"a\":\"a\",\"b\":\"b\"}");

    Map<String, Object> nested = new HashMap<>();
    nested.put("c", source);
    nested.put("d", source);
    String nestedJson = mapper.writeValueAsString(nested);
    assertThat(nestedJson).isEqualTo(
        "{\"c\":{\"a\":\"a\",\"b\":\"b\"},\"d\":{\"a\":\"a\",\"b\":\"b\"}}");
  }

  @Test
  void testJavaTimeSerialization() throws IOException {
    LocalDate date = LocalDate.of(2023, 3, 29);
    LocalDateTime datetime = LocalDateTime.of(2023, 3, 29, 0, 1, 1);
    LocalTime time = LocalTime.of(23, 59, 59);
    Map<String, Object> source = new HashMap<>();
    source.put("date", date);
    source.put("datetime", datetime);
    source.put("time", time);
    String json = mapper.writeValueAsString(source);
    assertThat(json).isEqualTo(
        "{\"date\":\"2023-03-29\",\"datetime\":\"2023-03-29 00:01:01\",\"time\":\"23:59:59\"}");
  }

  @Test
  void testEmptyElimination() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("nullValue", null);
    source.put("emptyValue", "");
    source.put("emptyArray", new String[0]);
    source.put("emptyMap", new HashMap<>());
    source.put("zero", 0);

    ObjectMapper m1 = new ObjectMapper();
    String originValue = m1.writeValueAsString(source);
    assertThat(originValue).isEqualTo(
        "{\"zero\":0,\"emptyValue\":\"\",\"emptyMap\":{},\"emptyArray\":[],\"nullValue\":null}");

    String json = mapper.writeValueAsString(source);
    assertThat(json).isEqualTo("{\"zero\":0}");
  }
}
