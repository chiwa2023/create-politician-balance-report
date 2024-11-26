package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

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

import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;

/**
 * CallSnsDirectMessageSendingInfoFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CallSnsDirectMessageSendingInfoFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private CallSnsDirectMessageSendingInfoFactoryLogic callSnsDirectMessageSendingInfoFactoryLogic;

    // TODO その他の年については追加次第テストを追加する

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("y2024/send_alert_sns_message_2024.sql")
    void testPractice2024() {

        // 本来はシステム日付の年テーブルの処理
        LocalDateTime shori = LocalDateTime.of(2024, 11, 1, 0, 0, 0);

        SendSnsDirectMessageCapsuleDto capsuleDto = callSnsDirectMessageSendingInfoFactoryLogic.practice(shori);

        List<SnsDirectMessageDto> list = capsuleDto.getListSnsMessageData();

        assertThat(list.size()).isEqualTo(4); // 4件データが取れる

        SnsDirectMessageDto messageDto00 = list.get(0);
        SnsDirectMessageDto messageDto01 = list.get(1);
        SnsDirectMessageDto messageDto02 = list.get(2);
        SnsDirectMessageDto messageDto03 = list.get(3);

        assertThat(messageDto00.getSendAlertSnsMessageId()).isEqualTo(364L);
        assertThat(messageDto01.getSendAlertSnsMessageId()).isEqualTo(452L);
        assertThat(messageDto02.getSendAlertSnsMessageId()).isEqualTo(739L);
        assertThat(messageDto03.getSendAlertSnsMessageId()).isEqualTo(762L);

        assertThat(messageDto00.getSendAlertSnsMessageCode()).isEqualTo(360);
        assertThat(messageDto00.getSnsLogicId()).isEqualTo(1);
        assertThat(messageDto00.getBodyMessage()).isEqualTo("ダイレクトメッセージ送信本文");
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserId()).isEqualTo(245L);
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserCode()).isEqualTo(240);
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserName()).isEqualTo("送信ユーザ");

    }

    @Test
    @Transactional
    @Sql("y2022/send_alert_sns_message_2022.sql")
    void testPractice2022() {

        // 本来はシステム日付の年テーブルの処理
        LocalDateTime shori = LocalDateTime.of(2022, 11, 1, 0, 0, 0);

        SendSnsDirectMessageCapsuleDto capsuleDto = callSnsDirectMessageSendingInfoFactoryLogic.practice(shori);

        List<SnsDirectMessageDto> list = capsuleDto.getListSnsMessageData();

        assertThat(list.size()).isEqualTo(4); // 4件データが取れる

        SnsDirectMessageDto messageDto00 = list.get(0);
        SnsDirectMessageDto messageDto01 = list.get(1);
        SnsDirectMessageDto messageDto02 = list.get(2);
        SnsDirectMessageDto messageDto03 = list.get(3);

        assertThat(messageDto00.getSendAlertSnsMessageId()).isEqualTo(364L);
        assertThat(messageDto01.getSendAlertSnsMessageId()).isEqualTo(452L);
        assertThat(messageDto02.getSendAlertSnsMessageId()).isEqualTo(739L);
        assertThat(messageDto03.getSendAlertSnsMessageId()).isEqualTo(762L);

        assertThat(messageDto00.getSendAlertSnsMessageCode()).isEqualTo(360);
        assertThat(messageDto00.getSnsLogicId()).isEqualTo(1);
        assertThat(messageDto00.getBodyMessage()).isEqualTo("ダイレクトメッセージ送信本文");
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserId()).isEqualTo(245L);
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserCode()).isEqualTo(240);
        assertThat(messageDto00.getCheckPrivilegeDto().getLoginUserName()).isEqualTo("送信ユーザ");

    }

    // Test追加位置
}
