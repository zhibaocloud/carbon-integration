package com.zhibaocloud.carbon.intg.sdk;

import com.zhibaocloud.carbon.intg.desensitization.CarbonStringDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
public class TestDesensitizationModel {

  @Getter
  @Setter
  static class Customer {

    @InterfaceDesensitize
    String name;
  }

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @CarbonDesensitize(using = CarbonStringDesensitization.class)
  @interface InterfaceDesensitize {

  }

  @Getter
  @Setter
  static class Agent {

    @CustomDesensitize
    String name;
  }

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @CarbonDesensitize(using = CustomDesensitization.class)
  @interface CustomDesensitize {

  }

  public static class CustomDesensitization implements CarbonStringDesensitization {

    @Override
    public String desensitize(String original) {
      throw new UnsupportedOperationException("not supported yet");
    }
  }
}
