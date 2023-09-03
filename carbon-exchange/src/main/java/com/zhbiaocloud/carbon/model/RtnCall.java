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

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Schema(title = "回访数据")
public class RtnCall {

  @Schema(title = "保单号", description = "保单唯一标识符，会用于去重判断", requiredMode = RequiredMode.REQUIRED)
  private String policyNo;

  @Schema(title = "投保单号")
  private String proposalNo;

  @Schema(title = "印刷号")
  private String prtNo;

  @Schema(title = "中介机构编码", description = "一般指中介机构在保险公司销管系统中的编码")
  private String agentCom;

  @Schema(title = "中介机构名称", description = "一般指中介机构在保险公司销管系统中的机构名称")
  private String agentComName;

  @Schema(title = "管理机构", description = "保险公司分公司管理机构、或接单机构编码")
  private String manageCom;

  @Schema(title = "管理机构名称", description = "保险公司分公司管理机构、或接单机构名称")
  private String manageComName;

  @Schema(title = "回访时间", description = "一般指回访成功日期", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime rtnCallTime;

  @Schema(title = "回访成功标识", description = "只有在有回访时间时才会判断回访成功标识", requiredMode = RequiredMode.REQUIRED)
  private Boolean rtnCallSuccess;

  @Schema(title = "回访失败原因", description = "只有在有回访成功标识为false时才会使用次字段")
  private String rtnCallFailedReason;
}
