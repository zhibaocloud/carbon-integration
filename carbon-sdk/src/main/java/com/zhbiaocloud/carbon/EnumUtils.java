/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon;

import com.zhbiaocloud.carbon.model.type.EncodedValue;

/**
 * 枚举工具类，用于兼容不同系统之间的类型转换
 *
 * @author jun
 */
public class EnumUtils {

  private EnumUtils() {
  }

  public static <T extends Enum<T> & EncodedValue> T fromValue(Class<T> enumType, String value) {
    for (T enumValue : enumType.getEnumConstants()) {
      if (enumValue.getValue().equals(value)) {
        return enumValue;
      }
    }
    return null;
  }
}
