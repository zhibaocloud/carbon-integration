package com.zhibaocloud.carbon.intg.serializer;

import java.util.ServiceLoader;

/**
 * @author yangtuo
 */
public interface CarbonSerializerFactory {

  CarbonSerializer create(SerializationConfiguration config);

  static CarbonSerializerFactory newInstance() {
    ServiceLoader<CarbonSerializerFactory> loader =
        ServiceLoader.load(CarbonSerializerFactory.class);
    return loader.iterator().next();
  }
}
