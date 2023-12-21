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
import com.google.gson.Gson;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
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


  /**
   * 测试序列化的为JSON时字段的顺序。需要保证按照字母顺序进行输出，否则计算签名时会出现问题。
   */
  @Test
  void testFieldSerializationOrder() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("b", "b");
    source.put("a", "a");

    String json = serializer.serialize(source);
    Assertions.assertThat(json).isEqualTo("{\"a\":\"a\",\"b\":\"b\"}");

    Map<String, Object> nested = new HashMap<>();
    nested.put("c", source);
    nested.put("d", source);
    String nestedJson = serializer.serialize(nested);
    Assertions.assertThat(nestedJson).isEqualTo(
        "{\"c\":{\"a\":\"a\",\"b\":\"b\"},\"d\":{\"a\":\"a\",\"b\":\"b\"}}");
  }


  @Test
  void testEmptyElimination() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("nullValue", null);
    source.put("emptyValue", "");
    source.put("emptyArray", new String[0]);
    source.put("emptyMap", new HashMap<>());
    source.put("zero", 0);
    source.put("emptyList", new ArrayList<>(0));

    Gson gson = new Gson();
    String originValue = gson.toJson(source);
    Assertions.assertThat(originValue).isEqualTo(
        "{\"zero\":0,\"emptyList\":[],\"emptyValue\":\"\",\"emptyMap\":{},\"emptyArray\":[]}");

    String json = serializer.serialize(source);
    Assertions.assertThat(json).isEqualTo("{\"zero\":0}");
  }

  //  @Test
  // TODO: 2023/12/21 该测试用例暂时无法通过：Gson默认忽略未知字段，且无法通过配置修改该行为
  void testEnvironment() throws IOException {

    CarbonSerializerFactory prodFactory = new CarbonGsonSerializerFactory();
    SerializationConfiguration prodConfig = new SerializationConfiguration();
    CarbonSerializer prodSerializer = prodFactory.create(prodConfig);

    CarbonSerializerFactory devFactory = new CarbonGsonSerializerFactory();
    SerializationConfiguration devConfig = new SerializationConfiguration();
    devConfig.setIgnoreUnknownProperties(false);
    CarbonSerializer devSerializer = devFactory.create(devConfig);

    CarbonPolicy prodPolicy = prodSerializer.deserialize("{\"a\":1}", CarbonPolicy.class);
    Assertions.assertThat(prodPolicy).isNotNull();

    Assertions.assertThatThrownBy(() -> devSerializer.deserialize("{\"a\":1}", CarbonPolicy.class))
        .isInstanceOf(RuntimeException.class);
  }
}
