/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求报文
 *
 * @param <T> 推送的数据内容
 * @author jun
 */
@Getter
@AllArgsConstructor
public class CarbonRequest<T> {

  /**
   * 数据类型，会推送至不同的数据接口
   */
  private String type;

  private T data;

}
