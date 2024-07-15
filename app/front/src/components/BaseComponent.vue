<script setup lang="ts">
import SelectPoliticalOrgnizationKbn from "../components/common/select_political_orgnization_kbn/SelectPoliticalOrgnizationKbn.vue";

function aaa(){
    alert("キャンセルbbb");
}
function bbb(){
    alert("保存aaa");
}
</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <SelectPoliticalOrgnizationKbn @send-cancel-select-political-organization-kbn="aaa" @send-select-political-organization-kbn-interface="bbb" ></SelectPoliticalOrgnizationKbn>
</template>
<style scoped></style>
