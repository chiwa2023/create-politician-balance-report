package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.util.ArrayList;
import java.util.List;

/**
 * 全銀フォーマット入出金明細用Dto(通知預金・定期預金・積立定期預金のグループ)
 */
public class TradingZenginFormatTransactionDetailGroup2NoticeDto {  // NOPMD DataClass

    /** ヘッダレコード */
    private TradingZenginFormatTransactionDetailHeaderRecordDto tradingZenginFormatTransactionDetailHeaderRecordDto;

    /** データレコードリスト */
    private List<TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto> listData = new ArrayList<>();

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
     * 明細Group2データレコードリストを取得する
     *
     * @return 明細Group2データレコードリスト
     */
    public List<TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto> getListData() {
        return listData;
    }

    /**
     * 明細Group2データレコードリストを設定する
     *
     * @param listData 明細Group2データレコードリスト
     */
    public void setListData(final List<TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto> listData) {
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
