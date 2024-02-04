package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * BalanceReportRequiredInputException単体テスト
 */
class BalanceReportRequiredInputExceptionTest {

    @Test
    void test() throws Exception {

        final String message = "親オブジェクト";

        BalanceReportRequiredInputException exception = new BalanceReportRequiredInputException(message);

        assertThat(exception.getMessage()).isEqualTo(message + "が未入力です");
    }

}
