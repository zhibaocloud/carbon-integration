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

package com.zhibaocloud.carbon.intg.fastjson;

import com.alibaba.fastjson2.JSONReader.Feature;
import com.zhibaocloud.carbon.intg.fastjson.CarbonFastjsonSerializer.Builder;
import com.zhibaocloud.carbon.intg.fastjson.filters.IgnoreEmptyPropertyFilter;
import com.zhibaocloud.carbon.intg.fastjson.modules.CarbonObjectReaderModule;
import com.zhibaocloud.carbon.intg.fastjson.modules.CarbonObjectWriterModule;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;

public class CarbonFastjsonSerializerFactory implements CarbonSerializerFactory {

  @Override
  public CarbonSerializer create(SerializationConfiguration config) {
    Builder builder = Builder.builder()
        .registry(new CarbonObjectWriterModule())
        .registry(new CarbonObjectReaderModule())
        .addFilters(IgnoreEmptyPropertyFilter.INSTANCE);

    if (Boolean.FALSE.equals(config.getIgnoreUnknownProperties())) {
      builder.config(Feature.ErrorOnUnknownProperties);
    }

    return builder.build();
  }
}
