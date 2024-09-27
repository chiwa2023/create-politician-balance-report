package mitei.mitei.create.report.balance.politician.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.logic.common.SetTableDataHistoryLogic;

/**
 * TaskPlan2025Repository単体テスト
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TaskPlan2025RepositoryTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private TaskPlan2025Repository taskPlan2025Repository;

    /** テーブル履歴セット */
    @Autowired
    private SetTableDataHistoryLogic setTableDataHistoryLogic;
    
    @Test
    void testSave() {

        TaskPlan2025Entity plan2025Entity = new TaskPlan2025Entity();

        plan2025Entity.setTaskPlanId(0L);
        plan2025Entity.setTaskPlanCode(499L);
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
        

        TaskPlan2025Entity recorded = taskPlan2025Repository.save(plan2025Entity);

        assertThat(recorded.getTaskPlanCode()).isEqualTo(499L);
        assertThat(recorded.getTaskPlanName()).isEqualTo("登録データ仕訳未処理");
        assertThat(recorded.getTaskPlanId()).isNotEqualTo(0L);
    }

}
