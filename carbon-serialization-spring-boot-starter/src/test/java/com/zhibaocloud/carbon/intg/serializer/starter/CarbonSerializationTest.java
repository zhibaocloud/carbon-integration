/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhibaocloud.carbon.intg.serializer.starter;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.fastjson.CarbonFastjsonSerializerFactory;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonRisk;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriodUnit;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriodUnit;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CarbonSerializationTest {


  private static Stream<CarbonSerializer> createMapper() {
    return Stream.of(
        new CarbonJacksonSerializerFactory(),
        new CarbonFastjsonSerializerFactory(),
        new CarbonGsonSerializerFactory()
    ).map(factory -> factory.create(new SerializerConfiguration()));
  }

  @ParameterizedTest
  @MethodSource("createMapper")
  void testInsuredPeriod(CarbonSerializer mapper) throws IOException {
    CarbonInsuredPeriod period = new CarbonInsuredPeriod("1Y");
    assertThat(period.getValue()).isEqualTo(1);
    assertThat(period.getUnit()).isEqualTo(CarbonInsuredPeriodUnit.Y);
    assertThat(period).hasToString("1Y");

    CarbonInsuredPeriod newPeriod = new CarbonInsuredPeriod(1, CarbonInsuredPeriodUnit.Y);
    assertThat(newPeriod).isEqualTo(period);

    CarbonInsuredPeriod period1 = CarbonInsuredPeriod.of("N");
    assertThat(period1.getValue()).isZero();
    assertThat(period1.getUnit()).isEqualTo(CarbonInsuredPeriodUnit.N);
    assertThat(period1).hasToString("N");

    CarbonInsuredPeriod period2 = CarbonInsuredPeriod.of("O");
    assertThat(period2.getValue()).isEqualTo(106);
    assertThat(period2.getUnit()).isEqualTo(CarbonInsuredPeriodUnit.O);

    CarbonInsuredPeriod ip = CarbonInsuredPeriod.of("10Y");
    CarbonRisk source = new CarbonRisk();
    source.setInsuredPeriod(ip);

    String json = mapper.serialize(source);
    assertThat(json).isEqualTo("{\"insuredPeriod\":\"10Y\"}");
    CarbonInsuredPeriod restored = mapper.deserialize(json, CarbonRisk.class).getInsuredPeriod();
    assertThat(ip).isEqualTo(restored);
    assertThat(restored.getValue()).isEqualTo(10);
  }


  @ParameterizedTest
  @MethodSource("createMapper")
  void testPaymentPeriod(CarbonSerializer mapper) throws IOException {
    CarbonPaymentPeriod period = CarbonPaymentPeriod.of("1Y");
    assertThat(period.getValue()).isEqualTo(1);
    assertThat(period.getUnit()).isEqualTo(CarbonPaymentPeriodUnit.Y);
    assertThat(period).hasToString("1Y");

    CarbonPaymentPeriod newPeriod = new CarbonPaymentPeriod(1, CarbonPaymentPeriodUnit.Y);
    assertThat(newPeriod).isEqualTo(period);

    CarbonRisk risk = new CarbonRisk();
    risk.setPaymentPeriod(period);
    String json = mapper.serialize(risk);
    assertThat(json).isEqualTo("{\"paymentPeriod\":\"1Y\"}");
    CarbonPaymentPeriod restored = mapper.deserialize(json, CarbonRisk.class).getPaymentPeriod();
    assertThat(period).isEqualTo(restored);

    CarbonPaymentPeriod single = CarbonPaymentPeriod.SINGLE;
    assertThat(single.getUnit()).isEqualTo(CarbonPaymentPeriodUnit.S);

    assertThat(single).hasToString("S");
  }

  @ParameterizedTest
  @MethodSource("createMapper")
  void testDateTimeSerialization(CarbonSerializer mapper) throws IOException {
    LocalDateTime timestamp = LocalDateTime.of(2023, 3, 30, 23, 59, 59, 999);

    CarbonPolicy policy = new CarbonPolicy();
    policy.setPayTime(timestamp);

    String json = mapper.serialize(policy);
    CarbonPolicy restored = mapper.deserialize(json, CarbonPolicy.class);
    LocalDateTime restoredTime = restored.getPayTime().withNano(0);

    assertThat(restoredTime)
        .isEqualTo(LocalDateTime.of(2023, 3, 30, 23, 59, 59, 0))
        .isNotEqualTo(timestamp);
  }

  @ParameterizedTest
  @MethodSource("createMapper")
  void testJavaTimeSerialization(CarbonSerializer mapper) throws IOException {
    LocalDate date = LocalDate.of(2023, 3, 29);
    LocalDateTime datetime = LocalDateTime.of(2023, 3, 29, 0, 1, 1);
    LocalTime time = LocalTime.of(23, 59, 59);
    Map<String, Object> source = new HashMap<>();
    source.put("date", date);
    source.put("datetime", datetime);
    source.put("time", time);
    String json = mapper.serialize(source);
    assertThat(json).isEqualTo(
        "{\"date\":\"2023-03-29\",\"datetime\":\"2023-03-29 00:01:01\",\"time\":\"23:59:59\"}");
  }

  @Getter
  @Setter
  static class Policy {

    private CarbonVersion version;

    private CarbonInsuredPeriod insuredPeriod;

    private CarbonPaymentPeriod paymentPeriod;
  }

  @ParameterizedTest
  @MethodSource("createMapper")
  void nullSaveTest(CarbonSerializer mapper) throws IOException {
    String out = mapper.serialize(new Policy());
    assertThat(out).isEqualTo("{}");
    Policy policy = mapper.deserialize("{}", Policy.class);
    assertThat(policy.version).isNull();
    assertThat(policy.insuredPeriod).isNull();
    assertThat(policy.paymentPeriod).isNull();
  }
}
