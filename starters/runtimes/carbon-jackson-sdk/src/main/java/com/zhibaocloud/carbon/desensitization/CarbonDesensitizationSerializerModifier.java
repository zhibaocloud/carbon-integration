package com.zhibaocloud.carbon.desensitization;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;

import java.util.List;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationSerializerModifier extends BeanSerializerModifier {
    @Override
    @SuppressWarnings("unchecked")
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (BeanPropertyWriter beanProperty : beanProperties) {
            CarbonDesensitize annotation = beanProperty.getAnnotation(CarbonDesensitize.class);
            if (annotation != null) {
                CarbonDesensitization<Object> desensitization = (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(annotation.using());
                beanProperty.assignSerializer(new CarbonObjectDesensitizeSerializer(desensitization));
            }
        }
        return beanProperties;
    }
}
