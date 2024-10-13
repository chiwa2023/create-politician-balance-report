package mitei.mitei.create.report.balance.politician.task_alert.sns;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.AbstractResultDto;

/**
 * SNSダイレクトメッセージ
 */
public class SendSnsDirectMessageResultDto extends AbstractResultDto implements Serializable { // NOPMD DataCalss

    /** SerialId */
    private static final long serialVersionUID = 1L;

    /** 初期データ(Integer) */
    private static final Integer INIT_Integer = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_Long = 0L;

    /** メッセージ */
    private String message;

    /**
     * メッセージを取得する
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * メッセージを設定する
     */
    @Override
    public void setMessage(final String message) {
        this.message = message;
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


}
