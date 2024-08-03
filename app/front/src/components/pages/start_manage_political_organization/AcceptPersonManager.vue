<script setup lang="ts">
import { Ref, ref } from "vue";
import { RouteLocationNormalizedLoaded, Router, useRoute, useRouter } from "vue-router";
import { StartManagePoliticalOrganizationDto } from "../../../dto/start_manage_political_organization/startManagePoliticalOrganizationDto";
import PersonManager from "../../common/person_managaer/PersonManager.vue";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import CheckSecurityDto from "../../../dto/common_check/checkSecurityDto";
import mockGetStartMagaePoliticalOrganization from "./mock/mockGetStartMagaePoliticalOrganization";
import inputSelectDisplayBold from "../../../util/display/inputSelectDisplayBold";

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

//このページで扱う情報のDto
const editDto: Ref<StartManagePoliticalOrganizationDto> = ref(mockGetStartMagaePoliticalOrganization(oneTimeRecognizeNo.value));

/** キャンセル  */
function onCancel() {
    alert("キャンセル");
}

/** 保存  */
function onSave() {
    alert("保存");
    //TODO 以下の処理を行う
    //入力されたコードが送信したコードと一致していること
    //承認されたことを記録すること
    //3名の責任者がすべて承認された場合、『私的グループメンバー』を政治団体構成員に変更すること
}
</script>
<template>
    <h1>既存政治団体をこのソフトウェアでの管理を開始する(2)</h1>
    <!-- 政治団体 -->
    <div class="left-area">
        選択された政治団体
    </div>
    <div class="right-area">
        <input type="number" v-model="editDto.politicalOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicalOrganizationName" disabled="true" class="left-space name-input">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        {{ editDto.roleOrganizationKbnText }}
    </div>
    <div class="right-area">
        <PersonManager :edit-dto="editDto.personManagerDto" :is-editable="false" :is-in-parts="true"></PersonManager>
    </div>
    <div class="clear-both"><br></div>

    <h3>送付されたコードを入力する</h3>

    <div class="left-area">
        送付されたコード
    </div>
    <div class="right-area">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar1" class="one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar2" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar3" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar4" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar5" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar6" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar7" class="left-space-narrow one-char-input">
        <input type="text" v-model="editDto.recognizeTelephonCodeDto.codeChar8" class="left-space-narrow one-char-input">
    </div>
    <div class="clear-both"><br></div>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

    <h3>現段階での確認状況</h3>

    <div class="left-area">
        承認状況
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="editDto.isAcceptDelegate" disabled="true"><span :class="inputSelectDisplayBold(editDto.isAcceptDelegate)">代表者の承認が終了しています</span><br>
        <input type="checkbox" v-model="editDto.isAcceptAccountManager" disabled="true"><span :class="inputSelectDisplayBold(editDto.isAcceptAccountManager)">会計責任者の承認が終了しています</span><br>
        <input type="checkbox" v-model="editDto.isAcceptAccountManagerSupport"
            disabled="true"><span :class="inputSelectDisplayBold(editDto.isAcceptAccountManagerSupport)">会計責任者の職務代行者の承認が終了しています</span><br>
    </div>
    <div class="clear-both"></div>

</template>
<style scoped>
</style>
