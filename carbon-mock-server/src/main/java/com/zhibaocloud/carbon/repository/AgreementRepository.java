/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.repository;

import com.zhibaocloud.carbon.domain.Agreement;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 代理协议Repo
 *
 * @author jun
 */
@Repository
public interface AgreementRepository extends JpaRepository<Agreement, UUID> {

}
