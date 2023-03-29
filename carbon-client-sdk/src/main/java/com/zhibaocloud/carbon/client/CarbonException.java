/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

/**
 * 与智保云投保通道的业务异常
 *
 * @author jun
 */
public class CarbonException extends RuntimeException {

  public CarbonException(String message) {
    super(message);
  }

  public CarbonException(String message, Throwable cause) {
    super(message, cause);
  }
}
