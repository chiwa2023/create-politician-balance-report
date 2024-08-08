export default class RealEstateDto {

    /** 不動産Id */
    balancesheetRealEstateId: number;

    /** 不動産同一識別コード */
    balancesheetRealEstateCode: number;

    /** 前年同一確認 */
    isSameData: boolean;

    /** 摘要 */
    itemName: string;

    /** 資産枝区分 */
    yoshikiEdaKbn: string;

    /** 用途 */
    purposeAll: string;

    /** 使用者と代表者の関係 */
    userRelation: string;

    /** 使用者ごとの用途 */
    userPerpose: string;

    /** 使用者ごとの使用面積 */
    userArea: number;

    /** 使用者ごとの対価の価額 */
    userAmount: number;

    constructor() {

        const INIT_STRING: string = "";
        const INIT_NUMBER: number = 0;
        const INIT_BOOLEAN: boolean = false;

        this.balancesheetRealEstateId = INIT_NUMBER;
        this.balancesheetRealEstateCode = INIT_NUMBER;
        this.isSameData = INIT_BOOLEAN;
        this.itemName = INIT_STRING;
        this.yoshikiEdaKbn = INIT_STRING;
        this.purposeAll = INIT_STRING;
        this.userRelation = INIT_STRING;
        this.userPerpose = INIT_STRING;
        this.userArea = INIT_NUMBER;
        this.userAmount = INIT_NUMBER;

    }
}