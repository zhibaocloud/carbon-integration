/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  /**
   * 加密算法
   */
  @Column(name = "encrypt_alg")
  private String encryptAlg;

  /**
   * 加解密Key
   */
  @Column(name = "secret")
  private String secret;

  /**
   * 加解密盐
   */
  @Column(name = "secret")
  private String salt;

  /**
   * 散列摘要算法
   */
  @Column(name = "hash_alg")
  private String hashAlg;
}
