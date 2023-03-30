/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.service;

import com.zhibaocloud.carbon.demo.DemoConfiguration;
import com.zhibaocloud.carbon.domain.Agreement;
import com.zhibaocloud.carbon.repository.AgreementRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 插入测试数据
 *
 * @author jun
 */
@Service
@RequiredArgsConstructor
public class SeedService implements ApplicationListener<ApplicationStartedEvent> {

  private final AgreementRepository repo;

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    Agreement agreement = new Agreement();
    agreement.setId(UUID.fromString(DemoConfiguration.appId()));
    agreement.setSupplier("XXXX保险公司");
    agreement.setAgency("XXXX保险代理");
    repo.saveAndFlush(agreement);
  }
}
