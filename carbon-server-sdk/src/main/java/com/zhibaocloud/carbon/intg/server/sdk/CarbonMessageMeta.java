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

package com.zhibaocloud.carbon.intg.server.sdk;

import com.zhibaocloud.carbon.intg.CarbonMessageType;
import java.util.UUID;

/**
 * 元数据信息，用于标记数据的来源，接收方(租户)等
 *
 * @author jun
 */
public class CarbonMessageMeta {

  /**
   * 请求 ID，可用于重试去重
   */
  private final UUID requestId;

  /**
   * 消息类型
   */
  private final CarbonMessageType type;

  /**
   * 租户标识
   */
  private final String tenant;

  public UUID getRequestId() {
    return requestId;
  }

  public CarbonMessageType getType() {
    return type;
  }

  public String getTenant() {
    return tenant;
  }

  public CarbonMessageMeta(UUID requestId, CarbonMessageType type, String tenant) {
    this.requestId = requestId;
    this.type = type;
    this.tenant = tenant;
  }
}
