package mitei.mitei.create.report.balance.politician.task_alert.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageAllPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.CallSnsDirectMessageSendingInfoFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.SaveSnsDirectMessageSendingResultFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.SendSnsDirectMessageFactoryLogic;

/**
 * SNSダイレクトメッセージ送信Service
 */
@Service
public class CallTaskUserAlertSnsService {

    /** SNS送信情報呼び出しLogic */
    @Autowired
    private CallSnsDirectMessageSendingInfoFactoryLogic callSnsDirectMessageSendingInfoFactoryLogic;

    /** SNSダイレクトメッセージ送信Logic */
    @Autowired
    private SendSnsDirectMessageFactoryLogic sendSnsDirectMessageFactoryLogic;

    /** 送信結果保存Logic */
    @Autowired
    private SaveSnsDirectMessageSendingResultFactoryLogic saveSnsDirectMessageSendingResultFactoryLogic;

    /**
     * SNSダイレクトメッセージ送信処理を行う
     *
     * @param datetimeShori 処理日付
     * @return 最終送信結果Dto
     */
    public SendSnsDirectMessageAllPlanResultDto practice(final LocalDateTime datetimeShori) {

        SendSnsDirectMessageCapsuleDto capsuleDto = callSnsDirectMessageSendingInfoFactoryLogic.practice(datetimeShori);
        
        List<SendSnsDirectMessageResultDto> listResult = sendSnsDirectMessageFactoryLogic.practice(capsuleDto);
        
        return saveSnsDirectMessageSendingResultFactoryLogic.practice(datetimeShori, listResult);
    }
}
