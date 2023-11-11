package com.zhibaocloud.carbon.intg.jackson.desensitization;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationSerializerModifier extends BeanSerializerModifier {

  @Override
  @SuppressWarnings("unchecked")
  public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
      List<BeanPropertyWriter> beanProperties) {
    for (BeanPropertyWriter beanProperty : beanProperties) {
      CarbonDesensitize desensitizeAnnotation = findDesensitizeAnnotation(beanProperty);
      if (desensitizeAnnotation != null) {
        CarbonDesensitization<Object> desensitization = (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(
            desensitizeAnnotation.using());
        beanProperty.assignSerializer(new CarbonObjectDesensitizeSerializer(desensitization));
      }
    }
    return beanProperties;
  }

  private CarbonDesensitize findDesensitizeAnnotation(BeanPropertyWriter beanProperty) {
    for (Annotation annotation : beanProperty.getMember().getAllAnnotations().annotations()) {
      if (annotation.annotationType().isAnnotationPresent(CarbonDesensitize.class)) {
        return annotation.annotationType().getAnnotation(CarbonDesensitize.class);
      }
    }
    return null;
  }
}

