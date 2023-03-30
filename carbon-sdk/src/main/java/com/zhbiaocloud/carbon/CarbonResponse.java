/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon;

import lombok.Data;

/**
 * 响应报文
 *
 * @author jun
 */
@Data
public class CarbonResponse {

  /**
   * 是否接收成功
   */
  private boolean success;

  /**
   * 失败原因
   */
  private String message;

}
