package mitei.mitei.create.report.balance.politician.logic.trunsaction;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * CheckTrunsactionProposeCsvReadLogic単体テスト
 */
@SpringJUnitConfig
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
class CheckTrunsactionProposeCsvReadLogicTest {
    // CHECKSTYLE:OFF
    
    /** テスト対象 */
    @Autowired
    private CheckTrunsactionProposeCsvReadLogic checkTrunsactionProposeCsvReadLogic;
    
    @Test
    void testPractice() {

        assertFalse(checkTrunsactionProposeCsvReadLogic.practice(100L),"申請になっていないIdを指定");
        assertTrue(checkTrunsactionProposeCsvReadLogic.practice(15L),"申請中のId指定");
    }

}
