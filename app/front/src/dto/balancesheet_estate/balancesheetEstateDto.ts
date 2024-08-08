import RealEstateDto from "./realEstateDto";

export default interface BalancesheetEstateInterface {

}

export default class BalancesheetEstateDto implements BalancesheetEstateInterface {

    /** 収支報告書資産Id */
    balancesheetEstateId: number;

    /** 収支報告書資産同一識別コード */
    balancesheetEstateCode: number;

    /** 前年同一確認 */
    isSameData: boolean;

    /** 様式仕訳区分 */
    yoshikiKbn: string;

    /** 様式仕訳枝項目区分 */
    yoshikiEdaKbn: string;

    /** 摘要 */
    itemName: string;

    /** 取引金額 */
    amount: number;

    /** 発生年月日 */
    accrualDate: string;

    /** 備考 */
    biko: string;

    /** 不動産使用目的リスト */
    listRealEstate: RealEstateDto[];

    constructor() {
        const INIT_NUMBER: number = 0;
        const INIT_STRING: string = "";
        const INIT_LOACLDATE: string = "1980-01-01";
        const INIT_BOOLEAN: boolean = false;

        this.balancesheetEstateId = INIT_NUMBER;
        this.balancesheetEstateCode = INIT_NUMBER;
        this.isSameData = INIT_BOOLEAN;
        this.yoshikiKbn = INIT_STRING;
        this.yoshikiEdaKbn = INIT_STRING;
        this.itemName = INIT_STRING;
        this.amount = INIT_NUMBER;
        this.accrualDate = INIT_LOACLDATE;
        this.biko = INIT_STRING;
        this.listRealEstate = [];

    }
}