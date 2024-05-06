<script setup lang="ts">
import { computed, WritableComputedRef } from "vue";
import VariousFinancialPayInterface from "../../../dto/financial/vairousFinancialPayDto";

const props = defineProps<{ selectedDto: VariousFinancialPayInterface, }>();
const editDto: WritableComputedRef<VariousFinancialPayInterface> = computed(
    () => props.selectedDto,
);
</script>
<template>
    <h3>編集内容入力</h3>
    <input type="text" v-model="editDto.variousFinancialPayId" /><br>
    <input type="text" v-model="editDto.variousFinancialPayName" /><br>
</template>
<style scoped></style>
