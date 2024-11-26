package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto;

/**
 * ConvertTradingDetailDataGroup1FromCsvLogic単体テスト
 */
class ConvertTradingDetailDataGroup1FromCsvLogicTest {
    // CHECKSTYLE:OFF
    
    @Test
    @Tag("TableTruncate")
    void testPractice() throws Exception {
        ConvertTradingDetailDataGroup1FromCsvLogic convertTradingDetailDataGroup1FromCsvLogic = new ConvertTradingDetailDataGroup1FromCsvLogic();

        final String data = "2,12345,031201,031218,1,11,0000098765,0003333,030913,031024,2,00468,456,2468013579,振込信金ユーザ太郎,××銀行,○○支店,取引詳細,edi,ｴﾝﾄﾞ";

        TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto dto = convertTradingDetailDataGroup1FromCsvLogic
                .practice(data.split(","));

        // データ区分の格納位置
        assertThat(dto.getDataKbn()).isEqualTo(2);

        // 照会番号の格納位置
        assertThat(dto.getReferNo()).isEqualTo("12345");

        // 勘定日の格納位置
        assertThat(dto.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));

        // 預入・払出日の格納位置
        assertThat(dto.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 18));

        // 入払区分の格納位置
        assertThat(dto.getDeWdKbn()).isEqualTo(1);

        // 取引区分の格納位置
        assertThat(dto.getTradingKbn()).isEqualTo(11);

        // 取引金額の格納位置
        assertThat(dto.getTransactionAmount()).isEqualTo(98765L);

        // うち他店券金額の格納位置
        assertThat(dto.getOtherStoreTicketAmount()).isEqualTo(3333L);

        // 交換呈示日の格納位置
        assertThat(dto.getExchangePresentationDate()).isEqualTo(LocalDate.of(2021, 9, 13));

        // 不渡返還日の格納位置
        assertThat(dto.getDishonoredReturnDate()).isEqualTo(LocalDate.of(2021, 10, 24));

        // 手形・小切手区分の格納位置
        assertThat(dto.getBillCheckKbn()).isEqualTo(2);

        // 手形・小切手番号の格納位置
        assertThat(dto.getBillCheckNo()).isEqualTo("00468");

        // 僚店番号の格納位置
        assertThat(dto.getBranchNo()).isEqualTo("456");

        // 振込依頼人コードの格納位置
        assertThat(dto.getTransferRequesterCode()).isEqualTo("2468013579");

        // 依頼人名または契約者番号の格納位置
        assertThat(dto.getTradingDetail()).isEqualTo("振込信金ユーザ太郎");

        // 仕向銀行名の格納位置
        assertThat(dto.getSendingBankName()).isEqualTo("××銀行");

        // 仕向店名の格納位置
        assertThat(dto.getSendingBankBranchName()).isEqualTo("○○支店");

        // 摘要内容の格納位置
        assertThat(dto.getAbstractContent()).isEqualTo("取引詳細");

        // EDI情報の格納位置
        assertThat(dto.getEdiInfo()).isEqualTo("edi");

        // ダミーの格納位置
        assertThat(dto.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

        
        
        final String data2 = "2, ,031201,031218,1, ,0000098765,0003333, , , , , , , , , , , ,ｴﾝﾄﾞ";

        TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto dto2 = convertTradingDetailDataGroup1FromCsvLogic
                .practice(data2.split(","));

        // データ区分の格納位置
        assertThat(dto2.getDataKbn()).isEqualTo(2);

        // 照会番号の格納位置
        assertNull(dto2.getReferNo(),"");

        // 勘定日の格納位置
        assertThat(dto2.getAccountingDate()).isEqualTo(LocalDate.of(2021, 12, 1));

        // 預入・払出日の格納位置
        assertThat(dto2.getDepositWithdrawalDate()).isEqualTo(LocalDate.of(2021, 12, 18));

        // 入払区分の格納位置
        assertThat(dto2.getDeWdKbn()).isEqualTo(1);

        // 取引区分の格納位置
        assertNull(dto2.getTradingKbn(),"");

        // 取引金額の格納位置
        assertThat(dto2.getTransactionAmount()).isEqualTo(98765L);

        // うち他店券金額の格納位置
        assertThat(dto2.getOtherStoreTicketAmount()).isEqualTo(3333L);

        // 交換呈示日の格納位置
        assertNull(dto2.getExchangePresentationDate(),"");

        // 不渡返還日の格納位置
        assertNull(dto2.getDishonoredReturnDate(),"");

        // 手形・小切手区分の格納位置
        assertNull(dto2.getBillCheckKbn(),"");

        // 手形・小切手番号の格納位置
        assertNull(dto2.getBillCheckNo(),"");

        // 僚店番号の格納位置
        assertNull(dto2.getBranchNo(),"");

        // 振込依頼人コードの格納位置
        assertNull(dto2.getTransferRequesterCode(),"");

        // 依頼人名または契約者番号の格納位置
        assertNull(dto2.getTradingDetail(),"");

        // 仕向銀行名の格納位置
        assertNull(dto2.getSendingBankName(),"");

        // 仕向店名の格納位置
        assertNull(dto2.getSendingBankBranchName(),"");

        // 摘要内容の格納位置
        assertNull(dto2.getAbstractContent(),"");

        // EDI情報の格納位置
        assertNull(dto2.getEdiInfo(),"");

        // ダミーの格納位置
        assertThat(dto2.getDummyEnd()).isEqualTo("ｴﾝﾄﾞ");

    }

}
