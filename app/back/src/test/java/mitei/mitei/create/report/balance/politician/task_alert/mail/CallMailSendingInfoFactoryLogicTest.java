package mitei.mitei.create.report.balance.politician.task_alert.mail;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

/**
 * CallMailSendingInfoFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CallMailSendingInfoFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private CallMailSendingInfoFactoryLogic callMailSendingInfoFactoryLogic;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("y2024/send_alert_mail_2024.sql")
    void testPractice() {

        // 運用上はシステム日付だが、テスト用の日付(テストデータのうち2027年データは除外されて抽出される、というテストを入れているため)
        LocalDateTime localDateTime = LocalDateTime.of(2024, 11, 1, 0, 0, 0);

        SendMailCapsuleDto capsuleDto = callMailSendingInfoFactoryLogic.practice(localDateTime);

        // 2024年をしているので2024年で取得した結果と全く同じ結果が取得できる
        // TODO その他の年については作成次第追加修正する
        List<MailDataDto> list = capsuleDto.getListMailData();

        assertThat(list.size()).isEqualTo(4); // 8件のうち、2件は最新でない、2件は実施時刻より後予定

        MailDataDto mailDataDto00 = list.get(0);
        assertThat(mailDataDto00.getSendAlertMailId()).isEqualTo(130);
        MailDataDto mailDataDto01 = list.get(1);
        assertThat(mailDataDto01.getSendAlertMailId()).isEqualTo(131);
        MailDataDto mailDataDto02 = list.get(2);
        assertThat(mailDataDto02.getSendAlertMailId()).isEqualTo(136);
        MailDataDto mailDataDto03 = list.get(3);
        assertThat(mailDataDto03.getSendAlertMailId()).isEqualTo(137);

        SimpleMailMessage mailMessage = mailDataDto00.getSimpleMailMessage();

        assertThat(mailMessage.getFrom()).isEqualTo("testA@test.net");
        assertThat(mailMessage.getTo()[0]).isEqualTo("testB@test.net");
        assertThat(mailMessage.getCc()[0]).isEqualTo("testC@test.net");
        assertThat(mailMessage.getBcc()[0]).isEqualTo("testD@test.net");
        assertThat(mailMessage.getReplyTo()).isEqualTo("testE@test.net");
        assertThat(mailMessage.getSubject()).isEqualTo("メールタイトル1");
        assertThat(mailMessage.getText()).isEqualTo("メール本文1");

    }

    @Test
    @Transactional
    @Sql("y2022/send_alert_mail_2022.sql")
    void testPractice2022() {

        // 運用上はシステム日付だが、テスト用の日付(テストデータのうち2027年データは除外されて抽出される、というテストを入れているため)
        LocalDateTime localDateTime = LocalDateTime.of(2022, 11, 1, 0, 0, 0);

        SendMailCapsuleDto capsuleDto = callMailSendingInfoFactoryLogic.practice(localDateTime);

        // 2022年をしているので2022年で取得した結果と全く同じ結果が取得できる
        // TODO その他の年については作成次第追加修正する
        List<MailDataDto> list = capsuleDto.getListMailData();

        assertThat(list.size()).isEqualTo(4); // 8件のうち、2件は最新でない、2件は実施時刻より後予定

        MailDataDto mailDataDto00 = list.get(0);
        assertThat(mailDataDto00.getSendAlertMailId()).isEqualTo(130);
        MailDataDto mailDataDto01 = list.get(1);
        assertThat(mailDataDto01.getSendAlertMailId()).isEqualTo(131);
        MailDataDto mailDataDto02 = list.get(2);
        assertThat(mailDataDto02.getSendAlertMailId()).isEqualTo(136);
        MailDataDto mailDataDto03 = list.get(3);
        assertThat(mailDataDto03.getSendAlertMailId()).isEqualTo(137);

        SimpleMailMessage mailMessage = mailDataDto00.getSimpleMailMessage();

        assertThat(mailMessage.getFrom()).isEqualTo("testA@test.net");
        assertThat(mailMessage.getTo()[0]).isEqualTo("testB@test.net");
        assertThat(mailMessage.getCc()[0]).isEqualTo("testC@test.net");
        assertThat(mailMessage.getBcc()[0]).isEqualTo("testD@test.net");
        assertThat(mailMessage.getReplyTo()).isEqualTo("testE@test.net");
        assertThat(mailMessage.getSubject()).isEqualTo("メールタイトル1");
        assertThat(mailMessage.getText()).isEqualTo("メール本文1");

    }

}
