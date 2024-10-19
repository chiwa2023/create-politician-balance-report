package mitei.mitei.create.report.balance.politician.task_plan.logic.y2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.entity.task_plan.TaskPlan2024Entity;
import mitei.mitei.create.report.balance.politician.repository.task_plan.TaskPlan2024Repository;
import mitei.mitei.create.report.balance.politician.task_plan.logic.PickupRelatedUserListByTaskKengenLogic;
import mitei.mitei.create.report.balance.politician.util.SetTableDataHistoryUtil;

/**
 * 新規のタスク予定を追加する
 */
@Component
public class InsertTaskPlanY2024Logic {

    /** タスク計画Repository(2024年) */
    @Autowired
    private TaskPlan2024Repository taskPlan2024Repository;

    /** 関連ユーザ抽出Logic */
    @Autowired
    private PickupRelatedUserListByTaskKengenLogic pickupRelatedUserListByTaskKengenLogic;

    /**
     * 挿入作業を行う
     *
     * @param privilegeDto 権限確認Dto
     * @param listTask     タスクリスト
     * @param listUser     対象ユーザリスト
     * @return 挿入行数
     */
    public int practice(final CheckPrivilegeDto privilegeDto, final List<TaskInfoEntity> listTask,
            final List<UserWebAccessEntity> listUser) {

        List<TaskPlan2024Entity> list = new ArrayList<>();
        for (TaskInfoEntity taskEntity : listTask) {
            list.add(this.createEntity(privilegeDto, taskEntity, listUser));
        }

        // 同一識別コードの設定
        Integer code = 0;
        Optional<TaskPlan2024Entity> optinoal = taskPlan2024Repository.findFirstByOrderByTaskPlanCodeDesc();
        if (!optinoal.isEmpty()) {
            code = optinoal.get().getTaskPlanCode();
        }
        for (TaskPlan2024Entity entity : list) {
            code++;
            entity.setTaskPlanCode(code);
        }

        return taskPlan2024Repository.saveAll(list).size();
    }

    private TaskPlan2024Entity createEntity(final CheckPrivilegeDto privilegeDto, final TaskInfoEntity taskInfoEntity,
            final List<UserWebAccessEntity> listUser) {

        TaskPlan2024Entity entity = new TaskPlan2024Entity();

        SetTableDataHistoryUtil.practice(privilegeDto, entity, DataHistoryStatusConstants.INSERT);

        // タスクの内容関連
        entity.setIsFinished(false); // タスクが未処理指定なのでfalse固定

        entity.setTaskPlanName(taskInfoEntity.getTaskInfoName());
        entity.setKengenKbn(taskInfoEntity.getKengenKbn());
        // タスクの指定する権限区分に紐づくユーザリスト文字列を生成
        entity.setListUserCode(
                pickupRelatedUserListByTaskKengenLogic.practiceString(taskInfoEntity.getKengenKbn(), listUser));
        // 遷移するURLと指定するqueryを連結して格納
        entity.setTransferPass(taskInfoEntity.getTransferPass() + taskInfoEntity.getParamQuery());

        // 操作中の政治団体は権限確認Dtoからもらう
        entity.setPoliticalOrganizationId(privilegeDto.getPoliticalOrganizationId());
        entity.setPoliticalOrganizationCode(privilegeDto.getPoliticalOrganizationCode());
        entity.setPoliticalOrganizationName(privilegeDto.getPoliticalOrganizationName());

        entity.setTaskPlanId(0L); // autoincrement(明記)

        return entity;
    }

}
