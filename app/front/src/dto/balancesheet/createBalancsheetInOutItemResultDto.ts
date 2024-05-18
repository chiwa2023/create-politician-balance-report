import BalancesheetIncomeDto from "../balancesheetIncomeDto";
import BalancesheetOutcomeDto from "../balancesheetOutcomeDto";
import CallingItemDto from "../calling_item/callingItemDto";
import TemplateFrameworkResultDto from "../template/templateFrameworkResultDto";

export default class CreateBalancsheetInOutItemResultDto extends TemplateFrameworkResultDto{

    /** 収入項目リスト */
    listIncome: BalancesheetIncomeDto[];

    /** 支出項目リスト */
    listOutcome: BalancesheetOutcomeDto[];

    /** 検索紐づけ候補マップ */
    listCallingItem: CallingItemDto[];

    constructor() {
        super();
        this.listIncome = [];
        this.listOutcome = [];
        this.listCallingItem = [];
    }
}