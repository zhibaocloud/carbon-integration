package com.zhibaocloud.carbon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class CarbonJacksonSerializer implements CarbonSerializer {

  private final ObjectMapper om;

  @Override
  public String serialize(Object value) throws IOException {
    return om.writeValueAsString(value);
  }

  @Override
  public <T> T deserialize(String payload, Class<T> clz) throws IOException {
    return om.readValue(payload, clz);
  }
}
