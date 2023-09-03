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

import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import java.io.IOException;

/**
 * 数据推送接口
 *
 * @author jun
 */
public interface CarbonClient {

  /**
   * 承保保单数据推送
   *
   * @param policy 保单数据
   * @throws IOException 数据通信、转换失败
   */
  void publish(Policy policy) throws IOException;

  /**
   * 保单回执数据推送
   *
   * @param receipt 回执数据
   * @throws IOException 数据通信、转换失败
   */
  void publish(Receipt receipt) throws IOException;

  /**
   * 保单回访数据推送
   *
   * @param rtnCall 回访数据
   * @throws IOException 数据通信、转换失败
   */
  void publish(RtnCall rtnCall) throws IOException;

  /**
   * 保单状态变化数据推送
   *
   * @param status 保单状态变化数据
   * @throws IOException 数据通信、转换失败
   */
  void publish(StatusChanged status) throws IOException;
}
