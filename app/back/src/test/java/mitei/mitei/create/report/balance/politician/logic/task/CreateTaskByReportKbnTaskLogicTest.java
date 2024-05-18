package mitei.mitei.create.report.balance.politician.logic.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.ReportKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * CreateTaskByReportKbnTaskLogic単体テスト
 */
class CreateTaskByReportKbnTaskLogicTest {
    // CHECKSTYLE:OFF

    @Test
    void testPractice() {

        CreateTaskByReportKbnTaskLogic createTaskByReportKbnTaskLogic = new CreateTaskByReportKbnTaskLogic();

        // Dtoそのものがnullの時は落とします。
        assertThrows(IllegalArgumentException.class, () -> createTaskByReportKbnTaskLogic.practice(null));

        RegistBalancesheetInOutCapsuleDto balancesheetInOutDto = new RegistBalancesheetInOutCapsuleDto();

        // リストが仮に存在しなくても空リストを返します
        assertThat(createTaskByReportKbnTaskLogic.practice(balancesheetInOutDto).size()).isEqualTo(0);

        List<BalancesheetIncome2025Entity> listIncome = new ArrayList<>();

        BalancesheetIncome2025Entity income1 = new BalancesheetIncome2025Entity();
        income1.setReportKbn(ReportKbnConstants.PLAN_TASK);// タスク計上
        income1.setPoliticalOrganizationId(3355L);
        income1.setLoginUserId(7799L);

        BalancesheetIncome2025Entity income2 = new BalancesheetIncome2025Entity();
        income2.setReportKbn(ReportKbnConstants.ABPLITION);// タスク計上しない
        income2.setPoliticalOrganizationId(13355L);
        income2.setLoginUserId(17799L);

        listIncome.add(income1);
        listIncome.add(income2);

        List<BalancesheetOutcome2025Entity> listOutcome = new ArrayList<>();

        BalancesheetOutcome2025Entity outcome1 = new BalancesheetOutcome2025Entity();
        outcome1.setReportKbn(ReportKbnConstants.PLAN_TASK);// タスク計上
        outcome1.setPoliticalOrganizationId(2244L);
        outcome1.setLoginUserId(6688L);

        BalancesheetOutcome2025Entity outcome2 = new BalancesheetOutcome2025Entity();
        outcome2.setReportKbn(ReportKbnConstants.LIVING_COST);// タスク計上しない
        outcome2.setPoliticalOrganizationId(12244L);
        outcome2.setLoginUserId(16688L);

        listOutcome.add(outcome1);
        listOutcome.add(outcome2);

        balancesheetInOutDto.setListIncome(listIncome);
        balancesheetInOutDto.setListOutcome(listOutcome);

        List<TaskPlanInterface> list = createTaskByReportKbnTaskLogic.practice(balancesheetInOutDto);

        // 収支1件づつ投入したのでタスクとしては2件返ります(各1件は条件対象外)
        assertThat(createTaskByReportKbnTaskLogic.practice(balancesheetInOutDto).size()).isEqualTo(2);

        TaskPlanInterface task1 = list.get(0);

        // タスクは終了していません
        assertThat(task1.getIsFinished()).isFalse();

        // 政治団体がコピーされています
        assertThat(task1.getPoliticalOrganizationId()).isEqualTo(income1.getPoliticalOrganizationId());

        // 操作ユーザがコピーされています
        assertThat(task1.getLoginUserId()).isEqualTo(income1.getLoginUserId());

        // 代表者だけのタスクです
        assertThat(task1.getIsDelegateFor()).isFalse();
        assertThat(task1.getIsAccountOfficerFor()).isTrue();
        assertThat(task1.getIsAccountStaffFor()).isTrue();

        TaskPlanInterface task2 = list.get(1);

        // タスクは終了していません
        assertThat(task2.getIsFinished()).isFalse();

        // 政治団体がコピーされています
        assertThat(task2.getPoliticalOrganizationId()).isEqualTo(outcome1.getPoliticalOrganizationId());

        // 操作ユーザがコピーされています
        assertThat(task2.getLoginUserId()).isEqualTo(outcome1.getLoginUserId());

        // 代表者だけのタスクです
        assertThat(task2.getIsDelegateFor()).isFalse();
        assertThat(task2.getIsAccountOfficerFor()).isTrue();
        assertThat(task2.getIsAccountStaffFor()).isTrue();

        // TODO タスクテーブルの仕様が決定するまではテストを落とす
        fail("Not yet implemented");
    }

    @Test
    void testPracticeNoData() {

        CreateTaskByReportKbnTaskLogic createTaskByReportKbnTaskLogic = new CreateTaskByReportKbnTaskLogic();

        // Dtoそのものがnullの時は落とします。
        assertThrows(IllegalArgumentException.class, () -> createTaskByReportKbnTaskLogic.practice(null));

        RegistBalancesheetInOutCapsuleDto balancesheetInOutDto = new RegistBalancesheetInOutCapsuleDto();

        // リストが仮に存在しなくても空リストを返します
        assertThat(createTaskByReportKbnTaskLogic.practice(balancesheetInOutDto).size()).isEqualTo(0);

        List<BalancesheetIncome2025Entity> listIncome = new ArrayList<>();

        BalancesheetIncome2025Entity income1 = new BalancesheetIncome2025Entity();
        income1.setReportKbn(ReportKbnConstants.LIVING_COST);// タスク計上しない
        income1.setPoliticalOrganizationId(3355L);
        income1.setLoginUserId(7799L);

        BalancesheetIncome2025Entity income2 = new BalancesheetIncome2025Entity();
        income2.setReportKbn(ReportKbnConstants.ABPLITION);// タスク計上しない
        income2.setPoliticalOrganizationId(13355L);
        income2.setLoginUserId(17799L);

        listIncome.add(income1);
        listIncome.add(income2);

        List<BalancesheetOutcome2025Entity> listOutcome = new ArrayList<>();

        BalancesheetOutcome2025Entity outcome1 = new BalancesheetOutcome2025Entity();
        outcome1.setReportKbn(ReportKbnConstants.LIVING_COST);// タスク計上しない
        outcome1.setPoliticalOrganizationId(2244L);
        outcome1.setLoginUserId(6688L);

        BalancesheetOutcome2025Entity outcome2 = new BalancesheetOutcome2025Entity();
        outcome2.setReportKbn(ReportKbnConstants.LIVING_COST);// タスク計上しない
        outcome2.setPoliticalOrganizationId(12244L);
        outcome2.setLoginUserId(16688L);

        listOutcome.add(outcome1);
        listOutcome.add(outcome2);

        balancesheetInOutDto.setListIncome(listIncome);
        balancesheetInOutDto.setListOutcome(listOutcome);

        // 抽出すべきデータが存在しないときは0データが返ります
        assertThat(createTaskByReportKbnTaskLogic.practice(balancesheetInOutDto).size()).isEqualTo(0);
    }

}
