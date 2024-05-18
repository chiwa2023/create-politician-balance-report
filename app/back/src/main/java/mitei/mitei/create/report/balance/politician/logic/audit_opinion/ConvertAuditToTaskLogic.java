package mitei.mitei.create.report.balance.politician.logic.audit_opinion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.entity.AuditOpinionIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.AuditOpinionOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * 意見付記EntityからタスクEntityに変換する
 */
@Component
public class ConvertAuditToTaskLogic {

    /**
     * 収入項目からタスクを生成する
     *
     * @param listAudit 意見付記リスト
     * @return タスクリスト
     */
    public List<TaskPlanInterface> practiceIncome(final List<AuditOpinionIncome2025Entity> listAudit){

        List<TaskPlanInterface> list = new ArrayList<>();
        // リストがnullもしくは空の場合は空リストを返す
        if(Objects.isNull(listAudit)) {
            return list;
        }
        if(listAudit.isEmpty()) {
            return list;
        }

        for(AuditOpinionIncome2025Entity auditEntity : listAudit) {
            list.add(this.createTaskIncome(auditEntity));
        }
        
        return list;
    }

    /**
     * 支出項目からタスクを生成する
     *
     * @param listAudit 支出項目リスト
     * @return タスクリスト
     */
    public List<TaskPlanInterface> practiceOutcome(final List<AuditOpinionOutcome2025Entity> listAudit){

        List<TaskPlanInterface> list = new ArrayList<>();
        // リストがnullもしくは空の場合は空リストを返す
        if(Objects.isNull(listAudit)) {
            return list;
        }
        if(listAudit.isEmpty()) {
            return list;
        }

        for(AuditOpinionOutcome2025Entity auditEntity : listAudit) {

            list.add(this.createTaskOutcome(auditEntity));
        }

        return list;
    }

    private TaskPlanInterface createTaskIncome(final AuditOpinionIncome2025Entity entityIncome) {

        TaskPlan2025Entity entity = new TaskPlan2025Entity();
        
        //政治団体とユーザをコピー(現段階では)
        BeanUtils.copyProperties(entityIncome, entity);

        // 作業はまだ終了していません
        entity.setIsFinished(false);

        // 前例と異なる処理が行われて意見付記テーブルに登録され、その件に対応するのは代表者がすべき仕事です
        entity.setIsDelegateFor(true);
        
        // 他の担当者には特にタスク登録は必要ありません
        entity.setIsAccountOfficerFor(false);
        entity.setIsAccountStaffFor(false);
        
        return entity;
    }

    private TaskPlanInterface createTaskOutcome(final AuditOpinionOutcome2025Entity entityOutcome) {
        
        TaskPlan2025Entity entity = new TaskPlan2025Entity();

        //政治団体とユーザをコピー(現段階では)
        BeanUtils.copyProperties(entityOutcome, entity);

        // 作業はまだ終了していません
        entity.setIsFinished(false);

        // 前例と異なる処理が行われて意見付記テーブルに登録され、その件に対応するのは代表者がすべき仕事です
        entity.setIsDelegateFor(true);
        
        // 他の担当者には特にタスク登録は必要ありません
        entity.setIsAccountOfficerFor(false);
        entity.setIsAccountStaffFor(false);
        
        return entity;
    }

}
