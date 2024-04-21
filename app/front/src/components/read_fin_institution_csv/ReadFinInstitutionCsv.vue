<script setup lang="ts">
import { ref, Ref, toRaw, watch } from "vue";
//import mockReadTemplate from "./mock/mockReadTemplate";
import CsvReadTemplateInterface from "../../dto/read_csv/csvReadTemplate";
import CsvReadTemplateDto from "../../dto/read_csv/csvReadTemplate";
import CsvCellInterface from "../../dto/read_csv/csvCell";
import SelectOptionsArrayDto from "../../dto/selectOptionsArrayDto";
import BalancesheetIncomeDto from "../../dto/balancesheetIncomeDto";
import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
//import mockCsvData from "./mock/mockCsvData";
import convertBalancesheetIncomeFromTradingCore from "../../dto/balancesheet/convertBalancesheetIncomeFromTradingCore";
import convertBalancesheetOutcomeFromTradingCore from "../../dto/balancesheet/convertBalancesheetOutcomeFromTradingCore";
import viewPrepareIncome from "../../dto/balancesheet/viewPrepareIncome";
import viewPrepareOutcome from "../../dto/balancesheet/viewPrepareOutcome";
import BalancesheetInput from "../../components/common/balancesheet_input/BalancesheetInput.vue";
import InputInstitutionCsv from "../common/input_institution_csv/InputInstitutionCsv.vue";
import SelectOptionsArrayInterface from "../../dto/selectOptionsArrayDto";

//csv読み取りテンプレートを取得する
const listCsvReadTemplate: Ref<CsvReadTemplateInterface[]> = ref([]);
const selectedCsvReadTemplate: Ref<string> = ref("");

//1行目ヘッダ有無
//const hasHeader: Ref<boolean> = ref(false);

//csv読み取りリスト(保存用)
//const backCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//CSVデータ解析用
const viewCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//csv項目指定リストの指定用配列
const listPointItems: Ref<SelectOptionsArrayDto[]> = ref([]);

//新テンプレートを申請
//const newCsvReadTemplate: Ref<string> = ref("");
//const temp: Ref<string> = ref("");
//const isReadData: Ref<boolean> = ref(true);

///**
// * 読み取りCsvデータを受信する
// */
//function recieveGeneralCsvData() {
//    //データを受信する
//    backCsvReadData.value = mockCsvData();
//
//    viewCsvReadData.value.splice(0);
//    for (const data of backCsvReadData.value) {
//        viewCsvReadData.value.push(data);
//    }
//
//    const columnSize: number = backCsvReadData.value[0].length;
//
//    //読み取りしたcsvの項目数に合わせたテンプレートのみを呼び出す
//    listCsvReadTemplate.value.splice(0);
//    listCsvReadTemplate.value = mockReadTemplate(columnSize);
//
//    //受信したデータをもとに指定用項目を準備する
//    listPointItems.value.splice(0);
//    for (let i: number = 0; i < columnSize; i++) {
//        listPointItems.value.push(new SelectOptionsArrayDto());
//    }
//
//    //準備ができたら表示する
//    isReadData.value = true;
//}

//ヘッダ有無の変更監視
//watch(hasHeader, () => {
//    if (hasHeader.value) {
//        viewCsvReadData.value.shift();
//    }
//    else {
//        viewCsvReadData.value.unshift(backCsvReadData.value[0]);
//    }
//});

//収支報告書収入リスト
const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const backupListIncome: Ref<BalancesheetIncomeDto[]> = ref([]);

//収支報告書支出リスト
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);
const backupListOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

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

        //テスト用仮データ
        listBalancesheetIncome.value.push(viewPrepareIncome(new BalancesheetIncomeDto()));
        listBalancesheetIncome.value.push(viewPrepareIncome(new BalancesheetIncomeDto()));
        listBalancesheetOutcome.value.push(viewPrepareOutcome(new BalancesheetOutcomeDto()));
        listBalancesheetOutcome.value.push(viewPrepareOutcome(new BalancesheetOutcomeDto()));

        //バックアップを取る
        backupListIncome.value = structuredClone(toRaw(listBalancesheetIncome.value));
        backupListOutcome.value = structuredClone(toRaw(listBalancesheetOutcome.value));

    }
    else {
        isSelectTemplate.value = true;
    }
});

/**
 * CSVデータを収支項目データに変換する
 * @param listPointArray 列と指定項目の組み合わせ
 */
function recieveSelectOptionsArrayInterface(listPointArray:string[]){

    //読みとられたcsvデータを収支報告書収入形式に変換
    listBalancesheetIncome.value.splice(0);
    listBalancesheetOutcome.value.splice(0);
    //const inputArray = listPointItems;
    let incomeDto: BalancesheetIncomeDto | null;
    let outcomeDto: BalancesheetOutcomeDto | null;
    let isSet = false;
    for (const line of viewCsvReadData.value) {
        isSet = false;

        incomeDto = convertBalancesheetIncomeFromTradingCore(line, listPointArray);
        if (incomeDto !== null) {
            listBalancesheetIncome.value.push(incomeDto);
            isSet = true;
        }
        outcomeDto = convertBalancesheetOutcomeFromTradingCore(line, listPointArray);
        if (outcomeDto !== null) {
            listBalancesheetOutcome.value.push(outcomeDto);
            isSet = true;
        }
        if (!isSet) {
            //TODO 未変換データの処理は決定次第修正する
            alert("未変換");
        }
    }

    //テスト用仮データ
    listBalancesheetIncome.value.push(viewPrepareIncome(new BalancesheetIncomeDto()));
    listBalancesheetIncome.value.push(viewPrepareIncome(new BalancesheetIncomeDto()));
    listBalancesheetOutcome.value.push(viewPrepareOutcome(new BalancesheetOutcomeDto()));
    listBalancesheetOutcome.value.push(viewPrepareOutcome(new BalancesheetOutcomeDto()));

    //バックアップを取る
    backupListIncome.value = structuredClone(toRaw(listBalancesheetIncome.value));
    backupListOutcome.value = structuredClone(toRaw(listBalancesheetOutcome.value));

}

/**
 * 自動読み込みデータの編集をやめるならデータを復元(収入)
 * @param index 行番号
 */
function restoreIncomeReadData(index: number) {
    listBalancesheetIncome.value[index].accrualDate = backupListIncome.value[index].accrualDate;
    listBalancesheetIncome.value[index].amount = backupListIncome.value[index].amount;
}

/**
 * 自動読み込みデータの編集をやめるならデータを復元(支出)
 * @param index 行番号
 */
function restoreOutcomeReadData(index: number) {
    listBalancesheetOutcome.value[index].accrualDate = backupListOutcome.value[index].accrualDate;
    listBalancesheetOutcome.value[index].amount = backupListOutcome.value[index].amount;
}

/**  
 * 入力内容を保存する
 */
function onSave() {
    alert("保存");
}
/**  
 * 入力内容を破棄するする
 */
function onCancel() {
    alert("キャンセル");
}
</script>
<template>
    <h2>csvを読み取りして仕訳する</h2>

    <h3>csvを指定する</h3>
    <!-- CSV読み取りコンポーネント -->
    <InputInstitutionCsv :csvData="viewCsvReadData" @sendSelectOptionsArrayInterface="recieveSelectOptionsArrayInterface"></InputInstitutionCsv>

    <h3>変換された収支報告書データ</h3>
    <!-- 政治資金収支報告書コンポーネント -->
    <BalancesheetInput :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome"
        @restoreIncomeReadData="restoreIncomeReadData" @restoreOutcomeReadData="restoreOutcomeReadData">
    </BalancesheetInput>

    <div class="footer">
        <button @click="onCancel">キャンセル</button>
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
