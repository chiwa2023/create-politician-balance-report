package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2022;


import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * InsertSnsDirectMessageSendingInfo2022Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertSnsDirectMessageSendingInfo2022LogicTest {

    
    /** テスト対象 */
    @Autowired
    private InsertSnsDirectMessageSendingInfo2022Logic insertSnsDirectMessageSendingInfo2022Logic;
    
    @Test
    void testPractice() {
        
        //LocalDateTime shori  = LocalDateTime.of(2022, 7,1,2,0,0);
        
        //insertSnsDirectMessageSendingInfo2022Logic.practice(shori);
        
        
        fail("Not yet implemented");
    }

}
