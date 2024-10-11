package mitei.mitei.create.report.balance.politician.task_alert.mail.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
import mitei.mitei.create.report.balance.politician.task_alert.mail.MailDataDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMailCapsuleDto;
import mitei.mitei.create.report.balance.politician.task_alert.mail.SendMaileResultDto;
import mitei.mitei.create.report.balance.politician.util.CreateCommonCheckDtoTestOnlyUtil;

/**
 * MockSendMailUserLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class MockSendMailUserLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private MockSendMailUserLogic mockSendMailUserLogic;

    @Test
    void testPractice() {
        // NOTE 必要なsmtpサーバを動作させてからテストする

        // 正常終了
        SendMailCapsuleDto capsuleDto01 = new SendMailCapsuleDto();
        capsuleDto01.getPosFailure().add(999);
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto01);
        capsuleDto01.getListMailData().add(this.createData(0));

        SendMaileResultDto resultDto01 = mockSendMailUserLogic.practice(capsuleDto01);
        assertTrue(resultDto01.getIsOk(), "正常終了");

        // 認証に失敗した場合は全員が失敗で返ってくる
        SendMailCapsuleDto capsuleDto02 = new SendMailCapsuleDto();
        capsuleDto02.getPosFailure().add(-999); // 全員失敗
        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto02);
        capsuleDto02.getListMailData().add(this.createData(0));
        capsuleDto02.getListMailData().add(this.createData(1));

        SendMaileResultDto resultDto02 = mockSendMailUserLogic.practice(capsuleDto02);
        assertFalse(resultDto02.getIsOk(), "異常終了");
        // 2人の挿入したデータ
        List<MailDataDto> listFailure02 = resultDto02.getListFailure();
        assertThat(listFailure02.size()).isEqualTo(2);
        assertThat(listFailure02.get(0).getCheckPrivilegeDto().getLoginUserId()).isEqualTo(1000L);
        assertThat(listFailure02.get(1).getCheckPrivilegeDto().getLoginUserId()).isEqualTo(1001L);

        // その他の部分15人のうち3人で失敗
        SendMailCapsuleDto capsuleDto03 = new SendMailCapsuleDto();

        capsuleDto03.getPosFailure().add(4); // メッセージ作成失敗
        capsuleDto03.getPosFailure().add(8); // 送信作成失敗
        capsuleDto03.getPosFailure().add(9); // その他の失敗

        CreateCommonCheckDtoTestOnlyUtil.practice(capsuleDto03);
        capsuleDto03.getListMailData().add(this.createData(0));
        capsuleDto03.getListMailData().add(this.createData(1));
        capsuleDto03.getListMailData().add(this.createData(2));
        capsuleDto03.getListMailData().add(this.createData(3));
        capsuleDto03.getListMailData().add(this.createData(4));
        capsuleDto03.getListMailData().add(this.createData(5));
        capsuleDto03.getListMailData().add(this.createData(6));
        capsuleDto03.getListMailData().add(this.createData(7));
        capsuleDto03.getListMailData().add(this.createData(8));
        capsuleDto03.getListMailData().add(this.createData(9));
        capsuleDto03.getListMailData().add(this.createData(10));
        capsuleDto03.getListMailData().add(this.createData(11));
        capsuleDto03.getListMailData().add(this.createData(12));
        capsuleDto03.getListMailData().add(this.createData(13));
        capsuleDto03.getListMailData().add(this.createData(14));
        capsuleDto03.getListMailData().add(this.createData(15));

        SendMaileResultDto resultDto03 = mockSendMailUserLogic.practice(capsuleDto03);
        assertFalse(resultDto03.getIsOk(), "異常終了");
        // 3人の失敗したデータ
        List<MailDataDto> listFailure03 = resultDto03.getListFailure();
        assertThat(listFailure03.size()).isEqualTo(3);
        assertThat(listFailure03.get(0).getCheckPrivilegeDto().getLoginUserId()).isEqualTo(1004L);
        assertThat(listFailure03.get(1).getCheckPrivilegeDto().getLoginUserId()).isEqualTo(1008L);
        assertThat(listFailure03.get(2).getCheckPrivilegeDto().getLoginUserId()).isEqualTo(1009L);

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
        mailMessage.setFrom("testA" + index + "a@test.jp"); // 送信元メールアドレス
        mailMessage.setTo("testB" + index + "b@test.jp");
        mailMessage.setCc("testC" + index + "c@test.jp");
        mailMessage.setBcc("testD" + index + "d@test.jp");
        mailMessage.setSubject("テスト用表題");
        mailMessage.setText("ローカルから送る用テストメッセージ");
        mailMessage.setReplyTo("testE" + index + "e@test.jp");

        mailDataDto.setSimpleMailMessage(mailMessage);

        return mailDataDto;
    }
}
