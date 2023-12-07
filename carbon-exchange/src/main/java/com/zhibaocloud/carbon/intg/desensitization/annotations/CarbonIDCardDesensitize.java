package com.zhibaocloud.carbon.intg.desensitization.annotations;


import com.zhibaocloud.carbon.intg.desensitization.CarbonIDCardDesensitization;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangtuo
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CarbonDesensitize(using = CarbonIDCardDesensitization.class)
@Documented
public @interface CarbonIDCardDesensitize {

}
