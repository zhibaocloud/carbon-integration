package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonPhoneDesensitization;

import java.lang.annotation.*;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CarbonDesensitize(using = CarbonPhoneDesensitization.class)
@Documented
public @interface CarbonPhoneDesensitize {
}