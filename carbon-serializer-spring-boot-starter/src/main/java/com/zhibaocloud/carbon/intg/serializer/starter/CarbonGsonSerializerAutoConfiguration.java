package com.zhibaocloud.carbon.intg.serializer.starter;

import com.google.gson.Gson;
import com.zhibaocloud.carbon.intg.gson.CarbonGsonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass(Gson.class)
@ConditionalOnMissingBean(CarbonSerializerFactory.class)
public class CarbonGsonSerializerAutoConfiguration {

  @Bean("carbon-gson-serialization")
  public CarbonSerializerFactory gson() {
    return new CarbonGsonSerializerFactory();
  }
}
