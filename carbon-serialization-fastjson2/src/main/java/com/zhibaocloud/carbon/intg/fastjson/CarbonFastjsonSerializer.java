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
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;

public class CarbonFastjsonSerializer implements CarbonSerializer {

  private final ObjectReaderProvider readerProvider;
  private final ObjectWriterProvider writerProvider;

  public CarbonFastjsonSerializer(ObjectReaderProvider readerProvider,
      ObjectWriterProvider writerProvider) {
    this.readerProvider = readerProvider;
    this.writerProvider = writerProvider;
  }

  @Override
  public String serialize(Object value) {
    return JSON.toJSONString(value, JSONFactory.createWriteContext(writerProvider));
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clz) {
    return JSON.parseObject(payload, clz, JSONFactory.createReadContext(readerProvider));
  }


  static class Builder {

    private final ObjectReaderProvider readerProvider;
    private final ObjectWriterProvider writerProvider;

    private Builder() {
      readerProvider = new ObjectReaderProvider();
      writerProvider = new ObjectWriterProvider();
    }

    public static Builder builder() {
      return new Builder();
    }

    public Builder registry(ObjectWriterModule module) {
      writerProvider.register(module);
      return this;
    }

    public Builder registry(ObjectReaderModule module) {
      readerProvider.register(module);
      return this;
    }

    public Builder config(JSONWriter.Feature... features) {
      // TODO
      return this;
    }

    public Builder config(JSONReader.Feature... features) {
      // TODO
      return this;
    }

    public Builder config(JSONReader.Feature feature, boolean state) {
      // TODO
      return this;
    }

    public Builder config(JSONWriter.Feature feature, boolean state) {
      // TODO
      return this;
    }


    public CarbonSerializer build() {
      return new CarbonFastjsonSerializer(readerProvider, writerProvider);
    }
  }
}