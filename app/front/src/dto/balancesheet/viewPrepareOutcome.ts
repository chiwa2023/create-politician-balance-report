import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
import closeInputOutcomeForm from "./closeInputOutcomeForm";
import openInputOutcomeForm from "./openInputOutcomeForm";
import changeOutcomeYoshikiKbnState from "./changeOutcomeYoshikiKbnState";

export default function viewPrepareOutcome(outcomeDto: BalancesheetOutcomeDto): BalancesheetOutcomeDto {

    switch (outcomeDto.reportKbn) {
    //報告対象
    case 1:
        //収支報告するのですべての入力フォームを開きます
        outcomeDto = openInputOutcomeForm(changeOutcomeYoshikiKbnState(outcomeDto));
        break;
    //生活費
    case 20:
        //収支報告しないのですべての入力フォームを閉じます
        closeInputOutcomeForm(outcomeDto);
        break;
        //政治活動
    case 11:
        //収支報告しないのですべての入力フォームを閉じます
        closeInputOutcomeForm(outcomeDto);
        break;
        //政治活動
    case 50:
        //後で入力したい、ということなので入力自体は可能です
        outcomeDto = openInputOutcomeForm(changeOutcomeYoshikiKbnState(outcomeDto));
        break;
    }
    return outcomeDto;
}
