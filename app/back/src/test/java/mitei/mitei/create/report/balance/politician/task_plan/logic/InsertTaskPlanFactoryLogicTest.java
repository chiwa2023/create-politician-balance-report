package mitei.mitei.create.report.balance.politician.task_plan.logic;

import static org.assertj.core.api.Assertions.assertThat;

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
import mitei.mitei.create.report.balance.politician.entity.task_plan.TaskPlan2024Entity;
import mitei.mitei.create.report.balance.politician.repository.task_plan.TaskPlan2024Repository;
import mitei.mitei.create.report.balance.politician.util.CreateTestPrivilegeDtoUtil;

/**
 * InsertTaskPlanFactoryLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertTaskPlanFactoryLogicTest {
    // CHECKSTYLE:OFF

    /** テスト対象 */
    @Autowired
    private InsertTaskPlanFactoryLogic insertTaskPlanFactoryLogic;
    
    
    /** タスク予定Repository */
    @Autowired
    private TaskPlan2024Repository taskPlan2024Repository;

    @Test
    @Tag("TableTruncate")
    @Transactional
    @Sql("y2024/truncate_task_plan_2024.sql")
    void testPractice() {
        
        // 他の報告年は自動でテストケースを随時追加する
        
        List<UserWebAccessEntity> listUser = new ArrayList<>();
        UserWebAccessEntity user01 = new UserWebAccessEntity();
        user01.setUserId(3005L);
        user01.setUserCode(3000);
        user01.setUserName("事務員 花子");
        user01.setSendSnsLogicId(321);
        user01.setKengenKbn(YakushokuKbnConstants.OFFICER.value());
        listUser.add(user01);

        UserWebAccessEntity user02 = new UserWebAccessEntity();
        user02.setUserId(4005L);
        user02.setUserCode(4000);
        user02.setUserName("作業員 一郎");
        user02.setSendSnsLogicId(486);
        user02.setKengenKbn(YakushokuKbnConstants.WORKER.value());
        listUser.add(user02);

        List<TaskInfoEntity> listTask = new ArrayList<>();

        TaskInfoEntity task01 = new TaskInfoEntity();
        task01.setMessageTemplate("【ユーザ名】さん　処理すべき新たなタスクが発生しました。【遷移先】にアクセスしてタスクの処理を行ってください");
        task01.setTransferPass("http://localhost:8080/dummy-page");
        task01.setParamQuery("?id=1&code=2");
        task01.setTaskInfoName("ダミー1タスク");
        task01.setKengenKbn(KengenKbnWorksConstants.MANAGER_UNDER);
        listTask.add(task01);

        TaskInfoEntity task02 = new TaskInfoEntity();
        task02.setMessageTemplate("【ユーザ名】さん　【遷移先】に移動してね!!");
        task02.setTransferPass("http://localhost:9080/abcde-page/3939");
        task02.setParamQuery("?id=300&code=200");
        task02.setTaskInfoName("ダミー2タスク");
        task02.setKengenKbn(KengenKbnWorksConstants.OFFICER_ONLY);
        listTask.add(task02);

        CheckPrivilegeDto privilegeDto = CreateTestPrivilegeDtoUtil.pracitce();

        int size = insertTaskPlanFactoryLogic.practice(2024,privilegeDto, listTask, listUser);

        assertThat(size).isEqualTo(2);

        List<TaskPlan2024Entity> list = taskPlan2024Repository.findAll();
        list.sort((e1, e2) -> e1.getTaskPlanCode() - e2.getTaskPlanCode());

        // 1件目
        TaskPlan2024Entity result01 = list.get(0);
        // assertThat(result01.getTaskPlanCode()).isEqualTo(1);
        assertThat(result01.getTaskPlanName()).isEqualTo("ダミー1タスク");
        assertThat(result01.getSaishinKbn()).isEqualTo(1);
        assertThat(result01.getPoliticalOrganizationId()).isEqualTo(privilegeDto.getPoliticalOrganizationId());
        assertThat(result01.getPoliticalOrganizationCode()).isEqualTo(privilegeDto.getPoliticalOrganizationCode());
        assertThat(result01.getPoliticalOrganizationName()).isEqualTo(privilegeDto.getPoliticalOrganizationName());
        assertThat(result01.getIsFinished()).isEqualTo(false);
        assertThat(result01.getKengenKbn()).isEqualTo(5); // KengenKbnWorksConstants.MANAGER_UNDER
        assertThat(result01.getListUserCode()).isEqualTo("3000-4000");
        assertThat(result01.getTransferPass()).isEqualTo("http://localhost:8080/dummy-page?id=1&code=2");
        assertThat(result01.getInsertUserId()).isEqualTo(privilegeDto.getLoginUserId());
        assertThat(result01.getInsertUserCode()).isEqualTo(privilegeDto.getLoginUserCode());
        assertThat(result01.getInsertUserName()).isEqualTo(privilegeDto.getLoginUserName());

        // 2件目
        TaskPlan2024Entity result02 = list.get(1);
        assertThat(result02.getTaskPlanCode()).isEqualTo(1 + result01.getTaskPlanCode());
        assertThat(result02.getTaskPlanName()).isEqualTo("ダミー2タスク");
        assertThat(result02.getKengenKbn()).isEqualTo(3); // KengenKbnWorksConstants.OFFICER_ONLY
        assertThat(result02.getListUserCode()).isEqualTo("3000");
        assertThat(result02.getTransferPass()).isEqualTo("http://localhost:9080/abcde-page/3939?id=300&code=200");

    }

}
