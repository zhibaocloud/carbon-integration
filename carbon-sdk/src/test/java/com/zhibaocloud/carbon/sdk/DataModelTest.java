/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import com.zhbiaocloud.carbon.model.Policy;
import org.junit.jupiter.api.Test;

class DataModelTest {

  @Test
  void testDataModel() {
    Policy policy = new Policy();
    policy.setPolicyNo("123");
  }
}
