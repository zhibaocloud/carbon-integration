/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.client;

public class SignatureMissMatchException extends CarbonException {

  public SignatureMissMatchException(String expected, String actual) {
    super("Signature miss match, expected: " + expected + ", actual: " + actual);
  }
}
