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

package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SerializationTest {

  private final CarbonSerializer serializer = new CarbonJacksonSerializerFactory()
      .create(new SerializationConfiguration());

  /**
   * 测试序列化的为JSON时字段的顺序。需要保证按照字母顺序进行输出，否则计算签名时会出现问题。
   */
  @Test
  void testFieldSerializationOrder() throws IOException {
    Map<String, Object> source = new HashMap<>();
    source.put("b", "b");
    source.put("a", "a");

    String json = serializer.serialize(source);
    assertThat(json).isEqualTo("{\"a\":\"a\",\"b\":\"b\"}");

    Map<String, Object> nested = new HashMap<>();
    nested.put("c", source);
    nested.put("d", source);
    String nestedJson = serializer.serialize(nested);
    assertThat(nestedJson).isEqualTo(
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

    ObjectMapper m1 = new ObjectMapper();
    String originValue = m1.writeValueAsString(source);
    assertThat(originValue).isEqualTo(
        "{\"zero\":0,\"emptyValue\":\"\",\"emptyMap\":{},\"emptyArray\":[],\"nullValue\":null}");

    String json = serializer.serialize(source);
    assertThat(json).isEqualTo("{\"zero\":0}");
  }

  @Test
  void testEnvironment() throws IOException {

    CarbonSerializerFactory prodFactory = new CarbonJacksonSerializerFactory();
    SerializationConfiguration prodConfig = new SerializationConfiguration();
    CarbonSerializer prodSerializer = prodFactory.create(prodConfig);

    CarbonSerializerFactory devFactory = new CarbonJacksonSerializerFactory();
    SerializationConfiguration devConfig = new SerializationConfiguration();
    devConfig.setIgnoreUnknownProperties(false);
    CarbonSerializer devSerializer = devFactory.create(devConfig);

    CarbonPolicy prodPolicy = prodSerializer.deserialize("{\"a\":1}", CarbonPolicy.class);
    assertThat(prodPolicy).isNotNull();

    Assertions.assertThatThrownBy(() -> devSerializer.deserialize("{\"a\":1}", CarbonPolicy.class))
        .isInstanceOf(UnrecognizedPropertyException.class);
  }
}
