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

package com.zhibaocloud.carbon.intg.gson.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

public class MapAdapter extends TypeAdapter<Map<Object, Object>> {

  private final TypeAdapter<Object> delegateAdapter;

  public MapAdapter(TypeAdapter<Object> delegateAdapter) {
    this.delegateAdapter = delegateAdapter;
  }


  @Override
  public void write(JsonWriter out, Map<Object, Object> value) throws IOException {
    if (value.isEmpty()) {
      out.nullValue();
    } else {
      delegateAdapter.write(out, value);
    }
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<Object, Object> read(JsonReader in) throws IOException {
    return (Map<Object, Object>) delegateAdapter.read(in);
  }
}