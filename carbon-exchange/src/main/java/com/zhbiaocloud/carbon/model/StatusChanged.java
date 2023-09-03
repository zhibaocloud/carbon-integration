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

import com.zhbiaocloud.carbon.model.type.PolicyStatus;
import com.zhbiaocloud.carbon.model.type.TerminationReason;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.Data;

@Data
@Schema(title = "保单状态变化")
public class StatusChanged {

  @Schema(title = "保单状态", description = "保单状态变化后的状态")
  private PolicyStatus status;

  @Schema(title = "保单中止日期")
  private LocalDate suspendDate;

  @Schema(title = "保单效力回复日期")
  private LocalDate recoverDate;

  @Schema(title = "保单终止日期")
  private LocalDate terminationDate;

  @Schema(title = "保单终止原因")
  private TerminationReason terminationReason;
}
