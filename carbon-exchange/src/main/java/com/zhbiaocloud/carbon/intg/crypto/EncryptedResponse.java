/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
 * Carbon Integration SDK is licensed under Mulan PSL v2.
 *
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at: http://license.coscl.org.cn/MulanPSL2
 *
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.zhbiaocloud.carbon.intg.crypto;

import com.zhbiaocloud.carbon.intg.CarbonVersion;
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
   * SDK 版本，用于判断兼容性
   */
  private CarbonVersion version = CarbonVersion.CURRENT;

  /**
   * 发送请求时的requestId，原样返回
   */
  private UUID requestId;

  /**
   * 签名，用于校验报文的完整性
   */
  private String sign;

  /**
   * 租户标识符
   */
  private String tenant;

  /**
   * 加密报文信息
   */
  private String payload;
}
