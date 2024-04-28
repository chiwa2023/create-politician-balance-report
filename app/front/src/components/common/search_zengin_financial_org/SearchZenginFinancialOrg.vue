<script setup lang="ts">
import { Ref, ref } from "vue";
import ZenginFinancialOrgInterface from "../../../dto/financial/zenginFinancialOrg";
import ZenginFinancialOrgDto from "../../../dto/financial/zenginFinancialOrg";
import mockGetZenginFinancialOrg from "./mock/mockGetZenginFainancialOrg";

//props,emit
const props = defineProps<{ isEditable: boolean }>();
const emits = defineEmits(["sendCancelSearchZenginFinancialOrg","sendZenginFinancialOrgInterface"]);

/** 表示行 */
const list: Ref<ZenginFinancialOrgInterface[]> = ref([]);
/** ラジオボタン選択 */
const selectedRow:Ref<number> = ref(0);

/**  
 * 入力内容を選択する
 */
function onSelect() {
    //PrimaryIdをKeyにしているので、1件だけに絞られることが保証されている
    const selectedDto:ZenginFinancialOrgInterface = list.value.filter((dto) => dto.zenginFinancialOrgId == selectedRow.value )[0];
    emits("sendZenginFinancialOrgInterface",selectedDto);
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelSearchZenginFinancialOrg");
}

/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId:number) {
    const newList:ZenginFinancialOrgInterface[] = list.value.filter((dto) => dto.zenginFinancialOrgId != rowId );
    list.value = newList;

    alert("行削除:"+rowId);
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow(){
    let maxId = 0;
    for(const dto of list.value){
        if(maxId<dto.zenginFinancialOrgId){
            maxId = dto.zenginFinancialOrgId;
        }
    }
    const addDto:ZenginFinancialOrgInterface = new ZenginFinancialOrgDto();
    addDto.zenginFinancialOrgId = maxId;
    list.value.push(addDto);
}

const searchWords:Ref<string> = ref("");
/**  
 * 検索条件に基づき検索を行う
 */
function onSearch(){
    alert(searchWords.value);
    //リストを取得する
    list.value = mockGetZenginFinancialOrg();
}
</script>
<template>
    <h3>全銀金融機関検索</h3>
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
        <tr v-for="variousDto in list" :key="variousDto.zenginFinancialOrgId">
            <td style="text-align: center;"><input type="radio" id="variousDto.ZenginFinancialOrgId" :value="variousDto.zenginFinancialOrgId" v-model="selectedRow"  /></td>
            <td style="text-align: right;">{{ variousDto.zenginFinancialOrgCode }}</td>
            <td>{{ variousDto.zenginFinancialOrgName }}</td>
            <td v-if="props.isEditable" style="text-align: center;"><button @click="deleteRow(variousDto.zenginFinancialOrgId)">削除</button></td>
        </tr>
    </table>
    <button v-if="props.isEditable" @click="addRow">新規行追加</button>
    </div>
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
