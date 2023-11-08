package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;

import java.lang.annotation.*;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CarbonDesensitize {
    Class<? extends CarbonDesensitization<?>> using();
}
