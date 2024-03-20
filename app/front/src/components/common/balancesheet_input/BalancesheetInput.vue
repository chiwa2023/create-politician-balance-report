<script setup lang="ts">
import { computed, WritableComputedRef } from "vue";
import BalancesheetIncomeInterface from "../../../dto/balancesheetIncomeDto";
import BalancesheetOutcomeInterface from "../../../dto/balancesheetOutcomeDto";
import IncomeLineVue from "./IncomeLine.vue";
import OutcomeLineVue from "./OutcomeLine.vue";

//propsとemit
const props = defineProps<{ listIncome: BalancesheetIncomeInterface[], listOutcome: BalancesheetOutcomeInterface[] }>();
const emit = defineEmits(["restoreIncomeReadData", "restoreOutcomeReadData"]);

//収入リスト
const listBalancesheetIncome: WritableComputedRef<BalancesheetIncomeInterface[]> = computed(
    () => props.listIncome,
);

//支出リスト
const listBalancesheetOutcome: WritableComputedRef<BalancesheetOutcomeInterface[]> = computed(
    () => props.listOutcome,
);

/**
 * 自動読み込みデータの編集をやめるならデータを復元(収入)
 * @param index 行番号
 */
function restoreIncomeReadData(index: number) {
    //中継するだけ
    emit("restoreIncomeReadData", index);
}


/**
 * 自動読み込みデータの編集をやめるならデータを復元(支出)
 * @param index 行番号
 */
function restoreOutcomeReadData(index: number) {
    //中継するだけ
    emit("restoreOutcomeReadData", index);
}
</script>
<template>
    <div class="one-line" style="overflow: scroll;">
        <h3>収入の部</h3>
        <table style="overflow: scroll;white-space: nowrap;">
            <tr>
                <th>参照摘要</th>
                <th>発生日</th>
                <th>金額</th>
                <th>*報告対象</th>
                <th>*仕訳大項目</th>
                <th>*仕訳小項目</th>
                <th>*項目</th>
                <th>*項目(氏名/職業)</th>
                <th>*項目(住所)</th>
                <th>*あっせんで集めた期間</th>
                <th>*政治資金パーティ名称</th>
                <th>*パーティ開催日</th>
                <th>*備考</th>
                <th>*寄付金控除</th>
                <th>+仕訳意見付記</th>
                <th>+前例と異なる処理</th>
                <th>+自動入力編集</th>
            </tr>
            <tr v-for="(incomeItem, indexIncome) in listBalancesheetIncome" :key="incomeItem.readingLine">
                <IncomeLineVue :lineIndex="indexIncome" :lineDto="incomeItem"
                    @restoreIncomeReadData="restoreIncomeReadData"></IncomeLineVue>
            </tr>
        </table>
        *…収支報告書に記載される項目。+…このソフトウェア独自項目
    </div>
    <div class="one-line" style="overflow: scroll;">
        <h3>支出の部</h3>
        <table style="overflow: scroll;white-space: nowrap;">
            <tr>
                <th>参照摘要</th>
                <th>発生日</th>
                <th>金額</th>
                <th>*報告対象</th>
                <th>*仕訳大項目</th>
                <th>*仕訳小項目</th>
                <th>*小分類</th>
                <th>*支出の目的</th>
                <th>*個人氏名/団体名称</th>
                <th>*住所</th>
                <th>*備考</th>
                <th>*領収書を徴しがたかった</th>
                <th>*交付金に係る支出</th>
                <th>+仕訳意見付記</th>
                <th>+前例と異なる処理</th>
                <th>+自動入力編集</th>
            </tr>
            <tr v-for="(outcomeItem, indexOutcome) in listBalancesheetOutcome" :key="outcomeItem.readingLine">
                <OutcomeLineVue :lineIndex="indexOutcome" :lineDto="outcomeItem"
                    @restoreOutcomeReadData="restoreOutcomeReadData"></OutcomeLineVue>
            </tr>
        </table>
        *…収支報告書に記載される項目。+…このソフトウェア独自項目
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
