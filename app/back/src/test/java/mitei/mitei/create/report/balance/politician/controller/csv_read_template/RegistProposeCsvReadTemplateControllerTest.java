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

import mitei.mitei.create.report.balance.politician.dto.financial.FinancialOrgConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * RegistProposeCsvReadTemplateController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistProposeCsvReadTemplateControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    void test()throws Exception {
        
        RegistProposeCsvReadRemplateCapsuleDto capsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto);

        ProposeCsvReadTemplateEntity entity = new  ProposeCsvReadTemplateEntity();

        entity.setProposeCsvReadTemplateName("石のお金Pay共通");
        String arrayText = "0,15,2,1";
        entity.setArrayNumber(arrayText.split(",").length);
        entity.setArrayText(arrayText);
        entity.setFinancialOrgKbn(FinancialOrgConstants.VARIOUS);
        entity.setFinancialOrgId(1L);
        entity.setFinancialOrgCode(2);
        entity.setFinancialOrgName("石のお金Pay");
        entity.setHasHeader(false);
        
        capsuleDto.setProposeCsvReadTemplateEntity(entity);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/propose-csv-read-template/regist")
                        .content(objectMapper.writeValueAsString(capsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        TemplateFrameworkResultDto resultDto = objectMapper.readValue(responseContent, TemplateFrameworkResultDto.class);
        
        assertThat(resultDto.getIsOk()).isTrue();
    }

}
