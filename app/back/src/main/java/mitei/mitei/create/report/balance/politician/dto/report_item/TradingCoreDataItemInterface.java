package mitei.mitei.create.report.balance.politician.dto.report_item;

import java.time.LocalDate;

/**
 * 取引関係を表現する核となる情報Dto
 */
public interface TradingCoreDataItemInterface {

    /**
     * 取引金額を取得する
     *
     * @return 取引金額
     */
    Long getTransactionAmount();

    /**
     * 取引金額を設定する
     *
     * @param transactionAmount 取引金額
     */
    void setTransactionAmount(Long transactionAmount);

    /**
     * 入出金区分を取得する
     *
     * @return 入出金区分
     */
    Integer getDeWdKbn();

    /**
     * 入出金区分を設定する
     *
     * @param deWdKbn 入出金区分
     */
    void setDeWdKbn(Integer deWdKbn);

    /**
     * 処理日を取得する
     *
     * @return 処理日
     */
    LocalDate getAccountingDate();

    /**
     * 処理日を設定する
     *
     * @param accountingDate 処理日
     */
    void setAccountingDate(LocalDate accountingDate);

    /**
     * 取引明細を取得する
     *
     * @return 取引明細
     */
    String getTradingDetail();

    /**
     * 取引明細を設定する
     *
     * @param tradingDetail 取引明細
     */
    void setTradingDetail(String tradingDetail);

}
