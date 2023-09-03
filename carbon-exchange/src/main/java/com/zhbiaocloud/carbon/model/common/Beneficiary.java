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

package com.zhbiaocloud.carbon.model.common;

import com.github.annotation.IDCardDesensitize;
import com.github.annotation.PhoneDesensitize;
import com.github.annotation.StringDesensitize;
import com.zhbiaocloud.carbon.model.type.BnfGrade;
import com.zhbiaocloud.carbon.model.type.BnfType;
import com.zhbiaocloud.carbon.model.type.DegreeType;
import com.zhbiaocloud.carbon.model.type.GenderType;
import com.zhbiaocloud.carbon.model.type.IdType;
import com.zhbiaocloud.carbon.model.type.MarriageType;
import com.zhbiaocloud.carbon.model.type.NationType;
import com.zhbiaocloud.carbon.model.type.NationalityType;
import com.zhbiaocloud.carbon.model.type.RelationType;
import com.zhbiaocloud.carbon.model.type.SocialSecurityFlag;
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
public class Beneficiary {

  @Schema(title = "与受益人关系", requiredMode = RequiredMode.REQUIRED)
  private RelationType relationToInsured;

  @Schema(title = "受益人类型", requiredMode = RequiredMode.REQUIRED)
  private BnfType bnfType;

  @Schema(title = "受益顺序", requiredMode = RequiredMode.REQUIRED)
  private BnfGrade bnfGrade;

  @Schema(title = "受益比例", description = "使用百分比表示，同一顺位受益人的收益比例之和为100%", requiredMode = RequiredMode.REQUIRED)
  private BigDecimal bnfRatio;

  @Schema(title = "受益人姓名")
  private String name;

  @Schema(title = "受益人性别")
  private GenderType gender;

  @Schema(title = "受益人出生日期")
  private LocalDate birthdate;

  @Schema(title = "受益人证件类型")
  private IdType idType;

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
  private DegreeType degree;

  @Schema(title = "受益人婚姻状况")
  private MarriageType marriage;

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
  private NationType nation;

  @Schema(title = "受益人民族")
  private NationalityType nationality;

  @Schema(title = "受益人是否有社保")
  private SocialSecurityFlag socialSecurityFlag;
}
