package mitei.mitei.create.report.balance.politician.task_alert.sns.logic;

import static org.assertj.core.api.Assertions.assertThat;

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

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.UserWebAccessEntity;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2022Entity;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2022Repository;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.util.CreateTestPrivilegeDtoUtil;

/**
 * InsertSnsDirectMessageSendingInfoFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertSnsDirectMessageSendingInfoFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private InsertSnsDirectMessageSendingInfoFactoryLogic insertSnsDirectMessageSendingInfoFactoryLogic;

    /** レポジトリ */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    /** レポジトリ */
    @Autowired
    private SendAlertSnsMessage2022Repository sendAlertSnsMessage2022Repository;

    @Test
    @Transactional
    @Sql("y2024/truncate_alert_sns_message_2024.sql")
    void testPractice() { // NOPMD

        // TODO その他の報告年処理テストは自動は随時追加する

        List<UserWebAccessEntity> listUser = new ArrayList<>();
        UserWebAccessEntity user01 = new UserWebAccessEntity();
        user01.setUserId(3005L);
        user01.setUserCode(3000);
        user01.setUserName("事務員 花子");
        user01.setSendSnsLogicId(321);
        listUser.add(user01);

        UserWebAccessEntity user02 = new UserWebAccessEntity();
        user02.setUserId(4005L);
        user02.setUserCode(4000);
        user02.setUserName("作業員 一郎");
        user02.setSendSnsLogicId(486);
        listUser.add(user02);

        List<TaskInfoEntity> listTask = new ArrayList<>();

        TaskInfoEntity task01 = new TaskInfoEntity();
        task01.setMessageTemplate("【ユーザ名】さん　処理すべき新たなタスクが発生しました。【遷移先】にアクセスしてタスクの処理を行ってください");
        task01.setTransferPass("http://localhost:8080/dummy-page");
        task01.setParamQuery("?id=1&code=2");
        listTask.add(task01);

        TaskInfoEntity task02 = new TaskInfoEntity();
        task02.setMessageTemplate("【ユーザ名】さん　【遷移先】に移動してね!!");
        task02.setTransferPass("http://localhost:9080/abcde-page/3939");
        task02.setParamQuery("?id=300&code=200");
        listTask.add(task02);

        LocalDateTime shori = LocalDateTime.of(2024, 7, 1, 2, 0, 0);
        CheckPrivilegeDto privilegeDto = CreateTestPrivilegeDtoUtil.pracitce();

        int size = insertSnsDirectMessageSendingInfoFactoryLogic.practice(privilegeDto, listUser, shori, listTask);
        assertThat(size).isEqualTo(4); // 2×2の4件

        List<SendAlertSnsMessage2024Entity> list = sendAlertSnsMessage2024Repository.findAll();
        list.sort((e1, e2) -> e1.getSendAlertSnsMessageCode() - e1.getSendAlertSnsMessageCode());

        // 1件目
        SendAlertSnsMessage2024Entity result00 = list.get(0);
        result00.getSendAlertSnsMessageId();
        result00.getSendAlertSnsMessageCode();
        assertThat(result00.getSaishinKbn()).isEqualTo(1);
        assertThat(result00.getSendUserId()).isEqualTo(3005L);
        assertThat(result00.getSendUserCode()).isEqualTo(3000);
        assertThat(result00.getSendUserName()).isEqualTo("事務員 花子");
        assertThat(result00.getSendDatetime()).isEqualTo(shori);
        assertThat(result00.getSnsLogicId()).isEqualTo(321);
        assertThat(result00.getTimesRetryNext()).isEqualTo(0);
        assertThat(result00.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(result00.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(result00.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(result00.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(result00.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(result00.getBodyText()).isEqualTo(
                "事務員 花子さん　処理すべき新たなタスクが発生しました。http://localhost:8080/dummy-page?id=1&code=2にアクセスしてタスクの処理を行ってください");
        assertThat(result00.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(result00.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(result00.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());
        // assertThat(result00.getInsertTimestamp()).isEqualTo(1);

        // 2件目
        SendAlertSnsMessage2024Entity result01 = list.get(1);
        assertThat(result01.getSendAlertSnsMessageCode()).isEqualTo(1 + result00.getSendAlertSnsMessageCode());
        assertThat(result01.getSaishinKbn()).isEqualTo(1);
        assertThat(result01.getSendUserId()).isEqualTo(4005L);
        assertThat(result01.getSendUserCode()).isEqualTo(4000);
        assertThat(result01.getSendUserName()).isEqualTo("作業員 一郎");
        assertThat(result01.getSendDatetime()).isEqualTo(shori);
        assertThat(result01.getSnsLogicId()).isEqualTo(486);
        assertThat(result01.getTimesRetryNext()).isEqualTo(0);
        assertThat(result01.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(result01.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(result01.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(result01.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(result01.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(result01.getBodyText()).isEqualTo(
                "作業員 一郎さん　処理すべき新たなタスクが発生しました。http://localhost:8080/dummy-page?id=1&code=2にアクセスしてタスクの処理を行ってください");

        // 3件目
        SendAlertSnsMessage2024Entity result02 = list.get(2);
        assertThat(result02.getSendAlertSnsMessageCode()).isEqualTo(1 + result01.getSendAlertSnsMessageCode());
        assertThat(result02.getSaishinKbn()).isEqualTo(1);
        assertThat(result02.getSendUserId()).isEqualTo(3005L);
        assertThat(result02.getSendUserCode()).isEqualTo(3000);
        assertThat(result02.getSendUserName()).isEqualTo("事務員 花子");
        assertThat(result02.getSendDatetime()).isEqualTo(shori);
        assertThat(result02.getSnsLogicId()).isEqualTo(321);
        assertThat(result02.getTimesRetryNext()).isEqualTo(0);
        assertThat(result02.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(result02.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(result02.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(result02.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(result02.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(result02.getBodyText())
                .isEqualTo("事務員 花子さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");

        // 4件目
        SendAlertSnsMessage2024Entity result03 = list.get(3);
        assertThat(result03.getSendAlertSnsMessageCode()).isEqualTo(1 + result02.getSendAlertSnsMessageCode());
        assertThat(result03.getSaishinKbn()).isEqualTo(1);
        assertThat(result03.getSendUserId()).isEqualTo(4005L);
        assertThat(result03.getSendUserCode()).isEqualTo(4000);
        assertThat(result03.getSendUserName()).isEqualTo("作業員 一郎");
        assertThat(result03.getSendDatetime()).isEqualTo(shori);
        assertThat(result03.getSnsLogicId()).isEqualTo(486);
        assertThat(result03.getTimesRetryNext()).isEqualTo(0);
        assertThat(result03.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(result03.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(result03.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(result03.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(result03.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(result03.getBodyText())
                .isEqualTo("作業員 一郎さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");

    }

    @Test
    @Transactional
    @Sql("y2022/truncate_alert_sns_message_2022.sql")
    void testPractice2022() { // NOPMD

        List<UserWebAccessEntity> listUser = new ArrayList<>();
        UserWebAccessEntity user01 = new UserWebAccessEntity();
        user01.setUserId(3005L);
        user01.setUserCode(3000);
        user01.setUserName("事務員 花子");
        user01.setSendSnsLogicId(321);
        listUser.add(user01);

        UserWebAccessEntity user02 = new UserWebAccessEntity();
        user02.setUserId(4005L);
        user02.setUserCode(4000);
        user02.setUserName("作業員 一郎");
        user02.setSendSnsLogicId(486);
        listUser.add(user02);

        List<TaskInfoEntity> listTask = new ArrayList<>();

        TaskInfoEntity task01 = new TaskInfoEntity();
        task01.setMessageTemplate("【ユーザ名】さん　処理すべき新たなタスクが発生しました。【遷移先】にアクセスしてタスクの処理を行ってください");
        task01.setTransferPass("http://localhost:8080/dummy-page");
        task01.setParamQuery("?id=1&code=2");
        listTask.add(task01);

        TaskInfoEntity task02 = new TaskInfoEntity();
        task02.setMessageTemplate("【ユーザ名】さん　【遷移先】に移動してね!!");
        task02.setTransferPass("http://localhost:9080/abcde-page/3939");
        task02.setParamQuery("?id=300&code=200");
        listTask.add(task02);

        LocalDateTime shori = LocalDateTime.of(2022, 7, 1, 2, 0, 0);
        CheckPrivilegeDto privilegeDto = CreateTestPrivilegeDtoUtil.pracitce();

        int size = insertSnsDirectMessageSendingInfoFactoryLogic.practice(privilegeDto, listUser, shori, listTask);
        assertThat(size).isEqualTo(4); // 2×2の4件

        List<SendAlertSnsMessage2022Entity> list = sendAlertSnsMessage2022Repository.findAll();
        list.sort((e1, e2) -> e1.getSendAlertSnsMessageCode() - e1.getSendAlertSnsMessageCode());

        // 1件目
        SendAlertSnsMessage2022Entity result00 = list.get(0);
        result00.getSendAlertSnsMessageId();
        result00.getSendAlertSnsMessageCode();
        assertThat(result00.getSaishinKbn()).isEqualTo(1);
        assertThat(result00.getSendUserId()).isEqualTo(3005L);
        assertThat(result00.getSendUserCode()).isEqualTo(3000);
        assertThat(result00.getSendUserName()).isEqualTo("事務員 花子");
        assertThat(result00.getSendDatetime()).isEqualTo(shori);
        assertThat(result00.getSnsLogicId()).isEqualTo(321);
        assertThat(result00.getTimesRetryNext()).isEqualTo(0);
        assertThat(result00.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(result00.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(result00.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(result00.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(result00.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(result00.getBodyText()).isEqualTo(
                "事務員 花子さん　処理すべき新たなタスクが発生しました。http://localhost:8080/dummy-page?id=1&code=2にアクセスしてタスクの処理を行ってください");
        assertThat(result00.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(result00.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(result00.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());
        
    }

}
