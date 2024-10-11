package mitei.mitei.create.report.balance.politician.entity.sns;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.entity.AllTabeDataHistoryInterface;



/**
 * send_alert_sns_message_2024接続用Entity
 */
@Entity
@Table(name = "send_alert_sns_message_2024")
public class SendAlertSnsMessage2024Entity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_String = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LocalDate = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_LocalDateTime = INIT_LocalDate.atTime(0, 0, 0);

    /** 項目名称取得Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "send_alert_sns_message_id")
    private Long sendAlertSnsMessageId = INIT_Long;

    /**
     * 項目名称取得Idを取得する
     *
     * @return 項目名称取得Id
     */
    public Long getSendAlertSnsMessageId() {
        return sendAlertSnsMessageId;
    }

    /**
     * 項目名称取得Idを設定する
     *
     * @param sendAlertSnsMessageId 項目名称取得Id
     */
    public void setSendAlertSnsMessageId(final Long sendAlertSnsMessageId) {
        this.sendAlertSnsMessageId = sendAlertSnsMessageId;
    }

    /** 項目名称取得同一識別コード */
    @Column(name = "send_alert_sns_message_code")
    private Integer sendAlertSnsMessageCode = INIT_Integer;

    /**
     * 項目名称取得同一識別コードを取得する
     *
     * @return 項目名称取得同一識別コード
     */
    public Integer getSendAlertSnsMessageCode() {
        return sendAlertSnsMessageCode;
    }

    /**
     * 項目名称取得同一識別コードを設定する
     *
     * @param sendAlertSnsMessageCode 項目名称取得同一識別コード
     */
    public void setSendAlertSnsMessageCode(final Integer sendAlertSnsMessageCode) {
        this.sendAlertSnsMessageCode = sendAlertSnsMessageCode;
    }

    /** 最新区分 */
    @Column(name = "saishin_kbn")
    private Integer saishinKbn = INIT_Integer;

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    @Override
    public Integer getSaishinKbn() {
        return saishinKbn;
    }

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    @Override
    public void setSaishinKbn(final Integer saishinKbn) {
        this.saishinKbn = saishinKbn;
    }

    /** 送信先ユーザId */
    @Column(name = "send_user_id")
    private Long sendUserId = INIT_Long;

    /**
     * 送信先ユーザIdを取得する
     *
     * @return 送信先ユーザId
     */
    public Long getSendUserId() {
        return sendUserId;
    }

    /**
     * 送信先ユーザIdを設定する
     *
     * @param sendUserId 送信先ユーザId
     */
    public void setSendUserId(final Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    /** 送信先ユーザ同一識別コード */
    @Column(name = "send_user_code")
    private Integer sendUserCode = INIT_Integer;

    /**
     * 送信先ユーザ同一識別コードを取得する
     *
     * @return 送信先ユーザ同一識別コード
     */
    public Integer getSendUserCode() {
        return sendUserCode;
    }

    /**
     * 送信先ユーザ同一識別コードを設定する
     *
     * @param sendUserCode 送信先ユーザ同一識別コード
     */
    public void setSendUserCode(final Integer sendUserCode) {
        this.sendUserCode = sendUserCode;
    }

    /** 送信先ユーザ名称 */
    @Column(name = "send_user_name")
    private String sendUserName = INIT_String;

    /**
     * 送信先ユーザ名称を取得する
     *
     * @return 送信先ユーザ名称
     */
    public String getSendUserName() {
        return sendUserName;
    }

    /**
     * 送信先ユーザ名称を設定する
     *
     * @param sendUserName 送信先ユーザ名称
     */
    public void setSendUserName(final String sendUserName) {
        this.sendUserName = sendUserName;
    }

    /** SNSLogicのId */
    @Column(name = "sns_logic_id")
    private Integer snsLogicId;

    /**
     * SnsLogicIdを取得する
     *
     * @return SnsLogicId
     */
    public Integer getSnsLogicId() {
        return snsLogicId;
    }

    /**
     * SnsLogicIdを設定する
     *
     * @param snsLogicId SnsLogicId
     */
    public void setSnsLogicId(final Integer snsLogicId) {
        this.snsLogicId = snsLogicId;
    }


    /** 次回送信時刻 */
    @Column(name = "send_datetime")
    private LocalDateTime sendDatetime = INIT_LocalDateTime;

    /**
     * 次回送信時刻を取得する
     *
     * @return 次回送信時刻
     */
    public LocalDateTime getSendDatetime() {
        return sendDatetime;
    }

    /**
     * 次回送信時刻を設定する
     *
     * @param sendDatetime 次回送信時刻
     */
    public void setSendDatetime(final LocalDateTime sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    /** 次回送信試行回目 */
    @Column(name = "times_retry_next")
    private Integer timesRetryNext = INIT_Integer;

    /**
     * 次回送信試行回目を取得する
     *
     * @return 次回送信試行回目
     */
    public Integer getTimesRetryNext() {
        return timesRetryNext;
    }

    /**
     * 次回送信試行回目を設定する
     *
     * @param timesRetryNext 次回送信試行回目
     */
    public void setTimesRetryNext(final Integer timesRetryNext) {
        this.timesRetryNext = timesRetryNext;
    }

    /** 再試行1回目時間(3時間後) */
    @Column(name = "datetime_times1")
    private LocalDateTime datetimeTimes1 = INIT_LocalDateTime;

    /**
     * 再試行1回目時間(3時間後)を取得する
     *
     * @return 再試行1回目時間(3時間後)
     */
    public LocalDateTime getDatetimeTimes1() {
        return datetimeTimes1;
    }

    /**
     * 再試行1回目時間(3時間後)を設定する
     *
     * @param datetimeTimes1 再試行1回目時間(3時間後)
     */
    public void setDatetimeTimes1(final LocalDateTime datetimeTimes1) {
        this.datetimeTimes1 = datetimeTimes1;
    }

    /** 再試行1回目時間(6時間後) */
    @Column(name = "datetime_times2")
    private LocalDateTime datetimeTimes2 = INIT_LocalDateTime;

    /**
     * 再試行1回目時間(6時間後)を取得する
     *
     * @return 再試行1回目時間(6時間後)
     */
    public LocalDateTime getDatetimeTimes2() {
        return datetimeTimes2;
    }

    /**
     * 再試行1回目時間(6時間後)を設定する
     *
     * @param datetimeTimes2 再試行1回目時間(6時間後)
     */
    public void setDatetimeTimes2(final LocalDateTime datetimeTimes2) {
        this.datetimeTimes2 = datetimeTimes2;
    }

    /** 再試行1回目時間(12時間後) */
    @Column(name = "datetime_times3")
    private LocalDateTime datetimeTimes3 = INIT_LocalDateTime;

    /**
     * 再試行1回目時間(12時間後)を取得する
     *
     * @return 再試行1回目時間(12時間後)
     */
    public LocalDateTime getDatetimeTimes3() {
        return datetimeTimes3;
    }

    /**
     * 再試行1回目時間(12時間後)を設定する
     *
     * @param datetimeTimes3 再試行1回目時間(12時間後)
     */
    public void setDatetimeTimes3(final LocalDateTime datetimeTimes3) {
        this.datetimeTimes3 = datetimeTimes3;
    }

    /** 再試行1回目時間(24時間後) */
    @Column(name = "datetime_times4")
    private LocalDateTime datetimeTimes4 = INIT_LocalDateTime;

    /**
     * 再試行1回目時間(24時間後)を取得する
     *
     * @return 再試行1回目時間(24時間後)
     */
    public LocalDateTime getDatetimeTimes4() {
        return datetimeTimes4;
    }

    /**
     * 再試行1回目時間(24時間後)を設定する
     *
     * @param datetimeTimes4 再試行1回目時間(24時間後)
     */
    public void setDatetimeTimes4(final LocalDateTime datetimeTimes4) {
        this.datetimeTimes4 = datetimeTimes4;
    }

    /** 再試行1回目時間(48時間後) */
    @Column(name = "datetime_times5")
    private LocalDateTime datetimeTimes5 = INIT_LocalDateTime;

    /**
     * 再試行1回目時間(48時間後)を取得する
     *
     * @return 再試行1回目時間(48時間後)
     */
    public LocalDateTime getDatetimeTimes5() {
        return datetimeTimes5;
    }

    /**
     * 再試行1回目時間(48時間後)を設定する
     *
     * @param datetimeTimes5 再試行1回目時間(48時間後)
     */
    public void setDatetimeTimes5(final LocalDateTime datetimeTimes5) {
        this.datetimeTimes5 = datetimeTimes5;
    }

    /** メッセージ本文 */
    @Column(name = "body_text")
    private String bodyText = INIT_String;

    /**
     * メッセージ本文を取得する
     *
     * @return メッセージ本文
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * メッセージ本文を設定する
     *
     * @param bodyText メッセージ本文
     */
    public void setBodyText(final String bodyText) {
        this.bodyText = bodyText;
    }

    /** 挿入ユーザId */
    @Column(name = "insert_user_id")
    private Long insertUserId = INIT_Long;

    /**
     * 挿入ユーザIdを取得する
     *
     * @return 挿入ユーザId
     */
    @Override
    public Long getInsertUserId() {
        return insertUserId;
    }

    /**
     * 挿入ユーザIdを設定する
     *
     * @param insertUserId 挿入ユーザId
     */
    @Override
    public void setInsertUserId(final Long insertUserId) {
        this.insertUserId = insertUserId;
    }

    /** 挿入ユーザ同一識別コード */
    @Column(name = "insert_user_code")
    private Integer insertUserCode = INIT_Integer;

    /**
     * 挿入ユーザ同一識別コードを取得する
     *
     * @return 挿入ユーザ同一識別コード
     */
    @Override
    public Integer getInsertUserCode() {
        return insertUserCode;
    }

    /**
     * 挿入ユーザ同一識別コードを設定する
     *
     * @param insertUserCode 挿入ユーザ同一識別コード
     */
    @Override
    public void setInsertUserCode(final Integer insertUserCode) {
        this.insertUserCode = insertUserCode;
    }

    /** 挿入ユーザ姓名 */
    @Column(name = "insert_user_name")
    private String insertUserName = INIT_String;

    /**
     * 挿入ユーザ姓名を取得する
     *
     * @return 挿入ユーザ姓名
     */
    @Override
    public String getInsertUserName() {
        return insertUserName;
    }

    /**
     * 挿入ユーザ姓名を設定する
     *
     * @param insertUserName 挿入ユーザ姓名
     */
    @Override
    public void setInsertUserName(final String insertUserName) {
        this.insertUserName = insertUserName;
    }

    /** 挿入タイムスタンプ */
    @Column(name = "insert_timestamp")
    private LocalDateTime insertTimestamp = INIT_LocalDateTime;

    /**
     * 挿入タイムスタンプを取得する
     *
     * @return 挿入タイムスタンプ
     */
    @Override
    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * 挿入タイムスタンプを設定する
     *
     * @param insertTimestamp 挿入タイムスタンプ
     */
    @Override
    public void setInsertTimestamp(final LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /** 更新ユーザId */
    @Column(name = "update_user_id")
    private Long updateUserId = INIT_Long;

    /**
     * 更新ユーザIdを取得する
     *
     * @return 更新ユーザId
     */
    @Override
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 更新ユーザIdを設定する
     *
     * @param updateUserId 更新ユーザId
     */
    @Override
    public void setUpdateUserId(final Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 更新ユーザ同一識別コード */
    @Column(name = "update_user_code")
    private Integer updateUserCode = INIT_Integer;

    /**
     * 更新ユーザ同一識別コードを取得する
     *
     * @return 更新ユーザ同一識別コード
     */
    @Override
    public Integer getUpdateUserCode() {
        return updateUserCode;
    }

    /**
     * 更新ユーザ同一識別コードを設定する
     *
     * @param updateUserCode 更新ユーザ同一識別コード
     */
    @Override
    public void setUpdateUserCode(final Integer updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    /** 更新ユーザ姓名 */
    @Column(name = "update_user_name")
    private String updateUserName = INIT_String;

    /**
     * 更新ユーザ姓名を取得する
     *
     * @return 更新ユーザ姓名
     */
    @Override
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 更新ユーザ姓名を設定する
     *
     * @param updateUserName 更新ユーザ姓名
     */
    @Override
    public void setUpdateUserName(final String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /** 更新タイムスタンプ */
    @Column(name = "update_timestamp")
    private LocalDateTime updateTimestamp = INIT_LocalDateTime;

    /**
     * 更新タイムスタンプを取得する
     *
     * @return 更新タイムスタンプ
     */
    @Override
    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 更新タイムスタンプを設定する
     *
     * @param updateTimestamp 更新タイムスタンプ
     */
    @Override
    public void setUpdateTimestamp(final LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
