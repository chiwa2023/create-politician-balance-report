package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2022;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2022Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2022Repository;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;

/**
 * SNSダイレクトメッセージ送信予定を取得する(2022年)
 */
@Component
public class CallSnsDirectMessageSendingInfo2022Logic {

    /** SNSダイレクトメッセージ送信Repository(2022年) */
    @Autowired
    private SendAlertSnsMessage2022Repository sendAlertSnsMessage2022Repository;

    /**
     * 予定取得処理を行う
     *
     * @return ダイレクトメッセージ送信予定格納Dto
     */
    public SendSnsDirectMessageCapsuleDto practice(final LocalDateTime datetimeShori) {

        SendSnsDirectMessageCapsuleDto capsuleDto = new SendSnsDirectMessageCapsuleDto();
        
        List<SendAlertSnsMessage2022Entity> listEntity = sendAlertSnsMessage2022Repository
                .findBySaishinKbnAndSendDatetimeBeforeOrderBySendAlertSnsMessageId(DataHistoryStatusConstants.INSERT.value(),
                        datetimeShori);

        List<SnsDirectMessageDto> listMessage = new ArrayList<>();

        for (SendAlertSnsMessage2022Entity entity : listEntity) {
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
    private SnsDirectMessageDto createDto(final SendAlertSnsMessage2022Entity entity) {
        
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
