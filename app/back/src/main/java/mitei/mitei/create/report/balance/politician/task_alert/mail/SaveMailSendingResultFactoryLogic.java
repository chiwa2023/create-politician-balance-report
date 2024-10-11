package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.mail.y2024.SaveMailSendingResult2024Logic;

/**
 * メール送信処理結果を保存するLogic
 */
@Component
public class SaveMailSendingResultFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** メール送信結果保存Logic2024 */
    @Autowired
    private SaveMailSendingResult2024Logic saveMailSendingResult2024Logic;

    /**
     * メール送信結果を保存する
     *
     * @param datetimeShori 処理日時
     * @param listPickup 全処理データリスト
     * @param listFailure 送信失敗Dataリスト
     */
    public SendMailAllPlanResultDto practice(final LocalDateTime datetimeShori, final List<MailDataDto> listPickup,
            final List<MailDataDto> listFailure) {

        switch (datetimeShori.getYear()) {

            // 2024年
            case YEAR_2024:
                return saveMailSendingResult2024Logic.practice(datetimeShori,listPickup, listFailure);
            default:
                throw new IllegalArgumentException("Unexpected value: " + datetimeShori.getYear());
        }

    }
}
