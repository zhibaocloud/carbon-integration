package com.zhibaocloud.carbon.intg.serializer;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yangtuo
 */
@Getter
@Setter
public class SerializationConfiguration {

  /**
   * 是否脱敏
   */
  private Boolean desensitization = false;

  /**
   * 是否忽略未知属性
   */
  private Boolean ignoreUnknownProperties = true;
}
