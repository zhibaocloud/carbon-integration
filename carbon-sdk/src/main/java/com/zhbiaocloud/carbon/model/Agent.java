/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 代理人信息
 *
 * @author jun
 */
@Data
@Schema(title = "代理人信息")
public class Agent {

  @NotBlank
  @Schema(title = "代理人姓名", requiredMode = RequiredMode.REQUIRED)
  private String name;

  @NotBlank
  @Schema(title = "代理人编码", description = "一般指指代理人在保险公司销管系统中的经代工号", requiredMode = RequiredMode.REQUIRED)
  private String code;

  @Schema(title = "代理人中介公司工号", description = "指代理人在中介机构中的内部工号")
  private String extCode;

  @Schema(title = "代理人执业证号")
  private String busiDevCertifNo;
}
