package com.zhibaocloud.carbon.intg.fastjson.modules;

import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriters;
import com.zhibaocloud.carbon.intg.CarbonVersion;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import java.lang.reflect.Type;

public class CarbonObjectWriterModule implements ObjectWriterModule {

  @Override
  public ObjectWriter<?> getObjectWriter(Type objectType, Class objectClass) {
    if (objectType == CarbonVersion.class) {
      return ObjectWriters.ofToString(CarbonVersion::toString);
    } else if (objectType == CarbonInsuredPeriod.class) {
      return ObjectWriters.ofToString(CarbonInsuredPeriod::toString);
    } else if (objectType == CarbonPaymentPeriod.class) {
      return ObjectWriters.ofToString(CarbonPaymentPeriod::toString);
    }
    return null;
  }
}
