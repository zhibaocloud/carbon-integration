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
 * 学历类型代码
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum DegreeType {

  /**
   * 学历类型
   */
  POSTGRADUATE("10", "研究生教育"),
  POSTGRADUATE_DOCTOR_GRADUATE("11", "博士研究生毕业"),
  POSTGRADUATE_DOCTOR_FINISH("12", "博士研究生结业"),
  POSTGRADUATE_DOCTOR_DROP_OUT("13", "博士研究生肄业"),
  POSTGRADUATE_MASTER_GRADUATE("14", "硕士研究生毕业"),
  POSTGRADUATE_MASTER_FINISH("15", "硕士研究生结业"),
  POSTGRADUATE_MASTER_DROP_OUT("16", "硕士研究生肄业"),
  POSTGRADUATE_GRADUATE("17", "研究生班毕业"),
  POSTGRADUATE_FINISH("18", "研究生班结业"),
  POSTGRADUATE_DROP_OUT("19", "研究生班肄业"),
  UNDERGRADUATE("20", "大学本科教育"),
  UNDERGRADUATE_GRADUATE("21", "大学本科毕业"),
  UNDERGRADUATE_FINISH("22", "大学本科结业"),
  UNDERGRADUATE_DROP_OUT("23", "大学本科肄业"),
  UNDERGRADUATE_COMMON_GRADUATE("28", "大学普通班毕业"),
  JUNIOR_COLLEGE("30", "大学专科教育"),
  JUNIOR_COLLEGE_GRADUATE("31", "大学专科毕业"),
  JUNIOR_COLLEGE_FINISH("32", "大学专科结业"),
  JUNIOR_COLLEGE_DROP_OUT("33", "大学专科肄业"),
  JUNIOR_COLLEGE_VOCATIONAL_GRADUATE("44", "职业高中毕业"),
  JUNIOR_COLLEGE_VOCATIONAL_FINISH("45", "职业高中结业"),
  JUNIOR_COLLEGE_VOCATIONAL_DROP_OUT("46", "职业高中肄业"),
  JUNIOR_COLLEGE_TECHNICAL_GRADUATE("47", "技工学校毕业"),
  JUNIOR_COLLEGE_TECHNICAL_FINISH("48", "技工学校结业"),
  JUNIOR_COLLEGE_TECHNICAL_DROP_OUT("49", "技工学校肄业"),
  HIGH_SCHOOL("60", "普通高级中学教育"),
  HIGH_SCHOOL_GRADUATE("61", "普通高中毕业"),
  HIGH_SCHOOL_FINISH("62", "普通高中结业"),
  HIGH_SCHOOL_DROP_OUT("63", "普通高中肄业"),
  JUNIOR_HIGH_SCHOOL("70", "初级中学教育"),
  JUNIOR_HIGH_SCHOOL_GRADUATE("71", "初中毕业"),
  JUNIOR_HIGH_SCHOOL_DROP_OUT("73", "初中肄业"),
  PRIMARY_SCHOOL("80", "小学教育"),
  PRIMARY_SCHOOL_GRADUATE("81", "小学毕业"),
  PRIMARY_SCHOOL_DROP_OUT("83", "小学肄业"),
  OTHER("90", "其他");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  private final String description;
}
