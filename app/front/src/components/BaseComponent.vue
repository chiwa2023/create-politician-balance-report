<script setup lang="ts">
import { Ref, ref } from "vue";
import { AllSheet0703JournalAndOtherDto } from '../dto/publish/5/kbn03/allSheet0703JournalAndOtherDto';
import AllSheet0703JournalAndOther from './common/comatible/5/kbn03/AllSheet0703JournalAndOther.vue';
import mockGetAllSheet0703JournalAndOtherDto from '../dto/publish/5/kbn03/mockGetAllSheet0703JournalAndOtherDto';

//MockData
const sheetDto:Ref<AllSheet0703JournalAndOtherDto> = ref(mockGetAllSheet0703JournalAndOtherDto());

</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <AllSheet0703JournalAndOther :sheed-dto="sheetDto"></AllSheet0703JournalAndOther>
</template>
<style scoped></style>
