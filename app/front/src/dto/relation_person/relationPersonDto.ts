export default interface RelationPersonInterface {


}

export default class RelationPersonDto implements RelationPersonInterface {

    /** 関連者区分 */
    relationKbn: number;

    /** 関連者個人Id */
    relationPersonId: number;

    /** 関連者個人同一識別コード */
    relationPersonCode: number;

    /** 関連者法人Id */
    relationCorporationId: number;

    /** 関連者法人同一識別コード */
    relationCorporationCode: number;

    /** 関連者政治団体Id */
    relationPoliticsOrganizationId: number;

    /** 関連者政治団体同一識別コード */
    relationPoliticsOrganizationCode: number;

    /** ユーザ団体Id */
    userOrganizationId: number;

    /** ユーザ団体同一識別コード */
    userOrganizationCode: number;

    /** ユーザ団体名称 */
    userOrganizationName: string;

    /** 報告書記載名称 */
    publishItemName: string;

    /** 報告書記載住所 */
    publishOrgnizationAddress: string;

    /** 報告書記載職業または代表者氏名 */
    publishProfessionOrgnizationName: string;

    /** 項目呼び出し条件摘要 */
    callingItemDigest: string;

    /** 項目呼び出し条件各種PayId */
    callingItemVariousFinancialPayId: number;

    /** 項目呼び出し条件各種Payコード */
    callingItemVariousFinancialPayCode: number;

    /** 項目呼び出し条件各種Pay名称 */
    callingItemVariousFinancialPayName: string;

    /** 項目呼び出し条件金融機関コード */
    callingItemZenginFinancialOrgCode: string;

    /** 項目呼び出し条件金融機関名称 */
    callingItemZenginFinancialOrgName: string;

    /** 項目呼び出し条件支店コード */
    callingItemZenginBranchCode: string;

    /** 項目呼び出し条件支店名称 */
    callingItemZenginBranchName: string;

    /** 項目呼び出し条件口座種別区分 */
    callingItemAccountType: number;

    /** 項目呼び出し条件口座番号 */
    callingItemAccountNo: string;

    /** 項目呼び出し条件口座名義人 */
    callingItemAccountHas: string;

    /** 項目呼び出し条件電話番号・市外局番 */
    callingItemTel1: string;

    /** 項目呼び出し条件電話番号・局番 */
    callingItemTel2: string;

    /** 項目呼び出し条件電話番号・番号 */
    callingItemTel3: string;

    /** 項目呼び出し条件郵便番号・前 */
    callingItemPostal1: string;

    /** 項目呼び出し条件郵便番号・後 */
    callingItemPostal2: string;

    /** 項目呼び出し条件住所 */
    callingItemAddressPost: string;

    /** 項目呼び出し条件住所番地 */
    callingItemAddressBlock: string;

    /** 項目呼び出し条件住所建物 */
    callingItemAddressBuiding: string;



    constructor() {
        this.relationKbn = 0;
        this.relationPersonId = 0;
        this.relationPersonCode = 0;
        this.relationCorporationId = 0;
        this.relationCorporationCode = 0;
        this.relationPoliticsOrganizationId = 0;
        this.relationPoliticsOrganizationCode = 0;
        this.userOrganizationId = 0;
        this.userOrganizationCode = 0;
        this.userOrganizationName = "";
        this.publishItemName = "";
        this.publishOrgnizationAddress = "";
        this.publishProfessionOrgnizationName = "";
        this.callingItemDigest = "";
        this.callingItemVariousFinancialPayId = 0;
        this.callingItemVariousFinancialPayCode = 0;
        this.callingItemVariousFinancialPayName = "";
        this.callingItemZenginFinancialOrgCode = "";
        this.callingItemZenginFinancialOrgName = "";
        this.callingItemZenginBranchCode = "";
        this.callingItemZenginBranchName = "";
        this.callingItemAccountType = 0;
        this.callingItemAccountNo = "";
        this.callingItemAccountHas = "";
        this.callingItemTel1 = "";
        this.callingItemTel2 = "";
        this.callingItemTel3 = "";
        this.callingItemPostal1 = "";
        this.callingItemPostal2 = "";
        this.callingItemAddressPost = "";
        this.callingItemAddressBlock = "";
        this.callingItemAddressBuiding = "";






    }
}