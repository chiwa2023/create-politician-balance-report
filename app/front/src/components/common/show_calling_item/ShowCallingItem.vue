<script setup lang="ts">
import { Ref, WritableComputedRef, computed, onBeforeMount, ref } from "vue";
import CallingItemEntity from "../../../entity/callingItemEntity";
import YoushikiEdaKbnIncomeConstants from "../../../dto/balancesheet/youshikiEdaKbnIncomeConstants";
import YoushikiEdaKbnOutcomeConstants from "../../../dto/balancesheet/youshikiEdaKbnOutcomeConstants";
import YoushikiKbnIncomeConstants from "../../../dto/balancesheet/youshikiKbnIncomeConstants";
import YoushikiKbnOutcomeConstants from "../../../dto/balancesheet/youshikiKbnOutcomeConstants";

//props,emits
const props = defineProps<{ digest: string, listItem: CallingItemEntity[] }>();
const emits = defineEmits(["sendCancelShowCallingItem", "sendCallingItemEntity"]);

//候補マップ
const listCallingItem: WritableComputedRef<CallingItemEntity[]> = computed(
    () => props.listItem,
);

const list: Ref<CallingItemEntity[]> = ref([]);

onBeforeMount(() => {
    alert(listCallingItem.value.length);

    //初期化して追加
    list.value.splice(0);
    for (const dto of listCallingItem.value) {
        if (dto.callingReferDigest === props.digest) {
            //一致するデータに絞込
            list.value.push(dto);
        }
    }

});

/** ラジオボタン選択 */
const selectedRow: Ref<number> = ref(0);

/**  
 * 入力内容を破棄する
 */
function onCancel() {
    emits("sendCancelShowCallingItem");
}
/**  
 * 選択データを送信する
 */
function onSelect() {
    //PrimaryIdをKeyにしているので、1件だけに絞られることが保証されている
    const selectedDto: CallingItemEntity = list.value.filter((dto) => dto.callingItemId == selectedRow.value)[0];
    emits("sendCallingItemEntity", selectedDto);
}

/**  
 * 様式枝区分項目のテキストを取得する
 * @param youshikiKbn 様式区分
 * @param edaKbn 様式枝区分
 * @returns 表示テキスト
 */
function getYoushikiEdaKbnText(youshikiKbn: number, edaKbn: number): string {

    if (youshikiKbn > 13) {
        return YoushikiEdaKbnOutcomeConstants.convertText(youshikiKbn, String(edaKbn));
    }
    else {
        return YoushikiEdaKbnIncomeConstants.convertText(String(edaKbn));
    }
}

/**  
 * 様式区分のテキストを取得する
 * @param youshikiKbn 様式区分
 * @returns 表示テキスト
 */
function getYoushikiKbnText(youshikiKbn: number): string {

    if (youshikiKbn > 13) {
        return YoushikiKbnOutcomeConstants.convertText(youshikiKbn);
    }
    else {
        return YoushikiKbnIncomeConstants.convertText(youshikiKbn);
    }
}

</script>
<template>
    <h1>項目呼び出し一覧</h1>
    検索結果の表示
    <!-- TODO 表示項目は仕様決定次第修正する(現状不足している) -->
    <table style="width:45%;">
        <tr>
            <th style="width:10%;">&nbsp;</th>
            <th style="width:30%;">摘要</th>
            <th>項目名</th>
            <th>様式区分</th>
            <th>様式枝区分項目</th>
        </tr>
        <tr v-for="callingItemEntity in list" :key="callingItemEntity.callingItemId">
            <td style="text-align: center;"><input type="radio" id="callingItemEntity.callingItemId"
                    :value="callingItemEntity.callingItemId" v-model="selectedRow" /></td>
            <td style="text-align: right;">{{ callingItemEntity.callingReferDigest }}</td>
            <td style="text-align: right;">{{ callingItemEntity.publishItemName }}</td>
            <td>{{ getYoushikiKbnText(callingItemEntity.youshikiKbn) }}</td>
            <td>{{ getYoushikiEdaKbnText(callingItemEntity.youshikiKbn, callingItemEntity.youshikiEdaKbn) }}</td>
        </tr>
    </table>
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
