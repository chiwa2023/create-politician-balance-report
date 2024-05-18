package mitei.mitei.create.report.balance.politician.logic.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.RegistBalancesheetInOutCapsuleDto;
import mitei.mitei.create.report.balance.politician.dto.balancesheet.ReportKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetIncome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * 収支報告書収入・支出項目からタスク計上された項目を抽出する
 */
@Component
public class CreateTaskByReportKbnTaskLogic {

    
    /**
     * タスク計上項目を抽出する
     *
     * @param registBalancesheetInOutCapsuleDto 収支報告書登録項目
     * @return タスクリスト
     */
    public List<TaskPlanInterface> practice(final RegistBalancesheetInOutCapsuleDto registBalancesheetInOutCapsuleDto) {

        //Dtoそのもの空は許容しません
        if(Objects.isNull(registBalancesheetInOutCapsuleDto)) {
            throw new IllegalArgumentException("収支報告書リストがnullです");
        }
        
        List<BalancesheetIncome2025Entity> listIncome = registBalancesheetInOutCapsuleDto.getListIncome();
        List<BalancesheetOutcome2025Entity> listOutcome = registBalancesheetInOutCapsuleDto.getListOutcome();

        //仮にリスト挿入されなかったとしても(front側経由ではありえない)、落とさないために空リストを用意します。
        if(Objects.isNull(listIncome)) {
            listIncome = new ArrayList<>();
        }
        if(Objects.isNull(listOutcome)) {
            listOutcome = new ArrayList<>();
        }
        
        List<TaskPlanInterface> listAll = new ArrayList<>();

        //収入項目で収支報告がタスク計上であるデータはタスク計上
        for(BalancesheetIncome2025Entity entityBalancesheet : listIncome) {
            if(ReportKbnConstants.PLAN_TASK  == entityBalancesheet.getReportKbn()) {
                
                listAll.add(this.createTaskIncome(entityBalancesheet));
            }            
        }

        //支出項目で収支報告がタスク計上であるデータはタスク計上
        for(BalancesheetOutcome2025Entity entityBalancesheet : listOutcome) {
            if(ReportKbnConstants.PLAN_TASK  == entityBalancesheet.getReportKbn()) {
                
                listAll.add(this.createTaskOutcome(entityBalancesheet));
            }            
        }

        return listAll;
    }


    private TaskPlanInterface createTaskIncome(final BalancesheetIncome2025Entity entityIncome) {

        TaskPlan2025Entity entity = new TaskPlan2025Entity();

        //政治団体とユーザをコピー(現段階では)
        BeanUtils.copyProperties(entityIncome, entity);

        // 作業はまだ終了していません
        entity.setIsFinished(false);

        // 前例と異ならない仕訳は代表者の仕事ではありません
        entity.setIsDelegateFor(false);
        
        // 事務担当者の誰かが作業しましょう
        entity.setIsAccountOfficerFor(true);
        entity.setIsAccountStaffFor(true);
        
        return entity;
    }

    private TaskPlanInterface createTaskOutcome(final BalancesheetOutcome2025Entity entityOutcome) {
        
        TaskPlan2025Entity entity = new TaskPlan2025Entity();

        //政治団体とユーザをコピー(現段階では)
        BeanUtils.copyProperties(entityOutcome, entity);

        // 作業はまだ終了していません
        entity.setIsFinished(false);

        // 前例と異ならない仕訳は代表者の仕事ではありません
        entity.setIsDelegateFor(false);
        
        // 事務担当者の誰かが作業しましょう
        entity.setIsAccountOfficerFor(true);
        entity.setIsAccountStaffFor(true);
        
        return entity;
    }

}
