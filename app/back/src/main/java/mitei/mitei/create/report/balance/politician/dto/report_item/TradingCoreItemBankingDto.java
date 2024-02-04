package mitei.mitei.create.report.balance.politician.dto.report_item;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 銀行入出金を情報を表すDto
 */
public class TradingCoreItemBankingDto implements Serializable { // NOPMD DataClass

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

    /** 金融機関番号(全銀統一コード) */
    private String financialInstitutionNo;

    /** 金融機関名称 */
    private String financialInstitutionName;

    /** 僚店番号(支店番号) */
    private String branchNo;

    /** 支店名 */
    private String branchName;

    /** 口座区分 */
    private Integer accountKbn;

    /** 口座区分 */
    private String accountKbnName;

    /** 口座番号 */
    private String accountNo;

    /** 口座名義 */
    private String accountHolderName;

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
     * 入出金区分を取得する
     *
     * @return 入出金区分
     */
    public Integer getDeWdKbn() {
        return deWdKbn;
    }

    /**
     * 入出金区分を設定する
     *
     * @param deWdKbn 入出金区分
     */
    public void setDeWdKbn(final Integer deWdKbn) {
        this.deWdKbn = deWdKbn;
    }

    /**
     * 処理日を取得する
     *
     * @return 処理日
     */
    public LocalDate getAccountingDate() {
        return accountingDate;
    }

    /**
     * 処理日を設定する
     *
     * @param accountingDate 処理日
     */
    public void setAccountingDate(final LocalDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    /**
     * 取引明細を取得する
     *
     * @return 取引明細
     */
    public String getTradingDetail() {
        return tradingDetail;
    }

    /**
     * 取引明細を設定する
     *
     * @param tradingDetail 取引明細
     */
    public void setTradingDetail(final String tradingDetail) {
        this.tradingDetail = tradingDetail;
    }

    /**
     * 金融機関番号を取得する
     *
     * @return 金融機関番号
     */
    public String getFinancialInstitutionNo() {
        return financialInstitutionNo;
    }

    /**
     * 金融機関番号を設定する
     *
     * @param financialInstitutionNo 金融機関番号
     */
    public void setFinancialInstitutionNo(final String financialInstitutionNo) {
        this.financialInstitutionNo = financialInstitutionNo;
    }

    /**
     * 金融機関名称を取得する
     *
     * @return 金融機関名称
     */
    public String getFinancialInstitutionName() {
        return financialInstitutionName;
    }

    /**
     * 金融機関名称を設定する
     *
     * @param financialInstitutionName 金融機関名称
     */
    public void setFinancialInstitutionName(final String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
    }

    /**
     * 支店番号を取得する
     *
     * @return 支店番号
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * 支店番号を設定する
     *
     * @param branchNo 支店番号
     */
    public void setBranchNo(final String branchNo) {
        this.branchNo = branchNo;
    }

    /**
     * 支店名称を取得する
     *
     * @return 支店名称
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 支店名称を設定する
     *
     * @param branchName 支店名称
     */
    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }
    
    /**
     * 口座種目を取得する
     *
     * @return 口座種目
     */
    public Integer getAccountKbn() {
        return accountKbn;
    }

    /**
     * 口座種目を設定する
     *
     * @param accountKbn 口座種目
     */
    public void setAccountKbn(final Integer accountKbn) {
        this.accountKbn = accountKbn;
    }

    /**
     * 口座種目名称を取得する
     *
     * @return 口座種目名称
     */
    public String getAccountKbnName() {
        return accountKbnName;
    }

    /**
     * 口座種目名称を設定する
     *
     * @param accountKbnName 口座種目名称
     */
    public void setAccountKbnName(final String accountKbnName) {
        this.accountKbnName = accountKbnName;
    }

    /**
     * 口座番号を取得する
     *
     * @return 口座番号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 口座番号を設定する
     *
     * @param accountNo 口座番号
     */
    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 口座名義人を取得する
     *
     * @return 口座名義人
     */
    public String getAccountHolderName() {
        return accountHolderName;
    }

    /**
     * 口座名義人を設定する
     *
     * @param accountHolderName 口座名義人
     */
    public void setAccountHolderName(final String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

}
