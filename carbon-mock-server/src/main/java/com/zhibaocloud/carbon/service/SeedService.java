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

package com.zhibaocloud.carbon.service;

import com.zhibaocloud.carbon.demo.DemoConfiguration;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.repository.AgreementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 插入测试数据
 *
 * @author jun
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SeedService implements ApplicationListener<ApplicationStartedEvent> {

  private final AgreementRepository repo;

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    Agreement agreement = new Agreement();
    agreement.setId(DemoConfiguration.appId());
    agreement.setSupplier("XXXX保险公司");
    agreement.setAgency("XXXX保险代理");
    repo.saveAndFlush(agreement);

    log.info("Seed data imported.");
  }
}
