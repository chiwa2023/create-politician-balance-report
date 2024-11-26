package mitei.mitei.create.report.balance.politician.task_alert.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Tag;
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

import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailAllPlanResultDto;

/**
 * CallTaskUserAlertMailService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CallTaskUserAlertMailServiceTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private CallTaskUserAlertMailService callTaskUserAlertMailService;

    @Test
    @Tag("ExternalService")
    @Transactional
    @Sql("../mail/y2024/send_alert_mail_2024.sql")
    void testPractice() {

        // システム日付の年テーブルの処理
        LocalDateTime shori = LocalDateTime.of(2024, 11, 1, 0, 0, 0);

        SendMailAllPlanResultDto resultDto = callTaskUserAlertMailService.practice(shori);

        assertThat(resultDto.getSuccessCount()).isEqualTo(4);
        assertThat(resultDto.getFailureCount()).isEqualTo(0);
        assertTrue(resultDto.getIsOk(), "テスト用に別途失敗にさせる手法が入り込む余地はないので、すべて成功");
    }

    @Test
    @Transactional
    @Sql("../mail/y2024/send_alert_mail_2024.sql")
    void testPracticeEmpty() {

        // システム日付の年テーブルの処理
        // 1件も送信しない
        LocalDateTime shori = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        SendMailAllPlanResultDto resultDto = callTaskUserAlertMailService.practice(shori);

        assertThat(resultDto.getSuccessCount()).isEqualTo(0); // 成功0件
        assertThat(resultDto.getFailureCount()).isEqualTo(0); // 失敗0件
        assertTrue(resultDto.getIsOk(), "送信失敗はしていないので消極的成功");
    }
}
