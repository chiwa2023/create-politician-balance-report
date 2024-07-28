package mitei.mitei.create.report.balance.politician.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import mitei.mitei.create.report.balance.politician.entity_interface.AllTabeDataHistoryInterface;


/**
 * calling_item接続用Entity
 */
@Entity
@Table(name = "calling_item")
public class CallingItemEntity  implements Serializable,AllTabeDataHistoryInterface{ // NOPMD DataClass

    /** Serialize id */
    private static final long serialVersionUID = 1L;

    /** 初期データ(String) */
    private static final String INIT_STRING = "";

    /** 初期データ(Integer) */
    private static final Integer INIT_INTEGER = 0;
    
    /** 初期データ(Long) */
    private static final Long INIT_LONG = 0L;

    /** 初期データ(LocalcDate) */
    private static final LocalDate INIT_LOCALDATE = LocalDate.of(1980,1,1);

    /** 初期データ(Timestamp) */
    private static final Timestamp INIT_TIMESTAMP  = Timestamp.valueOf(INIT_LOCALDATE.atTime(0, 0, 0));

    /** 項目名称取得Id */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long callingItemId = INIT_LONG;

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

    /** 項目名称取得同一識別コード */
    private Integer callingItemCode = INIT_INTEGER;

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

    /** 項目名称取得名称 */
    private String callingItemName = INIT_STRING;

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

    /** ユーザ団体Id */
    private Long userOrganizationId = INIT_LONG;

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

    /** ユーザ団体同一識別コード */
    private Integer userOrganizationCode = INIT_INTEGER;

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

    /** ユーザ団体名称 */
    private String userOrganizationName = INIT_STRING;

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

    /** 項目呼び出し条件摘要 */
    private String callingReferDigest = INIT_STRING;

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

    /** 項目呼び出し条件各種PayId */
    private Long callingItemVariousFinancialPayId = INIT_LONG;

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

    /** 項目呼び出し条件各種Payコード */
    private Integer callingItemVariousFinancialPayCode = INIT_INTEGER;

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

    /** 項目呼び出し条件各種Pay名称 */
    private String callingItemVariousFinancialPayName = INIT_STRING;

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

    /** 項目呼び出し条件全銀金融機関コード */
    private String callingItemZenginFinancialOrgCode = INIT_STRING;

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

    /** 項目呼び出し条件全銀金融機関名称 */
    private String callingItemZenginFinancialOrgName = INIT_STRING;

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

    /** 項目呼び出し条件支店コード */
    private String callingItemZenginBranchCode = INIT_STRING;

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

    /** 項目呼び出し条件支店名称 */
    private String callingItemZenginBranchName = INIT_STRING;

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
    private Integer callingItemAccountType = INIT_INTEGER;

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

    /** 項目呼び出し条件口座番号 */
    private String callingItemAccountNo = INIT_STRING;

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

    /** 口座情報有無 */
    private String callingItemAccountHas = INIT_STRING;

    /**
     * 口座情報有無を取得する
     *
     * @return 口座情報有無
     */
    public String getCallingItemAccountHas() {
        return callingItemAccountHas;
    }

    /**
     * 口座情報有無を設定する
     *
     * @param callingItemAccountHas 口座情報有無
     */
    public void setCallingItemAccountHas(final String callingItemAccountHas) {
        this.callingItemAccountHas = callingItemAccountHas;
    }

    /** 項目呼び出し条件電話番号・市外局番 */
    private String callingItemTel1 = INIT_STRING;

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

    /** 項目呼び出し条件電話番号・局番 */
    private String callingItemTel2 = INIT_STRING;

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

    /** 項目呼び出し条件電話番号・番号 */
    private String callingItemTel3 = INIT_STRING;

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

    /**  */
    private String callingItemPostal1 = INIT_STRING;

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

    /** 項目呼び出し条件郵便番号・後 */
    private String callingItemPostal2 = INIT_STRING;

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

    /** 項目呼び出し条件住所 */
    private String callingItemAddressPost = INIT_STRING;

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

    /** 項目呼び出し条件住所番地 */
    private String callingItemAddressBlock = INIT_STRING;

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

    /** 項目呼び出し条件住所建物 */
    private String callingItemAddressBuiding = INIT_STRING;

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

    /** 様式区分 */
    private Integer youshikiKbn = INIT_INTEGER;

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

    /** 様式枝区分項目 */
    private Integer youshikiEdaKbn = INIT_INTEGER;

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

    /** 報告書記載名称区分 */
    private Integer publishItemKbn = INIT_INTEGER;

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

    /** 報告書記載名称 */
    private String publishItemName = INIT_STRING;

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

    /** 報告書記載住所 */
    private String publishOrgnizationAddress = INIT_STRING;

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

    /** 職業または団体名称 */
    private String publishProfessionOrgnizationName = INIT_STRING;

    /**
     * 職業または団体名称を取得する
     *
     * @return 職業または団体名称
     */
    public String getPublishProfessionOrgnizationName() {
        return publishProfessionOrgnizationName;
    }

    /**
     * 職業または団体名称を設定する
     *
     * @param publishProfessionOrgnizationName 職業または団体名称
     */
    public void setPublishProfessionOrgnizationName(final String publishProfessionOrgnizationName) {
        this.publishProfessionOrgnizationName = publishProfessionOrgnizationName;
    }

    /** 一般項目Id */
    private Long generalItemId = INIT_LONG;

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

    /** 一般項目同一識別コード */
    private Integer generalItemCode = INIT_INTEGER;

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

    /** 関連者Id */
    private Long relationPersonId = INIT_LONG;

    /**
     * 関連者Idを取得する
     *
     * @return 関連者Id
     */
    public Long getRelationPersonId() {
        return relationPersonId;
    }

    /**
     * 関連者Idを設定する
     *
     * @param relationPersonId 関連者Id
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

    /** 関連法人Id */
    private Long relationCorporationId = INIT_LONG;

    /**
     * 関連法人Idを取得する
     *
     * @return 関連法人Id
     */
    public Long getRelationCorporationId() {
        return relationCorporationId;
    }

    /**
     * 関連法人Idを設定する
     *
     * @param relationCorporationId 関連法人Id
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

    /** 関連政治団体Id */
    private Long relationPoliticsOrganizationId = INIT_LONG;

    /**
     * 関連政治団体Idを取得する
     *
     * @return 関連政治団体Id
     */
    public Long getRelationPoliticsOrganizationId() {
        return relationPoliticsOrganizationId;
    }

    /**
     * 関連政治団体Idを設定する
     *
     * @param relationPoliticsOrganizationId 関連政治団体Id
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
    private Timestamp insertTimestamp = INIT_TIMESTAMP ;

    /**
     * 挿入タイムスタンプを取得する
     *
     * @return 挿入タイムスタンプ
     */
    @Override
    public Timestamp getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * 挿入タイムスタンプを設定する
     *
     * @param insertTimestamp 挿入タイムスタンプ
     */
    @Override
    public void setInsertTimestamp(final Timestamp insertTimestamp) {
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
    private Timestamp updateTimestamp = INIT_TIMESTAMP ;

    /**
     * 更新タイムスタンプを取得する
     *
     * @return 更新タイムスタンプ
     */
    @Override
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    /**
     * 更新タイムスタンプを設定する
     *
     * @param updateTimestamp 更新タイムスタンプ
     */
    @Override
    public void setUpdateTimestamp(final Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }


}
