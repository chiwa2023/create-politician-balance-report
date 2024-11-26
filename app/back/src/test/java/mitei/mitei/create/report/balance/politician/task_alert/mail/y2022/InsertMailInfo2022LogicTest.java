package mitei.mitei.create.report.balance.politician.task_alert.mail.y2022;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.user.KengenKbnWorksConstants;
import mitei.mitei.create.report.balance.politician.dto.user.YakushokuKbnConstants;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.entity.mail.SendAlertMail2022Entity;
import mitei.mitei.create.report.balance.politician.repository.mail.SendAlertMail2022Repository;
import mitei.mitei.create.report.balance.politician.util.CreateTestPrivilegeDtoUtil;

/**
 * InsertMailInfo2022Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertMailInfo2022LogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private InsertMailInfo2022Logic insertMailInfo2022Logic;

    /** 送信メールテーブル */
    @Autowired
    private SendAlertMail2022Repository sendAlertMail2022Repository;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("truncate_alert_mail_2022.sql")
    void testPractice() { // NOPMD

        UserWebAccessEntity user00 = new UserWebAccessEntity();
        user00.setUserId(2011L);
        user00.setUserCode(2000);
        user00.setUserName("会計責任者 正夫");
        user00.setMailAddress("test123@test.net"); // NOPMD

        List<UserWebAccessEntity> listUser = new ArrayList<>();
        UserWebAccessEntity user01 = new UserWebAccessEntity();
        user01.setUserId(3005L);
        user01.setUserCode(3000);
        user01.setUserName("事務員 花子");
        user01.setSendSnsLogicId(321);
        user01.setMailAddress("test234@test.net");
        user01.setKengenKbn(YakushokuKbnConstants.OFFICER.value());
        listUser.add(user01);

        UserWebAccessEntity user02 = new UserWebAccessEntity();
        user02.setUserId(4005L);
        user02.setUserCode(4000);
        user02.setUserName("作業員 一郎");
        user02.setSendSnsLogicId(486);
        user02.setMailAddress("test345@test.net");
        user02.setKengenKbn(YakushokuKbnConstants.WORKER.value());
        listUser.add(user02);

        List<TaskInfoEntity> listTask = new ArrayList<>();

        TaskInfoEntity task01 = new TaskInfoEntity();
        task01.setMessageTemplate("【ユーザ名】さん　処理すべき新たなタスクが発生しました。【遷移先】にアクセスしてタスクの処理を行ってください");
        task01.setTransferPass("http://localhost:8080/dummy-page");
        task01.setParamQuery("?id=1&code=2");
        task01.setTaskInfoName("ダミー1タスク発生");
        task01.setKengenKbn(KengenKbnWorksConstants.OFFICER_UNDER);
        listTask.add(task01);

        TaskInfoEntity task02 = new TaskInfoEntity();
        task02.setMessageTemplate("【ユーザ名】さん　【遷移先】に移動してね!!");
        task02.setTransferPass("http://localhost:9080/abcde-page/3939");
        task02.setParamQuery("?id=300&code=200");
        task02.setTaskInfoName("ダミー2タスク発生");
        task02.setKengenKbn(KengenKbnWorksConstants.OFFICER_UNDER);
        listTask.add(task02);

        LocalDateTime shori = LocalDateTime.of(2022, 7, 1, 2, 0, 0);
        CheckPrivilegeDto privilegeDto = CreateTestPrivilegeDtoUtil.pracitce();

        int size = insertMailInfo2022Logic.practice(privilegeDto, shori, user00, listUser, listTask);
        assertThat(size).isEqualTo(4); // 2×2の4件

        List<SendAlertMail2022Entity> list = sendAlertMail2022Repository.findAll();
        list.sort((e1, e2) -> e1.getSendAlertMailCode() - e1.getSendAlertMailCode());

        // 1件目
        SendAlertMail2022Entity result00 = list.get(0);
        assertThat(result00.getSaishinKbn()).isEqualTo(1);
        assertThat(result00.getSendUserId()).isEqualTo(3005L);
        assertThat(result00.getSendUserCode()).isEqualTo(3000);
        assertThat(result00.getSendUserName()).isEqualTo("事務員 花子");
        assertThat(result00.getSendDatetime()).isEqualTo(shori);
        assertThat(result00.getIsRepeat()).isEqualTo(false);
        assertThat(result00.getFromMail()).isEqualTo("test123@test.net");
        assertThat(result00.getToMail()).isEqualTo("test234@test.net");
        assertThat(result00.getCcMail()).isEqualTo("");
        assertThat(result00.getBccMail()).isEqualTo("");
        assertThat(result00.getReplyToMail()).isEqualTo("test123@test.net");
        assertThat(result00.getSubjectMail()).isEqualTo("ダミー1タスク発生");
        assertThat(result00.getBodyTextMail()).isEqualTo(
                "事務員 花子さん　処理すべき新たなタスクが発生しました。http://localhost:8080/dummy-page?id=1&code=2にアクセスしてタスクの処理を行ってください");
        assertThat(result00.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(result00.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(result00.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());

        // 2件目
        SendAlertMail2022Entity result01 = list.get(1);
        assertThat(result01.getSendAlertMailCode()).isEqualTo(1 + result00.getSendAlertMailCode());
        assertThat(result01.getSendUserId()).isEqualTo(4005L);
        assertThat(result01.getSendUserCode()).isEqualTo(4000);
        assertThat(result01.getSendUserName()).isEqualTo("作業員 一郎");
        assertThat(result01.getSendDatetime()).isEqualTo(shori);
        assertThat(result01.getIsRepeat()).isEqualTo(false);
        assertThat(result01.getFromMail()).isEqualTo("test123@test.net");
        assertThat(result01.getToMail()).isEqualTo("test345@test.net");
        assertThat(result01.getCcMail()).isEqualTo("");
        assertThat(result01.getBccMail()).isEqualTo("");
        assertThat(result01.getReplyToMail()).isEqualTo("test123@test.net");
        assertThat(result01.getSubjectMail()).isEqualTo("ダミー1タスク発生");
        assertThat(result01.getBodyTextMail()).isEqualTo(
                "作業員 一郎さん　処理すべき新たなタスクが発生しました。http://localhost:8080/dummy-page?id=1&code=2にアクセスしてタスクの処理を行ってください");

        // 3件目
        SendAlertMail2022Entity result02 = list.get(2);
        assertThat(result02.getSendAlertMailCode()).isEqualTo(1 + result01.getSendAlertMailCode());
        assertThat(result02.getSendUserId()).isEqualTo(3005L);
        assertThat(result02.getSendUserCode()).isEqualTo(3000);
        assertThat(result02.getSendUserName()).isEqualTo("事務員 花子");
        assertThat(result02.getSendDatetime()).isEqualTo(shori);
        assertThat(result02.getIsRepeat()).isEqualTo(false);
        assertThat(result02.getFromMail()).isEqualTo("test123@test.net");
        assertThat(result02.getToMail()).isEqualTo("test234@test.net");
        assertThat(result02.getCcMail()).isEqualTo("");
        assertThat(result02.getBccMail()).isEqualTo("");
        assertThat(result02.getReplyToMail()).isEqualTo("test123@test.net");
        assertThat(result02.getSubjectMail()).isEqualTo("ダミー2タスク発生");
        assertThat(result02.getBodyTextMail())
                .isEqualTo("事務員 花子さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");

        // 4件目
        SendAlertMail2022Entity result03 = list.get(3);
        assertThat(result03.getSendAlertMailCode()).isEqualTo(1 + result02.getSendAlertMailCode());
        assertThat(result03.getSendUserId()).isEqualTo(4005L);
        assertThat(result03.getSendUserCode()).isEqualTo(4000);
        assertThat(result03.getSendUserName()).isEqualTo("作業員 一郎");
        assertThat(result03.getSendDatetime()).isEqualTo(shori);
        assertThat(result03.getIsRepeat()).isEqualTo(false);
        assertThat(result03.getFromMail()).isEqualTo("test123@test.net");
        assertThat(result03.getToMail()).isEqualTo("test345@test.net");
        assertThat(result03.getCcMail()).isEqualTo("");
        assertThat(result03.getBccMail()).isEqualTo("");
        assertThat(result03.getReplyToMail()).isEqualTo("test123@test.net");
        assertThat(result03.getSubjectMail()).isEqualTo("ダミー2タスク発生");
        assertThat(result03.getBodyTextMail())
                .isEqualTo("作業員 一郎さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");

    }

}
