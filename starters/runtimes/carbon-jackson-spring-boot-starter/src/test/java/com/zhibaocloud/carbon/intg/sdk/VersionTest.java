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
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.mapper.CarbonMapper;
import com.zhibaocloud.carbon.intg.mapper.impl.DefaultCarbonMapperFactory;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class VersionTest {

  private final DefaultCarbonMapperFactory factory = new DefaultCarbonMapperFactory(false);

  @Test
  void testVersionMatch() throws IOException {
    CarbonMapper mapper = factory.create();
    UUID requestId = UUID.fromString("4d1ec672-f1ed-4988-99d7-3228b4ebfeaa");
    CarbonEncryptedRequest request = new CarbonEncryptedRequest();
    request.setRequestId(requestId);

    String content = mapper.writeValueAsString(request);

    assertThat(content).isEqualTo(
        "{\"requestId\":\"4d1ec672-f1ed-4988-99d7-3228b4ebfeaa\",\"version\":\"1.2.1\"}");

    CarbonVersion current = CarbonVersion.CURRENT;
    CarbonEncryptedRequest restored = mapper.readValue(content, CarbonEncryptedRequest.class);
    assertThat(restored.getVersion()).isEqualTo(current);
  }

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
