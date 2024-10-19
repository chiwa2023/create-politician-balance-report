package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.task_plan.logic.CreateSendMessageLogic;
import mitei.mitei.create.report.balance.politician.task_plan.logic.PickupRelatedUserListByTaskKengenLogic;
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

    /** メッセージ本文作成Logic */
    @Autowired
    private CreateSendMessageLogic createSendMessageLogic;

    /** タスク該当ユーザ抽出Logic */
    @Autowired
    private PickupRelatedUserListByTaskKengenLogic pickupRelatedUserListByTaskKengenLogic;

    /** SNSダイレクトメッセージ送信Repository(2024年) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    /**
     * ダイレクトメッセージ送信計画データを挿入する
     *
     * @param privilegeDto  権限確認Dto
     * @param listUser      ユーザリスト
     * @param dateTimeShori 処理日時
     * @param listTask      タスクリスト
     */
    public int practice(final CheckPrivilegeDto privilegeDto, final List<UserWebAccessEntity> listUser,
            final LocalDateTime dateTimeShori, final List<TaskInfoEntity> listTask) {

        List<SendAlertSnsMessage2024Entity> list = new ArrayList<>();
        for (TaskInfoEntity taskEntity : listTask) {
            List<UserWebAccessEntity> listPickup = pickupRelatedUserListByTaskKengenLogic
                    .practice(taskEntity.getKengenKbn(), listUser);
            for (UserWebAccessEntity userEntity : listPickup) {
                list.add(this.createEntity(privilegeDto, dateTimeShori, userEntity, taskEntity));
            }
        }

        // 同一識別コード設定
        Integer code = 0;
        Optional<SendAlertSnsMessage2024Entity> optionl = sendAlertSnsMessage2024Repository
                .findFirstByOrderBySendAlertSnsMessageCodeDesc();
        if (!optionl.isEmpty()) {
            code = optionl.get().getSendAlertSnsMessageCode();
        }
        for (SendAlertSnsMessage2024Entity entity : list) {
            code++;
            entity.setSendAlertSnsMessageCode(code);
        }

        return sendAlertSnsMessage2024Repository.saveAll(list).size();
    }

    private SendAlertSnsMessage2024Entity createEntity(final CheckPrivilegeDto privilegeDto,
            final LocalDateTime dateTimeShori, final UserWebAccessEntity userEntity, final TaskInfoEntity taskEntity) {

        SendAlertSnsMessage2024Entity entity = new SendAlertSnsMessage2024Entity();
        SetTableDataHistoryUtil.practice(privilegeDto, entity, DataHistoryStatusConstants.INSERT);

        // 送信内容設定
        entity.setSnsLogicId(userEntity.getSendSnsLogicId());
        entity.setBodyText(createSendMessageLogic.practice(userEntity.getUserName(), taskEntity));
        entity.setSendUserId(userEntity.getUserId());
        entity.setSendUserCode(userEntity.getUserCode());
        entity.setSendUserName(userEntity.getUserName());

        // 送信条件の設定
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

        entity.setSendAlertSnsMessageId(0L); // auto increment

        return entity;
    }

}
