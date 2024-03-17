import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";

//支出の収支報告するのでとりあえずすべての入力フォームをあけます
export default function openInputOutcomeForm(outcomeDto:BalancesheetOutcomeDto): BalancesheetOutcomeDto {
    //様式区分を表示します;
    outcomeDto.isUseYoshikiKbn = true;
    //様式区分枝項目を表示します
    outcomeDto.isUseYoshikiEdaKbn = true;
    //組織名称を表示します
    outcomeDto.isUseOrgName = true;
    //項目部分を表示します
    outcomeDto.isUseItemName = true;
    //団体住所部分を表示します
    outcomeDto.isUseAddress = true;
    //備考部分を表示ます
    outcomeDto.isUseBiko = true;
    //寄付金控除を表示します
    outcomeDto.isUseRelatedGrants = true;
    outcomeDto.isUseCollectRecipt = true;
    //パーティ名称を表示します
    outcomeDto.isUseCategorizedGroup = true;
    //パーティ日付を表示します
    outcomeDto.isUseItemName = true;

    return outcomeDto;
}
