package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.util.SetTableDataHistoryUtil;

/**
 * SNSダイレクトメッセージ送信送信予定追加Logic
 */
@Component
public class InsertSnsDirectMessageSendingInfo2024Logic {

    /** 再試行１回目の時間間隔 */
    private static final int TIMES1_HOUR = 3;
    /** 再試行2回目の時間間隔 */
    private static final int TIMES2_HOUR = 6;
    /** 再試行3回目の時間間隔 */
    private static final int TIMES3_HOUR = 12;
    /** 再試行4回目の日付間隔 */
    private static final int TIMES4_DAY = 1;
    /** 再試行5回目の日付間隔 */
    private static final int TIMES5_DAY = 2;

    /** SNSダイレクトメッセージ送信Repository(2024年) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    public int practice(final LocalDateTime dateTimeShori) {

        // TODO 仮Logicのため修正する
        
        // 権限Dto
        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        checkPrivilegeDto.setLoginUserId(1000L); // SUPPRESS CHECKSTYLE MagicNumber
        checkPrivilegeDto.setLoginUserCode(900); // SUPPRESS CHECKSTYLE MagicNumber
        checkPrivilegeDto.setLoginUserName("ユーザ名");
        checkPrivilegeDto.setPoliticalOrganizationId(2345L); // SUPPRESS CHECKSTYLE MagicNumber
        checkPrivilegeDto.setPoliticalOrganizationCode(2333); // SUPPRESS CHECKSTYLE MagicNumber
        checkPrivilegeDto.setPoliticalOrganizationName("サンプル政治団体");

        SendAlertSnsMessage2024Entity entity = new SendAlertSnsMessage2024Entity();
        SetTableDataHistoryUtil.practice(checkPrivilegeDto, entity, DataHistoryStatusConstants.INSERT);

        entity.setTimesRetryNext(0);
        entity.setSnsLogicId(1); // Mock Sample1を呼び出す
        entity.setBodyText("ダイレクトメッセージ送信本文");

        entity.setTimesRetryNext(0); // 初回は再試行回数0
        entity.setSendDatetime(dateTimeShori); // 初回は指定処理時間

        LocalDateTime time0 = LocalDateTime.from(dateTimeShori);

        // 3時間後
        LocalDateTime time1 = time0.plusHours(TIMES1_HOUR);
        entity.setDatetimeTimes1(time1);

        // 6時間後
        LocalDateTime time2 = time0.plusHours(TIMES2_HOUR);
        entity.setDatetimeTimes2(time2);

        // 12時間後
        LocalDateTime time3 = time0.plusHours(TIMES3_HOUR);
        entity.setDatetimeTimes3(time3);

        // 24時間後(1日後)
        LocalDateTime time4 = time0.plusDays(TIMES4_DAY);
        entity.setDatetimeTimes4(time4);

        // 2日後
        LocalDateTime time5 = time0.plusDays(TIMES5_DAY);
        entity.setDatetimeTimes5(time5);
        
        entity.setSendAlertSnsMessageId(323L);
        entity.setSendAlertSnsMessageCode(320);
        
        

        return sendAlertSnsMessage2024Repository.save(entity).getSendAlertSnsMessageCode();
    }

}
