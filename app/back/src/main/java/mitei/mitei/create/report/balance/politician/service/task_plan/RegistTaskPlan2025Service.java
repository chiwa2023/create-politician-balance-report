package mitei.mitei.create.report.balance.politician.service.task_plan;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;
import mitei.mitei.create.report.balance.politician.repository.TaskPlan2025Repository;

/**
 * タスク登録サービス
 */
@Service
public class RegistTaskPlan2025Service {

    /** タスク予定Repository */
    @Autowired
    private TaskPlan2025Repository taskPlan2025Repository;
    
    /**
     * 2025年のタスク予定を登録する
     *
     * @param listTaskPlan タスクリスト
     * @return 登録結果
     */
    public TemplateFrameworkResultDto practice(final List<TaskPlan2025Entity> listTaskPlan) {
        
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());

        long code = 1L;

        //最新コードを取得
        Optional<TaskPlan2025Entity> optionalNewest = taskPlan2025Repository.findFirstByOrderByTaskPlanCodeDesc();
        if(!optionalNewest.isEmpty()) {
            code = optionalNewest.get().getTaskPlanCode() + 1;
        }
        
        for(TaskPlanInterface entity : listTaskPlan) {
            entity.setTaskPlanId(0L);
            entity.setTaskPlanCode(code);
            entity.setInsertTimestamp(now);
            code++;
        }
 
        List<TaskPlan2025Entity> listRecorded = taskPlan2025Repository.saveAll(listTaskPlan);
        
        TemplateFrameworkResultDto resultDto = new TemplateFrameworkResultDto();
        resultDto.setSuccessCount(listRecorded.size());
        resultDto.setIsOk(listRecorded.size() == listTaskPlan.size());
        
        return resultDto;
    }
    
}
