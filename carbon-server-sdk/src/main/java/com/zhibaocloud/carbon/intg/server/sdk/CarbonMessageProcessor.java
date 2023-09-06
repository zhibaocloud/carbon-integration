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

package com.zhibaocloud.carbon.intg.server.sdk;

import com.zhbiaocloud.carbon.intg.CarbonResponse;
import com.zhbiaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.intg.crypto.EncryptedResponse;
import com.zhbiaocloud.carbon.intg.model.CarbonPolicy;
import com.zhbiaocloud.carbon.intg.model.CarbonReceipt;
import com.zhbiaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhbiaocloud.carbon.intg.model.CarbonStatusChanged;
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
        CarbonPolicy policy = channel.decodeRequest(request, CarbonPolicy.class);
        listener.on(policy, meta);
        break;
      case RECEIPT:
        CarbonReceipt receipt = channel.decodeRequest(request, CarbonReceipt.class);
        listener.on(receipt, meta);
        break;
      case RTN_CALL:
        CarbonRtnCall rtnCall = channel.decodeRequest(request, CarbonRtnCall.class);
        listener.on(rtnCall, meta);
        break;
      case STATUS:
        CarbonStatusChanged status = channel.decodeRequest(request, CarbonStatusChanged.class);
        listener.on(status, meta);
        break;
    }
  }
}
