package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.util.ArrayList;
import java.util.List;

/**
 * 全銀フォーマット入出金明細用Dto(普通預金・当座預金・貯蓄預金のグループ)
 */
public class TradingZenginFormatTransactionDetailGroup1OrdinalyDto { // NOPMD DataClass

    /** ヘッダレコード */
    private TradingZenginFormatTransactionDetailHeaderRecordDto tradingZenginFormatTransactionDetailHeaderRecordDto;

    /** データレコードリスト */
    private List<TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto> listData = new ArrayList<>();

    /** トレーラレコード */
    private TradingZenginFormatTransactionDetailTrailerRecordDto tradingZenginFormatTransactionDetailTrailerRecordDto;

    /**
     * ヘッダレコードを取得する
     *
     * @return ヘッダレコード
     */
    public TradingZenginFormatTransactionDetailHeaderRecordDto getTradingZenginFormatTransactionDetailHeaderRecordDto() {
        return tradingZenginFormatTransactionDetailHeaderRecordDto;
    }

    /**
     * ヘッダレコードを設定する
     *
     * @param tradingZenginFormatTransactionDetailHeaderRecordDto ヘッダレコード
     */
    public void setTradingZenginFormatTransactionDetailHeaderRecordDto(
            final TradingZenginFormatTransactionDetailHeaderRecordDto tradingZenginFormatTransactionDetailHeaderRecordDto) {
        this.tradingZenginFormatTransactionDetailHeaderRecordDto = tradingZenginFormatTransactionDetailHeaderRecordDto;
    }

    /**
     * Group1データレコードリストを取得する
     *
     * @return Group1データレコードリスト
     */
    public List<TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto> getListData() {
        return listData;
    }

    /**
     * Group1データレコードリストを設定する
     *
     * @param listData Group1データレコードリスト
     */
    public void setListData(final List<TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto> listData) {
        this.listData = listData;
    }

    /**
     * トレーラレコードを取得する
     *
     * @return トレーラレコード
     */
    public TradingZenginFormatTransactionDetailTrailerRecordDto getTradingZenginFormatTransactionDetailTrailerRecordDto() {
        return tradingZenginFormatTransactionDetailTrailerRecordDto;
    }

    /**
     * トレーラレコードを設定する
     *
     * @param tradingZenginFormatTransactionDetailTrailerRecordDto トレーラレコード
     */
    public void setTradingZenginFormatTransactionDetailTrailerRecordDto(
            final TradingZenginFormatTransactionDetailTrailerRecordDto tradingZenginFormatTransactionDetailTrailerRecordDto) {
        this.tradingZenginFormatTransactionDetailTrailerRecordDto = tradingZenginFormatTransactionDetailTrailerRecordDto;
    }

}
