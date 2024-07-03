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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializerFactory;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class VersionTest {

  private final CarbonSerializerFactory factory = new CarbonJacksonSerializerFactory();

  @Test
  void testVersionMatch() throws IOException {
    CarbonSerializer mapper = factory.create(new SerializationConfiguration());
    UUID requestId = UUID.fromString("4d1ec672-f1ed-4988-99d7-3228b4ebfeaa");
    CarbonEncryptedRequest request = new CarbonEncryptedRequest();
    request.setRequestId(requestId);

    String content = mapper.serialize(request);

    assertThat(content).isEqualTo(
        "{\"requestId\":\"4d1ec672-f1ed-4988-99d7-3228b4ebfeaa\",\"version\":\"1.4.0\"}");

    CarbonVersion current = CarbonVersion.CURRENT;
    CarbonEncryptedRequest restored = mapper.deserialize(content, CarbonEncryptedRequest.class);
    assertThat(restored.getVersion().getMajor()).isEqualTo(current.getMajor());
  }

  @Test
  void testVersionSerialization() throws IOException {
    ObjectMapper om = new ObjectMapper();
    om.setSerializationInclusion(Include.NON_NULL);

    CarbonEncryptedResponse response = new CarbonEncryptedResponse();
    String serializedResponse = om.writeValueAsString(response);

    CarbonSerializer mapper = factory.create(new SerializationConfiguration());
    String mapperResponseJson = mapper.serialize(response);

    assertThat(mapperResponseJson).isEqualTo(serializedResponse);
  }
}
