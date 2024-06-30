package mitei.mitei.create.report.balance.politician.service.task_plan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import jakarta.transaction.Transactional;
import mitei.mitei.create.report.balance.politician.dto.SaishinKbnConstants;
import mitei.mitei.create.report.balance.politician.dto.template.TemplateFrameworkResultDto;
import mitei.mitei.create.report.balance.politician.entity.TaskPlan2025Entity;
import mitei.mitei.create.report.balance.politician.entity_interface.TaskPlanInterface;

/**
 * RegistTaskPlanAllPortalService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class RegistTaskPlanAllPortalServiceTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private RegistTaskPlanAllPortalService registTaskPlanAllPortalService;
    
    @Test
    @Transactional
    void testPractice() {
        
        List<TaskPlanInterface> list = new ArrayList<>();

        //たまたま2025年のEntityでテストデータでを作っているが、登録はテスト実施年で登録する
        //(タスク登録=当日日付最優先、だから、そういう仕様)
        TaskPlan2025Entity plan2025Entity = new TaskPlan2025Entity();

        plan2025Entity.setTaskPlanCode(null);// 最終的には上書き
        plan2025Entity.setTaskPlanName("登録データ仕訳未処理");

        plan2025Entity.setSaishinKbn(SaishinKbnConstants.SAISHIN);
        plan2025Entity.setIsFinished(false);
        plan2025Entity.setIsNoticsAlert(false);

        plan2025Entity.setPoliticalOrganizationId(12345L);
        plan2025Entity.setPoliticalOrganizationCode(1000);
        plan2025Entity.setPoliticalOrganizationName("サンプル政治団体");

        plan2025Entity.setIsDelegateFor(true);
        plan2025Entity.setIsAccountOfficerFor(true);
        plan2025Entity.setIsAccountStaffFor(true);

        plan2025Entity.setLoginUserId(991L);
        plan2025Entity.setLoginUserCode(845);
        plan2025Entity.setLoginUserName("会計責任者　正夫");

        list.add(plan2025Entity);
        
        TemplateFrameworkResultDto resultDto = registTaskPlanAllPortalService.practice(list);
        
        //1件のリストを渡したら1件届く
        assertThat(resultDto.getSuccessCount()).isEqualTo(1);
        //仮で登録した提出年がメッセージに入れてある
        assertThat(resultDto.getMessage()).isEqualTo(String.valueOf(LocalDate.now().getYear()));
    }

    @Test
    @Transactional
    void testPracticeNoData() {
     
        //listがnullの場合、実装ミスをまず疑うこと
        assertThrows(IllegalArgumentException.class, () -> registTaskPlanAllPortalService.practice(null));
        
        //listが0件の場合は何もしないで正常を返す
        List<TaskPlanInterface> list = new ArrayList<>();
        assertThat(registTaskPlanAllPortalService.practice(list).getIsOk()).isTrue();
    }
}