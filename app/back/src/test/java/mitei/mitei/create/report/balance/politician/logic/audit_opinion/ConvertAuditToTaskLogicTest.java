package mitei.mitei.create.report.balance.politician.logic.audit_opinion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.entity.AuditOpinionIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.AuditOpinionOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * ConvertAuditToTaskLogic単体テスト
 */
class ConvertAuditToTaskLogicTest {
    // CHECKSTYLE:OFF
    
    @Test
    void testPracticeIncome() {
        ConvertAuditToTaskLogic convertAuditToTaskLogic = new ConvertAuditToTaskLogic();

        //null代入されても(何もしない)空リスト返却されるだけ(実装ミスの発見は遅れるが・・・)
        assertThat(convertAuditToTaskLogic.practiceIncome(null).size()).isEqualTo(0);

        List<AuditOpinionIncome2025Entity> list = new ArrayList<>();

        //空リストが代入されたら空リストが返る
        assertThat(convertAuditToTaskLogic.practiceIncome(list).size()).isEqualTo(0);
        
        AuditOpinionIncome2025Entity entityIncome = new AuditOpinionIncome2025Entity();

        entityIncome.setPoliticalOrganizationId(13579L);
        entityIncome.setInsertUserId(999888L);
        
        list.add(entityIncome);
        
        List<TaskPlanInterface> listAns = convertAuditToTaskLogic.practiceIncome(list);
        //1件リストが存在したら1件のリストを返す
        assertThat(listAns.size()).isEqualTo(1);

        TaskPlanInterface entity = listAns.get(0);
        
        //タスクは終了していません
        assertThat(entity.getIsFinished()).isFalse();

        //政治団体がコピーされています
        assertThat(entity.getPoliticalOrganizationId()).isEqualTo(entityIncome.getPoliticalOrganizationId());

        //操作ユーザがコピーされています
        assertThat(entity.getInsertUserId()).isEqualTo(entityIncome.getInsertUserId());
        
        //代表者だけのタスクです
        assertThat(entity.getIsDelegateFor()).isTrue();
        assertThat(entity.getIsAccountOfficerFor()).isFalse();
        assertThat(entity.getIsAccountStaffFor()).isFalse();
        
        //TODO タスクテーブルの仕様が確定するまでfailする
        fail("Not yet implemented");
    }

    @Test
    void testPracticeOutcome() {

        ConvertAuditToTaskLogic convertAuditToTaskLogic = new ConvertAuditToTaskLogic();

        //null代入されても(何もしない)空リスト返却されるだけ(実装ミスの発見は遅れるが・・・)
        assertThat(convertAuditToTaskLogic.practiceOutcome(null).size()).isEqualTo(0);

        List<AuditOpinionOutcome2025Entity> list = new ArrayList<>();

        //空リストが代入されたら空リストが返る
        assertThat(convertAuditToTaskLogic.practiceOutcome(list).size()).isEqualTo(0);
        
        AuditOpinionOutcome2025Entity entityOutcome = new AuditOpinionOutcome2025Entity();

        entityOutcome.setPoliticalOrganizationId(13579L);
        entityOutcome.setInsertUserId(999888L);
        
        list.add(entityOutcome);
        
        List<TaskPlanInterface> listAns = convertAuditToTaskLogic.practiceOutcome(list);
        //1件リストが存在したら1件のリストを返す
        assertThat(listAns.size()).isEqualTo(1);

        TaskPlanInterface entity = listAns.get(0);
        
        //タスクは終了していません
        assertThat(entity.getIsFinished()).isFalse();

        //政治団体がコピーされています
        assertThat(entity.getPoliticalOrganizationId()).isEqualTo(entityOutcome.getPoliticalOrganizationId());

        //操作ユーザがコピーされています
        assertThat(entity.getInsertUserId()).isEqualTo(entityOutcome.getInsertUserId());
        
        //代表者だけのタスクです
        assertThat(entity.getIsDelegateFor()).isTrue();
        assertThat(entity.getIsAccountOfficerFor()).isFalse();
        assertThat(entity.getIsAccountStaffFor()).isFalse();
        
        //TODO タスクテーブルの仕様が確定するまでfailする
        fail("Not yet implemented");
    }

}
