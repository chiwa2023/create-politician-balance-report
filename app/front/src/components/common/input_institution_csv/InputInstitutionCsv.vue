<script setup lang="ts">
import { ref, Ref, watch, computed, WritableComputedRef } from "vue";
import CsvCellInterface from "../../../dto/read_csv/csvCell";
import SelectOptionsArrayInterface from "../../../dto/selectOptionsArrayDto";
import SelectOptionsArrayDto from "../../../dto/selectOptionsArrayDto";
import ReadCsv from "../read_csv/ReadCsv.vue";
import CsvReadTemplateInterface from "../../../dto/read_csv/csvReadTemplate";
import CsvReadTemplateDto from "../../../dto/read_csv/csvReadTemplate";
import PropseCsvReadTemplateInterface from "../../../dto/read_csv/proposeCsvReadTemplate";
import ProposeCsvReadTemplateDto from "../../../dto/read_csv/proposeCsvReadTemplate";
import mockReadTemplate from "./mock/mockReadTemplate";
import SearchZenginFinancialOrg from "../search_zengin_financial_org/SearchZenginFinancialOrg.vue";
import SearchVariousFinancialPay from "../search_various_financial_pay/SearchVariousFinancialPay.vue";
import ZenginFinancialOrgInterface from "../../../dto/financial/zenginFinancialOrg";
import VariousFinancialPayInterface from "../../../dto/financial/vairousFinancialPayDto";

//props,emit
const props = defineProps<{ csvData: [CsvCellInterface[]], }>();
const emits = defineEmits(["sendSelectOptionsArrayInterface"]);

//表示用(リストヘッダの無の場合受信データ後の1行目削除前データに戻す必要がある)
const viewCsvReadData: WritableComputedRef<[CsvCellInterface[]]> = computed(
    () => props.csvData,
);

//csv読み取りテンプレートを取得する
const listCsvReadTemplate: Ref<CsvReadTemplateInterface[]> = ref([]);
const selectedCsvReadTemplate: Ref<string> = ref("");

//1行目ヘッダ有無
const hasHeader: Ref<boolean> = ref(false);

//csv読み取りリスト(保存用)
const backCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//表示用(リストヘッダの有無でリストが変わるので)
//const viewCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);

//csv項目指定リストの指定用配列
const listPointItems: Ref<SelectOptionsArrayInterface[]> = ref([]);

//データが存在しないときは要素を表示しない
const isReadData: Ref<boolean> = ref(false);

/**
 * 読み取られたCsvデータを受信する
 * @param csvData csvデータ
 */
function recieveGeneralCsvDataInterface(csvData: [CsvCellInterface[]]) {
    //受信時は必ずヘッダが入っている
    hasHeader.value = false;

    //データを受信する
    backCsvReadData.value = csvData;

    //csvデータを受信したら初期化して表示
    viewCsvReadData.value.splice(0);
    for (const data of backCsvReadData.value) {
        viewCsvReadData.value.push(data);
    }

    //列数を取得
    const columnSize: number = backCsvReadData.value[0].length;

    //読み取りしたcsvの項目数に合わせたテンプレートのみを呼び出す
    listCsvReadTemplate.value.splice(0);
    listCsvReadTemplate.value = mockReadTemplate(columnSize);
    selectedCsvReadTemplate.value = "選択解除";

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
        const list:string[] = selectedDto.arrayText.split(",");
        const maxLength = list.length;
        for (let index = 0; index < maxLength; index++) {
            listPointItems.value[index].selectedOption = list[index];
        }

        propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.financialOrgCode;
        propseCsvReadTemplateDto.value.financialOrgName = selectedDto.financialOrgName;
        isSelectTemplate.value = false;

        //呼びだした選択項目の指定内容をそのまま投げる
        emits("sendSelectOptionsArrayInterface", list);
    }
    else {
        for (const pointItem of listPointItems.value) {
            pointItem.selectedOption = "0";
        }
        propseCsvReadTemplateDto.value.financialOrgCode = 0;
        propseCsvReadTemplateDto.value.financialOrgName = "";
        isSelectTemplate.value = true;
    }
});

//csv読み取り形式申請名
const isAppling: Ref<boolean> = ref(false);
//const newCsvReadTemplate: Ref<string> = ref("");
//const financialOrgCode: Ref<number> = ref(0);
//const financialOrgName: Ref<string> = ref("");

/**
 * 収支報告書データの更新を強制する
 */
function refreshBalanceSheet() {
    const selectedList: string[] = [];
    //手作業で別途更新された内容を拾っていく
    for (const item of listPointItems.value) {
        selectedList.push(item.selectedOption);
    }
    emits("sendSelectOptionsArrayInterface", selectedList);
}

//申請モード定数
const templateNew:number = 1;
const templateChange:number = 2;

const proposeMode:Ref<number> = ref(0);
const isNameEditDisable:Ref<boolean> = ref(false);

/**
 * 申請が新規か変更かで入力可能項目を変更する
 */
function onProposeMode() {
    if(templateChange === proposeMode.value){
        isNameEditDisable.value = false;
    }
    if(templateNew === proposeMode.value){
        isNameEditDisable.value = true;
        //選択された値からDto呼び出し、設定が必要
        propseCsvReadTemplateDto.value.csvReadTemplateName = selectedCsvReadTemplate.value;
    }
}

//csv読み取り仕様登録申請Interface
const propseCsvReadTemplateDto:Ref<PropseCsvReadTemplateInterface> = ref(new ProposeCsvReadTemplateDto());

const isVisibleSearchZenginFinancialOrg: Ref<boolean> = ref(false);
/**
 * 全銀検索コンポーネントを表示する
 */
function showSearchZenginFinancialOrg() {
    isVisibleSearchZenginFinancialOrg.value = true;
}
const isVisibleSearchVariousFinancialPay: Ref<boolean> = ref(false);
/**
 * 各種Pay検索コンポーネントを表示する
 */
function showSearchVariousFinancialPay() {
    isVisibleSearchVariousFinancialPay.value = true;
}

/**
 * 全銀金融機関検索コンポーネントを非表示にする
 */
function recieveCancelSearchZenginFinancialOrg() {
    //コンポーネント非表示
    isVisibleSearchZenginFinancialOrg.value = false;
}
/**
 * 各種Pay検索コンポーネントを非表示にする
 */
function recieveCancelSearchVariousFinancialPay() {
    //コンポーネント非表示
    isVisibleSearchVariousFinancialPay.value = false;
}


/**
 * 全銀金融機関検索コンポーネントから選択されたデータを受け取り非表示にする
 * @param selectedDto 選択されたDto
 */
function recieveZenginFinancialOrgInterface(selectedDto:ZenginFinancialOrgInterface) {
    //受信内容を複写
    propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.zenginFinancialOrgCode;
    propseCsvReadTemplateDto.value.financialOrgName = selectedDto.zenginFinancialOrgName;

    isVisibleSearchZenginFinancialOrg.value = false;
}
/**
 * 各種Pay検索コンポーネントから選択されたデータを受け取り非表示にする
 * @param selectedDto 選択されたDto
 */
function recieveVariousFinancialPayInterface(selectedDto:VariousFinancialPayInterface) {
    //受信内容を複写
    propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.variousFinancialPayCode;
    propseCsvReadTemplateDto.value.financialOrgName = selectedDto.variousFinancialPayName;

    isVisibleSearchVariousFinancialPay.value = false;
}

/**
 * 利用申請作業を行う
 */
function onPromoteTemplate(){
    alert("テンプレート"+propseCsvReadTemplateDto.value.csvReadTemplateId + "==="+propseCsvReadTemplateDto.value.csvReadTemplateCode + "==="+propseCsvReadTemplateDto.value.csvReadTemplateName);
    alert("金融機関"+propseCsvReadTemplateDto.value.financialOrgId + "==="+propseCsvReadTemplateDto.value.financialOrgCode + "==="+propseCsvReadTemplateDto.value.financialOrgName);
}
</script>
<template>
    <!-- 一般CSVファイルアップロードコンポーネント -->
    <ReadCsv @sendGeneralCsvDataInterface="recieveGeneralCsvDataInterface"></ReadCsv>
    <br>
    <div class="one-line">
        読みとったCSVデータ
    </div>
    <!-- 受信データ表示部 -->
    <div class="left-area">
        CSV読み取り形式
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
        ヘッダの有無
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="hasHeader">1行目はヘッダなので取り込まない
    </div>
    <br>
    <div class="one-line" style="overflow: scroll;">
        <table v-if="isReadData">
            <tr>
                <th v-for="(itemSelect) in listPointItems" :key="itemSelect.selectedOption">
                    <select v-model="itemSelect.selectedOption">
                        <option v-for="option in itemSelect.options" v-bind:value="option.value"
                            v-bind:key="option.value">
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
        <button @click="refreshBalanceSheet">この指定で更新</button>
    </div>
    <br>
    <div v-if="isReadData">
        <div class="one-line">
            <input type="checkbox" v-model="isAppling">この結びつけを申請する<br>
        </div>
        <div v-if="isAppling">
            <div class="left-area">
                金融機関(各種Pay／全銀)
            </div>
            <div class="right-area">
                <input type="number" v-model="propseCsvReadTemplateDto.financialOrgCode" disabled="false" style="margin-right: 2%;">
                <input type="text" v-model="propseCsvReadTemplateDto.financialOrgName" disabled="false" style="margin-right: 2%;">
                <button style="margin-right: 2%;" @click="showSearchVariousFinancialPay" :disabled="!isSelectTemplate">各種Pay検索</button>
                <button style="margin-right: 2%;" @click="showSearchZenginFinancialOrg" :disabled="!isSelectTemplate">全銀金融機関検索</button>
            </div>
            <div class="left-area">
                新規／変更
            </div>
            <div class="right-area">
                <input type="radio" id="templateNew" :value="templateNew" v-model="proposeMode" @click="onProposeMode">新規
                <input type="radio" id="templateChange" :value="templateChange" v-model="proposeMode" @click="onProposeMode">変更
            </div>
            <div class="left-area">
                読み取り形式名称
            </div>
            <div class="right-area">
                <input v-model="propseCsvReadTemplateDto.csvReadTemplateName" :disabled="isNameEditDisable">形式<button style="margin-left: 2%;" @click="onPromoteTemplate">申請</button>
            </div>
        </div>
    </div>
    <!-- ベースを操作禁止するレイヤ -->
    <div v-if="isVisibleSearchZenginFinancialOrg" class="overBackground"></div>
    <div v-if="isVisibleSearchVariousFinancialPay" class="overBackground"></div>
    <!-- 全銀金融機関検索コンポーネント -->
    <div v-if="isVisibleSearchZenginFinancialOrg">
        <div class="overComponent">
            <SearchZenginFinancialOrg :isEditable="false"
                @sendCancelSearchZenginFinancialOrg="recieveCancelSearchZenginFinancialOrg"
                @sendZenginFinancialOrgInterface="recieveZenginFinancialOrgInterface"></SearchZenginFinancialOrg>
        </div>
    </div>
    <!-- 各種Pay機関検索コンポーネント -->
    <div v-if="isVisibleSearchVariousFinancialPay">
        <div class="overComponent">
        <SearchVariousFinancialPay :isEditable="false"
            @sendCancelSearchVariousFinancialPay="recieveCancelSearchVariousFinancialPay"
            @sendVariousFinancialPayInterface="recieveVariousFinancialPayInterface"></SearchVariousFinancialPay>
        </div>
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
