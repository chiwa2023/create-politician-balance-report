package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

import mitei.mitei.create.report.balance.politician.dto.common_check.DataHistoryStatusConstants;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageAllPlanResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;

/**
 * SaveSnsDirectMessageSendingResultFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SaveSnsDirectMessageSendingResultFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private SaveSnsDirectMessageSendingResultFactoryLogic saveSnsDirectMessageSendingResultFactoryLogic;

    /** SNSダイレクトメッセージ送信Repository(2024年) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    @Test
    @Transactional
    @Sql("y2024/save_alert_sns_message_2024.sql")
    void testPractice2024() { // NOPMD

        // TODO 2024年以外の処理は作成次第修正する

        LocalDateTime datetimeShori = LocalDateTime.of(2024, 1, 1, 0, 0, 0);

        Long id = 364L; // NOPMD
        Integer code = 360;
        SendSnsDirectMessageResultDto messageResultDto01 = new SendSnsDirectMessageResultDto();
        messageResultDto01.setSendAlertSnsMessageId(id);
        messageResultDto01.setSendAlertSnsMessageCode(code);
        messageResultDto01.setIsOk(false); // 意図的に落として次の計画を作成
        List<SendSnsDirectMessageResultDto> listResult01 = new ArrayList<>();
        listResult01.add(messageResultDto01);

        SendSnsDirectMessageAllPlanResultDto resultDto01 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult01);
        assertFalse(resultDto01.getIsOk(), "意図的に失敗して次の予定を作成1");
        assertThat(resultDto01.getFailureCount()).isEqualTo(1);
        assertThat(resultDto01.getSuccessCount()).isEqualTo(0);

        // 再送信1回目
        Integer saishin = DataHistoryStatusConstants.INSERT.value();
        List<SendAlertSnsMessage2024Entity> list01 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list01.size()).isEqualTo(1);
        SendAlertSnsMessage2024Entity entity01 = list01.get(0);
        assertThat(entity01.getSendAlertSnsMessageId()).isEqualTo(365L);
        assertThat(entity01.getTimesRetryNext()).isEqualTo(1);
        assertThat(entity01.getSendDatetime()).isEqualTo(entity01.getDatetimeTimes1());

        List<SendSnsDirectMessageResultDto> listResult02 = new ArrayList<>();
        SendSnsDirectMessageResultDto messageResultDto02 = this.createDto(entity01.getSendAlertSnsMessageId(), code);
        listResult02.add(messageResultDto02);

        SendSnsDirectMessageAllPlanResultDto resultDto02 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult02);
        assertFalse(resultDto02.getIsOk(), "意図的に失敗して次の予定を作成2");
        assertThat(resultDto02.getFailureCount()).isEqualTo(1);
        assertThat(resultDto02.getSuccessCount()).isEqualTo(0);

        // 再送信2回目
        List<SendAlertSnsMessage2024Entity> list02 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list02.size()).isEqualTo(1);
        SendAlertSnsMessage2024Entity entity02 = list02.get(0);
        assertThat(entity02.getSendAlertSnsMessageId()).isEqualTo(366L);
        assertThat(entity02.getTimesRetryNext()).isEqualTo(2);
        assertThat(entity02.getSendDatetime()).isEqualTo(entity02.getDatetimeTimes2());

        List<SendSnsDirectMessageResultDto> listResult03 = new ArrayList<>();
        SendSnsDirectMessageResultDto messageResultDto03 = this.createDto(entity02.getSendAlertSnsMessageId(), code);
        listResult03.add(messageResultDto03);

        SendSnsDirectMessageAllPlanResultDto resultDto03 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult03);
        assertFalse(resultDto03.getIsOk(), "意図的に失敗して次の予定を作成3");
        assertThat(resultDto03.getFailureCount()).isEqualTo(1);
        assertThat(resultDto03.getSuccessCount()).isEqualTo(0);

        // 再送信3回目
        List<SendAlertSnsMessage2024Entity> list03 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list03.size()).isEqualTo(1);
        SendAlertSnsMessage2024Entity entity03 = list03.get(0);
        assertThat(entity03.getSendAlertSnsMessageId()).isEqualTo(367L);
        assertThat(entity03.getTimesRetryNext()).isEqualTo(3);
        assertThat(entity03.getSendDatetime()).isEqualTo(entity02.getDatetimeTimes3());

        List<SendSnsDirectMessageResultDto> listResult04 = new ArrayList<>();
        SendSnsDirectMessageResultDto messageResultDto04 = this.createDto(entity03.getSendAlertSnsMessageId(), code);
        listResult04.add(messageResultDto04);

        SendSnsDirectMessageAllPlanResultDto resultDto04 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult04);
        assertFalse(resultDto04.getIsOk(), "意図的に失敗して次の予定を作成4");
        assertThat(resultDto04.getFailureCount()).isEqualTo(1);
        assertThat(resultDto04.getSuccessCount()).isEqualTo(0);

        // 再送信4回目
        List<SendAlertSnsMessage2024Entity> list04 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list04.size()).isEqualTo(1);
        SendAlertSnsMessage2024Entity entity04 = list04.get(0);
        assertThat(entity04.getTimesRetryNext()).isEqualTo(4);
        assertThat(entity04.getSendDatetime()).isEqualTo(entity04.getDatetimeTimes4());

        List<SendSnsDirectMessageResultDto> listResult05 = new ArrayList<>();
        SendSnsDirectMessageResultDto messageResultDto05 = this.createDto(entity04.getSendAlertSnsMessageId(), code);
        listResult05.add(messageResultDto05);

        SendSnsDirectMessageAllPlanResultDto resultDto05 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult05);
        assertFalse(resultDto05.getIsOk(), "意図的に失敗して次の予定を作成5");
        assertThat(resultDto05.getFailureCount()).isEqualTo(1);
        assertThat(resultDto05.getSuccessCount()).isEqualTo(0);

        // 再送信5回目
        List<SendAlertSnsMessage2024Entity> list05 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list05.size()).isEqualTo(1);
        SendAlertSnsMessage2024Entity entity05 = list05.get(0);
        assertThat(entity05.getTimesRetryNext()).isEqualTo(5);
        assertThat(entity05.getSendDatetime()).isEqualTo(entity05.getDatetimeTimes5());

        List<SendSnsDirectMessageResultDto> listResult06 = new ArrayList<>();
        SendSnsDirectMessageResultDto messageResultDto06 = this.createDto(entity05.getSendAlertSnsMessageId(), code);
        listResult06.add(messageResultDto06);

        SendSnsDirectMessageAllPlanResultDto resultDto06 = saveSnsDirectMessageSendingResultFactoryLogic
                .practice(datetimeShori, listResult06);
        assertFalse(resultDto06.getIsOk(), "意図的に失敗して次の予定を作成6");
        assertThat(resultDto06.getFailureCount()).isEqualTo(1);
        assertThat(resultDto06.getSuccessCount()).isEqualTo(0);

        // 再送信5回目
        List<SendAlertSnsMessage2024Entity> list06 = sendAlertSnsMessage2024Repository
                .findBySaishinKbnAndSendAlertSnsMessageCodeOrderBySendAlertSnsMessageId(saishin, code);
        assertThat(list06.size()).isEqualTo(0); // 試行を5回を繰り返したら次の予定を作成しません

    }

    private SendSnsDirectMessageResultDto createDto(final Long entityId, final Integer code) {

        SendSnsDirectMessageResultDto dto = new SendSnsDirectMessageResultDto();
        dto.setSendAlertSnsMessageId(entityId);
        dto.setSendAlertSnsMessageCode(code);
        dto.setIsOk(false); // 意図的に落として次の計画を作成

        return dto;
    }

}
