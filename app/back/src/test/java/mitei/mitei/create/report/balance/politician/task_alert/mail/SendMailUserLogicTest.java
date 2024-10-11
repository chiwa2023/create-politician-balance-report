package mitei.mitei.create.report.balance.politician.task_alert.mail;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * SendMailUserLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class SendMailUserLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private SendMailUserLogic sendMailUserLogic;

    @Test
    void test() {

        // 正常終了
        SendMailCapsuleDto capsuleDto01 = new SendMailCapsuleDto();
        capsuleDto01.getPosFailure().add(999);
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto01);
        capsuleDto01.getListMailData().add(this.createData(0));

        SendMaileResultDto resultDto01 = sendMailUserLogic.practice(capsuleDto01);
        assertTrue(resultDto01.getIsOk(), "正常終了");

        // TODO 本番環境での意図的な例外の起こし方が不明

        fail("Not yet implemented");
    }

    private MailDataDto createData(final int index) {

        MailDataDto mailDataDto = new MailDataDto();

        // 権限Dto
        CheckPrivilegeDto checkPrivilegeDto = new CheckPrivilegeDto();
        checkPrivilegeDto.setIsResult(true);
        checkPrivilegeDto.setIsRaiseExcception(false);
        checkPrivilegeDto.setLoginUserId(1000L + index);
        checkPrivilegeDto.setLoginUserCode(900 + index);
        checkPrivilegeDto.setLoginUserName("ユーザ名" + index);
        checkPrivilegeDto.setPoliticalOrganizationId(2345L);
        checkPrivilegeDto.setPoliticalOrganizationCode(2333);
        checkPrivilegeDto.setPoliticalOrganizationName("サンプル政治団体");
        mailDataDto.setCheckPrivilegeDto(checkPrivilegeDto);

        // メールメッセージ
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("testA" + index + "t@test.jp"); // 送信元メールアドレス
        mailMessage.setTo("testB" + index + "@test.jp");
        mailMessage.setCc("testC" + index + "@test.jp");
        mailMessage.setBcc("testD" + index + "@test.jp");
        mailMessage.setSubject("テスト用表題");
        mailMessage.setText("ローカルから送る用テストメッセージ");
        mailMessage.setReplyTo("テスト用表題" + index);

        mailDataDto.setSimpleMailMessage(mailMessage);

        return mailDataDto;
    }

}
