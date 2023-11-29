package com.zhibaocloud.carbon.intg.serializer;


/**
 * @author yangtuo
 */
public class SerializationConfiguration {

  /**
   * 是否脱敏
   */
  private Boolean desensitization = false;

  /**
   * 是否忽略未知属性
   */
  private Boolean ignoreUnknownProperties = true;

  public Boolean getDesensitization() {
    return desensitization;
  }

  public void setDesensitization(Boolean desensitization) {
    this.desensitization = desensitization;
  }

  public Boolean getIgnoreUnknownProperties() {
    return ignoreUnknownProperties;
  }

  public void setIgnoreUnknownProperties(Boolean ignoreUnknownProperties) {
    this.ignoreUnknownProperties = ignoreUnknownProperties;
  }
}
