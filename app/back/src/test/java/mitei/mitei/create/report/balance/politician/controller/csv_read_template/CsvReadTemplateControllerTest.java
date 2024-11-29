package mitei.mitei.create.report.balance.politician.controller.csv_read_template;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;
import mitei.mitei.create.report.balance.politician.dto.institution_csv.CsvReadTemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * CsvReadTemplateController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTemplateControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    void test() throws Exception {

        CsvReadTemplateCapsuleDto capsuleDto = this.createCapsuleDto();
        /* ビジネス処理特有の値を設定 */
        capsuleDto.setArrayNumber(7); // CHECKSTYLE:OFF

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/csv-read-template/select-template-by-number")
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        String ans = "[{\"csvReadTemplateCode\":2,\"csvReadTemplateName\":\"きつねが木の葉で払うPay\",\"arrayText\":\"15,1,2,16,0,0,0\",\"financialOrgName\":\"きつねが木の葉で払うPay\",\"arrayNumber\":7,\"financialOrgKbn\":1,\"financialOrgCode\":1,\"updateTime\":\"2012-12-12T15:00:00.000+00:00\",\"saishinKbn\":1,\"tableAllSearchText\":\"きつねが木の葉で払うpay\",\"csvReadTemplateId\":2,\"financialOrgId\":1,\"value\":\"2\",\"text\":\"きつねが木の葉で払うPay\"},{\"csvReadTemplateCode\":1,\"csvReadTemplateName\":\"首都圏信用金庫\",\"arrayText\":\"15,1,2,16,0,0,0\",\"financialOrgName\":\"首都圏信用金庫\",\"arrayNumber\":7,\"financialOrgKbn\":2,\"financialOrgCode\":1,\"updateTime\":\"2012-12-11T15:00:00.000+00:00\",\"saishinKbn\":1,\"tableAllSearchText\":\"首都圏信用金庫\",\"csvReadTemplateId\":1,\"financialOrgId\":3,\"value\":\"1\",\"text\":\"首都圏信用金庫\"},{\"csvReadTemplateCode\":null,\"csvReadTemplateName\":null,\"arrayText\":\"0,0,0,0,0,0,0\",\"financialOrgName\":null,\"arrayNumber\":0,\"financialOrgKbn\":null,\"financialOrgCode\":null,\"updateTime\":null,\"saishinKbn\":null,\"tableAllSearchText\":null,\"csvReadTemplateId\":null,\"financialOrgId\":null,\"value\":\"0\",\"text\":\"選択解除\"}]";

        assertThat(responseContent).isEqualTo(ans);
    }

    /**
     * 共通処理が正常となるフレームワークDtoを取得する
     *
     * @return フレームワークDto
     */
    private CsvReadTemplateCapsuleDto createCapsuleDto() {

        CheckSecurityDto checkSecurityDto = new CheckSecurityDto();
        checkSecurityDto.setIsResult(true);
        checkSecurityDto.setIsRaiseExcception(false);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);

        CheckTransactionDto checkTransactionDto = new CheckTransactionDto();
        checkTransactionDto.setIsResult(true);
        checkTransactionDto.setIsRaiseExcception(false);
        checkTransactionDto.setIsSelectOnly(false);

        CsvReadTemplateCapsuleDto capsuleDto = new CsvReadTemplateCapsuleDto();

        capsuleDto.setCheckSecurityDto(checkSecurityDto);
        capsuleDto.setCheckPrivilegeDto(checkPrivilegeDto);
        capsuleDto.setCheckTransactionDto(checkTransactionDto);

        return capsuleDto;
    }
}
