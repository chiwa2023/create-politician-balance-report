package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

/**
 * propse_csv_read_template接続用Entity
 */
@Entity
@Table(name = "propose_csv_read_template")
public class ProposeCsvReadTemplateEntity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** CSV読取り仕様同一識別コード */
    private Integer proposeCsvReadTemplateCode;

    /**
     * CSV読取り仕様同一識別コードを取得する
     *
     * @return CSV読取り仕様同一識別コード
     */
    public Integer getProposeCsvReadTemplateCode() {
        return proposeCsvReadTemplateCode;
    }

    /**
     * CSV読取り仕様同一識別コードを設定する
     *
     * @param proposeCsvReadTemplateCode CSV読取り仕様同一識別コード
     */
    public void setProposeCsvReadTemplateCode(final Integer proposeCsvReadTemplateCode) {
        this.proposeCsvReadTemplateCode = proposeCsvReadTemplateCode;
    }

    /** CSV読取り仕様名称 */
    private String proposeCsvReadTemplateName;

    /**
     * CSV読取り仕様名称を取得する
     *
     * @return CSV読取り仕様名称
     */
    public String getProposeCsvReadTemplateName() {
        return proposeCsvReadTemplateName;
    }

    /**
     * CSV読取り仕様名称を設定する
     *
     * @param proposeCsvReadTemplateName CSV読取り仕様名称
     */
    public void setProposeCsvReadTemplateName(final String proposeCsvReadTemplateName) {
        this.proposeCsvReadTemplateName = proposeCsvReadTemplateName;
    }

    /** 指定配列内容 */
    private String arrayText;

    /**
     * 指定配列内容を取得する
     *
     * @return 指定配列内容
     */
    public String getArrayText() {
        return arrayText;
    }

    /**
     * 指定配列内容を設定する
     *
     * @param arrayText 指定配列内容
     */
    public void setArrayText(final String arrayText) {
        this.arrayText = arrayText;
    }

    /** 金融機関名称 */
    private String financialOrgName;

    /**
     * 金融機関名称を取得する
     *
     * @return 金融機関名称
     */
    public String getFinancialOrgName() {
        return financialOrgName;
    }

    /**
     * 金融機関名称を設定する
     *
     * @param financialOrgName 金融機関名称
     */
    public void setFinancialOrgName(final String financialOrgName) {
        this.financialOrgName = financialOrgName;
    }

    /** 配列桁数 */
    private Integer arrayNumber;

    /**
     * 配列桁数を取得する
     *
     * @return 配列桁数
     */
    public Integer getArrayNumber() {
        return arrayNumber;
    }

    /**
     * 配列桁数を設定する
     *
     * @param arrayNumber 配列桁数
     */
    public void setArrayNumber(final Integer arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

    /** 金融機関区分 */
    private Integer financialOrgKbn;

    /**
     * 金融機関区分を取得する
     *
     * @return 金融機関区分
     */
    public Integer getFinancialOrgKbn() {
        return financialOrgKbn;
    }

    /**
     * 金融機関区分を設定する
     *
     * @param financialOrgKbn 金融機関区分
     */
    public void setFinancialOrgKbn(final Integer financialOrgKbn) {
        this.financialOrgKbn = financialOrgKbn;
    }

    /** 金融機関同一識別コード */
    private Integer financialOrgCode;

    /**
     * 金融機関同一識別コードを取得する
     *
     * @return 金融機関同一識別コード
     */
    public Integer getFinancialOrgCode() {
        return financialOrgCode;
    }

    /**
     * 金融機関同一識別コードを設定する
     *
     * @param financialOrgCode 金融機関同一識別コード
     */
    public void setFinancialOrgCode(final Integer financialOrgCode) {
        this.financialOrgCode = financialOrgCode;
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

    /** CSV読取り仕様Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proposeCsvReadTemplateId;

    /**
     * CSV読取り仕様Idを取得する
     *
     * @return CSV読取り仕様Id
     */
    public Long getProposeCsvReadTemplateId() {
        return proposeCsvReadTemplateId;
    }

    /**
     * CSV読取り仕様Idを設定する
     *
     * @param proposeCsvReadTemplateId CSV読取り仕様Id
     */
    public void setProposeCsvReadTemplateId(final Long proposeCsvReadTemplateId) {
        this.proposeCsvReadTemplateId = proposeCsvReadTemplateId;
    }

    /** 金融機関Id */
    private Long financialOrgId;

    /**
     * 金融機関Idを取得する
     *
     * @return 金融機関Id
     */
    public Long getFinancialOrgId() {
        return financialOrgId;
    }

    /**
     * 金融機関Idを設定する
     *
     * @param financialOrgId 金融機関Id
     */
    public void setFinancialOrgId(final Long financialOrgId) {
        this.financialOrgId = financialOrgId;
    }

    /** ヘッダの有無 */
    private Boolean hasHeader;

    /**
     * ヘッダの有無を取得する
     *
     * @return ヘッダの有無
     */
    public Boolean getHasHeader() {
        return hasHeader;
    }

    /**
     * ヘッダの有無を設定する
     *
     * @param hasHeader ヘッダの有無
     */
    public void setHasHeader(final Boolean hasHeader) {
        this.hasHeader = hasHeader;
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

    /** ログインユーザId */
    private Long loginUserId;

    /** ログインユーザー同一識別コード */
    private Integer loginUserCode;

    /**
     * ログインユーザIdを取得する
     *
     * @return ログインユーザId
     */
    public Long getLoginUserId() {
        return loginUserId;
    }

    /**
     * ログインユーザIdを設定する
     *
     * @param loginUserId ログインユーザId
     */
    public void setLoginUserId(final Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    /**
     * ログイン同一識別コードを取得する
     *
     * @return ログイン同一識別コード
     */
    public Integer getLoginUserCode() {
        return loginUserCode;
    }

    /**
     * ログイン同一識別コードを設定する
     *
     * @param loginUserCode ログイン同一識別コード
     */
    public void setLoginUserCode(final Integer loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    /** 書証Id */
    private String shoshouId;

    /** 書証同一識別コード */
    private Long shoshouCode;

    /** 書証同一識別コード */
    private Integer shoshouKbn;

    public String getShoshouId() {
        return shoshouId;
    }

    public void setShoshouId(final String shoshouId) {
        this.shoshouId = shoshouId;
    }

    public Long getShoshouCode() {
        return shoshouCode;
    }

    public void setShoshouCode(final Long shoshouCode) {
        this.shoshouCode = shoshouCode;
    }

    public Integer getShoshouKbn() {
        return shoshouKbn;
    }

    public void setShoshouKbn(final Integer shoshouKbn) {
        this.shoshouKbn = shoshouKbn;
    }

    
    /** 申請元Id(新規は0) */
    private Long editId;
    
    /** 申請中該当非該当 */
    private Boolean inProsessing;
    
    /** 申請諾否 */
    private Boolean isAccepted;
    
    /** 判定理由 */
    private String judgeReason;

    public Boolean getInProsessing() {
        return inProsessing;
    }

    public void setInProsessing(final Boolean inProsessing) {
        this.inProsessing = inProsessing;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(final Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public String getJudgeReason() {
        return judgeReason;
    }

    public void setJudgeReason(final String judgeReason) {
        this.judgeReason = judgeReason;
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(final Long editId) {
        this.editId = editId;
    }
    
}