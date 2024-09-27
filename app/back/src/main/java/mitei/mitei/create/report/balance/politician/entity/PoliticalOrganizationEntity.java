package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

/**
 * political_organization接続用Entity
 */
@Entity
@Table(name = "political_organization")
public class PoliticalOrganizationEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_STRING = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_INTEGER = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_LONG = 0L;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1948,7,29);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_TIMESTAMP  = INIT_LOCALDATE.atTime(0, 0, 0);

    /** 政治団体Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long politicalOrganizationId = INIT_LONG;

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
    private Integer politicalOrganizationCode = INIT_INTEGER;

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
    private String politicalOrganizationName = INIT_STRING;

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
    private Integer saishinKbn = INIT_INTEGER;

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
    private Long delegateId = INIT_LONG;

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
    private Integer delegateCode = INIT_INTEGER;

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

    /** 代表者姓名 */
    private String delegateName = INIT_STRING;

    /**
     * 代表者姓名を取得する
     *
     * @return 代表者姓名
     */
    public String getDelegateName() {
        return delegateName;
    }

    /**
     * 代表者姓名を設定する
     *
     * @param delegateName 代表者姓名
     */
    public void setDelegateName(final String delegateName) {
        this.delegateName = delegateName;
    }

    /** 会計責任者Id */
    private Long accountOfficerId = INIT_LONG;

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
    private Integer accountOfficerCode = INIT_INTEGER;

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

    /** 会計責任者姓名 */
    private String accountOfficerName = INIT_STRING;

    /**
     * 会計責任者姓名を取得する
     *
     * @return 会計責任者姓名
     */
    public String getAccountOfficerName() {
        return accountOfficerName;
    }

    /**
     * 会計責任者姓名を設定する
     *
     * @param accountOfficerName 会計責任者姓名
     */
    public void setAccountOfficerName(final String accountOfficerName) {
        this.accountOfficerName = accountOfficerName;
    }

    /** 事務担当者1Id */
    private Long accountStaff1Id = INIT_LONG;

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
    private Integer accountStaff1Code = INIT_INTEGER;

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
    private String accountStaff1Name = INIT_STRING;

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
    private Long accountStaff2Id = INIT_LONG;

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
    private Integer accountStaff2Code = INIT_INTEGER;

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
    private String accountStaff2Name = INIT_STRING;

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
    private Long accountStaff3Id = INIT_LONG;

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
    private Integer accountStaff3Code = INIT_INTEGER;

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
    private String accountStaff3Name = INIT_STRING;

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
    private String tableAllSearchText = INIT_STRING;

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

    /** 挿入ユーザId */
    private Long insertUserId = INIT_LONG;

    /**
     * 挿入ユーザIdを取得する
     *
     * @return 挿入ユーザId
     */
    @Override
    public Long getInsertUserId() {
        return insertUserId;
    }

    /**
     * 挿入ユーザIdを設定する
     *
     * @param insertUserId 挿入ユーザId
     */
    @Override
    public void setInsertUserId(final Long insertUserId) {
        this.insertUserId = insertUserId;
    }

    /** 挿入ユーザ同一識別コード */
    private Integer insertUserCode = INIT_INTEGER;

    /**
     * 挿入ユーザ同一識別コードを取得する
     *
     * @return 挿入ユーザ同一識別コード
     */
    @Override
    public Integer getInsertUserCode() {
        return insertUserCode;
    }

    /**
     * 挿入ユーザ同一識別コードを設定する
     *
     * @param insertUserCode 挿入ユーザ同一識別コード
     */
    @Override
    public void setInsertUserCode(final Integer insertUserCode) {
        this.insertUserCode = insertUserCode;
    }

    /** 挿入ユーザ姓名 */
    private String insertUserName = INIT_STRING;

    /**
     * 挿入ユーザ姓名を取得する
     *
     * @return 挿入ユーザ姓名
     */
    @Override
    public String getInsertUserName() {
        return insertUserName;
    }

    /**
     * 挿入ユーザ姓名を設定する
     *
     * @param insertUserName 挿入ユーザ姓名
     */
    @Override
    public void setInsertUserName(final String insertUserName) {
        this.insertUserName = insertUserName;
    }

    /** 挿入タイムスタンプ */
    private LocalDateTime insertTimestamp = INIT_TIMESTAMP ;

    /**
     * 挿入タイムスタンプを取得する
     *
     * @return 挿入タイムスタンプ
     */
    @Override
    public LocalDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * 挿入タイムスタンプを設定する
     *
     * @param insertTimestamp 挿入タイムスタンプ
     */
    @Override
    public void setInsertTimestamp(final LocalDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /** 更新ユーザId */
    private Long updateUserId = INIT_LONG;

    /**
     * 更新ユーザIdを取得する
     *
     * @return 更新ユーザId
     */
    @Override
    public Long getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 更新ユーザIdを設定する
     *
     * @param updateUserId 更新ユーザId
     */
    @Override
    public void setUpdateUserId(final Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /** 更新ユーザ同一識別コード */
    private Integer updateUserCode = INIT_INTEGER;

    /**
     * 更新ユーザ同一識別コードを取得する
     *
     * @return 更新ユーザ同一識別コード
     */
    @Override
    public Integer getUpdateUserCode() {
        return updateUserCode;
    }

    /**
     * 更新ユーザ同一識別コードを設定する
     *
     * @param updateUserCode 更新ユーザ同一識別コード
     */
    @Override
    public void setUpdateUserCode(final Integer updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    /** 更新ユーザ姓名 */
    private String updateUserName = INIT_STRING;

    /**
     * 更新ユーザ姓名を取得する
     *
     * @return 更新ユーザ姓名
     */
    @Override
    public String getUpdateUserName() {
        return updateUserName;
    }

    /**
     * 更新ユーザ姓名を設定する
     *
     * @param updateUserName 更新ユーザ姓名
     */
    @Override
    public void setUpdateUserName(final String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /** 更新タイムスタンプ */
    private LocalDateTime updateTimestamp = INIT_TIMESTAMP ;

    /**
     * 更新タイムスタンプを取得する
     *
     * @return 更新タイムスタンプ
     */
    @Override
    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 更新タイムスタンプを設定する
     *
     * @param updateTimestamp 更新タイムスタンプ
     */
    @Override
    public void setUpdateTimestamp(final LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

}
