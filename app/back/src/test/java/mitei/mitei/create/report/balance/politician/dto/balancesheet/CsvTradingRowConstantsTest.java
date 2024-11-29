package mitei.mitei.create.report.balance.politician.dto.balancesheet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * CsvTradingRowConstants単体テスト
 */
class CsvTradingRowConstantsTest {
    // CHECKSTYLE:OFF MagicNumber

    /** 指定なし */
    private static final int NO_POINT = 0;

    /** 取引金額支出 */
    private static final int OUTCOME_AMOUNT = 1;

    /** 取引金額収入 */
    private static final int INCOME_AMOUNT = 2;

    /** 取引金額増減兼用 */
    private static final int AMOUNT_IN_OUT = 3;

    /** 発生日 */
    private static final int ACCURAL_DATE = 15;

    /** 摘要 */
    private static final int DIGEST = 16;

    /** 取引相手名称 */
    private static final int TRADING_PERSON = 17;

    @Test
    @Tag("TableTruncate")
    void testConvertValueToText() {
        
        // 指定なし
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(NO_POINT))).isEqualTo("指定なし");
        
        // 取引金額支出
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(OUTCOME_AMOUNT))).isEqualTo("取引金額支出");

        // 取引金額収入
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(INCOME_AMOUNT))).isEqualTo("取引金額収入");

        //取引金額増減兼用
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(AMOUNT_IN_OUT))).isEqualTo("取引金額増減兼用");

        // 発生日
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(ACCURAL_DATE))).isEqualTo("発生日");

        // 摘要
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(DIGEST))).isEqualTo("摘要");

        //取引相手名称
        assertThat(CsvTradingRowConstants.convertValueToText(String.valueOf(TRADING_PERSON))).isEqualTo("取引相手名称");
        
        //定数にない値を入れると例外
        assertThrows(IllegalArgumentException.class, () -> CsvTradingRowConstants.convertValueToText(String.valueOf(100)));
        
        //数値でない値を入れると例外
        assertThrows(NumberFormatException.class, () -> CsvTradingRowConstants.convertValueToText("あかさたな"));
    }

}
