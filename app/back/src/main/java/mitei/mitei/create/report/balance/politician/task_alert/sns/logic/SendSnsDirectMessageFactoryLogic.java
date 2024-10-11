package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.mock.sample1.MockSendSnsDirectMessageSample1Logic;
import mitei.mitei.create.report.balance.politician.task_alert.sns.logic.mock.sample2.MockSendSnsDirectMessageSample2Logic;

/**
 * 全SNSの送信作業を行うLogic
 */
@Component
public class SendSnsDirectMessageFactoryLogic {

    /** SNSの登録がない事を明示している */
    private static final int ID_NO_SEND = 0;

    /** テスト用SNS-Sample1の識別Id */
    private static final int ID_SAMPLE1 = MockSendSnsDirectMessageSample1Logic.LOGIC_ID;
    /** テスト用SNS-Sample1 */
    @Autowired
    private MockSendSnsDirectMessageSample1Logic sendSnsDirectMessageSample1Logic;

    /** テスト用SNS-Sample2の識別Id */
    private static final int ID_SAMPLE2 = MockSendSnsDirectMessageSample2Logic.LOGIC_ID;
    /** テスト用SNS-Sample2 */
    @Autowired
    private MockSendSnsDirectMessageSample2Logic sendSnsDirectMessageSample2Logic;

    /**
     * 指定されたSNSでのダイレクトメッセージ送信を行うFactoryLogic
     *
     * @param messageCapsuleDto SNS送信情報格納Dto
     * @return SNSダイレクトメッセージ送信結果格納Dto
     */
    public List<SendSnsDirectMessageResultDto> practice(final SendSnsDirectMessageCapsuleDto messageCapsuleDto) {

        // 送信ユーザ分の処理を行う
        List<SnsDirectMessageDto> listSend = messageCapsuleDto.getListSnsMessageData();
        List<SendSnsDirectMessageResultDto> listResult = new ArrayList<>();

        for (SnsDirectMessageDto directMessageDto : listSend) {
            listResult.add(this.execute(directMessageDto));
        }

        return listResult;
    }

    private SendSnsDirectMessageResultDto execute(final SnsDirectMessageDto directMessageDto) {

        SendSnsDirectMessageResultDto resultDto = new SendSnsDirectMessageResultDto();

        switch (directMessageDto.getSnsLogicId()) {
            
            // 送信する気がありません
            case ID_NO_SEND:
                resultDto.setIsOk(true);
                resultDto.setMessage("SNSダイレクトメッセージ送信をしない選択がされています");
                resultDto.setSendAlertSnsMessageId(directMessageDto.getSendAlertSnsMessageId());
                resultDto.setSendAlertSnsMessageCode(directMessageDto.getSendAlertSnsMessageCode());
                return resultDto;
            /*
             * ここから実際の送信ロジック(現在はMockだけ)
             */
            case ID_SAMPLE1:
                return sendSnsDirectMessageSample1Logic.practice(directMessageDto);
            case ID_SAMPLE2:
                return sendSnsDirectMessageSample2Logic.practice(directMessageDto);

            // 送信失敗処理
            default:
                resultDto.setIsOk(false); // 送信できていません
                resultDto.setMessage("ダイレクトメッセージ送信するSNSが選択されていません");
                resultDto.setSendAlertSnsMessageId(directMessageDto.getSendAlertSnsMessageId());
                resultDto.setSendAlertSnsMessageCode(directMessageDto.getSendAlertSnsMessageCode());
                return resultDto;
        }
    }

}
