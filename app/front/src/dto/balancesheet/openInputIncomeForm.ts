import BalancesheetIncomeDto from "../../dto/balancesheetIncomeDto";

//収入収支報告するのでとりあえずすべての入力フォームをあけます
export default function openInputIncomeForm(incomeDto:BalancesheetIncomeDto):BalancesheetIncomeDto {
    //様式区分を表示します;
    incomeDto.isUseYoshikiKbn = true;
    //様式区分枝項目を表示します
    incomeDto.isUseYoshikiEdaKbn = true;
    //あっせん期間を表示します
    incomeDto.isUseMediation = true;
    //組織名称を表示します
    incomeDto.isUseOrgName = true;
    //項目部分を表示します
    incomeDto.isUseItemName = true;
    //団体住所部分を表示します
    incomeDto.isUseAddress = true;
    //備考部分を表示ます
    incomeDto.isUseBiko = true;
    //寄付金控除を表示します
    incomeDto.isUseCreditTax = true;
    //パーティ名称を表示します
    incomeDto.isUsePartyName = true;
    //パーティ日付を表示ます
    incomeDto.isUsePartyDate = true;
    return incomeDto;
}
