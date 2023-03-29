/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 承保保单数据模型
 *
 * @author jun
 */
@Data
@Schema(title = "承保保单数据模型")
public class Policy {

  @Schema(title = "保单号", description = "保单唯一标识符，会用于去重判断")
  private String policyNo;

  @Schema(title = "投保单号")
  private String proposalNo;

  @Schema(title = "印刷号")
  private String prtNo;

  @Schema(title = "订单号")
  private String orderNo;

  @Schema(title = "外部订单号", description = "用于中介公司自行开发的投保订单标识符，回传数据进行匹配更新状态")
  private String extOrderNo;

  @Schema(title = "原保单号", description = "转保/续保且保单号不同的情况下传递")
  private String previousPolicyNo;

  @Schema(title = "原投保单号", description = "转保/续保且投保单号不同的情况下传递")
  private String previousProposalNo;

  @Schema(title = "管理机构", description = "保险公司分公司管理机构、或接单机构编码")
  private String manageCom;

  @Schema(title = "管理机构名称", description = "保险公司分公司管理机构、或接单机构名称")
  private String manageComName;

  @Schema(title = "中介机构编码", description = "一般指中介机构在保险公司销管系统中的编码")
  private String agentCom;

  @Schema(title = "中介机构名称", description = "一般指中介机构在保险公司销管系统中的机构名称")
  private String agentComName;

  @Schema(title = "保费", description = "首期合同保费")
  private BigDecimal premium;

  @Schema(title = "保额", description = "首期合同保额")
  private BigDecimal amount;

  @Schema(title = "投保时间")
  private LocalDateTime applyTime;

  @Schema(title = "首期交费时间", description = "同支付时间")
  private LocalDateTime payTime;

  @Schema(title = "签单时间", description = "同承保时间")
  private LocalDateTime signTime;
}
