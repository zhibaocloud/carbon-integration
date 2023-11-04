package com.zhibaocloud.carbon.intg.mapper;

import java.io.IOException;

/**
 * 序列化抽象接口
 *
 * @author yangtuo
 */
public interface CarbonMapper {

  String writeValueAsString(Object value) throws IOException;

  <T> T readValue(String payload, Class<T> clz) throws IOException;
}
