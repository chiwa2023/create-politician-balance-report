import CsvCellInterface from "../../dto/read_csv/csvCell";
import BalancesheetIncomeDto from "../../dto/balancesheetIncomeDto";
import viewPrepareIncome from "./viewPrepareIncome";

/**
 * 取引コアInterfaceから収支報告書収入データに変換
 * @param line csv読取り行(1行)
 * @param inputArray csv読取り列指定
 * @returns 収支報告書収入データ
 */
export default function convertBalancesheetIncomeFromTradingCore(line: CsvCellInterface[], inputArray: string[]): BalancesheetIncomeDto | null {

    const incomeDto: BalancesheetIncomeDto = new BalancesheetIncomeDto();
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
                //支出用データなのでnullで収入処理させない
                return null;
            }
            break;

            //| 取引金額収入 `2`
        case "2":
            if (line[index].data !== "") {
                incomeDto.amount = parseInt(line[index].data);
            }
            break;

            //| 取引金額増減兼用`3`
        case "3":
            tempAmount = parseInt(line[index].data);
            if (tempAmount < 0) {
                //値が0より小さいときは支出、収入処理させない
                return null;
            }
            else {
                incomeDto.amount = tempAmount;
            }
            break;

            //| 発生日`15`
        case "15":
            incomeDto.accrualDate = line[index].data;
            break;

            //| 摘要`16`
        case "16":
            incomeDto.referDigest = line[index].data;
            break;

            //| 取引相手名称`17`
        case "17":
            break;
        }
    }

    //TODO incomeDto.referDigestデータをもとにデータを入れていく
    incomeDto.reportKbn = 1;
    incomeDto.biko = "入力備考";
    incomeDto.itemName = "ｼｴﾝｼｬ ﾊﾅｺ";
    incomeDto.youshikiKbn = 7;
    incomeDto.youshikiEdaKbn = 1;
    incomeDto.professionOrgnizationName = "弁護士";
    incomeDto.orgnizationAddress = "東京都千代田区";
    incomeDto.isCreditTax = true;

    return viewPrepareIncome(incomeDto);
}






