package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 全銀フォーマットCsvでGroup1(普通預金・当座預金・貯蓄預金の場合)用データレコード
 */
public class TradingZenginFormatTransactionDetailDataRecordGroup1OrdinalyDto implements Serializable { // NOPMD DataClass
    
    /** serialId */
    private static final long serialVersionUID = 1L;

    /** データ区分[N1] */
    private Integer dataKbn;
    
    /** 照会番号[N8:前詰め0] */
    private String referNo;
    
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
    
    /** 振込依頼人コード[N10:前詰め0] */
    private String transferRequesterCode;
    
    /** 依頼人名または契約者番号[C48] */
    private String tradingDetail;
       
    /** 仕向銀行名[C15] */
    private String sendingBankName;
    
    /** 仕向店名[C15] */
    private String sendingBankBranchName;
    
    /** 摘要内容[C20] */
    private String abstractContent;
    
    /** EDI情報[C20] */
    private String ediInfo;

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
     * 照会番号を取得する
     *
     * @return 照会番号
     */
    public String getReferNo() {
        return referNo;
    }

    /**
     * 照会番号を設定する
     *
     * @param referNo 照会番号
     */
    public void setReferNo(final String referNo) {
        this.referNo = referNo;
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
     * 振込依頼人コードを取得する
     *
     * @return 振込依頼人コード
     */
    public String getTransferRequesterCode() {
        return transferRequesterCode;
    }

    /**
     * 振込依頼人コードを設定する
     *
     * @param transferRequesterCode 振込依頼人コード
     */
    public void setTransferRequesterCode(final String transferRequesterCode) {
        this.transferRequesterCode = transferRequesterCode;
    }

    /**
     * 依頼人名または契約者番号を取得する
     *
     * @return 依頼人名または契約者番号
     */
    public String getTradingDetail() {
        return tradingDetail;
    }

    /**
     * 依頼人名または契約者番号を設定する
     *
     * @param tradingDetail 依頼人名または契約者番号
     */
    public void setTradingDetail(final String tradingDetail) {
        this.tradingDetail = tradingDetail;
    }

    /**
     * 仕向銀行名を取得する
     *
     * @return 仕向銀行名
     */
    public String getSendingBankName() {
        return sendingBankName;
    }

    /**
     * 仕向銀行名を設定する
     *
     * @param sendingBankName 仕向銀行名
     */
    public void setSendingBankName(final String sendingBankName) {
        this.sendingBankName = sendingBankName;
    }

    /**
     * 仕向店名を取得する
     *
     * @return 仕向店名
     */
    public String getSendingBankBranchName() {
        return sendingBankBranchName;
    }

    /**
     * 仕向店名を設定する
     *
     * @param sendingBankBranchName 仕向店名
     */
    public void setSendingBankBranchName(final String sendingBankBranchName) {
        this.sendingBankBranchName = sendingBankBranchName;
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
     * EDI情報を取得する
     *
     * @return EDI情報
     */
    public String getEdiInfo() {
        return ediInfo;
    }

    /**
     * EDI情報を設定する
     *
     * @param ediInfo EDI情報
     */
    public void setEdiInfo(final String ediInfo) {
        this.ediInfo = ediInfo;
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
