package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailTrailerRecordDto;

/**
 * ConvertTradingDetailTrailerFromCsvLogic単体テスト
 */
class ConvertTradingDetailTrailerFromCsvLogicTest {
    // CHECKSTYLE:OFF

    @Test
    void testPractice() {
        ConvertTradingDetailTrailerFromCsvLogic convertTradingDetailTrailerFromCsvLogic = new ConvertTradingDetailTrailerFromCsvLogic();

        final String data ="8,1,00035791,1,000123,1,00097531,2,ｴﾝﾄﾞ";
        
        TradingZenginFormatTransactionDetailTrailerRecordDto dto = convertTradingDetailTrailerFromCsvLogic.practice(data.split(","));
        
        // データ区分の格納位置
        assertThat(dto.getDataKbn()).isEqualTo(8);

        // 入金件数の格納位置 
        assertThat(dto.getCountIncome()).isEqualTo(1);

        // 入金額合計の格納位置 
        assertThat(dto.getSumIncome()).isEqualTo(35791L);

        // 出金件数の格納位置 
        assertThat(dto.getCountOutcome()).isEqualTo(1);

        // 出金額合計の格納位置 
        assertThat(dto.getSumOutcome()).isEqualTo(123);

        // 貸越区分の格納位置 
        assertThat(dto.getOverdraftKbn()).isEqualTo(1);

        // 取引後残高の格納位置 
        assertThat(dto.getBalanceAfterTransaction()).isEqualTo(97531L);

        // データ・レコード件数の格納位置 
        assertThat(dto.getCountData()).isEqualTo(2);

        // ダミーの格納位置 
        assertThat(dto.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");
        
        
        
        final String data2 ="8,1,00035791,1,000123, , ,2,ｴﾝﾄﾞ";
        
        TradingZenginFormatTransactionDetailTrailerRecordDto dto2 = convertTradingDetailTrailerFromCsvLogic.practice(data2.split(","));
        
        // データ区分の格納位置
        assertThat(dto2.getDataKbn()).isEqualTo(8);

        // 入金件数の格納位置 
        assertThat(dto2.getCountIncome()).isEqualTo(1);

        // 入金額合計の格納位置 
        assertThat(dto2.getSumIncome()).isEqualTo(35791L);

        // 出金件数の格納位置 
        assertThat(dto2.getCountOutcome()).isEqualTo(1);

        // 出金額合計の格納位置 
        assertThat(dto2.getSumOutcome()).isEqualTo(123);

        // 貸越区分の格納位置 
        assertNull(dto2.getOverdraftKbn());

        // 取引後残高の格納位置 
        assertNull(dto2.getBalanceAfterTransaction());

        // データ・レコード件数の格納位置 
        assertThat(dto2.getCountData()).isEqualTo(2);

        // ダミーの格納位置 
        assertThat(dto2.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");
        
    }

}
