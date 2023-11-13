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

package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import com.zhibaocloud.carbon.intg.CarbonVersion;
import org.junit.jupiter.api.Test;

class VersionTest {

  @Test
  void testCompatible() {
    CarbonVersion newMinorVersion = new CarbonVersion("0.2.0");
    CarbonVersion oldMinorVersion = new CarbonVersion("0.1.0");
    assertThat(newMinorVersion.isCompatible(oldMinorVersion)).isTrue();
    assertThat(oldMinorVersion.isCompatible(newMinorVersion)).isFalse();

    CarbonVersion newMajorVersion = new CarbonVersion("1.0.0");
    CarbonVersion oldMajorVersion = new CarbonVersion("0.9.0");
    assertThat(newMajorVersion.isCompatible(oldMajorVersion)).isFalse();
    assertThat(oldMajorVersion.isCompatible(newMajorVersion)).isFalse();

    CarbonVersion newPatchVersion = new CarbonVersion("0.1.1");
    CarbonVersion oldPatchVersion = new CarbonVersion("0.1.0");
    assertThat(newPatchVersion.isCompatible(oldPatchVersion)).isTrue();
    assertThat(oldPatchVersion.isCompatible(newPatchVersion)).isTrue();

    assertThatThrownBy(() -> new CarbonVersion("0.1")).isInstanceOf(IllegalArgumentException.class);
  }
}
