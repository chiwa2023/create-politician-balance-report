package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;

/**
 * SNSダイレクトメッセージ送信予定を取得する(2024年)
 */
@Component
public class CallSnsDirectMessageSendingInfo2024Logic {

    /** SNSダイレクトメッセージ送信Repository(2024年) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    /**
     * 予定取得処理を行う
     *
     * @return ダイレクトメッセージ送信予定格納Dto
     */
    public SendSnsDirectMessageCapsuleDto practice(final LocalDateTime datetimeShori) {

        SendSnsDirectMessageCapsuleDto capsuleDto = new SendSnsDirectMessageCapsuleDto();
        
        List<SendAlertSnsMessage2024Entity> listEntity = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendDatetimeBeforeOrderBySendAlertSnsMessageId(DataHistoryStatusConstants.INSERT.value(),
                        datetimeShori);

        List<SnsDirectMessageDto> listMessage = new ArrayList<>();

        for (SendAlertSnsMessage2024Entity entity : listEntity) {
            listMessage.add(this.createDto(entity));
        }

        capsuleDto.setListSnsMessageData(listMessage);

        return capsuleDto;
    }

    /**
     * ダイレクトメッセージ送信予定Entityからダイレクトメッセージ送信送信Dtoを生成する
     *
     * @param entity ダイレクトメッセージ送信Entity
     * @return ダイレクトメッセージ送信Dto
     */
    private SnsDirectMessageDto createDto(final SendAlertSnsMessage2024Entity entity) {
        
        CheckPrivilegeDto privilegeDto = new CheckPrivilegeDto();
        privilegeDto.setLoginUserId(entity.getSendUserId());
        privilegeDto.setLoginUserCode(entity.getSendUserCode());
        privilegeDto.setLoginUserName(entity.getSendUserName());

        SnsDirectMessageDto messageDto = new SnsDirectMessageDto();

        messageDto.setCheckPrivilegeDto(privilegeDto);
        
        messageDto.setBodyMessage(entity.getBodyText());
        messageDto.setSnsLogicId(entity.getSnsLogicId());
        messageDto.setSendAlertSnsMessageId(entity.getSendAlertSnsMessageId());
        messageDto.setSendAlertSnsMessageCode(entity.getSendAlertSnsMessageCode());

        return messageDto;
    }

}
