package mitei.mitei.create.report.balance.politician.task_plan.logic;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_plan.dto.TaskPlanSelectOptionDto;
import mitei.mitei.create.report.balance.politician.task_plan.logic.y2022.SearchTaskPlanByPoliticalOrgY2022Logic;
import mitei.mitei.create.report.balance.politician.task_plan.logic.y2024.SearchTaskPlanByPoliticalOrgY2024Logic;
import mitei.mitei.create.report.balance.politician.task_plan.logic.y2025.SearchTaskPlanByPoliticalOrgY2025Logic;

/**
 * 未処理タスク予定検索ファクトリLogic
 */
@Component
public class SearchTaskPlanByPoliticalOrgFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 未処理タスク予定検索Logic(2024) */
    @Autowired
    private SearchTaskPlanByPoliticalOrgY2024Logic searchTaskPlanByPoliticalOrgY2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** 未処理タスク予定検索Logic(2022) */
    @Autowired // 2022
    private SearchTaskPlanByPoliticalOrgY2022Logic searchTaskPlanByPoliticalOrgY2022Logic;

    /** 2025年 */
    private static final int YEAR_2025 = 2025;
    /** 未処理タスク予定検索Logic(2025) */
    @Autowired
    private SearchTaskPlanByPoliticalOrgY2025Logic searchTaskPlanByPoliticalOrgY2025Logic;

    /**
     * 未処理タスクリストを検索する
     *
     * @param dateTimeShori データ処理日
     * @param listPoriOrg   所属政治団体同一識別コードリスト
     * @param userCode      ログインユーザ同一識別コード
     * @return 未処理タスクリスト
     */
    public List<TaskPlanSelectOptionDto> practice(final LocalDateTime dateTimeShori, final List<Integer> listPoriOrg,
            final Integer userCode) {

        switch (dateTimeShori.getYear()) {
            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return searchTaskPlanByPoliticalOrgY2024Logic.practice(listPoriOrg, userCode);

            // 2022年
            case YEAR_2022:
                return searchTaskPlanByPoliticalOrgY2022Logic.practice(listPoriOrg, userCode);

            // 2025年
            case YEAR_2025:
                return searchTaskPlanByPoliticalOrgY2025Logic.practice(listPoriOrg, userCode);

                // caseの追加位置
                
            default:
                throw new IllegalArgumentException("Unexpected value: " + dateTimeShori.getYear());
        }
    }

}
