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

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * CsvReadTemplateSearchAllSaishinController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CsvReadTemplateSearchAllSaishinControllerTest {
    // CHECKSTYLE:OFF
    
    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPractice()throws Exception {
        TemplateFrameworkCapsuleDto templateFrameworkCapsuleDto = new TemplateFrameworkCapsuleDto();
        
        //テスト用にフレームワークのチェックをパスするデータを入力
        CreateCommonCheckDtoTestOnlyUtil.practice(templateFrameworkCapsuleDto);

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        
        String responseContent = mockMvc // NOPMD LawOfDemeter
                .perform(post("/propose-read-csv-template/search-all")
                        .content(objectMapper.writeValueAsString(templateFrameworkCapsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        
        System.out.println(responseContent);
        
        fail("Not yet implemented");
    }

}
