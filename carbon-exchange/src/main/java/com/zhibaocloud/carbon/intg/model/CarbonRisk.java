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
import java.util.Objects;

/**
 * 险种信息
 *
 * @author jun
 */
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

  public CarbonRisk() {
  }

  public String getInsuredNo() {
    return insuredNo;
  }

  public void setInsuredNo(String insuredNo) {
    this.insuredNo = insuredNo;
  }

  public CarbonMainRiskFlag getFlag() {
    return flag;
  }

  public void setFlag(CarbonMainRiskFlag flag) {
    this.flag = flag;
  }

  public String getRiskCode() {
    return riskCode;
  }

  public void setRiskCode(String riskCode) {
    this.riskCode = riskCode;
  }

  public String getRiskName() {
    return riskName;
  }

  public void setRiskName(String riskName) {
    this.riskName = riskName;
  }

  public String getPlanCode() {
    return planCode;
  }

  public void setPlanCode(String planCode) {
    this.planCode = planCode;
  }

  public String getPlanName() {
    return planName;
  }

  public void setPlanName(String planName) {
    this.planName = planName;
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

  public LocalDateTime getPayTime() {
    return payTime;
  }

  public void setPayTime(LocalDateTime payTime) {
    this.payTime = payTime;
  }

  public LocalDateTime getPayToTime() {
    return payToTime;
  }

  public void setPayToTime(LocalDateTime payToTime) {
    this.payToTime = payToTime;
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

  public CarbonPolicyStatus getStatus() {
    return status;
  }

  public void setStatus(CarbonPolicyStatus status) {
    this.status = status;
  }

  public CarbonInsuredPeriod getInsuredPeriod() {
    return insuredPeriod;
  }

  public void setInsuredPeriod(CarbonInsuredPeriod insuredPeriod) {
    this.insuredPeriod = insuredPeriod;
  }

  public CarbonPaymentPeriod getPaymentPeriod() {
    return paymentPeriod;
  }

  public void setPaymentPeriod(CarbonPaymentPeriod paymentPeriod) {
    this.paymentPeriod = paymentPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CarbonRisk that = (CarbonRisk) o;
    return Objects.equals(insuredNo, that.insuredNo) && flag == that.flag && Objects.equals(riskCode, that.riskCode) && Objects.equals(riskName, that.riskName) && Objects.equals(planCode, that.planCode) && Objects.equals(planName, that.planName) && Objects.equals(premium, that.premium) && Objects.equals(amount, that.amount) && Objects.equals(payTime, that.payTime) && Objects.equals(payToTime, that.payToTime) && Objects.equals(effectiveTime, that.effectiveTime) && Objects.equals(expirationTime, that.expirationTime) && status == that.status && Objects.equals(insuredPeriod, that.insuredPeriod) && Objects.equals(paymentPeriod, that.paymentPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(insuredNo, flag, riskCode, riskName, planCode, planName, premium, amount, payTime, payToTime, effectiveTime, expirationTime, status, insuredPeriod, paymentPeriod);
  }

  @Override
  public String toString() {
    return "CarbonRisk{" +
            "insuredNo='" + insuredNo + '\'' +
            ", flag=" + flag +
            ", riskCode='" + riskCode + '\'' +
            ", riskName='" + riskName + '\'' +
            ", planCode='" + planCode + '\'' +
            ", planName='" + planName + '\'' +
            ", premium=" + premium +
            ", amount=" + amount +
            ", payTime=" + payTime +
            ", payToTime=" + payToTime +
            ", effectiveTime=" + effectiveTime +
            ", expirationTime=" + expirationTime +
            ", status=" + status +
            ", insuredPeriod=" + insuredPeriod +
            ", paymentPeriod=" + paymentPeriod +
            '}';
  }
}
