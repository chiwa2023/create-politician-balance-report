import SelectOptionInterface from "../../dto/selectOptionDto";
import SelectOptionDto from "../../dto/selectOptionDto";

/**
 * CSV指定項目を取得する
 * @returns 選択肢オプション項目
 */
export default function getCsvReadItem():SelectOptionInterface[]{

    // TODO backと共通の定数値なのでbackから取得することも検討する
    const list:SelectOptionInterface[] = [];

    //| 指定なし         | 指定なしを表す定数値`0`                            | (空白)           |
    const dtoNoSelect:SelectOptionDto = new SelectOptionDto();
    dtoNoSelect.value = "0";
    dtoNoSelect.text = "指定なし";
    
    //| 取引金額支出     | 支出取引金額が入っていることを表す定数値`1`        | 取引金額支出     |
    const dtoOutcomeAmount:SelectOptionDto = new SelectOptionDto();
    dtoOutcomeAmount.value = "1";
    dtoOutcomeAmount.text = "取引金額支出";
    
    //| 取引金額収入     | 収入取引金額が入っていることを表す定数値`2`        | 取引金額収入     |
    const dtoIncomeAmount:SelectOptionDto = new SelectOptionDto();
    dtoIncomeAmount.value = "2";
    dtoIncomeAmount.text = "取引金額収入";
    
    //| 取引金額増減兼用 | 取引金額増減兼用が入っていることを表す定数値`3`    | 取引金額増減兼用 |
    const dtoAmount:SelectOptionDto = new SelectOptionDto();
    dtoAmount.value = "3";
    dtoAmount.text = "取引金額増減兼用";
    
    //| 発生日           | 発生日が入っていることを表す定数値`15`             | 発生日           |
    const dtoDate:SelectOptionDto = new SelectOptionDto();
    dtoDate.value = "15";
    dtoDate.text = "発生日";
    
    //| 摘要             | 摘要が入っていることを表す定数値`16`               | 摘要             |
    const dtoDigest:SelectOptionDto = new SelectOptionDto();
    dtoDigest.value = "16";
    dtoDigest.text = "摘要";
    
    //| 取引相手名称     | 取引の相手方データが入っていることを表す定数値`17` | 取引相手名称     |
    const dtoDealer:SelectOptionDto = new SelectOptionDto();
    dtoDealer.value = "17";
    dtoDealer.text = "取引相手名称";

    //作成した項目を追加
    list.push(dtoNoSelect);
    list.push(dtoOutcomeAmount);
    list.push(dtoIncomeAmount);
    list.push(dtoAmount);
    list.push(dtoDate);
    list.push(dtoDigest);
    list.push(dtoDealer);

    return list;
}