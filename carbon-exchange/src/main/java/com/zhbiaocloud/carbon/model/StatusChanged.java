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

package com.zhbiaocloud.carbon.model;

import com.zhbiaocloud.carbon.model.type.CompanyType;
import com.zhbiaocloud.carbon.model.type.PolicyStatus;
import com.zhbiaocloud.carbon.model.type.TerminationReason;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Schema(title = "保单状态变化")
public class StatusChanged {

  @Schema(title = "保险公司", description = "保险公司编码/名称", requiredMode = RequiredMode.REQUIRED)
  private CompanyType company;

  @Schema(title = "保单号", description = "保单唯一标识符，可用于去重判断", requiredMode = RequiredMode.REQUIRED)
  private String policyNo;

  @Schema(title = "保单状态", description = "保单状态变化后的状态")
  private PolicyStatus status;

  @Schema(title = "保单中止时间")
  private LocalDateTime suspendTime;

  @Schema(title = "保单效力恢复时间")
  private LocalDateTime recoverTime;

  @Schema(title = "保单终止时间")
  private LocalDateTime terminationTime;

  @Schema(title = "保单终止原因")
  private TerminationReason terminationReason;
}
