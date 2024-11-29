package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailEndRecordDto;

/**
 * ConvertTradingDetailEndFromCsvLogic単体テスト
 */
class ConvertTradingDetailEndFromCsvLogicTest {
    // CHECKSTYLE:OFF

    @Test
    @Tag("TableTruncate")
    void testPractice() {
        ConvertTradingDetailEndFromCsvLogic convertTradingDetailEndFromCsvLogic = new ConvertTradingDetailEndFromCsvLogic();

        final String data = "9,11,2,ｴﾝﾄﾞ";
        TradingZenginFormatTransactionDetailEndRecordDto dto = convertTradingDetailEndFromCsvLogic.practice(data.split(","));

        // データ区分の格納位置
        assertThat(dto.getDataKbn()).isEqualTo(9);

        // レコード総件数の格納位置
        assertThat(dto.getCountRecord()).isEqualTo(11);

        // 口座数の格納位置
        assertThat(dto.getCountAccount()).isEqualTo(2);

        // ダミーの格納位置
        assertThat(dto.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");
        
    }

}
