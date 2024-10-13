package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2025;


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
 * InsertSnsDirectMessageSendingInfo2025Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertSnsDirectMessageSendingInfo2025LogicTest {

    
    /** テスト対象 */
    @Autowired
    private InsertSnsDirectMessageSendingInfo2025Logic insertSnsDirectMessageSendingInfo2025Logic;
    
    @Test
    void testPractice() {
        
        //LocalDateTime shori  = LocalDateTime.of(2025, 7,1,2,0,0);
        
        //insertSnsDirectMessageSendingInfo2025Logic.practice(shori);
        
        
        fail("Not yet implemented");
    }

}
