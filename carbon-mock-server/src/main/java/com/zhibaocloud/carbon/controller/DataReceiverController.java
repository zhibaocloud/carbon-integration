/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.controller;

import com.zhbiaocloud.carbon.model.EncryptedRequest;
import com.zhbiaocloud.carbon.model.EncryptedResponse;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.domain.SaasAgreement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于接收外部数据推送
 *
 * @author jun
 */
@RestController
@Tag(name = "数据推送接口")
public class DataReceiverController {

  @PostMapping("/v2/callbacks/a/{id}/{type}")
  @Operation(operationId = "publishByAgreement", summary = "保单数据同步", description = "用于接收保险公司向中介公司推送的保单数据")
  @ResponseStatus(HttpStatus.OK)
  @Parameter(in = ParameterIn.PATH, name = "id", schema = @Schema(type = "string", format = "uuid"))
  public ResponseEntity<EncryptedResponse> onAgreementCallback(
      @Parameter(hidden = true) @PathVariable("id") Agreement agreement,
      @PathVariable(name = "type") String type,
      @Valid @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = new EncryptedResponse(
        request.getRequestId(),
        "",
        ""
    );
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v2/callbacks/b/{id}/{type}")
  @Operation(operationId = "publishByTenants", summary = "保单数据同步", description = "用于接收保险公司向中介公司推送的保单数据")
  @ResponseStatus(HttpStatus.OK)
  @Parameter(in = ParameterIn.PATH, name = "id", schema = @Schema(type = "string", format = "uuid"))
  public ResponseEntity<EncryptedResponse> onBatchCallback(
      @Parameter(hidden = true) @PathVariable("id") SaasAgreement saas,
      @PathVariable(name = "type") String type,
      @Valid @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = new EncryptedResponse(
        request.getRequestId(),
        "",
        ""
    );
    return ResponseEntity.ok(response);
  }
}
