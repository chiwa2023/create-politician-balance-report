package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

/**
 * calling_item接続用Entity
 */
@Entity
@Table(name = "calling_item")
public class CallingItemEntity implements Serializable { // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

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

    /** 項目呼び出し条件摘要 */
    private String callingReferDigest;

    /**
     * 項目呼び出し条件摘要を取得する
     *
     * @return 項目呼び出し条件摘要
     */
    public String getCallingReferDigest() {
        return callingReferDigest;
    }

    /**
     * 項目呼び出し条件摘要を設定する
     *
     * @param callingReferDigest 項目呼び出し条件摘要
     */
    public void setCallingReferDigest(final String callingReferDigest) {
        this.callingReferDigest = callingReferDigest;
    }

    /** 関連者法人同一識別コード */
    private Integer relationCorporationCode;

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

    /** 項目呼び出し条件口座番号 */
    private String callingItemAccountNo;

    /**
     * 項目呼び出し条件口座番号を取得する
     *
     * @return 項目呼び出し条件口座番号
     */
    public String getCallingItemAccountNo() {
        return callingItemAccountNo;
    }

    /**
     * 項目呼び出し条件口座番号を設定する
     *
     * @param callingItemAccountNo 項目呼び出し条件口座番号
     */
    public void setCallingItemAccountNo(final String callingItemAccountNo) {
        this.callingItemAccountNo = callingItemAccountNo;
    }

    /** 項目呼び出し条件住所建物 */
    private String callingItemAddressBuiding;

    /**
     * 項目呼び出し条件住所建物を取得する
     *
     * @return 項目呼び出し条件住所建物
     */
    public String getCallingItemAddressBuiding() {
        return callingItemAddressBuiding;
    }

    /**
     * 項目呼び出し条件住所建物を設定する
     *
     * @param callingItemAddressBuiding 項目呼び出し条件住所建物
     */
    public void setCallingItemAddressBuiding(final String callingItemAddressBuiding) {
        this.callingItemAddressBuiding = callingItemAddressBuiding;
    }

    /** 項目呼び出し条件住所 */
    private String callingItemAddressPost;

    /**
     * 項目呼び出し条件住所を取得する
     *
     * @return 項目呼び出し条件住所
     */
    public String getCallingItemAddressPost() {
        return callingItemAddressPost;
    }

    /**
     * 項目呼び出し条件住所を設定する
     *
     * @param callingItemAddressPost 項目呼び出し条件住所
     */
    public void setCallingItemAddressPost(final String callingItemAddressPost) {
        this.callingItemAddressPost = callingItemAddressPost;
    }

    /** 関連者区分 */
    private Integer relationKbn;

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

    /** 継続事業Id */
    private Long continueBuissinessId;

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

    /** 項目呼び出し条件全銀金融機関名称 */
    private String callingItemZenginFinancialOrgName;

    /**
     * 項目呼び出し条件全銀金融機関名称を取得する
     *
     * @return 項目呼び出し条件全銀金融機関名称
     */
    public String getCallingItemZenginFinancialOrgName() {
        return callingItemZenginFinancialOrgName;
    }

    /**
     * 項目呼び出し条件全銀金融機関名称を設定する
     *
     * @param callingItemZenginFinancialOrgName 項目呼び出し条件全銀金融機関名称
     */
    public void setCallingItemZenginFinancialOrgName(final String callingItemZenginFinancialOrgName) {
        this.callingItemZenginFinancialOrgName = callingItemZenginFinancialOrgName;
    }

    /** 項目呼び出し条件各種Pay名称 */
    private String callingItemVariousFinancialPayName;

    /**
     * 項目呼び出し条件各種Pay名称を取得する
     *
     * @return 項目呼び出し条件各種Pay名称
     */
    public String getCallingItemVariousFinancialPayName() {
        return callingItemVariousFinancialPayName;
    }

    /**
     * 項目呼び出し条件各種Pay名称を設定する
     *
     * @param callingItemVariousFinancialPayName 項目呼び出し条件各種Pay名称
     */
    public void setCallingItemVariousFinancialPayName(final String callingItemVariousFinancialPayName) {
        this.callingItemVariousFinancialPayName = callingItemVariousFinancialPayName;
    }

    /** ユーザ団体名称 */
    private String userOrganizationName;

    /**
     * ユーザ団体名称を取得する
     *
     * @return ユーザ団体名称
     */
    public String getUserOrganizationName() {
        return userOrganizationName;
    }

    /**
     * ユーザ団体名称を設定する
     *
     * @param userOrganizationName ユーザ団体名称
     */
    public void setUserOrganizationName(final String userOrganizationName) {
        this.userOrganizationName = userOrganizationName;
    }

    /** 関連者個人Id */
    private Long relationPersonId;

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

    /** 関連者個人同一識別コード */
    private Integer relationPersonCode;

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

    /** 項目呼び出し条件支店コード */
    private String callingItemZenginBranchCode;

    /**
     * 項目呼び出し条件支店コードを取得する
     *
     * @return 項目呼び出し条件支店コード
     */
    public String getCallingItemZenginBranchCode() {
        return callingItemZenginBranchCode;
    }

    /**
     * 項目呼び出し条件支店コードを設定する
     *
     * @param callingItemZenginBranchCode 項目呼び出し条件支店コード
     */
    public void setCallingItemZenginBranchCode(final String callingItemZenginBranchCode) {
        this.callingItemZenginBranchCode = callingItemZenginBranchCode;
    }

    /** 継続事業同一識別コード */
    private Integer continueBuissinessCode;

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

    /** ユーザ団体Id */
    private Long userOrganizationId;

    /**
     * ユーザ団体Idを取得する
     *
     * @return ユーザ団体Id
     */
    public Long getUserOrganizationId() {
        return userOrganizationId;
    }

    /**
     * ユーザ団体Idを設定する
     *
     * @param userOrganizationId ユーザ団体Id
     */
    public void setUserOrganizationId(final Long userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }

    /** 項目名称取得同一識別コード */
    private Integer callingItemCode;

    /**
     * 項目名称取得同一識別コードを取得する
     *
     * @return 項目名称取得同一識別コード
     */
    public Integer getCallingItemCode() {
        return callingItemCode;
    }

    /**
     * 項目名称取得同一識別コードを設定する
     *
     * @param callingItemCode 項目名称取得同一識別コード
     */
    public void setCallingItemCode(final Integer callingItemCode) {
        this.callingItemCode = callingItemCode;
    }

    /** 一般項目Id */
    private Long generalItemId;

    /**
     * 一般項目Idを取得する
     *
     * @return 一般項目Id
     */
    public Long getGeneralItemId() {
        return generalItemId;
    }

    /**
     * 一般項目Idを設定する
     *
     * @param generalItemId 一般項目Id
     */
    public void setGeneralItemId(final Long generalItemId) {
        this.generalItemId = generalItemId;
    }

    /** 報告書記載名称 */
    private String publishItemName;

    /**
     * 報告書記載名称を取得する
     *
     * @return 報告書記載名称
     */
    public String getPublishItemName() {
        return publishItemName;
    }

    /**
     * 報告書記載名称を設定する
     *
     * @param publishItemName 報告書記載名称
     */
    public void setPublishItemName(final String publishItemName) {
        this.publishItemName = publishItemName;
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

    /** 項目呼び出し条件郵便番号・後 */
    private String callingItemPostal2;

    /**
     * 項目呼び出し条件郵便番号・後を取得する
     *
     * @return 項目呼び出し条件郵便番号・後
     */
    public String getCallingItemPostal2() {
        return callingItemPostal2;
    }

    /**
     * 項目呼び出し条件郵便番号・後を設定する
     *
     * @param callingItemPostal2 項目呼び出し条件郵便番号・後
     */
    public void setCallingItemPostal2(final String callingItemPostal2) {
        this.callingItemPostal2 = callingItemPostal2;
    }

    /** 項目呼び出し条件郵便番号・前 */
    private String callingItemPostal1;

    /**
     * 項目呼び出し条件郵便番号・前を取得する
     *
     * @return 項目呼び出し条件郵便番号・前
     */
    public String getCallingItemPostal1() {
        return callingItemPostal1;
    }

    /**
     * 項目呼び出し条件郵便番号・前を設定する
     *
     * @param callingItemPostal1 項目呼び出し条件郵便番号・前
     */
    public void setCallingItemPostal1(final String callingItemPostal1) {
        this.callingItemPostal1 = callingItemPostal1;
    }

    /** 項目呼び出し条件全銀金融機関コード */
    private String callingItemZenginFinancialOrgCode;

    /**
     * 項目呼び出し条件全銀金融機関コードを取得する
     *
     * @return 項目呼び出し条件全銀金融機関コード
     */
    public String getCallingItemZenginFinancialOrgCode() {
        return callingItemZenginFinancialOrgCode;
    }

    /**
     * 項目呼び出し条件全銀金融機関コードを設定する
     *
     * @param callingItemZenginFinancialOrgCode 項目呼び出し条件全銀金融機関コード
     */
    public void setCallingItemZenginFinancialOrgCode(final String callingItemZenginFinancialOrgCode) {
        this.callingItemZenginFinancialOrgCode = callingItemZenginFinancialOrgCode;
    }

    /** 項目呼び出し条件電話番号・番号 */
    private String callingItemTel3;

    /**
     * 項目呼び出し条件電話番号・番号を取得する
     *
     * @return 項目呼び出し条件電話番号・番号
     */
    public String getCallingItemTel3() {
        return callingItemTel3;
    }

    /**
     * 項目呼び出し条件電話番号・番号を設定する
     *
     * @param callingItemTel3 項目呼び出し条件電話番号・番号
     */
    public void setCallingItemTel3(final String callingItemTel3) {
        this.callingItemTel3 = callingItemTel3;
    }

    /** 項目呼び出し条件電話番号・局番 */
    private String callingItemTel2;

    /**
     * 項目呼び出し条件電話番号・局番を取得する
     *
     * @return 項目呼び出し条件電話番号・局番
     */
    public String getCallingItemTel2() {
        return callingItemTel2;
    }

    /**
     * 項目呼び出し条件電話番号・局番を設定する
     *
     * @param callingItemTel2 項目呼び出し条件電話番号・局番
     */
    public void setCallingItemTel2(final String callingItemTel2) {
        this.callingItemTel2 = callingItemTel2;
    }

    /** 一般項目同一識別コード */
    private Integer generalItemCode;

    /**
     * 一般項目同一識別コードを取得する
     *
     * @return 一般項目同一識別コード
     */
    public Integer getGeneralItemCode() {
        return generalItemCode;
    }

    /**
     * 一般項目同一識別コードを設定する
     *
     * @param generalItemCode 一般項目同一識別コード
     */
    public void setGeneralItemCode(final Integer generalItemCode) {
        this.generalItemCode = generalItemCode;
    }

    /** 項目呼び出し条件電話番号・市外局番 */
    private String callingItemTel1;

    /**
     * 項目呼び出し条件電話番号・市外局番を取得する
     *
     * @return 項目呼び出し条件電話番号・市外局番
     */
    public String getCallingItemTel1() {
        return callingItemTel1;
    }

    /**
     * 項目呼び出し条件電話番号・市外局番を設定する
     *
     * @param callingItemTel1 項目呼び出し条件電話番号・市外局番
     */
    public void setCallingItemTel1(final String callingItemTel1) {
        this.callingItemTel1 = callingItemTel1;
    }

    /** 報告書記載住所 */
    private String publishOrgnizationAddress;

    /**
     * 報告書記載住所を取得する
     *
     * @return 報告書記載住所
     */
    public String getPublishOrgnizationAddress() {
        return publishOrgnizationAddress;
    }

    /**
     * 報告書記載住所を設定する
     *
     * @param publishOrgnizationAddress 報告書記載住所
     */
    public void setPublishOrgnizationAddress(final String publishOrgnizationAddress) {
        this.publishOrgnizationAddress = publishOrgnizationAddress;
    }

    /** ユーザ団体同一識別コード */
    private Integer userOrganizationCode;

    /**
     * ユーザ団体同一識別コードを取得する
     *
     * @return ユーザ団体同一識別コード
     */
    public Integer getUserOrganizationCode() {
        return userOrganizationCode;
    }

    /**
     * ユーザ団体同一識別コードを設定する
     *
     * @param userOrganizationCode ユーザ団体同一識別コード
     */
    public void setUserOrganizationCode(final Integer userOrganizationCode) {
        this.userOrganizationCode = userOrganizationCode;
    }

    /** 項目呼び出し条件各種PayId */
    private Long callingItemVariousFinancialPayId;

    /**
     * 項目呼び出し条件各種PayIdを取得する
     *
     * @return 項目呼び出し条件各種PayId
     */
    public Long getCallingItemVariousFinancialPayId() {
        return callingItemVariousFinancialPayId;
    }

    /**
     * 項目呼び出し条件各種PayIdを設定する
     *
     * @param callingItemVariousFinancialPayId 項目呼び出し条件各種PayId
     */
    public void setCallingItemVariousFinancialPayId(final Long callingItemVariousFinancialPayId) {
        this.callingItemVariousFinancialPayId = callingItemVariousFinancialPayId;
    }

    /** 項目名称取得名称 */
    private String callingItemName;

    /**
     * 項目名称取得名称を取得する
     *
     * @return 項目名称取得名称
     */
    public String getCallingItemName() {
        return callingItemName;
    }

    /**
     * 項目名称取得名称を設定する
     *
     * @param callingItemName 項目名称取得名称
     */
    public void setCallingItemName(final String callingItemName) {
        this.callingItemName = callingItemName;
    }

    /** 項目呼び出し条件口座名義人 */
    private String callingItemAccountHas;

    /**
     * 項目呼び出し条件口座名義人を取得する
     *
     * @return 項目呼び出し条件口座名義人
     */
    public String getCallingItemAccountHas() {
        return callingItemAccountHas;
    }

    /**
     * 項目呼び出し条件口座名義人を設定する
     *
     * @param callingItemAccountHas 項目呼び出し条件口座名義人
     */
    public void setCallingItemAccountHas(final String callingItemAccountHas) {
        this.callingItemAccountHas = callingItemAccountHas;
    }

    /** 項目呼び出し条件各種Payコード */
    private Integer callingItemVariousFinancialPayCode;

    /**
     * 項目呼び出し条件各種Payコードを取得する
     *
     * @return 項目呼び出し条件各種Payコード
     */
    public Integer getCallingItemVariousFinancialPayCode() {
        return callingItemVariousFinancialPayCode;
    }

    /**
     * 項目呼び出し条件各種Payコードを設定する
     *
     * @param callingItemVariousFinancialPayCode 項目呼び出し条件各種Payコード
     */
    public void setCallingItemVariousFinancialPayCode(final Integer callingItemVariousFinancialPayCode) {
        this.callingItemVariousFinancialPayCode = callingItemVariousFinancialPayCode;
    }

    /** 報告書記載名称区分 */
    private Integer publishItemKbn;

    /**
     * 報告書記載名称区分を取得する
     *
     * @return 報告書記載名称区分
     */
    public Integer getPublishItemKbn() {
        return publishItemKbn;
    }

    /**
     * 報告書記載名称区分を設定する
     *
     * @param publishItemKbn 報告書記載名称区分
     */
    public void setPublishItemKbn(final Integer publishItemKbn) {
        this.publishItemKbn = publishItemKbn;
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

    /** 関連者政治団体Id */
    private Long relationPoliticsOrganizationId;

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

    /** 項目呼び出し条件支店名称 */
    private String callingItemZenginBranchName;

    /**
     * 項目呼び出し条件支店名称を取得する
     *
     * @return 項目呼び出し条件支店名称
     */
    public String getCallingItemZenginBranchName() {
        return callingItemZenginBranchName;
    }

    /**
     * 項目呼び出し条件支店名称を設定する
     *
     * @param callingItemZenginBranchName 項目呼び出し条件支店名称
     */
    public void setCallingItemZenginBranchName(final String callingItemZenginBranchName) {
        this.callingItemZenginBranchName = callingItemZenginBranchName;
    }

    /** 項目呼び出し条件口座種別区分 */
    private Integer callingItemAccountType;

    /**
     * 項目呼び出し条件口座種別区分を取得する
     *
     * @return 項目呼び出し条件口座種別区分
     */
    public Integer getCallingItemAccountType() {
        return callingItemAccountType;
    }

    /**
     * 項目呼び出し条件口座種別区分を設定する
     *
     * @param callingItemAccountType 項目呼び出し条件口座種別区分
     */
    public void setCallingItemAccountType(final Integer callingItemAccountType) {
        this.callingItemAccountType = callingItemAccountType;
    }

    /** 関連者政治団体同一識別コード */
    private Integer relationPoliticsOrganizationCode;

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

    /** 項目呼び出し条件住所番地 */
    private String callingItemAddressBlock;

    /**
     * 項目呼び出し条件住所番地を取得する
     *
     * @return 項目呼び出し条件住所番地
     */
    public String getCallingItemAddressBlock() {
        return callingItemAddressBlock;
    }

    /**
     * 項目呼び出し条件住所番地を設定する
     *
     * @param callingItemAddressBlock 項目呼び出し条件住所番地
     */
    public void setCallingItemAddressBlock(final String callingItemAddressBlock) {
        this.callingItemAddressBlock = callingItemAddressBlock;
    }

    /** 関連者法人Id */
    private Long relationCorporationId;

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

    /** 報告書記載職業または代表者氏名 */
    private String publishProfessionOrgnizationName;

    /**
     * 報告書記載職業または代表者氏名を取得する
     *
     * @return 報告書記載職業または代表者氏名
     */
    public String getPublishProfessionOrgnizationName() {
        return publishProfessionOrgnizationName;
    }

    /**
     * 報告書記載職業または代表者氏名を設定する
     *
     * @param publishProfessionOrgnizationName 報告書記載職業または代表者氏名
     */
    public void setPublishProfessionOrgnizationName(final String publishProfessionOrgnizationName) {
        this.publishProfessionOrgnizationName = publishProfessionOrgnizationName;
    }

    /** 項目名称取得Id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long callingItemId;

    /**
     * 項目名称取得Idを取得する
     *
     * @return 項目名称取得Id
     */
    public Long getCallingItemId() {
        return callingItemId;
    }

    /**
     * 項目名称取得Idを設定する
     *
     * @param callingItemId 項目名称取得Id
     */
    public void setCallingItemId(final Long callingItemId) {
        this.callingItemId = callingItemId;
    }

    /** 様式区分 */
    private Integer youshikiKbn;

    /** 様式枝区分項目 */
    private Integer youshikiEdaKbn;

    /**
     * 様式区分を取得する
     *
     * @return 様式区分
     */
    public Integer getYoushikiKbn() {
        return youshikiKbn;
    }

    /**
     * 様式区分を設定する
     *
     * @param youshikiKbn 様式区分
     */
    public void setYoushikiKbn(final Integer youshikiKbn) {
        this.youshikiKbn = youshikiKbn;
    }

    /**
     * 様式枝区分項目を取得する
     *
     * @return 様式枝区分項目
     */
    public Integer getYoushikiEdaKbn() {
        return youshikiEdaKbn;
    }

    /**
     * 様式枝区分項目を設定する
     *
     * @param youshikiEdaKbn 様式枝区分項目
     */
    public void setYoushikiEdaKbn(final Integer youshikiEdaKbn) {
        this.youshikiEdaKbn = youshikiEdaKbn;
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
