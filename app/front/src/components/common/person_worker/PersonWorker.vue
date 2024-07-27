<script setup lang="ts">
import { computed, WritableComputedRef } from 'vue';
import PersonWorkerInterface from '../../../dto/person_worker/personWorkerDto';

//props,emit
const props = defineProps<{ editDto: PersonWorkerInterface, isInParts: boolean, isEditable: boolean }>();
/** 入力用Dto */
const personWorkerDto: WritableComputedRef<PersonWorkerInterface> = computed(() => { return props.editDto; });

//レイアウト変更変数
const leftAreaSpace: WritableComputedRef<string> = computed(() => { if (props.isInParts) { return "left-area-in" } else { return "left-area" } });

</script>
<template>
    <div :class="leftAreaSpace">
        ふりがな
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.firstNameKana" class="name-input-half" :disabled="!isEditable"
            placeholder="姓ふりがな">
        <input type="text" v-model="personWorkerDto.lastNameKana" class="left-space name-input-half" :disabled="!isEditable"
            placeholder="名ふりがな">
            <input type="text" v-model="personWorkerDto.middleNameKana" class="left-space name-input-half" :disabled="!isEditable"
            placeholder="ミドルネームふりがな">
    </div>
    <div class="clear-both"></div>

    <div :class="leftAreaSpace">
        姓名
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.firstName" class="name-input-half" :disabled="!isEditable" placeholder="姓">
        <input type="text" v-model="personWorkerDto.lastName" class="left-space name-input-half" :disabled="!isEditable"
            placeholder="姓">
            <input type="text" v-model="personWorkerDto.middleName" class="left-space name-input-half" :disabled="!isEditable"
            placeholder="ミドルネーム">
    </div>
    <div class="clear-both"></div>


    <div :class="leftAreaSpace">
        電話番号
    </div>
    <div class="right-area">
        <input type="text" v-model="personWorkerDto.tel1" :disabled="!isEditable" class="code-input">-
        <input type="text" v-model="personWorkerDto.tel2" :disabled="!isEditable" class="code-input">-
        <input type="text" v-model="personWorkerDto.tel3" :disabled="!isEditable" class="code-input">
    </div>

</template>
<style scoped>
textarea {
    font-size: 1.25em;
    width: 75%;
    font-weight: bold;
}
input.name-input-half {
  width: 18%;
  text-align: left;
}

</style>
