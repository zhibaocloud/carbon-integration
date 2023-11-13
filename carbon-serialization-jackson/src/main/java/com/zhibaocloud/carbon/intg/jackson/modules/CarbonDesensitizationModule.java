package com.zhibaocloud.carbon.intg.jackson.modules;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zhibaocloud.carbon.intg.jackson.desensitization.CarbonDesensitizationSerializerModifier;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationModule extends SimpleModule {

  {
    setSerializerModifier(new CarbonDesensitizationSerializerModifier());
  }
}
