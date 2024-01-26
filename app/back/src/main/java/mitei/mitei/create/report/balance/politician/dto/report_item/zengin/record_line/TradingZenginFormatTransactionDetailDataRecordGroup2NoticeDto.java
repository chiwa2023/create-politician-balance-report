package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 全銀フォーマットCsvでGroup1(通知預金・定期預金・積立定期預金の場合)用データレコード
 */
public class TradingZenginFormatTransactionDetailDataRecordGroup2NoticeDto implements Serializable{

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** データ区分[N1] */
    private Integer dataKbn;
    
    /** 識別番号[N8:前詰め0] */
    private String identificationNo;
    
    /** 勘定日[N6:1桁0あり] */
    private LocalDate accountingDate;
    
    /** 預入・払出日[N6:1桁0あり] */
    private LocalDate depositWithdrawalDate;
    
    /** 入払区分[N1] */
    private Integer deWdKbn;
    
    /** 取引区分[N2] */
    private Integer tradingKbn;
    
    /** 取引金額[N12:前詰め0] */
    private Long transactionAmount;
    
    /** うち他店券金額[N12:前詰め0] */
    private Long otherStoreTicketAmount;
    
    /** 交換呈示日[N6:1桁0あり] */
    private LocalDate exchangePresentationDate;
    
    /** 不渡返還日[N6:1桁0あり] */
    private LocalDate dishonoredReturnDate;
    
    /** 手形・小切手区分[N1:] */
    private Integer billCheckKbn;

    /** 手形・小切手番号[N7:前詰め0] */
    private String billCheckNo;

    /** 僚店番号[N3] */
    private String branchNo;
    
    /** 当初預入日[N6] */
    private LocalDate orginalDate;
    
    /** 利率[N6] */
    private Float interestRate;
    
    /** 満期日[N6] */
    private LocalDate maturityDate;
    
    /** 期間(1)[N7] */
    private String period1;
    
    /** 期間利息[N11] */
    private Long periodInterest;
    
    /** 中間払利率[N3] */
    private Float intermediateInterestRate;
    
    /** 中間払区分[N6] */
    private Integer interimPaymentKbn ;
    
    /** 期後期間[N4] */
    private Integer postPeriod;

    /** 期後利率[N6] */
    private Float postPeriodInterestRate;

    /** 期後利息[N9] */
    private Long postPeriodInterest;

    /** 合計利息[N11] */
    private Long totalInterest;

    /** 税区分[N1] */
    private Integer taxKbn;

    /** 税率[N3] */
    private Float taxRate;

    /** 税額[N4] */
    private Long taxAmount;

    /** 税引後利息[N11] */
    private Long afterTaxInterest;

    /** 摘要内容[C20] */
    private String abstractContent;

    /** 期間（2）[N5] */
    private String period2;

    /** 期間利息正負表示[N3] */
    private Integer periodicInterestKbn ;

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
     * 勘定日を取得する
     *
     * @return 勘定日
     */
    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    /**
     * 勘定日を設定する
     *
     * @param accountingDate 勘定日
     */
    public void setAccountingDate(final LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    /**
     * 預入・払出日を取得する
     *
     * @return 預入・払出日
     */
    public LocalDate getDepositWithdrawalDate() {
        return depositWithdrawalDate;
    }

    /**
     * 預入・払出日を設定する
     *
     * @param depositWithdrawalDate 預入・払出日
     */
    public void setDepositWithdrawalDate(final LocalDate depositWithdrawalDate) {
        this.depositWithdrawalDate = depositWithdrawalDate;
    }

    /**
     * 入払区分を取得する
     *
     * @return 入払区分
     */
    public Integer getDeWdKbn() {
        return deWdKbn;
    }

    /**
     * 入払区分を設定する
     *
     * @param deWdKbn 入払区分
     */
    public void setDeWdKbn(final Integer deWdKbn) {
        this.deWdKbn = deWdKbn;
    }

    /**
     * 取引区分を取得する
     *
     * @return 取引区分
     */
    public Integer getTradingKbn() {
        return tradingKbn;
    }

    /**
     * 取引区分を設定する
     *
     * @param tradingKbn 取引区分
     */
    public void setTradingKbn(final Integer tradingKbn) {
        this.tradingKbn = tradingKbn;
    }

    /**
     * 取引金額を取得する
     *
     * @return 取引金額
     */
    public Long getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * 取引金額を設定する
     *
     * @param transactionAmount 取引金額
     */
    public void setTransactionAmount(final Long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    /**
     * うち他店券金額を取得する
     *
     * @return うち他店券金額
     */
    public Long getOtherStoreTicketAmount() {
        return otherStoreTicketAmount;
    }

    /**
     * うち他店券金額を設定する
     *
     * @param otherStoreTicketAmount うち他店券金額
     */
    public void setOtherStoreTicketAmount(final Long otherStoreTicketAmount) {
        this.otherStoreTicketAmount = otherStoreTicketAmount;
    }

    /**
     * 交換呈示日を取得する
     *
     * @return 交換呈示日
     */
    public LocalDate getExchangePresentationDate() {
        return exchangePresentationDate;
    }

    /**
     * 交換呈示日を設定する
     *
     * @param exchangePresentationDate 交換呈示日
     */
    public void setExchangePresentationDate(final LocalDate exchangePresentationDate) {
        this.exchangePresentationDate = exchangePresentationDate;
    }

    /**
     * 不渡返還日を取得する
     *
     * @return 不渡返還日
     */
    public LocalDate getDishonoredReturnDate() {
        return dishonoredReturnDate;
    }

    /**
     * 不渡返還日を設定する
     *
     * @param dishonoredReturnDate 不渡返還日
     */
    public void setDishonoredReturnDate(final LocalDate dishonoredReturnDate) {
        this.dishonoredReturnDate = dishonoredReturnDate;
    }

    /**
     * 手形・小切手区分を取得する
     *
     * @return 手形・小切手区分
     */
    public Integer getBillCheckKbn() {
        return billCheckKbn;
    }

    /**
     * 手形・小切手区分を設定する
     *
     * @param billCheckKbn 手形・小切手区分
     */
    public void setBillCheckKbn(final Integer billCheckKbn) {
        this.billCheckKbn = billCheckKbn;
    }

    /**
     * 手形・小切手番号を取得する
     *
     * @return 手形・小切手番号
     */
    public String getBillCheckNo() {
        return billCheckNo;
    }

    /**
     * 手形・小切手番号を設定する
     *
     * @param billCheckNo 手形・小切手番号
     */
    public void setBillCheckNo(final String billCheckNo) {
        this.billCheckNo = billCheckNo;
    }

    /**
     * 僚店番号を取得する
     *
     * @return 僚店番号
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * 僚店番号を設定する
     *
     * @param branchNo 僚店番号
     */
    public void setBranchNo(final String branchNo) {
        this.branchNo = branchNo;
    }

    
    
    
    
    /**
     * 識別番号を取得する
     *
     * @return 識別番号
     */
    public String getIdentificationNo() {
        return identificationNo;
    }

    /**
     * 識別番号を設定する
     *
     * @param identificationNo 識別番号
     */
    public void setIdentificationNo(final String identificationNo) {
        this.identificationNo = identificationNo;
    }

    /**
     * 当初預入日を取得する
     *
     * @return 当初預入日
     */
    public LocalDate getOrginalDate() {
        return orginalDate;
    }

    /**
     * 当初預入日を設定する
     *
     * @param orginalDate 当初預入日
     */
    public void setOrginalDate(final LocalDate orginalDate) {
        this.orginalDate = orginalDate;
    }

    /**
     * 利率を取得する
     *
     * @return 利率
     */
    public Float getInterestRate() {
        return interestRate;
    }

    /**
     * 利率を設定する
     *
     * @param interestRate 利率
     */
    public void setInterestRate(final Float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * 満期日を取得する
     *
     * @return 満期日
     */
    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    /**
     * 満期日を設定する
     *
     * @param maturityDate 満期日
     */
    public void setMaturityDate(final LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    /**
     * 期間(1)を取得する
     *
     * @return 期間(1)
     */
    public String getPeriod1() {
        return period1;
    }

    /**
     * 期間(1)を設定する
     *
     * @param period1 期間(1)
     */
    public void setPeriod1(final String period1) {
        this.period1 = period1;
    }

    /**
     * 期間利息を取得する
     *
     * @return 期間利息
     */
    public Long getPeriodInterest() {
        return periodInterest;
    }

    /**
     * 期間利息を設定する
     *
     * @param periodInterest 期間利息
     */
    public void setPeriodInterest(final Long periodInterest) {
        this.periodInterest = periodInterest;
    }

    /**
     * 中間払利率を取得する
     *
     * @return 中間払利率
     */
    public Float getIntermediateInterestRate() {
        return intermediateInterestRate;
    }

    /**
     * 中間払利率を設定する
     *
     * @param intermediateInterestRate 中間払利率
     */
    public void setIntermediateInterestRate(final Float intermediateInterestRate) {
        this.intermediateInterestRate = intermediateInterestRate;
    }

    /**
     * 中間払区分を取得する
     *
     * @return 中間払区分
     */
    public Integer getInterimPaymentKbn() {
        return interimPaymentKbn;
    }

    /**
     * 中間払区分を設定する
     *
     * @param interimPaymentKbn 中間払区分
     */
    public void setInterimPaymentKbn(final Integer interimPaymentKbn) {
        this.interimPaymentKbn = interimPaymentKbn;
    }

    /**
     * 期後期間を取得する
     *
     * @return 期後期間
     */
    public Integer getPostPeriod() {
        return postPeriod;
    }

    /**
     * 期後期間を設定する
     *
     * @param postPeriod 期後期間
     */
    public void setPostPeriod(final Integer postPeriod) {
        this.postPeriod = postPeriod;
    }

    /**
     * 期後利率を取得する
     *
     * @return 期後利率
     */
    public Float getPostPeriodInterestRate() {
        return postPeriodInterestRate;
    }

    /**
     * 期後利率を設定する
     *
     * @param postPeriodInterestRate 期後利率
     */
    public void setPostPeriodInterestRate(final Float postPeriodInterestRate) {
        this.postPeriodInterestRate = postPeriodInterestRate;
    }

    /**
     * 期後利息を取得する
     *
     * @return 期後利息
     */
    public Long getPostPeriodInterest() {
        return postPeriodInterest;
    }

    /**
     * 期後利息を設定する
     *
     * @param postPeriodInterest 期後利息
     */
    public void setPostPeriodInterest(final Long postPeriodInterest) {
        this.postPeriodInterest = postPeriodInterest;
    }

    /**
     * 合計利息を取得する
     *
     * @return 合計利息
     */
    public Long getTotalInterest() {
        return totalInterest;
    }

    /**
     * 合計利息を設定する
     *
     * @param totalInterest 合計利息
     */
    public void setTotalInterest(final Long totalInterest) {
        this.totalInterest = totalInterest;
    }

    /**
     * 税区分を取得する
     *
     * @return 税区分
     */
    public Integer getTaxKbn() {
        return taxKbn;
    }

    /**
     * 税区分を設定する
     *
     * @param taxKbn 税区分
     */
    public void setTaxKbn(final Integer taxKbn) {
        this.taxKbn = taxKbn;
    }

    /**
     * 税率を取得する
     *
     * @return 税率
     */
    public Float getTaxRate() {
        return taxRate;
    }

    /**
     * 税率を設定する
     *
     * @param taxRate 税率
     */
    public void setTaxRate(final Float taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * 税額を取得する
     *
     * @return 税額
     */
    public Long getTaxAmount() {
        return taxAmount;
    }

    /**
     * 税額を設定する
     *
     * @param taxAmount 税額
     */
    public void setTaxAmount(final Long taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * 税引後利息を取得する
     *
     * @return 税引後利息
     */
    public Long getAfterTaxInterest() {
        return afterTaxInterest;
    }

    /**
     * 税引後利息を設定する
     *
     * @param afterTaxInterest 税引後利息
     */
    public void setAfterTaxInterest(final Long afterTaxInterest) {
        this.afterTaxInterest = afterTaxInterest;
    }

    /**
     * 摘要内容を取得する
     *
     * @return 摘要内容
     */
    public String getAbstractContent() {
        return abstractContent;
    }

    /**
     * 摘要内容を設定する
     *
     * @param abstractContent 摘要内容
     */
    public void setAbstractContent(final String abstractContent) {
        this.abstractContent = abstractContent;
    }

    /**
     * 期間（2）を取得する
     *
     * @return 期間（2）
     */
    public String getPeriod2() {
        return period2;
    }

    /**
     * 期間（2）を設定する
     *
     * @param period2 期間（2）
     */
    public void setPeriod2(final String period2) {
        this.period2 = period2;
    }

    /**
     * 期間利息正負表示を取得する
     *
     * @return 期間利息正負表示
     */
    public Integer getPeriodicInterestKbn() {
        return periodicInterestKbn;
    }

    /**
     * 期間利息正負表示を設定する
     *
     * @param periodicInterestKbn 期間利息正負表示
     */
    public void setPeriodicInterestKbn(final Integer periodicInterestKbn) {
        this.periodicInterestKbn = periodicInterestKbn;
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
