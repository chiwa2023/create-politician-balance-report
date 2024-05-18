<script setup lang="ts">
import { Ref, ref } from "vue";
import AuditOpinioIncomeDto from "../dto/audit_opinion/auditOpinionIncomeDto";
import ShowMeetingAdjustIncome from "./common/show_meeting_adjust_income/ShowMeetingAdjustIncome.vue";
import SearchBalancesheetIncome from "./common/search_balancesheet_income/SearchBalancesheetIncome.vue";

const abc: Ref<AuditOpinioIncomeDto> = ref(new AuditOpinioIncomeDto());

const incomeCode: Ref<number> = ref(0);
const incomeItemName:Ref<string> = ref("寄付 政治団体三郎");

const recieveData = (data: AuditOpinioIncomeDto) => {
    abc.value = data;
};


</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    
    <input type="number" v-model="incomeCode"> <input type="text" v-model="incomeItemName" class="leftMargin"><button class="leftMargin">収入項目を検索</button>

    <ShowMeetingAdjustIncome :incomeCode="incomeCode" @sendData="recieveData"></ShowMeetingAdjustIncome>
    {{ abc.auditOpinionId }}
</template>
<style scoped></style>
