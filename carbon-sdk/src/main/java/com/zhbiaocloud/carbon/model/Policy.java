/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 承保保单数据模型
 *
 * @author jun
 */
@Data
@Schema(title = "承保保单数据模型")
public class Policy {

  @Schema(title = "保单号")
  private String policyNo;

  @Schema(title = "投保单号")
  private String proposalNo;

  @Schema(title = "印刷号")
  private String prtNo;

  @Schema(title = "订单号")
  private String orderNo;

}
