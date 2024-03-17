<script setup lang="ts">
import { ref, Ref, toRaw } from "vue";
import BalancesheetIncomeDto from "../dto/balancesheetIncomeDto";
import BalancesheetOutcomeDto from "../dto/balancesheetOutcomeDto";
import BalancesheetInput from "./common/balancesheet_input/BalancesheetInput.vue";

const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

const backupListIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const backupListOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);




const times: Ref<number> = ref(0);

const onButton = () => {
    alert("押された");
    times.value = times.value + 1;
    listBalancesheetIncome.value.splice(0);
    listBalancesheetOutcome.value.splice(0);
    for (let index = 0; index < times.value; index++) {
        listBalancesheetIncome.value.push(new BalancesheetIncomeDto());
        listBalancesheetOutcome.value.push(new BalancesheetOutcomeDto());
    }
    backupListIncome.value = structuredClone(toRaw(listBalancesheetIncome.value));
    backupListOutcome.value = structuredClone(toRaw(listBalancesheetOutcome.value));
};

//自動読み込みデータの編集をやめるならデータを復元(収入)
function restoreIncomeReadData(index: number) {
    listBalancesheetIncome.value[index].accrualDate = backupListIncome.value[index].accrualDate;
    listBalancesheetIncome.value[index].amount = backupListIncome.value[index].amount;
}

//自動読み込みデータの編集をやめるならデータを復元(支出)
function restoreOutcomeReadData(index: number) {
    alert("復元(component)" + index);
    listBalancesheetOutcome.value[index].accrualDate = backupListOutcome.value[index].accrualDate;
    listBalancesheetOutcome.value[index].amount = backupListOutcome.value[index].amount;
}

</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <BalancesheetInput :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome"
        @restoreIncomeReadData="restoreIncomeReadData" @restoreOutcomeReadData="restoreOutcomeReadData">
    </BalancesheetInput>
    <hr>
    <input type="number" v-model="times"><button @click="onButton">押す</button>
</template>
<style scoped></style>
