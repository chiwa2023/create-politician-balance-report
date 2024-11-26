package mitei.mitei.create.report.balance.politician.task_plan.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.PoliticalOrganizationSelectOptionDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSelectOptionDto;
import mitei.mitei.create.report.balance.politician.util.CreateTestPrivilegeDtoUtil;

/**
 * GetLoginUserTaskPlanService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class GetLoginUserTaskPlanServiceTest {
    // CHECKSTYLE:OFF

    /** 単体テスト */
    @Autowired
    private GetLoginUserTaskPlanService getLoginUserTaskPlanService;
    
    
    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql({"../../logic/poli_org/political_org_beloging_user.sql","../logic/y2024/task_plan_2024.sql"})
    void testPractice() {

        LocalDateTime datetimeShori = LocalDateTime.of(2024,7,1,12,34,56);

        CheckPrivilegeDto checkPrivilegeDto = CreateTestPrivilegeDtoUtil.pracitce();
        checkPrivilegeDto.setLoginUserCode(890);
        
        TaskPlanResultDto resultDto = getLoginUserTaskPlanService.practice(datetimeShori, checkPrivilegeDto);
        
        List<PoliticalOrganizationSelectOptionDto> list = resultDto.getListPoliticalOrganizationSelect();

        // テストデータから3件取得
        assertThat(list.size()).isEqualTo(4);

        PoliticalOrganizationSelectOptionDto dto0 = this.getOrgData(list, 3570);
        assertThat(dto0.getPoliticalOrganizationId()).isEqualTo(3579L);
        assertThat(dto0.getPoliticalOrganizationCode()).isEqualTo(3570);
        assertThat(dto0.getPoliticalOrganizationName()).isEqualTo("ちゃらんぽらん政治団体1");
        assertThat(dto0.getValue()).isEqualTo("3570");
        assertThat(dto0.getText()).isEqualTo("ちゃらんぽらん政治団体1(3570)");

        PoliticalOrganizationSelectOptionDto dto1 = this.getOrgData(list, 5220);
        assertThat(dto1.getPoliticalOrganizationId()).isEqualTo(5224L);
        assertThat(dto1.getPoliticalOrganizationCode()).isEqualTo(5220);
        assertThat(dto1.getPoliticalOrganizationName()).isEqualTo("変わっている政治団体1");
        assertThat(dto1.getValue()).isEqualTo("5220");
        assertThat(dto1.getText()).isEqualTo("変わっている政治団体1(5220)");

        
        List<TaskPlanSelectOptionDto> listDto02 = resultDto.getListTaskPlanSelect();
        assertThat(listDto02.size()).isEqualTo(3);

        TaskPlanSelectOptionDto dto0211 = this.getTaskDto(listDto02, 1030L);
        assertThat(dto0211.getTaskPlanId()).isEqualTo(1030L);
        assertThat(dto0211.getTaskPlanCode()).isEqualTo(2030L);
        assertThat(dto0211.getTaskPlanName()).isEqualTo("収入仕分け");
        assertThat(dto0211.getPoliticalOrganizationId()).isEqualTo(3579L);
        assertThat(dto0211.getPoliticalOrganizationCode()).isEqualTo(3570);
        assertThat(dto0211.getPoliticalOrganizationName()).isEqualTo("ちゃらんぽらん政治団体1");
        assertThat(dto0211.getTransferPass()).isEqualTo("/dummy-page1");
        assertThat(dto0211.getValue()).isEqualTo("1030");
        assertThat(dto0211.getText()).isEqualTo("収入仕分け");
        
        
        TaskPlanSelectOptionDto dto0212 = this.getTaskDto(listDto02, 1034L);
        assertThat(dto0212.getTaskPlanId()).isEqualTo(1034L);
        
        TaskPlanSelectOptionDto dto0213 = this.getTaskDto(listDto02, 1035L);
        assertThat(dto0213.getTaskPlanId()).isEqualTo(1035L);
        assertThat(dto0213.getTaskPlanCode()).isEqualTo(2035L);
        assertThat(dto0213.getTaskPlanName()).isEqualTo("XML一括処理");
        assertThat(dto0213.getPoliticalOrganizationId()).isEqualTo(5224L);
        assertThat(dto0213.getPoliticalOrganizationCode()).isEqualTo(5220);
        assertThat(dto0213.getPoliticalOrganizationName()).isEqualTo("変わっている政治団体1");
        assertThat(dto0213.getTransferPass()).isEqualTo("/dummy-page9");
        assertThat(dto0213.getValue()).isEqualTo("1035");
        assertThat(dto0213.getText()).isEqualTo("XML一括処理");
        
        
    }

    private PoliticalOrganizationSelectOptionDto getOrgData(final List<PoliticalOrganizationSelectOptionDto> list,
            final Integer code) {

        for (PoliticalOrganizationSelectOptionDto dto : list) {

            if (code.equals(dto.getPoliticalOrganizationCode())) {
                return dto;
            }

        }

        return null;
    }

    private TaskPlanSelectOptionDto getTaskDto(final List<TaskPlanSelectOptionDto> list, final Long dtoId) {

        for (TaskPlanSelectOptionDto dto : list) {
            if (dtoId.equals(dto.getTaskPlanId())) {
                return dto;
            }
        }
        return null;
    }

}
