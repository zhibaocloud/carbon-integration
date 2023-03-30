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

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.common.Risk;
import com.zhbiaocloud.carbon.model.type.InsuredPeriod;
import com.zhbiaocloud.carbon.model.type.InsuredPeriodUnit;
import com.zhbiaocloud.carbon.model.type.PaymentPeriod;
import com.zhbiaocloud.carbon.model.type.PaymentPeriodUnit;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class SerializationTest {

  private final ObjectMapper mapper = new CarbonMapperFactory(false).create();

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

  @Test
  void testEnvironment() throws IOException {
    CarbonMapperFactory prodFactory = new CarbonMapperFactory(true);
    CarbonMapperFactory devFactory = new CarbonMapperFactory(false);
    ObjectMapper prodMapper = prodFactory.create();
    ObjectMapper devMapper = devFactory.create();

    Policy prodPolicy = prodMapper.readValue("{\"a\":1}", Policy.class);
    assertThat(prodPolicy).isNotNull();

    assertThatThrownBy(() -> devMapper.readValue("{\"a\":1}", Policy.class))
        .isInstanceOf(UnrecognizedPropertyException.class);
  }

  @Test
  void testInsuredPeriod() throws IOException {
    InsuredPeriod period = new InsuredPeriod("1Y");
    assertThat(period.getValue()).isEqualTo(1);
    assertThat(period.getUnit()).isEqualTo(InsuredPeriodUnit.Y);
    assertThat(period).hasToString("1Y");

    InsuredPeriod newPeriod = new InsuredPeriod(1, InsuredPeriodUnit.Y);
    assertThat(newPeriod).isEqualTo(period);

    InsuredPeriod period1 = InsuredPeriod.of("N");
    assertThat(period1.getValue()).isZero();
    assertThat(period1.getUnit()).isEqualTo(InsuredPeriodUnit.N);
    assertThat(period1).hasToString("N");

    InsuredPeriod period2 = InsuredPeriod.of("O");
    assertThat(period2.getValue()).isEqualTo(106);
    assertThat(period2.getUnit()).isEqualTo(InsuredPeriodUnit.O);

    InsuredPeriod ip = InsuredPeriod.of("10Y");
    Risk source = new Risk();
    source.setInsuredPeriod(ip);

    String json = mapper.writeValueAsString(source);
    assertThat(json).isEqualTo("{\"insuredPeriod\":\"10Y\"}");
    InsuredPeriod restored = mapper.readValue(json, Risk.class).getInsuredPeriod();
    assertThat(ip).isEqualTo(restored);
    assertThat(restored.getValue()).isEqualTo(10);
  }

  @Test
  void testPaymentPeriod() throws IOException {
    PaymentPeriod period = PaymentPeriod.of("1Y");
    assertThat(period.getValue()).isEqualTo(1);
    assertThat(period.getUnit()).isEqualTo(PaymentPeriodUnit.Y);
    assertThat(period).hasToString("1Y");

    PaymentPeriod newPeriod = new PaymentPeriod(1, PaymentPeriodUnit.Y);
    assertThat(newPeriod).isEqualTo(period);

    Risk risk = new Risk();
    risk.setPaymentPeriod(period);
    String json = mapper.writeValueAsString(risk);
    assertThat(json).isEqualTo("{\"paymentPeriod\":\"1Y\"}");
    PaymentPeriod restored = mapper.readValue(json, Risk.class).getPaymentPeriod();
    assertThat(period).isEqualTo(restored);

    PaymentPeriod single = PaymentPeriod.SINGLE;
    assertThat(single.getUnit()).isEqualTo(PaymentPeriodUnit.S);

    assertThat(single).hasToString("S");
  }

  /**
   * 时间格式精度损失
   */
  @Test
  void testDateTimeSerialization() throws IOException {
    LocalDateTime timestamp = LocalDateTime.of(2023, 3, 30, 23, 59, 59, 999);

    Policy policy = new Policy();
    policy.setPayTime(timestamp);

    String json = mapper.writeValueAsString(policy);
    Policy restored = mapper.readValue(json, Policy.class);
    LocalDateTime restoredTime = restored.getPayTime();

    assertThat(restoredTime)
        .isEqualTo(LocalDateTime.of(2023, 3, 30, 23, 59, 59, 0))
        .isNotEqualTo(timestamp);
  }
}
