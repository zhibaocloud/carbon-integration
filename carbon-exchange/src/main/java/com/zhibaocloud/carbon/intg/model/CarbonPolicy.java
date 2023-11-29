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
import com.zhibaocloud.carbon.intg.types.CarbonPayIntv;
import com.zhibaocloud.carbon.intg.types.CarbonPayType;
import com.zhibaocloud.carbon.intg.types.CarbonPolicyStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 推送/接收承保保单数据模型
 *
 * @author jun
 */
@Schema(title = "承保保单数据模型")
public class CarbonPolicy implements CarbonIdentifier {


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
   * 订单号
   */
  @Schema(title = "订单号")
  private String orderNo;


  /**
   * 外部订单号
   */
  @Schema(title = "外部订单号", description = "用于中介公司自行开发的投保订单标识符，回传数据进行匹配更新状态")
  private String extOrderNo;


  /**
   * 原保单号
   */
  @Schema(title = "原保单号", description = "转保/续保且保单号不同的情况下传递")
  private String previousPolicyNo;


  /**
   * 原投保单号
   */
  @Schema(title = "原投保单号", description = "转保/续保且投保单号不同的情况下传递")
  private String previousProposalNo;


  /**
   * 管理机构
   */
  @Schema(title = "管理机构", description = "保险公司分公司管理机构、或接单机构编码")
  private String manageCom;


  /**
   * 管理机构名称
   */
  @Schema(title = "管理机构名称", description = "保险公司分公司管理机构、或接单机构名称")
  private String manageComName;


  /**
   * 中介机构编码
   */
  @Schema(title = "中介机构编码", description = "一般指中介机构在保险公司销管系统中的编码")
  private String agentCom;


  /**
   * 中介机构名称
   */
  @Schema(title = "中介机构名称", description = "一般指中介机构在保险公司销管系统中的机构名称")
  private String agentComName;


  /**
   * 产品编码
   */
  @Schema(title = "产品编码", description = "有些保险产品趸交、期交的险种编码不同，在这里需要使用固定的产品编码", requiredMode = RequiredMode.REQUIRED)
  private String productNo;


  /**
   * 产品名称
   */
  @Schema(title = "产品名称", description = "主险产品名称，需要和在条款中使用的名称保持一致", requiredMode = RequiredMode.REQUIRED)
  private String productName;


  /**
   * 保费
   */
  @Schema(title = "保费", description = "首期合同保费", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal premium;


  /**
   * 保额
   */
  @Schema(title = "保额", description = "首期合同保额", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal amount;


  /**
   * 电子保单下载地址
   */
  @Schema(title = "电子保单下载地址")
  private String ePolicyUrl;


  /**
   * 交费间隔
   */
  @Schema(title = "交费间隔", description = "同交费频率")
  private CarbonPayIntv payIntv;


  /**
   * 支付方式
   */
  @Schema(title = "支付方式")
  private CarbonPayType payType;


  /**
   * 投保时间
   */
  @Schema(title = "投保时间", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime applyTime;


  /**
   * 首期交费时间
   */
  @Schema(title = "首期交费时间", description = "同支付时间", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime payTime;


  /**
   * 签单时间
   */
  @Schema(title = "签单时间", description = "同承保时间", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime signTime;


  /**
   * 生效时间
   */
  @Schema(title = "生效时间", requiredMode = RequiredMode.REQUIRED)
  private LocalDateTime effectiveTime;


  /**
   * 失效时间
   */
  @Schema(title = "失效时间", description = "保终身时不需要传递")
  private LocalDateTime expirationTime;


  /**
   * 回执签收时间
   */
  @Schema(title = "回执签收时间", description = "客户（投保人）签收时间")
  private LocalDateTime receiptSignTime;


  /**
   * 回执录入时间
   */
  @Schema(title = "回执录入时间", description = "回执回销日期，或保险公司收到回执日期")
  private LocalDateTime receiptEnteredTime;


  /**
   * 回访时间
   */
  @Schema(title = "回访时间", description = "一般指回访成功日期")
  private LocalDateTime rtnCallTime;


  /**
   * 回访成功标识
   */
  @Schema(title = "回访成功标识", description = "只有在有回访时间时才会判断回访成功标识")
  private Boolean rtnCallSuccess;


  /**
   * 回访失败原因
   */
  @Schema(title = "回访失败原因", description = "只有在有回访成功标识为false时才会使用次字段")
  private String rtnCallFailedReason;


  /**
   * 保单状态
   */
  @Schema(title = "保单状态")
  private CarbonPolicyStatus status;


  /**
   * 扩展字段
   */
  @Schema(title = "扩展字段", description = "在投保时传递额外的参数，数据推送时会将这些扩展参数原样返回")
  private Map<String, String> ext;


  /**
   * 代理人信息
   */
  @Schema(title = "代理人信息", requiredMode = RequiredMode.REQUIRED)
  private CarbonAgent agent;


  /**
   * 投保人信息
   */
  @Schema(title = "投保人信息", requiredMode = RequiredMode.REQUIRED)
  private CarbonApplicant applicant;


  /**
   * 被保人信息
   */
  @Schema(title = "被保人信息", requiredMode = RequiredMode.REQUIRED)
  private List<CarbonInsured> insureds;


  /**
   * 受益人信息
   */
  @Schema(title = "受益人信息", description = "如果没有受益人信息，表示法定受益人")
  private List<CarbonBeneficiary> bnfs;


  /**
   * 险种信息
   */
  @Schema(title = "险种信息", requiredMode = RequiredMode.REQUIRED)
  private List<CarbonRisk> risks;

  public CarbonPolicy() {
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

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public String getExtOrderNo() {
    return extOrderNo;
  }

  public void setExtOrderNo(String extOrderNo) {
    this.extOrderNo = extOrderNo;
  }

  public String getPreviousPolicyNo() {
    return previousPolicyNo;
  }

  public void setPreviousPolicyNo(String previousPolicyNo) {
    this.previousPolicyNo = previousPolicyNo;
  }

  public String getPreviousProposalNo() {
    return previousProposalNo;
  }

  public void setPreviousProposalNo(String previousProposalNo) {
    this.previousProposalNo = previousProposalNo;
  }

  public String getManageCom() {
    return manageCom;
  }

  public void setManageCom(String manageCom) {
    this.manageCom = manageCom;
  }

  public String getManageComName() {
    return manageComName;
  }

  public void setManageComName(String manageComName) {
    this.manageComName = manageComName;
  }

  public String getAgentCom() {
    return agentCom;
  }

  public void setAgentCom(String agentCom) {
    this.agentCom = agentCom;
  }

  public String getAgentComName() {
    return agentComName;
  }

  public void setAgentComName(String agentComName) {
    this.agentComName = agentComName;
  }

  public String getProductNo() {
    return productNo;
  }

  public void setProductNo(String productNo) {
    this.productNo = productNo;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public BigDecimal getPremium() {
    return premium;
  }

  public void setPremium(BigDecimal premium) {
    this.premium = premium;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getEPolicyUrl() {
    return ePolicyUrl;
  }

  public void setEPolicyUrl(String ePolicyUrl) {
    this.ePolicyUrl = ePolicyUrl;
  }

  public CarbonPayIntv getPayIntv() {
    return payIntv;
  }

  public void setPayIntv(CarbonPayIntv payIntv) {
    this.payIntv = payIntv;
  }

  public CarbonPayType getPayType() {
    return payType;
  }

  public void setPayType(CarbonPayType payType) {
    this.payType = payType;
  }

  public LocalDateTime getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(LocalDateTime applyTime) {
    this.applyTime = applyTime;
  }

  public LocalDateTime getPayTime() {
    return payTime;
  }

  public void setPayTime(LocalDateTime payTime) {
    this.payTime = payTime;
  }

  public LocalDateTime getSignTime() {
    return signTime;
  }

  public void setSignTime(LocalDateTime signTime) {
    this.signTime = signTime;
  }

  public LocalDateTime getEffectiveTime() {
    return effectiveTime;
  }

  public void setEffectiveTime(LocalDateTime effectiveTime) {
    this.effectiveTime = effectiveTime;
  }

  public LocalDateTime getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(LocalDateTime expirationTime) {
    this.expirationTime = expirationTime;
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

  public CarbonPolicyStatus getStatus() {
    return status;
  }

  public void setStatus(CarbonPolicyStatus status) {
    this.status = status;
  }

  public Map<String, String> getExt() {
    return ext;
  }

  public void setExt(Map<String, String> ext) {
    this.ext = ext;
  }

  public CarbonAgent getAgent() {
    return agent;
  }

  public void setAgent(CarbonAgent agent) {
    this.agent = agent;
  }

  public CarbonApplicant getApplicant() {
    return applicant;
  }

  public void setApplicant(CarbonApplicant applicant) {
    this.applicant = applicant;
  }

  public List<CarbonInsured> getInsureds() {
    return insureds;
  }

  public void setInsureds(List<CarbonInsured> insureds) {
    this.insureds = insureds;
  }

  public List<CarbonBeneficiary> getBnfs() {
    return bnfs;
  }

  public void setBnfs(List<CarbonBeneficiary> bnfs) {
    this.bnfs = bnfs;
  }

  public List<CarbonRisk> getRisks() {
    return risks;
  }

  public void setRisks(List<CarbonRisk> risks) {
    this.risks = risks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarbonPolicy that = (CarbonPolicy) o;
    return company == that.company && Objects.equals(policyNo, that.policyNo) && Objects.equals(proposalNo, that.proposalNo) && Objects.equals(prtNo, that.prtNo) && Objects.equals(orderNo, that.orderNo) && Objects.equals(extOrderNo, that.extOrderNo) && Objects.equals(previousPolicyNo, that.previousPolicyNo) && Objects.equals(previousProposalNo, that.previousProposalNo) && Objects.equals(manageCom, that.manageCom) && Objects.equals(manageComName, that.manageComName) && Objects.equals(agentCom, that.agentCom) && Objects.equals(agentComName, that.agentComName) && Objects.equals(productNo, that.productNo) && Objects.equals(productName, that.productName) && Objects.equals(premium, that.premium) && Objects.equals(amount, that.amount) && Objects.equals(ePolicyUrl, that.ePolicyUrl) && payIntv == that.payIntv && payType == that.payType && Objects.equals(applyTime, that.applyTime) && Objects.equals(payTime, that.payTime) && Objects.equals(signTime, that.signTime) && Objects.equals(effectiveTime, that.effectiveTime) && Objects.equals(expirationTime, that.expirationTime) && Objects.equals(receiptSignTime, that.receiptSignTime) && Objects.equals(receiptEnteredTime, that.receiptEnteredTime) && Objects.equals(rtnCallTime, that.rtnCallTime) && Objects.equals(rtnCallSuccess, that.rtnCallSuccess) && Objects.equals(rtnCallFailedReason, that.rtnCallFailedReason) && status == that.status && Objects.equals(ext, that.ext) && Objects.equals(agent, that.agent) && Objects.equals(applicant, that.applicant) && Objects.equals(insureds, that.insureds) && Objects.equals(bnfs, that.bnfs) && Objects.equals(risks, that.risks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, policyNo, proposalNo, prtNo, orderNo, extOrderNo, previousPolicyNo, previousProposalNo, manageCom, manageComName, agentCom, agentComName, productNo, productName, premium, amount, ePolicyUrl, payIntv, payType, applyTime, payTime, signTime, effectiveTime, expirationTime, receiptSignTime, receiptEnteredTime, rtnCallTime, rtnCallSuccess, rtnCallFailedReason, status, ext, agent, applicant, insureds, bnfs, risks);
  }

  @Override
  public String toString() {
    return "CarbonPolicy{" +
            "company=" + company +
            ", policyNo='" + policyNo + '\'' +
            ", proposalNo='" + proposalNo + '\'' +
            ", prtNo='" + prtNo + '\'' +
            ", orderNo='" + orderNo + '\'' +
            ", extOrderNo='" + extOrderNo + '\'' +
            ", previousPolicyNo='" + previousPolicyNo + '\'' +
            ", previousProposalNo='" + previousProposalNo + '\'' +
            ", manageCom='" + manageCom + '\'' +
            ", manageComName='" + manageComName + '\'' +
            ", agentCom='" + agentCom + '\'' +
            ", agentComName='" + agentComName + '\'' +
            ", productNo='" + productNo + '\'' +
            ", productName='" + productName + '\'' +
            ", premium=" + premium +
            ", amount=" + amount +
            ", ePolicyUrl='" + ePolicyUrl + '\'' +
            ", payIntv=" + payIntv +
            ", payType=" + payType +
            ", applyTime=" + applyTime +
            ", payTime=" + payTime +
            ", signTime=" + signTime +
            ", effectiveTime=" + effectiveTime +
            ", expirationTime=" + expirationTime +
            ", receiptSignTime=" + receiptSignTime +
            ", receiptEnteredTime=" + receiptEnteredTime +
            ", rtnCallTime=" + rtnCallTime +
            ", rtnCallSuccess=" + rtnCallSuccess +
            ", rtnCallFailedReason='" + rtnCallFailedReason + '\'' +
            ", status=" + status +
            ", ext=" + ext +
            ", agent=" + agent +
            ", applicant=" + applicant +
            ", insureds=" + insureds +
            ", bnfs=" + bnfs +
            ", risks=" + risks +
            '}';
  }
}
