package com.zhibaocloud.carbon.intg.serializer;

import java.io.IOException;

/**
 * 序列化抽象接口
 *
 * @author yangtuo
 */
public interface CarbonSerializer {

  String serialize(Object value) throws IOException;

  <T> T deserialize(String payload, Class<T> clz) throws IOException;
}
