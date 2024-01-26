package mitei.mitei.create.report.balance.politician.dto.report_item;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 取引コア情報
 */
public class TradingCoreItemDto implements Serializable,TradingCoreDataItemInterface{ // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** 取引金額 */
    private Long transactionAmount;

    /** 入出金区分 */
    private Integer deWdKbn;

    /** 処理日 */
    private LocalDate accountingDate;
    
    /** 処理明細(自由記述) */
    private String tradingDetail;

    /**
     * 取引金額を取得する
     */
    @Override
    public Long getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * 取引金額を設定する
     *
     * @param transactionAmount 取引金額
     */
    @Override
    public void setTransactionAmount(final Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * 入出金区分を取得する
     *
     * @return 入出金区分
     */
    @Override
    public Integer getDeWdKbn() {
        return deWdKbn;
    }

    /**
     * 入出金区分を設定する
     *
     * @param deWdKbn 入出金区分
     */
    @Override
    public void setDeWdKbn(final Integer deWdKbn) {
        this.deWdKbn = deWdKbn;
    }

    /**
     * 処理日を取得する
     *
     * @return 処理日
     */
    @Override
    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    /**
     * 処理日を設定する
     *
     * @param accountingDate 処理日
     */
    @Override
    public void setAccountingDate(final LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    /**
     * 取引明細を取得する
     *
     * @return 取引明細
     */
    @Override
    public String getTradingDetail() {
        return tradingDetail;
    }

    /**
     * 取引明細を設定する
     *
     * @param tradingDetail 取引明細
     */
    @Override
    public void setTradingDetail(final String tradingDetail) {
        this.tradingDetail = tradingDetail;
    }

    
}
