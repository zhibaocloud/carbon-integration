package com.zhibaocloud.carbon.intg.serializer.starter;

import com.alibaba.fastjson2.JSON;
import com.zhibaocloud.carbon.intg.fastjson.CarbonFastjsonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangtuo
 */
@Configuration
@ConditionalOnClass(JSON.class)
@ConditionalOnMissingBean(CarbonSerializerFactory.class)
public class CarbonFastjsonSerializerAutoConfiguration {

  @Bean("carbon-fastjson-serialization")
  public CarbonSerializerFactory fastjson() {
    return new CarbonFastjsonSerializerFactory();
  }
}
