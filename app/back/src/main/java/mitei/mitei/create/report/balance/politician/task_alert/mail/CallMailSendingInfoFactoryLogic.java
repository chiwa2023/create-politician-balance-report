package mitei.mitei.create.report.balance.politician.task_alert.mail;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.mail.y2024.CallMailSendingInfo2024Logic;

/**
 * データベースからメール送信情報を呼び出す
 */
@Component
public class CallMailSendingInfoFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** 2024年Loigc */
    @Autowired
    private CallMailSendingInfo2024Logic callMailSendingInfo2024Logic;

    /**
     * データベースからメール送信情報を呼び出す(2024)年
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
            case YEAR_2024:
                return callMailSendingInfo2024Logic;

            default:
                return null;
        }
    }

}
