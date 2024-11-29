package mitei.mitei.create.report.balance.politician.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.apache.tomcat.websocket.AuthenticationException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckPrivilegeDto;

/**
 * CheckPrivilegeService単体テスト
 */
class CheckPrivilegeServiceTest {

    @Test
    @Tag("TableTruncate")
    void testPractice()throws Exception {
        
        //他機能テストのためのMock処理
        CheckPrivilegeService checkPrivilegeService = new CheckPrivilegeService();
        
        //強制例外
        CheckPrivilegeDto dtoExcepttion = new CheckPrivilegeDto();
        dtoExcepttion.setIsRaiseExcception(true);
        assertThrows(AuthenticationException.class,() ->  checkPrivilegeService.practice(dtoExcepttion));
        
        //チェックがfalse
        CheckPrivilegeDto dtoReject = new CheckPrivilegeDto();
        dtoReject.setIsResult(false);
        dtoReject.setIsRaiseExcception(false);
        assertThat(checkPrivilegeService.practice(dtoReject)).isEqualTo(false);

        //チェックがtrue
        CheckPrivilegeDto dto = new CheckPrivilegeDto();
        dto.setIsResult(true);
        dto.setIsRaiseExcception(false);
        assertThat(checkPrivilegeService.practice(dto)).isEqualTo(true);
        
        fail("Not yet implemented");
    }

}
