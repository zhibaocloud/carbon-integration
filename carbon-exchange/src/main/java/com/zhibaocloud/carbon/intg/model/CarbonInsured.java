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

import com.zhibaocloud.carbon.intg.desensitization.SensitiveData;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonEmailDesensitize;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonIDCardDesensitize;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonPhoneDesensitize;
import com.zhibaocloud.carbon.intg.desensitization.annotations.CarbonStringDesensitize;
import com.zhibaocloud.carbon.intg.types.CarbonDegreeType;
import com.zhibaocloud.carbon.intg.types.CarbonGenderType;
import com.zhibaocloud.carbon.intg.types.CarbonIdType;
import com.zhibaocloud.carbon.intg.types.CarbonMarriageType;
import com.zhibaocloud.carbon.intg.types.CarbonNationType;
import com.zhibaocloud.carbon.intg.types.CarbonNationalityType;
import com.zhibaocloud.carbon.intg.types.CarbonRelationType;
import com.zhibaocloud.carbon.intg.types.CarbonSocialSecurityFlag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 被保人信息
 *
 * @author jun
 */
@Schema(title = "被保人信息")
public class CarbonInsured implements SensitiveData {


  /**
   * 被保人编号
   */
  @Schema(title = "被保人编号", description = "在多被保人数据中用于标识和险种的关系")
  private String insuredNo;


  /**
   * 与投保人关系
   */
  @Schema(title = "与投保人关系", requiredMode = RequiredMode.REQUIRED)
  private CarbonRelationType relationToApplicant;


  /**
   * 被保人姓名
   */
  @Schema(title = "被保人姓名")
  private String name;


  /**
   * 被保人性别
   */
  @Schema(title = "被保人性别")
  private CarbonGenderType gender;


  /**
   * 被保人出生日期
   */
  @Schema(title = "被保人出生日期")
  private LocalDate birthdate;


  /**
   * 被保人证件类型
   */
  @Schema(title = "被保人证件类型")
  private CarbonIdType idType;


  /**
   * 被保人证件号码
   */
  @CarbonIDCardDesensitize
  @Schema(title = "被保人证件号码")
  private String idNo;


  /**
   * 被保人证件有效期起始日期
   */
  @Schema(title = "被保人证件有效期起始日期")
  private LocalDate idValidStart;


  /**
   * 被保人证件有效期截止日期
   */
  @Schema(title = "被保人证件有效期截止日期")
  private LocalDate idValidEnd;


  /**
   * 被保人手机号码
   */
  @CarbonPhoneDesensitize
  @Schema(title = "被保人手机号码")
  private String mobile;


  /**
   * 被保人电子邮箱
   */
  @CarbonEmailDesensitize
  @Schema(title = "被保人电子邮箱")
  private String email;


  /**
   * 被保人学历
   */
  @Schema(title = "被保人学历")
  private CarbonDegreeType degree;


  /**
   * 被保人婚姻状况
   */
  @Schema(title = "被保人婚姻状况")
  private CarbonMarriageType marriage;


  /**
   * 被保人职业类别
   */
  @Schema(title = "被保人职业类别")
  private String occupationType;


  /**
   * 被保人职业代码
   */
  @Schema(title = "被保人职业代码")
  private String occupationCode;


  /**
   * 被保人职业名称
   */
  @Schema(title = "被保人职业名称")
  private String occupationName;


  /**
   * 被保人户籍注册地址
   */
  @CarbonStringDesensitize
  @Schema(title = "被保人户籍注册地址")
  private String rgtAddress;


  /**
   * 被保人联系地址
   */
  @CarbonStringDesensitize
  @Schema(title = "被保人联系地址")
  private String postalAddress;


  /**
   * 被保人年收入（单位：万元）
   */
  @Schema(title = "被保人年收入（单位：万元）")
  private BigDecimal income;


  /**
   * 被保人国籍
   */
  @Schema(title = "被保人国籍")
  private CarbonNationType nation;


  /**
   * 被保人民族
   */
  @Schema(title = "被保人民族")
  private CarbonNationalityType nationality;


  /**
   * 被保人是否有社保
   */
  @Schema(title = "被保人是否有社保")
  private CarbonSocialSecurityFlag socialSecurityFlag;

  public CarbonInsured() {
  }

  public String getInsuredNo() {
    return insuredNo;
  }

  public void setInsuredNo(String insuredNo) {
    this.insuredNo = insuredNo;
  }

  public CarbonRelationType getRelationToApplicant() {
    return relationToApplicant;
  }

  public void setRelationToApplicant(CarbonRelationType relationToApplicant) {
    this.relationToApplicant = relationToApplicant;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CarbonGenderType getGender() {
    return gender;
  }

  public void setGender(CarbonGenderType gender) {
    this.gender = gender;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public CarbonIdType getIdType() {
    return idType;
  }

  public void setIdType(CarbonIdType idType) {
    this.idType = idType;
  }

  public String getIdNo() {
    return idNo;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public LocalDate getIdValidStart() {
    return idValidStart;
  }

  public void setIdValidStart(LocalDate idValidStart) {
    this.idValidStart = idValidStart;
  }

  public LocalDate getIdValidEnd() {
    return idValidEnd;
  }

  public void setIdValidEnd(LocalDate idValidEnd) {
    this.idValidEnd = idValidEnd;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CarbonDegreeType getDegree() {
    return degree;
  }

  public void setDegree(CarbonDegreeType degree) {
    this.degree = degree;
  }

  public CarbonMarriageType getMarriage() {
    return marriage;
  }

  public void setMarriage(CarbonMarriageType marriage) {
    this.marriage = marriage;
  }

  public String getOccupationType() {
    return occupationType;
  }

  public void setOccupationType(String occupationType) {
    this.occupationType = occupationType;
  }

  public String getOccupationCode() {
    return occupationCode;
  }

  public void setOccupationCode(String occupationCode) {
    this.occupationCode = occupationCode;
  }

  public String getOccupationName() {
    return occupationName;
  }

  public void setOccupationName(String occupationName) {
    this.occupationName = occupationName;
  }

  public String getRgtAddress() {
    return rgtAddress;
  }

  public void setRgtAddress(String rgtAddress) {
    this.rgtAddress = rgtAddress;
  }

  public String getPostalAddress() {
    return postalAddress;
  }

  public void setPostalAddress(String postalAddress) {
    this.postalAddress = postalAddress;
  }

  public BigDecimal getIncome() {
    return income;
  }

  public void setIncome(BigDecimal income) {
    this.income = income;
  }

  public CarbonNationType getNation() {
    return nation;
  }

  public void setNation(CarbonNationType nation) {
    this.nation = nation;
  }

  public CarbonNationalityType getNationality() {
    return nationality;
  }

  public void setNationality(CarbonNationalityType nationality) {
    this.nationality = nationality;
  }

  public CarbonSocialSecurityFlag getSocialSecurityFlag() {
    return socialSecurityFlag;
  }

  public void setSocialSecurityFlag(CarbonSocialSecurityFlag socialSecurityFlag) {
    this.socialSecurityFlag = socialSecurityFlag;
  }

  @Override
  public String toString() {
    return "CarbonInsured{" +
        "insuredNo='" + insuredNo + '\'' +
        ", relationToApplicant=" + relationToApplicant +
        ", name='" + name + '\'' +
        ", gender=" + gender +
        ", birthdate=" + birthdate +
        ", idType=" + idType +
        ", idNo='" + idNo + '\'' +
        ", idValidStart=" + idValidStart +
        ", idValidEnd=" + idValidEnd +
        ", mobile='" + mobile + '\'' +
        ", email='" + email + '\'' +
        ", degree=" + degree +
        ", marriage=" + marriage +
        ", occupationType='" + occupationType + '\'' +
        ", occupationCode='" + occupationCode + '\'' +
        ", occupationName='" + occupationName + '\'' +
        ", rgtAddress='" + rgtAddress + '\'' +
        ", postalAddress='" + postalAddress + '\'' +
        ", income=" + income +
        ", nation=" + nation +
        ", nationality=" + nationality +
        ", socialSecurityFlag=" + socialSecurityFlag +
        '}';
  }

}
