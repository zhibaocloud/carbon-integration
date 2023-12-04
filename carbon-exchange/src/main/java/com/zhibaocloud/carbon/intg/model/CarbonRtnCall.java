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
import java.util.Objects;

/**
 * 推送/接收回访数据模型
 *
 * @author jun
 */
@Schema(title = "回访数据")
public class CarbonRtnCall implements CarbonIdentifier {


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
   * 回访时间
   */
  @Schema(title = "回访时间", description = "一般指回访成功日期", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime rtnCallTime;


  /**
   * 回访成功标识
   */
  @Schema(title = "回访成功标识", description = "只有在有回访时间时才会判断回访成功标识", requiredMode = RequiredMode.REQUIRED)
  private Boolean rtnCallSuccess;


  /**
   * 回访失败原因
   */
  @Schema(title = "回访失败原因", description = "只有在有回访成功标识为false时才会使用次字段")
  private String rtnCallFailedReason;

  public CarbonRtnCall() {
  }

  public CarbonCompanyType getCompany() {
    return company;
  }

  public void setCompany(CarbonCompanyType company) {
    this.company = company;
  }

  public String getPolicyNo() {
    return policyNo;
  }

  public void setPolicyNo(String policyNo) {
    this.policyNo = policyNo;
  }

  public String getProposalNo() {
    return proposalNo;
  }

  public void setProposalNo(String proposalNo) {
    this.proposalNo = proposalNo;
  }

  public String getPrtNo() {
    return prtNo;
  }

  public void setPrtNo(String prtNo) {
    this.prtNo = prtNo;
  }

  public LocalDateTime getRtnCallTime() {
    return rtnCallTime;
  }

  public void setRtnCallTime(LocalDateTime rtnCallTime) {
    this.rtnCallTime = rtnCallTime;
  }

  public Boolean getRtnCallSuccess() {
    return rtnCallSuccess;
  }

  public void setRtnCallSuccess(Boolean rtnCallSuccess) {
    this.rtnCallSuccess = rtnCallSuccess;
  }

  public String getRtnCallFailedReason() {
    return rtnCallFailedReason;
  }

  public void setRtnCallFailedReason(String rtnCallFailedReason) {
    this.rtnCallFailedReason = rtnCallFailedReason;
  }
  @Override
  public String toString() {
    return "CarbonRtnCall{" +
            "company=" + company +
            ", policyNo='" + policyNo + '\'' +
            ", proposalNo='" + proposalNo + '\'' +
            ", prtNo='" + prtNo + '\'' +
            ", rtnCallTime=" + rtnCallTime +
            ", rtnCallSuccess=" + rtnCallSuccess +
            ", rtnCallFailedReason='" + rtnCallFailedReason + '\'' +
            '}';
  }
}
