package mitei.mitei.create.report.balance.politician.task_plan.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.task_plan.logic.y2022.InsertTaskPlanY2022Logic;
import mitei.mitei.create.report.balance.politician.task_plan.logic.y2024.InsertTaskPlanY2024Logic;

/**
 * タスク計画データを挿入する
 */
@Component
public class InsertTaskPlanFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 2024年Loigc */
    @Autowired // 2024
    private InsertTaskPlanY2024Logic insertTaskPlanY2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** 2022年Loigc */
    @Autowired // 2022
    private InsertTaskPlanY2022Logic insertTaskPlanY2022Logic;

    /** 2024年 */
    private static final int YEAR_2025 = 2025;
    /** 2025年Loigc */
    @Autowired // 2025
    private InsertTaskPlanY2024Logic insertTaskPlanY2025Logic;

    /**
     * 挿入作業を行う
     *
     * @param privilegeDto 権限確認Dto
     * @param listTask     タスクリスト
     * @param listUser     対象ユーザリスト
     * @return 挿入行数
     */
    public int practice(final int year, final CheckPrivilegeDto privilegeDto, final List<TaskInfoEntity> listTask,
            final List<UserWebAccessEntity> listUser) {

        switch (year) {
            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return insertTaskPlanY2024Logic.practice(privilegeDto, listTask, listUser);

            // 2022年
            case YEAR_2022:
                return insertTaskPlanY2022Logic.practice(privilegeDto, listTask, listUser);

            // 2025年
            case YEAR_2025:
                return insertTaskPlanY2025Logic.practice(privilegeDto, listTask, listUser);

            // caseの追加位置
            default:
                return 0;
        }

    }
}
