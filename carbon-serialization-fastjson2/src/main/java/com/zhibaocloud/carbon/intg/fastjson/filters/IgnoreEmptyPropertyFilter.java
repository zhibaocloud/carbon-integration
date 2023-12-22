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

package com.zhibaocloud.carbon.intg.fastjson.filters;

import com.alibaba.fastjson2.filter.PropertyFilter;
import java.util.Collection;
import java.util.Map;

/**
 * @author yangtuo
 */
public class IgnoreEmptyPropertyFilter implements PropertyFilter {

  public static final IgnoreEmptyPropertyFilter INSTANCE = new IgnoreEmptyPropertyFilter();

  @Override
  public boolean apply(Object object, String name, Object value) {
    if (value instanceof String) {
      return !((String) value).isEmpty();
    }
    if (value instanceof Map) {
      return !((Map<?, ?>) value).isEmpty();
    }
    if (value instanceof Collection) {
      return !((Collection<?>) value).isEmpty();
    }
    if (value instanceof Object[]) {
      return ((Object[]) value).length > 0;
    }
    return true;
  }
}
