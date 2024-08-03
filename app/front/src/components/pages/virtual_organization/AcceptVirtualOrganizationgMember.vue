<script setup lang="ts">
import { Ref, ref } from "vue";

import { RouteLocationNormalizedLoaded, Router, useRoute, useRouter } from "vue-router";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import CheckSecurityDto from "../../../dto/common_check/checkSecurityDto";
import PersonWorker from "../../common/person_worker/PersonWorker.vue";
import AcceptOrganizationDto from "../../../dto/virtual_organization/acceptOrganizationDto";
import mockGetAcceptOrganization from "./mock/mockGetAcceptOrganization";

//router    
const routerDestination: Router = useRouter();//遷移先への移動用
const routeSource: RouteLocationNormalizedLoaded = useRoute();//遷移元からの情報取得用

// 直接アクセスしかされないので、ログインされているかをチェックする
// ログインされていない場合はログインページへ
const securityDto: CheckSecurityDto = SessionStorageCommonCheck.getSecurity();
if (0 === securityDto.loginUserId) {
    // loginUserIdが0=初期値の場合はログインしていないのでログインページに遷移する
    routerDestination.push("/login_user" + "?directPath=" + routeSource.fullPath);
}

//呼び出し用コードを取得
const oneTimeRecognizeNo: Ref<string> = ref("");
if (routeSource.query.oneTimeRecognizeNo !== undefined && routeSource.query.oneTimeRecognizeNo !== null) {
    oneTimeRecognizeNo.value = routeSource.query.oneTimeRecognizeNo.toString();
}

//編集用Dto
const acceptDto: Ref<AcceptOrganizationDto> = ref(mockGetAcceptOrganization(oneTimeRecognizeNo.value));

//キャンセル
function onCancel() {
    alert("キャンセル");
}

//保存
function onSave() {
    alert("保存");
    // TODO 必要な処理
    // 入力されたコードの照合
    // 仮想政治団体テーブルにメンバーを追加する
}

</script>
<template>
    <h1>同じ団体所属申請を承諾する</h1>
    <div class="left-area">
        招待されたメールアドレス
    </div>
    <div class="right-area">
        <input type="email" v-model="acceptDto.personAccept.mailAddress" disabled="true">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        送付されたコード
    </div>
    <div class="right-area">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar1" class="one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar2" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar3" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar4" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar5" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar6" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar7" class="left-space-narrow one-char-input">
        <input type="text" v-model="acceptDto.recognizeTelephonCodeDto.codeChar8" class="left-space-narrow one-char-input">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        申請されたユーザ
    </div>
    <div class="right-area">
        <PersonWorker :edit-dto="acceptDto.personPropose" :is-editable="false" :is-in-parts="true"></PersonWorker>
    </div>
    <div class="clear-both"><br></div>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

</template>
<style scoped></style>
