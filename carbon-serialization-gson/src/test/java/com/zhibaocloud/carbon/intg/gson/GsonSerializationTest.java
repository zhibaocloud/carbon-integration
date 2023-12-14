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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class GsonSerializationTest {

  CarbonGsonSerializerFactory factory = new CarbonGsonSerializerFactory();
  CarbonSerializer serializer = factory.create(new SerializationConfiguration());

  @Test
  void testSerialization() throws IOException {
    GsonBean bean = new GsonBean();
    bean.setDate(null);
    bean.setDatetime(null);
    bean.setTime(null);

    String output0 = serializer.serialize(bean);
    assertThat(output0).isEqualTo("{}");

    LocalDate date = LocalDate.of(2023, 12, 31);
    String json = "{\"date\":\"2023-12-31\"}";

    bean.setDate(date);

    String output1 = serializer.serialize(bean);
    assertThat(output1).isEqualTo(json);

    GsonBean restored = serializer.deserialize("{}", GsonBean.class);
    assertThat(restored.getDate()).isNull();

    restored = serializer.deserialize(json, GsonBean.class);
    assertThat(restored.getDate()).isEqualTo(date);
  }

  @Test
  void testModelSerialization() throws IOException {
    CarbonApplicant appnt = new CarbonApplicant();
    appnt.setName("张三");
    appnt.setMobile("13800138000");
    appnt.setIdNo("110101199001011234");
    appnt.setEmail("zhangsan@mail.com");
    appnt.setRgtAddress("四川省成都市");
    appnt.setBirthdate(LocalDate.of(1990, 1, 1));

    String serialized = serializer.serialize(appnt);
    CarbonApplicant deserialized = serializer.deserialize(serialized, CarbonApplicant.class);
    assertThat(deserialized.toString()).isEqualTo(appnt.toString());
  }
}
