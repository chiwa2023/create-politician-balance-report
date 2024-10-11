package mitei.mitei.create.report.balance.politician.task_alert.sns;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;

/**
 * SNSダイレクトメッセージ送信用情報格納Dto
 */
public class SnsDirectMessageDto implements Serializable { // NOPMD DataClass

    /** SerialId */
    private static final long serialVersionUID = 1L;

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    
    /** 権限確認Dto */
    private CheckPrivilegeDto checkPrivilegeDto;

    /**
     * 権限確認Dtoを取得する
     *
     * @return 権限確認Dto
     */
    public CheckPrivilegeDto getCheckPrivilegeDto() {
        return checkPrivilegeDto;
    }

    /**
     * 権限確認Dtoを設定する
     *
     * @param checkPrivilegeDto 権限確認Dto
     */
    public void setCheckPrivilegeDto(final CheckPrivilegeDto checkPrivilegeDto) {
        this.checkPrivilegeDto = checkPrivilegeDto;
    }

    
    /** 項目名称取得Id */
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

    
    /** SNSLogicのId */
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

    /** 送信メッセージ本文 */
    private String bodyMessage;

    /**
     * 送信メッセージ本文を取得する
     *
     * @return 送信メッセージ本文
     */
    public String getBodyMessage() {
        return bodyMessage;
    }

    /**
     * 送信メッセージ本文を設定する
     *
     * @param bodyMessage 送信メッセージ本文
     */
    public void setBodyMessage(final String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    
    
    
}
