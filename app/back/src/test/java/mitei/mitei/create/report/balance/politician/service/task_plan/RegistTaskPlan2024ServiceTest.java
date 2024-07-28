package mitei.mitei.create.report.balance.politician.service.task_plan;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2024Entity;
import mitei.mitei.create.report.balance.politician.logic.common.SetTableDataHistoryLogic;

/**
 * RegistTaskPlan2024Service単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistTaskPlan2024ServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象*/
    @Autowired
    private RegistTaskPlan2024Service registTaskPlan2024Service;

    /** テーブル履歴Logic */
    @Autowired
    private SetTableDataHistoryLogic setTableDataHistoryLogic;

    @Test
    @Transactional
    void testPractice() {
        
        List<TaskPlan2024Entity> list = new ArrayList<>();

        TaskPlan2024Entity plan2024Entity = new TaskPlan2024Entity();

        plan2024Entity.setTaskPlanCode(null);// 最終的には上書き
        plan2024Entity.setTaskPlanName("登録データ仕訳未処理");

        plan2024Entity.setSaishinKbn(SaishinKbnConstants.SAISHIN);
        plan2024Entity.setIsFinished(false);
        plan2024Entity.setIsNoticsAlert(false);

        plan2024Entity.setPoliticalOrganizationId(12345L);
        plan2024Entity.setPoliticalOrganizationCode(1000);
        plan2024Entity.setPoliticalOrganizationName("サンプル政治団体");

        plan2024Entity.setIsDelegateFor(true);
        plan2024Entity.setIsAccountOfficerFor(true);
        plan2024Entity.setIsAccountStaffFor(true);
        
        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setLoginUserId(991L);
        checkPrivilegeDto.setLoginUserCode(845);
        checkPrivilegeDto.setLoginUserName("会計責任者　正夫");

        setTableDataHistoryLogic.practice(checkPrivilegeDto, plan2024Entity, DataHistoryStatusConstants.INSERT);

        list.add(plan2024Entity);

        // 1件のリストを渡したら1件登録されます
        assertThat(registTaskPlan2024Service.practice(list).getSuccessCount()).isEqualTo(1);
    }

}
