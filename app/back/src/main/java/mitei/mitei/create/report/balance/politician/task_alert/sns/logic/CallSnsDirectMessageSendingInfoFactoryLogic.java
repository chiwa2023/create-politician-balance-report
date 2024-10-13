package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2022.CallSnsDirectMessageSendingInfo2022Logic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024.CallSnsDirectMessageSendingInfo2024Logic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2025.CallSnsDirectMessageSendingInfo2025Logic;
// importを追加

/**
 * SNSダイレクトメッセージ送信予定を取得する
 */
@Component
public class CallSnsDirectMessageSendingInfoFactoryLogic {

    // フィールドテンプレート始まり

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** SNSダイレクトメッセージ送信予定を取得する(2024年) */
    @Autowired // 2024
    private CallSnsDirectMessageSendingInfo2024Logic callSnsDirectMessageSendingInfo2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** SNSダイレクトメッセージ送信予定を取得する(2022年) */
    @Autowired // 2022
    private CallSnsDirectMessageSendingInfo2022Logic callSnsDirectMessageSendingInfo2022Logic;

    /** 2025年 */
    private static final int YEAR_2025 = 2025;
    /** SNSダイレクトメッセージ送信予定を取得する(2025年) */
    @Autowired // 2025
    private CallSnsDirectMessageSendingInfo2025Logic callSnsDirectMessageSendingInfo2025Logic;

    // フィールドの追加位置

    /**
     * 予定取得処理を行う
     *
     * @return ダイレクトメッセージ送信予定格納Dto
     */
    public SendSnsDirectMessageCapsuleDto practice(final LocalDateTime datetimeShori) {

        switch (datetimeShori.getYear()) {
            // caseテンプレート始まり
            
            // 2024年
            case YEAR_2024:
                return callSnsDirectMessageSendingInfo2024Logic.practice(datetimeShori);

            // 2022年
            case YEAR_2022:
                return callSnsDirectMessageSendingInfo2022Logic.practice(datetimeShori);

            // 2025年
            case YEAR_2025:
                return callSnsDirectMessageSendingInfo2025Logic.practice(datetimeShori);

            // caseの追加位置

            default:
                throw new IllegalArgumentException("Unexpected value: " + datetimeShori.getYear());
        }

    }
}
