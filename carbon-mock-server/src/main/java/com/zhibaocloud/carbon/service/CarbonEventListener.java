/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
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
  public void onPolicyReceived(Policy event) throws IOException;

  /**
   * 处理收到的回执数据
   *
   * @param event 回执数据
   * @throws IOException 数据处理失败
   */
  @EventListener
  public void onReceiptReceived(Receipt event) throws IOException;

  /**
   * 处理收到的回访数据
   *
   * @param event 回访数据
   * @throws IOException 数据处理失败
   */
  @EventListener
  public void onRtncallReceived(RtnCall event) throws IOException;
}
