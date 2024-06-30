<script setup lang="ts">
import { ref, Ref, watch, computed, WritableComputedRef, toRaw } from "vue";
import CsvCellInterface from "../../../dto/read_csv/csvCell";
import SelectOptionsArrayInterface from "../../../dto/selectOptionsArrayDto";
import SelectOptionsArrayDto from "../../../dto/selectOptionsArrayDto";
import ReadCsv from "../read_csv/ReadCsv.vue";
import CsvReadTemplateInterface from "../../../dto/read_csv/csvReadTemplate";
import CsvReadTemplateDto from "../../../dto/read_csv/csvReadTemplate";
import PropseCsvReadTemplateInterface from "../../../dto/read_csv/proposeCsvReadTemplate";
import ProposeCsvReadTemplateDto from "../../../dto/read_csv/proposeCsvReadTemplate";
import SearchZenginFinancialOrg from "../search_zengin_financial_org/SearchZenginFinancialOrg.vue";
import SearchVariousFinancialPay from "../search_various_financial_pay/SearchVariousFinancialPay.vue";
import ZenginFinancialOrgInterface from "../../../dto/financial/zenginFinancialOrg";
import VariousFinancialPayInterface from "../../../dto/financial/vairousFinancialPayDto";
import CsvReadTemplateCapsuleDto from "../../../dto/read_csv/csvReadTemplateCapsuleDto";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import createCheckTransactionDto from "../../../dto/common_check/createCheckTransactionDto";
import axios from "axios";
import showErrorMessage from "../../../dto/common_check/showErrorMessage";
import SendCsvAndStragedShoshouDto from "../../../dto/read_csv/sendCsvAndStragedShoshouDto";
import SaveStorageResultDto from "../../../dto/storage/saveStorageResultDto";
import PropseCsvReadTemplateEntity from "../../../entity/proposeCsvReadTemplateEntity";
import FinancialOrgConstants from "../../../dto/financial/financialOrgConstants";
import RegistProposeCsvReadRemplateCapsuleDto from "../../../dto/read_csv/registProposeCsvReadRemplateCapsuleDto";
import TemplateFrameworkResultDto from "../../../dto/template/templateFrameworkResultDto";

//props,emit
const props = defineProps<{ csvData: [CsvCellInterface[]], }>();
const emits = defineEmits(["sendSelectOptionsArrayInterface"]);

//表示用(リストヘッダの有から無にする場合、受信データ後の1行目削除前データに戻す必要がある)
const viewCsvReadData: WritableComputedRef<[CsvCellInterface[]]> = computed(
    () => props.csvData,
);

//csv読み取りテンプレートを取得する
const listCsvReadTemplate: Ref<CsvReadTemplateInterface[]> = ref([]);
const selectedCsvReadTemplate: Ref<string> = ref("");

//1行目ヘッダ有無
const hasHeader: Ref<boolean> = ref(false);

//csv読み取り情報
const sendCsvAndStragedShoshouDto: Ref<SendCsvAndStragedShoshouDto> = ref(new SendCsvAndStragedShoshouDto());
//csv読み取りリスト(保存用)
const backCsvReadData: Ref<[CsvCellInterface[]]> = ref([[]]);
//書証情報
const saveStorageResultDto: Ref<SaveStorageResultDto> = ref(new SaveStorageResultDto());

//csv項目指定リストの指定用配列
const listPointItems: Ref<SelectOptionsArrayInterface[]> = ref([]);

//データが存在しないときは要素を表示しない
const isReadData: Ref<boolean> = ref(false);

/**
 * 読み取られたCsvデータを受信する
 * @param sendDto csv変換結果
 */
async function recieveGeneralCsvDataInterface(sendDto: SendCsvAndStragedShoshouDto) {
    //受信時は必ずヘッダが入っている
    hasHeader.value = false;

    //データを受信する
    sendCsvAndStragedShoshouDto.value = sendDto;
    backCsvReadData.value = structuredClone(toRaw(sendDto.listAllCsv));
    saveStorageResultDto.value = sendDto.saveStorageResultDto;

    //csvデータを受信したら初期化して表示
    viewCsvReadData.value.splice(0);
    for (const data of backCsvReadData.value) {
        viewCsvReadData.value.push(data);
    }

    //列数を取得
    const columnSize: number = backCsvReadData.value[0].length;

    //読み取りしたcsvの項目数に合わせたテンプレートのみを呼び出す
    listCsvReadTemplate.value.splice(0);

    //セッションストレージ取得
    const csvReadTemplateCapsuleDto: CsvReadTemplateCapsuleDto = new CsvReadTemplateCapsuleDto();
    csvReadTemplateCapsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
    csvReadTemplateCapsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
    csvReadTemplateCapsuleDto.checkTransactionDto = createCheckTransactionDto(false);
    //独自変数設定
    csvReadTemplateCapsuleDto.arrayNumber = columnSize;

    //実接続
    const url = "http://localhost:8080/csv-read-template/select-template-by-number";
    await axios.post(url, csvReadTemplateCapsuleDto)
        .then((response) => {

            listCsvReadTemplate.value = response.data;

        })
        .catch((error) => showErrorMessage(error.status));

    selectedCsvReadTemplate.value = "0";//選択解除

    //受信したデータをもとに指定用項目を準備する
    listPointItems.value.splice(0);
    for (let i: number = 0; i < columnSize; i++) {
        listPointItems.value.push(new SelectOptionsArrayDto());
    }

    //準備ができたら表示する
    isReadData.value = true;
}

/**
 * ヘッダ設定による編集データ変形
 * @param hasHeader ヘッダ有無
 */
function createDataByHasHeader(hasHeader: boolean) {
    if (hasHeader) {
        viewCsvReadData.value.shift();
    } else {
        viewCsvReadData.value.unshift(backCsvReadData.value[0]);
    }
}

//読み取り形式変更監視
const isSelectTemplate: Ref<boolean> = ref(true);
watch(selectedCsvReadTemplate, () => {
    if (selectedCsvReadTemplate.value !== "0") {

        //選択された項目のDtoを抽出
        let selectedDto: CsvReadTemplateInterface = new CsvReadTemplateDto();
        for (const dto of listCsvReadTemplate.value) {
            if (dto.value === selectedCsvReadTemplate.value) {
                selectedDto = dto;
                break;
            }
        }
        //格納された値に合わせて設定
        const list: string[] = selectedDto.arrayText.split(",");
        const maxLength = list.length;
        for (let index = 0; index < maxLength; index++) {
            listPointItems.value[index].selectedOption = list[index];
        }

        hasHeader.value = selectedDto.hasHeader;
        createDataByHasHeader(selectedDto.hasHeader);

        propseCsvReadTemplateDto.value.financialOrgKbn = selectedDto.financialOrgKbn;
        propseCsvReadTemplateDto.value.financialOrgId = selectedDto.financialOrgId;
        propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.financialOrgCode;
        propseCsvReadTemplateDto.value.financialOrgName = selectedDto.financialOrgName;
        propseCsvReadTemplateDto.value.csvReadTemplateName = selectedDto.csvReadTemplateName;
        propseCsvReadTemplateDto.value.editId = selectedDto.csvReadTemplateId;

        isSelectTemplate.value = false;

        //呼びだした選択項目の指定内容をそのまま投げる
        emits("sendSelectOptionsArrayInterface", list, saveStorageResultDto.value, viewCsvReadData.value);
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

/**
 * 収支報告書データの更新を強制する
 */
function refreshBalanceSheet() {
    const selectedList: string[] = [];
    //手作業で別途更新された内容を拾っていく
    for (const item of listPointItems.value) {
        selectedList.push(item.selectedOption);
    }

    emits("sendSelectOptionsArrayInterface", selectedList, saveStorageResultDto.value, viewCsvReadData.value);
}

//申請モード定数
const templateNew: number = 1;
const templateChange: number = 2;

const proposeMode: Ref<number> = ref(templateChange);
const isNameEditDisable: Ref<boolean> = ref(false);

/**
 * 申請が新規か変更かで入力可能項目を変更する
 */
function onProposeMode() {
    if (templateChange === proposeMode.value) {
        isNameEditDisable.value = false;
        propseCsvReadTemplateDto.value.csvReadTemplateName = "";
    }
    if (templateNew === proposeMode.value) {
        isNameEditDisable.value = true;
    }
}

//csv読み取り仕様登録申請Interface
const propseCsvReadTemplateDto: Ref<PropseCsvReadTemplateInterface> = ref(new ProposeCsvReadTemplateDto());

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
function recieveZenginFinancialOrgInterface(selectedDto: ZenginFinancialOrgInterface) {
    //受信内容を複写
    propseCsvReadTemplateDto.value.financialOrgKbn = FinancialOrgConstants.ZENGIN_ORG;
    propseCsvReadTemplateDto.value.financialOrgId = selectedDto.zenginFinancialOrgId;
    propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.zenginFinancialOrgCode;
    propseCsvReadTemplateDto.value.financialOrgName = selectedDto.zenginFinancialOrgName;

    isVisibleSearchZenginFinancialOrg.value = false;
}
/**
 * 各種Pay検索コンポーネントから選択されたデータを受け取り非表示にする
 * @param selectedDto 選択されたDto
 */
function recieveVariousFinancialPayInterface(selectedDto: VariousFinancialPayInterface) {
    //受信内容を複写
    propseCsvReadTemplateDto.value.financialOrgKbn = FinancialOrgConstants.VARIOUS_PAY;
    propseCsvReadTemplateDto.value.financialOrgId = selectedDto.variousFinancialPayId;
    propseCsvReadTemplateDto.value.financialOrgCode = selectedDto.variousFinancialPayCode;
    propseCsvReadTemplateDto.value.financialOrgName = selectedDto.variousFinancialPayName;

    isVisibleSearchVariousFinancialPay.value = false;
}

/**
 * 利用申請作業を行う
 */
async function onPromoteTemplate() {

    const propseCsvReadTemplateEntity: PropseCsvReadTemplateEntity = new PropseCsvReadTemplateEntity();

    propseCsvReadTemplateEntity.proposeCsvReadTemplateId = propseCsvReadTemplateDto.value.csvReadTemplateId;
    propseCsvReadTemplateEntity.proposeCsvReadTemplateCode = propseCsvReadTemplateDto.value.csvReadTemplateCode;
    propseCsvReadTemplateEntity.proposeCsvReadTemplateName = propseCsvReadTemplateDto.value.csvReadTemplateName;

    let arrayText: string = "";

    for (const selectValue of listPointItems.value) {
        arrayText = arrayText + selectValue.selectedOption + ",";
    }
    arrayText = arrayText.substring(0, arrayText.length - 1);

    propseCsvReadTemplateEntity.arrayNumber = listPointItems.value.length;
    propseCsvReadTemplateEntity.arrayText = arrayText;
    propseCsvReadTemplateEntity.financialOrgKbn = propseCsvReadTemplateDto.value.financialOrgKbn;
    propseCsvReadTemplateEntity.financialOrgId = propseCsvReadTemplateDto.value.financialOrgId;
    propseCsvReadTemplateEntity.financialOrgCode = propseCsvReadTemplateDto.value.financialOrgCode;
    propseCsvReadTemplateEntity.financialOrgName = propseCsvReadTemplateDto.value.financialOrgName;
    propseCsvReadTemplateEntity.hasHeader = hasHeader.value;
    propseCsvReadTemplateEntity.shoshouId = saveStorageResultDto.value.shoshouId;
    propseCsvReadTemplateEntity.shoshouKbn = saveStorageResultDto.value.shoshouKbn;

    if (proposeMode.value === templateChange) {
        //変更時には編集元Idを保持しておく
        propseCsvReadTemplateEntity.editId = propseCsvReadTemplateDto.value.editId;
    }
    else {
        //新規時は編集元Idは0
        propseCsvReadTemplateEntity.editId = 0;
    }

    const registProposeCsvReadRemplateCapsuleDto: RegistProposeCsvReadRemplateCapsuleDto = new RegistProposeCsvReadRemplateCapsuleDto();

    registProposeCsvReadRemplateCapsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
    registProposeCsvReadRemplateCapsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
    registProposeCsvReadRemplateCapsuleDto.checkTransactionDto = createCheckTransactionDto(false);
    //独自変数設定
    registProposeCsvReadRemplateCapsuleDto.proposeCsvReadTemplateEntity = propseCsvReadTemplateEntity;

    //登録
    const url = "http://localhost:8080/propose-csv-read-template/regist";
    await axios.post(url, registProposeCsvReadRemplateCapsuleDto)
        .then((response) => {
            const resultDto: TemplateFrameworkResultDto = response.data;
            if (response.status === 200) {
                alert(resultDto.message);
            }
            //TODO no contentに修正
            if (response.status === 204) {
                alert(resultDto.message);
            }
        })
        .catch((error) => showErrorMessage(error.status));
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
        <input type="checkbox" v-model="hasHeader" @change="createDataByHasHeader(hasHeader)">1行目はヘッダなので取り込まない
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
                <input type="number" v-model="propseCsvReadTemplateDto.financialOrgCode" disabled="false"
                    style="margin-right: 2%;">
                <input type="text" v-model="propseCsvReadTemplateDto.financialOrgName" disabled="false"
                    style="margin-right: 2%;">
                <button style="margin-right: 2%;" @click="showSearchVariousFinancialPay"
                    :disabled="!isSelectTemplate">各種Pay検索</button>
                <button style="margin-right: 2%;" @click="showSearchZenginFinancialOrg"
                    :disabled="!isSelectTemplate">全銀金融機関検索</button>
            </div>
            <div class="left-area">
                新規／変更
            </div>
            <div class="right-area">
                <input type="radio" id="templateNew" :value="templateNew" v-model="proposeMode"
                    @click="onProposeMode">新規
                <input type="radio" id="templateChange" :value="templateChange" v-model="proposeMode"
                    @click="onProposeMode">変更
            </div>
            <div class="left-area">
                読み取り形式名称
            </div>
            <div class="right-area">
                <input v-model="propseCsvReadTemplateDto.csvReadTemplateName" :disabled="isNameEditDisable">形式<button
                    style="margin-left: 2%;" @click="onPromoteTemplate">申請</button>
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
