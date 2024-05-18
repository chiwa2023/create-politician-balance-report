<script setup lang="ts">
import { Ref, onBeforeMount, ref } from "vue";
import BalancesheetIncomeInterface from "../../../dto/balancesheetIncomeDto";
import BalancesheetIncomeDto from "../../../dto/balancesheetIncomeDto";

//props,emit
const props = defineProps<{ isEditable: boolean }>();
const emits = defineEmits(["sendCancelSearchBalancesheetIncome", "sendBalancesheetIncomeInterface"]);

/** 表示行 */
const list: Ref<BalancesheetIncomeInterface[]> = ref([]);

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
    const selectedDto: BalancesheetIncomeInterface = list.value.filter((dto) => dto.balancesheetIncomeId == rowId)[0];
    emits("sendBalancesheetIncomeInterface", selectedDto);
}
/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelSearchBalancesheetIncome");
}

/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId: number) {
    const newList: BalancesheetIncomeInterface[] = list.value.filter((dto) => dto.balancesheetIncomeId != rowId);
    list.value = newList;
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow() {
    let maxId = 0;
    for (const dto of list.value) {
        if (maxId < dto.balancesheetIncomeId) {
            maxId = dto.balancesheetIncomeId;
        }
    }
    const addDto: BalancesheetIncomeInterface = new BalancesheetIncomeDto();
    addDto.balancesheetIncomeId = maxId;
    list.value.push(addDto);
}

onBeforeMount(() => {
    //props.incomeCodeを用いて該当意見付記リスト取得
    list.value.push(new BalancesheetIncomeDto());
});

</script>
<template>
    <h3>収入項目検索</h3>
    <!-- TODO 検索条件は決定次第修正する 
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
    -->
    <div class="online">
        検索結果の表示

        <table style="width:45%;">
            <tr>
                <th style="width:10%;">&nbsp;</th>
                <th style="width:30%;">コード</th>
                <th>摘要</th>
                <th v-if="props.isEditable" style="width:20%;">&nbsp;</th>
            </tr>
            <tr v-for="incomeDto in list" :key="incomeDto.balancesheetIncomeId">
                <td style="text-align: center;"><input type="radio" id="incomeDto.balancesheetIncomeId"
                        :value="incomeDto.balancesheetIncomeId" v-model="selectedRow"
                        @click="onSelectChange(incomeDto.balancesheetIncomeId)" /></td>
                <td style="text-align: right;">{{ incomeDto.balancesheetIncomeCode }}</td>
                <td>{{ incomeDto.itemName }}</td>
                <td v-if="props.isEditable" style="text-align: center;"><button
                        @click="deleteRow(incomeDto.balancesheetIncomeId)">削除</button></td>
            </tr>
        </table>
        <button v-if="props.isEditable" @click="addRow">新規行追加</button>
    </div>
    <br>
    <div class="footer" v-if="!props.isEditable">
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
