package com.zhibaocloud.carbon.desensitization;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationSerializerModifier extends BeanSerializerModifier {


    private final List<Class<? extends Annotation>> types = Arrays.asList(
            CarbonIDCardDesensitize.class,
            CarbonEmailDesensitize.class,
            CarbonStringDesensitize.class,
            CarbonPhoneDesensitize.class
    );

    @Override
    @SuppressWarnings("unchecked")
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (BeanPropertyWriter beanProperty : beanProperties) {
            CarbonDesensitize annotation = getDesensitizationAnnotation(beanProperty);
            if (annotation != null) {
                CarbonDesensitization<Object> desensitization = (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(annotation.using());
                beanProperty.assignSerializer(new CarbonObjectDesensitizeSerializer(desensitization));
            }
        }
        return beanProperties;
    }

    private CarbonDesensitize getDesensitizationAnnotation(BeanPropertyWriter beanProperty) {
        for (Class<? extends Annotation> type : types) {
            Annotation annotation = beanProperty.getAnnotation(type);
            if (annotation != null) {
                return annotation.annotationType().getAnnotation(CarbonDesensitize.class);
            }
        }
        return null;
    }
}
