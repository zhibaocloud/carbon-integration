/*
 * Copyright (c) 2018-2018-2023. Chengdu WeiSiFan Technology Co., Ltd.
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.intg.CarbonMapperFactory;
import com.zhbiaocloud.carbon.intg.model.EnumUtils;
import com.zhbiaocloud.carbon.intg.model.CarbonPolicy;
import com.zhbiaocloud.carbon.intg.model.CarbonAgent;
import com.zhbiaocloud.carbon.intg.model.CarbonApplicant;
import com.zhbiaocloud.carbon.intg.model.CarbonBeneficiary;
import com.zhbiaocloud.carbon.intg.model.CarbonInsured;
import com.zhbiaocloud.carbon.intg.model.CarbonRisk;
import com.zhbiaocloud.carbon.intg.types.BnfGrade;
import com.zhbiaocloud.carbon.intg.types.BnfType;
import com.zhbiaocloud.carbon.intg.types.DegreeType;
import com.zhbiaocloud.carbon.intg.types.GenderType;
import com.zhbiaocloud.carbon.intg.types.IdType;
import com.zhbiaocloud.carbon.intg.types.InsuredPeriod;
import com.zhbiaocloud.carbon.intg.types.MainRiskFlag;
import com.zhbiaocloud.carbon.intg.types.MarriageType;
import com.zhbiaocloud.carbon.intg.types.NationType;
import com.zhbiaocloud.carbon.intg.types.NationalityType;
import com.zhbiaocloud.carbon.intg.types.PayIntv;
import com.zhbiaocloud.carbon.intg.types.PayType;
import com.zhbiaocloud.carbon.intg.types.PaymentPeriod;
import com.zhbiaocloud.carbon.intg.types.PolicyStatus;
import com.zhbiaocloud.carbon.intg.types.RelationType;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class DataModelTest {

  private final ObjectMapper mapper = new CarbonMapperFactory(false).create();

  @Test
  void testEnumTools() {
    GenderType gender = EnumUtils.fromValue(GenderType.class, "1");
    assertThat(gender).isEqualTo(GenderType.MALE);
    GenderType unknown = EnumUtils.fromValue(GenderType.class, "99");
    assertThat(unknown).isNull();

    NationType nation = EnumUtils.fromValue(NationType.class, "CHN");
    assertThat(nation).isEqualTo(NationType.CHN);
  }

  private CarbonApplicant createAppnt() {
    CarbonApplicant appnt = new CarbonApplicant();
    appnt.setName("张三");
    appnt.setGender(GenderType.MALE);
    appnt.setBirthdate(LocalDate.of(1980, 1, 1));
    appnt.setIdType(IdType.ID_CARD);
    appnt.setIdNo("123456789012345678");
    appnt.setDegree(DegreeType.UNDERGRADUATE);
    appnt.setMarriage(MarriageType.MARRIED);
    appnt.setNation(NationType.CHN);
    appnt.setNationality(NationalityType.HAN);
    appnt.setIdValidStart(LocalDate.of(2010, 1, 1));
    appnt.setIdValidEnd(LocalDate.of(2020, 1, 1));
    appnt.setOccupationName("工程师");
    appnt.setOccupationType("1");
    appnt.setOccupationCode("999998");
    return appnt;
  }

  private CarbonInsured createInsured() {
    CarbonInsured insured = new CarbonInsured();
    insured.setRelationToApplicant(RelationType.SELF);
    insured.setName("张三");
    insured.setGender(GenderType.MALE);
    insured.setBirthdate(LocalDate.of(1980, 1, 1));
    insured.setIdType(IdType.ID_CARD);
    insured.setIdNo("123456789012345678");
    insured.setDegree(DegreeType.UNDERGRADUATE);
    insured.setMarriage(MarriageType.MARRIED);
    insured.setNation(NationType.CHN);
    insured.setNationality(NationalityType.HAN);
    insured.setIdValidStart(LocalDate.of(2010, 1, 1));
    insured.setIdValidEnd(LocalDate.of(2020, 1, 1));
    insured.setOccupationName("工程师");
    insured.setOccupationType("1");
    insured.setOccupationCode("999998");
    return insured;
  }

  private CarbonRisk createRisk() {
    CarbonRisk risk = new CarbonRisk();
    risk.setFlag(MainRiskFlag.MAIN);
    risk.setRiskCode("P000001");
    risk.setRiskName("XXXX重大疾病保险");
    risk.setPremium(new BigDecimal(5_000));
    risk.setAmount(new BigDecimal(100_000));
    risk.setPayTime(LocalDateTime.of(2023, 3, 29, 0, 0, 0));
    risk.setEffectiveTime(LocalDateTime.of(2023, 3, 30, 0, 0, 0));
    risk.setExpirationTime(LocalDateTime.of(2033, 3, 29, 23, 59, 59));
    risk.setPaymentPeriod(PaymentPeriod.of("5Y"));
    risk.setInsuredPeriod(InsuredPeriod.LIFE_LONG);
    return risk;
  }

  private CarbonBeneficiary createBnf() {
    CarbonBeneficiary insured = new CarbonBeneficiary();
    insured.setRelationToInsured(RelationType.SELF);
    insured.setBnfType(BnfType.SURVIVAL_BENEFICIARY);
    insured.setBnfGrade(BnfGrade.GRADE_1);
    insured.setBnfRatio(BigDecimal.valueOf(100));
    insured.setName("张三");
    insured.setGender(GenderType.MALE);
    insured.setBirthdate(LocalDate.of(1980, 1, 1));
    insured.setIdType(IdType.ID_CARD);
    insured.setIdNo("123456789012345678");
    insured.setDegree(DegreeType.UNDERGRADUATE);
    insured.setMarriage(MarriageType.MARRIED);
    insured.setNation(NationType.CHN);
    insured.setNationality(NationalityType.HAN);
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
    policy.setPayIntv(PayIntv.YEARLY);
    policy.setPayType(PayType.BANK_CARD);

    policy.setStatus(PolicyStatus.VALID);

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
    String json = mapper.writeValueAsString(policy);
    CarbonPolicy restored = mapper.readValue(json, CarbonPolicy.class);
    assertThat(restored).isEqualTo(policy);
    assertThat(restored).hasSameHashCodeAs(policy);

    System.out.println(json);
  }
}
