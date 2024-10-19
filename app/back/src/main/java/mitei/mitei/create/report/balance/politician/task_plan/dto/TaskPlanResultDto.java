package mitei.mitei.create.report.balance.politician.task_plan.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.PoliticalOrganizationSelectOptionDto;

/**
 * 現在予定の検索結果Dto
 */
public class TaskPlanResultDto implements Serializable { // NOPMD DataClass

    /** SerialId */
    private static final long serialVersionUID = 1L;

    /** 所属政治団体リスト */
    private List<PoliticalOrganizationSelectOptionDto> listPoliticalOrganizationSelect = new ArrayList<>();

    /** 未処理タスク計画リスト */
    private List<TaskPlanSelectOptionDto> listTaskPlanSelect = new ArrayList<>();

    /**
     * 政治団体Selectboxオプションリストを取得する
     *
     * @return 政治団体Selectboxオプションリスト
     */
    public List<PoliticalOrganizationSelectOptionDto> getListPoliticalOrganizationSelect() {
        return listPoliticalOrganizationSelect;
    }

    /**
     * 政治団体Selectboxオプションリスト設定する
     *
     * @param listPoliticalOrganizationSelect 政治団体Selectboxオプションリスト
     */
    public void setListPoliticalOrganizationSelect(
            final List<PoliticalOrganizationSelectOptionDto> listPoliticalOrganizationSelect) {
        this.listPoliticalOrganizationSelect = listPoliticalOrganizationSelect;
    }

    /**
     * 未処理タスクSelectboxオプションリストを取得する
     *
     * @return 未処理タスクSelectboxオプションリスト
     */
    public List<TaskPlanSelectOptionDto> getListTaskPlanSelect() {
        return listTaskPlanSelect;
    }

    /**
     * 未処理タスクSelectboxオプションリストを設定する
     *
     * @param listTaskPlanSelect 未処理タスクSelectboxオプションリスト
     */
    public void setListTaskPlanSelect(final List<TaskPlanSelectOptionDto> listTaskPlanSelect) {
        this.listTaskPlanSelect = listTaskPlanSelect;
    }

}
