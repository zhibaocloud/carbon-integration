/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

package com.zhibaocloud.carbon.server.sdk;

import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import java.io.IOException;

public interface CarbonMessageListener {

  /**
   * 处理收到的承保数据
   *
   * @param event 承保数据
   */
  void on(Policy event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的回执数据
   *
   * @param event 回执数据
   */
  void on(Receipt event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的回访数据
   *
   * @param event 回访数据
   */
  void on(RtnCall event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的保单状态变化数据
   *
   * @param status 保单状态变化数据
   */
  void on(StatusChanged status, CarbonMessageMeta meta) throws IOException;
}
