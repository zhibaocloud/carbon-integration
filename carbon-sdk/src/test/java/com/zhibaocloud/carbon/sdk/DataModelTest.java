/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.model.type.PayIntv;
import com.zhbiaocloud.carbon.model.Policy;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class DataModelTest {

  private final ObjectMapper mapper = new CarbonMapperFactory().create();

  @Test
  void testPolicyModel() throws IOException {
    Policy policy = new Policy();
    policy.setPolicyNo("123");
    policy.setPayIntv(PayIntv.SINGLE);

    String json = mapper.writeValueAsString(policy);
    System.out.println(json);

    Policy restored = mapper.readValue(json, Policy.class);
    assertThat(restored).isEqualTo(policy);
    assertThat(restored).hasSameHashCodeAs(policy);
    assertThat(restored.getPayIntv()).isEqualTo(PayIntv.SINGLE);
  }
}
