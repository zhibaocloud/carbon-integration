package com.zhibaocloud.carbon.intg.fastjson;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import com.zhibaocloud.carbon.intg.fastjson.TestDesensitizationModel.Agent;
import com.zhibaocloud.carbon.intg.fastjson.TestDesensitizationModel.Customer;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * @author yangtuo
 */

class DesensitizationTest {

  private final CarbonSerializer mapper;

  {
    SerializationConfiguration config = new SerializationConfiguration();
    config.setDesensitization(true);
    mapper = new CarbonFastjsonSerializerFactory().create(config);
  }

  @Test
  void testDesensitization() throws IOException {
    CarbonApplicant appnt = new CarbonApplicant();
    appnt.setName("张三");
    appnt.setMobile("13800138000");
    appnt.setIdNo("110101199001011234");
    appnt.setEmail("zhangsan@mail.com");
    appnt.setRgtAddress("四川省成都市");

    String content = mapper.serialize(appnt);
    assertThat(content).isEqualTo(
        "{\"email\":\"********@mail.com\",\"idNo\":\"1101**************1234\",\"mobile\":\"138****8000\",\"name\":\"张三\",\"rgtAddress\":\"******\"}"
    );
  }

  @Test
  void testSerializationThrowsException() {
    Agent agent = new Agent();
    agent.setName("张三");

    assertThatThrownBy(() -> mapper.serialize(agent)).hasMessageContaining("not supported yet");

  }

  @Test
  void testDesensitizationWithInterface() {
    Customer customer = new Customer();
    customer.setName("张三");

    assertThatThrownBy(() -> mapper.serialize(customer)).isInstanceOf(
        UnsupportedOperationException.class);
  }
}
