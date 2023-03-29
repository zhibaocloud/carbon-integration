/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model;

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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

/**
 * 被保人信息
 *
 * @author jun
 */
@Data
@Schema(title = "被保人信息")
public class Insured {

  @NotNull
  @Schema(title = "与投保人关系", requiredMode = RequiredMode.REQUIRED)
  private RelationType relationToApplicant;

  @NotBlank
  @Schema(title = "被保人姓名")
  private String name;

  @NotNull
  @Schema(title = "被保人性别")
  private GenderType gender;

  @NotNull
  @Schema(title = "被保人出生日期")
  private LocalDate birthdate;

  @NotNull
  @Schema(title = "被保人证件类型")
  private IdType idType;

  @NotNull
  @Schema(title = "被保人证件号码")
  private String idNo;

  @Schema(title = "被保人证件有效期起始日期")
  private LocalDate idValidStart;

  @Schema(title = "被保人证件有效期截止日期")
  private LocalDate idValidEnd;

  @Schema(title = "被保人手机号码")
  private String mobile;

  @Email
  @Schema(title = "被保人电子邮箱")
  private String email;

  @Schema(title = "被保人学历")
  private DegreeType degree;

  @Schema(title = "被保人婚姻状况")
  private MarriageType marriage;

  @Schema(title = "被保人职业类别")
  private String occupationType;

  @Schema(title = "被保人职业代码")
  private String occupationCode;

  @Schema(title = "被保人职业名称")
  private String occupationName;

  @Schema(title = "被保人户籍注册地址")
  private String rgtAddress;

  @Schema(title = "被保人联系地址")
  private String postalAddress;

  @Schema(title = "被保人年收入（单位：万元）")
  private BigDecimal income;

  @Schema(title = "被保人国籍")
  private NationType nation;

  @Schema(title = "被保人民族")
  private NationalityType nationality;

  @Schema(title = "被保人是否有社保")
  private SocialSecurityFlag socialSecurityFlag;
}