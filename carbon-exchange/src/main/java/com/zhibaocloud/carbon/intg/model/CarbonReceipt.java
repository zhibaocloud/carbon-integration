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
 * 推送/接收回执数据模型
 *
 * @author jun
 */
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

  public CarbonReceipt() {
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

  public LocalDateTime getReceiptSignTime() {
    return receiptSignTime;
  }

  public void setReceiptSignTime(LocalDateTime receiptSignTime) {
    this.receiptSignTime = receiptSignTime;
  }

  public LocalDateTime getReceiptEnteredTime() {
    return receiptEnteredTime;
  }

  public void setReceiptEnteredTime(LocalDateTime receiptEnteredTime) {
    this.receiptEnteredTime = receiptEnteredTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarbonReceipt that = (CarbonReceipt) o;
    return company == that.company && Objects.equals(policyNo, that.policyNo) && Objects.equals(proposalNo, that.proposalNo) && Objects.equals(prtNo, that.prtNo) && Objects.equals(receiptSignTime, that.receiptSignTime) && Objects.equals(receiptEnteredTime, that.receiptEnteredTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, policyNo, proposalNo, prtNo, receiptSignTime, receiptEnteredTime);
  }

  @Override
  public String toString() {
    return "CarbonReceipt{" +
            "company=" + company +
            ", policyNo='" + policyNo + '\'' +
            ", proposalNo='" + proposalNo + '\'' +
            ", prtNo='" + prtNo + '\'' +
            ", receiptSignTime=" + receiptSignTime +
            ", receiptEnteredTime=" + receiptEnteredTime +
            '}';
  }
}
