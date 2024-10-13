package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.mail.y2024.CallMailSendingInfo2024Logic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.y2022.CallMailSendingInfo2022Logic;
// importを追加

/**
 * データベースからメール送信情報を呼び出す
 */
@Component
public class CallMailSendingInfoFactoryLogic {

    // フィールドテンプレート始まり

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 2024年Loigc */
    @Autowired // 2024
    private CallMailSendingInfo2024Logic callMailSendingInfo2024Logic;

    /** 2022年 */
    private static final int YEAR_2022 = 2022;
    /** 2022年Loigc */
    @Autowired // 2022
    private CallMailSendingInfo2022Logic callMailSendingInfo2022Logic;

    // フィールドの追加位置

    /**
     * データベースからメール送信情報を呼び出す
     *
     * @param localDateTime 処理日
     * @return メール送信情報Dto
     */
    public SendMailCapsuleDto practice(final LocalDateTime localDateTime) {

        CallMailSendingInfoInterface logicImpl = this.getLogic(localDateTime.getYear());

        SendMailCapsuleDto capsuleDto = new SendMailCapsuleDto();
        if (Objects.isNull(logicImpl)) {
            return capsuleDto;
        } else {
            return logicImpl.practice(localDateTime);
        }

    }

    private CallMailSendingInfoInterface getLogic(final Integer year) {

        switch (year) {
            // caseテンプレート始まり

            // 2024年
            case YEAR_2024:
                return callMailSendingInfo2024Logic;

            // 2022年
            case YEAR_2022:
                return callMailSendingInfo2022Logic;

            // caseの追加位置

            default:
                return null;
        }
    }

}
