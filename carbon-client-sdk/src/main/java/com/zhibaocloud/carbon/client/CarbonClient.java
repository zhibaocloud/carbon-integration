/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
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
}