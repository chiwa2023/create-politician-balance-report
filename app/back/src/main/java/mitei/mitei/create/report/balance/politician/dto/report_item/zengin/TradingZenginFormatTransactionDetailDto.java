package mitei.mitei.create.report.balance.politician.dto.report_item.zengin;

import java.util.ArrayList;
import java.util.List;

import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailEndRecordDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup1OrdinalyDto;
import mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line.TradingZenginFormatTransactionDetailGroup2NoticeDto;

/**
 * 全銀フォーマット入出金明細用Dto
 */
public class TradingZenginFormatTransactionDetailDto { // NOPMD DataClass

    /** Group1(普通預金など)データリスト */
    private List<TradingZenginFormatTransactionDetailGroup1OrdinalyDto> listGroup1 = new ArrayList<>();

    /** Group2(通知預金など)データリスト */
    private List<TradingZenginFormatTransactionDetailGroup2NoticeDto> listGroup2 = new ArrayList<>();

    /** エンドレコード */
    private TradingZenginFormatTransactionDetailEndRecordDto tradingZenginFormatTransactionDetailEndRecordDto;

    /**
     * Group1明細データレコードリストを取得する
     *
     * @return Group1明細データレコードリスト
     */
    public List<TradingZenginFormatTransactionDetailGroup1OrdinalyDto> getListGroup1() {
        return listGroup1;
    }

    /**
     * Group1明細データレコードリストを設定する
     *
     * @param listGroup1 Group1明細データレコードリスト
     */
    public void setListGroup1(final List<TradingZenginFormatTransactionDetailGroup1OrdinalyDto> listGroup1) {
        this.listGroup1 = listGroup1;
    }

    /**
     * Group2明細データレコードリストを取得する
     *
     * @return Group2明細データレコードリスト
     */
    public List<TradingZenginFormatTransactionDetailGroup2NoticeDto> getListGroup2() {
        return listGroup2;
    }

    /**
     * Group2明細データレコードリストを設定する
     *
     * @param listGroup2 Group2明細データレコードリスト
     */
    public void setListGroup2(final List<TradingZenginFormatTransactionDetailGroup2NoticeDto> listGroup2) {
        this.listGroup2 = listGroup2;
    }

    /**
     * 入出金明細エンドレコードを取得する
     *
     * @return 入出金明細エンドレコード
     */
    public TradingZenginFormatTransactionDetailEndRecordDto getTradingZenginFormatTransactionDetailEndRecordDto() {
        return tradingZenginFormatTransactionDetailEndRecordDto;
    }

    /**
     * 入出金明細エンドレコードを設定する
     *
     * @param tradingZenginFormatTransactionDetailEndRecordDto 入出金明細エンドレコード
     */
    public void setTradingZenginFormatTransactionDetailEndRecordDto(
            final TradingZenginFormatTransactionDetailEndRecordDto tradingZenginFormatTransactionDetailEndRecordDto) {
        this.tradingZenginFormatTransactionDetailEndRecordDto = tradingZenginFormatTransactionDetailEndRecordDto;
    }

}
