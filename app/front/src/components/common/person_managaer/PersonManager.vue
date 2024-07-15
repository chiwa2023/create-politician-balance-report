<script setup lang="ts">
import { computed, WritableComputedRef } from 'vue';
import PersonManagerInterface from '../../../dto/person_manager/personManager';

//props,emit
const props = defineProps<{ editDto: PersonManagerInterface }>();
/** 入力用Dto */
const personManagerDto: WritableComputedRef<PersonManagerInterface> = computed(() => { return props.editDto; });

</script>
<template>
    <div class="left-area-in">
        ふりがな
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.firstNameKana" class="text-input" disabled="true" placeholder="姓ふりがな">
        <input type="text" v-model="personManagerDto.lastNameKana" class="left-space text-input" disabled="true" placeholder="名ふりがな">
    </div>
    <div class="clear-both"></div>

    <div class="left-area-in">
        姓名
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.firstName" class="text-input" disabled="true" placeholder="姓">
        <input type="text" v-model="personManagerDto.lastName" class="left-space text-input" disabled="true" placeholder="名">
    </div>
    <div class="clear-both"></div>

    <div class="left-area-in">
        電話番号
    </div>
    <div class="right-area">
        <input type="text"  v-model="personManagerDto.tel1" disabled="true" class="code-input">-
        <input type="text" v-model="personManagerDto.tel2" disabled="true" class="code-input">-
        <input type="text" v-model="personManagerDto.tel3" disabled="true" class="code-input">
    </div>

    <div class="left-area-in">
        郵便番号
    </div>
    <div class="right-area">
        <input type="text" v-model="personManagerDto.postalcode1" disabled="true" class="code-input">-
        <input type="text" v-model="personManagerDto.postalcode2" disabled="true" class="code-input">
    </div>

    <div class="left-area-in">
        住所
    </div>
    <div class="right-area">
        <textarea v-model="personManagerDto.addressPostal" disabled="true"></textarea><br>
        <textarea v-model="personManagerDto.addressBlock" disabled="true"></textarea><br>
        <textarea v-model="personManagerDto.addressBuilding" disabled="true"></textarea><br>
    </div>

    <div class="left-area-in">
        生年月日
    </div>
    <div class="right-area-in">
        <input type="date" v-model="personManagerDto.birtday" disabled="true" class="text-input">
    </div>
    <div class="clear-both"></div>

</template>
<style scoped>
textarea {
    font-size: 1.25em;
    width: 75%;
    font-weight: bold;
}
</style>
