package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto;

/**
 * ConvertTradingDetailDataGroup2FromCsvLogic単体テスト
 */
class ConvertTradingDetailDataGroup2FromCsvLogicTest {
    // CHECKSTYLE:OFF
    
    @Test
    @Tag("TableTruncate")
    void testPractice() { // NOPMD
        ConvertTradingDetailDataGroup2FromCsvLogic convertTradingDetailDataGroup2FromCsvLogic = new ConvertTradingDetailDataGroup2FromCsvLogic();

        final String data = "2,00123,031201,031210,1,10,0000098765,000333,040205,040209,1,000246,456,040301,0.22,100101,0110022,00135,1.12,2,012,0.33,00129,0035798,2,0.23,009753,006654,ﾃｷﾖｳ,1212,1,ｴﾝﾄﾞ";

        TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto dto = convertTradingDetailDataGroup2FromCsvLogic
                .practice(data.split(","));

        // データ区分の格納位置
        assertThat(dto.getDataKbn()).isEqualTo(2);

        // 識別番号の格納位置
        assertThat(dto.getIdentificationNo()).isEqualTo("00123");

        // 勘定日の格納位置
        assertThat(dto.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));

        // 預入・払出日の格納位置
        assertThat(dto.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 10));

        // 入払区分の格納位置
        assertThat(dto.getDeWdKbn()).isEqualTo(1);

        // 取引区分の格納位置
        assertThat(dto.getTradingKbn()).isEqualTo(10);

        // 取引金額の格納位置
        assertThat(dto.getTransactionAmount()).isEqualTo(98765L);

        // うち他店券金額の格納位置
        assertThat(dto.getOtherStoreTicketAmount()).isEqualTo(333);

        // 交換呈示日の格納位置
        assertThat(dto.getExchangePresentationDate()).isEqualTo(LocalDate.of(2022, 2, 5));

        // 不渡返還日の格納位置
        assertThat(dto.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2022, 2, 9));

        // 手形・小切手区分の格納位置
        assertThat(dto.getBillCheckKbn()).isEqualTo(1);

        // 手形・小切手番号の格納位置
        assertThat(dto.getBillCheckNo()).isEqualTo("000246");

        // 僚店番号の格納位置
        assertThat(dto.getBranchNo()).isEqualTo("456");

        // 当初預入日の格納位置
        assertThat(dto.getOrginalDate()).isEqualTo(LocalDate.of(2022, 3, 1));

        // 利率の格納位置
        assertThat(dto.getInterestRate()).isEqualTo(0.22F);

        // 満期日の格納位置
        assertThat(dto.getMaturityDate()).isEqualTo(LocalDate.of(2028, 1, 1));

        // 期間(1)の格納位置
        assertThat(dto.getPeriod1()).isEqualTo("0110022");

        // 期間利息の格納位置
        assertThat(dto.getPeriodInterest()).isEqualTo(135L);

        // 中間払利率の格納位置
        assertThat(dto.getIntermediateInterestRate()).isEqualTo(1.12F);

        // 中間払区分の格納位置
        assertThat(dto.getInterimPaymentKbn()).isEqualTo(2);

        // 期後期間の格納位置
        assertThat(dto.getPostPeriod()).isEqualTo(12);

        // 期後利率の格納位置
        assertThat(dto.getPostPeriodInterestRate()).isEqualTo(0.33F);

        // 期後利息の格納位置
        assertThat(dto.getPostPeriodInterest()).isEqualTo(129L);

        // 合計利息の格納位置
        assertThat(dto.getTotalInterest()).isEqualTo(35798L);

        // 税区分の格納位置
        assertThat(dto.getTaxKbn()).isEqualTo(2);

        // 税率の格納位置
        assertThat(dto.getTaxRate()).isEqualTo(0.23F);

        // 税額の格納位置
        assertThat(dto.getTaxAmount()).isEqualTo(9753L);

        // 税引後利息の格納位置
        assertThat(dto.getAfterTaxInterest()).isEqualTo(6654L);

        // 摘要内容の格納位置
        assertThat(dto.getAbstractContent()).isEqualTo("ﾃｷﾖｳ");

        // 期間（2）の格納位置
        assertThat(dto.getPeriod2()).isEqualTo("1212");

        // 期間利息正負表示の格納位置
        assertThat(dto.getPeriodicInterestKbn()).isEqualTo(1);

        // ダミーの格納位置
        assertThat(dto.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");
        
        
        
        final String data2 = "2, ,031201,031210,1, ,0000098765,000333, , , , , , ,0.22, , , , , , , , , , , , , , , , ,ｴﾝﾄﾞ";

        TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto dto2 = convertTradingDetailDataGroup2FromCsvLogic
                .practice(data2.split(","));

        // データ区分の格納位置
        assertThat(dto2.getDataKbn()).isEqualTo(2);

        final String emptyData = "空データ";
        
        // 識別番号の格納位置
        assertNull(dto2.getIdentificationNo(),emptyData);

        // 勘定日の格納位置
        assertThat(dto2.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));

        // 預入・払出日の格納位置
        assertThat(dto2.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 10));

        // 入払区分の格納位置
        assertThat(dto2.getDeWdKbn()).isEqualTo(1);

        // 取引区分の格納位置
        assertNull(dto2.getTradingKbn(),emptyData);

        // 取引金額の格納位置
        assertThat(dto2.getTransactionAmount()).isEqualTo(98765L);

        // うち他店券金額の格納位置
        assertThat(dto2.getOtherStoreTicketAmount()).isEqualTo(333);

        // 交換呈示日の格納位置
        assertNull(dto2.getExchangePresentationDate(),emptyData);

        // 不渡返還日の格納位置
        assertNull(dto2.getDishonoredReturnDate(),emptyData);

        // 手形・小切手区分の格納位置
        assertNull(dto2.getBillCheckKbn(),emptyData);

        // 手形・小切手番号の格納位置
        assertNull(dto2.getBillCheckNo(),emptyData);

        // 僚店番号の格納位置
        assertNull(dto2.getBranchNo(),emptyData);

        // 当初預入日の格納位置
        assertNull(dto2.getOrginalDate(),emptyData);

        // 利率の格納位置
        assertThat(dto2.getInterestRate()).isEqualTo(0.22F);

        // 満期日の格納位置
        assertNull(dto2.getMaturityDate(),emptyData);

        // 期間(1)の格納位置
        assertNull(dto2.getPeriod1(),emptyData);

        // 期間利息の格納位置
        assertNull(dto2.getPeriodInterest(),emptyData);

        // 中間払利率の格納位置
        assertNull(dto2.getIntermediateInterestRate(),emptyData);

        // 中間払区分の格納位置
        assertNull(dto2.getInterimPaymentKbn(),emptyData);

        // 期後期間の格納位置
        assertNull(dto2.getPostPeriod(),emptyData);

        // 期後利率の格納位置
        assertNull(dto2.getPostPeriodInterestRate(),emptyData);

        // 期後利息の格納位置
        assertNull(dto2.getPostPeriodInterest(),emptyData);

        // 合計利息の格納位置
        assertNull(dto2.getTotalInterest(),emptyData);

        // 税区分の格納位置
        assertNull(dto2.getTaxKbn(),emptyData);

        // 税率の格納位置
        assertNull(dto2.getTaxRate(),emptyData);

        // 税額の格納位置
        assertNull(dto2.getTaxAmount(),emptyData);

        // 税引後利息の格納位置
        assertNull(dto2.getAfterTaxInterest(),emptyData);

        // 摘要内容の格納位置
        assertNull(dto2.getAbstractContent(),emptyData);

        // 期間（2）の格納位置
        assertNull(dto2.getPeriod2(),emptyData);

        // 期間利息正負表示の格納位置
        assertNull(dto2.getPeriodicInterestKbn(),emptyData);

        // ダミーの格納位置
        assertThat(dto2.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

    }

}
