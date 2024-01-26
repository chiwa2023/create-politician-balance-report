package mitei.mitei.create.report.balance.politician.dto.report_item.zengin.record_line;

import java.io.Serializable;

/**
 * 全銀フォーマットCsvエンド・レコード
 */
public class TradingZenginFormatTransactionDetailEndRecordDto implements Serializable {  // NOPMD DataClass

    /** serialId */
    private static final long serialVersionUID = 1L;

    /** データ区分[1] */
    private Integer dataKbn;
    
    /** レコード総件数[10] */
    private Long countRecord;
    
    /** 口座数[5] */
    private Integer countAccount;
    
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
     * レコード総件数を取得する
     *
     * @return レコード総件数
     */
    public Long getCountRecord() {
        return countRecord;
    }

    /**
     * レコード総件数を設定する
     *
     * @param countRecord レコード総件数
     */
    public void setCountRecord(final Long countRecord) {
        this.countRecord = countRecord;
    }

    /**
     * 口座数を取得する
     *
     * @return 口座数
     */
    public Integer getCountAccount() {
        return countAccount;
    }

    /**
     * 口座数を設定する
     *
     * @param countAccount 口座数
     */
    public void setCountAccount(final Integer countAccount) {
        this.countAccount = countAccount;
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
