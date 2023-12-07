package com.zhibaocloud.carbon.intg.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import java.io.IOException;

/**
 * @author yangtuo
 */
public class CarbonJacksonSerializer implements CarbonSerializer {

  private final ObjectMapper om;

  public CarbonJacksonSerializer(ObjectMapper om) {
    this.om = om;
  }

  @Override
  public String serialize(Object value) throws IOException {
    return om.writeValueAsString(value);
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clz) throws IOException {
    return om.readValue(payload, clz);
  }
}
