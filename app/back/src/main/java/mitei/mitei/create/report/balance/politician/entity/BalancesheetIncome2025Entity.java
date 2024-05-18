package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * balancesheet_income_2025接続用Entity
 */
@Entity
@Table(name = "balancesheet_income_2025")
public class BalancesheetIncome2025Entity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** Integer初期値 */
    private static final int INT_INIT = 0;

    /** Long初期値 */
    private static final long LONG_INIT = 0L;

    /** 文字列初期値 */
    private static final String STRING_INIT = "";

    /** Boolean初期値 */
    private static final Boolean BOOLEAN_INIT = false;

    /** LocalDate初期値 */
    private static final LocalDate LOCALDATE_INIT = LocalDate.of(1980, 1, 1);

    /** Timestamp初期値 */
    private static final Timestamp TIMESTAMP_INIT = Timestamp.valueOf(LOCALDATE_INIT.atTime(0, 0, 0));

    /** 項目名称Id区分 */
    private Integer itemIdKbn = INT_INIT;

    /**
     * 項目名称Id区分を取得する
     *
     * @return 項目名称Id区分
     */
    public Integer getItemIdKbn() {
        return itemIdKbn;
    }

    /**
     * 項目名称Id区分を設定する
     *
     * @param itemIdKbn 項目名称Id区分
     */
    public void setItemIdKbn(final Integer itemIdKbn) {
        this.itemIdKbn = itemIdKbn;
    }

    /** ログインユーザ同一識別コード */
    private Integer loginUserCode = INT_INIT;

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

    /** 書証Id */
    private String shoshouId = STRING_INIT;

    /**
     * 書証Idを取得する
     *
     * @return 書証Id
     */
    public String getShoshouId() {
        return shoshouId;
    }

    /**
     * 書証Idを設定する
     *
     * @param shoshouId 書証Id
     */
    public void setShoshouId(final String shoshouId) {
        this.shoshouId = shoshouId;
    }

    /** 意見付記 */
    private String note = STRING_INIT;

    /**
     * 意見付記を取得する
     *
     * @return 意見付記
     */
    public String getNote() {
        return note;
    }

    /**
     * 意見付記を設定する
     *
     * @param note 意見付記
     */
    public void setNote(final String note) {
        this.note = note;
    }

    /** 関連者法人同一識別コード */
    private Integer relationCorporationCode = INT_INIT;

    /**
     * 関連者法人同一識別コードを取得する
     *
     * @return 関連者法人同一識別コード
     */
    public Integer getRelationCorporationCode() {
        return relationCorporationCode;
    }

    /**
     * 関連者法人同一識別コードを設定する
     *
     * @param relationCorporationCode 関連者法人同一識別コード
     */
    public void setRelationCorporationCode(final Integer relationCorporationCode) {
        this.relationCorporationCode = relationCorporationCode;
    }

    /** 政治資金収支報告書収入項目Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long balancesheetIncomeId = LONG_INIT;

    /**
     * 政治資金収支報告書収入項目Idを取得する
     *
     * @return 政治資金収支報告書収入項目Id
     */
    public Long getBalancesheetIncomeId() {
        return balancesheetIncomeId;
    }

    /**
     * 政治資金収支報告書収入項目Idを設定する
     *
     * @param balancesheetIncomeId 政治資金収支報告書収入項目Id
     */
    public void setBalancesheetIncomeId(final Long balancesheetIncomeId) {
        this.balancesheetIncomeId = balancesheetIncomeId;
    }

    /** 発生日 */
    private LocalDate accrualDate = LOCALDATE_INIT;

    /**
     * 発生日を取得する
     *
     * @return 発生日
     */
    public LocalDate getAccrualDate() {
        return accrualDate;
    }

    /**
     * 発生日を設定する
     *
     * @param accrualDate 発生日
     */
    public void setAccrualDate(final LocalDate accrualDate) {
        this.accrualDate = accrualDate;
    }

    /** 備考 */
    private String biko = STRING_INIT;

    /**
     * 備考を取得する
     *
     * @return 備考
     */
    public String getBiko() {
        return biko;
    }

    /**
     * 備考を設定する
     *
     * @param biko 備考
     */
    public void setBiko(final String biko) {
        this.biko = biko;
    }

    /** 参照した摘要 */
    private String referDigest = STRING_INIT;

    /**
     * 参照した摘要を取得する
     *
     * @return 参照した摘要
     */
    public String getReferDigest() {
        return referDigest;
    }

    /**
     * 参照した摘要を設定する
     *
     * @param referDigest 参照した摘要
     */
    public void setReferDigest(final String referDigest) {
        this.referDigest = referDigest;
    }

    /** 政治資金団体同一識別コード */
    private Integer politicalOrganizationCode = INT_INIT;

    /**
     * 政治資金団体同一識別コードを取得する
     *
     * @return 政治資金団体同一識別コード
     */
    public Integer getPoliticalOrganizationCode() {
        return politicalOrganizationCode;
    }

    /**
     * 政治資金団体同一識別コードを設定する
     *
     * @param politicalOrganizationCode 政治資金団体同一識別コード
     */
    public void setPoliticalOrganizationCode(final Integer politicalOrganizationCode) {
        this.politicalOrganizationCode = politicalOrganizationCode;
    }

    /** 継続事業Id */
    private Long continueBuissinessId = LONG_INIT;

    /**
     * 継続事業Idを取得する
     *
     * @return 継続事業Id
     */
    public Long getContinueBuissinessId() {
        return continueBuissinessId;
    }

    /**
     * 継続事業Idを設定する
     *
     * @param continueBuissinessId 継続事業Id
     */
    public void setContinueBuissinessId(final Long continueBuissinessId) {
        this.continueBuissinessId = continueBuissinessId;
    }

    /** 寄付法人が上場または外資50%超え会社有無フラグ */
    private Boolean isPrimeListedOrForeign = BOOLEAN_INIT;

    /**
     * 寄付法人が上場または外資50%超え会社有無フラグを取得する
     *
     * @return 寄付法人が上場または外資50%超え会社有無フラグ
     */
    public Boolean getIsPrimeListedOrForeign() {
        return isPrimeListedOrForeign;
    }

    /**
     * 寄付法人が上場または外資50%超え会社有無フラグを設定する
     *
     * @param isPrimeListedOrForeign 寄付法人が上場または外資50%超え会社有無フラグ
     */
    public void setIsPrimeListedOrForeign(final Boolean isPrimeListedOrForeign) {
        this.isPrimeListedOrForeign = isPrimeListedOrForeign;
    }

    /** 書証識別コード */
    private Long shoshouHistoryCode = LONG_INIT;

    /**
     * 書証識別コードを取得する
     *
     * @return 書証識別コード
     */
    public Long getShoshouHistoryCode() {
        return shoshouHistoryCode;
    }

    /**
     * 書証識別コードを設定する
     *
     * @param shoshouHistoryCode 書証識別コード
     */
    public void setShoshouHistoryCode(final Long shoshouHistoryCode) {
        this.shoshouHistoryCode = shoshouHistoryCode;
    }

    /** 関連者個人Id */
    private Long relationPersonId = LONG_INIT;

    /**
     * 関連者個人Idを取得する
     *
     * @return 関連者個人Id
     */
    public Long getRelationPersonId() {
        return relationPersonId;
    }

    /**
     * 関連者個人Idを設定する
     *
     * @param relationPersonId 関連者個人Id
     */
    public void setRelationPersonId(final Long relationPersonId) {
        this.relationPersonId = relationPersonId;
    }

    /** 収支報告区分 */
    private Integer reportKbn = INT_INIT;

    /**
     * 収支報告区分を取得する
     *
     * @return 収支報告区分
     */
    public Integer getReportKbn() {
        return reportKbn;
    }

    /**
     * 収支報告区分を設定する
     *
     * @param reportKbn 収支報告区分
     */
    public void setReportKbn(final Integer reportKbn) {
        this.reportKbn = reportKbn;
    }

    /** 団体代表者・職業 */
    private String professionOrgnizationName = STRING_INIT;

    /**
     * 団体代表者・職業を取得する
     *
     * @return 団体代表者・職業
     */
    public String getProfessionOrgnizationName() {
        return professionOrgnizationName;
    }

    /**
     * 団体代表者・職業を設定する
     *
     * @param professionOrgnizationName 団体代表者・職業
     */
    public void setProfessionOrgnizationName(final String professionOrgnizationName) {
        this.professionOrgnizationName = professionOrgnizationName;
    }

    /** 税額控除有無 */
    private Boolean isCreditTax = BOOLEAN_INIT;

    /**
     * 税額控除有無を取得する
     *
     * @return 税額控除有無
     */
    public Boolean getIsCreditTax() {
        return isCreditTax;
    }

    /**
     * 税額控除有無を設定する
     *
     * @param isCreditTax 税額控除有無
     */
    public void setIsCreditTax(final Boolean isCreditTax) {
        this.isCreditTax = isCreditTax;
    }

    /** 様式仕訳枝項目区分 */
    private Integer youshikiEdaKbn = INT_INIT;

    /**
     * 様式仕訳枝項目区分を取得する
     *
     * @return 様式仕訳枝項目区分
     */
    public Integer getYoushikiEdaKbn() {
        return youshikiEdaKbn;
    }

    /**
     * 様式仕訳枝項目区分を設定する
     *
     * @param youshikiEdaKbn 様式仕訳枝項目区分
     */
    public void setYoushikiEdaKbn(final Integer youshikiEdaKbn) {
        this.youshikiEdaKbn = youshikiEdaKbn;
    }

    /** 関連者個人同一識別コード */
    private Integer relationPersonCode = INT_INIT;

    /**
     * 関連者個人同一識別コードを取得する
     *
     * @return 関連者個人同一識別コード
     */
    public Integer getRelationPersonCode() {
        return relationPersonCode;
    }

    /**
     * 関連者個人同一識別コードを設定する
     *
     * @param relationPersonCode 関連者個人同一識別コード
     */
    public void setRelationPersonCode(final Integer relationPersonCode) {
        this.relationPersonCode = relationPersonCode;
    }

    /** 継続事業同一識別コード */
    private Integer continueBuissinessCode = INT_INIT;

    /**
     * 継続事業同一識別コードを取得する
     *
     * @return 継続事業同一識別コード
     */
    public Integer getContinueBuissinessCode() {
        return continueBuissinessCode;
    }

    /**
     * 継続事業同一識別コードを設定する
     *
     * @param continueBuissinessCode 継続事業同一識別コード
     */
    public void setContinueBuissinessCode(final Integer continueBuissinessCode) {
        this.continueBuissinessCode = continueBuissinessCode;
    }

    /** 政治資金パーティ名称 */
    private String partyName = STRING_INIT;

    /**
     * 政治資金パーティ名称を取得する
     *
     * @return 政治資金パーティ名称
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * 政治資金パーティ名称を設定する
     *
     * @param partyName 政治資金パーティ名称
     */
    public void setPartyName(final String partyName) {
        this.partyName = partyName;
    }

    /** 様式仕訳区分 */
    private Integer youshikiKbn = INT_INIT;

    /**
     * 様式仕訳区分を取得する
     *
     * @return 様式仕訳区分
     */
    public Integer getYoushikiKbn() {
        return youshikiKbn;
    }

    /**
     * 様式仕訳区分を設定する
     *
     * @param youshikiKbn 様式仕訳区分
     */
    public void setYoushikiKbn(final Integer youshikiKbn) {
        this.youshikiKbn = youshikiKbn;
    }

    /** 政治資金団体名称 */
    private String politicalOrganizationName = STRING_INIT;

    /**
     * 政治資金団体名称を取得する
     *
     * @return 政治資金団体名称
     */
    public String getPoliticalOrganizationName() {
        return politicalOrganizationName;
    }

    /**
     * 政治資金団体名称を設定する
     *
     * @param politicalOrganizationName 政治資金団体名称
     */
    public void setPoliticalOrganizationName(final String politicalOrganizationName) {
        this.politicalOrganizationName = politicalOrganizationName;
    }

    /** 書証区分 */
    private Integer shoshouKbn = INT_INIT;

    /**
     * 書証区分を取得する
     *
     * @return 書証区分
     */
    public Integer getShoshouKbn() {
        return shoshouKbn;
    }

    /**
     * 書証区分を設定する
     *
     * @param shoshouKbn 書証区分
     */
    public void setShoshouKbn(final Integer shoshouKbn) {
        this.shoshouKbn = shoshouKbn;
    }

    /** 自動入力編集有無 */
    private Boolean isEditAutoInput = BOOLEAN_INIT;

    /**
     * 自動入力編集有無を取得する
     *
     * @return 自動入力編集有無
     */
    public Boolean getIsEditAutoInput() {
        return isEditAutoInput;
    }

    /**
     * 自動入力編集有無を設定する
     *
     * @param isEditAutoInput 自動入力編集有無
     */
    public void setIsEditAutoInput(final Boolean isEditAutoInput) {
        this.isEditAutoInput = isEditAutoInput;
    }

    /** 一般項目名称Id */
    private Long generalItemId = LONG_INIT;

    /**
     * 一般項目名称Idを取得する
     *
     * @return 一般項目名称Id
     */
    public Long getGeneralItemId() {
        return generalItemId;
    }

    /**
     * 一般項目名称Idを設定する
     *
     * @param generalItemId 一般項目名称Id
     */
    public void setGeneralItemId(final Long generalItemId) {
        this.generalItemId = generalItemId;
    }

    /** 書証読み取り行 */
    private Integer readingLine = INT_INIT;

    /**
     * 書証読み取り行を取得する
     *
     * @return 書証読み取り行
     */
    public Integer getReadingLine() {
        return readingLine;
    }

    /**
     * 書証読み取り行を設定する
     *
     * @param readingLine 書証読み取り行
     */
    public void setReadingLine(final Integer readingLine) {
        this.readingLine = readingLine;
    }

    /** ログインユーザId */
    private Long loginUserId = LONG_INIT;

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

    /** 前例と異なる処理フラグ */
    private Boolean isDifferPrecedent = BOOLEAN_INIT;

    /**
     * 前例と異なる処理フラグを取得する
     *
     * @return 前例と異なる処理フラグ
     */
    public Boolean getIsDifferPrecedent() {
        return isDifferPrecedent;
    }

    /**
     * 前例と異なる処理フラグを設定する
     *
     * @param isDifferPrecedent 前例と異なる処理フラグ
     */
    public void setIsDifferPrecedent(final Boolean isDifferPrecedent) {
        this.isDifferPrecedent = isDifferPrecedent;
    }

    /** 保全証票リスト */
    private String storagedDocumentIdList = STRING_INIT;

    /**
     * 保全証票リストを取得する
     *
     * @return 保全証票リスト
     */
    public String getStoragedDocumentIdList() {
        return storagedDocumentIdList;
    }

    /**
     * 保全証票リストを設定する
     *
     * @param storagedDocumentIdList 保全証票リスト
     */
    public void setStoragedDocumentIdList(final String storagedDocumentIdList) {
        this.storagedDocumentIdList = storagedDocumentIdList;
    }

    /** 取引金額 */
    private Long amount = LONG_INIT;

    /**
     * 取引金額を取得する
     *
     * @return 取引金額
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 取引金額を設定する
     *
     * @param amount 取引金額
     */
    public void setAmount(final Long amount) {
        this.amount = amount;
    }

    /** 更新時間 */
    private Timestamp updateTime = TIMESTAMP_INIT;

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

    /** 一般名称同一識別コード */
    private Integer generalItemCode = INT_INIT;

    /**
     * 一般名称同一識別コードを取得する
     *
     * @return 一般名称同一識別コード
     */
    public Integer getGeneralItemCode() {
        return generalItemCode;
    }

    /**
     * 一般名称同一識別コードを設定する
     *
     * @param generalItemCode 一般名称同一識別コード
     */
    public void setGeneralItemCode(final Integer generalItemCode) {
        this.generalItemCode = generalItemCode;
    }

    /** 集めた期間終了日 */
    private LocalDate mediationEndDate = LOCALDATE_INIT;

    /**
     * 集めた期間終了日を取得する
     *
     * @return 集めた期間終了日
     */
    public LocalDate getMediationEndDate() {
        return mediationEndDate;
    }

    /**
     * 集めた期間終了日を設定する
     *
     * @param mediationEndDate 集めた期間終了日
     */
    public void setMediationEndDate(final LocalDate mediationEndDate) {
        this.mediationEndDate = mediationEndDate;
    }

    /** 個人・団体住所 */
    private String orgnizationAddress = STRING_INIT;

    /**
     * 個人・団体住所を取得する
     *
     * @return 個人・団体住所
     */
    public String getOrgnizationAddress() {
        return orgnizationAddress;
    }

    /**
     * 個人・団体住所を設定する
     *
     * @param orgnizationAddress 個人・団体住所
     */
    public void setOrgnizationAddress(final String orgnizationAddress) {
        this.orgnizationAddress = orgnizationAddress;
    }

    /** 項目名称 */
    private String itemName = STRING_INIT;

    /**
     * 項目名称を取得する
     *
     * @return 項目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 項目名称を設定する
     *
     * @param itemName 項目名称
     */
    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    /** 政治資金収支報告書収入項目同一識別コード */
    private Long balancesheetIncomeCode = LONG_INIT;

    /**
     * 政治資金収支報告書収入項目同一識別コードを取得する
     *
     * @return 政治資金収支報告書収入項目同一識別コード
     */
    public Long getBalancesheetIncomeCode() {
        return balancesheetIncomeCode;
    }

    /**
     * 政治資金収支報告書収入項目同一識別コードを設定する
     *
     * @param balancesheetIncomeCode 政治資金収支報告書収入項目同一識別コード
     */
    public void setBalancesheetIncomeCode(final Long balancesheetIncomeCode) {
        this.balancesheetIncomeCode = balancesheetIncomeCode;
    }

    /** パーティ開催日 */
    private LocalDate partyDate = LOCALDATE_INIT;

    /**
     * パーティ開催日を取得する
     *
     * @return パーティ開催日
     */
    public LocalDate getPartyDate() {
        return partyDate;
    }

    /**
     * パーティ開催日を設定する
     *
     * @param partyDate パーティ開催日
     */
    public void setPartyDate(final LocalDate partyDate) {
        this.partyDate = partyDate;
    }

    /** 政治資金団体Id */
    private Long politicalOrganizationId = LONG_INIT;

    /**
     * 政治資金団体Idを取得する
     *
     * @return 政治資金団体Id
     */
    public Long getPoliticalOrganizationId() {
        return politicalOrganizationId;
    }

    /**
     * 政治資金団体Idを設定する
     *
     * @param politicalOrganizationId 政治資金団体Id
     */
    public void setPoliticalOrganizationId(final Long politicalOrganizationId) {
        this.politicalOrganizationId = politicalOrganizationId;
    }

    /** 関連者区分 */
    private Integer relationKbn = INT_INIT;

    /**
     * 関連者区分を取得する
     *
     * @return 関連者区分
     */
    public Integer getRelationKbn() {
        return relationKbn;
    }

    /**
     * 関連者区分を設定する
     *
     * @param relationKbn 関連者区分
     */
    public void setRelationKbn(final Integer relationKbn) {
        this.relationKbn = relationKbn;
    }

    /** 寄付が遺贈有無フラグ */
    private Boolean isBequest = BOOLEAN_INIT;

    /**
     * 寄付が遺贈有無フラグを取得する
     *
     * @return 寄付が遺贈有無フラグ
     */
    public Boolean getIsBequest() {
        return isBequest;
    }

    /**
     * 寄付が遺贈有無フラグを設定する
     *
     * @param isBequest 寄付が遺贈有無フラグ
     */
    public void setIsBequest(final Boolean isBequest) {
        this.isBequest = isBequest;
    }

    /** 最新区分 */
    private Integer saishinKbn = INT_INIT;

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

    /** 関連者政治団体Id */
    private Long relationPoliticsOrganizationId = LONG_INIT;

    /**
     * 関連者政治団体Idを取得する
     *
     * @return 関連者政治団体Id
     */
    public Long getRelationPoliticsOrganizationId() {
        return relationPoliticsOrganizationId;
    }

    /**
     * 関連者政治団体Idを設定する
     *
     * @param relationPoliticsOrganizationId 関連者政治団体Id
     */
    public void setRelationPoliticsOrganizationId(final Long relationPoliticsOrganizationId) {
        this.relationPoliticsOrganizationId = relationPoliticsOrganizationId;
    }

    /** 関連者政治団体同一識別コード */
    private Integer relationPoliticsOrganizationCode = INT_INIT;

    /**
     * 関連者政治団体同一識別コードを取得する
     *
     * @return 関連者政治団体同一識別コード
     */
    public Integer getRelationPoliticsOrganizationCode() {
        return relationPoliticsOrganizationCode;
    }

    /**
     * 関連者政治団体同一識別コードを設定する
     *
     * @param relationPoliticsOrganizationCode 関連者政治団体同一識別コード
     */
    public void setRelationPoliticsOrganizationCode(final Integer relationPoliticsOrganizationCode) {
        this.relationPoliticsOrganizationCode = relationPoliticsOrganizationCode;
    }

    /** 関連者法人Id */
    private Long relationCorporationId = LONG_INIT;

    /**
     * 関連者法人Idを取得する
     *
     * @return 関連者法人Id
     */
    public Long getRelationCorporationId() {
        return relationCorporationId;
    }

    /**
     * 関連者法人Idを設定する
     *
     * @param relationCorporationId 関連者法人Id
     */
    public void setRelationCorporationId(final Long relationCorporationId) {
        this.relationCorporationId = relationCorporationId;
    }

    /** 集めた期間開始日 */
    private LocalDate mediationStartDate = LOCALDATE_INIT;

    /**
     * 集めた期間開始日を取得する
     *
     * @return 集めた期間開始日
     */
    public LocalDate getMediationStartDate() {
        return mediationStartDate;
    }

    /**
     * 集めた期間開始日を設定する
     *
     * @param mediationStartDate 集めた期間開始日
     */
    public void setMediationStartDate(final LocalDate mediationStartDate) {
        this.mediationStartDate = mediationStartDate;
    }

    /** ログインユーザ氏名 */
    private String loginUserName = STRING_INIT;

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
