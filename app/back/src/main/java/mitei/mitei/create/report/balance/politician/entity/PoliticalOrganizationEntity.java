package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

import java.sql.Timestamp;


/**
 * political_organization接続用Entity
 */
@Entity
@Table(name = "political_organization")
public class PoliticalOrganizationEntity  implements Serializable{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 政治団体Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long politicalOrganizationId;

    /**
     * 政治団体Idを取得する
     *
     * @return 政治団体Id
     */
    public Long getPoliticalOrganizationId() {
        return politicalOrganizationId;
    }

    /**
     * 政治団体Idを設定する
     *
     * @param politicalOrganizationId 政治団体Id
     */
    public void setPoliticalOrganizationId(final Long politicalOrganizationId) {
        this.politicalOrganizationId = politicalOrganizationId;
    }

    /** 政治団体同一識別コード */
    private Integer politicalOrganizationCode;

    /**
     * 政治団体同一識別コードを取得する
     *
     * @return 政治団体同一識別コード
     */
    public Integer getPoliticalOrganizationCode() {
        return politicalOrganizationCode;
    }

    /**
     * 政治団体同一識別コードを設定する
     *
     * @param politicalOrganizationCode 政治団体同一識別コード
     */
    public void setPoliticalOrganizationCode(final Integer politicalOrganizationCode) {
        this.politicalOrganizationCode = politicalOrganizationCode;
    }

    /** 政治団体名称 */
    private String politicalOrganizationName;

    /**
     * 政治団体名称を取得する
     *
     * @return 政治団体名称
     */
    public String getPoliticalOrganizationName() {
        return politicalOrganizationName;
    }

    /**
     * 政治団体名称を設定する
     *
     * @param politicalOrganizationName 政治団体名称
     */
    public void setPoliticalOrganizationName(final String politicalOrganizationName) {
        this.politicalOrganizationName = politicalOrganizationName;
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

    /** 代表者Id */
    private Long delegateId;

    /**
     * 代表者Idを取得する
     *
     * @return 代表者Id
     */
    public Long getDelegateId() {
        return delegateId;
    }

    /**
     * 代表者Idを設定する
     *
     * @param delegateId 代表者Id
     */
    public void setDelegateId(final Long delegateId) {
        this.delegateId = delegateId;
    }

    /** 代表者同一識別コード */
    private Integer delegateCode;

    /**
     * 代表者同一識別コードを取得する
     *
     * @return 代表者同一識別コード
     */
    public Integer getDelegateCode() {
        return delegateCode;
    }

    /**
     * 代表者同一識別コードを設定する
     *
     * @param delegateCode 代表者同一識別コード
     */
    public void setDelegateCode(final Integer delegateCode) {
        this.delegateCode = delegateCode;
    }

    /** 代表者名称 */
    private String delegateName;

    /**
     * 代表者名称を取得する
     *
     * @return 代表者名称
     */
    public String getDelegateName() {
        return delegateName;
    }

    /**
     * 代表者名称を設定する
     *
     * @param delegateName 代表者名称
     */
    public void setDelegateName(final String delegateName) {
        this.delegateName = delegateName;
    }

    /** 会計責任者Id */
    private Long accountOfficerId;

    /**
     * 会計責任者Idを取得する
     *
     * @return 会計責任者Id
     */
    public Long getAccountOfficerId() {
        return accountOfficerId;
    }

    /**
     * 会計責任者Idを設定する
     *
     * @param accountOfficerId 会計責任者Id
     */
    public void setAccountOfficerId(final Long accountOfficerId) {
        this.accountOfficerId = accountOfficerId;
    }

    /** 会計責任者同一識別コード */
    private Integer accountOfficerCode;

    /**
     * 会計責任者同一識別コードを取得する
     *
     * @return 会計責任者同一識別コード
     */
    public Integer getAccountOfficerCode() {
        return accountOfficerCode;
    }

    /**
     * 会計責任者同一識別コードを設定する
     *
     * @param accountOfficerCode 会計責任者同一識別コード
     */
    public void setAccountOfficerCode(final Integer accountOfficerCode) {
        this.accountOfficerCode = accountOfficerCode;
    }

    /** 会計責任者名称 */
    private String accountOfficerName;

    /**
     * 会計責任者名称を取得する
     *
     * @return 会計責任者名称
     */
    public String getAccountOfficerName() {
        return accountOfficerName;
    }

    /**
     * 会計責任者名称を設定する
     *
     * @param accountOfficerName 会計責任者名称
     */
    public void setAccountOfficerName(final String accountOfficerName) {
        this.accountOfficerName = accountOfficerName;
    }

    /** 事務担当者1Id */
    private Long accountStaff1Id;

    /**
     * 事務担当者1Idを取得する
     *
     * @return 事務担当者1Id
     */
    public Long getAccountStaff1Id() {
        return accountStaff1Id;
    }

    /**
     * 事務担当者1Idを設定する
     *
     * @param accountStaff1Id 事務担当者1Id
     */
    public void setAccountStaff1Id(final Long accountStaff1Id) {
        this.accountStaff1Id = accountStaff1Id;
    }

    /** 事務担当者1同一識別コード */
    private Integer accountStaff1Code;

    /**
     * 事務担当者1同一識別コードを取得する
     *
     * @return 事務担当者1同一識別コード
     */
    public Integer getAccountStaff1Code() {
        return accountStaff1Code;
    }

    /**
     * 事務担当者1同一識別コードを設定する
     *
     * @param accountStaff1Code 事務担当者1同一識別コード
     */
    public void setAccountStaff1Code(final Integer accountStaff1Code) {
        this.accountStaff1Code = accountStaff1Code;
    }

    /** 事務担当者1名称 */
    private String accountStaff1Name;

    /**
     * 事務担当者1名称を取得する
     *
     * @return 事務担当者1名称
     */
    public String getAccountStaff1Name() {
        return accountStaff1Name;
    }

    /**
     * 事務担当者1名称を設定する
     *
     * @param accountStaff1Name 事務担当者1名称
     */
    public void setAccountStaff1Name(final String accountStaff1Name) {
        this.accountStaff1Name = accountStaff1Name;
    }

    /** 事務担当者2Id */
    private Long accountStaff2Id;

    /**
     * 事務担当者2Idを取得する
     *
     * @return 事務担当者2Id
     */
    public Long getAccountStaff2Id() {
        return accountStaff2Id;
    }

    /**
     * 事務担当者2Idを設定する
     *
     * @param accountStaff2Id 事務担当者2Id
     */
    public void setAccountStaff2Id(final Long accountStaff2Id) {
        this.accountStaff2Id = accountStaff2Id;
    }

    /** 事務担当者2同一識別コード */
    private Integer accountStaff2Code;

    /**
     * 事務担当者2同一識別コードを取得する
     *
     * @return 事務担当者2同一識別コード
     */
    public Integer getAccountStaff2Code() {
        return accountStaff2Code;
    }

    /**
     * 事務担当者2同一識別コードを設定する
     *
     * @param accountStaff2Code 事務担当者2同一識別コード
     */
    public void setAccountStaff2Code(final Integer accountStaff2Code) {
        this.accountStaff2Code = accountStaff2Code;
    }

    /** 事務担当者2名称 */
    private String accountStaff2Name;

    /**
     * 事務担当者2名称を取得する
     *
     * @return 事務担当者2名称
     */
    public String getAccountStaff2Name() {
        return accountStaff2Name;
    }

    /**
     * 事務担当者2名称を設定する
     *
     * @param accountStaff2Name 事務担当者2名称
     */
    public void setAccountStaff2Name(final String accountStaff2Name) {
        this.accountStaff2Name = accountStaff2Name;
    }

    /** 事務担当者3Id */
    private Long accountStaff3Id;

    /**
     * 事務担当者3Idを取得する
     *
     * @return 事務担当者3Id
     */
    public Long getAccountStaff3Id() {
        return accountStaff3Id;
    }

    /**
     * 事務担当者3Idを設定する
     *
     * @param accountStaff3Id 事務担当者3Id
     */
    public void setAccountStaff3Id(final Long accountStaff3Id) {
        this.accountStaff3Id = accountStaff3Id;
    }

    /** 事務担当者3同一識別コード */
    private Integer accountStaff3Code;

    /**
     * 事務担当者3同一識別コードを取得する
     *
     * @return 事務担当者3同一識別コード
     */
    public Integer getAccountStaff3Code() {
        return accountStaff3Code;
    }

    /**
     * 事務担当者3同一識別コードを設定する
     *
     * @param accountStaff3Code 事務担当者3同一識別コード
     */
    public void setAccountStaff3Code(final Integer accountStaff3Code) {
        this.accountStaff3Code = accountStaff3Code;
    }

    /** 事務担当者3名称 */
    private String accountStaff3Name;

    /**
     * 事務担当者3名称を取得する
     *
     * @return 事務担当者3名称
     */
    public String getAccountStaff3Name() {
        return accountStaff3Name;
    }

    /**
     * 事務担当者3名称を設定する
     *
     * @param accountStaff3Name 事務担当者3名称
     */
    public void setAccountStaff3Name(final String accountStaff3Name) {
        this.accountStaff3Name = accountStaff3Name;
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

    /** ログインユーザId */
    private Long loginUserId;

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

    /** ログインユーザ同一識別コード */
    private Integer loginUserCode;

    /**
     * ログインユーザ同一識別コードを取得する
     *
     * @return ログインユーザ同一識別コード
     */
    public Integer getLoginUserCode() {
        return loginUserCode;
    }

    /**
     * ログインユーザ同一識別コードを設定する
     *
     * @param loginUserCode ログインユーザ同一識別コード
     */
    public void setLoginUserCode(final Integer loginUserCode) {
        this.loginUserCode = loginUserCode;
    }

    /** ログインユーザ */
    private String loginUserName;

    /**
     * ログインユーザを取得する
     *
     * @return ログインユーザ
     */
    public String getLoginUserName() {
        return loginUserName;
    }

    /**
     * ログインユーザを設定する
     *
     * @param loginUserName ログインユーザ
     */
    public void setLoginUserName(final String loginUserName) {
        this.loginUserName = loginUserName;
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

}
