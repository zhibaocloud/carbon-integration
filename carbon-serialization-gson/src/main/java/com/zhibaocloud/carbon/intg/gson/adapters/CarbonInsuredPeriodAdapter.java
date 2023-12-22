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
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import java.io.IOException;

public class CarbonInsuredPeriodAdapter extends TypeAdapter<CarbonInsuredPeriod> {

  @Override
  public void write(JsonWriter out, CarbonInsuredPeriod value) throws IOException {
    out.value(value.toString());
  }

  @Override
  public CarbonInsuredPeriod read(JsonReader in) throws IOException {
    return new CarbonInsuredPeriod(in.nextString());
  }
}