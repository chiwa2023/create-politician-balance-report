package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;

/**
 * 年ごとのメール送信予定を取り出すInterface
 */
public interface CallMailSendingInfoInterface {

    /**
     * 検索作業実施
     *
     * @param localDateTime 現在時間
     * @return メール送信Dto
     */
    SendMailCapsuleDto practice(LocalDateTime localDateTime);
}
