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
import com.alibaba.fastjson2.JSONWriter.Context;
import com.alibaba.fastjson2.JSONWriter.Feature;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarbonFastjsonSerializer implements CarbonSerializer {

  private final Builder builder;

  public CarbonFastjsonSerializer(Builder builder) {
    this.builder = builder;
  }

  @Override
  public String serialize(Object value) {
    return JSON.toJSONString(value, withWriterContext());
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clz) {
    return JSON.parseObject(payload, clz, withReaderContext());
  }

  private JSONReader.Context withReaderContext() {
    JSONReader.Context ctx = JSONFactory.createReadContext(
        builder.readerProvider,
        builder.getReaderFeatures()
    );
    ctx.config(builder.getFilters());
    return ctx;
  }

  private Context withWriterContext() {
    Context ctx = JSONFactory.createWriteContext(
        builder.writerProvider,
        builder.getWriterFeatures()
    );
    ctx.configFilter(builder.getFilters());
    return ctx;
  }


  public static class Builder {

    private final ObjectReaderProvider readerProvider;
    private final ObjectWriterProvider writerProvider;
    private final List<Filter> filters = new ArrayList<>();
    private final List<JSONReader.Feature> readerFeatures = new ArrayList<>();
    private final List<JSONWriter.Feature> writerFeatures = new ArrayList<>();

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
      writerFeatures.addAll(Arrays.asList(features));
      return this;
    }

    public Builder config(JSONReader.Feature... features) {
      readerFeatures.addAll(Arrays.asList(features));
      return this;
    }

    public Builder addFilters(Filter... filters) {
      this.filters.addAll(Arrays.asList(filters));
      return this;
    }

    private Filter[] getFilters() {
      return filters.toArray(new Filter[0]);
    }

    public CarbonSerializer build() {
      return new CarbonFastjsonSerializer(this);
    }

    public Feature[] getWriterFeatures() {
      return writerFeatures.toArray(new Feature[0]);
    }

    public JSONReader.Feature[] getReaderFeatures() {
      return readerFeatures.toArray(new JSONReader.Feature[0]);
    }
  }
}