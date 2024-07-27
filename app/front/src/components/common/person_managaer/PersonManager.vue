<script setup lang="ts">
import { computed, WritableComputedRef } from 'vue';
import PersonManagerInterface from '../../../dto/person_manager/personManager';

//props,emit
const props = defineProps<{ editDto: PersonManagerInterface, isInParts: boolean, isEditable: boolean }>();

/** 入力用Dto */
const personManagerDto: WritableComputedRef<PersonManagerInterface> = computed(() => { return props.editDto; });

//レイアウト変更変数
const leftAreaSpace: WritableComputedRef<string> = computed(() => { if (props.isInParts) { return "left-area-in" } else { return "left-area" } });

</script>
<template>
    <div :class="leftAreaSpace">
        ふりがな
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.firstNameKana" class="name-input" :disabled="!isEditable"
            placeholder="姓ふりがな">
        <input type="text" v-model="personManagerDto.lastNameKana" class="left-space name-input" :disabled="!isEditable"
            placeholder="名ふりがな">
            <input type="text" v-model="personManagerDto.middleNameKana" class="left-space name-input" :disabled="!isEditable"
            placeholder="ミドルネームふりがな">
    </div>
    <div class="clear-both"></div>

    <div :class="leftAreaSpace">
        姓名
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.firstName" class="name-input" :disabled="!isEditable"
            placeholder="姓">
        <input type="text" v-model="personManagerDto.lastName" class="left-space name-input" :disabled="!isEditable"
            placeholder="名">
            <input type="text" v-model="personManagerDto.middleName" class="left-space name-input" :disabled="!isEditable"
            placeholder="ミドルネーム">
    </div>
    <div class="clear-both"></div>

    <div :class="leftAreaSpace">
        電話番号
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.tel1" :disabled="!isEditable" class="code-input">-
        <input type="text" v-model="personManagerDto.tel2" :disabled="!isEditable" class="code-input">-
        <input type="text" v-model="personManagerDto.tel3" :disabled="!isEditable" class="code-input">
    </div>

    <div :class="leftAreaSpace">
        郵便番号
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.postalcode1" :disabled="!isEditable" class="code-input">-
        <input type="text" v-model="personManagerDto.postalcode2" :disabled="!isEditable" class="code-input">
    </div>

    <div :class="leftAreaSpace">
        住所
    </div>
    <div class="right-area">
        <textarea v-model="personManagerDto.addressPostal" :disabled="!isEditable"></textarea><br>
        <textarea v-model="personManagerDto.addressBlock" :disabled="!isEditable"></textarea><br>
        <textarea v-model="personManagerDto.addressBuilding" :disabled="!isEditable"></textarea><br>
    </div>

    <div :class="leftAreaSpace">
        生年月日
    </div>
    <div class="right-area">
        <input type="date" v-model="personManagerDto.birtday" :disabled="!isEditable" class="name-input">
    </div>
    <div class="clear-both"></div>

</template>
<style scoped>
</style>
