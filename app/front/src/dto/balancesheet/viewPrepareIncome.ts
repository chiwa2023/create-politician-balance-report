import BalancesheetIncomeDto from "../../dto/balancesheetIncomeDto";
import closeInputIncomeForm from "./closeInputIncomeForm";
import openInputIncomeForm from "./openInputIncomeForm";
import changeIncomeYoshikiKbnState from "./changeIncomeYoshikiKbnState";

export default function viewPrepareIncome(incomeDto:BalancesheetIncomeDto):BalancesheetIncomeDto{

    switch (incomeDto.reportKbn) {
    //報告対象
    case 1:
        //収支報告するのですべての入力フォームを開きます
        incomeDto = openInputIncomeForm(changeIncomeYoshikiKbnState(incomeDto));
        break;
        //生活費
    case 20:
        //収支報告しないのですべての入力フォームを閉じます
        closeInputIncomeForm(incomeDto);
        break;
        //政治活動
    case 11:
        //収支報告しないのですべての入力フォームを閉じます
        closeInputIncomeForm(incomeDto);
        break;
        //政治活動
    case 50:
        //後で入力したい、ということなので入力自体は可能です
        incomeDto = openInputIncomeForm(changeIncomeYoshikiKbnState(incomeDto));
        break;
    }

    return incomeDto;
}
