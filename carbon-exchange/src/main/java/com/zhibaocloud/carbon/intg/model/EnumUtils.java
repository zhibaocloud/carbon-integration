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

package com.zhibaocloud.carbon.intg.model;

import com.zhibaocloud.carbon.intg.types.EncodedValue;

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
