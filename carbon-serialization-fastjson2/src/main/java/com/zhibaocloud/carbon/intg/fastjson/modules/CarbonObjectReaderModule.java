package com.zhibaocloud.carbon.intg.fastjson.modules;

import com.alibaba.fastjson2.modules.ObjectReaderModule;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaders;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.lang.reflect.Type;

public class CarbonObjectReaderModule implements ObjectReaderModule {

  @Override
  public ObjectReader<?> getObjectReader(Type type) {
    if (type == CarbonVersion.class) {
      return ObjectReaders.ofString(CarbonVersion::new);
    } else if (type == CarbonInsuredPeriod.class) {
      return ObjectReaders.ofString(CarbonInsuredPeriod::new);
    } else if (type == CarbonPaymentPeriod.class) {
      return ObjectReaders.ofString(CarbonPaymentPeriod::new);
    }
    return null;
  }
}