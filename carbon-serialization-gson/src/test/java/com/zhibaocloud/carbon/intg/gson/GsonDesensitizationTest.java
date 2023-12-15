package com.zhibaocloud.carbon.intg.gson;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

  // TODO
//  @Test
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

}
