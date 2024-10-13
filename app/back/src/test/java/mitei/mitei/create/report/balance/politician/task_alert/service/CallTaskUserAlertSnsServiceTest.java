package mitei.mitei.create.report.balance.politician.task_alert.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageAllPlanResultDto;

/**
 * CallTaskUserAlertSnsService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CallTaskUserAlertSnsServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private CallTaskUserAlertSnsService callTaskUserAlertSnsService;

    @Test
    @Transactional
    @Sql({ "service_alert_sns_message_2024.sql", "../sns/logic/mock/sample1/sns_dm_setting_mock_sample1.sql",
            "../sns/logic/mock/sample2/sns_dm_setting_mock_sample2.sql" })
    void testPractice() { // NOPMD

        // 送信予定で存在しないSNS(送信Logic)を指定すると落とせるので、
        // その仕組みを活用する。ただし途中で送信できるようになるわけではない
        // 送信が成功した場合のテストは1回目で実施されているのでテスト済

        /*
         * 1回目
         */
        // 第1波
        LocalDateTime datetimeShori01 = LocalDateTime.of(2024, 7, 1, 2, 15, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto01 = callTaskUserAlertSnsService.practice(datetimeShori01);
        assertThat(resultDto01.getSuccessCount()).isEqualTo(4);
        assertThat(resultDto01.getFailureCount()).isEqualTo(2);
        assertFalse(resultDto01.getIsOk(), "6件取得して2件失敗");

        // 第2波
        LocalDateTime datetimeShori11 = LocalDateTime.of(2024, 7, 1, 2, 45, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto11 = callTaskUserAlertSnsService.practice(datetimeShori11);
        assertThat(resultDto11.getSuccessCount()).isEqualTo(4);
        assertThat(resultDto11.getFailureCount()).isEqualTo(23);
        assertFalse(resultDto11.getIsOk(), "27件取得して23件失敗");

        /*
         * 2回目
         */
        // 第1波
        LocalDateTime datetimeShori02 = LocalDateTime.of(2024, 7, 1, 5, 15, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto02 = callTaskUserAlertSnsService.practice(datetimeShori02);
        assertThat(resultDto02.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto02.getFailureCount()).isEqualTo(2);
        assertFalse(resultDto02.getIsOk(), "2件取得して2件失敗"); // NOPMD

        // 第2波
        LocalDateTime datetimeShori12 = LocalDateTime.of(2024, 7, 1, 5, 45, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto12 = callTaskUserAlertSnsService.practice(datetimeShori12);
        assertThat(resultDto12.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto12.getFailureCount()).isEqualTo(23);
        assertFalse(resultDto12.getIsOk(), "23件取得して23件失敗"); // NOPMD

        /*
         * 3回目
         */
        // 第1波と2波が合計している
        // 定期送信ができなくなり、予定実施をスキップした場合、今ある予定をすべて流そうとする。このときの予定の時刻の変更はない
        // TODO 長期間送信処理ができなかった場合に、リセット処理を追加するかは検討する
        // こういうことも起きうる、という頭の体操
        LocalDateTime datetimeShori33 = LocalDateTime.of(2024, 7, 1, 9, 0, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto33 = callTaskUserAlertSnsService.practice(datetimeShori33);
        assertThat(resultDto33.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto33.getFailureCount()).isEqualTo(25);
        assertFalse(resultDto33.getIsOk(), "25件取得して25件失敗");

        /*
         * 4回目
         */
        // 2回目と３回の間で送信予定が実行できなかったが、3回目の処理を完全に実施できた場合、
        // 予定を再度再開しても、最初に立てた予定に沿って第1波と2波に分かれて実施される(予定時間の変更はないから)
        // 第1波
        LocalDateTime datetimeShori04 = LocalDateTime.of(2024, 7, 1, 14, 15, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto04 = callTaskUserAlertSnsService.practice(datetimeShori04);
        assertThat(resultDto04.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto04.getFailureCount()).isEqualTo(2);
        assertFalse(resultDto04.getIsOk(), "2件取得して2件失敗"); // NOPMD

        // 第2波
        LocalDateTime datetimeShori14 = LocalDateTime.of(2024, 7, 1, 14, 45, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto14 = callTaskUserAlertSnsService.practice(datetimeShori14);
        assertThat(resultDto14.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto14.getFailureCount()).isEqualTo(23);
        assertFalse(resultDto14.getIsOk(), "23件取得して23件失敗"); // NOPMD

        /*
         * 5回目
         */
        // 第1波
        LocalDateTime datetimeShori05 = LocalDateTime.of(2024, 7, 2, 2, 15, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto05 = callTaskUserAlertSnsService.practice(datetimeShori05);
        assertThat(resultDto05.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto05.getFailureCount()).isEqualTo(2);
        assertFalse(resultDto05.getIsOk(), "2件取得して2件失敗"); // NOPMD

        // 第2波
        LocalDateTime datetimeShori15 = LocalDateTime.of(2024, 7, 2, 2, 45, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto15 = callTaskUserAlertSnsService.practice(datetimeShori15);
        assertThat(resultDto15.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto15.getFailureCount()).isEqualTo(23);
        assertFalse(resultDto15.getIsOk(), "23件取得して23件失敗"); // NOPMD

        /*
         * 6回目
         */
        // 第1波
        LocalDateTime datetimeShori06 = LocalDateTime.of(2024, 7, 3, 2, 15, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto06 = callTaskUserAlertSnsService.practice(datetimeShori06);
        assertThat(resultDto06.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto06.getFailureCount()).isEqualTo(2);
        assertFalse(resultDto06.getIsOk(), "2件取得して2件失敗"); // NOPMD

        // 第2波
        LocalDateTime datetimeShori16 = LocalDateTime.of(2024, 7, 3, 2, 45, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto16 = callTaskUserAlertSnsService.practice(datetimeShori16);
        assertThat(resultDto16.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto16.getFailureCount()).isEqualTo(23);
        assertFalse(resultDto16.getIsOk(), "23件取得して23件失敗"); // NOPMD

        /*
         * 7回目
         */
        // すべての試行回数を終えたのですべての予定が存在しない
        LocalDateTime datetimeShori77 = LocalDateTime.of(2024, 7, 4, 2, 0, 0);
        SendSnsDirectMessageAllPlanResultDto resultDto77 = callTaskUserAlertSnsService.practice(datetimeShori77);
        assertThat(resultDto77.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto77.getFailureCount()).isEqualTo(0);
        assertTrue(resultDto77.getIsOk(), "0件取得して0件失敗0件成功");

    }

    @Test
    @Transactional
    @Sql({ "service_alert_sns_message_2024.sql", "../sns/logic/mock/sample1/sns_dm_setting_mock_sample1.sql",
            "../sns/logic/mock/sample2/sns_dm_setting_mock_sample2.sql" })
    void testPracticeEmpty() {

        LocalDateTime datetimeShori = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        SendSnsDirectMessageAllPlanResultDto resultDto = callTaskUserAlertSnsService.practice(datetimeShori);

        // 処理対象は1件もありません
        assertThat(resultDto.getSuccessCount()).isEqualTo(0); // 成功0件
        assertThat(resultDto.getFailureCount()).isEqualTo(0); // 失敗0件
        assertTrue(resultDto.getIsOk(), "送信失敗はしていないので消極的成功");

    }

}
