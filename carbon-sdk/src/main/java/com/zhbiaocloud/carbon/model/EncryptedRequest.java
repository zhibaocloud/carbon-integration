/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import com.zhbiaocloud.carbon.Version;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 加密后的报文请求
 *
 * @author jun
 */
@Data
public class EncryptedRequest {

  /**
   * 用于对每个请求进行唯一标识。该标识会在响应报文中回复
   */
  private UUID requestId;

  private String sign;

  private String payload;

  private Version version = Version.CURRENT;
}
