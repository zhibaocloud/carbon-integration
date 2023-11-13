package com.zhibaocloud.carbon.intg.serializer.starter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass({ObjectMapper.class, JavaTimeModule.class})
@ConditionalOnMissingBean(CarbonSerializerFactory.class)
public class CarbonJacksonSerializerAutoConfiguration {

  @Bean("carbon-jackson-serialization")
  public CarbonSerializerFactory jackson() {
    return new CarbonJacksonSerializerFactory();
  }
}
