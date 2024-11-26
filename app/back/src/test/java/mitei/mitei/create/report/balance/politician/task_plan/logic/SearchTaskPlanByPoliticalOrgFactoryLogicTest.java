package mitei.mitei.create.report.balance.politician.task_plan.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSelectOptionDto;

/**
 * SearchTaskPlanByPoliticalOrgFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SearchTaskPlanByPoliticalOrgFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private SearchTaskPlanByPoliticalOrgFactoryLogic searchTaskPlanByPoliticalOrgFactoryLogic;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("y2024/task_plan_2024.sql")
    void testPractice2024() {

        Integer userCode = 890;
        LocalDateTime datetimeShori = LocalDateTime.of(2024, 7, 1, 12, 34, 56);

        List<Integer> listPoliOrg = new ArrayList<>();
        List<TaskPlanSelectOptionDto> listDto00 = searchTaskPlanByPoliticalOrgFactoryLogic.practice(datetimeShori,
                listPoliOrg, userCode);
        assertTrue(listDto00.isEmpty(), "政治団体に所属していないデータを検索した場合は空リストが返る");

        listPoliOrg.add(3570);
        List<TaskPlanSelectOptionDto> listDto01 = searchTaskPlanByPoliticalOrgFactoryLogic.practice(datetimeShori,
                listPoliOrg, userCode);
        assertThat(listDto01.size()).isEqualTo(2);

        TaskPlanSelectOptionDto dto0111 = this.getDto(listDto01, 1030L);
        assertThat(dto0111.getTaskPlanId()).isEqualTo(1030L);
        TaskPlanSelectOptionDto dto0112 = this.getDto(listDto01, 1034L);
        assertThat(dto0112.getTaskPlanId()).isEqualTo(1034L);

        assertThat(dto0111.getTaskPlanCode()).isEqualTo(2030L);
        assertThat(dto0111.getTaskPlanName()).isEqualTo("収入仕分け");
        assertThat(dto0111.getPoliticalOrganizationId()).isEqualTo(3579L);
        assertThat(dto0111.getPoliticalOrganizationCode()).isEqualTo(3570);
        assertThat(dto0111.getPoliticalOrganizationName()).isEqualTo("ちゃらんぽらん政治団体1");
        assertThat(dto0111.getTransferPass()).isEqualTo("/dummy-page1");
        assertThat(dto0111.getValue()).isEqualTo("1030");
        assertThat(dto0111.getText()).isEqualTo("収入仕分け");

        List<Integer> listPoliOrg01 = new ArrayList<>();
        listPoliOrg01.add(3570);
        listPoliOrg01.add(5220);
        List<TaskPlanSelectOptionDto> listDto02 = searchTaskPlanByPoliticalOrgFactoryLogic.practice(datetimeShori,
                listPoliOrg01, userCode);
        assertThat(listDto02.size()).isEqualTo(3);

        TaskPlanSelectOptionDto dto0211 = this.getDto(listDto02, 1030L);
        assertThat(dto0211.getTaskPlanId()).isEqualTo(1030L);
        TaskPlanSelectOptionDto dto0212 = this.getDto(listDto02, 1034L);
        assertThat(dto0212.getTaskPlanId()).isEqualTo(1034L);
        TaskPlanSelectOptionDto dto0213 = this.getDto(listDto02, 1035L);
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

    private TaskPlanSelectOptionDto getDto(final List<TaskPlanSelectOptionDto> list, final Long dtoId) {

        for (TaskPlanSelectOptionDto dto : list) {
            if (dtoId.equals(dto.getTaskPlanId())) {
                return dto;
            }
        }
        return null;
    }

}
