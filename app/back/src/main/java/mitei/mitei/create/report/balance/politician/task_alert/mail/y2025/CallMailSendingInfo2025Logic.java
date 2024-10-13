package mitei.mitei.create.report.balance.politician.task_alert.mail.y2025;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.mail.SendAlertMail2025Entity;
import mitei.mitei.create.report.balance.politician.repository.mail.SendAlertMail2025Repository;
import mitei.mitei.create.report.balance.politician.task_alert.mail.CallMailSendingInfoInterface;
import mitei.mitei.create.report.balance.politician.task_alert.mail.MailDataDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailCapsuleDto;

/**
 * メール送信予定を取得する(2025)
 */
@Component
public class CallMailSendingInfo2025Logic implements CallMailSendingInfoInterface {

    /** メール送信予定記録テーブル(2025) */
    @Autowired
    private SendAlertMail2025Repository sendAlertMail2025Repository;

    /**
     * 最新区分が最新・・・メール未送信データを取得する
     */
    @Override
    public SendMailCapsuleDto practice(final LocalDateTime localDateTime) {

        SendMailCapsuleDto capsuleDto = new SendMailCapsuleDto();

        // 最新区分かつ
        List<SendAlertMail2025Entity> listEntity = sendAlertMail2025Repository
                .findBySaishinKbnAndSendDatetimeBeforeOrderBySendAlertMailId(DataHistoryStatusConstants.INSERT.value(),
                        localDateTime);

        List<MailDataDto> list = new ArrayList<>();

        for (SendAlertMail2025Entity entity : listEntity) {
            list.add(this.createDto(entity));
        }

        capsuleDto.setListMailData(list);

        return capsuleDto;
    }

    /**
     * Entityから送信情報Dtoに変換する(BeanUtisがSQLの予約語とかなり重なっていて使いづらかった)
     *
     * @param entity 送信予定Entity
     * @return 送信予定Dto
     */
    private MailDataDto createDto(final SendAlertMail2025Entity entity) {

        CheckPrivilegeDto privilegeDto = new CheckPrivilegeDto();
        privilegeDto.setLoginUserId(entity.getSendUserId());
        privilegeDto.setLoginUserCode(entity.getSendUserCode());
        privilegeDto.setLoginUserName(entity.getSendUserName());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(entity.getFromMail());
        message.setTo(entity.getToMail());
        message.setCc(entity.getCcMail());
        message.setBcc(entity.getBccMail());
        message.setReplyTo(entity.getReplyToMail());
        message.setSubject(entity.getSubjectMail());
        message.setText(entity.getBodyTextMail());

        MailDataDto dto = new MailDataDto();
        dto.setCheckPrivilegeDto(privilegeDto);
        dto.setSimpleMailMessage(message);

        dto.setSendAlertMailId(entity.getSendAlertMailId());
        dto.setSendAlertMailCode(entity.getSendAlertMailCode());
        dto.setIsRepeat(entity.getIsRepeat());

        return dto;
    }

}
