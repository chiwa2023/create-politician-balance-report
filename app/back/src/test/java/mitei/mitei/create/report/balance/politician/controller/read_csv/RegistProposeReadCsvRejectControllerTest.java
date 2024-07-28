package mitei.mitei.create.report.balance.politician.controller.read_csv;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.dto.read_csv.RegistProposeCsvReadRemplateCapsuleDto;
import mitei.mitei.create.report.balance.politician.entity.ProposeCsvReadTemplateEntity;
import mitei.mitei.create.report.balance.politician.repository.ProposeCsvReadTemplateRepository;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * RegistProposeReadCsvRejectController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistProposeReadCsvRejectControllerTest {
    // CHECKSTYLE:OFF

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    /** CSV読み取り使用申請テーブル */
    @Autowired
    private ProposeCsvReadTemplateRepository proposeCsvReadTemplateRepository;

    @Test
    void testPractice() throws Exception {
        RegistProposeCsvReadRemplateCapsuleDto registProposeCsvReadRemplateCapsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(registProposeCsvReadRemplateCapsuleDto);

        Optional<ProposeCsvReadTemplateEntity> optional = proposeCsvReadTemplateRepository.findById(15L);
        registProposeCsvReadRemplateCapsuleDto.setProposeCsvReadTemplateEntity(optional.get());

        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();
        // String responseContent = mockMvc // NOPMD LawOfDemeter
        // .perform(post("/propose-csv-read-reject/regist")
        // .content(objectMapper.writeValueAsString(registProposeCsvReadRemplateCapsuleDto))
        // // リクエストボディを指定
        // .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
        // .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        // System.out.println(responseContent);

        assertThat(mockMvc // NOPMD LawOfDemeter
                .perform(post("/propose-csv-read-reject/regist")
                        .content(objectMapper.writeValueAsString(registProposeCsvReadRemplateCapsuleDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
