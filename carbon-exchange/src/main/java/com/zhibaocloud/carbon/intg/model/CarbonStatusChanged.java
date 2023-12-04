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
import com.zhibaocloud.carbon.intg.types.CarbonPolicyStatus;
import com.zhibaocloud.carbon.intg.types.CarbonTerminationReason;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 推送/接收保单状态变化数据模型
 *
 * @author jun
 */
@Schema(title = "保单状态变化")
public class CarbonStatusChanged implements CarbonIdentifier {

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
   * 保单状态
   */
  @Schema(title = "保单状态", description = "保单状态变化后的状态")
  private CarbonPolicyStatus status;

  /**
   * 保单中止时间
   */
  @Schema(title = "保单中止时间")
  private LocalDateTime suspendTime;

  /**
   * 保单效力恢复时间
   */
  @Schema(title = "保单效力恢复时间")
  private LocalDateTime recoverTime;

  /**
   * 保单终止时间
   */
  @Schema(title = "保单终止时间")
  private LocalDateTime terminationTime;

  /**
   * 保单终止原因
   */
  @Schema(title = "保单终止原因")
  private CarbonTerminationReason terminationReason;

  public CarbonStatusChanged() {
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

  public CarbonPolicyStatus getStatus() {
    return status;
  }

  public void setStatus(CarbonPolicyStatus status) {
    this.status = status;
  }

  public LocalDateTime getSuspendTime() {
    return suspendTime;
  }

  public void setSuspendTime(LocalDateTime suspendTime) {
    this.suspendTime = suspendTime;
  }

  public LocalDateTime getRecoverTime() {
    return recoverTime;
  }

  public void setRecoverTime(LocalDateTime recoverTime) {
    this.recoverTime = recoverTime;
  }

  public LocalDateTime getTerminationTime() {
    return terminationTime;
  }

  public void setTerminationTime(LocalDateTime terminationTime) {
    this.terminationTime = terminationTime;
  }

  public CarbonTerminationReason getTerminationReason() {
    return terminationReason;
  }

  public void setTerminationReason(CarbonTerminationReason terminationReason) {
    this.terminationReason = terminationReason;
  }
  @Override
  public String toString() {
    return "CarbonStatusChanged{" +
            "company=" + company +
            ", policyNo='" + policyNo + '\'' +
            ", proposalNo='" + proposalNo + '\'' +
            ", status=" + status +
            ", suspendTime=" + suspendTime +
            ", recoverTime=" + recoverTime +
            ", terminationTime=" + terminationTime +
            ", terminationReason=" + terminationReason +
            '}';
  }
}
