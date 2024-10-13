package mitei.mitei.create.report.balance.politician.task_alert.mail.y2024;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.mail.SendAlertMail2024Entity;
import mitei.mitei.create.report.balance.politician.repository.mail.SendAlertMail2024Repository;
import mitei.mitei.create.report.balance.politician.task_alert.mail.MailDataDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailAllPlanResultDto;

/**
 * SaveMailSendingResult2024Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SaveMailSendingResult2024LogicTest {
    // CHECKSTYLE:OFF

    /** 単体テスト */
    @Autowired
    private SaveMailSendingResult2024Logic saveMailSendingResult2024Logic;

    /** 試行リストpickup用 */
    @Autowired
    private CallMailSendingInfo2024Logic callMailSendingInfo2024Logic;

    /** メール送信予定テーブルRepository(2024年) */
    @Autowired
    private SendAlertMail2024Repository sendAlertMail2024Repository;

    @Test
    @Sql("send_alert_mail_2024.sql")
    void testPractice() {

        LocalDateTime localDateTime = LocalDateTime.of(2024, 11, 1, 0, 0, 0);

        List<MailDataDto> listPickup = callMailSendingInfo2024Logic.practice(localDateTime).getListMailData();
        assertThat(listPickup.size()).isEqualTo(4); // 4件取得できているはず

        List<MailDataDto> listFailure = new ArrayList<>();
        listFailure.add(listPickup.get(1));

        SendMailAllPlanResultDto resultDto = saveMailSendingResult2024Logic.practice(localDateTime, listPickup,
                listFailure);
        assertThat(resultDto.getSuccessCount()).isEqualTo(3);
        assertThat(resultDto.getFailureCount()).isEqualTo(1);
        assertFalse(resultDto.getIsOk(), "意図的に1件失敗にもっていったのでステータス失敗");

        // 抽出されたIdリスト
        List<Long> listPickUpId = new ArrayList<>();
        for (MailDataDto dataDto : listPickup) {
            listPickUpId.add(dataDto.getSendAlertMailId());
        }

        // 更新が正常がチェックする
        List<SendAlertMail2024Entity> listAllEntity = sendAlertMail2024Repository.findAll();
        int updateValue = DataHistoryStatusConstants.UPDATE.value();
        for (SendAlertMail2024Entity entity : listAllEntity) {
            if (listPickUpId.contains(entity.getSendAlertMailId())) {
                // 抽出対象であれば最新区分は履歴(0)でないとダメ
                assertThat(entity.getSaishinKbn()).isEqualTo(updateValue);
            }
        }

        // 失敗データが新規再試行データに振り替わっているかチェック
        Optional<SendAlertMail2024Entity> optional = sendAlertMail2024Repository
                .findById(listFailure.get(0).getSendAlertMailId());
        SendAlertMail2024Entity entityFailure = optional.get();

        List<SendAlertMail2024Entity> listRetry = sendAlertMail2024Repository.findBySaishinKbnAndSendAlertMailCode(
                DataHistoryStatusConstants.INSERT.value(), entityFailure.getSendAlertMailCode());
        assertThat(listRetry.size()).isEqualTo(1); // 失敗したデータと同じ同一識別コードを持つ最新データは1件
        SendAlertMail2024Entity entityRetry = listRetry.get(0);
        assertThat(entityRetry.getSendDatetime()).isEqualTo(LocalDateTime.of(2024, 11, 1, 12, 0, 0)); // 再試行データは12時間後に設定

        // 新タスクに振替後のシナリオ
        LocalDateTime localDateTime02 = LocalDateTime.of(2024, 11, 2, 0, 0, 0);

        List<MailDataDto> listPickup02 = callMailSendingInfo2024Logic.practice(localDateTime02).getListMailData();
        assertThat(listPickup02.size()).isEqualTo(1); // 振り替えた1件取得できているはず

        // 引き続き送信に失敗
        List<MailDataDto> listFailure02 = new ArrayList<>();
        listFailure02.add(listPickup02.get(0));

        SendMailAllPlanResultDto resultDto02 = saveMailSendingResult2024Logic.practice(localDateTime02, listPickup02,
                listFailure02);
        assertThat(resultDto02.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto02.getFailureCount()).isEqualTo(1);
        assertFalse(resultDto02.getIsOk(), "意図的に1件失敗にもっていったのでステータス失敗");

        // 再試行に対してはさらに新たな試行データを作成しない
        List<SendAlertMail2024Entity> listRetry02 = sendAlertMail2024Repository.findBySaishinKbnAndSendAlertMailCode(
                DataHistoryStatusConstants.INSERT.value(), entityFailure.getSendAlertMailCode());
        assertThat(listRetry02.size()).isEqualTo(0); // 再送に対しては新たな送信データを設定しない

    }

}
