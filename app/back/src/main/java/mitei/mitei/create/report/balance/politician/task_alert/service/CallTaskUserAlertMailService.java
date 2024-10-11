package mitei.mitei.create.report.balance.politician.task_alert.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mitei.mitei.create.report.balance.politician.task_alert.mail.CallMailSendingInfoFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SaveMailSendingResultFactoryLogic;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailAllPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMaileResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.mock.MockSendMailUserLogic;

/**
 * メール通知を行うService
 */
@Service
public class CallTaskUserAlertMailService {

    /** メール送信情報呼び出しLogic */
    @Autowired
    private CallMailSendingInfoFactoryLogic callMailSendingInfoFactoryLogic;

    /** メール送信Logic TODO Mockロジックから本番Logic入れ替え */
    @Autowired
    private MockSendMailUserLogic sendMailUserLogic;

    /** 送信結果保存Logic */
    @Autowired
    private SaveMailSendingResultFactoryLogic saveMailSendingResultFactoryLogic;

    /**
     * 処理日の応じためー送信処理を行う
     *
     * @param datetimeShori 処理日
     * @return メール通知送信結果
     */
    public SendMailAllPlanResultDto practice(final LocalDateTime datetimeShori) {

        // 送信データを呼び出す
        SendMailCapsuleDto capsuleDto = callMailSendingInfoFactoryLogic.practice(datetimeShori);

        // 送信を行う
        SendMaileResultDto sendMaileResultDto = sendMailUserLogic.practice(capsuleDto);

        // 送信結果を保存する
        return saveMailSendingResultFactoryLogic.practice(datetimeShori, capsuleDto.getListMailData(),
                sendMaileResultDto.getListFailure());

    }
}
