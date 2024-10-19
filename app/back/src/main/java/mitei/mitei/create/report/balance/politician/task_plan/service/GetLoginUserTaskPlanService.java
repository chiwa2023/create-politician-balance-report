package mitei.mitei.create.report.balance.politician.task_plan.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.dto.PoliticalOrganizationSelectOptionDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.logic.poli_org.SearchPoliticalOrgBelongingUserLogic;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSelectOptionDto;
import mitei.mitei.create.report.balance.politician.task_plan.logic.SearchTaskPlanByPoliticalOrgFactoryLogic;

/**
 * ログインユーザが処理できる未処理タスクを検索する
 */
@Service
public class GetLoginUserTaskPlanService {

    /** ユーザ所属政治団体検索Logic */
    @Autowired
    private SearchPoliticalOrgBelongingUserLogic searchPoliticalOrgBelongingUserLogic;

    /** 未処理タスク予定検索Logic */
    @Autowired
    private SearchTaskPlanByPoliticalOrgFactoryLogic searchTaskPlanByPoliticalOrgFactoryLogic;

    /**
     * 未処理タスクを検索する
     *
     * @param datetimeShori 処理日
     * @param privilegeDto  権限確認Dto
     * @return 未処理タスク検索結果Dto
     */
    public TaskPlanResultDto practice(final LocalDateTime datetimeShori, final CheckPrivilegeDto privilegeDto) {

        // 政治団体リスト
        List<PoliticalOrganizationSelectOptionDto> listOrganization = searchPoliticalOrgBelongingUserLogic
                .practice(privilegeDto.getLoginUserCode());

        List<Integer> listPoliOrgCode = new ArrayList<>();
        for (PoliticalOrganizationSelectOptionDto orgDto : listOrganization) {
            listPoliOrgCode.add(orgDto.getPoliticalOrganizationCode());
        }
        
        // TODO 複数年処理を追加する(複数年の定義が必要)

        // 未処理タスクリスト
        List<TaskPlanSelectOptionDto> listTask = searchTaskPlanByPoliticalOrgFactoryLogic.practice(datetimeShori,
                listPoliOrgCode, privilegeDto.getLoginUserCode());

        // 結果Dtoに取得したリストを格納
        TaskPlanResultDto resultDto = new TaskPlanResultDto();
        resultDto.setListPoliticalOrganizationSelect(listOrganization);
        resultDto.setListTaskPlanSelect(listTask);

        return resultDto;
    }
}
