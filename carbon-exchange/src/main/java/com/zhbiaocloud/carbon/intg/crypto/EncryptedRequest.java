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
import com.zhbiaocloud.carbon.intg.CarbonMessageType;
import java.util.UUID;
import lombok.Data;

/**
 * 加密后的报文请求
 *
 * @author jun
 */
@Data
public class EncryptedRequest {

  /**
   * SDK 版本，用于判断兼容性
   */
  private CarbonVersion version = CarbonVersion.CURRENT;

  /**
   * 用于对每个请求进行唯一标识。该标识会在响应报文中回复
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

  /**
   * 加密数据类型，用于反序列化时识别数据类型
   */
  private CarbonMessageType type;
}
