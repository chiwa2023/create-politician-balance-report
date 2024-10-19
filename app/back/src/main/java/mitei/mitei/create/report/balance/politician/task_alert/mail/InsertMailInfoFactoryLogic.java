package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.task_alert.mail.y2022.InsertMailInfo2022Logic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.y2024.InsertMailInfo2024Logic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.y2025.InsertMailInfo2025Logic;

/**
 * メール通知計画ファクトリLogic
 */
@Component
public class InsertMailInfoFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 2024年Loigc */
    @Autowired // 2024
    private InsertMailInfo2024Logic insertMailInfo2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 20242;
    /** 2022年Loigc */
    @Autowired // 2022
    private InsertMailInfo2022Logic insertMailInfo2022Logic;

    /** 2025年 */
    private static final int YEAR_2025 = 2025;
    /** 2025年Loigc */
    @Autowired // 2025
    private InsertMailInfo2025Logic insertMailInfo2025Logic;

    /**
     * 処理日時に合わせた処理を行う
     *
     * @param privilegeDto  権限確認Dto
     * @param datetimeShori 処理日時
     * @param userEntity    ユーザWebアクセス情報
     * @param listSend      送信ユーザリスト
     * @param listTask      タスクリスト
     * @return 更新行数
     */
    public int practice(final CheckPrivilegeDto privilegeDto, final LocalDateTime datetimeShori,
            final UserWebAccessEntity userEntity, final List<UserWebAccessEntity> listSend,
            final List<TaskInfoEntity> listTask) {

        switch (datetimeShori.getYear()) {
            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return insertMailInfo2024Logic.practice(privilegeDto, datetimeShori, userEntity, listSend, listTask);

            // 2022年
            case YEAR_2022:
                return insertMailInfo2022Logic.practice(privilegeDto, datetimeShori, userEntity, listSend, listTask);

            // 2025年
            case YEAR_2025:
                return insertMailInfo2025Logic.practice(privilegeDto, datetimeShori, userEntity, listSend, listTask);

            // caseの追加位置
                
            default:
                return 0;
        }
    }
}
