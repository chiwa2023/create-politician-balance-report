import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
import getOrdinaryExpensesEdaKbn from "./getOrdinaryExpensesEdaKbn";
import getPoliticalExpensesEdaKbn from "./getPoliticalExpensesEdaKbn";

/**
 * 支出様式区分変更時の処理
 * @param outcomeDto 収支報告書支出データ
 * @returns 収支報告書支出データ
 */
export default function changeOutcomeYoshikiKbnState(outcomeDto:BalancesheetOutcomeDto):BalancesheetOutcomeDto {

    switch (outcomeDto.yoshikiKbn) {
    case "14":
        outcomeDto.isUseYoshikiEdaKbn = true;
        outcomeDto.yoshikiEdaKbnOptions = getOrdinaryExpensesEdaKbn();
        break;

    case "15":
        outcomeDto.isUseYoshikiEdaKbn = true;
        outcomeDto.yoshikiEdaKbnOptions = getPoliticalExpensesEdaKbn();
        break;

    case "16":
        outcomeDto.isUseYoshikiEdaKbn = false;
        break;
    }
    return outcomeDto;    
}
