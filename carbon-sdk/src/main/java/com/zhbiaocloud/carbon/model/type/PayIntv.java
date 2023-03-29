/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhbiaocloud.carbon.model.type;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 交费间隔、交费频率
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum PayIntv {

  /**
   * 同一次性交清，交费年期为1年交
   */
  SINGLE("01", "趸交"),

  MONTHLY("02", "月交"),

  QUARTERLY("03", "季交"),

  HALF_YEARLY("04", "半年交"),

  YEARLY("05", "年交"),

  IRREGULAR("06", "不定期交费"),

  OTHER("99", "其他");

  /**
   * 在网络中传输时的码值
   */
  @JsonValue
  private final String value;

  private final String label;
}
