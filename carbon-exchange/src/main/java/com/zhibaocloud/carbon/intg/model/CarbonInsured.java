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
import com.zhibaocloud.carbon.intg.types.*;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 被保人信息
 *
 * @author jun
 */
@Data
@NoArgsConstructor
@Schema(title = "被保人信息")
public class CarbonInsured {


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
}
