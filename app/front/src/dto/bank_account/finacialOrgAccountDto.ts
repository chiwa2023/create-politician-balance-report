export default interface FinacialOrgAccountInterface {

}

export default class FinacialOrgAccountDto implements FinacialOrgAccountInterface {

    /** 金融機関と支店Id(内部用) */
    finacialOrgId: number;

    /** 金融機関と支店同一識別コード(内部用) */
    finacialOrgCode: number;

    /** 全銀金融機関共通コード */
    zenginFinacialOrgCode: string;

    /** 全銀金融機関名称 */
    finacialOrgName: string;

    /** 全銀金融機関支店共通コード */
    zenginFinacialBranchCode: string;

    /** 全銀金融機関支店名称 */
    finacialBranchName: string;

    /** 口座種別 */
    typeAccount: string;

    /** 口座種別名称 */
    typeAccountText: string;

    /** 口座番号 */
    accountNumber: string;

    /** 口座名義人(カナ) */
    accountMeiginin: string;

    constructor() {

        const INIT_NUMBER: number = 0;
        const INIT_STRING: string = "";

        this.finacialOrgId = INIT_NUMBER;
        this.finacialOrgCode = INIT_NUMBER;
        this.zenginFinacialOrgCode = INIT_STRING;
        this.finacialOrgName = INIT_STRING;
        this.zenginFinacialBranchCode = INIT_STRING;
        this.finacialBranchName = INIT_STRING;
        this.typeAccount = INIT_STRING;
        this.typeAccountText = INIT_STRING;
        this.accountNumber = INIT_STRING;
        this.accountMeiginin = INIT_STRING;

    }
}