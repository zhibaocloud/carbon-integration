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

package com.zhibaocloud.carbon.intg.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhibaocloud.carbon.intg.gson.adapters.CarbonAdapterFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;

public class CarbonGsonSerializerFactory implements CarbonSerializerFactory {

  @Override
  public CarbonSerializer create(SerializationConfiguration config) {
    Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new CarbonAdapterFactory(config))
        .create();
    return new CarbonGsonSerializer(gson);
  }
}
