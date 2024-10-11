package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.mock.sample1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import mitei.mitei.create.report.balance.politician.task_alert.sns.SendSnsDirectMessageResultDto;
import mitei.mitei.create.report.balance.politician.task_alert.sns.SnsDirectMessageDto;

/**
 * MockSendSnsDirectMessageSample1Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class MockSendSnsDirectMessageSample1LogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private MockSendSnsDirectMessageSample1Logic mockSendSnsDirectMessageSample1Logic;

    @Test
    @Transactional
    @Sql("sns_dm_setting_mock_sample1.sql")
    void testPractice() {

        // 設定情報が存在しない場合は失敗
        SnsDirectMessageDto messageDto01 = new SnsDirectMessageDto();

        // 権限Dto
        CheckPrivilegeDto privilegeDto01 = new CheckPrivilegeDto();
        privilegeDto01.setIsResult(true);
        privilegeDto01.setIsRaiseExcception(false);
        privilegeDto01.setLoginUserId(999L);
        privilegeDto01.setLoginUserCode(899);
        privilegeDto01.setLoginUserName("ユーザ名");
        privilegeDto01.setPoliticalOrganizationId(2345L);
        privilegeDto01.setPoliticalOrganizationCode(2333);
        privilegeDto01.setPoliticalOrganizationName("サンプル政治団体");
        messageDto01.setCheckPrivilegeDto(privilegeDto01);
        SendSnsDirectMessageResultDto resultDto01 = mockSendSnsDirectMessageSample1Logic.practice(messageDto01);
        assertFalse(resultDto01.getIsOk(), "設定情報が存在しない場合は失敗");

        // 失敗を設定したら失敗が返ってくる
        SnsDirectMessageDto messageDto02 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto02 = new CheckPrivilegeDto();
        privilegeDto02.setIsResult(true);
        privilegeDto02.setIsRaiseExcception(true); // 失敗設定
        privilegeDto02.setLoginUserId(999L);
        privilegeDto02.setLoginUserCode(901);
        privilegeDto02.setLoginUserName("ユーザ名");
        privilegeDto02.setPoliticalOrganizationId(2345L);
        privilegeDto02.setPoliticalOrganizationCode(2333);
        privilegeDto02.setPoliticalOrganizationName("サンプル政治団体");
        messageDto02.setCheckPrivilegeDto(privilegeDto02);
        SendSnsDirectMessageResultDto resultDto02 = mockSendSnsDirectMessageSample1Logic.practice(messageDto02);
        assertFalse(resultDto02.getIsOk(), "Mockテスト用、失敗を設定したら失敗が返る");

        // 成功を設定したら成功が返ってくる
        SnsDirectMessageDto messageDto03 = new SnsDirectMessageDto();
        CheckPrivilegeDto privilegeDto03 = new CheckPrivilegeDto();
        privilegeDto03.setIsResult(true);
        privilegeDto03.setIsRaiseExcception(false); // 成功設定
        privilegeDto03.setLoginUserId(999L);
        privilegeDto03.setLoginUserCode(901);
        privilegeDto03.setLoginUserName("ユーザ名");
        privilegeDto03.setPoliticalOrganizationId(2345L);
        privilegeDto03.setPoliticalOrganizationCode(2333);
        privilegeDto03.setPoliticalOrganizationName("サンプル政治団体");
        messageDto03.setCheckPrivilegeDto(privilegeDto03);
        SendSnsDirectMessageResultDto resultDto03 = mockSendSnsDirectMessageSample1Logic.practice(messageDto03);
        assertTrue(resultDto03.getIsOk(), "Mockテスト用、成功を設定したら成功が返る");

    }

}
