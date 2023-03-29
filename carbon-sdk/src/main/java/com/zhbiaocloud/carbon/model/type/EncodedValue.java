/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

/**
 * 枚举类型的接口
 *
 * @author jun
 */
public interface EncodedValue {

  /**
   * 在数据库、或外部系统中存储的码值
   *
   * @return 码值
   */
  String getValue();

  /**
   * 枚举描述
   *
   * @return 枚举的描述文字
   */
  String getDescription();
}
