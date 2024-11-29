package mitei.mitei.create.report.balance.politician.service.task_plan;

import static org.assertj.core.api.Assertions.assertThat;

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
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.logic.common.SetTableDataHistoryLogic;

/**
 * RegistTaskPlan2025Service単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistTaskPlan2025ServiceTest {
    // CHECKSTYLE:OFF

    /** タスク登録Service */
    @Autowired
    private RegistTaskPlan2025Service registTaskPlan2025Service;

    /** テーブル履歴Logic */
    @Autowired
    private SetTableDataHistoryLogic setTableDataHistoryLogic;

    @Test
    @Tag("TableTruncate")
    @Transactional
    void testPractice() {
        List<TaskPlan2025Entity> list = new ArrayList<>();

        TaskPlan2025Entity plan2025Entity = new TaskPlan2025Entity();

        plan2025Entity.setTaskPlanCode(null);// 最終的には上書き
        plan2025Entity.setTaskPlanName("登録データ仕訳未処理");

        plan2025Entity.setSaishinKbn(DataHistoryStatusConstants.INSERT.value());
        plan2025Entity.setIsFinished(false);
        plan2025Entity.setIsNoticsAlert(false);

        plan2025Entity.setPoliticalOrganizationId(12345L);
        plan2025Entity.setPoliticalOrganizationCode(1000);
        plan2025Entity.setPoliticalOrganizationName("サンプル政治団体");

        plan2025Entity.setIsDelegateFor(true);
        plan2025Entity.setIsAccountOfficerFor(true);
        plan2025Entity.setIsAccountStaffFor(true);

        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setLoginUserId(991L);
        checkPrivilegeDto.setLoginUserCode(845);
        checkPrivilegeDto.setLoginUserName("会計責任者　正夫");

        setTableDataHistoryLogic.practice(checkPrivilegeDto, plan2025Entity, DataHistoryStatusConstants.INSERT);

        list.add(plan2025Entity);

        // 1件のリストを渡したら1件登録されます
        assertThat(registTaskPlan2025Service.practice(list).getSuccessCount()).isEqualTo(1);
    }

}
