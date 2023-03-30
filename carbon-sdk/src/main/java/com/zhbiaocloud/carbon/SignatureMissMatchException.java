/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon;

/**
 * 服务端返回的签名与本地计算的签名不一致，有可能是被篡改。或报文被损坏
 *
 * @author jun
 */
public class SignatureMissMatchException extends CarbonException {

  public SignatureMissMatchException(String expected, String actual) {
    super("Signature miss match, expected: " + expected + ", actual: " + actual);
  }
}
