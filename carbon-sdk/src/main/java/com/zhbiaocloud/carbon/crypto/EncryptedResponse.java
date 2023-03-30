/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.crypto;

import com.zhbiaocloud.carbon.Version;
import java.util.UUID;
import lombok.Data;

/**
 * 加密后的报文响应
 *
 * @author jun
 */
@Data
public class EncryptedResponse {

  /**
   * 发送请求时的requestId，原样返回
   */
  private UUID requestId;

  private String sign;

  private String payload;

  private Version version = Version.CURRENT;
}
