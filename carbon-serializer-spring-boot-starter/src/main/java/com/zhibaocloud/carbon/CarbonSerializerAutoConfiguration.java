package com.zhibaocloud.carbon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

/**
 * @author yangtuo
 */
public class CarbonSerializerAutoConfiguration {

  @Bean
  @ConditionalOnClass(ObjectMapper.class)
  public CarbonSerializerFactory mapperFactory() {
    return new CarbonJacksonSerializerFactory();
  }
}
