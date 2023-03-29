/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "saas_agreements")
public class SaasAgreement {

  @Id
  private UUID id = UUID.randomUUID();

  /**
   * 合作协议名称
   */
  @Column(name = "title")
  private String title;
}
