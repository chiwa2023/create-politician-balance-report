package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

/**
 * zengin_financial_org接続用Entity
 */
@Entity
@Table(name = "zengin_financial_org")
public class ZenginFinancialOrgEntity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 全銀金融機関名称 */
    private String zenginFinancialOrgName;

    /**
     * 全銀金融機関名称を取得する
     *
     * @return 全銀金融機関名称
     */
    public String getZenginFinancialOrgName() {
        return zenginFinancialOrgName;
    }

    /**
     * 全銀金融機関名称を設定する
     *
     * @param zenginFinancialOrgName 全銀金融機関名称
     */
    public void setZenginFinancialOrgName(final String zenginFinancialOrgName) {
        this.zenginFinancialOrgName = zenginFinancialOrgName;
    }

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

    /** 全銀金融機関Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zenginFinancialOrgId;

    /**
     * 全銀金融機関Idを取得する
     *
     * @return 全銀金融機関Id
     */
    public Long getZenginFinancialOrgId() {
        return zenginFinancialOrgId;
    }

    /**
     * 全銀金融機関Idを設定する
     *
     * @param zenginFinancialOrgId 全銀金融機関Id
     */
    public void setZenginFinancialOrgId(final Long zenginFinancialOrgId) {
        this.zenginFinancialOrgId = zenginFinancialOrgId;
    }

    /** テーブル全文検索カラム */
    private String tableAllSearchText;

    /**
     * テーブル全文検索カラムを取得する
     *
     * @return テーブル全文検索カラム
     */
    public String getTableAllSearchText() {
        return tableAllSearchText;
    }

    /**
     * テーブル全文検索カラムを設定する
     *
     * @param tableAllSearchText テーブル全文検索カラム
     */
    public void setTableAllSearchText(final String tableAllSearchText) {
        this.tableAllSearchText = tableAllSearchText;
    }

    /** 全銀金融機関同一識別コード */
    private Integer zenginFinancialOrgCode;

    /**
     * 全銀金融機関同一識別コードを取得する
     *
     * @return 全銀金融機関同一識別コード
     */
    public Integer getZenginFinancialOrgCode() {
        return zenginFinancialOrgCode;
    }

    /**
     * 全銀金融機関同一識別コードを設定する
     *
     * @param zenginFinancialOrgCode 全銀金融機関同一識別コード
     */
    public void setZenginFinancialOrgCode(final Integer zenginFinancialOrgCode) {
        this.zenginFinancialOrgCode = zenginFinancialOrgCode;
    }

    /** ログインユーザ氏名 */
    private String loginUserName;

    /**
     * ログインユーザ氏名を取得する
     *
     * @return ログインユーザ氏名
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * ログインユーザ氏名を設定する
     *
     * @param loginUserName ログインユーザ氏名
     */
    public void setLoginUserName(final String loginUserName) {
        this.loginUserName = loginUserName;
    }

}
