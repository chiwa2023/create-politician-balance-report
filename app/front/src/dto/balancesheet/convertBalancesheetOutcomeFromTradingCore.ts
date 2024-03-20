import CsvCellInterface from "../../dto/read_csv/csvCell";
import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
import viewPrepareOutcome from "./viewPrepareOutcome";
import getOrdinaryExpensesEdaKbn from "./getOrdinaryExpensesEdaKbn";

/**
 * 取引コアInterfaceから収支報告書支出データに変換
 * @param line CSVの行
 * @param inputArray ＣSV読み取り指定配列
 * @returns 収支報告書支出データ
 */
export default function convertBalancesheetOutcomeFromTradingCore(line: CsvCellInterface[], inputArray: string[]): BalancesheetOutcomeDto | null {

    const outcomeDto: BalancesheetOutcomeDto = new BalancesheetOutcomeDto();
    const maxSize = line.length;
    let action: string = "";
    let tempAmount: number = 0;
    for (let index = 0; index < maxSize; index++) {
        action = inputArray[index];
        switch (action) {
        //| 指定なし`0`
        case "0":
            //何もしない
            break;

            //| 取引金額支出 `1`
        case "1":
            if (line[index].data !== "") {
                outcomeDto.amount = parseInt(line[index].data);
            }
            break;

            //| 取引金額収入 `2`
        case "2":
            if (line[index].data !== "") {
                //支出用データなのでnullで収入処理させない
                return null;
            }
            break;

            //| 取引金額増減兼用`3`
        case "3":
            tempAmount = parseInt(line[index].data);
            if (tempAmount < 0) {
                outcomeDto.amount = tempAmount;
            }
            else {
                //値が0より大きいときは収入、支出処理させない
                return null;
            }
            break;

            //| 発生日`15`
        case "15":
            outcomeDto.accrualDate = line[index].data;
            break;

            //| 摘要`16`
        case "16":
            outcomeDto.referDigest = line[index].data;
            break;

            //| 取引相手名称`17`
        case "17":
            break;
        }
    }

    //TODO outcomeDto.referDigestデータをもとにデータを入れていく
    outcomeDto.reportKbn = 1;
    outcomeDto.biko = "入力備考";
    outcomeDto.itemName = "ﾁﾎｳｷﾞｲﾝ11";
    outcomeDto.yoshikiKbn = "15";
    outcomeDto.yoshikiEdaKbn = "1";
    outcomeDto.shimeiOrgnizationName = "市議会議員";
    outcomeDto.orgnizationAddress = "東京都千代田区";
    outcomeDto.isExpendituresRelatedGrants = true;
    outcomeDto.notCollectReciptKbn = 1;
    outcomeDto.yoshikiEdaKbnOptions = getOrdinaryExpensesEdaKbn();
    outcomeDto.categorizeGroup = "お祝いパーティ";

    return viewPrepareOutcome(outcomeDto);
}

