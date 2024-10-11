package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024.CallSnsDirectMessageSendingInfo2024Logic;

/**
 * SNSダイレクトメッセージ送信予定を取得する
 */
@Component
public class CallSnsDirectMessageSendingInfoFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** SNSダイレクトメッセージ送信予定を取得する(2024年) */
    @Autowired
    private CallSnsDirectMessageSendingInfo2024Logic callSnsDirectMessageSendingInfo2024Logic;

    /**
     * 予定取得処理を行う
     *
     * @return ダイレクトメッセージ送信予定格納Dto
     */
    public SendSnsDirectMessageCapsuleDto practice(final LocalDateTime datetimeShori) {

        switch (datetimeShori.getYear()) {
            case YEAR_2024: 
                return callSnsDirectMessageSendingInfo2024Logic.practice(datetimeShori);
            default:
                throw new IllegalArgumentException("Unexpected value: " + datetimeShori.getYear());
        }
        
    
    }    
}
