package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2022.InsertSnsDirectMessageSendingInfo2022Logic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024.InsertSnsDirectMessageSendingInfo2024Logic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2025.InsertSnsDirectMessageSendingInfo2025Logic;

/**
 * SNSダイレクトメッセージ送信を報告年の違いを吸収するファクトリLogic
 */
@Component
public class InsertSnsDirectMessageSendingInfoFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 2024年Loigc */
    @Autowired // 2024
    private InsertSnsDirectMessageSendingInfo2024Logic insertSnsDirectMessageSendingInfo2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** 2022年Loigc */
    @Autowired // 2022
    private InsertSnsDirectMessageSendingInfo2022Logic insertSnsDirectMessageSendingInfo2022Logic;

    /** 2025年 */
    private static final int YEAR_2025 = 2025;
    /** 2025年Loigc */
    @Autowired // 2025
    private InsertSnsDirectMessageSendingInfo2025Logic insertSnsDirectMessageSendingInfo2025Logic;

    /**
     * ダイレクトメッセージ送信計画データを挿入する
     *
     * @param privilegeDto  権限確認Dto
     * @param listUser      ユーザリスト
     * @param dateTimeShori 処理日時
     * @param listTask      タスクリスト
     */
    public int practice(final CheckPrivilegeDto privilegeDto, final List<UserWebAccessEntity> listUser,
            final LocalDateTime dateTimeShori, final List<TaskInfoEntity> listTask) {

        switch (dateTimeShori.getYear()) {
            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return insertSnsDirectMessageSendingInfo2024Logic.practice(privilegeDto, listUser, dateTimeShori,
                        listTask);

            // 2022年
            case YEAR_2022:
                return insertSnsDirectMessageSendingInfo2022Logic.practice(privilegeDto, listUser, dateTimeShori,
                        listTask);

            // 2025年
            case YEAR_2025:
                return insertSnsDirectMessageSendingInfo2025Logic.practice(privilegeDto, listUser, dateTimeShori,
                        listTask);

            // caseの追加位置
            default:
                return 0;
        }

    }
}
