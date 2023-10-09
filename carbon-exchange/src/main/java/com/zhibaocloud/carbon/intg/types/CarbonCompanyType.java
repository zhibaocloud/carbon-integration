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
 * 保险公司类型
 *
 * @author jun
 */
@Getter
@RequiredArgsConstructor
public enum CarbonCompanyType implements EncodedValue {


  /**
   * 友邦保险有限公司北京分公司
   */
  C000037110000("000037110000", "友邦保险有限公司北京分公司"),

  /**
   * 友邦保险有限公司上海分公司
   */
  C000037310000("000037310000", "友邦保险有限公司上海分公司"),

  /**
   * 友邦保险有限公司江苏分公司
   */
  C000037320000("000037320000", "友邦保险有限公司江苏分公司"),

  /**
   * 友邦保险有限公司广东分公司
   */
  C000037440000("000037440000", "友邦保险有限公司广东分公司"),

  /**
   * 友邦保险有限公司深圳分公司
   */
  C000037440300("000037440300", "友邦保险有限公司深圳分公司"),

  /**
   * 友邦保险有限公司江门支公司
   */
  C000037440700("000037440700", "友邦保险有限公司江门支公司"),

  /**
   * 友邦保险有限公司东莞支公司
   */
  C000037441900("000037441900", "友邦保险有限公司东莞支公司"),

  /**
   * 瑞士再保险股份有限公司北京分公司
   */
  C000058("000058", "瑞士再保险股份有限公司北京分公司"),

  /**
   * 慕尼黑再保险公司北京分公司
   */
  C000059("000059", "慕尼黑再保险公司北京分公司"),

  /**
   * 德国通用再保险股份公司上海分公司
   */
  C000066("000066", "德国通用再保险股份公司上海分公司"),

  /**
   * 法国再保险公司北京分公司
   */
  C000125("000125", "法国再保险公司北京分公司"),

  /**
   * 汉诺威再保险股份公司上海分公司
   */
  C000128("000128", "汉诺威再保险股份公司上海分公司"),

  /**
   * RGA美国再保险公司上海分公司
   */
  C000182("000182", "RGA美国再保险公司上海分公司"),

  /**
   * 中宏人寿保险有限公司
   */
  C000028("000028", "中宏人寿保险有限公司"),

  /**
   * 建信人寿保险股份有限公司
   */
  C000029("000029", "建信人寿保险股份有限公司"),

  /**
   * 安联人寿保险有限公司
   */
  C000030("000030", "安联人寿保险有限公司"),

  /**
   * 工银安盛人寿保险有限公司
   */
  C000031("000031", "工银安盛人寿保险有限公司"),

  /**
   * 中国人民财产保险股份有限公司
   */
  C000002("000002", "中国人民财产保险股份有限公司"),

  /**
   * 中国大地财产保险股份有限公司
   */
  C000010("000010", "中国大地财产保险股份有限公司"),

  /**
   * 中华联合财产保险股份有限公司
   */
  C000012("000012", "中华联合财产保险股份有限公司"),

  /**
   * 中国太平洋财产保险股份有限公司
   */
  C000014("000014", "中国太平洋财产保险股份有限公司"),

  /**
   * 中国平安财产保险股份有限公司
   */
  C000017("000017", "中国平安财产保险股份有限公司"),

  /**
   * 天安财产保险股份有限公司
   */
  C000022("000022", "天安财产保险股份有限公司"),

  /**
   * 史带财产保险股份有限公司
   */
  C000023("000023", "史带财产保险股份有限公司"),

  /**
   * 华安财产保险股份有限公司
   */
  C000024("000024", "华安财产保险股份有限公司"),

  /**
   * 永安财产保险股份有限公司
   */
  C000025("000025", "永安财产保险股份有限公司"),

  /**
   * 太平财产保险有限公司
   */
  C000026("000026", "太平财产保险有限公司"),

  /**
   * 亚太财产保险有限公司
   */
  C000038("000038", "亚太财产保险有限公司"),

  /**
   * 美亚财产保险有限公司
   */
  C000039("000039", "美亚财产保险有限公司"),

  /**
   * 东京海上日动火灾保险
   */
  C000040("000040", "东京海上日动火灾保险（中国）有限公司"),

  /**
   * 瑞再企商保险有限公司
   */
  C000042("000042", "瑞再企商保险有限公司"),

  /**
   * 安达保险有限公司
   */
  C000043("000043", "安达保险有限公司"),

  /**
   * 三井住友海上火灾保险
   */
  C000044("000044", "三井住友海上火灾保险（中国）有限公司"),

  /**
   * 三星财产保险
   */
  C000045("000045", "三星财产保险（中国）有限公司"),

  /**
   * 中银保险有限公司
   */
  C000046("000046", "中银保险有限公司"),

  /**
   * 京东安联财产保险有限公司
   */
  C000050("000050", "京东安联财产保险有限公司"),

  /**
   * 日本财产保险
   */
  C000053("000053", "日本财产保险（中国）有限公司"),

  /**
   * 利宝保险有限公司
   */
  C000060("000060", "利宝保险有限公司"),

  /**
   * 太平洋安信农业保险股份有限公司
   */
  C000064("000064", "太平洋安信农业保险股份有限公司"),

  /**
   * 中航安盟财产保险有限公司
   */
  C000067("000067", "中航安盟财产保险有限公司"),

  /**
   * 永诚财产保险股份有限公司
   */
  C000068("000068", "永诚财产保险股份有限公司"),

  /**
   * 安华农业保险股份有限公司
   */
  C000075("000075", "安华农业保险股份有限公司"),

  /**
   * 安盛天平财产保险有限公司
   */
  C000078("000078", "安盛天平财产保险有限公司"),

  /**
   * 阳光财产保险股份有限公司
   */
  C000093("000093", "阳光财产保险股份有限公司"),

  /**
   * 阳光农业相互保险公司
   */
  C000094("000094", "阳光农业相互保险公司"),

  /**
   * 都邦财产保险股份有限公司
   */
  C000096("000096", "都邦财产保险股份有限公司"),

  /**
   * 渤海财产保险股份有限公司
   */
  C000098("000098", "渤海财产保险股份有限公司"),

  /**
   * 华农财产保险股份有限公司
   */
  C000101("000101", "华农财产保险股份有限公司"),

  /**
   * 苏黎世财产保险
   */
  C000104("000104", "苏黎世财产保险（中国）有限公司"),

  /**
   * 中国人寿财产保险股份有限公司
   */
  C000108("000108", "中国人寿财产保险股份有限公司"),

  /**
   * 安诚财产保险股份有限公司
   */
  C000110("000110", "安诚财产保险股份有限公司"),

  /**
   * 现代财产保险
   */
  C000111("000111", "现代财产保险（中国）有限公司"),

  /**
   * 长安责任保险股份有限公司
   */
  C000112("000112", "长安责任保险股份有限公司"),

  /**
   * 劳合社保险
   */
  C000113("000113", "劳合社保险（中国）有限公司"),

  /**
   * 中意财产保险有限公司
   */
  C000117("000117", "中意财产保险有限公司"),

  /**
   * 爱和谊日生同和财产保险
   */
  C000118("000118", "爱和谊日生同和财产保险（中国）有限公司"),

  /**
   * 国元农业保险股份有限公司
   */
  C000126("000126", "国元农业保险股份有限公司"),

  /**
   * 鼎和财产保险股份有限公司
   */
  C000129("000129", "鼎和财产保险股份有限公司"),

  /**
   * 中煤财产保险股份有限公司
   */
  C000132("000132", "中煤财产保险股份有限公司"),

  /**
   * 国泰财产保险有限责任公司
   */
  C000133("000133", "国泰财产保险有限责任公司"),

  /**
   * 英大泰和财产保险股份有限公司
   */
  C000135("000135", "英大泰和财产保险股份有限公司"),

  /**
   * 紫金财产保险股份有限公司
   */
  C000137("000137", "紫金财产保险股份有限公司"),

  /**
   * 日本兴亚财产保险
   */
  C000139("000139", "日本兴亚财产保险（中国）有限责任公司"),

  /**
   * 浙商财产保险股份有限公司
   */
  C000140("000140", "浙商财产保险股份有限公司"),

  /**
   * 国任财产保险股份有限公司
   */
  C000142("000142", "国任财产保险股份有限公司"),

  /**
   * 凯本财产保险
   */
  C000143("000143", "凯本财产保险（中国）有限公司"),

  /**
   * 富邦财产保险有限公司
   */
  C000146("000146", "富邦财产保险有限公司"),

  /**
   * 泰山财产保险股份有限公司
   */
  C000148("000148", "泰山财产保险股份有限公司"),

  /**
   * 锦泰财产保险股份有限公司
   */
  C000149("000149", "锦泰财产保险股份有限公司"),

  /**
   * 众诚汽车保险股份有限公司
   */
  C000151("000151", "众诚汽车保险股份有限公司"),

  /**
   * 华泰财产保险有限公司
   */
  C000154("000154", "华泰财产保险有限公司"),

  /**
   * 长江财产保险股份有限公司
   */
  C000156("000156", "长江财产保险股份有限公司"),

  /**
   * 诚泰财产保险股份有限公司
   */
  C000158("000158", "诚泰财产保险股份有限公司"),

  /**
   * 安邦财产保险股份有限公司
   */
  C000159("000159", "安邦财产保险股份有限公司"),

  /**
   * 富德财产保险股份有限公司
   */
  C000163("000163", "富德财产保险股份有限公司"),

  /**
   * 鑫安汽车保险股份有限公司
   */
  C000165("000165", "鑫安汽车保险股份有限公司"),

  /**
   * 北部湾财产保险股份有限公司
   */
  C000173("000173", "北部湾财产保险股份有限公司"),

  /**
   * 众安在线财产保险股份有限公司
   */
  C000179("000179", "众安在线财产保险股份有限公司"),

  /**
   * 中石油专属财产保险股份有限公司
   */
  C000180("000180", "中石油专属财产保险股份有限公司"),

  /**
   * 华海财产保险股份有限公司
   */
  C000183("000183", "华海财产保险股份有限公司"),

  /**
   * 燕赵财产保险股份有限公司
   */
  C000185("000185", "燕赵财产保险股份有限公司"),

  /**
   * 恒邦财产保险股份有限公司
   */
  C000187("000187", "恒邦财产保险股份有限公司"),

  /**
   * 合众财产保险股份有限公司
   */
  C000189("000189", "合众财产保险股份有限公司"),

  /**
   * 中路财产保险股份有限公司
   */
  C000192("000192", "中路财产保险股份有限公司"),

  /**
   * 中原农业保险股份有限公司
   */
  C000195("000195", "中原农业保险股份有限公司"),

  /**
   * 中国铁路财产保险自保有限公司
   */
  C000196("000196", "中国铁路财产保险自保有限公司"),

  /**
   * 泰康在线财产保险股份有限公司
   */
  C000199("000199", "泰康在线财产保险股份有限公司"),

  /**
   * 东海航运保险股份有限公司
   */
  C000202("000202", "东海航运保险股份有限公司"),

  /**
   * 安心财产保险有限责任公司
   */
  C000203("000203", "安心财产保险有限责任公司"),

  /**
   * 阳光信用保证保险股份有限公司
   */
  C000204("000204", "阳光信用保证保险股份有限公司"),

  /**
   * 易安财产保险股份有限公司
   */
  C000205("000205", "易安财产保险股份有限公司"),

  /**
   * 久隆财产保险有限公司
   */
  C000206("000206", "久隆财产保险有限公司"),

  /**
   * 新疆前海联合财产保险股份有限公司
   */
  C000208("000208", "新疆前海联合财产保险股份有限公司"),

  /**
   * 珠峰财产保险股份有限公司
   */
  C000209("000209", "珠峰财产保险股份有限公司"),

  /**
   * 海峡金桥财产保险股份有限公司
   */
  C000210("000210", "海峡金桥财产保险股份有限公司"),

  /**
   * 建信财产保险有限公司
   */
  C000212("000212", "建信财产保险有限公司"),

  /**
   * 中远海运财产保险自保有限公司
   */
  C000219("000219", "中远海运财产保险自保有限公司"),

  /**
   * 众惠财产相互保险社
   */
  C000221("000221", "众惠财产相互保险社"),

  /**
   * 广东能源财产保险自保有限公司
   */
  C000229("000229", "广东能源财产保险自保有限公司"),

  /**
   * 黄河财产保险股份有限公司
   */
  C000231("000231", "黄河财产保险股份有限公司"),

  /**
   * 太平科技保险股份有限公司
   */
  C000232("000232", "太平科技保险股份有限公司"),

  /**
   * 融盛财产保险股份有限公司
   */
  C000238("000238", "融盛财产保险股份有限公司"),

  /**
   * 汇友财产相互保险社
   */
  C000225("000225", "汇友财产相互保险社"),

  /**
   * 中国财产再保险有限责任公司
   */
  C000008("000008", "中国财产再保险有限责任公司"),

  /**
   * 中国人寿再保险有限责任公司
   */
  C000009("000009", "中国人寿再保险有限责任公司"),

  /**
   * 信利再保险
   */
  C000147("000147", "信利再保险（中国）有限公司"),

  /**
   * 太平再保险
   */
  C000201("000201", "太平再保险（中国）有限公司"),

  /**
   * 前海再保险股份有限公司
   */
  C000215("000215", "前海再保险股份有限公司"),

  /**
   * 人保再保险股份有限公司
   */
  C000222("000222", "人保再保险股份有限公司"),

  /**
   * 中国人寿保险股份有限公司
   */
  C000005("000005", "中国人寿保险股份有限公司"),

  /**
   * 中国太平洋人寿保险股份有限公司
   */
  C000015("000015", "中国太平洋人寿保险股份有限公司"),

  /**
   * 中国平安人寿保险股份有限公司
   */
  C000018("000018", "中国平安人寿保险股份有限公司"),

  /**
   * 新华人寿保险股份有限公司
   */
  C000019("000019", "新华人寿保险股份有限公司"),

  /**
   * 太平人寿保险有限公司
   */
  C000027("000027", "太平人寿保险有限公司"),

  /**
   * 中信保诚人寿保险有限公司
   */
  C000032("000032", "中信保诚人寿保险有限公司"),

  /**
   * 交银人寿保险有限公司
   */
  C000033("000033", "交银人寿保险有限公司"),

  /**
   * 天安人寿保险股份有限公司
   */
  C000034("000034", "天安人寿保险股份有限公司"),

  /**
   * 中意人寿保险有限公司
   */
  C000035("000035", "中意人寿保险有限公司"),

  /**
   * 光大永明人寿保险有限公司
   */
  C000036("000036", "光大永明人寿保险有限公司"),

  /**
   * 北大方正人寿保险有限公司
   */
  C000047("000047", "北大方正人寿保险有限公司"),

  /**
   * 中荷人寿保险有限公司
   */
  C000048("000048", "中荷人寿保险有限公司"),

  /**
   * 中英人寿保险有限公司
   */
  C000049("000049", "中英人寿保险有限公司"),

  /**
   * 同方全球人寿保险有限公司
   */
  C000051("000051", "同方全球人寿保险有限公司"),

  /**
   * 民生人寿保险股份有限公司
   */
  C000052("000052", "民生人寿保险股份有限公司"),

  /**
   * 招商信诺人寿保险有限公司
   */
  C000054("000054", "招商信诺人寿保险有限公司"),

  /**
   * 长生人寿保险有限公司
   */
  C000055("000055", "长生人寿保险有限公司"),

  /**
   * 恒安标准人寿保险有限公司
   */
  C000056("000056", "恒安标准人寿保险有限公司"),

  /**
   * 瑞泰人寿保险有限公司
   */
  C000057("000057", "瑞泰人寿保险有限公司"),

  /**
   * 富德生命人寿保险股份有限公司
   */
  C000061("000061", "富德生命人寿保险股份有限公司"),

  /**
   * 小康人寿保险有限责任公司
   */
  C000071("000071", "小康人寿保险有限责任公司"),

  /**
   * 合众人寿保险股份有限公司
   */
  C000074("000074", "合众人寿保险股份有限公司"),

  /**
   * 华泰人寿保险股份有限公司
   */
  C000076("000076", "华泰人寿保险股份有限公司"),

  /**
   * 陆家嘴国泰人寿保险有限责任公司
   */
  C000077("000077", "陆家嘴国泰人寿保险有限责任公司"),

  /**
   * 中美联泰大都会人寿保险有限公司
   */
  C000083("000083", "中美联泰大都会人寿保险有限公司"),

  /**
   * 华夏人寿保险股份有限公司
   */
  C000086("000086", "华夏人寿保险股份有限公司"),

  /**
   * 中银三星人寿保险有限公司
   */
  C000087("000087", "中银三星人寿保险有限公司"),

  /**
   * 君康人寿保险股份有限公司
   */
  C000090("000090", "君康人寿保险股份有限公司"),

  /**
   * 信泰人寿保险股份有限公司
   */
  C000091("000091", "信泰人寿保险股份有限公司"),

  /**
   * 农银人寿保险股份有限公司
   */
  C000092("000092", "农银人寿保险股份有限公司"),

  /**
   * 长城人寿保险股份有限公司
   */
  C000095("000095", "长城人寿保险股份有限公司"),

  /**
   * 中国人民人寿保险股份有限公司
   */
  C000100("000100", "中国人民人寿保险股份有限公司"),

  /**
   * 国华人寿保险股份有限公司
   */
  C000102("000102", "国华人寿保险股份有限公司"),

  /**
   * 恒大人寿保险有限公司
   */
  C000103("000103", "恒大人寿保险有限公司"),

  /**
   * 英大泰和人寿保险股份有限公司
   */
  C000121("000121", "英大泰和人寿保险股份有限公司"),

  /**
   * 幸福人寿保险股份有限公司
   */
  C000124("000124", "幸福人寿保险股份有限公司"),

  /**
   * 阳光人寿保险股份有限公司
   */
  C000127("000127", "阳光人寿保险股份有限公司"),

  /**
   * 鼎诚人寿保险有限责任公司
   */
  C000130("000130", "鼎诚人寿保险有限责任公司"),

  /**
   * 汇丰人寿保险有限公司
   */
  C000131("000131", "汇丰人寿保险有限公司"),

  /**
   * 君龙人寿保险有限公司
   */
  C000136("000136", "君龙人寿保险有限公司"),

  /**
   * 百年人寿保险股份有限公司
   */
  C000138("000138", "百年人寿保险股份有限公司"),

  /**
   * 中邮人寿保险股份有限公司
   */
  C000141("000141", "中邮人寿保险股份有限公司"),

  /**
   * 中融人寿保险股份有限公司
   */
  C000144("000144", "中融人寿保险股份有限公司"),

  /**
   * 大家人寿保险股份有限公司
   */
  C000145("000145", "大家人寿保险股份有限公司"),

  /**
   * 利安人寿保险股份有限公司
   */
  C000152("000152", "利安人寿保险股份有限公司"),

  /**
   * 华汇人寿保险股份有限公司
   */
  C000157("000157", "华汇人寿保险股份有限公司"),

  /**
   * 前海人寿保险股份有限公司
   */
  C000160("000160", "前海人寿保险股份有限公司"),

  /**
   * 东吴人寿保险股份有限公司
   */
  C000164("000164", "东吴人寿保险股份有限公司"),

  /**
   * 弘康人寿保险股份有限公司
   */
  C000166("000166", "弘康人寿保险股份有限公司"),

  /**
   * 珠江人寿保险股份有限公司
   */
  C000167("000167", "珠江人寿保险股份有限公司"),

  /**
   * 财信吉祥人寿保险股份有限公司
   */
  C000168("000168", "财信吉祥人寿保险股份有限公司"),

  /**
   * 复星保德信人寿保险有限公司
   */
  C000169("000169", "复星保德信人寿保险有限公司"),

  /**
   * 中韩人寿保险有限公司
   */
  C000171("000171", "中韩人寿保险有限公司"),

  /**
   * 德华安顾人寿保险有限公司
   */
  C000176("000176", "德华安顾人寿保险有限公司"),

  /**
   * 渤海人寿保险股份有限公司
   */
  C000186("000186", "渤海人寿保险股份有限公司"),

  /**
   * 国联人寿保险股份有限公司
   */
  C000188("000188", "国联人寿保险股份有限公司"),

  /**
   * 上海人寿保险股份有限公司
   */
  C000190("000190", "上海人寿保险股份有限公司"),

  /**
   * 中华联合人寿保险股份有限公司
   */
  C000200("000200", "中华联合人寿保险股份有限公司"),

  /**
   * 泰康人寿保险有限责任公司
   */
  C000213("000213", "泰康人寿保险有限责任公司"),

  /**
   * 横琴人寿保险有限公司
   */
  C000216("000216", "横琴人寿保险有限公司"),

  /**
   * 和泰人寿保险股份有限公司
   */
  C000218("000218", "和泰人寿保险股份有限公司"),

  /**
   * 华贵人寿保险股份有限公司
   */
  C000220("000220", "华贵人寿保险股份有限公司"),

  /**
   * 信美人寿相互保险社
   */
  C000223("000223", "信美人寿相互保险社"),

  /**
   * 爱心人寿保险股份有限公司
   */
  C000224("000224", "爱心人寿保险股份有限公司"),

  /**
   * 招商局仁和人寿保险股份有限公司
   */
  C000226("000226", "招商局仁和人寿保险股份有限公司"),

  /**
   * 三峡人寿保险股份有限公司
   */
  C000230("000230", "三峡人寿保险股份有限公司"),

  /**
   * 北京人寿保险股份有限公司
   */
  C000233("000233", "北京人寿保险股份有限公司"),

  /**
   * 国宝人寿保险股份有限公司
   */
  C000234("000234", "国宝人寿保险股份有限公司"),

  /**
   * 海保人寿保险股份有限公司
   */
  C000236("000236", "海保人寿保险股份有限公司"),

  /**
   * 国富人寿保险股份有限公司
   */
  C000237("000237", "国富人寿保险股份有限公司"),

  /**
   * 平安养老保险股份有限公司
   */
  C000072("000072", "平安养老保险股份有限公司"),

  /**
   * 太平养老保险股份有限公司
   */
  C000082("000082", "太平养老保险股份有限公司"),

  /**
   * 中国人寿养老保险股份有限公司
   */
  C000109("000109", "中国人寿养老保险股份有限公司"),

  /**
   * 长江养老保险股份有限公司
   */
  C000120("000120", "长江养老保险股份有限公司"),

  /**
   * 泰康养老保险股份有限公司
   */
  C000122("000122", "泰康养老保险股份有限公司"),

  /**
   * 大家养老保险股份有限公司
   */
  C000181("000181", "大家养老保险股份有限公司"),

  /**
   * 新华养老保险股份有限公司
   */
  C000211("000211", "新华养老保险股份有限公司"),

  /**
   * 中国人民养老保险有限责任公司
   */
  C000228("000228", "中国人民养老保险有限责任公司"),

  /**
   * 平安健康保险股份有限公司
   */
  C000084("000084", "平安健康保险股份有限公司"),

  /**
   * 中国人民健康保险股份有限公司
   */
  C000085("000085", "中国人民健康保险股份有限公司"),

  /**
   * 昆仑健康保险股份有限公司
   */
  C000097("000097", "昆仑健康保险股份有限公司"),

  /**
   * 和谐健康保险股份有限公司
   */
  C000099("000099", "和谐健康保险股份有限公司"),

  /**
   * 太平洋健康保险股份有限公司
   */
  C000184("000184", "太平洋健康保险股份有限公司"),

  /**
   * 复星联合健康保险股份有限公司
   */
  C000217("000217", "复星联合健康保险股份有限公司"),

  /**
   * 瑞华健康保险股份有限公司
   */
  C000235("000235", "瑞华健康保险股份有限公司"),

  /**
   * 大家财产保险有限责任公司
   */
  C000242("000242", "大家财产保险有限责任公司");

  /**
   * 存储在数据库中的码值
   */
  private final String value;

  /**
   * 码表文字描述
   */
  private final String description;
}
