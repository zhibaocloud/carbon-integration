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
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import java.io.IOException;

public class CarbonFastjsonSerializer implements CarbonSerializer {

  @Override
  public String serialize(Object value) throws IOException {
    return JSON.toJSONString(value);
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clz) throws IOException {
    return JSON.parseObject(payload, clz);
  }
}
