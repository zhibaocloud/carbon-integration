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

package com.zhibaocloud.carbon.intg.server.sdk;

import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import java.io.IOException;

public interface CarbonMessageListener {

  /**
   * 处理收到的承保数据
   *
   * @param event 承保数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 通信失败
   */
  void on(CarbonPolicy event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的回执数据
   *
   * @param event 回执数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 通信失败
   */
  void on(CarbonReceipt event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的回访数据
   *
   * @param event 回访数据
   * @param meta  数据的元数据，包括租户标识等
   * @throws IOException 通信失败
   */
  void on(CarbonRtnCall event, CarbonMessageMeta meta) throws IOException;

  /**
   * 处理收到的保单状态变化数据
   *
   * @param status 保单状态变化数据
   * @param meta   数据的元数据，包括租户标识等
   * @throws IOException 通信失败
   */
  void on(CarbonStatusChanged status, CarbonMessageMeta meta) throws IOException;
}
