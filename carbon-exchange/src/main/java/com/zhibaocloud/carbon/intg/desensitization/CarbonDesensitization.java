package com.zhibaocloud.carbon.intg.desensitization;

/**
 * @author yangtuo
 */
public interface CarbonDesensitization<T> {

  /**
   * 脱敏
   *
   * @param original 原始数据
   * @return 脱敏后的数据
   */
  T desensitize(T original);

}
