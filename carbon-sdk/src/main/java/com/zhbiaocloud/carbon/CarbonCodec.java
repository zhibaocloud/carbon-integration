/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.model.Policy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarbonCodec {

  private final ObjectMapper mapper;

  public Policy decode(String payload) {
    return new Policy();
  }
}
