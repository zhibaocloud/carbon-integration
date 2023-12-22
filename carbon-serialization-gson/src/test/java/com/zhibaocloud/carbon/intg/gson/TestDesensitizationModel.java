/*
 * Copyright (c) 2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
 * Carbon Integration SDK is licensed under Mulan PSL v2.
 *
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.zhibaocloud.carbon.intg.gson;

import com.zhibaocloud.carbon.intg.desensitization.CarbonSensitiveData;
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


  static class Customer implements CarbonSensitiveData {

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

  static class Agent implements CarbonSensitiveData {

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
