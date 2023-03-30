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

package com.zhibaocloud.carbon.controller;

import com.zhbiaocloud.carbon.crypto.EncryptedRequest;
import com.zhbiaocloud.carbon.crypto.EncryptedResponse;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.domain.SaaSAgreement;
import com.zhibaocloud.carbon.service.DataReceiverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Tag(name = "数据推送接口")
public class DataReceiverController {

  private final DataReceiverService svc;

  @PostMapping("/v2/callbacks/verify")
  @Operation(operationId = "verifyEncryption", summary = "加密验证", description = "用于验证加密方式是否正确，以及客户端、服务端接口是否兼容")
  public ResponseEntity<EncryptedResponse> verify(@Valid @RequestBody EncryptedRequest request) {
    EncryptedResponse response = new EncryptedResponse();
    response.setRequestId(request.getRequestId());
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v2/callbacks/a/{id}/{type}")
  @Operation(operationId = "publishByAgreement", summary = "保单数据同步", description = "用于接收保险公司向中介公司推送的保单数据")
  @ResponseStatus(HttpStatus.OK)
  @Parameter(in = ParameterIn.PATH, name = "id", schema = @Schema(type = "string", format = "uuid"))
  public ResponseEntity<EncryptedResponse> onAgreementCallback(
      @Parameter(hidden = true) @PathVariable("id") Agreement agreement,
      @PathVariable(name = "type") String type,
      @Valid @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = svc.process(agreement, request, type);
    return ResponseEntity.ok(response);
  }

  @PostMapping("/v2/callbacks/b/{id}/{type}")
  @Operation(operationId = "publishByTenants", summary = "保单数据同步", description = "用于接收保险公司向中介公司推送的保单数据")
  @ResponseStatus(HttpStatus.OK)
  @Parameter(in = ParameterIn.PATH, name = "id", schema = @Schema(type = "string", format = "uuid"))
  public ResponseEntity<EncryptedResponse> onBatchCallback(
      @Parameter(hidden = true) @PathVariable("id") SaaSAgreement saas,
      @PathVariable(name = "type") String type,
      @Valid @RequestBody EncryptedRequest request
  ) {
    EncryptedResponse response = svc.process(saas, request, type);
    return ResponseEntity.ok(response);
  }
}
