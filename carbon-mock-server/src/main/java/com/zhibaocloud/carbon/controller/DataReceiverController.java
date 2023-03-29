/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.controller;

import com.zhbiaocloud.carbon.model.EncryptedRequest;
import com.zhbiaocloud.carbon.model.EncryptedResponse;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.domain.SaasAgreement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataReceiverController {

  @PostMapping("/v2/callbacks/a/{id}/{type}")
  public ResponseEntity<EncryptedResponse> onAgreementCallback(
      Agreement agreement,
      String type,
      @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = new EncryptedResponse(
        request.getRequestId(),
        "",
        ""
    );
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v2/callbacks/b/{id}/{type}")
  public ResponseEntity<EncryptedResponse> onBatchCallback(
      SaasAgreement saas,
      String type,
      @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = new EncryptedResponse(
        request.getRequestId(),
        "",
        ""
    );
    return ResponseEntity.ok(response);
  }
}
