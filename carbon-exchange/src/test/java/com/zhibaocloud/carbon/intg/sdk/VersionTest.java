/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.intg.CarbonMapperFactory;
import com.zhbiaocloud.carbon.intg.CarbonVersion;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedRequest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class VersionTest {

  private final CarbonMapperFactory factory = new CarbonMapperFactory(false);

  @Test
  void testVersionMatch() throws JsonProcessingException {
    ObjectMapper mapper = factory.create();
    UUID requestId = UUID.fromString("4d1ec672-f1ed-4988-99d7-3228b4ebfeaa");
    EncryptedRequest request = new EncryptedRequest();
    request.setRequestId(requestId);

    String content = mapper.writeValueAsString(request);

    assertThat(content).isEqualTo(
        "{\"requestId\":\"4d1ec672-f1ed-4988-99d7-3228b4ebfeaa\",\"version\":\"1.0.0\"}");

    CarbonVersion current = CarbonVersion.CURRENT;
    EncryptedRequest restored = mapper.readValue(content, EncryptedRequest.class);
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
