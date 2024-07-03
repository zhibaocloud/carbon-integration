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

package com.zhibaocloud.carbon.intg.jackson;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhibaocloud.carbon.intg.model.EnumUtils;
import com.zhibaocloud.carbon.intg.types.CarbonGenderType;
import com.zhibaocloud.carbon.intg.types.CarbonNationType;
import org.junit.jupiter.api.Test;

class DataModelTest {


  @Test
  void testEnumTools() {
    CarbonGenderType gender = EnumUtils.fromValue(CarbonGenderType.class, "1");
    assertThat(gender).isEqualTo(CarbonGenderType.MALE);
    CarbonGenderType unknown = EnumUtils.fromValue(CarbonGenderType.class, "99");
    assertThat(unknown).isNull();

    CarbonNationType nation = EnumUtils.fromValue(CarbonNationType.class, "CHN");
    assertThat(nation).isEqualTo(CarbonNationType.CHN);
  }
}
