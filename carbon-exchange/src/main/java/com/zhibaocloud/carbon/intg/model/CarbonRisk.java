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

package com.zhibaocloud.carbon.intg.model;

import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonMainRiskFlag;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPolicyStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 险种信息
 *
 * @author jun
 */
@Data
@Schema(title = "承保险种信息")
public class CarbonRisk {

  @Schema(title = "被保人编号", description = "在多被保人数据中用于标识和被保人的关系")
  private String insuredNo;

  @Schema(title = "主附险性质", description = "“双主险”基本采用年金险/两全险+万能险的组合，需要将万能险标记为附加险", requiredMode = RequiredMode.REQUIRED)
  private CarbonMainRiskFlag flag;

  @Schema(title = "险种编码", requiredMode = RequiredMode.REQUIRED)
  private String riskCode;

  @Schema(title = "险种名称", requiredMode = RequiredMode.REQUIRED)
  private String riskName;

  @Schema(title = "保险计划编码")
  private String planCode;

  @Schema(title = "保险计划名称")
  private String planName;

  @Schema(title = "保费", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal premium;

  @Schema(title = "保额")
  private BigDecimal amount;

  @Schema(title = "交费时间")
  private LocalDateTime payTime;

  @Schema(title = "交至时间")
  private LocalDateTime payToTime;

  @Schema(title = "生效时间")
  private LocalDateTime effectiveTime;

  @Schema(title = "失效时间")
  private LocalDateTime expirationTime;

  @Schema(title = "险种状态")
  private CarbonPolicyStatus status;

  @Schema(title = "保险期间")
  private CarbonInsuredPeriod insuredPeriod;

  @Schema(title = "交费期间")
  private CarbonPaymentPeriod paymentPeriod;
}