<script setup lang="ts">
import { computed, WritableComputedRef } from 'vue';
import PersonWorkerInterface from '../../../dto/person_worker/personWorkerDto';

//props,emit
const props = defineProps<{ editDto: PersonWorkerInterface }>();
/** 入力用Dto */
const personWorkerDto: WritableComputedRef<PersonWorkerInterface> = computed(() => { return props.editDto; });

</script>
<template>
    <div class="left-area-in">
        ふりがな
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.firstNameKana"  class="text-input" disabled="true"  placeholder="姓ふりがな">
        <input type="text" v-model="personWorkerDto.lastNameKana" class="left-space text-input" disabled="true" placeholder="名ふりがな">
    </div>
    <div class="clear-both"></div>

    <div class="left-area-in">
        姓名
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.firstName" class="text-input" disabled="true" placeholder="姓">
        <input type="text" v-model="personWorkerDto.lastName" class="left-space text-input" disabled="true" placeholder="姓">
    </div>
    <div class="clear-both"></div>


    <div class="left-area-in">
        電話番号
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.tel1" disabled="true" class="code-input" >-
        <input type="text" v-model="personWorkerDto.tel2" disabled="true" class="code-input" >-
        <input type="text" v-model="personWorkerDto.tel3" disabled="true" class="code-input" >
    </div>

</template>
<style scoped>
textarea {
  font-size: 1.25em;
  width:75%;
  font-weight: bold;
}

</style>
