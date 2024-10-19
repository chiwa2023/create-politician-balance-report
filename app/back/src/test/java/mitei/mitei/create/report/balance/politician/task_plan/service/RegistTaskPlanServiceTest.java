package mitei.mitei.create.report.balance.politician.task_plan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;
import mitei.mitei.create.report.balance.politician.dto.task_plan.RegistTaskPlanResultDto;
import mitei.mitei.create.report.balance.politician.entity.TaskInfoEntity;
import mitei.mitei.create.report.balance.politician.entity.mail.SendAlertMail2024Entity;
import mitei.mitei.create.report.balance.politician.entity.sns.SendAlertSnsMessage2024Entity;
import mitei.mitei.create.report.balance.politician.entity.task_plan.TaskPlan2024Entity;
import mitei.mitei.create.report.balance.politician.repository.TaskInfoRepository;
import mitei.mitei.create.report.balance.politician.repository.mail.SendAlertMail2024Repository;
import mitei.mitei.create.report.balance.politician.repository.sns.SendAlertSnsMessage2024Repository;
import mitei.mitei.create.report.balance.politician.repository.task_plan.TaskPlan2024Repository;
import mitei.mitei.create.report.balance.politician.util.CreateTestPrivilegeDtoUtil;

/**
 * RegistTaskPlanService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistTaskPlanServiceTest {
    // CHECKSTYLE:OFF

    /** 単体テスト */
    @Autowired
    private RegistTaskPlanService registTaskPlanService;

    /** タスク情報Repository */
    @Autowired
    private TaskInfoRepository taskInfoRepository;

    /** タスク計画Repository(2024) */
    @Autowired
    private TaskPlan2024Repository taskPlan2024Repository;

    /** メール通知計画Repository(2024) */
    @Autowired
    private SendAlertMail2024Repository sendAlertMail2024Repository;

    /** SNSダイレクトメッセージ送信計画Repository(2024) */
    @Autowired
    private SendAlertSnsMessage2024Repository sendAlertSnsMessage2024Repository;

    @Test
    @Transactional
    @Sql({ "political_org_beloging_user.sql", "user_web_access.sql", "truncate_table.sql", "task_info.sql" })
    void testPractice() { // NOPMD

        // 処理日時
        LocalDateTime shori = LocalDateTime.of(2024, 7, 1, 2, 0, 0);

        // 権限確認Dtoのnullを許容しない(実装ミスを検出)
        assertThrows(IllegalArgumentException.class,
                () -> registTaskPlanService.practice(null, shori, new ArrayList<TaskInfoEntity>())); // NOPMD

        CheckPrivilegeDto privilegeDto = CreateTestPrivilegeDtoUtil.pracitce();
        // 事務員 花子(同一識別コード201)がタスクが発生する作業を行った
        privilegeDto.setLoginUserId(201L);
        privilegeDto.setLoginUserCode(201);
        privilegeDto.setLoginUserName("事務員　花子");
        // 事務員 花子はちゃらんぽらん政治団体(〃3570)の作業をしていた。
        // (複数の政治団体所属していも、作業政治団体は1団体に限定)
        privilegeDto.setPoliticalOrganizationId(3579L);
        privilegeDto.setPoliticalOrganizationCode(3570);
        privilegeDto.setPoliticalOrganizationName("ちゃらんぽらん政治団体");

        // タスクリストのnullを許容しない(実装ミスを検出)
        assertThrows(IllegalArgumentException.class, () -> registTaskPlanService.practice(privilegeDto, shori, null));

        // 空リスト(タスク指定ミスなど)は処理しないので0件消極的成功
        // TODO タスクが存在しないので、タスク0件の場合この処理をする前に処理中断するかは要検討
        RegistTaskPlanResultDto resultDto00 = registTaskPlanService.practice(privilegeDto, shori,
                new ArrayList<TaskInfoEntity>()); // NOPMD
        assertTrue(resultDto00.getIsOk(), "空リストは処理をしないので0件消極的成功");
        assertThat(resultDto00.getSuccessCount()).isEqualTo(0);
        assertThat(resultDto00.getFailureCount()).isEqualTo(0);

        // 引数が揃っている場合処理成功(単体テスト時は固定値からのテストなのでDBで由来のデータで正常に取得できるかある程度細かく見る)

        // TODO findAllは修正する
        List<TaskInfoEntity> listTsak = taskInfoRepository.findAll();

        RegistTaskPlanResultDto resultDto01 = registTaskPlanService.practice(privilegeDto, shori, listTsak);
        assertTrue(resultDto01.getIsOk(), "処理成功");
        // assertThat(resultDto01.getSuccessCount()).isEqualTo(2);
        assertThat(resultDto01.getFailureCount()).isEqualTo(0);

        // 全件取得すると2件(resut通り)
        List<TaskPlan2024Entity> listResultTask = taskPlan2024Repository.findAll();
        assertThat(listResultTask.size()).isEqualTo(2);
        listResultTask.sort((e1, e2) -> e1.getTaskPlanCode() - e2.getTaskPlanCode());
        // 1件目
        TaskPlan2024Entity planEntity00 = listResultTask.get(0);
        assertThat(planEntity00.getTaskPlanName()).isEqualTo("タスク1");
        assertThat(planEntity00.getSaishinKbn()).isEqualTo(1);
        assertThat(planEntity00.getPoliticalOrganizationId()).isEqualTo(privilegeDto.getPoliticalOrganizationId());
        assertThat(planEntity00.getPoliticalOrganizationCode()).isEqualTo(privilegeDto.getPoliticalOrganizationCode());
        assertThat(planEntity00.getPoliticalOrganizationName()).isEqualTo(privilegeDto.getPoliticalOrganizationName());
        assertThat(planEntity00.getIsFinished()).isEqualTo(false);
        assertThat(planEntity00.getKengenKbn()).isEqualTo(3);
        assertThat(planEntity00.getListUserCode()).isEqualTo("201");
        assertThat(planEntity00.getTransferPass()).isEqualTo("http://localhost:9080/abcde-page/3939?id=300&code=200");

        // 2件目
        TaskPlan2024Entity planEntity01 = listResultTask.get(1);
        assertThat(planEntity01.getTaskPlanName()).isEqualTo("タスク2");
        assertThat(planEntity01.getKengenKbn()).isEqualTo(7);
        assertThat(planEntity01.getListUserCode()).isEqualTo("890-203");
        assertThat(planEntity01.getTransferPass()).isEqualTo("http://localhost:9080/abcd-dummy?id=34");

        // 全件取得すると1(作業員)+2(代表者・会計責任者)の3件取得
        List<SendAlertMail2024Entity> listResultMail = sendAlertMail2024Repository.findAll();
        assertThat(listResultMail.size()).isEqualTo(3);
        listResultMail.sort((e1, e2) -> e1.getSendAlertMailCode() - e2.getSendAlertMailCode());
        // 1件目
        SendAlertMail2024Entity mailEntity00 = listResultMail.get(0);
        assertThat(mailEntity00.getSaishinKbn()).isEqualTo(1);
        assertThat(mailEntity00.getSendUserId()).isEqualTo(201L);
        assertThat(mailEntity00.getSendUserCode()).isEqualTo(201);
        assertThat(mailEntity00.getSendUserName()).isEqualTo("事務担当者 花子");
        assertThat(mailEntity00.getSendDatetime()).isEqualTo(shori);
        assertThat(mailEntity00.getIsRepeat()).isEqualTo(false);
        assertThat(mailEntity00.getFromMail()).isEqualTo("3456@test.net"); // NOPMD
        assertThat(mailEntity00.getToMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity00.getCcMail()).isEqualTo("");
        assertThat(mailEntity00.getBccMail()).isEqualTo("");
        assertThat(mailEntity00.getReplyToMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity00.getSubjectMail()).isEqualTo("タスク1");
        assertThat(mailEntity00.getBodyTextMail())
                .isEqualTo("事務担当者 花子さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");
        assertThat(mailEntity00.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(mailEntity00.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(mailEntity00.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());

        // 2件目
        SendAlertMail2024Entity mailEntity01 = listResultMail.get(1);

        assertThat(mailEntity01.getSendUserId()).isEqualTo(899L);
        assertThat(mailEntity01.getSendUserCode()).isEqualTo(890);
        assertThat(mailEntity01.getSendUserName()).isEqualTo("会計責任者 正夫");
        assertThat(mailEntity01.getFromMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity01.getToMail()).isEqualTo("2345@test.net");
        assertThat(mailEntity01.getReplyToMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity01.getSubjectMail()).isEqualTo("タスク2");
        assertThat(mailEntity01.getBodyTextMail())
                .isEqualTo("会計責任者 正夫さん　http://localhost:9080/abcd-dummy?id=34でまってるよ(ハート)");

        // 3件目
        SendAlertMail2024Entity mailEntity02 = listResultMail.get(2);
        assertThat(mailEntity02.getSendUserId()).isEqualTo(203L);
        assertThat(mailEntity02.getSendUserCode()).isEqualTo(203);
        assertThat(mailEntity02.getSendUserName()).isEqualTo("代表者 太郎");
        assertThat(mailEntity02.getFromMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity02.getToMail()).isEqualTo("1234@test.net");
        assertThat(mailEntity02.getReplyToMail()).isEqualTo("3456@test.net");
        assertThat(mailEntity02.getSubjectMail()).isEqualTo("タスク2");
        assertThat(mailEntity02.getBodyTextMail())
                .isEqualTo("代表者 太郎さん　http://localhost:9080/abcd-dummy?id=34でまってるよ(ハート)");

        // 全件取得すると1(作業員)+2(代表者・会計責任者)の3件取得
        List<SendAlertSnsMessage2024Entity> listResultSns = sendAlertSnsMessage2024Repository.findAll();
        assertThat(listResultSns.size()).isEqualTo(3);
        listResultSns.sort((e1, e2) -> e1.getSendAlertSnsMessageCode() - e2.getSendAlertSnsMessageCode());
        // 1件目
        SendAlertSnsMessage2024Entity snsEntity00 = listResultSns.get(0);
        assertThat(snsEntity00.getSaishinKbn()).isEqualTo(1);
        assertThat(snsEntity00.getSendUserId()).isEqualTo(201L);
        assertThat(snsEntity00.getSendUserCode()).isEqualTo(201);
        assertThat(snsEntity00.getSendUserName()).isEqualTo("事務担当者 花子");
        assertThat(snsEntity00.getSendDatetime()).isEqualTo(shori);
        assertThat(snsEntity00.getSnsLogicId()).isEqualTo(1);
        assertThat(snsEntity00.getTimesRetryNext()).isEqualTo(0);
        assertThat(snsEntity00.getDatetimeTimes1()).isEqualTo(LocalDateTime.of(2024, 7, 1, 5, 0, 0));
        assertThat(snsEntity00.getDatetimeTimes2()).isEqualTo(LocalDateTime.of(2024, 7, 1, 8, 0, 0));
        assertThat(snsEntity00.getDatetimeTimes3()).isEqualTo(LocalDateTime.of(2024, 7, 1, 14, 0, 0));
        assertThat(snsEntity00.getDatetimeTimes4()).isEqualTo(LocalDateTime.of(2024, 7, 2, 2, 0, 0));
        assertThat(snsEntity00.getDatetimeTimes5()).isEqualTo(LocalDateTime.of(2024, 7, 3, 2, 0, 0));
        assertThat(snsEntity00.getBodyText())
                .isEqualTo("事務担当者 花子さん　http://localhost:9080/abcde-page/3939?id=300&code=200に移動してね!!");
        assertThat(snsEntity00.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(snsEntity00.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(snsEntity00.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());

        // 2件目
        SendAlertSnsMessage2024Entity snsEntity01 = listResultSns.get(1);
        assertThat(snsEntity01.getSendUserId()).isEqualTo(899L);
        assertThat(snsEntity01.getSendUserCode()).isEqualTo(890);
        assertThat(snsEntity01.getSendUserName()).isEqualTo("会計責任者 正夫");
        assertThat(snsEntity01.getSnsLogicId()).isEqualTo(2);
        assertThat(snsEntity01.getBodyText()).isEqualTo("会計責任者 正夫さん　http://localhost:9080/abcd-dummy?id=34でまってるよ(ハート)");

        // 3件目
        SendAlertSnsMessage2024Entity snsEntity02 = listResultSns.get(2);
        assertThat(snsEntity02.getSendUserId()).isEqualTo(203L);
        assertThat(snsEntity02.getSendUserCode()).isEqualTo(203);
        assertThat(snsEntity02.getSendUserName()).isEqualTo("代表者 太郎");
        assertThat(snsEntity02.getSnsLogicId()).isEqualTo(1);
        assertThat(snsEntity02.getBodyText()).isEqualTo("代表者 太郎さん　http://localhost:9080/abcd-dummy?id=34でまってるよ(ハート)");

    }

}
