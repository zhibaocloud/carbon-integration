package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonSimpleStringDesensitization;

import java.lang.annotation.*;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CarbonDesensitize(using = CarbonSimpleStringDesensitization.class)
@Documented
public @interface CarbonStringDesensitize {
}
