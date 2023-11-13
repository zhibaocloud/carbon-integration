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

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.reader.ObjectReaders;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import com.alibaba.fastjson2.writer.ObjectWriters;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializerConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.lang.reflect.Type;
import java.util.function.Function;

public class CarbonFastjsonSerializerFactory implements CarbonSerializerFactory {

  static class CarbonObjectReaderModule implements ObjectReaderModule {

    @Override
    public ObjectReader<?> getObjectReader(Type type) {
      if (type == CarbonVersion.class) {
        return ObjectReaders.ofString(CarbonVersion::new);
      } else if (type == CarbonInsuredPeriod.class) {
        return ObjectReaders.ofString(CarbonInsuredPeriod::new);
      } else if (type == CarbonPaymentPeriod.class) {
        return ObjectReaders.ofString(CarbonPaymentPeriod::new);
      }
      return null;
    }
  }

  static class CarbonObjectWriterModule implements ObjectWriterModule {

    @Override
    public ObjectWriter<?> getObjectWriter(Type objectType, Class objectClass) {
      if (objectType == CarbonVersion.class) {
        return ObjectWriters.ofToString(CarbonVersion::toString);
      } else if (objectType == CarbonInsuredPeriod.class) {
        return ObjectWriters.ofToString(CarbonInsuredPeriod::toString);
      } else if (objectType == CarbonPaymentPeriod.class) {
        return ObjectWriters.ofToString(CarbonPaymentPeriod::toString);
      }
      return null;
    }
  }
  static {
    // TODO: 考虑创建单独的 fastjson 对象，避免和用户的 fastjson 配置冲突
    ObjectReaderProvider reader = JSONFactory.getDefaultObjectReaderProvider();
    reader.register(new CarbonObjectReaderModule());

    ObjectWriterProvider writer = JSONFactory.getDefaultObjectWriterProvider();
    writer.register(new CarbonObjectWriterModule());
  }

  @Override
  public CarbonSerializer create(SerializerConfiguration config) {
    return new CarbonFastjsonSerializer();
  }
}
