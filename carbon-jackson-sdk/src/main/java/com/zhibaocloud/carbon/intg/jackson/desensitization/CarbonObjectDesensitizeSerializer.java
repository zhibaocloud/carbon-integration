package com.zhibaocloud.carbon.intg.jackson.desensitization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.zhibaocloud.carbon.intg.desensitization.CarbonDesensitization;
import java.io.IOException;
import lombok.Getter;

/**
 * @author yangtuo
 */
@Getter
public class CarbonObjectDesensitizeSerializer extends StdSerializer<Object> {

  private final CarbonDesensitization<Object> desensitization;

  public CarbonObjectDesensitizeSerializer(CarbonDesensitization<Object> desensitization) {
    super(Object.class);
    this.desensitization = desensitization;
  }


  @Override
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
    CarbonDesensitization<Object> objectDesensitization = getDesensitization();
    gen.writeObject(objectDesensitization.desensitize(value));
  }
}
