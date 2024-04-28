package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailTrailer;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailTrailerRecordDto;

/**
 * 全銀フォーマット入出金明細のトレーラレコードに変換する
 */
@Component
public class ConvertTradingDetailTrailerFromCsvLogic {
    /** 半角スペース */
    private static final String charHalfSpace = " ";

    /**
     * トレーラレコードに変換する
     *
     * @param cell csvの各セル
     * @return トレーラレコード
     */
    public TradingZenginFormatTransactionDetailTrailerRecordDto practice(final String[] cell) { // NOPMD
        
        TradingZenginFormatTransactionDetailTrailerRecordDto dto = new TradingZenginFormatTransactionDetailTrailerRecordDto();
        
        // データ区分の格納位置
        dto.setDataKbn(Integer.parseInt(cell[PosTransactionDetailTrailer.DATA_KBN]));

        // 入金件数の格納位置 
        dto.setCountIncome(Integer.parseInt(cell[PosTransactionDetailTrailer.COUNT_INCOME]));

        // 入金額合計の格納位置 
        dto.setSumIncome(Long.parseLong(cell[PosTransactionDetailTrailer.SUM_INCOME]));

        // 出金件数の格納位置 
        dto.setCountOutcome(Integer.parseInt(cell[PosTransactionDetailTrailer.COUNT_OUTCOME]));

        // 出金額合計の格納位置 
        dto.setSumOutcome(Long.parseLong(cell[PosTransactionDetailTrailer.SUM_OUTCOME]));

        // 貸越区分の格納位置 
        dto.setOverdraftKbn(this.parseInt(cell[PosTransactionDetailTrailer.OVERDRAFT_KBN]));

        // 取引後残高の格納位置 
        dto.setBalanceAfterTransaction(this.parseLong(cell[PosTransactionDetailTrailer.BALANCE_AFTER_TRANSACTION]));

        // データ・レコード件数の格納位置 
        dto.setCountData(Integer.parseInt(cell[PosTransactionDetailTrailer.COUNT_DATA]));

        // ダミーの格納位置 
        dto.setDummyEnd(cell[PosTransactionDetailTrailer.DUMMY_END].trim());
        
        return dto;
    }

    private Integer parseInt(final String data) {
        // 半角スペースは入力省略
        if(charHalfSpace.equals(data)) {
            return null;
        }
        
        return Integer.parseInt(data);
    }


    private Long parseLong(final String data) {
        // 半角スペースは入力省略
        if(charHalfSpace.equals(data)) {
            return null;
        }
        
        return Long.parseLong(data);
    }


}
