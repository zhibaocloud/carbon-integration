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

  @Schema(title = "被保人编号", description = "用于关联被保人")
  private String insuredNo;

  @Schema(title = "与受益人关系", requiredMode = RequiredMode.REQUIRED)
  private CarbonRelationType relationToInsured;

  @Schema(title = "受益人类型", requiredMode = RequiredMode.REQUIRED)
  private CarbonBnfType bnfType;

  @Schema(title = "受益顺序", requiredMode = RequiredMode.REQUIRED)
  private CarbonBnfGrade bnfGrade;

  @Schema(title = "受益比例", description = "使用百分比表示，同一顺位受益人的收益比例之和为100%", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal bnfRatio;

  @Schema(title = "受益人姓名")
  private String name;

  @Schema(title = "受益人性别")
  private CarbonGenderType gender;

  @Schema(title = "受益人出生日期")
  private LocalDate birthdate;

  @Schema(title = "受益人证件类型")
  private CarbonIdType idType;

  @IDCardDesensitize
  @Schema(title = "受益人证件号码")
  private String idNo;

  @Schema(title = "受益人证件有效期起始日期")
  private LocalDate idValidStart;

  @Schema(title = "受益人证件有效期截止日期")
  private LocalDate idValidEnd;

  @PhoneDesensitize
  @Schema(title = "受益人手机号码")
  private String mobile;

  @Schema(title = "受益人电子邮箱")
  private String email;

  @Schema(title = "受益人学历")
  private CarbonDegreeType degree;

  @Schema(title = "受益人婚姻状况")
  private CarbonMarriageType marriage;

  @Schema(title = "受益人职业类别")
  private String occupationType;

  @Schema(title = "受益人职业代码")
  private String occupationCode;

  @Schema(title = "受益人职业名称")
  private String occupationName;

  @StringDesensitize
  @Schema(title = "受益人户籍注册地址")
  private String rgtAddress;

  @StringDesensitize
  @Schema(title = "受益人联系地址")
  private String postalAddress;

  @Schema(title = "受益人年收入（单位：万元）")
  private BigDecimal income;

  @Schema(title = "受益人国籍")
  private CarbonNationType nation;

  @Schema(title = "受益人民族")
  private CarbonNationalityType nationality;

  @Schema(title = "受益人是否有社保")
  private CarbonSocialSecurityFlag socialSecurityFlag;
}