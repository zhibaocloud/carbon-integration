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

package com.zhibaocloud.carbon.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接入方式
 *
 * @author jun
 */
@Getter
@AllArgsConstructor
public enum ClientMode {

  /**
   * 以"协议"为单位进行对接 即：一次只能接入一家中介公司、保险公司
   */
  AGREEMENT("a"),

  /**
   * 批量接入，一次性接入所有的中介公司
   */
  BATCH("b");

  private final String value;
}
