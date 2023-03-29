/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

/**
 * 接收方返回的错误消息
 *
 * @author jun
 */
public class MessageException extends CarbonException {

  public MessageException(String message) {
    super(message);
  }
}
