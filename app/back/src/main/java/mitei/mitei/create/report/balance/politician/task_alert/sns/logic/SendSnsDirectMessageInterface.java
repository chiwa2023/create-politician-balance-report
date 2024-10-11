package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;

/**
 * SNダイレクトメッセージ送信を共通の情報で行うためのInterface
 */
public interface SendSnsDirectMessageInterface {

    /**
     * 実際の送信を行うメソッド
     *
     * @param directMessageDto 送信内容格納Dto
     * @return 送信結果格納Dto
     */
    SendSnsDirectMessageResultDto practice(SnsDirectMessageDto directMessageDto);

}
