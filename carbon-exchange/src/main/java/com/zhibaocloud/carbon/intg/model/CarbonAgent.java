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

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

/**
 * 代理人信息
 *
 * @author jun
 */
@Schema(title = "代理人信息")
public class CarbonAgent {

  /**
   * 代理人姓名
   */
  @Schema(title = "代理人姓名", requiredMode = RequiredMode.REQUIRED)
  private String name;

  /**
   * 代理人编码
   */
  @Schema(title = "代理人编码", description = "一般指指代理人在保险公司销管系统中的经代工号", requiredMode = RequiredMode.REQUIRED)
  private String code;

  /**
   * 代理人中介公司工号
   */
  @Schema(title = "代理人中介公司工号", description = "指代理人在中介机构中的内部工号")
  private String extCode;

  /**
   * 代理人执业证号
   */
  @Schema(title = "代理人执业证号")
  private String busiDevCertifNo;

  public CarbonAgent() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getExtCode() {
    return extCode;
  }

  public void setExtCode(String extCode) {
    this.extCode = extCode;
  }

  public String getBusiDevCertifNo() {
    return busiDevCertifNo;
  }

  public void setBusiDevCertifNo(String busiDevCertifNo) {
    this.busiDevCertifNo = busiDevCertifNo;
  }

  @Override
  public String toString() {
    return "CarbonAgent{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        ", extCode='" + extCode + '\'' +
        ", busiDevCertifNo='" + busiDevCertifNo + '\'' +
        '}';
  }
}
