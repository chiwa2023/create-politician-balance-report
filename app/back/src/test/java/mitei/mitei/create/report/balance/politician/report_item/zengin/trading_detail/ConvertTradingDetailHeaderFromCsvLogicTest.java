package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailHeaderRecordDto;

/**
 * ConvertTradingDetailHeaderFromCsvLogic単体テスト
 */
class ConvertTradingDetailHeaderFromCsvLogicTest {
// CHECKSTYLE:OFF
    @Test
    void testPractice() { // NOPMD

        final String data = "1,03,0,041001,040901,050131,0123,ｷﾞﾝｺｳﾒｲ   ,098,ｼﾃﾝﾒｲ     ,ﾀﾞﾐｰ  ,1,00002345,ｺｳｻﾞﾒｲｼｮｳ     ,1,1,00024680,   ";

        ConvertTradingDetailHeaderFromCsvLogic convertTradingDetailHeaderFromCsvLogic = new ConvertTradingDetailHeaderFromCsvLogic();

        TradingZenginFormatTransactionDetailHeaderRecordDto dto = convertTradingDetailHeaderFromCsvLogic
                .practice(data.split(","));
        
        // データ区分の格納位置
        assertThat(dto.getDataKbn()).isEqualTo(1);

        // 種別コードの格納位置
        assertThat(dto.getBusinessType()).isEqualTo("03");

        // コード区分の格納位置
        assertThat(dto.getCodeKbn()).isEqualTo(0);

        // 作成日の格納位置
        assertThat(dto.getDateMaking()).isEqualTo(LocalDate.of(2022, 10, 1));

        // 勘定日(自)の格納位置
        assertThat(dto.getDateFromRef()).isEqualTo(LocalDate.of(2022, 9, 1));

        // 勘定日(至)の格納位置
        assertThat(dto.getDateToRef()).isEqualTo(LocalDate.of(2023, 1, 31));

        // 銀行コードの格納位置
        assertThat(dto.getBankNo()).isEqualTo("0123");

        // 銀行名の格納位置
        assertThat(dto.getBankName()).isEqualTo("ｷﾞﾝｺｳﾒｲ");

        // 支店コードの格納位置
        assertThat(dto.getBranchNo()).isEqualTo("098");

        // 支店名の格納位置
        assertThat(dto.getBranchName()).isEqualTo("ｼﾃﾝﾒｲ");

        // ダミーの格納位置
        assertThat(dto.getDummy()).isEqualTo("ﾀﾞﾐｰ");

        // 預金種目の格納位置
        assertThat(dto.getDepositType()).isEqualTo(1);

        // 口座番号の格納位置
        assertThat(dto.getAccountNo()).isEqualTo("00002345");

        // 口座名の格納位置
        assertThat(dto.getAccountName()).isEqualTo("ｺｳｻﾞﾒｲｼｮｳ");

        // 貸越区分の格納位置
        assertThat(dto.getOverdraftKbn()).isEqualTo(1);

        // 通帳・証書区分の格納位置
        assertThat(dto.getPassbookKbn()).isEqualTo(1);

        // 取引前残高の格納位置
        assertThat(dto.getPreTransactionBalance()).isEqualTo(24680L);

        // ダミーの格納位置
        assertThat(dto.getDummyEnd()).isEqualTo("");
        
        
        //省略可能データ対応
        final String data2 = "1,03,0,041001,040901,050131,0123,ｷﾞﾝｺｳﾒｲ   ,098,ｼﾃﾝﾒｲ     ,ﾀﾞﾐｰ  ,1,00002345,ｺｳｻﾞﾒｲｼｮｳ     ,1, , ,   ";

        TradingZenginFormatTransactionDetailHeaderRecordDto dto2 = convertTradingDetailHeaderFromCsvLogic
                .practice(data2.split(","));

        // データ区分の格納位置
        assertThat(dto2.getDataKbn()).isEqualTo(1);

        // 種別コードの格納位置
        assertThat(dto2.getBusinessType()).isEqualTo("03");

        // コード区分の格納位置
        assertThat(dto2.getCodeKbn()).isEqualTo(0);

        // 作成日の格納位置
        assertThat(dto2.getDateMaking()).isEqualTo(LocalDate.of(2022, 10, 1));

        // 勘定日(自)の格納位置
        assertThat(dto2.getDateFromRef()).isEqualTo(LocalDate.of(2022, 9, 1));

        // 勘定日(至)の格納位置
        assertThat(dto2.getDateToRef()).isEqualTo(LocalDate.of(2023, 1, 31));

        // 銀行コードの格納位置
        assertThat(dto2.getBankNo()).isEqualTo("0123");

        // 銀行名の格納位置
        assertThat(dto2.getBankName()).isEqualTo("ｷﾞﾝｺｳﾒｲ");

        // 支店コードの格納位置
        assertThat(dto2.getBranchNo()).isEqualTo("098");

        // 支店名の格納位置
        assertThat(dto2.getBranchName()).isEqualTo("ｼﾃﾝﾒｲ");

        // ダミーの格納位置
        assertThat(dto2.getDummy()).isEqualTo("ﾀﾞﾐｰ");

        // 預金種目の格納位置
        assertThat(dto2.getDepositType()).isEqualTo(1);

        // 口座番号の格納位置
        assertThat(dto2.getAccountNo()).isEqualTo("00002345");

        // 口座名の格納位置
        assertThat(dto2.getAccountName()).isEqualTo("ｺｳｻﾞﾒｲｼｮｳ");

        // 貸越区分の格納位置
        assertThat(dto2.getOverdraftKbn()).isEqualTo(1);

        // 通帳・証書区分の格納位置
        assertNull(dto2.getPassbookKbn(),"必ず値が設定");

        // 取引前残高の格納位置
        assertNull(dto2.getPreTransactionBalance(),"必ず値が設定");

        // ダミーの格納位置
        assertThat(dto2.getDummyEnd()).isEqualTo("");

    }

}
