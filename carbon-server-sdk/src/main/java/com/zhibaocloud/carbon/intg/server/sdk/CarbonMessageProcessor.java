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

import com.zhibaocloud.carbon.intg.CarbonResponse;
import com.zhibaocloud.carbon.intg.crypto.CarbonDataChannel;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonReceipt;
import com.zhibaocloud.carbon.intg.model.CarbonRtnCall;
import com.zhibaocloud.carbon.intg.model.CarbonStatusChanged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class CarbonMessageProcessor {

  private static final Logger logger = LoggerFactory.getLogger(CarbonMessageProcessor.class);

  private final CarbonDataChannel channel;

  private final CarbonMessageListener listener;

  public CarbonMessageProcessor(CarbonDataChannel channel, CarbonMessageListener listener) {
    this.channel = channel;
    this.listener = listener;
  }

  public CarbonEncryptedResponse process(CarbonEncryptedRequest request) {
    try {
      handle(request);
      return channel.encodeResponse(
          request.getRequestId(),
          new CarbonResponse(true, "OK")
      );
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      return channel.encodeResponse(
          request.getRequestId(),
          new CarbonResponse(false, e.getMessage())
      );
    }
  }

  private void handle(CarbonEncryptedRequest request) throws IOException {
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
