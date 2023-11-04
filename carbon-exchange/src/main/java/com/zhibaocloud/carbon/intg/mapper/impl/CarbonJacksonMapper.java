package com.zhibaocloud.carbon.intg.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhibaocloud.carbon.intg.mapper.CarbonMapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

/**
 * @author yangtuo
 */
@RequiredArgsConstructor
public class CarbonJacksonMapper implements CarbonMapper {

  private final ObjectMapper om;

  @Override
  public String writeValueAsString(Object value) throws IOException {
    return om.writeValueAsString(value);
  }

  @Override
  public <T> T readValue(String payload, Class<T> clz) throws IOException {
    return om.readValue(payload, clz);
  }
}
