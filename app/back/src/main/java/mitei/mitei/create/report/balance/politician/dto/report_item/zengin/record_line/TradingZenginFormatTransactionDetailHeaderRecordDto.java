package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 全銀フォーマット入出金明細Csvヘッダ・レコード
 */
public class TradingZenginFormatTransactionDetailHeaderRecordDto implements Serializable {  // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** データ区分[1] */
    private Integer dataKbn;
    
    /** 種別コード[2] */
    private String businessType;
    
    /** コード区分[1] */
    private Integer codeKbn;
    
    /** 作成日[6] */
    private LocalDate dateMaking;
    
    /** 勘定日(自)[6] */
    private LocalDate dateFromRef;
    
    /** 勘定日(至)[6] */
    private LocalDate dateToRef;
    
    /** 銀行コード[4] */
    private String bankNo;
    
    /** 銀行名[15] */
    private String bankName;
    
    /** 支店コード[3] */
    private String branchNo;
    
    /** 支店名[15] */
    private String branchName;
    
    /** ダミー[3] */
    private String dummy;
    
    /** 預金種目[1] */
    private Integer depositType;
   
    /** 口座番号[10] */
    private String accountNo;
    
    /** 口座名[40] */
    private String accountName;
    
    /** 貸越区分[1] */
    private Integer overdraftKbn;
    
    /** 通帳・証書区分[1] */
    private Long passbookKbn;
    
    /** 取引前残高[14] */
    private Long preTransactionBalance;
    
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
     * 種別コードを取得する
     *
     * @return 種別コード
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 種別コードを設定する
     *
     * @param businessType 種別コード
     */
    public void setBusinessType(final String businessType) {
        this.businessType = businessType;
    }

    /**
     * コード区分を取得する
     *
     * @return コード区分
     */
    public Integer getCodeKbn() {
        return codeKbn;
    }

    /**
     * コード区分を設定する
     *
     * @param codeKbn コード区分
     */
    public void setCodeKbn(final Integer codeKbn) {
        this.codeKbn = codeKbn;
    }

    /**
     * 作成日を取得する
     *
     * @return 作成日
     */
    public LocalDate getDateMaking() {
        return dateMaking;
    }

    /**
     * 作成日を設定する
     *
     * @param dateMaking 作成日
     */
    public void setDateMaking(final LocalDate dateMaking) {
        this.dateMaking = dateMaking;
    }

    /**
     * 勘定日(自)を取得する
     *
     * @return 勘定日(自)
     */
    public LocalDate getDateFromRef() {
        return dateFromRef;
    }

    /**
     * 勘定日(自)を設定する
     *
     * @param dateFromRef 勘定日(自)
     */
    public void setDateFromRef(final LocalDate dateFromRef) {
        this.dateFromRef = dateFromRef;
    }

    /**
     * 勘定日(至)を取得する
     *
     * @return 勘定日(至)
     */
    public LocalDate getDateToRef() {
        return dateToRef;
    }

    /**
     * 勘定日(至)を設定する
     *
     * @param dateToRef 勘定日(至)
     */
    public void setDateToRef(final LocalDate dateToRef) {
        this.dateToRef = dateToRef;
    }

    /**
     * 銀行コードを取得する
     *
     * @return 銀行コード
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 銀行コードを設定する
     *
     * @param bankNo 銀行コード
     */
    public void setBankNo(final String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     * 銀行名を取得する
     *
     * @return 銀行名
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 銀行名を設定する
     *
     * @param bankName 銀行名
     */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /**
     * 支店コードを取得する
     *
     * @return 支店コード
     */
    public String getBranchNo() {
        return branchNo;
    }

    /**
     * 支店コードを設定する
     *
     * @param branchNo 支店コード
     */
    public void setBranchNo(final String branchNo) {
        this.branchNo = branchNo;
    }

    /**
     * 支店名を取得する
     *
     * @return 支店名
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 支店名を設定する
     *
     * @param branchName 支店名
     */
    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    /**
     * ダミーを取得する
     *
     * @return ダミー
     */
    public String getDummy() {
        return dummy;
    }

    /**
     * ダミーを設定する
     *
     * @param dummy ダミー
     */
    public void setDummy(final String dummy) {
        this.dummy = dummy;
    }

    /**
     * 預金種目を取得する
     *
     * @return 預金種目
     */
    public Integer getDepositType() {
        return depositType;
    }

    /**
     * 預金種目を設定する
     *
     * @param depositType 預金種目
     */
    public void setDepositType(final Integer depositType) {
        this.depositType = depositType;
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
     * 口座名を取得する
     *
     * @return 口座名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 口座名を設定する
     *
     * @param accountName 口座名
     */
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
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
     * 通帳・証書区分を取得する
     *
     * @return 通帳・証書区分
     */
    public Long getPassbookKbn() {
        return passbookKbn;
    }

    /**
     * 通帳・証書区分を設定する
     *
     * @param passbookKbn 通帳・証書区分
     */
    public void setPassbookKbn(final Long passbookKbn) {
        this.passbookKbn = passbookKbn;
    }

    /**
     * 取引前残高を取得する
     *
     * @return 取引前残高
     */
    public Long getPreTransactionBalance() {
        return preTransactionBalance;
    }

    /**
     * 取引前残高を設定する
     *
     * @param preTransactionBalance 取引前残高
     */
    public void setPreTransactionBalance(final Long preTransactionBalance) {
        this.preTransactionBalance = preTransactionBalance;
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
