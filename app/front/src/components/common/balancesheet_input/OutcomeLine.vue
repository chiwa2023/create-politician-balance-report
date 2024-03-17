<script setup lang="ts">
import { computed, watch } from "vue";
import changeOutcomeYoshikiKbnState from "../../../dto/balancesheet/changeOutcomeYoshikiKbnState";
import viewPrepareOutcome from "../../../dto/balancesheet/viewPrepareOutcome";
import BalancesheetOutcomeInterface from "../../../dto/balancesheetOutcomeDto";

const props = defineProps<{ lineIndex: number, lineDto: BalancesheetOutcomeInterface }>();
const emit = defineEmits(["restoreOutcomeReadData"]);

//行Index
const lineIndex = computed(
    () => {
        return props.lineIndex;
    }
);

//行データ
const outcomeItem = computed(
    () => {
        return props.lineDto;
    }
);

/** 報告区分を監視 */
watch(() => outcomeItem.value.reportKbn, () => {
    viewPrepareOutcome(outcomeItem.value);
});


/** 様式区分を監視 */
watch(() => outcomeItem.value.yoshikiKbn, () => {
    changeOutcomeYoshikiKbnState(outcomeItem.value);
});

//入力不可能を監視
watch(() => outcomeItem.value.isEditAutoInput, (newValue) => {
    if (!newValue) {
        emit("restoreOutcomeReadData", lineIndex.value);
    }
});
</script>
<template>
    <td><input type="text" v-model="outcomeItem.referDigest" :disabled="true"></td>
    <td><input type="date" v-model="outcomeItem.accrualDate" :disabled="!outcomeItem.isEditAutoInput"></td>
    <td><input type="number" v-model="outcomeItem.amount" :disabled="!outcomeItem.isEditAutoInput"></td>
    <td><input type="radio" v-model="outcomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="11">報告対象外政治関連(廃止予定)<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="50">タスク計上(後で変更)</td>
    <td>
        <div v-show="outcomeItem.isUseYoshikiKbn"><select v-model="outcomeItem.yoshikiKbn">
                <option value="14">14.人件費を除く経常収支</option>
                <option value="15">15.政治活動費</option>
                <option value="16">16.本部／支部交付金に係る支出</option>
            </select></div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseYoshikiEdaKbn">
            <select v-model="outcomeItem.yoshikiEdaKbn">
                <option v-for="option in outcomeItem.yoshikiEdaKbnOptions" v-bind:value="option.value"
                    v-bind:key="option.value">
                    {{ option.text }}
                </option>
            </select>

        </div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseCategorizedGroup">小分類：<br><input type="text"
                v-model="outcomeItem.categorizeGroup"></div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseItemName">支出の適用：<br><input type="text" v-model="outcomeItem.itemName">
        </div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseOrgName">支出を受けた者の氏名(団体名称)：<br><input type="text"
                v-model="outcomeItem.shimeiOrgnizationName"></div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseAddress">支出を受けた者の住所：<br><input type="text"
                v-model="outcomeItem.orgnizationAddress"></div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseBiko"><input type="text" v-model="outcomeItem.biko"></div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseCollectRecipt">
            <select v-model="outcomeItem.notCollectReciptKbn">
                <option value=""></option>
                <option value="1">1.支出明細書作成</option>
                <option value="2">2.支出目的書(振込明細)を作成</option>
            </select>
        </div>
    </td>
    <td>
        <div v-show="outcomeItem.isUseRelatedGrants">交付金に係る支出：<br><input type="checkbox"
                v-model="outcomeItem.isExpendituresRelatedGrants">交付金に係る支出</div>
    </td>
    <td><textarea v-model="outcomeItem.note"></textarea></td>
    <td><input type="checkbox" v-model="outcomeItem.isDifferPrecedent">前例と異なる処理</td>
    <td><input type="checkbox" v-model="outcomeItem.isEditAutoInput">入力できない部分を<br>入力可能にする</td>
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
