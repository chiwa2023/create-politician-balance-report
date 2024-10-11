package mitei.mitei.create.report.balance.politician.task_alert.sns;

import java.io.Serializable;

import mitei.mitei.create.report.balance.politician.dto.AbstractResultDto;

/**
 * SNSダイレクトメッセージ送信の送信結果を格納するDto
 */
public class SendSnsDirectMessageAllPlanResultDto extends AbstractResultDto implements Serializable {

    /** SerialId */
    private static final long serialVersionUID = 1L;

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

}
