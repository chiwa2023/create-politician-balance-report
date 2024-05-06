import CallingItemEntity from "../../entity/callingItemEntity";
import BalancesheetIncomeDto from "../balancesheetIncomeDto";
import BalancesheetOutcomeDto from "../balancesheetOutcomeDto";

export default class CreateBalancsheetInOutItemResultDto {

    /** 収入項目リスト */
    listIncome: BalancesheetIncomeDto[];

    /** 支出項目リスト */
    listOutcome: BalancesheetOutcomeDto[];

    /** 検索紐づけ候補マップ */
    listCallingItem: CallingItemEntity[];

    constructor() {
        this.listIncome = [];
        this.listOutcome = [];
        this.listCallingItem = [];
    }
}