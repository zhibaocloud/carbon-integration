package com.zhibaocloud.carbon.intg.fastjson;

import com.zhibaocloud.carbon.intg.desensitization.CarbonStringDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangtuo
 */
public class TestDesensitizationModel {


  static class Customer {

    @InterfaceDesensitize
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @CarbonDesensitize(using = CarbonStringDesensitization.class)
  @interface InterfaceDesensitize {

  }

  static class Agent {

    @CustomDesensitize
    private String name;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
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
