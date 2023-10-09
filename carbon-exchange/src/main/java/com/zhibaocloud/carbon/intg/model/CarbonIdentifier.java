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

/**
 * 推送数据通用字段，用于去重复，或者将多个报文数据合并至同一张保单
 *
 * @author jun
 */
public interface CarbonIdentifier {

  /**
   * 获取保单号
   *
   * @return 保单号
   */
  String getPolicyNo();

  /**
   * 获取投保单号
   *
   * @return 投保单号
   */
  String getProposalNo();

  /**
   * 获取订单号
   *
   * @return 订单号
   */
  default String getOrderNo() {
    return null;
  }
}
