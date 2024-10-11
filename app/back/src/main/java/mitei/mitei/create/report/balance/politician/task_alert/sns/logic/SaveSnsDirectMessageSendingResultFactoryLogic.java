package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageAllPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024.SaveSnsDirectMessageSendingResult2024Logic;

/**
 * SNSダイレクトメッセージ送信予定FactoryLogic
 */
@Component
public class SaveSnsDirectMessageSendingResultFactoryLogic {

    /** 2024年 */
    private static final int YEAR_2024 = 2024;
    /** SNSダイレクトメッセージ送信結果保存Logic(2024年) */
    @Autowired
    private SaveSnsDirectMessageSendingResult2024Logic saveSnsDirectMessageSendingResult2024Logic;

    /**
     * 処理を行う
     *
     * @param datetimeShori 処理日
     * @param listResult    送信結果リスト
     * @return 最終結果Dto
     */
    public SendSnsDirectMessageAllPlanResultDto practice(final LocalDateTime datetimeShori,
            final List<SendSnsDirectMessageResultDto> listResult) {

        switch (datetimeShori.getYear()) {
            case YEAR_2024:
                return saveSnsDirectMessageSendingResult2024Logic.practice(listResult);
            default:
                throw new IllegalArgumentException("Unexpected value: " + datetimeShori.getYear());
        }

    }
}
