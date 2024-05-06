package mitei.mitei.create.report.balance.politician.service.zengin_financial_org;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mitei.mitei.create.report.balance.politician.entity.ZenginFinancialOrgEntity;

/**
 * ZenginFinancialOrgService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class ZenginFinancialOrgServiceTest {

    /** テスト対象　*/
    @Autowired
    private ZenginFinancialOrgService zenginFinancialOrgService;
    
    @Test
    void test()throws Exception {
        
        List<ZenginFinancialOrgEntity> listCondition = zenginFinancialOrgService.searchTable("金庫");
        
        //それぞれの仕様の名称を確認します。
        ZenginFinancialOrgEntity entity1 = listCondition.get(0);
        assertThat(entity1.getZenginFinancialOrgName()).isEqualTo("首都圏信用金庫");

        ZenginFinancialOrgEntity entity2 = listCondition.get(1);
        assertThat(entity2.getZenginFinancialOrgName()).isEqualTo("東北圏信用金庫");
    }
}
