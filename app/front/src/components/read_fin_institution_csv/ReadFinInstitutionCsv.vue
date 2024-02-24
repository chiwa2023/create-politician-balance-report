<script setup lang="ts">
import { ref, Ref, watch } from 'vue';
import mockReadTemplate from './mock/mockReadTemplate';
import CsvReadTemplateInterface from '../../dto/read_csv/csvReadTemplate';
import CsvReadTemplateDto from '../../dto/read_csv/csvReadTemplate';
import CsvCellInterface from '../../dto/read_csv/csvCell';
import SelectOptionsArrayDto from '../../dto/selectOptionsArrayDto';
import BalancesheetIncomeDto from '../../dto/balancesheetIncomeDto';
import BalancesheetOutcomeDto from '../../dto/balancesheetOutcomeDto';
import mockCsvData from './mock/mockCsvData';
import getOrdinaryExpensesEdaKbn from '../../dto/balancesheet/getOrdinaryExpensesEdaKbn';

import BalancesheetInput from '../../components/common/balancesheet_input/BalancesheetInput.vue';


//csv読み取りテンプレートを取得する
const listCsvReadTemplate: Ref<CsvReadTemplateInterface[]> = ref([]);
const selectedCsvReadTemplate: Ref<string> = ref("");

//1行目ヘッダ有無
const hasHeader: Ref<boolean> = ref(false);

//csv読み取りリスト(保存用)
const backCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//表示用(リストヘッダの有無でリストが変わるので)
const viewCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//csv項目指定リストの指定用配列
const listPointItems: Ref<SelectOptionsArrayDto[]> = ref([]);

//新テンプレートを申請
const newCsvReadTemplate: Ref<string> = ref("");

const temp: Ref<string> = ref("");

const isReadData: Ref<boolean> = ref(false);

//読み取りCsvデータを受信 
function recieveGeneralCsvData() {
    //データを受信する
    backCsvReadData.value = mockCsvData();

    viewCsvReadData.value.splice(0);
    for (const data of backCsvReadData.value) {
        viewCsvReadData.value.push(data);
    }

    const columnSize: number = backCsvReadData.value[0].length;

    //読み取りしたcsvの項目数に合わせたテンプレートのみを呼び出す
    listCsvReadTemplate.value.splice(0);
    listCsvReadTemplate.value = mockReadTemplate(columnSize);

    //受信したデータをもとに指定用項目を準備する
    listPointItems.value.splice(0);
    for (let i: number = 0; i < columnSize; i++) {
        listPointItems.value.push(new SelectOptionsArrayDto());
    }

    //準備ができたら表示する
    isReadData.value = true;
}


//ヘッダ有無の変更監視
watch(hasHeader, () => {
    if (hasHeader.value) {
        viewCsvReadData.value.shift();
    }
    else {
        viewCsvReadData.value.unshift(backCsvReadData.value[0]);
    }
});

//収支報告書収入リスト
const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
//収支報告書支出リスト
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

//読み取り形式変更監視
const isSelectTemplate: Ref<boolean> = ref(true);
watch(selectedCsvReadTemplate, () => {
    if (selectedCsvReadTemplate.value !== "選択解除") {
        //選択された項目のDtoを抽出
        let selectedDto: CsvReadTemplateInterface = new CsvReadTemplateDto();
        for (const dto of listCsvReadTemplate.value) {
            if (dto.value === selectedCsvReadTemplate.value) {
                selectedDto = dto;
                break;
            }
        }
        //格納された値に合わせて設定
        const maxLength = selectedDto.selectOptionsArray.length;
        for (let index = 0; index < maxLength; index++) {
            listPointItems.value[index].selectedOption = selectedDto.selectOptionsArray[index];
        }
        isSelectTemplate.value = false;

        //読みとられたcsvデータを収支報告書収入形式に変換
        listBalancesheetIncome.value.splice(0);
        listBalancesheetOutcome.value.splice(0);
        const inputArray = selectedDto.selectOptionsArray;
        let incomeDto: BalancesheetIncomeDto | null;
        let outcomeDto: BalancesheetOutcomeDto | null;
        let isSet = false;
        for (const line of viewCsvReadData.value) {
            isSet = false;

            incomeDto = convertBalancesheetIncomeFromTradingCore(line, inputArray);
            if (incomeDto !== null) {
                listBalancesheetIncome.value.push(incomeDto);
                isSet = true;
            }
            outcomeDto = convertBalancesheetOutcomeFromTradingCore(line, inputArray);
            if (outcomeDto !== null) {
                listBalancesheetOutcome.value.push(outcomeDto);
                isSet = true;
            }
            if (!isSet) {
                //TODO 未変換データの処理は決定次第修正する
                alert("未変換");
            }
        }

        listBalancesheetIncome.value.push(new BalancesheetIncomeDto());
        listBalancesheetIncome.value.push(new BalancesheetIncomeDto());
        listBalancesheetOutcome.value.push(new BalancesheetOutcomeDto());
        listBalancesheetOutcome.value.push(new BalancesheetOutcomeDto());

    }
    else {
        isSelectTemplate.value = true;
    }
});


//取引コアInterfaceから収支報告書収入データに変換
function convertBalancesheetIncomeFromTradingCore(line: CsvCellInterface[], inputArray: string[]): BalancesheetIncomeDto | null {

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
    incomeDto.yoshikiKbn = "7";
    incomeDto.yoshikiEdaKbn = "1";
    incomeDto.shimeiOrgnizationName = "弁護士";
    incomeDto.orgnizationAddress = "東京都千代田区";
    incomeDto.isCreditTax = true;

    return incomeDto;
}

//取引コアInterfaceから収支報告書支出データに変換
function convertBalancesheetOutcomeFromTradingCore(line: CsvCellInterface[], inputArray: string[]): BalancesheetOutcomeDto | null {

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

    return outcomeDto;
}


//保存
function onSave() {
    alert(temp.value);
}
</script>
<template>
    <h2>csvを読み取りして仕訳する</h2>
    <div class="one-line">
        <button @click="recieveGeneralCsvData">csvが読みとられた</button>
    </div>
    <br>
    <div class="left-area">
        CSV読み取り形式名称
    </div>
    <div class="right-area">
        <select v-model="selectedCsvReadTemplate" :disabled="!isReadData">
            <option v-for="option in listCsvReadTemplate" v-bind:value="option.value" v-bind:key="option.value">{{
                option.text
            }}
            </option>
        </select><br>
    </div>
    <div class="left-area">
        &nbsp;
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="hasHeader">1行目はヘッダなので取り込まない
    </div>
    <br>
    <div class="one-line" style="overflow: scroll;">
        読みとったCSVデータ
        <table v-if="isReadData">
            <tr>
                <th v-for="(itemSelect) in listPointItems">
                    <select v-model="itemSelect.selectedOption">
                        <option v-for="option in itemSelect.options" v-bind:value="option.value" v-bind:key="option.value">
                            {{ option.text }}
                        </option>
                    </select>
                </th>
            </tr>
            <tr v-for="(line, indexData) in viewCsvReadData" :key="indexData">
                <td v-for="item in line" :key="item.data">
                    {{ item.data }}&nbsp;
                </td>
            </tr>
        </table>
    </div>
    <br>
    <div class="one-line" v-if="isSelectTemplate">
        この結びつけ形式を保存できるよう申請する<br>
        <input v-model="newCsvReadTemplate">形式<button style="margin-left: 2%;">申請</button>
    </div>
    <BalancesheetInput :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome"></BalancesheetInput>

    <div class="footer">
        <button>キャンセル</button>
        <button @click="onSave">保存</button>
    </div>
</template>
<style scoped>
table {
    border-style: solid;
    border-width: 1px;
}

td {
    border-style: solid;
    border-width: 1px;
}

th {
    border-style: solid;
    border-width: 1px;
}
</style>
