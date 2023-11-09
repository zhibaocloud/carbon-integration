package com.zhibaocloud.carbon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import java.util.Arrays;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author yangtuo
 */
public class CarbonSerializerAutoConfiguration {

  @Bean
  @ConditionalOnClass(ObjectMapper.class)
  public CarbonSerializerFactory mapperFactory(Environment environment) {
    String[] profiles = environment.getActiveProfiles();
    boolean isProd = Arrays.asList(profiles).contains("production");
    return new CarbonJacksonSerializerFactory(isProd);
  }
}
