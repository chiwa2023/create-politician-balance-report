<script setup lang="ts">
import { Ref, ref } from "vue";
import PersonManager from '../../common/person_managaer/PersonManager.vue';
import PersonWorker from '../../common/person_worker/PersonWorker.vue';
import PersonManagerInterface from "../../../dto/person_manager/personManager";
import inputSelectDisplayBold from "../../../util/display/inputSelectDisplayBold";
import mockGetUserInfo from './mock/mockGetUserInfo';

//TODO セッションから取り出す
const loginUserId: number = 1007;

//責任者情報(作業者拡張)
const managerDto: Ref<PersonManagerInterface> = ref(mockGetUserInfo(loginUserId));

</script>
<template>
    <h1>ユーザ登録</h1>

    <div class="left-area">
        アカウント
    </div>
    <div class="right-area">
        <input type="email" v-model="managerDto.mailAddress">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        団体役割登録
    </div>
    <div class="right-area">
        <input type="radio" value="1" v-model="managerDto.userKbn"><span
            :class="inputSelectDisplayBold(managerDto.userKbn === 1)">責任者で登録(あとで作業者から責任者に変更時にも情報追加が不要になります)</span><br>
        <input type="radio" value="2" v-model="managerDto.userKbn"><span
            :class="inputSelectDisplayBold(managerDto.userKbn === 2)">作業者で登録</span><br>
    </div>
    <div class="clear-both"><br></div>

    <!-- 責任者入力 -->
    <PersonManager v-if="managerDto.userKbn == 1" :edit-dto="managerDto" :is-in-parts="false" :is-editable="true"></PersonManager>

    <!-- 作業員入力 -->
    <PersonWorker v-if="managerDto.userKbn == 2" :edit-dto="managerDto"  :is-in-parts="false" :is-editable="true"></PersonWorker>
    <div class="clear-both"></div>

    <h3>SNSアカウント</h3>
    <!-- TODO SNSアカウント -->

</template>
<style scoped></style>
