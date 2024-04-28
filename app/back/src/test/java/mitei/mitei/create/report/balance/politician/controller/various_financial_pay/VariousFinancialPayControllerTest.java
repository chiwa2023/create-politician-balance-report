package mitei.mitei.create.report.balance.politician.controller.various_financial_pay;

import static org.junit.jupiter.api.Assertions.fail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;


/**
 * VariousFinancialPayController単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class VariousFinancialPayControllerTest {

    /** mockMvc */
    @Autowired
    private MockMvc mockMvc;

    void test()throws Exception {
        fail("Not yet implemented");
    } 
    
}
