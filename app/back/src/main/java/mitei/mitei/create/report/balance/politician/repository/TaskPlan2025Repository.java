package mitei.mitei.create.report.balance.politician.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import jakarta.persistence.LockModeType;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;

/**
 * task_plan_2025接続用Repository
 */
public interface TaskPlan2025Repository  extends JpaRepository<TaskPlan2025Entity, Integer>{

    /**
     * テーブル同一識別コードがテーブルで最大である行を取得する
     *
     * @return 最大値のOptional
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<TaskPlan2025Entity> findFirstByOrderByTaskPlanCodeDesc();

}
