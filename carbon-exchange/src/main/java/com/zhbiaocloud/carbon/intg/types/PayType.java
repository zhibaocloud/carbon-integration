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

package com.zhbiaocloud.carbon.intg.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 支付方式
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum PayType implements EncodedValue {
  /**
   * 支付方式代码
   */
  CASH("10", "现金"),
  BANK_CARD("20", "银行卡"),
  CREDIT_CARD("21", "信用卡"),
  DEBIT_CARD("22", "借记卡"),
  ELECTRONIC_TRANSFER("30", "电子资金转账"),
  CASH_PAYMENT("40", "现金缴款单"),
  CHECK("50", "支票"),
  CASH_CHECK("51", "现金支票"),
  TRANSFER_CHECK("52", "转账支票"),
  TELEGRAPHIC_TRANSFER("60", "电汇"),
  BILL_OF_EXCHANGE("70", "汇票"),
  BANK_BILL_OF_EXCHANGE("71", "银行汇票"),
  BANK_ACCEPTANCE_BILL("72", "银行承兑汇票"),
  COMMERCIAL_ACCEPTANCE_BILL("73", "商业承兑汇票"),
  THIRD_PARTY_PAYMENT("80", "第三方支付"),
  MEDICAL_INSURANCE_PERSONAL_ACCOUNT("90", "医保个人账户"),
  OTHER("99", "其它方式");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
