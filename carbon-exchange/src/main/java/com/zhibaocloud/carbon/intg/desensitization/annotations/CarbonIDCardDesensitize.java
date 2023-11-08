package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonIDCardDesensitization;

import java.lang.annotation.*;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CarbonDesensitize(using = CarbonIDCardDesensitization.class)
@Documented
public @interface CarbonIDCardDesensitize {
}