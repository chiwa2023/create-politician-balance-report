package mitei.mitei.create.report.balance.politician.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckSecurityDto;

/**
 * CheckSecurityService単体テスト
 */
class CheckSecurityServiceTest {

    @Test
    void testPractice()throws Exception {
        
        //他機能テストのためのMock処理
        CheckSecurityService checkSecurityService = new CheckSecurityService();
        
        //強制例外
        CheckSecurityDto dtoExcepttion = new CheckSecurityDto();
        dtoExcepttion.setIsRaiseExcception(true);
        assertThrows(SecurityException.class,() ->  checkSecurityService.practice(dtoExcepttion));
        
        //チェックがfalse
        CheckSecurityDto dtoReject = new CheckSecurityDto();
        dtoReject.setIsResult(false);
        dtoReject.setIsRaiseExcception(false);
        assertThat(checkSecurityService.practice(dtoReject)).isEqualTo(false);

        //チェックがtrue
        CheckSecurityDto dto = new CheckSecurityDto();
        dto.setIsResult(true);
        dto.setIsRaiseExcception(false);
        assertThat(checkSecurityService.practice(dto)).isEqualTo(true);
        
        fail("Not yet implemented");
    }

}
