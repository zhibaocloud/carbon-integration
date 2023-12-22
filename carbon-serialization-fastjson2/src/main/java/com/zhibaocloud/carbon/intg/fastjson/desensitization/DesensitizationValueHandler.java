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

package com.zhibaocloud.carbon.intg.fastjson.desensitization;

import com.alibaba.fastjson2.filter.BeanContext;
import com.alibaba.fastjson2.filter.ContextValueFilter;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonDesensitize;
import java.lang.annotation.Annotation;

/**
 * @author yangtuo
 */
public class DesensitizationValueHandler implements ContextValueFilter {


  @Override
  public Object process(BeanContext context, Object object, String name, Object value) {
    CarbonDesensitize desensitizeAnnotation = findDesensitizeAnnotation(context);
    if (desensitizeAnnotation == null) {
      return value;
    }
    CarbonDesensitization<Object> desensitization = getDesensitization(desensitizeAnnotation);
    return desensitization.desensitize(value);
  }

  @SuppressWarnings("unchecked")
  private static CarbonDesensitization<Object> getDesensitization(
      CarbonDesensitize desensitizeAnnotation) {
    return (CarbonDesensitization<Object>) CarbonDesensitizationFactory.getDesensitization(
        desensitizeAnnotation.using());
  }

  private CarbonDesensitize findDesensitizeAnnotation(BeanContext context) {
    for (Annotation annotation : context.getField().getDeclaredAnnotations()) {
      if (annotation instanceof CarbonDesensitize) {
        return (CarbonDesensitize) annotation;
      }
      if (annotation.annotationType().isAnnotationPresent(CarbonDesensitize.class)) {
        return annotation.annotationType().getAnnotation(CarbonDesensitize.class);
      }
    }
    return null;
  }
}
