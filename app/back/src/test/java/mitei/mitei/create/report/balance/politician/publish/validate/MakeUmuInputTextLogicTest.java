package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * MakeUmuInputTextLogic単体テスト
 */
class MakeUmuInputTextLogicTest {

    @Test
    void test() {
        
        
        MakeUmuInputTextLogic makeUmuInputTextLogic = new MakeUmuInputTextLogic();
        
        String textAnswer =makeUmuInputTextLogic.practice(0);
        
        assertThat(textAnswer).isEqualTo(textAnswer);
        
        fail("Not yet implemented");
    }

}
