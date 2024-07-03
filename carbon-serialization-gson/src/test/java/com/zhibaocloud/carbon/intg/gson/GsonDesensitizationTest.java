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
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import com.zhibaocloud.carbon.intg.gson.TestDesensitizationModel.Agent;
import com.zhibaocloud.carbon.intg.gson.TestDesensitizationModel.Customer;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import org.junit.jupiter.api.Test;


/**
 * @author yangtuo
 */
public class GsonDesensitizationTest {

  private final CarbonSerializer serializer;

  {
    SerializationConfiguration config = new SerializationConfiguration();
    config.setDesensitization(true);
    serializer = new CarbonGsonSerializerFactory().create(config);
  }


  @Test
  void testDesensitization() throws IOException {
    CarbonApplicant appnt = new CarbonApplicant();
    appnt.setName("张三");
    appnt.setMobile("13800138000");
    appnt.setIdNo("110101199001011234");
    appnt.setEmail("zhangsan@mail.com");
    appnt.setRgtAddress("四川省成都市");

    String content = serializer.serialize(appnt);
    assertThat(content).isEqualTo(
        "{\"email\":\"********@mail.com\",\"idNo\":\"1101**************1234\",\"mobile\":\"138****8000\",\"name\":\"张三\",\"rgtAddress\":\"******\"}"
    );
  }

  @Test
  void testSerializationThrowsException() {
    Agent agent = new Agent();
    agent.setName("张三");

    assertThatThrownBy(() -> serializer.serialize(agent)).hasMessageContaining("not supported yet");

  }

  @Test
  void testDesensitizationWithInterface() {
    Customer customer = new Customer();
    customer.setName("张三");

    assertThatThrownBy(() -> serializer.serialize(customer)).isInstanceOf(Exception.class);
  }

}
