package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

/** 
 * various_financial_pay接続用Entity
 */
@Entity
@Table(name = "various_financial_pay")
public class VariousFinancialPayEntity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 更新時間 */
    private Timestamp updateTime;

    /**
     * 更新時間を取得する
     *
     * @return 更新時間
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新時間を設定する
     *
     * @param updateTime 更新時間
     */
    public void setUpdateTime(final Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /** 各種PayId */
    @Id
    private Long variousFinancialPayId;

    /**
     * 各種PayIdを取得する
     *
     * @return 各種PayId
     */
    public Long getVariousFinancialPayId() {
        return variousFinancialPayId;
    }

    /**
     * 各種PayIdを設定する
     *
     * @param variousFinancialPayId 各種PayId
     */
    public void setVariousFinancialPayId(final Long variousFinancialPayId) {
        this.variousFinancialPayId = variousFinancialPayId;
    }

    /** 最新区分 */
    private Integer saishinKbn;

    /**
     * 最新区分を取得する
     *
     * @return 最新区分
     */
    public Integer getSaishinKbn() {
        return saishinKbn;
    }

    /**
     * 最新区分を設定する
     *
     * @param saishinKbn 最新区分
     */
    public void setSaishinKbn(final Integer saishinKbn) {
        this.saishinKbn = saishinKbn;
    }

    /** 各種Pay名称 */
    private String variousFinancialPayName;

    /**
     * 各種Pay名称を取得する
     *
     * @return 各種Pay名称
     */
    public String getVariousFinancialPayName() {
        return variousFinancialPayName;
    }

    /**
     * 各種Pay名称を設定する
     *
     * @param variousFinancialPayName 各種Pay名称
     */
    public void setVariousFinancialPayName(final String variousFinancialPayName) {
        this.variousFinancialPayName = variousFinancialPayName;
    }

    /** 各種Pay同一識別コード */
    private Integer variousFinancialPayCode;

    /**
     * 各種Pay同一識別コードを取得する
     *
     * @return 各種Pay同一識別コード
     */
    public Integer getVariousFinancialPayCode() {
        return variousFinancialPayCode;
    }
    
    /**
     * 各種Pay同一識別コードを設定する
     *
     * @param variousFinancialPayCode 各種Pay同一識別コード
     */
    public void setVariousFinancialPayCode(final Integer variousFinancialPayCode) {
        this.variousFinancialPayCode = variousFinancialPayCode;
    }

}
