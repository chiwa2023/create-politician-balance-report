package mitei.mitei.create.report.balance.politician.task_alert.sns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.AbstractCapsuleDto;

/**
 * SNSダイレクトメッセージ送信情報格納Dto
 */

public class SendSnsDirectMessageCapsuleDto extends AbstractCapsuleDto implements Serializable {

    /** SerialId */
    private static final long serialVersionUID = 1L;

    /** 送信SNS情報リスト */
    private List<SnsDirectMessageDto> listSnsMessageData = new ArrayList<>();

    /**
     * SNS送信メッセージリストを取得する
     *
     * @return SNS送信メッセージ
     */
    public List<SnsDirectMessageDto> getListSnsMessageData() {
        return listSnsMessageData;
    }

    /**
     * SNS送信メッセージを設定する
     *
     * @param listSnsMessageData SNS送信メッセージ
     */
    public void setListSnsMessageData(final List<SnsDirectMessageDto> listSnsMessageData) {
        this.listSnsMessageData = listSnsMessageData;
    }

}
