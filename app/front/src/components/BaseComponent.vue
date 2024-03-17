<script setup lang="ts">
import { ref, Ref } from 'vue';
import BalancesheetIncomeDto from '../dto/balancesheetIncomeDto';
import BalancesheetOutcomeDto from '../dto/balancesheetOutcomeDto';

import BalancesheetInput2 from './common/balancesheet_input/BalancesheetInput2.vue';
import TestComponentParent3Vue from './common/balancesheet_input/TestComponentParent3.vue';

const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

const times:Ref<number> = ref(0);

const onButton = () =>{
    alert("押された");
    times.value = times.value+1;
    listBalancesheetIncome.value.splice(0);
    listBalancesheetOutcome.value.splice(0);
    for(let index = 0 ; index<times.value ;  index++){
        listBalancesheetIncome.value.push(new BalancesheetIncomeDto());
        listBalancesheetOutcome.value.push(new BalancesheetOutcomeDto());
    }
}

function recieveBalancesheetIncomeInterface (list:BalancesheetIncomeDto[]){
    alert("recieve");
    listBalancesheetIncome.value = list;
}

</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <BalancesheetInput2 :list-income="listBalancesheetIncome" :list-outcome="listBalancesheetOutcome" @sendBalancesheetIncomeInterface="recieveBalancesheetIncomeInterface"></BalancesheetInput2>
    <!--
    <TestComponentParent3Vue></TestComponentParent3Vue>
    -->
    <hr>
    <input type="number" v-model="times"><button @click="onButton">押す</button>
</template>
<style scoped></style>
