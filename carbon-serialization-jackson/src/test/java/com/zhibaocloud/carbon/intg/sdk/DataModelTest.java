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

package com.zhibaocloud.carbon.intg.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.zhibaocloud.carbon.intg.jackson.CarbonJacksonSerializerFactory;
import com.zhibaocloud.carbon.intg.model.CarbonAgent;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import com.zhibaocloud.carbon.intg.model.CarbonBeneficiary;
import com.zhibaocloud.carbon.intg.model.CarbonInsured;
import com.zhibaocloud.carbon.intg.model.CarbonPolicy;
import com.zhibaocloud.carbon.intg.model.CarbonRisk;
import com.zhibaocloud.carbon.intg.serializer.CarbonSerializer;
import com.zhibaocloud.carbon.intg.serializer.SerializationConfiguration;
import com.zhibaocloud.carbon.intg.types.CarbonBnfGrade;
import com.zhibaocloud.carbon.intg.types.CarbonBnfType;
import com.zhibaocloud.carbon.intg.types.CarbonDegreeType;
import com.zhibaocloud.carbon.intg.types.CarbonGenderType;
import com.zhibaocloud.carbon.intg.types.CarbonIdType;
import com.zhibaocloud.carbon.intg.types.CarbonInsuredPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonMainRiskFlag;
import com.zhibaocloud.carbon.intg.types.CarbonMarriageType;
import com.zhibaocloud.carbon.intg.types.CarbonNationType;
import com.zhibaocloud.carbon.intg.types.CarbonNationalityType;
import com.zhibaocloud.carbon.intg.types.CarbonPayIntv;
import com.zhibaocloud.carbon.intg.types.CarbonPayType;
import com.zhibaocloud.carbon.intg.types.CarbonPaymentPeriod;
import com.zhibaocloud.carbon.intg.types.CarbonPolicyStatus;
import com.zhibaocloud.carbon.intg.types.CarbonRelationType;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class DataModelTest {

  private final CarbonSerializer mapper = new CarbonJacksonSerializerFactory()
      .create(new SerializationConfiguration());


  private CarbonApplicant createAppnt() {
    CarbonApplicant appnt = new CarbonApplicant();
    appnt.setName("张三");
    appnt.setGender(CarbonGenderType.MALE);
    appnt.setBirthdate(LocalDate.of(1980, 1, 1));
    appnt.setIdType(CarbonIdType.ID_CARD);
    appnt.setIdNo("123456789012345678");
    appnt.setDegree(CarbonDegreeType.UNDERGRADUATE);
    appnt.setMarriage(CarbonMarriageType.MARRIED);
    appnt.setNation(CarbonNationType.CHN);
    appnt.setNationality(CarbonNationalityType.HAN);
    appnt.setIdValidStart(LocalDate.of(2010, 1, 1));
    appnt.setIdValidEnd(LocalDate.of(2020, 1, 1));
    appnt.setOccupationName("工程师");
    appnt.setOccupationType("1");
    appnt.setOccupationCode("999998");
    return appnt;
  }

  private CarbonInsured createInsured() {
    CarbonInsured insured = new CarbonInsured();
    insured.setRelationToApplicant(CarbonRelationType.SELF);
    insured.setName("张三");
    insured.setGender(CarbonGenderType.MALE);
    insured.setBirthdate(LocalDate.of(1980, 1, 1));
    insured.setIdType(CarbonIdType.ID_CARD);
    insured.setIdNo("123456789012345678");
    insured.setDegree(CarbonDegreeType.UNDERGRADUATE);
    insured.setMarriage(CarbonMarriageType.MARRIED);
    insured.setNation(CarbonNationType.CHN);
    insured.setNationality(CarbonNationalityType.HAN);
    insured.setIdValidStart(LocalDate.of(2010, 1, 1));
    insured.setIdValidEnd(LocalDate.of(2020, 1, 1));
    insured.setOccupationName("工程师");
    insured.setOccupationType("1");
    insured.setOccupationCode("999998");
    return insured;
  }

  private CarbonRisk createRisk() {
    CarbonRisk risk = new CarbonRisk();
    risk.setFlag(CarbonMainRiskFlag.MAIN);
    risk.setRiskCode("P000001");
    risk.setRiskName("XXXX重大疾病保险");
    risk.setPremium(new BigDecimal(5_000));
    risk.setAmount(new BigDecimal(100_000));
    risk.setPayTime(LocalDateTime.of(2023, 3, 29, 0, 0, 0));
    risk.setEffectiveTime(LocalDateTime.of(2023, 3, 30, 0, 0, 0));
    risk.setExpirationTime(LocalDateTime.of(2033, 3, 29, 23, 59, 59));
    risk.setPaymentPeriod(CarbonPaymentPeriod.of("5Y"));
    risk.setInsuredPeriod(CarbonInsuredPeriod.LIFE_LONG);
    return risk;
  }

  private CarbonBeneficiary createBnf() {
    CarbonBeneficiary insured = new CarbonBeneficiary();
    insured.setRelationToInsured(CarbonRelationType.SELF);
    insured.setBnfType(CarbonBnfType.SURVIVAL_BENEFICIARY);
    insured.setBnfGrade(CarbonBnfGrade.GRADE_1);
    insured.setBnfRatio(BigDecimal.valueOf(100));
    insured.setName("张三");
    insured.setGender(CarbonGenderType.MALE);
    insured.setBirthdate(LocalDate.of(1980, 1, 1));
    insured.setIdType(CarbonIdType.ID_CARD);
    insured.setIdNo("123456789012345678");
    insured.setDegree(CarbonDegreeType.UNDERGRADUATE);
    insured.setMarriage(CarbonMarriageType.MARRIED);
    insured.setNation(CarbonNationType.CHN);
    insured.setNationality(CarbonNationalityType.HAN);
    insured.setIdValidStart(LocalDate.of(2010, 1, 1));
    insured.setIdValidEnd(LocalDate.of(2020, 1, 1));
    insured.setOccupationName("工程师");
    insured.setOccupationType("1");
    insured.setOccupationCode("999998");
    return insured;
  }

  private CarbonAgent createAgent() {
    CarbonAgent agent = new CarbonAgent();
    agent.setName("代理人姓名");
    agent.setCode("JD001");
    agent.setExtCode("9527");
    agent.setBusiDevCertifNo("26087373737373737");
    return agent;
  }

  private CarbonPolicy createPolicy() {
    CarbonPolicy policy = new CarbonPolicy();
    policy.setPolicyNo("PEG12345678");
    policy.setProposalNo("PEG12345678");
    policy.setPrtNo("HEG000000000");
    policy.setOrderNo("O00000001");
    policy.setExtOrderNo("EXT0000002");
    policy.setPreviousPolicyNo("PEG12345678PEV");
    policy.setPreviousProposalNo("PEG12345678PEV");
    policy.setManageCom("122222");
    policy.setManageComName("XXX保险公司YY省分公司");
    policy.setAgentCom("AGT000002");
    policy.setAgentComName("XXX保险代理YY省分公司");
    policy.setProductNo("P000001");
    policy.setProductName("XXXX重大疾病保险");
    policy.setPremium(new BigDecimal(5_000));
    policy.setAmount(new BigDecimal(100_000));
    policy.setEPolicyUrl("https://xxxx.com/xxxx/xxxx/xxxx.pdf");
    policy.setPayIntv(CarbonPayIntv.YEARLY);
    policy.setPayType(CarbonPayType.BANK_CARD);

    policy.setStatus(CarbonPolicyStatus.VALID);

    policy.setSignTime(LocalDateTime.of(2023, 3, 29, 0, 0, 0));
    policy.setApplyTime(LocalDateTime.of(2023, 3, 30, 0, 0, 0));
    policy.setEffectiveTime(LocalDateTime.of(2023, 3, 30, 0, 0, 0));
    policy.setExpirationTime(LocalDateTime.of(2033, 3, 29, 23, 59, 59));

    policy.setRtnCallSuccess(Boolean.FALSE);
    policy.setRtnCallTime(LocalDateTime.of(23, 3, 29, 18, 0, 0));
    policy.setRtnCallFailedReason("客户未接电话");

    policy.setAgent(this.createAgent());
    policy.setApplicant(this.createAppnt());
    policy.setInsureds(Collections.singletonList(this.createInsured()));
    policy.setRisks(Collections.singletonList(this.createRisk()));
    policy.setBnfs(Collections.singletonList(this.createBnf()));
    return policy;
  }

  @Test
  void testPolicyModel() throws IOException {
    CarbonPolicy policy = this.createPolicy();
    String json = mapper.serialize(policy);
    CarbonPolicy restored = mapper.deserialize(json, CarbonPolicy.class);
    assertThat(restored.getRisks().get(0).getRiskCode()).isEqualTo(restored.getRisks().get(0).getRiskCode());
    assertThat(restored.getRisks().get(0).getRiskCode().hashCode()).hasSameHashCodeAs(restored.getRisks().get(0).getRiskCode().hashCode());

    System.out.println(json);
  }
}
