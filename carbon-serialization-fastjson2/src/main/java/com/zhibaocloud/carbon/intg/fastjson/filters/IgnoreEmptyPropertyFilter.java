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
