package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhibaocloud.carbon.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * @author yangtuo
 */

class DesensitizationTest {

  private final CarbonSerializer mapper;

  {
    SerializerConfiguration config = new SerializerConfiguration();
    config.setDesensitization(true);
    mapper = new CarbonJacksonSerializerFactory().create(config);
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
}
