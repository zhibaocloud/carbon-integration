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

package com.zhibaocloud.carbon.intg.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 证件类型
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonIdType implements EncodedValue {
  /**
   * 居民身份证
   */
  ID_CARD("111", "居民身份证"),
  /**
   * 临时居民身份证
   */
  TEMP_ID_CARD("112", "临时居民身份证"),
  /**
   * 户口簿
   */
  RESIDENT_BOOKLET("113", "户口簿"),
  /**
   * 中国人民解放军军官证
   */
  MILITARY_OFFICER_CARD("114", "中国人民解放军军官证"),
  /**
   * 中国人民武装警察部队警官证
   */
  POLICE_OFFICER_CARD("115", "中国人民武装警察部队警官证"),
  /**
   * 出生医学证明
   */
  BIRTH_CARD("117", "出生医学证明"),
  /**
   * 法官证
   */
  JUDGE_CARD("121", "法官证"),
  /**
   * 警官证
   */
  POLICE_CARD("123", "警官证"),
  /**
   * 检察官证
   */
  PROSECUTOR_CARD("125", "检察官证"),
  /**
   * 律师证
   */
  LAWYER_CARD("127", "律师证"),
  /**
   * 记者证
   */
  JOURNALIST_CARD("128", "记者证"),
  /**
   * 工作证
   */
  WORK_CARD("131", "工作证"),
  /**
   * 学生证
   */
  STUDENT_CARD("133", "学生证"),
  /**
   * 离休证
   */
  RETIREMENT_CARD("211", "离休证"),
  /**
   * 老年证
   */
  ELDERLY_CARD("213", "老年证"),
  /**
   * 残疾证
   */
  DISABLED_CARD("217", "残疾证"),
  /**
   * 结婚证
   */
  MARRIAGE_CARD("219", "结婚证"),
  /**
   * 离婚证
   */
  DIVORCE_CARD("221", "离婚证"),
  /**
   * 独生子女证
   */
  ONLY_CHILD_CARD("223", "独生子女证"),
  /**
   * 毕业证书
   */
  GRADUATION_CARD("225", "毕业证书"),
  /**
   * 肄业证
   */
  DROP_OUT_CARD("227", "肄业证"),
  /**
   * 结业证
   */
  GRADUATION_CARD_2("229", "结业证"),
  /**
   * 学位证
   */
  DEGREE_CARD("231", "学位证"),
  /**
   * 机动车驾驶证
   */
  DRIVING_LICENSE("335", "机动车驾驶证"),
  /**
   * 外交护照
   */
  DIPLOMATIC_PASSPORT("411", "外交护照"),
  /**
   * 公务护照
   */
  OFFICIAL_PASSPORT("412", "公务护照"),
  /**
   * 因公普通护照
   */
  OFFICIAL_PASSPORT_2("413", "因公普通护照"),
  /**
   * 普通护照
   */
  PASSPORT("414", "普通护照"),
  /**
   * 外国人出入境证
   */
  FOREIGNER_ENTRY_EXIT_CARD("417", "外国人出入境证"),
  /**
   * 外国人旅行证
   */
  FOREIGNER_TRAVEL_CARD("418", "外国人旅行证"),
  /**
   * 海员证
   */
  SEAMAN_CARD("419", "海员证"),
  /**
   * 香港特别行政区护照
   */
  HONG_KONG_PASSPORT("420", "香港特别行政区护照"),
  /**
   * 澳门特别行政区护照
   */
  MACAO_PASSPORT("421", "澳门特别行政区护照"),
  /**
   * 澳门特别行政区旅行证
   */
  MACAO_TRAVEL_CARD("423", "澳门特别行政区旅行证"),
  /**
   * 台湾居民来往大陆通行证
   */
  TAIWAN_TRAVEL_CARD("511", "台湾居民来往大陆通行证"),
  /**
   * 往来港澳通行证
   */
  HONG_KONG_TRAVEL_CARD("513", "往来港澳通行证"),
  /**
   * 前往港澳通行证
   */
  HONG_KONG_TRAVEL_CARD_2("515", "前往港澳通行证"),
  /**
   * 港澳同胞回乡证
   */
  HONG_KONG_TRAVEL_CARD_3("516", "港澳同胞回乡证（通行卡）"),
  /**
   * 大陆居民往来台湾通行证
   */
  TAIWAN_TRAVEL_CARD_2("517", "大陆居民往来台湾通行证"),
  /**
   * 因公往来香港澳门特别行政区通行证
   */
  HONG_KONG_TRAVEL_CARD_4("518", "因公往来香港澳门特别行政区通行证"),
  /**
   * 华侨回归定居证
   */
  OVERSEA_SETTLEMENT_CARD("551", "华侨回归定居证"),
  /**
   * 台湾居民定居证
   */
  TAIWAN_SETTLEMENT_CARD("552", "台湾居民定居证"),
  /**
   * 外国人永久居留身份证
   */
  FOREIGNER_PERMANENT_RESIDENCE_CARD("553", "外国人永久居留身份证"),
  /**
   * 外国人居留证
   */
  FOREIGNER_RESIDENCE_CARD("554", "外国人居留证"),
  /**
   * 外国人临时居留证
   */
  FOREIGNER_TEMP_RESIDENCE_CARD("555", "外国人临时居留证"),
  /**
   * 入籍证书
   */
  ENTRY_CARD("556", "入籍证书"),
  /**
   * 出籍证书
   */
  EXIT_CARD("557", "出籍证书"),
  /**
   * 复籍证书
   */
  REENTRY_CARD("558", "复籍证书"),
  /**
   * 其他
   */
  OTHER("990", "其他"),
  /**
   * 港澳台居民居住证
   */
  GAT_RESIDENCE_CARD("1000", "港澳台居民居住证");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  /**
   * 码表文字描述
   */
  private final String description;
}
