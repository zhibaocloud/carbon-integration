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

import com.zhibaocloud.carbon.intg.types.CarbonCompanyType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 推送/接收回执数据模型
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@Schema(title = "回执数据")
public class CarbonReceipt implements CarbonIdentifier {

  /**
   * 保险公司
   */
  @Schema(title = "保险公司", description = "保险公司编码/名称", requiredMode = RequiredMode.REQUIRED)
  private CarbonCompanyType company;

  /**
   * 保单号
   */
  @Schema(title = "保单号", description = "保单唯一标识符，可用于去重判断", requiredMode = RequiredMode.REQUIRED)
  private String policyNo;

  /**
   * 投保单号
   */
  @Schema(title = "投保单号")
  private String proposalNo;

  /**
   * 印刷号
   */
  @Schema(title = "印刷号")
  private String prtNo;

  /**
   * 回执签收时间
   */
  @Schema(title = "回执签收时间", description = "客户（投保人）签收时间", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime receiptSignTime;

  /**
   * 回执录入时间
   */
  @Schema(title = "回执录入时间", description = "回执回销日期，或保险公司收到回执日期", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime receiptEnteredTime;

}
