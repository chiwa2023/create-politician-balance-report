package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.mail.y2024.SaveMailSendingResult2024Logic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.y2022.SaveMailSendingResult2022Logic;
// importを追加

/**
 * メール送信処理結果を保存するLogic
 */
@Component
public class SaveMailSendingResultFactoryLogic {

    // フィールドテンプレート始まり

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** メール送信結果保存Logic2024 */
    @Autowired // 2024
    private SaveMailSendingResult2024Logic saveMailSendingResult2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** メール送信結果保存Logic2022 */
    @Autowired // 2022
    private SaveMailSendingResult2022Logic saveMailSendingResult2022Logic;

    // フィールドの追加位置

    /**
     * メール送信結果を保存する
     *
     * @param datetimeShori 処理日時
     * @param listPickup    全処理データリスト
     * @param listFailure   送信失敗Dataリスト
     */
    public SendMailAllPlanResultDto practice(final LocalDateTime datetimeShori, final List<MailDataDto> listPickup,
            final List<MailDataDto> listFailure) {

        switch (datetimeShori.getYear()) {

            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return saveMailSendingResult2024Logic.practice(datetimeShori, listPickup, listFailure);

            // 2022年
            case YEAR_2022:
                return saveMailSendingResult2022Logic.practice(datetimeShori, listPickup, listFailure);

            // caseの追加位置

            default:
                throw new IllegalArgumentException("Unexpected value: " + datetimeShori.getYear());
        }

    }
}
