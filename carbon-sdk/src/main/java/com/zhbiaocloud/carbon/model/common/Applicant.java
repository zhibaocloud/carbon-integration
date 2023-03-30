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

import com.zhbiaocloud.carbon.model.type.DegreeType;
import com.zhbiaocloud.carbon.model.type.GenderType;
import com.zhbiaocloud.carbon.model.type.IdType;
import com.zhbiaocloud.carbon.model.type.MarriageType;
import com.zhbiaocloud.carbon.model.type.NationType;
import com.zhbiaocloud.carbon.model.type.NationalityType;
import com.zhbiaocloud.carbon.model.type.SocialSecurityFlag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 投保人信息
 *
 * @author jun
 */
@Data
@Schema(title = "投保人信息")
public class Applicant {

  @NotBlank
  @Schema(title = "投保人姓名", requiredMode = RequiredMode.REQUIRED)
  private String name;

  @NotNull
  @Schema(title = "投保人性别", requiredMode = RequiredMode.REQUIRED)
  private GenderType gender;

  @NotNull
  @Schema(title = "投保人出生日期", requiredMode = RequiredMode.REQUIRED)
  private LocalDate birthdate;

  @NotNull
  @Schema(title = "投保人证件类型", requiredMode = RequiredMode.REQUIRED)
  private IdType idType;

  @NotNull
  @Schema(title = "投保人证件号码", requiredMode = RequiredMode.REQUIRED)
  private String idNo;

  @Schema(title = "投保人证件有效期起始日期")
  private LocalDate idValidStart;

  @Schema(title = "投保人证件有效期截止日期")
  private LocalDate idValidEnd;

  @Schema(title = "投保人手机号码")
  private String mobile;

  @Email
  @Schema(title = "投保人电子邮箱")
  private String email;

  @Schema(title = "投保人学历")
  private DegreeType degree;

  @Schema(title = "投保人婚姻状况")
  private MarriageType marriage;

  @Schema(title = "投保人职业类别")
  private String occupationType;

  @Schema(title = "投保人职业代码")
  private String occupationCode;

  @Schema(title = "投保人职业名称")
  private String occupationName;

  @Schema(title = "投保人户籍注册地址")
  private String rgtAddress;

  @Schema(title = "投保人联系地址")
  private String postalAddress;

  @Schema(title = "投保人年收入（单位：万元）")
  private BigDecimal income;

  @Schema(title = "投保人国籍")
  private NationType nation;

  @Schema(title = "投保人民族")
  private NationalityType nationality;

  @Schema(title = "投保人是否有社保")
  private SocialSecurityFlag socialSecurityFlag;
}
