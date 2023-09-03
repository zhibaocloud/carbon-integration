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

package com.zhibaocloud.carbon.service;

import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import java.io.IOException;
import org.springframework.context.event.EventListener;

/**
 * Carbon 事件监听器，实现接口以处理推送数据
 *
 * @author jun
 */
public interface CarbonEventListener {

  /**
   * 处理收到的承保数据
   *
   * @param event 承保数据
   * @throws IOException 数据处理失败
   */
  @EventListener
  void onPolicyReceived(Policy event) throws IOException;

  /**
   * 处理收到的回执数据
   *
   * @param event 回执数据
   * @throws IOException 数据处理失败
   */
  @EventListener
  void onReceiptReceived(Receipt event) throws IOException;

  /**
   * 处理收到的回访数据
   *
   * @param event 回访数据
   * @throws IOException 数据处理失败
   */
  @EventListener
  void onRtncallReceived(RtnCall event) throws IOException;
}
