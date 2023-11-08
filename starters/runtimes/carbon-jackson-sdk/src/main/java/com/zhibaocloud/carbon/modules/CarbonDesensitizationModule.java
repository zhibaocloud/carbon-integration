package com.zhibaocloud.carbon.modules;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zhibaocloud.carbon.desensitization.CarbonDesensitizationSerializerModifier;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationModule extends SimpleModule {

  {
    setSerializerModifier(new CarbonDesensitizationSerializerModifier());
  }
}
