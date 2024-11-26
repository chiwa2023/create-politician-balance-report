package mitei.mitei.create.report.balance.politician.task_plan.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSearchConditonCapsuleDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;
import mitei.mitei.create.report.balance.politician.util.GetObjectMapperWithTimeModuleUtil;

/**
 * GetLoginUserTaskPlanController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetLoginUserTaskPlanControllerTest {
    

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql({"../../logic/poli_org/political_org_beloging_user.sql","../logic/y2024/task_plan_2024.sql"})
    void testPractice()throws Exception {
        
        String path = "/get-task-plan";

        // 検索条件Dto
        TaskPlanSearchConditonCapsuleDto searchConditionDto = new TaskPlanSearchConditonCapsuleDto();        
        CreateCommonCheckDtoTestOnlyUtil.practice(searchConditionDto);
        searchConditionDto.getCheckPrivilegeDto().setLoginUserCode(890); // テスト用固定値 SUPPRESS CHECKSTYLE MagicNumber
        
        ObjectMapper objectMapper = GetObjectMapperWithTimeModuleUtil.practice();

        // サーバステータスがOK(200)
        assertThat(mockMvc // NOPMD LawOfDemeter
                .perform(post(path).content(objectMapper.writeValueAsString(searchConditionDto)) // リクエストボディを指定
                        .contentType(MediaType.APPLICATION_JSON_VALUE)) // Content Typeを指定
                .andExpect(status().isOk()).andReturn().getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

    }

}
