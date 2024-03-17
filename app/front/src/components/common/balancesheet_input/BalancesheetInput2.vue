<script setup lang="ts">
import { ref, Ref, onBeforeMount, computed, WritableComputedRef,reactive, watch, toRaw} from 'vue';

import BalancesheetIncomeInterface from '../../../dto/balancesheetIncomeDto';
import BalancesheetIncomeDto from '../../../dto/balancesheetIncomeDto';
import BalancesheetOutcomeInterface from '../../../dto/balancesheetOutcomeDto';

import IncomeLineVue from './IncomeLine.vue';

//propsとemit
const props = defineProps<{ listIncome: BalancesheetIncomeInterface[], listOutcome: BalancesheetOutcomeInterface[] }>();
const emit = defineEmits(['sendBalancesheetIncomeInterface', 'sendBalancesheetOutcomeInterface'])


//const listBalancesheetIncome: Ref<BalancesheetIncomeInterface[]> = ref([]);
//const listBalancesheetOutcome: Ref<BalancesheetOutcomeInterface[]> = ref([]);

const listBalancesheetIncome: WritableComputedRef<BalancesheetIncomeInterface[]> = computed({
    get: () => props.listIncome,
    set: (value) => { alert("変更Income"); emit('sendBalancesheetIncomeInterface', value) }
})

const listBalancesheetOutcome: WritableComputedRef<BalancesheetOutcomeInterface[]> = computed({
    get: () => props.listOutcome,
    set: (value) => { emit('sendBalancesheetOutcomeInterface', value) }
})

const lineIndex = ref(0);
let lineDto = reactive(new BalancesheetIncomeDto());
const backupLineDto:BalancesheetIncomeDto = structuredClone(toRaw(lineDto));

function bbb(){
    lineDto.accrualDate = backupLineDto.accrualDate;
    lineDto.amount = backupLineDto.amount;
}

</script>
<template>
    <h1>テスト中</h1>
    <IncomeLineVue :lineIndex="lineIndex" :lineDto="lineDto" @aaa="bbb"></IncomeLineVue>
    <hr>
    id:{{ lineDto.yoshikiKbn }}<br>
    name:{{ lineDto.yoshikiEdaKbn }}<br>

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
