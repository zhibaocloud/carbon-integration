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
import com.zhibaocloud.carbon.intg.types.CarbonSocialSecurityFlag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 投保人信息
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@Schema(title = "投保人信息")
public class CarbonApplicant {

  /**
   * 投保人姓名
   */
  @Schema(title = "投保人姓名", requiredMode = RequiredMode.REQUIRED)
  private String name;

  /**
   * 投保人性别
   */
  @Schema(title = "投保人性别", requiredMode = RequiredMode.REQUIRED)
  private CarbonGenderType gender;

  /**
   * 投保人出生日期
   */
  @Schema(title = "投保人出生日期", requiredMode = RequiredMode.REQUIRED)
  private LocalDate birthdate;

  /**
   * 投保人证件类型
   */
  @Schema(title = "投保人证件类型", requiredMode = RequiredMode.REQUIRED)
  private CarbonIdType idType;

  /**
   * 投保人证件号码
   */
  @CarbonIDCardDesensitize
  @Schema(title = "投保人证件号码", requiredMode = RequiredMode.REQUIRED)
  private String idNo;

  /**
   * 投保人证件有效期起始日期
   */
  @Schema(title = "投保人证件有效期起始日期")
  private LocalDate idValidStart;

  /**
   * 投保人证件有效期截止日期
   */
  @Schema(title = "投保人证件有效期截止日期")
  private LocalDate idValidEnd;

  /**
   * 投保人手机号码
   */
  @CarbonPhoneDesensitize
  @Schema(title = "投保人手机号码")
  private String mobile;

  /**
   * 投保人电子邮箱
   */
  @CarbonEmailDesensitize
  @Schema(title = "投保人电子邮箱")
  private String email;

  /**
   * 投保人学历
   */
  @Schema(title = "投保人学历")
  private CarbonDegreeType degree;

  /**
   * 投保人婚姻状况
   */
  @Schema(title = "投保人婚姻状况")
  private CarbonMarriageType marriage;

  /**
   * 投保人职业类别
   */
  @Schema(title = "投保人职业类别")
  private String occupationType;

  /**
   * 投保人职业代码
   */
  @Schema(title = "投保人职业代码")
  private String occupationCode;

  /**
   * 投保人职业名称
   */
  @Schema(title = "投保人职业名称")
  private String occupationName;

  /**
   * 投保人户籍注册地址
   */
  @CarbonStringDesensitize
  @Schema(title = "投保人户籍注册地址")
  private String rgtAddress;

  /**
   * 投保人联系地址
   */
  @CarbonStringDesensitize
  @Schema(title = "投保人联系地址")
  private String postalAddress;

  /**
   * 投保人年收入（单位：万元）
   */
  @Schema(title = "投保人年收入（单位：万元）")
  private BigDecimal income;

  /**
   * 投保人国籍
   */
  @Schema(title = "投保人国籍")
  private CarbonNationType nation;

  /**
   * 投保人民族
   */
  @Schema(title = "投保人民族")
  private CarbonNationalityType nationality;

  /**
   * 投保人是否有社保
   */
  @Schema(title = "投保人是否有社保")
  private CarbonSocialSecurityFlag socialSecurityFlag;
}
