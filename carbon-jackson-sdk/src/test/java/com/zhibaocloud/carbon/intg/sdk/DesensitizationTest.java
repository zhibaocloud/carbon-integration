package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.zhibaocloud.carbon.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.desensitization.CarbonStringDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lombok.Getter;
import lombok.Setter;
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

  @Test
  void testDesensitizationWithInterface() {
    Customer customer = new Customer();
    customer.setName("张三");

    assertThatThrownBy(() -> {
      mapper.serialize(customer);
    }).isInstanceOf(UnsupportedOperationException.class);
  }

  @Getter
  @Setter
  static class Customer {

    @CustomDesensitize
    String name;
  }

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @CarbonDesensitize(using = CarbonStringDesensitization.class)
  @interface CustomDesensitize {

  }
}
