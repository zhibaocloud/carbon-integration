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

package com.zhibaocloud.carbon.intg.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 支付方式
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonPayType implements EncodedValue {

  /**
   * 现金
   */
  CASH("10", "现金"),
  /**
   * 银行卡
   */
  BANK_CARD("20", "银行卡"),
  /**
   * 信用卡
   */
  CREDIT_CARD("21", "信用卡"),
  /**
   * 借记卡
   */
  DEBIT_CARD("22", "借记卡"),
  /**
   * 电子资金转账
   */
  ELECTRONIC_TRANSFER("30", "电子资金转账"),
  /**
   * 现金缴款单
   */
  CASH_PAYMENT("40", "现金缴款单"),
  /**
   * 支票
   */
  CHECK("50", "支票"),
  /**
   * 现金支票
   */
  CASH_CHECK("51", "现金支票"),
  /**
   * 转账支票
   */
  TRANSFER_CHECK("52", "转账支票"),
  /**
   * 电汇
   */
  TELEGRAPHIC_TRANSFER("60", "电汇"),
  /**
   * 汇票
   */
  BILL_OF_EXCHANGE("70", "汇票"),
  /**
   * 银行汇票
   */
  BANK_BILL_OF_EXCHANGE("71", "银行汇票"),
  /**
   * 银行承兑汇票
   */
  BANK_ACCEPTANCE_BILL("72", "银行承兑汇票"),
  /**
   * 商业承兑汇票
   */
  COMMERCIAL_ACCEPTANCE_BILL("73", "商业承兑汇票"),
  /**
   * 第三方支付
   */
  THIRD_PARTY_PAYMENT("80", "第三方支付"),
  /**
   * 医保个人账户
   */
  MEDICAL_INSURANCE_PERSONAL_ACCOUNT("90", "医保个人账户"),
  /**
   * 其它方式
   */
  OTHER("99", "其它方式");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  /**
   * 码表文字描述
   */
  private final String description;
}
