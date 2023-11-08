package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonEmailDesensitization;

import java.lang.annotation.*;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CarbonDesensitize(using = CarbonEmailDesensitization.class)
@Documented
public @interface CarbonEmailDesensitize {

}
