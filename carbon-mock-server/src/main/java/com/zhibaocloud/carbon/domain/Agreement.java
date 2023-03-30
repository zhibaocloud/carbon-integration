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

package com.zhibaocloud.carbon.domain;

import com.zhbiaocloud.carbon.crypto.CryptoConfiguration;
import com.zhibaocloud.carbon.demo.DemoConfiguration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 * 代理协议
 *
 * @author jun
 */
@Getter
@Setter
@Entity
@Table(name = "agreements")
public class Agreement {

  @Id
  @Column(name = "id")
  private UUID id = UUID.randomUUID();

  /**
   * 合作协议名称
   */
  @Column(name = "title")
  private String title;

  /**
   * 代理公司
   */
  @Column(name = "agency")
  private String agency;

  /**
   * 产品供应商
   */
  @Column(name = "supplier")
  private String supplier;

  @Transient
  public CryptoConfiguration getConfig() {
    return DemoConfiguration.crypto();
  }
}
