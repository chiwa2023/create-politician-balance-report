<script setup lang="ts">
import { Ref, ref, toRaw } from "vue";
import SsearchBalancesheetEstateCapsuleDto from "../../../dto/balancesheet_estate/searchBalancesheetEstateCapsuleDto";
import BalancesheetEstateInterface from "../../../dto/balancesheet_estate/balancesheetEstateDto";
import BalancesheetEstateDto from "../../../dto/balancesheet_estate/balancesheetEstateDto";
import mockGetBalancesheetEstateList from "./mock/mockGetBalancesheetEstateList";

//props,emit
const props = defineProps<{ searchDto: SsearchBalancesheetEstateCapsuleDto }>();
const emits = defineEmits(["sendCancelSearchBalancesheetEstate", "sendBalancesheetEstateInterface"]);

/** 表示行 */
const list: Ref<BalancesheetEstateInterface[]> = ref([]);
const listBackup: Ref<BalancesheetEstateInterface[]> = ref([]);

/** ラジオボタン選択 */
const selectedRow: Ref<number> = ref(0);

/** 編集フラグ */
const isEditable: Ref<boolean> = ref(!props.searchDto.checkTransactionDto.isSelectOnly);

/**  
 * 選択行を通知する
 * @param rowId その行のDtoのId
 */
function onSelectChange(rowId: number) {
    if (true === isEditable.value) {
        sendData(rowId);
    }
}

/**  
 * 入力内容を選択する
 */
function onSelect() {
    sendData(selectedRow.value);
}

/**  
 * 選択データを送信する
 * @param rowId その行のDtoのId
 */
function sendData(rowId: number) {
    //PrimaryIdをKeyにしているので、1件だけに絞られることが保証されている
    const selectedDto: BalancesheetEstateInterface = list.value.filter((dto) => dto.balancesheetEstateId == rowId)[0];
    emits("sendBalancesheetEstateInterface", selectedDto);
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelSearchBalancesheetEstate");
}

/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId: number) {
    const newList: BalancesheetEstateInterface[] = list.value.filter((dto) => dto.balancesheetEstateId != rowId);
    list.value = newList;
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow() {
    let maxId = 0;
    for (const dto of list.value) {
        if (maxId < dto.balancesheetEstateId) {
            maxId = dto.balancesheetEstateId;
        }
    }
    const addDto: BalancesheetEstateInterface = new BalancesheetEstateDto();
    addDto.balancesheetEstateId = maxId;
    list.value.push(addDto);
}

const searchWords: Ref<string> = ref("");
/**  
 * 検索条件に基づき検索を行う
 */
async function onSearch() {
    //Mockリストの取得

    //実接続
    //セッションストレージ取得
    const searchBalancesheetEstateCapsuleDto: SsearchBalancesheetEstateCapsuleDto = new SsearchBalancesheetEstateCapsuleDto();
    searchBalancesheetEstateCapsuleDto.checkSecurityDto = props.searchDto.checkSecurityDto;
    searchBalancesheetEstateCapsuleDto.checkPrivilegeDto = props.searchDto.checkPrivilegeDto;
    searchBalancesheetEstateCapsuleDto.checkTransactionDto = props.searchDto.checkTransactionDto;

    //独自変数設定
    searchBalancesheetEstateCapsuleDto.searchWords = searchWords.value;

    //Mockリストの取得
    list.value = mockGetBalancesheetEstateList();
    listBackup.value = structuredClone(toRaw(list.value));
}

const filterKey:Ref<string> = ref("");

function onFilterList(){
    list.value = listBackup.value.filter((dto) =>{
        if(filterKey.value === ""){
            return true;
        }
        if(dto.yoshikiEdaKbn === filterKey.value){
            return true;

        }else{
            return false;
        }
    } );
}

</script>
<template>
    <h3>収支報告書資産一覧</h3>
    <div class="one-line">
        検索条件の指定
    </div>
    <div class="left-area">
        検索語
    </div>
    <div class="right-area">
        <input type="text" v-model="searchWords" style="margin-right:2%;"><button @click="onSearch">検索</button>
    </div>
    <div class="both-clear"></div>

    <div class="left-area">
        前年データを複写
    </div>
    <div class="right-area">
        <button @click="onSearch">前年データを複写</button>
    </div>
    <div class="both-clear"><br></div>

    <div class="one-line">
        検索結果<br>

        資産でフィルタ
        <select v-model="filterKey" class="left-space" @change="onFilterList">
            <option value="">すべて選択</option>
            <option value="ア">ア：土地</option>
            <option value="イ">イ：建物</option>
            <option value="ウ">ウ：地上権または借地権 </option>
            <option value="エ">エ：取得価額が100万円を超える動産</option>
            <option value="オ">オ：普通または当座でない預金(貯金)</option>
            <option value="カ">カ：金銭信託</option>
            <option value="キ">キ：有価証券</option>
            <option value="ク">ク：出資による権利</option>
            <option value="ケ">ケ：相手先ごとに残高100万円を超える貸付</option>
            <option value="コ">コ：100万円を超える敷金</option>
            <option value="サ">サ：100万円を超える施設利用の権利 </option>
            <option value="シ">シ：相手先ごとに100万円を超える借入金</option>
        </select>
        <br>
        <table>
            <tr>
                <th style="width:6%;">&nbsp;</th>
                <th style="width:15%;">同一データ確認</th>
                <th style="width:15%;">コード</th>
                <th>資産枝区分</th>
                <th>摘要</th>
                <th>金額</th>
                <th>年月日</th>
                <th>備考</th>
                <th>不動産入力</th>
                <th v-if="isEditable" style="width:9%;">&nbsp;</th>
            </tr>
            <tr v-for="searchedDto in list" :key="searchedDto.balancesheetEstateId">
                <td style="text-align: center;"><input type="radio" id="searchedDto.balancesheetEstateId"
                        :value="searchedDto.balancesheetEstateId" v-model="selectedRow"
                        @click="onSelectChange(searchedDto.balancesheetEstateId)" /></td>

                <td><input type="checkbox" v-model="searchedDto.isSameData">前年と同一</td>
                <td style="text-align: right;">{{ searchedDto.balancesheetEstateCode }}</td>
                <td><select v-model="searchedDto.yoshikiEdaKbn" disabled="true">
                        <option value="ア">ア：土地</option>
                        <option value="イ">イ：建物</option>
                        <option value="ウ">ウ：地上権または借地権 </option>
                        <option value="エ">エ：取得価額が100万円を超える動産</option>
                        <option value="オ">オ：普通または当座でない預金(貯金)</option>
                        <option value="カ">カ：金銭信託</option>
                        <option value="キ">キ：有価証券</option>
                        <option value="ク">ク：出資による権利</option>
                        <option value="ケ">ケ：相手先ごとに残高100万円を超える貸付</option>
                        <option value="コ">コ：100万円を超える敷金</option>
                        <option value="サ">サ：100万円を超える施設利用の権利 </option>
                        <option value="シ">シ：相手先ごとに100万円を超える借入金</option>
                    </select></td>
                <td>{{ searchedDto.itemName }}</td>
                <td>{{ searchedDto.amount }}</td>
                <td>{{ searchedDto.accrualDate }}</td>
                <td>{{ searchedDto.biko }}</td>
                <td>&nbsp;</td>
                <td v-if="isEditable" style="text-align: center;"><button
                        @click="deleteRow(searchedDto.balancesheetEstateId)">削除</button></td>
            </tr>
        </table>
        <button v-if="isEditable" @click="addRow">新規行追加</button>
    </div>
    <br>
    <div class="footer" v-if="!isEditable">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSelect" class="footer-button">選択</button>
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
