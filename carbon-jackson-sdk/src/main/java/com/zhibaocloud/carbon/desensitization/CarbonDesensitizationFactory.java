package com.zhibaocloud.carbon.desensitization;


import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationFactory {

  private CarbonDesensitizationFactory() {
  }

  private static final Map<Class<? extends CarbonDesensitization<?>>, CarbonDesensitization<?>> map = new HashMap<>();

  @SuppressWarnings("all")
  public static CarbonDesensitization<?> getDesensitization(Class<? extends CarbonDesensitization<?>> clazz) {
    return map.computeIfAbsent(clazz, k -> {
      try {
        return (CarbonDesensitization<?>) clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        throw new UnsupportedOperationException(e.getMessage(), e);
      }
    });
  }

}
