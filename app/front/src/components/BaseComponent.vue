<script setup lang="ts">
import { ref, Ref } from 'vue';
import BalancesheetIncomeDto from '../dto/balancesheetIncomeDto';
import BalancesheetOutcomeDto from '../dto/balancesheetOutcomeDto';

import BalancesheetInput from './common/balancesheet_input/BalancesheetInput.vue';

const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

const times:Ref<number> = ref(0);

const onButton = () =>{
    alert("押された");
    listBalancesheetIncome.value.splice(0);
    listBalancesheetOutcome.value.splice(0);
    for(let index = 0 ; index<times.value ;  index++){
        listBalancesheetIncome.value.push(new BalancesheetIncomeDto());
        listBalancesheetOutcome.value.push(new BalancesheetOutcomeDto());
    }
}
</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <BalancesheetInput :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome"></BalancesheetInput>
    <hr>
    <input type="number" v-model="times"><button @click="onButton">押す</button>
</template>
<style scoped></style>
