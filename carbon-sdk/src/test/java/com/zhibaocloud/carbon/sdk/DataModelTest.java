/*
 * Copyright (c) 2018-2023. 成都市维斯凡科技有限公司 All rights reserved.
 */

package com.zhibaocloud.carbon.sdk;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhbiaocloud.carbon.CarbonMapperFactory;
import com.zhbiaocloud.carbon.EnumUtils;
import com.zhbiaocloud.carbon.model.Applicant;
import com.zhbiaocloud.carbon.model.Insured;
import com.zhbiaocloud.carbon.model.Policy;
import com.zhbiaocloud.carbon.model.type.DegreeType;
import com.zhbiaocloud.carbon.model.type.GenderType;
import com.zhbiaocloud.carbon.model.type.IdType;
import com.zhbiaocloud.carbon.model.type.MarriageType;
import com.zhbiaocloud.carbon.model.type.NationType;
import com.zhbiaocloud.carbon.model.type.NationalityType;
import com.zhbiaocloud.carbon.model.type.PayIntv;
import com.zhbiaocloud.carbon.model.type.PolicyStatus;
import com.zhbiaocloud.carbon.model.type.RelationType;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class DataModelTest {

  private final ObjectMapper mapper = new CarbonMapperFactory().create();

  @Test
  void testEnumTools() {
    GenderType gender = EnumUtils.fromValue(GenderType.class, "1");
    assertThat(gender).isEqualTo(GenderType.MALE);

    NationType nation = EnumUtils.fromValue(NationType.class, "CHN");
    assertThat(nation).isEqualTo(NationType.CHN);
  }

  private Applicant createAppnt() {
    Applicant appnt = new Applicant();
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

  private Insured createInsured() {
    Insured insured = new Insured();
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

  private Policy createPolicy() {
    Policy policy = new Policy();
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
    policy.setStatus(PolicyStatus.VALID);
    policy.setApplicant(this.createAppnt());
    policy.setInsureds(List.of(this.createInsured()));
    return policy;
  }

  @Test
  void testPolicyModel() throws IOException {
    Policy policy = this.createPolicy();
    String json = mapper.writeValueAsString(policy);
    Policy restored = mapper.readValue(json, Policy.class);
    assertThat(restored).isEqualTo(policy);
    assertThat(restored).hasSameHashCodeAs(policy);

    System.out.println(json);
  }
}
