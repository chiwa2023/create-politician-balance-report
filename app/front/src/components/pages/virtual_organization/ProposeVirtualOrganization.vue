<script setup lang="ts">
import { Ref, ref } from "vue";
import UserAccountDto from "../../../dto/user_account/userAccountDto";
import { Router, useRouter } from "vue-router";

const routerDestination: Router = useRouter();//遷移先への移動用

//編集用Dto(仮)
const userAccountDto: Ref<UserAccountDto> = ref(new UserAccountDto());

/* キャンセル */
function onCancel() {
    alert("キャンセル");
}

/* 保存 */
function onSave() {
    alert("申請");
    // TODO 以下の作業を行う
    // 申請があったことを登録する
    // 対象ユーザにアクセスURLを掲載したメールを送信する
    // 対象ユーザに電話番号に認証コード送信する

    //トップメニューへ戻る
    routerDestination.push("/");
}

</script>
<template>
    <h1>他のユーザを同じグループに招待</h1>

    <div style="text-align: center">
        <div
            style="width: 50%;margin-left: auto;margin-right: auto;border-width: 2px;border-style: solid;margin-top: 5%;">
            <br>
            同じグループにするメンバーのメールアドレスを入力する<br>
            <br>
            <!-- 入力(コピペ)がかったるいなどの理由で、グループ未登録ユーザを検索機能をつけると
             意図しないメールアドレスが見えてしまい情報漏洩となる、むしろ本人の同意を確認するための「秘密の質問」機能があってもよい -->
            <div style="width: 99%;margin-left: auto;margin-right: auto;">
                <div class="left-area-center">
                    メールアドレス
                </div>
                <div class="right-area-center">
                    <input type="email" v-model="userAccountDto.loginUserMailAddress">
                </div>
                <div class="clear-both"><br></div>
            </div>
            <button @click="onSave">申請</button><br>
            <br>
        </div>
    </div>
    <br>
    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
    </div>

</template>
<style scoped>
div.left-area-center {
    float: left;
    width: 34%;
    text-align: right;
    padding-right: 1%;
}

div.right-area-center {
    float: left;
    text-align: left;
    width: 65%;
}
</style>
