package com.zhibaocloud.carbon;

import com.zhibaocloud.carbon.intg.mapper.CarbonMapperFactory;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @author yangtuo
 */
public class CarbonJacksonAutoConfiguration {

  @Bean
  public CarbonMapperFactory mapperFactory(Environment environment) {
    String[] profiles = environment.getActiveProfiles();
    boolean isProd = Arrays.asList(profiles).contains("production");
    return new CarbonJacksonMapperFactory(isProd);
  }
}
