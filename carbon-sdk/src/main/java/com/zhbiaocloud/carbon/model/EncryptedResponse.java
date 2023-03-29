/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 加密后的报文响应
 *
 * @author jun
 */
@Data
@AllArgsConstructor
public class EncryptedResponse {

  /**
   * 发送请求时的requestId，原样返回
   */
  private UUID requestId;

  private String sign;

  private String payload;
}
