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

package com.zhibaocloud.carbon.sdk;

import com.zhbiaocloud.carbon.crypto.CarbonChannel;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageProcessor {

  private final CarbonChannel channel;

  private final MessageListener listener;

  public void process(EncryptedRequest request) throws IOException {
    switch (request.getType()) {
      case UNDERWRITE:
        Policy policy = channel.decodeRequest(request, Policy.class);
        listener.on(policy);
        break;
      case RECEIPT:
        Receipt receipt = channel.decodeRequest(request, Receipt.class);
        listener.on(receipt);
        break;
      case RTN_CALL:
        RtnCall rtnCall = channel.decodeRequest(request, RtnCall.class);
        listener.on(rtnCall);
        break;
      case STATUS:
        StatusChanged status = channel.decodeRequest(request, StatusChanged.class);
        listener.on(status);
        break;
    }
  }
}
