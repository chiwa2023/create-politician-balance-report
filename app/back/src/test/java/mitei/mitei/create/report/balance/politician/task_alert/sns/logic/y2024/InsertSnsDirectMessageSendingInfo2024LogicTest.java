package mitei.mitei.create.report.balance.politician.task_alert.sns.logic.y2024;


import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * InsertSnsDirectMessageSendingInfo2024Logic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class InsertSnsDirectMessageSendingInfo2024LogicTest {

    
    /** テスト対象 */
    @Autowired
    private InsertSnsDirectMessageSendingInfo2024Logic insertSnsDirectMessageSendingInfo2024Logic;
    
    @Test
    void testPractice() {
        
        LocalDateTime shori  = LocalDateTime.of(2024, 7,1,2,0,0);
        
        insertSnsDirectMessageSendingInfo2024Logic.practice(shori);
        
        
        fail("Not yet implemented");
    }

}
