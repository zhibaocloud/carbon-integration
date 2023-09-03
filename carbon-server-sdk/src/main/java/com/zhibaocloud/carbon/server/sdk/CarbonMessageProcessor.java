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

import com.zhbiaocloud.carbon.CarbonResponse;
import com.zhbiaocloud.carbon.crypto.CarbonDataChannel;
import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.Receipt;
import com.zhbiaocloud.carbon.model.RtnCall;
import com.zhbiaocloud.carbon.model.StatusChanged;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CarbonMessageProcessor {

  private final CarbonDataChannel channel;

  private final CarbonMessageListener listener;

  public EncryptedResponse process(EncryptedRequest request) {
    try {
      handle(request);
      return channel.encodeResponse(
          request.getRequestId(),
          new CarbonResponse(true, "OK")
      );
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return channel.encodeResponse(
          request.getRequestId(),
          new CarbonResponse(false, e.getMessage())
      );
    }
  }

  private void handle(EncryptedRequest request) throws IOException {
    CarbonMessageMeta meta = new CarbonMessageMeta(
        request.getRequestId(),
        request.getType(),
        request.getTenant()
    );
    switch (request.getType()) {
      case UNDERWRITE:
        Policy policy = channel.decodeRequest(request, Policy.class);
        listener.on(policy, meta);
        break;
      case RECEIPT:
        Receipt receipt = channel.decodeRequest(request, Receipt.class);
        listener.on(receipt, meta);
        break;
      case RTN_CALL:
        RtnCall rtnCall = channel.decodeRequest(request, RtnCall.class);
        listener.on(rtnCall, meta);
        break;
      case STATUS:
        StatusChanged status = channel.decodeRequest(request, StatusChanged.class);
        listener.on(status, meta);
        break;
    }
  }
}
