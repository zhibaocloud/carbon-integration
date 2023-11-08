package com.zhibaocloud.carbon.intg.sdk;

import com.zhibaocloud.carbon.CarbonJacksonMapperFactory;
import com.zhibaocloud.carbon.intg.mapper.CarbonMapper;
import com.zhibaocloud.carbon.intg.model.CarbonApplicant;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author yangtuo
 */

class DesensitizationTest {

    private final CarbonMapper mapper = new CarbonJacksonMapperFactory(false).create();

    @Test
    void testDesensitization() throws IOException {
        CarbonApplicant appnt = new CarbonApplicant();
        appnt.setName("张三");
        appnt.setMobile("13800138000");
        appnt.setIdNo("110101199001011234");
        appnt.setEmail("zhangsan@mail.com");

        String content = mapper.writeValueAsString(appnt);
        assertThat(content).isEqualTo(
                "{\"email\":\"********@mail.com\",\"idNo\":\"1101**************1234\",\"mobile\":\"138****8000\"," +
                        "\"name\":\"张三\"}"
        );
    }
}
