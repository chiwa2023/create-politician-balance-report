package mitei.mitei.create.report.balance.politician.service.various_financial_pay;

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

import mitei.mitei.create.report.balance.politician.entity.VariousFinancialPayEntity;

/**
 * VariousFinancialPayService単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class VariousFinancialPayServiceTest {

    /** 単体テスト対象 */
    @Autowired
    private VariousFinancialPayService variousFinancialPayService;
    
    @Test
    void test()throws Exception {
        
        List<VariousFinancialPayEntity> listCondition = variousFinancialPayService.searchTable("木の葉");
        
        //それぞれの仕様の名称を確認します。
        assertThat(listCondition.get(1).getVariousFinancialPayName()).isEqualTo("きつねが木の葉で払うPay");
        assertThat(listCondition.get(0).getVariousFinancialPayName()).isEqualTo("木の葉のポイントざくざくPay");
    }

}
