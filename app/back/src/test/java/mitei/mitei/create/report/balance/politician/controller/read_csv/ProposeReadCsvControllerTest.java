package mitei.mitei.create.report.balance.politician.controller.read_csv;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

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

import mitei.mitei.create.report.balance.politician.dto.read_csv.ReadCsvByEntityCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * ProposeReadCsvController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ProposeReadCsvControllerTest {
    // CHECKSTYLE:OFF

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPractice()throws Exception {
        
        ReadCsvByEntityCapsuleDto readCsvByEntityCapsuleDto = new ReadCsvByEntityCapsuleDto();
        
        CreateCommonCheckDtoTestOnlyUtil.practice(readCsvByEntityCapsuleDto);
        
        ProposeCsvReadTemplateEntity proposeCsvReadTemplateEntity = new  ProposeCsvReadTemplateEntity();

        //必要に応じて指定
        proposeCsvReadTemplateEntity.setProposeCsvReadTemplateId(0L);
        proposeCsvReadTemplateEntity.setProposeCsvReadTemplateCode(0);
        proposeCsvReadTemplateEntity.setShoshouId("");
        proposeCsvReadTemplateEntity.setShoshouCode(1233L);
        proposeCsvReadTemplateEntity.setShoshouKbn(1);
        
        readCsvByEntityCapsuleDto.setProposeCsvReadTemplateEntity(proposeCsvReadTemplateEntity);
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/read-csv-by-entity/practice")
                        .content(objectMapper.writeValueAsString(readCsvByEntityCapsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        System.out.println(responseContent);
        
        fail("Not yet implemented");
    }

}
