package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.io.Serializable;

/**
 * 全銀フォーマットCsvトレーラ・レコード
 */
public class TradingZenginFormatTransactionDetailTrailerRecordDto implements Serializable { // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** データ区分[1] */
    private Integer dataKbn;

    /** 入金件数[6] */
    private Integer countIncome;

    /** 入金額合計[13] */
    private Long sumIncome;

    /** 出金件数[6] */
    private Integer countOutcome;

    /** 出金額合計[13] */
    private Long sumOutcome;

    /** 貸越区分[1] */
    private Integer overdraftKbn;

    /** 取引後残高[14] */
    private Long balanceAfterTransaction;

    /** データ・レコード件数[7] */
    private Integer countData;

    /** ダミー[5] */
    private String dummyEnd;

    /**
     * データ区分を取得する
     *
     * @return データ区分
     */
    public Integer getDataKbn() {
        return dataKbn;
    }

    /**
     * データ区分を設定する
     *
     * @param dataKbn データ区分
     */
    public void setDataKbn(final Integer dataKbn) {
        this.dataKbn = dataKbn;
    }

    /**
     * 入金件数を取得する
     *
     * @return 入金件数
     */
    public Integer getCountIncome() {
        return countIncome;
    }

    /**
     * 入金件数を設定する
     *
     * @param countIncome 入金件数
     */
    public void setCountIncome(final Integer countIncome) {
        this.countIncome = countIncome;
    }

    /**
     * 入金額合計を取得する
     *
     * @return 入金額合計
     */
    public Long getSumIncome() {
        return sumIncome;
    }

    /**
     * 入金額合計を設定する
     *
     * @param sumIncome 入金額合計
     */
    public void setSumIncome(final Long sumIncome) {
        this.sumIncome = sumIncome;
    }

    /**
     * 出金件数を取得する
     *
     * @return 出金件数
     */
    public Integer getCountOutcome() {
        return countOutcome;
    }

    /**
     * 出金件数を設定する
     *
     * @param countOutcome 出金件数
     */
    public void setCountOutcome(final Integer countOutcome) {
        this.countOutcome = countOutcome;
    }

    /**
     * 出金額合計を取得する
     *
     * @return 出金額合計
     */
    public Long getSumOutcome() {
        return sumOutcome;
    }

    /**
     * 出金額合計を設定する
     *
     * @param sumOutcome 出金額合計
     */
    public void setSumOutcome(final Long sumOutcome) {
        this.sumOutcome = sumOutcome;
    }

    /**
     * 貸越区分を取得する
     *
     * @return 貸越区分
     */
    public Integer getOverdraftKbn() {
        return overdraftKbn;
    }

    /**
     * 貸越区分を設定する
     *
     * @param overdraftKbn 貸越区分
     */
    public void setOverdraftKbn(final Integer overdraftKbn) {
        this.overdraftKbn = overdraftKbn;
    }

    /**
     * 取引後残高を取得する
     *
     * @return 取引後残高
     */
    public Long getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    /**
     * 取引後残高を設定する
     *
     * @param balanceAfterTransaction 取引後残高
     */
    public void setBalanceAfterTransaction(final Long balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    /**
     * データ・レコード件数を取得する
     *
     * @return データ・レコード件数
     */
    public Integer getCountData() {
        return countData;
    }

    /**
     * データ・レコード件数を設定する
     *
     * @param countData データ・レコード件数
     */
    public void setCountData(final Integer countData) {
        this.countData = countData;
    }

    /**
     * ダミーを取得する
     *
     * @return ダミー
     */
    public String getDummyEnd() {
        return dummyEnd;
    }

    /**
     * ダミーを設定する
     *
     * @param dummyEnd ダミー
     */
    public void setDummyEnd(final String dummyEnd) {
        this.dummyEnd = dummyEnd;
    }
    
    
}
