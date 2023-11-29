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

package com.zhibaocloud.carbon.intg;


/**
 * 请求报文
 *
 * @param <T> 推送的数据内容
 * @author jun
 */
public class CarbonRequest<T> {

  /**
   * 数据类型，会推送至不同的数据接口
   */
  private String type;

  private T data;

  public String getType() {
    return type;
  }

  public T getData() {
    return data;
  }

  public CarbonRequest(String type, T data) {
    this.type = type;
    this.data = data;
  }
}
