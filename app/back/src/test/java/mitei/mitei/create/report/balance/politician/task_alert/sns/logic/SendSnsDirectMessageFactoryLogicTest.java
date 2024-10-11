package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * SendSnsDirectMessageFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SendSnsDirectMessageFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private SendSnsDirectMessageFactoryLogic sendSnsDirectMessageFactoryLogic;

    @Test
    @Transactional
    @Sql({ "mock/sample1/sns_dm_setting_mock_sample1.sql", "mock/sample2/sns_dm_setting_mock_sample2.sql" })
    void testPractice() {

        SendSnsDirectMessageCapsuleDto capsuleDto01 = new SendSnsDirectMessageCapsuleDto();
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto01);

        List<SnsDirectMessageDto> listSend = new ArrayList<>();

        /* SNS指定をしない */
        SnsDirectMessageDto messageDto00 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto00 = new CheckPrivilegeDto();
        messageDto00.setCheckPrivilegeDto(privilegeDto00);
        messageDto00.setSnsLogicId(0); // もともとSNS登録がない

        /* SNS-Sample1 */
        SnsDirectMessageDto messageDto01 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto01 = new CheckPrivilegeDto();
        privilegeDto01.setLoginUserCode(901); // SNS設定は取れる体
        privilegeDto01.setIsRaiseExcception(false); // 正常送信を仮定
        messageDto01.setCheckPrivilegeDto(privilegeDto01);
        messageDto01.setSnsLogicId(1); // SNS(Sample1-mock)にメッセージ送信

        /* SNS-Sample2 */
        SnsDirectMessageDto messageDto02 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto02 = new CheckPrivilegeDto();
        privilegeDto02.setLoginUserCode(901); // SNS設定は取れる体
        privilegeDto02.setIsRaiseExcception(true); // 異常送信を仮定
        messageDto02.setCheckPrivilegeDto(privilegeDto02);
        messageDto02.setSnsLogicId(2); // SNS(Sample2-mock)にメッセージ送信

        /* 誤ったSNS指定をしている(実装ミス) */
        SnsDirectMessageDto messageDto03 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto03 = new CheckPrivilegeDto();
        messageDto03.setCheckPrivilegeDto(privilegeDto03);
        messageDto03.setSnsLogicId(325); // 誤ったSNS指定をしている

        listSend.add(messageDto00);
        listSend.add(messageDto01);
        listSend.add(messageDto02);
        listSend.add(messageDto03);
        capsuleDto01.setListSnsMessageData(listSend);

        List<SendSnsDirectMessageResultDto> list01 = sendSnsDirectMessageFactoryLogic.practice(capsuleDto01);

        // 設定した送信予定数の分だけ送信結果が返ってきます
        assertThat(list01.size()).isEqualTo(listSend.size());

        SendSnsDirectMessageResultDto resultDto00 = list01.get(0);
        assertTrue(resultDto00.getIsOk(), "送信していませんが、送信できた扱いです(再送信処理をしないので)");
        SendSnsDirectMessageResultDto resultDto01 = list01.get(1);
        assertTrue(resultDto01.getIsOk(), "正常送信できました");
        SendSnsDirectMessageResultDto resultDto02 = list01.get(2);
        assertFalse(resultDto02.getIsOk(), "送信異常です(再送信処理対象)");
        SendSnsDirectMessageResultDto resultDto03 = list01.get(3);
        assertFalse(resultDto03.getIsOk(), "SNS指定ミスです(再送信処理する)");

    }

}
