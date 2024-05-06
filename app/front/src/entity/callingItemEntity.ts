
export default class CallingItemEntity {

    /** ログインユーザ同一識別コード */
    loginUserCode: number;

    /** 項目呼び出し条件摘要 */
    callingReferDigest: string;

    /** 関連者法人同一識別コード */
    relationCorporationCode: number;

    /** 項目呼び出し条件口座番号 */
    callingItemAccountNo: string;

    /** 項目呼び出し条件住所建物 */
    callingItemAddressBuiding: string;

    /** 項目呼び出し条件住所 */
    callingItemAddressPost: string;

    /** 関連者区分 */
    relationKbn: number;

    /** 継続事業Id */
    continueBuissinessId: number;

    /** 項目呼び出し条件全銀金融機関名称 */
    callingItemZenginFinancialOrgName: string;

    /** 項目呼び出し条件各種Pay名称 */
    callingItemVariousFinancialPayName: string;

    /** ユーザ団体名称 */
    userOrganizationName: string;

    /** 関連者個人Id */
    relationPersonId: number;

    /** 更新時間 */
    updateTime: Date;

    /** 関連者個人同一識別コード */
    relationPersonCode: number;

    /** 項目呼び出し条件支店コード */
    callingItemZenginBranchCode: string;

    /** 継続事業同一識別コード */
    continueBuissinessCode: number;

    /** ユーザ団体Id */
    userOrganizationId: number;

    /** 項目名称取得同一識別コード */
    callingItemCode: number;

    /** 一般項目Id */
    generalItemId: number;

    /** 報告書記載名称 */
    publishItemName: string;

    /** ログインユーザId */
    loginUserId: number;

    /** ログインユーザ氏名 */
    loginUserName: string;

    /** 項目呼び出し条件郵便番号・後 */
    callingItemPostal2: string;

    /** 項目呼び出し条件郵便番号・前 */
    callingItemPostal1: string;

    /** 項目呼び出し条件全銀金融機関コード */
    callingItemZenginFinancialOrgCode: string;

    /** 項目呼び出し条件電話番号・番号 */
    callingItemTel3: string;

    /** 項目呼び出し条件電話番号・局番 */
    callingItemTel2: string;

    /** 一般項目同一識別コード */
    generalItemCode: number;

    /** 項目呼び出し条件電話番号・市外局番 */
    callingItemTel1: string;

    /** 報告書記載住所 */
    publishOrgnizationAddress: string;

    /** ユーザ団体同一識別コード */
    userOrganizationCode: number;

    /** 項目呼び出し条件各種PayId */
    callingItemVariousFinancialPayId: number;

    /** 項目名称取得名称 */
    callingItemName: string;

    /** 項目呼び出し条件口座名義人 */
    callingItemAccountHas: string;

    /** 項目呼び出し条件各種Payコード */
    callingItemVariousFinancialPayCode: number;

    /** 報告書記載名称区分 */
    publishItemKbn: number;

    /** 最新区分 */
    saishinKbn: number;

    /** 関連者政治団体Id */
    relationPoliticsOrganizationId: number;

    /** 項目呼び出し条件支店名称 */
    callingItemZenginBranchName: string;

    /** 項目呼び出し条件口座種別区分 */
    callingItemAccountType: number;

    /** 関連者政治団体同一識別コード */
    relationPoliticsOrganizationCode: number;

    /** 項目呼び出し条件住所番地 */
    callingItemAddressBlock: string;

    /** 関連者法人Id */
    relationCorporationId: number;

    /** 報告書記載職業または代表者氏名 */
    publishProfessionOrgnizationName: string;

    /** 項目名称取得Id */
    callingItemId: number;

    /** 様式区分 */
    youshikiKbn: number;

    /** 様式枝区分項目 */
    youshikiEdaKbn: number;

    constructor() {
        this.loginUserCode = 0;
        this.loginUserName = "";
        this.callingReferDigest = "";
        this.relationCorporationCode = 0;
        this.callingItemAccountNo = "";
        this.callingItemAddressBuiding = "";
        this.callingItemAddressPost = "";
        this.relationKbn = 0;
        this.continueBuissinessId = 0;
        this.callingItemZenginFinancialOrgName = "";
        this.callingItemVariousFinancialPayName = "";
        this.userOrganizationName = "";
        this.relationPersonId = 0;
        this.updateTime = new Date();
        this.relationPersonCode = 0;
        this.callingItemZenginBranchCode = "";
        this.continueBuissinessCode = 0;
        this.userOrganizationId = 0;
        this.callingItemCode = 0;
        this.generalItemId = 0;
        this.publishItemName = "";
        this.loginUserId = 0;
        this.callingItemPostal2 = "";
        this.callingItemPostal1 = "";
        this.callingItemZenginFinancialOrgCode = "";
        this.callingItemTel3 = "";
        this.callingItemTel2 = "";
        this.generalItemCode = 0;
        this.callingItemTel1 = "";
        this.publishOrgnizationAddress = "";
        this.userOrganizationCode = 0;
        this.callingItemVariousFinancialPayId = 0;
        this.callingItemName = "";
        this.callingItemAccountHas = "";
        this.callingItemVariousFinancialPayCode = 0;
        this.publishItemKbn = 0;
        this.saishinKbn = 0;
        this.relationPoliticsOrganizationId = 0;
        this.callingItemZenginBranchName = "";
        this.callingItemAccountType = 0;
        this.relationPoliticsOrganizationCode = 0;
        this.callingItemAddressBlock = "";
        this.relationCorporationId = 0;
        this.publishProfessionOrgnizationName = "";
        this.callingItemId = 0;
        this.youshikiKbn = 0;
        this.youshikiEdaKbn = 0;

    }


}