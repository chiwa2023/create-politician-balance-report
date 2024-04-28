<script setup lang="ts">
import { Ref, ref } from "vue";
import VariousFinancialPayInterface from "../../../dto/financial/vairousFinancialPayDto";
import VariousFinancialPayDto from "../../../dto/financial/vairousFinancialPayDto";
import mockGetVariousFainancialPay from "./mock/mockGetVariousFainacialPay";

//props,emit
const props = defineProps<{ isEditable: boolean }>();
const emits = defineEmits(["sendCancelSearchVariousFinancialPay", "sendVariousFinancialPayInterface"]);

/** 表示行 */
const list: Ref<VariousFinancialPayInterface[]> = ref([]);
/** ラジオボタン選択 */
const selectedRow:Ref<number> = ref(0);

/**  
 * 入力内容を選択する
 */
function onSelect() {
    //PrimaryIdをKeyにしているので、1件だけに絞られることが保証されている
    const selectedDto:VariousFinancialPayInterface = list.value.filter((dto) => dto.variousFinancialPayId == selectedRow.value )[0];
    emits("sendVariousFinancialPayInterface",selectedDto);
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelSearchVariousFinancialPay");
}

/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId:number) {
    const newList:VariousFinancialPayInterface[] = list.value.filter((dto) => dto.variousFinancialPayId != rowId );
    list.value = newList;
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow(){
    let maxId = 0;
    for(const dto of list.value){
        if(maxId<dto.variousFinancialPayId){
            maxId = dto.variousFinancialPayId;
        }
    }
    const addDto:VariousFinancialPayInterface = new VariousFinancialPayDto();
    addDto.variousFinancialPayId = maxId;
    list.value.push(addDto);
}

const searchWords:Ref<string> = ref("");
/**  
 * 検索条件に基づき検索を行う
 */
function onSearch(){
    alert(searchWords.value);
    //リストを取得する
    list.value = mockGetVariousFainancialPay();
}
</script>
<template>
    <h3>各種Pay検索</h3>
    <div class="online">
        検索条件の指定
    </div>
    <div class="left-area-component">
        検索語
    </div>
    <div class="right-area-component">
        <input type="text" v-model="searchWords" style="margin-right:2%;"><button @click="onSearch">検索</button>
    </div>
    <br>
    <div class="online">
    検索結果の表示

    <table style="width:45%;">
        <tr>
            <th style="width:10%;">&nbsp;</th>
            <th style="width:30%;">コード</th>
            <th>名前</th>
            <th v-if="props.isEditable" style="width:20%;">&nbsp;</th>
        </tr>
        <tr v-for="variousDto in list" :key="variousDto.variousFinancialPayId">
            <td style="text-align: center;"><input type="radio" id="variousDto.variousFinancialPayId" :value="variousDto.variousFinancialPayId" v-model="selectedRow"  /></td>
            <td style="text-align: right;">{{ variousDto.variousFinancialPayCode }}</td>
            <td>{{ variousDto.variousFinancialPayName }}</td>
            <td v-if="props.isEditable" style="text-align: center;"><button @click="deleteRow(variousDto.variousFinancialPayId)">削除</button></td>
        </tr>
    </table>
    <button v-if="props.isEditable" @click="addRow">新規行追加</button>
    </div>
    <br>
    <div class="footer">
        <button @click="onCancel">キャンセル</button>
        <button @click="onSelect">選択</button>
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
