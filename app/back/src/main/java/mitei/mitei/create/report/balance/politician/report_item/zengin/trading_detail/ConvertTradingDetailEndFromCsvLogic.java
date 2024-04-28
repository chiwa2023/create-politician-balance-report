package mitei.mitei.create.report.balance.politician.report_item.zengin.trading_detail;

import org.springframework.stereotype.Component;

import mitei.mitei.create.report.balance.politician.dto.report_item.ZenginFormatRecordPosConstants.PosTransactionDetailEnd;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailEndRecordDto;

/**
 * 全銀フォーマット入出金明細のエンドレコードに変換する
 */
@Component
public class ConvertTradingDetailEndFromCsvLogic {

    /**
     * エンドレコードに変換する
     *
     * @param cell csvの各セル
     * @return ヘッダレコード
     */
    public TradingZenginFormatTransactionDetailEndRecordDto practice(final String[] cell) { // NOPMD

        TradingZenginFormatTransactionDetailEndRecordDto dto = new TradingZenginFormatTransactionDetailEndRecordDto();

        // データ区分の格納位置
        dto.setDataKbn(Integer.parseInt(cell[PosTransactionDetailEnd.DATA_KBN]));

        // レコード総件数の格納位置
        dto.setCountRecord(Long.parseLong(cell[PosTransactionDetailEnd.COUNT_RECORD]));

        // 口座数の格納位置
        dto.setCountAccount(Integer.parseInt(cell[PosTransactionDetailEnd.COUNT_ACCOUNT]));

        // ダミーの格納位置
        dto.setDummyEnd(cell[PosTransactionDetailEnd.DUMMY_END].trim());

        return dto;
    }
}
