package com.zhibaocloud.carbon.intg.fastjson.desensitization;

import com.alibaba.fastjson2.filter.BeanContext;
import com.alibaba.fastjson2.filter.ContextValueFilter;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.annotation.Annotation;

/**
 * @author yangtuo
 */
public class DesensitizationValueHandler implements ContextValueFilter {


  @Override
  public Object process(BeanContext context, Object object, String name, Object value) {
    CarbonDesensitize desensitizeAnnotation = findDesensitizeAnnotation(context);
    if (desensitizeAnnotation == null) {
      return value;
    }
    CarbonDesensitization<Object> desensitization = getDesensitization(desensitizeAnnotation);
    return desensitization.desensitize(value);
  }

  @SuppressWarnings("unchecked")
  private static CarbonDesensitization<Object> getDesensitization(
      CarbonDesensitize desensitizeAnnotation) {
    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(
        desensitizeAnnotation.using());
  }

  private CarbonDesensitize findDesensitizeAnnotation(BeanContext context) {
    for (Annotation annotation : context.getField().getDeclaredAnnotations()) {
      if (annotation instanceof CarbonDesensitize) {
        return (CarbonDesensitize) annotation;
      }
      if (annotation.annotationType().isAnnotationPresent(CarbonDesensitize.class)) {
        return annotation.annotationType().getAnnotation(CarbonDesensitize.class);
      }
    }
    return null;
  }
}
