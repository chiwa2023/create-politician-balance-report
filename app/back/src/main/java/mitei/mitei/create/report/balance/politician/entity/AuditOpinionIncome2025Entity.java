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
 * audit_opinion_income_2025接続用Entity
 */
@Entity
@Table(name = "audit_opinion_income_2025")
public class AuditOpinionIncome2025Entity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_STRING = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_INTEGER = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_LONG = 0L;

    /** 初期データ(Boolean) */
    private static final Boolean INIT_BOOLEAN = false;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1980,1,1);

    /** 初期データ(Timestamp) */
    private static final LocalDateTime INIT_TIMESTAMP  = INIT_LOCALDATE.atTime(0, 0, 0);

    /** 収支報告書収入意見付記項目Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditOpinionIncomeId = INIT_LONG;

    /**
     * 収支報告書収入意見付記項目Idを取得する
     *
     * @return 収支報告書収入意見付記項目Id
     */
    public Long getAuditOpinionIncomeId() {
        return auditOpinionIncomeId;
    }

    /**
     * 収支報告書収入意見付記項目Idを設定する
     *
     * @param auditOpinionIncomeId 収支報告書収入意見付記項目Id
     */
    public void setAuditOpinionIncomeId(final Long auditOpinionIncomeId) {
        this.auditOpinionIncomeId = auditOpinionIncomeId;
    }

    /** データ作成が調査側フラグ */
    private Boolean isCreatedItemByInvest = INIT_BOOLEAN;

    /**
     * データ作成が調査側フラグを取得する
     *
     * @return データ作成が調査側フラグ
     */
    public Boolean getIsCreatedItemByInvest() {
        return isCreatedItemByInvest;
    }

    /**
     * データ作成が調査側フラグを設定する
     *
     * @param isCreatedItemByInvest データ作成が調査側フラグ
     */
    public void setIsCreatedItemByInvest(final Boolean isCreatedItemByInvest) {
        this.isCreatedItemByInvest = isCreatedItemByInvest;
    }

    /** 政治資金収支報告書収入項目Id */
    private Long balancesheetIncomeId = INIT_LONG;

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

    /** 政治資金収支報告書収入項目同一識別コード */
    private Long balancesheetIncomeCode = INIT_LONG;

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

    /** 政治資金団体Id */
    private Long politicalOrganizationId = INIT_LONG;

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

    /** 政治資金団体同一識別コード */
    private Integer politicalOrganizationCode = INIT_INTEGER;

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

    /** 政治資金団体名称 */
    private String politicalOrganizationName = INIT_STRING;

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

    /** 書証Id */
    private String shoshouId = INIT_STRING;

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

    /** 書証識別コード */
    private Long shoshouHistoryCode = INIT_LONG;

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

    /** 書証区分 */
    private Integer shoshouKbn = INIT_INTEGER;

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

    /** 書証読み取り行 */
    private Integer readingLine = INIT_INTEGER;

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

    /** 参照した摘要 */
    private String referDigest = INIT_STRING;

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

    /** 取引金額 */
    private Long amount = INIT_LONG;

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

    /** 発生日 */
    private LocalDate accrualDate = INIT_LOCALDATE;

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

    /** 自動入力編集の有無 */
    private Boolean isEditAutoInput = INIT_BOOLEAN;

    /**
     * 自動入力編集の有無を取得する
     *
     * @return 自動入力編集の有無
     */
    public Boolean getIsEditAutoInput() {
        return isEditAutoInput;
    }

    /**
     * 自動入力編集の有無を設定する
     *
     * @param isEditAutoInput 自動入力編集の有無
     */
    public void setIsEditAutoInput(final Boolean isEditAutoInput) {
        this.isEditAutoInput = isEditAutoInput;
    }

    /** 収支報告区分 */
    private Integer reportKbn = INIT_INTEGER;

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

    /** 様式仕訳区分 */
    private Integer youshikiKbn = INIT_INTEGER;

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

    /** 様式仕訳枝項目区分 */
    private Integer youshikiEdaKbn = INIT_INTEGER;

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

    /** 項目名称 */
    private String itemName = INIT_STRING;

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

    /** 項目名称Id区分 */
    private Integer itemIdKbn = INIT_INTEGER;

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

    /** 一般項目名称Id */
    private Long generalItemId = INIT_LONG;

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

    /** 一般名称同一識別コード */
    private Integer generalItemCode = INIT_INTEGER;

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

    /** 継続事業Id */
    private Long continueBuissinessId = INIT_LONG;

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

    /** 継続事業同一識別コード */
    private Integer continueBuissinessCode = INIT_INTEGER;

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

    /** 関連者区分 */
    private Integer relationKbn = INIT_INTEGER;

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

    /** 関連者個人Id */
    private Long relationPersonId = INIT_LONG;

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

    /** 関連者個人同一識別コード */
    private Integer relationPersonCode = INIT_INTEGER;

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

    /** 関連者法人Id */
    private Long relationCorporationId = INIT_LONG;

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

    /** 関連者法人同一識別コード */
    private Integer relationCorporationCode = INIT_INTEGER;

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

    /** 関連者政治団体Id */
    private Long relationPoliticsOrganizationId = INIT_LONG;

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
    private Integer relationPoliticsOrganizationCode = INIT_INTEGER;

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

    /** 個人・団体住所 */
    private String orgnizationAddress = INIT_STRING;

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

    /** 団体代表者・職業 */
    private String professionOrgnizationName = INIT_STRING;

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

    /** あっせん期間開始日 */
    private LocalDate mediationStartDate = INIT_LOCALDATE;

    /**
     * あっせん期間開始日を取得する
     *
     * @return あっせん期間開始日
     */
    public LocalDate getMediationStartDate() {
        return mediationStartDate;
    }

    /**
     * あっせん期間開始日を設定する
     *
     * @param mediationStartDate あっせん期間開始日
     */
    public void setMediationStartDate(final LocalDate mediationStartDate) {
        this.mediationStartDate = mediationStartDate;
    }

    /** あっせん期間終了日 */
    private LocalDate mediationEndDate = INIT_LOCALDATE;

    /**
     * あっせん期間終了日を取得する
     *
     * @return あっせん期間終了日
     */
    public LocalDate getMediationEndDate() {
        return mediationEndDate;
    }

    /**
     * あっせん期間終了日を設定する
     *
     * @param mediationEndDate あっせん期間終了日
     */
    public void setMediationEndDate(final LocalDate mediationEndDate) {
        this.mediationEndDate = mediationEndDate;
    }

    /** パーティ日付 */
    private LocalDate partyDate = INIT_LOCALDATE;

    /**
     * パーティ日付を取得する
     *
     * @return パーティ日付
     */
    public LocalDate getPartyDate() {
        return partyDate;
    }

    /**
     * パーティ日付を設定する
     *
     * @param partyDate パーティ日付
     */
    public void setPartyDate(final LocalDate partyDate) {
        this.partyDate = partyDate;
    }

    /** 備考 */
    private String biko = INIT_STRING;

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

    /** 税額控除有無 */
    private Boolean isCreditTax = INIT_BOOLEAN;

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

    /** 寄付が遺贈有無フラグ */
    private Boolean isBequest = INIT_BOOLEAN;

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

    /** 寄付法人が上場または外資50%超え会社有無フラグ */
    private Boolean isPrimeListedOrForeign = INIT_BOOLEAN;

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

    /** 政治資金パーティ名称 */
    private String partyName = INIT_STRING;

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

    /** 意見付記 */
    private String note = INIT_STRING;

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

    /** 前例と異なる処理フラグ */
    private Boolean isDifferPrecedent = INIT_BOOLEAN;

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
    private String storagedDocumentIdList = INIT_STRING;

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

    /** 調査側意見ユーザ人数 */
    private Integer researcherAmount = INIT_INTEGER;

    /**
     * 調査側意見ユーザ人数を取得する
     *
     * @return 調査側意見ユーザ人数
     */
    public Integer getResearcherAmount() {
        return researcherAmount;
    }

    /**
     * 調査側意見ユーザ人数を設定する
     *
     * @param researcherAmount 調査側意見ユーザ人数
     */
    public void setResearcherAmount(final Integer researcherAmount) {
        this.researcherAmount = researcherAmount;
    }

    /** 監査意見支持意見の値 */
    private String auditAgreeItemValue = INIT_STRING;

    /**
     * 監査意見支持意見の値を取得する
     *
     * @return 監査意見支持意見の値
     */
    public String getAuditAgreeItemValue() {
        return auditAgreeItemValue;
    }

    /**
     * 監査意見支持意見の値を設定する
     *
     * @param auditAgreeItemValue 監査意見支持意見の値
     */
    public void setAuditAgreeItemValue(final String auditAgreeItemValue) {
        this.auditAgreeItemValue = auditAgreeItemValue;
    }

    /** 監査意見支持意見の表示テキスト */
    private String auditAgreeItemText = INIT_STRING;

    /**
     * 監査意見支持意見の表示テキストを取得する
     *
     * @return 監査意見支持意見の表示テキスト
     */
    public String getAuditAgreeItemText() {
        return auditAgreeItemText;
    }

    /**
     * 監査意見支持意見の表示テキストを設定する
     *
     * @param auditAgreeItemText 監査意見支持意見の表示テキスト
     */
    public void setAuditAgreeItemText(final String auditAgreeItemText) {
        this.auditAgreeItemText = auditAgreeItemText;
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

    /** ログインユーザ役割 */
    private String insertUserRole = INIT_STRING;

    /**
     * ログインユーザ役割を取得する
     *
     * @return ログインユーザ役割
     */
    public String getInsertUserRole() {
        return insertUserRole;
    }

    /**
     * ログインユーザ役割を設定する
     *
     * @param insertUserRole ログインユーザ役割
     */
    public void setInsertUserRole(final String insertUserRole) {
        this.insertUserRole = insertUserRole;
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

    /** ログインユーザ役割 */
    private String updateUserRole = INIT_STRING;

    /**
     * ログインユーザ役割を取得する
     *
     * @return ログインユーザ役割
     */
    public String getUpdateUserRole() {
        return updateUserRole;
    }

    /**
     * ログインユーザ役割を設定する
     *
     * @param updateUserRole ログインユーザ役割
     */
    public void setUpdateUserRole(final String updateUserRole) {
        this.updateUserRole = updateUserRole;
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
