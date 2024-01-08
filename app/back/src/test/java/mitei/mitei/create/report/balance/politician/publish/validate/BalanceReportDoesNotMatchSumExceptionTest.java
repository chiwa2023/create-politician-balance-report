package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * BalanceReportDoesNotMatchSumException単体テスト
 */
class BalanceReportDoesNotMatchSumExceptionTest {

    @Test
    void test() {
        
        final String message = "シート0703";

        BalanceReportDoesNotMatchSumException exception = new BalanceReportDoesNotMatchSumException(message);

        assertThat(exception.getMessage()).isEqualTo(message + "のリストの金額合計が集計(pageTotal)と一致しません");

    }

}
