/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import com.zhbiaocloud.carbon.model.type.PolicyStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Risk {

  @NotBlank
  @Schema(title = "险种编码", requiredMode = RequiredMode.REQUIRED)
  private String riskCode;

  @NotBlank
  @Schema(title = "险种名称", requiredMode = RequiredMode.REQUIRED)
  private String riskName;

  @Schema(title = "保险计划编码")
  private String planCode;

  @Schema(title = "保险计划名称")
  private String planName;

  @NotNull
  @Schema(title = "保费", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal premium;

  @NotNull
  @Schema(title = "保额", requiredMode = RequiredMode.REQUIRED)
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
  private PolicyStatus status;
}
