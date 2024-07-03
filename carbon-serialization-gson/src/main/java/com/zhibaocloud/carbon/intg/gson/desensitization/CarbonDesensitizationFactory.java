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

package com.zhibaocloud.carbon.intg.gson.desensitization;

import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtuo
 */
public class CarbonDesensitizationFactory {

  private CarbonDesensitizationFactory() {
  }

  private static final Map<Class<? extends CarbonDesensitization<?>>, CarbonDesensitization<?>> map = new HashMap<>();

  @SuppressWarnings("all")
  public static CarbonDesensitization<?> getDesensitization(
      Class<? extends CarbonDesensitization<?>> clazz) {
    return map.computeIfAbsent(clazz, k -> {
      try {
        return (CarbonDesensitization<?>) k.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        throw new UnsupportedOperationException(e.getMessage(), e);
      }
    });
  }

}
