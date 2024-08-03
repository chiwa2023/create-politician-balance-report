<script setup lang="ts">
import { Ref, ref } from "vue";
import createCheckTransactionDto from "../../../dto/common_check/createCheckTransactionDto";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import SearchPersonManagerCapsuleDto from "../../../dto/person_manager/searchPersonManagerCapsuleDto";
import PersonManagerInterface from "../../../dto/person_manager/personManager";
import PersonManagerDto from "../../../dto/person_manager/personManager";
import mockGetPersonManager from "./mock/mockGetPersonManager";

//props,emit
const props = defineProps<{ isEditable: boolean,callIndex: number }>();
const emits = defineEmits(["sendCancelSearchPersonManager", "sendPersonManagerInterface"]);

/** 表示行 */
const list: Ref<PersonManagerInterface[]> = ref([]);
/** ラジオボタン選択 */
const selectedRow: Ref<number> = ref(0);

/**  
 * 選択行を通知する
 * @param rowId その行のDtoのId
 */
function onSelectChange(rowId: number) {
    if (true === props.isEditable) {
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
    const selectedDto: PersonManagerInterface = list.value.filter((dto) => dto.personManagerId == rowId)[0];
    emits("sendPersonManagerInterface", selectedDto,props.callIndex);
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelSearchPersonManager");
}

/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId: number) {
    const newList: PersonManagerInterface[] = list.value.filter((dto) => dto.personManagerId != rowId);
    list.value = newList;
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow() {
    let maxId = 0;
    for (const dto of list.value) {
        if (maxId < dto.personManagerId) {
            maxId = dto.personManagerId;
        }
    }
    const addDto: PersonManagerInterface = new PersonManagerDto();
    addDto.personManagerId = maxId;
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
    const searchPersonManagerCapsuleDto: SearchPersonManagerCapsuleDto = new SearchPersonManagerCapsuleDto();
    searchPersonManagerCapsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
    searchPersonManagerCapsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
    //編集フラグがある場合は、そのフラグ(の反転した値)を照会フラグに設定する
    searchPersonManagerCapsuleDto.checkTransactionDto = createCheckTransactionDto(!props.isEditable);

    //独自変数設定
    searchPersonManagerCapsuleDto.searchWords = searchWords.value;

    //Mockリストの取得
    list.value = mockGetPersonManager();
}
</script>
<template>
    <h3>責任者検索</h3>
    <div class="one-line">
        検索条件の指定
    </div>
    <div class="left-area-component">
        検索語
    </div>
    <div class="right-area-component">
        <input type="text" v-model="searchWords" style="margin-right:2%;"><button @click="onSearch">検索</button>
    </div>
    <br>
    <div class="one-line">
        検索結果の表示

        <table style="width:45%;">
            <tr>
                <th style="width:10%;">&nbsp;</th>
                <th style="width:30%;">コード</th>
                <th>名前</th>
                <th v-if="props.isEditable" style="width:20%;">&nbsp;</th>
            </tr>
            <tr v-for="searchedDto in list" :key="searchedDto.personManagerId">
                <td style="text-align: center;"><input type="radio" id="searchedDto.personManagerId"
                        :value="searchedDto.personManagerId" v-model="selectedRow"
                        @click="onSelectChange(searchedDto.personManagerId)" /></td>
                <td style="text-align: right;">{{ searchedDto.personManagerCode }}</td>
                <td>{{ searchedDto.personManagerName }}</td>
                <td v-if="props.isEditable" style="text-align: center;"><button
                        @click="deleteRow(searchedDto.personManagerId)">削除</button></td>
            </tr>
        </table>
        <button v-if="props.isEditable" @click="addRow">新規行追加</button>
    </div>
    <br>
    <div class="footer" v-if="!props.isEditable">
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
