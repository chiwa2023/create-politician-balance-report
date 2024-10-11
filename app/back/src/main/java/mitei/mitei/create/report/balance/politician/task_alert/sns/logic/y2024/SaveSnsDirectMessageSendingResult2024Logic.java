package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageAllPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.util.SetTableDataHistoryUtil;

/**
 * SNSダイレクトメッセージ送信結果を保存する(2024年)
 */
@Component
public class SaveSnsDirectMessageSendingResult2024Logic {

    /** 再送信回数0回目 */
    private static final int TIMES0 = 0;
    /** 再送信回数1回目 */
    private static final int TIMES1 = 1;
    /** 再送信回数3回目 */
    private static final int TIMES2 = 2;
    /** 再送信回数3回目 */
    private static final int TIMES3 = 3;
    /** 再送信回数4回目 */
    private static final int TIMES4 = 4;
    /** 再送信回数5回目 */
    private static final int TIMES5 = 5;

    /** SNSダイレクトメッセージ送信Repository(2024年) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    /**
     * 送信結果保全処理を行う
     *
     * @param listResult 結果リスト
     * @return 最終結果リスト
     */
    public SendSnsDirectMessageAllPlanResultDto practice(final List<SendSnsDirectMessageResultDto> listResult) {

        List<SendAlertSnsMessage2024Entity> listUpdate = new ArrayList<>();
        List<SendAlertSnsMessage2024Entity> listInsert = new ArrayList<>();

        SendAlertSnsMessage2024Entity entity;
        SendAlertSnsMessage2024Entity entityPlan;
        CheckPrivilegeDto privilegeDto;
        int count = 0;
        int failure = 0;
        for (SendSnsDirectMessageResultDto dto : listResult) {
            count++;
            
            entity = this.getEntityById(dto.getSendAlertSnsMessageId());
            privilegeDto = this.createPriviledgeDto(entity);
            if(!dto.getIsOk()) {
                failure++;
            }
            entityPlan = this.createSedingPlanEntity(dto.getIsOk(), entity,privilegeDto);

            if (!Objects.isNull(entityPlan)) {
                listInsert.add(entityPlan);
            }

            // 送信済データはすべて履歴に
            SetTableDataHistoryUtil.practice(privilegeDto, entity, DataHistoryStatusConstants.UPDATE);
            listUpdate.add(entity);
        }

        sendAlertSnsMessage2024Repository.saveAll(listUpdate);
        sendAlertSnsMessage2024Repository.saveAll(listInsert);

        // 最終結果を用意する
        SendSnsDirectMessageAllPlanResultDto resultDto = new SendSnsDirectMessageAllPlanResultDto();
        resultDto.setFailureCount(failure);
        resultDto.setSuccessCount(count-failure);
        resultDto.setIsOk(failure == 0);

        return resultDto;
    }

    /**
     * テーブルIdを用いてデータを取得する
     *
     * @param entityId テーブルId
     * @return SNSダイレクトメッセージ送信予定Entity
     */
    private SendAlertSnsMessage2024Entity getEntityById(final Long entityId) {

        return sendAlertSnsMessage2024Repository.findById(entityId).get();
    }

    
    private CheckPrivilegeDto createPriviledgeDto(final SendAlertSnsMessage2024Entity entity) {
        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        
        checkPrivilegeDto.setLoginUserId(entity.getInsertUserId());
        checkPrivilegeDto.setLoginUserCode(entity.getInsertUserCode());
        checkPrivilegeDto.setLoginUserName(entity.getInsertUserName());
        
        return checkPrivilegeDto;
    }
    
    
    /**
     * 未送信の時だけSNSダイレクトメッセージ送信予定を生成して返却する
     *
     * @param isSuccess 送信結果
     * @param entity    元予定Entity
     * @return 新たなSNSダイレクトメッセージ送信予定Entity
     */
    private SendAlertSnsMessage2024Entity createSedingPlanEntity(final Boolean isSuccess,
            final SendAlertSnsMessage2024Entity entity,final CheckPrivilegeDto checkPrivilegeDto) {

        // 送信完了していればnullを戻す
        if (isSuccess) {
            return null;
        }

        SendAlertSnsMessage2024Entity planEntity = new SendAlertSnsMessage2024Entity();
        BeanUtils.copyProperties(entity, planEntity);

        planEntity.setSendAlertSnsMessageId(0L); // autoIncrement
        SetTableDataHistoryUtil.practice(checkPrivilegeDto, planEntity, DataHistoryStatusConstants.INSERT);

        switch (entity.getTimesRetryNext()) {

            // 再送信1回目を作成
            case TIMES0:
                planEntity.setSendDatetime(planEntity.getDatetimeTimes1());
                planEntity.setTimesRetryNext(TIMES1);
                return planEntity;

            // 再送信2回目を作成
            case TIMES1:
                planEntity.setSendDatetime(planEntity.getDatetimeTimes2());
                planEntity.setTimesRetryNext(TIMES2);
                return planEntity;
                
            // 再送信3回目を作成
            case TIMES2:
                planEntity.setSendDatetime(planEntity.getDatetimeTimes3());
                planEntity.setTimesRetryNext(TIMES3);
                return planEntity;

            // 再送信4回目を作成
            case TIMES3:
                planEntity.setSendDatetime(planEntity.getDatetimeTimes4());
                planEntity.setTimesRetryNext(TIMES4);
                return planEntity;

            // 再送信5回目を作成
            case TIMES4:
                planEntity.setSendDatetime(planEntity.getDatetimeTimes5());
                planEntity.setTimesRetryNext(TIMES5);
                return planEntity;

            // 再送信6回目は作成しない(ここまで)
            case TIMES5:
                return null;

            // その他の値が来ても予定を作成しない
            default:
                return null;
        }

    }
}
