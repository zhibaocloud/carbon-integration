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

  /**
   * 被保人编号
   */
  @Schema(title = "被保人编号", description = "在多被保人数据中用于标识和被保人的关系")
  private String insuredNo;

  /**
   * 主附险性质
   */
  @Schema(title = "主附险性质", description = "“双主险”基本采用年金险/两全险+万能险的组合，需要将万能险标记为附加险", requiredMode = RequiredMode.REQUIRED)
  private CarbonMainRiskFlag flag;

  /**
   * 险种编码
   */
  @Schema(title = "险种编码", requiredMode = RequiredMode.REQUIRED)
  private String riskCode;

  /**
   * 险种名称
   */
  @Schema(title = "险种名称", requiredMode = RequiredMode.REQUIRED)
  private String riskName;

  /**
   * 保险计划编码
   */
  @Schema(title = "保险计划编码")
  private String planCode;

  /**
   * 保险计划名称
   */
  @Schema(title = "保险计划名称")
  private String planName;

  /**
   * 保费
   */
  @Schema(title = "保费", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal premium;

  /**
   * 保额
   */
  @Schema(title = "保额")
  private BigDecimal amount;

  /**
   * 交费时间
   */
  @Schema(title = "交费时间")
  private LocalDateTime payTime;

  /**
   * 交至时间
   */
  @Schema(title = "交至时间")
  private LocalDateTime payToTime;

  /**
   * 生效时间
   */
  @Schema(title = "生效时间")
  private LocalDateTime effectiveTime;

  /**
   * 失效时间
   */
  @Schema(title = "失效时间")
  private LocalDateTime expirationTime;

  /**
   * 险种状态
   */
  @Schema(title = "险种状态")
  private CarbonPolicyStatus status;

  /**
   * 保险期间
   */
  @Schema(title = "保险期间")
  private CarbonInsuredPeriod insuredPeriod;

  /**
   * 交费期间
   */
  @Schema(title = "交费期间")
  private CarbonPaymentPeriod paymentPeriod;
}
