package mitei.mitei.create.report.balance.politician.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.dao.PessimisticLockingFailureException;

import mitei.mitei.create.report.balance.politician.dto.common_check.CheckTransactionDto;

/**
 * CheckTransactionService単体テスト
 */
class CheckTransactionServiceTest {

    @Test
    @Tag("TableTruncate")
    void testPractice()throws Exception {
        
        //他機能テストのためのMock処理
        CheckTransactionService checkTransactionService = new CheckTransactionService();
        
        //強制例外
        CheckTransactionDto dtoExcepttion = new CheckTransactionDto();
        dtoExcepttion.setIsRaiseExcception(true);
        dtoExcepttion.setIsSelectOnly(false);
        assertThrows(PessimisticLockingFailureException.class,() ->  checkTransactionService.practice(dtoExcepttion));
        
        //チェックがfalse
        CheckTransactionDto dtoReject = new CheckTransactionDto();
        dtoReject.setIsResult(false);
        dtoReject.setIsRaiseExcception(false);
        dtoReject.setIsSelectOnly(false);
        assertThat(checkTransactionService.practice(dtoReject)).isEqualTo(false);

        //照会しかしない場合は常にtrue
        CheckTransactionDto dtoSelect = new CheckTransactionDto();
        dtoSelect.setIsResult(false);
        dtoSelect.setIsRaiseExcception(true);
        dtoSelect.setIsSelectOnly(true);
        assertThat(checkTransactionService.practice(dtoSelect)).isEqualTo(true);

        //チェックがtrue
        CheckTransactionDto dto = new CheckTransactionDto();
        dto.setIsResult(true);
        dto.setIsRaiseExcception(false);
        dto.setIsSelectOnly(false);
        assertThat(checkTransactionService.practice(dto)).isEqualTo(true);
        
        fail("Not yet implemented");
    }

}
