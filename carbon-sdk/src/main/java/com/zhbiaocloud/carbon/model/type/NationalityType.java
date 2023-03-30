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

package com.zhbiaocloud.carbon.model.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 民族代码
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum NationalityType implements EncodedValue {

  /**
   * 民族代码
   */
  HAN("01", "汉族"),
  MONGOL("02", "蒙古族"),
  HUI("03", "回族"),
  TIBETAN("04", "藏族"),
  UYGHUR("05", "维吾尔族"),
  MIAO("06", "苗族"),
  YI("07", "彝族"),
  ZHUANG("08", "壮族"),
  BUYEI("09", "布依族"),
  KOREAN("10", "朝鲜族"),
  MANCHU("11", "满族"),
  DONG("12", "侗族"),
  YAO("13", "瑶族"),
  BAI("14", "白族"),
  TUJIA("15", "土家族"),
  HANI("16", "哈尼族"),
  KAZAKH("17", "哈萨克族"),
  DAI("18", "傣族"),
  LI("19", "黎族"),
  LISU("20", "傈傈族"),
  VA("21", "佤族"),
  SHE("22", "畲族"),
  GAOSHAN("23", "高山族"),
  LAHU("24", "拉祜族"),
  SUI("25", "水族"),
  DONGXIANG("26", "东乡族"),
  NAXI("27", "纳西族"),
  JINGPO("28", "景颇族"),
  KIRGIZ("29", "柯尔克孜族"),
  TU("30", "土族"),
  DAUR("31", "达斡尔族"),
  MULAO("32", "仫佬族"),
  QIANG("33", "羌族"),
  BLANG("34", "布朗族"),
  SALAR("35", "撒拉族"),
  MAONAN("36", "毛南族"),
  GELAO("37", "仡佬族"),
  XIBE("38", "锡伯族"),
  ACHANG("39", "阿昌族"),
  PUMI("40", "普米族"),
  TAJIK("41", "塔吉克族"),
  NU("42", "怒族"),
  UZBEK("43", "乌孜别克族"),
  RUSSIAN("44", "俄罗斯族"),
  EWENKI("45", "鄂温克族"),
  DEANG("46", "德昂族"),
  BONAN("47", "保安族"),
  YUGUR("48", "裕固族"),
  JING("49", "京族"),
  TATAR("50", "塔塔尔族"),
  DRUNG("51", "独龙族"),
  OROQEN("52", "鄂伦春族"),
  HEZHEN("53", "赫哲族"),
  MENBA("54", "门巴族"),
  LUOBA("55", "珞巴族"),
  JINO("56", "基诺族"),
  UNKNOWN("99", "未知");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
