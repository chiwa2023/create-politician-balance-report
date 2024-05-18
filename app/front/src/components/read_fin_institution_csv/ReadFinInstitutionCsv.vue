<script setup lang="ts">
import { ref, Ref, toRaw } from "vue";
import CsvCellInterface from "../../dto/read_csv/csvCell";
import BalancesheetIncomeDto from "../../dto/balancesheetIncomeDto";
import BalancesheetOutcomeDto from "../../dto/balancesheetOutcomeDto";
import BalancesheetInput from "../../components/common/balancesheet_input/BalancesheetInput.vue";
import InputInstitutionCsv from "../common/input_institution_csv/InputInstitutionCsv.vue";
import SaveStorageResultDto from "../../dto/storage/saveStorageResultDto";
import SessionStorageCommonCheck from "../../dto/common_check/sessionStorageCommonCheck";
import createCheckTransactionDto from "../../dto/common_check/createCheckTransactionDto";
import axios from "axios";
import RegistBalancesheetInOutCapsuleDto from "../../dto/balancesheet/registBalancesheetInOutCapsuleDto";
import CreateBalancesheetInOutDataByCsvCapsuleDto from "../../dto/balancesheet/createBalancesheetInOutDataByCsvCapsuleDto";
import CreateBalancsheetInOutItemResultDto from "../../dto/balancesheet/createBalancsheetInOutItemResultDto";
import viewPrepareIncome from "../../dto/balancesheet/viewPrepareIncome";
import viewPrepareOutcome from "../../dto/balancesheet/viewPrepareOutcome";
import showErrorMessage from "../../dto/common_check/showErrorMessage";
import CallingItemDto from "../../dto/calling_item/callingItemDto";
import TemplateFrameworkResultDto from "../../dto/template/templateFrameworkResultDto";

//CSVデータ解析用
const viewCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//csv項目指定リストの指定用配列
//const listPointItems: Ref<SelectOptionsArrayDto[]> = ref([]);

//収支報告書収入リスト
const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const backupListIncome: Ref<BalancesheetIncomeDto[]> = ref([]);

//収支報告書支出リスト
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);
const backupListOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

//呼び出し候補リスト
const listCallingItem: Ref<CallingItemDto[]> = ref([]);

/**
 * CSVデータを収支項目データに変換する
 * @param listPointArray 列と指定項目の組み合わせ
 * @param saveStorageResultDto 読み取りした書証情報
 */
async function recieveSelectOptionsArrayInterface(listPointArray: string[], saveStorageResultDto: SaveStorageResultDto) {

    //接続情報を準備する0
    const createBalancesheetInOutDataByCsvCapsuleDto: CreateBalancesheetInOutDataByCsvCapsuleDto = new CreateBalancesheetInOutDataByCsvCapsuleDto();
    //共通情報をセッションストレージから取得
    createBalancesheetInOutDataByCsvCapsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
    createBalancesheetInOutDataByCsvCapsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
    createBalancesheetInOutDataByCsvCapsuleDto.checkTransactionDto = createCheckTransactionDto(false);

    //独自情報をセット
    //createBalancesheetInOutDataByCsvCapsuleDto.hasHeader = hasHeader;
    createBalancesheetInOutDataByCsvCapsuleDto.saveStorageResultDto = saveStorageResultDto;
    createBalancesheetInOutDataByCsvCapsuleDto.listPointer = listPointArray;
    createBalancesheetInOutDataByCsvCapsuleDto.listCsvData = viewCsvReadData.value;

    //csvデータ、列項目指定、書証情報からcsv設定データに変換
    const url = "http://localhost:8080/create-balancesheet-in-out/by-csv";
    await axios.post(url, createBalancesheetInOutDataByCsvCapsuleDto)
        .then((response) => {
            //データを取得
            const resultDto: CreateBalancsheetInOutItemResultDto = response.data;

            if (200 === response.status) {
                listCallingItem.value = resultDto.listCallingItem;

                listBalancesheetIncome.value.splice(0);
                listBalancesheetOutcome.value.splice(0);

                //データに合わせて画面表示コントロールする
                for (const dtoIncome of resultDto.listIncome) {
                    listBalancesheetIncome.value.push(viewPrepareIncome(dtoIncome));
                }
                for (const dtoOutcome of resultDto.listOutcome) {
                    listBalancesheetOutcome.value.push(viewPrepareOutcome(dtoOutcome));
                }

                //バックアップを取る
                backupListIncome.value = structuredClone(toRaw(listBalancesheetIncome.value));
                backupListOutcome.value = structuredClone(toRaw(listBalancesheetOutcome.value));
            }
            //正常にデータが取得できなかった
            if (204 === response.status) {
                alert(resultDto.message);
            }

        })
        .catch((error) => showErrorMessage(error.status));
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
async function onSave() {

    //登録するリストを設定する
    const capsuleDto: RegistBalancesheetInOutCapsuleDto = new RegistBalancesheetInOutCapsuleDto();
    //セッションストレージ取得
    capsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
    capsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
    capsuleDto.checkTransactionDto = createCheckTransactionDto(false);
    //独自変数設定
    capsuleDto.listIncome = listBalancesheetIncome.value;
    capsuleDto.listOutcome = listBalancesheetOutcome.value;

    //csvデータ、列項目指定、書証情報からcsv設定データに変換
    const url = "http://localhost:8080/create-balancesheet-in-out/regist";
    await axios.post(url, capsuleDto)
        .then((response) => {
            const resultDto: TemplateFrameworkResultDto = response.data;

            if (200 === response.status) {
                alert(resultDto.successCount + "件登録できました");
            }

            if (204 === response.status) {
                alert(resultDto.message);
            }

        })
        .catch((error) => showErrorMessage(error.status));
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    alert("キャンセル");
}
</script>
<template>
    <h2>csvを読み取りして仕訳する</h2>

    <h3>csvを指定する</h3>
    <!-- CSV読み取りコンポーネント -->
    <InputInstitutionCsv :csvData="viewCsvReadData"
        @sendSelectOptionsArrayInterface="recieveSelectOptionsArrayInterface"></InputInstitutionCsv>

    <h3>変換された収支報告書データ</h3>
    <!-- 政治資金収支報告書コンポーネント -->
    <BalancesheetInput :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome"
        :listItem="listCallingItem" @restoreIncomeReadData="restoreIncomeReadData"
        @restoreOutcomeReadData="restoreOutcomeReadData">
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
