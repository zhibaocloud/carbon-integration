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

package com.zhibaocloud.carbon.intg.server;

import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedRequest;
import com.zhibaocloud.carbon.intg.crypto.CarbonEncryptedResponse;
import com.zhibaocloud.carbon.intg.server.sdk.CarbonMessageProcessor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于接收数据推送
 *
 * @author jun
 */
@RestController
@RequiredArgsConstructor
@Tag(name = "数据推送接口")
public class DataReceiverController {

  private final CarbonMessageProcessor processor;

  /**
   * 由接入方实现该接口，并将该接口地址告知智保云，用于接收保险公司推送的保单数据
   *
   * @param request 推送数据内容
   * @return 返回处理结果
   */
  @PostMapping("/v2/callbacks/a/fd3c35de-ca5f-4442-87aa-17edc67f93d0")
  @Operation(operationId = "receive", summary = "保单数据同步", description = "用于接收保险公司向中介公司推送的保单数据")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<CarbonEncryptedResponse> onCallback(
      @RequestBody CarbonEncryptedRequest request) {
    CarbonEncryptedResponse response = processor.process(request);
    return ResponseEntity.ok(response);
  }
}
