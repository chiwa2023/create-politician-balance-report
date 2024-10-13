package mitei.mitei.create.report.balance.politician.repository.sns;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;

/**
 * send_alert_sns_message_2024接続用Repository
 */
public interface SendAlertSnsMessage2024Repository extends JpaRepository<SendAlertSnsMessage2024Entity, Long> {

    // TODO マスタ系のテーブルでは名称検索が要求されることが多いので、事前に自動生成する。不要な場合は削除する
    /**
     * 名称を検索対象として全文検索をする
     *
     * @param searchWords 検索語
     * @return 検索結果
     */
    @Query(value = "SELECT * FROM send_alert_sns_message_2024 WHERE saishin_kbn= 1 AND MATCH(send_alert_sns_message_2024_name) AGAINST (?1 IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<SendAlertSnsMessage2024Entity> findFullText(String searchWords);

    /**
     * SNSダイレクトメッセージを送信する予定リストを取得する
     *
     * @param saishinKbn   最新区分
     * @param sendDatetime 処理基準時間
     * @return SNSダイレクトメッセージを送信する予定リスト
     */
    List<SendAlertSnsMessage2024Entity> findBySaishinKbnAndSendDatetimeBeforeOrderBySendAlertSnsMessageId(
            Integer saishinKbn, LocalDateTime sendDatetime);

    /**
     * 最新区分と行同一識別コードが一致するデータを取得する
     *
     * @param saishinKbn  最新区分
     * @param messageCode 行同一識別コード
     * @return データリスト
     */
    List<SendAlertSnsMessage2024Entity> findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(
            Integer saishinKbn, Integer messageCode);

}
