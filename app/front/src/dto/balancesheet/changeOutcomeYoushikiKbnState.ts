﻿import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
import getOrdinaryExpensesEdaKbn from "./getOrdinaryExpensesEdaKbn";
import getPoliticalExpensesEdaKbn from "./getPoliticalExpensesEdaKbn";

/**
 * 支出様式区分変更時の処理
 * @param outcomeDto 収支報告書支出データ
 * @returns 収支報告書支出データ
 */
export default function changeOutcomeYoushikiKbnState(outcomeDto:BalancesheetOutcomeDto):BalancesheetOutcomeDto {

    //収支報告するときは常に大項目はオープン
    outcomeDto.isUseYoushikiKbn = true;

    switch (String(outcomeDto.youshikiKbn)) {
    case "14":
        outcomeDto.isUseYoushikiEdaKbn = true;
        outcomeDto.youshikiEdaKbnOptions = getOrdinaryExpensesEdaKbn();
        break;

    case "15":
        outcomeDto.isUseYoushikiEdaKbn = true;
        outcomeDto.youshikiEdaKbnOptions = getPoliticalExpensesEdaKbn();
        break;

    case "16":
        outcomeDto.isUseYoushikiEdaKbn = false;
        break;
    }
    return outcomeDto;    
}
