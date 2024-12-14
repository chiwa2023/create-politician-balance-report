import FinacialOrgAccountDto from "../bank_account/finacialOrgAccountDto";
import FinacialOrgAccountInterface from "../bank_account/finacialOrgAccountDto";


export default interface ContinueBuissinessInterface {


}


export default class ContinueBuissinessDto implements ContinueBuissinessInterface {

    /** 継続事業Id  */
    continueBussinessId: number;

    /** 継続事業同一識別コード  */
    continueBussinessCode: number;

    /** 事業名称  */
    buissinessName: string;

    /** 金融機関口座Dto  */
    financialOrgAccaount: FinacialOrgAccountInterface;

    /** 提出年  */
    houkokuNen: number;

    /** 事業摘要  */
    digest: string;

    constructor() {
        const INIT_NUMBER: number = 0;
        const INIT_STRING: string = "";

        this.continueBussinessId = INIT_NUMBER;
        this.continueBussinessCode = INIT_NUMBER;
        this.houkokuNen = INIT_NUMBER;
        this.buissinessName = INIT_STRING;
        this.digest = INIT_STRING;
        this.financialOrgAccaount = new FinacialOrgAccountDto();
    }
}