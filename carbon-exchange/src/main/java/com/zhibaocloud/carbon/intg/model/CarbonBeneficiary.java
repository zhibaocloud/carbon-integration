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

import com.github.annotation.IDCardDesensitize;
import com.github.annotation.PhoneDesensitize;
import com.github.annotation.StringDesensitize;
import com.zhibaocloud.carbon.intg.types.CarbonBnfGrade;
import com.zhibaocloud.carbon.intg.types.CarbonBnfType;
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
import lombok.Data;

/**
 * 受益人信息
 *
 * @author jun
 */
@Data
@Schema(title = "受益人信息")
public class CarbonBeneficiary {

  /**
   * 被保人编号
   */
  @Schema(title = "被保人编号", description = "用于关联被保人")
  private String insuredNo;

  /**
   * 与受益人关系
   */
  @Schema(title = "与受益人关系", requiredMode = RequiredMode.REQUIRED)
  private CarbonRelationType relationToInsured;

  /**
   * 受益人类型
   */
  @Schema(title = "受益人类型", requiredMode = RequiredMode.REQUIRED)
  private CarbonBnfType bnfType;

  /**
   * 受益顺序
   */
  @Schema(title = "受益顺序", requiredMode = RequiredMode.REQUIRED)
  private CarbonBnfGrade bnfGrade;

  /**
   * 受益比例
   */
  @Schema(title = "受益比例", description = "使用百分比表示，同一顺位受益人的收益比例之和为100%", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal bnfRatio;

  /**
   * 受益人姓名
   */
  @Schema(title = "受益人姓名")
  private String name;

  /**
   * 受益人性别
   */
  @Schema(title = "受益人性别")
  private CarbonGenderType gender;

  /**
   * 受益人出生日期
   */
  @Schema(title = "受益人出生日期")
  private LocalDate birthdate;

  /**
   * 受益人证件类型
   */
  @Schema(title = "受益人证件类型")
  private CarbonIdType idType;

  /**
   * 受益人证件号码
   */
  @IDCardDesensitize
  @Schema(title = "受益人证件号码")
  private String idNo;

  /**
   * 受益人证件有效期起始日期
   */
  @Schema(title = "受益人证件有效期起始日期")
  private LocalDate idValidStart;

  /**
   * 受益人证件有效期截止日期
   */
  @Schema(title = "受益人证件有效期截止日期")
  private LocalDate idValidEnd;

  /**
   * 受益人手机号码
   */
  @PhoneDesensitize
  @Schema(title = "受益人手机号码")
  private String mobile;

  /**
   * 受益人电子邮箱
   */
  @Schema(title = "受益人电子邮箱")
  private String email;

  /**
   * 受益人学历
   */
  @Schema(title = "受益人学历")
  private CarbonDegreeType degree;

  /**
   * 受益人婚姻状况
   */
  @Schema(title = "受益人婚姻状况")
  private CarbonMarriageType marriage;

  /**
   * 受益人职业类别
   */
  @Schema(title = "受益人职业类别")
  private String occupationType;

  /**
   * 受益人职业代码
   */
  @Schema(title = "受益人职业代码")
  private String occupationCode;

  /**
   * 受益人职业名称
   */
  @Schema(title = "受益人职业名称")
  private String occupationName;

  /**
   * 受益人户籍注册地址
   */
  @StringDesensitize
  @Schema(title = "受益人户籍注册地址")
  private String rgtAddress;

  /**
   * 受益人联系地址
   */
  @StringDesensitize
  @Schema(title = "受益人联系地址")
  private String postalAddress;

  /**
   * 受益人年收入（单位：万元）
   */
  @Schema(title = "受益人年收入（单位：万元）")
  private BigDecimal income;

  /**
   * 受益人国籍
   */
  @Schema(title = "受益人国籍")
  private CarbonNationType nation;

  /**
   * 受益人民族
   */
  @Schema(title = "受益人民族")
  private CarbonNationalityType nationality;

  /**
   * 受益人是否有社保
   */
  @Schema(title = "受益人是否有社保")
  private CarbonSocialSecurityFlag socialSecurityFlag;
}
