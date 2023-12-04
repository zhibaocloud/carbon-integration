/*
 * Copyright (c) 2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhibaocloud.carbon.intg.crypto;

import com.zhibaocloud.carbon.intg.CarbonMessageType;
import com.zhibaocloud.carbon.intg.CarbonVersion;

import java.util.Objects;
import java.util.UUID;

/**
 * 加密后的报文请求
 *
 * @author jun
 */
public class CarbonEncryptedRequest {

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

  public CarbonEncryptedRequest() {
  }

  public CarbonVersion getVersion() {
    return version;
  }

  public void setVersion(CarbonVersion version) {
    this.version = version;
  }

  public UUID getRequestId() {
    return requestId;
  }

  public void setRequestId(UUID requestId) {
    this.requestId = requestId;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getTenant() {
    return tenant;
  }

  public void setTenant(String tenant) {
    this.tenant = tenant;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public CarbonMessageType getType() {
    return type;
  }

  public void setType(CarbonMessageType type) {
    this.type = type;
  }

}
