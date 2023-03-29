/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接入方式
 *
 * @author jun
 */
@Getter
@AllArgsConstructor
public enum ClientMode {

  /**
   * 以"协议"为单位进行对接 即：一次只能接入一家中介公司、保险公司
   */
  AGREEMENT("a"),

  /**
   * 批量接入，一次性接入所有的中介公司
   */
  BATCH("b");

  private final String value;
}
