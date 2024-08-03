<script setup lang="ts">
import { ref, Ref, onBeforeMount } from "vue";
import CheckSendBalancesheetInterface from "../../../dto/checkSendBalancesheetDto";
import CheckSendBalancesheetDto from "../../../dto/checkSendBalancesheetDto";
import mockGetCheckSendBalancesheetDto from "./mock/mockGetCheckSendBalancesheetDto";

const checkSendDto: Ref<CheckSendBalancesheetInterface> = ref(new CheckSendBalancesheetDto());

/** 初期設定 */
onBeforeMount(async () => {
    //収支報告書を送信する時の基礎情報を取得する
    checkSendDto.value = mockGetCheckSendBalancesheetDto();
});


/**  
 * 入力内容を破棄する
 */
function onCancel() {
    alert("キャンセル");
}

/**  
 * 入力内容を保存する
 */
function onExecute() {
    const errorList = checkInputError();    
    if(errorList.length ===0 ){
        alert("送信");
    }
    else{
        let allMessage = "";
        for(const mess of  errorList){
            allMessage = allMessage +mess + "\n";
        }
        alert(allMessage);
    }
}

/**
 * 送信前チェック
 * @returns 該当エラメッセージリスト
 */
function checkInputError():string[] {
    let message:string[] = [];
    if(!checkSendDto.value.isConfirmYear){
        message.push("報告年が同一であることのチェックが入っていません");
    }
    if(!checkSendDto.value.isConfirmRepresentName){
        message.push("代表者が同一であることのチェックが入っていません");
    }
    if(!checkSendDto.value.isConfirmAccountOfiicerName){
        message.push("会計責任者が同一であることのチェックが入っていません");
    }
    if(!checkSendDto.value.isConfirmOfficeAddress){
        message.push("主たる事務所の住所が同一であることのチェックが入っていません");
    }
    if(!checkSendDto.value.isConfirmOrganizationKbn){
        message.push("政治団体区分が同一であることのチェックが入っていません");
    }
    if(!checkSendDto.value.isConfirmHasOtherOrg){
        message.push("政治資金管理団体の有無が同一であることのチェックが入っていません");
    }
    if(checkSendDto.value.userNameSubmissionOrg === ""){
        message.push("ユーザ名が空白です");
    }
    if(checkSendDto.value.userPasswordSubmissionOrg === ""){
        message.push("ユーザパスワードが空白です");
    }

    return message;
}

/**
 * 生成した収支報告書XMLを自分のデバイスに保存(ダウンロード)
 */
function saveMyDevice() {
    const url: string = checkSendDto.value.publishXmlPath;
    const cell: string[] = url.split("/");
    let anchorElement = document.createElement("a");
    anchorElement.href = url;
    anchorElement.download = cell[cell.length - 1];
    document.body.appendChild(anchorElement);
    anchorElement.click();
}

/**
 * 送信データプレビューする
 */
function previewPublish() {
    alert("送信するデータのプレビュー");
}
</script>
<template>
    <h2>発行済収支報告書を提出する</h2>
    <div class="one-line">
        提出用XMLが生成されています。<input type="datetime-local" v-model="checkSendDto.publishTimestampText" disabled="true"><button @click="saveMyDevice">自分のデバイスに保存</button>
    </div>
    <br>
    <div class="one-line">
        提出前に下記の情報が正しいか確認をしてください。<button @click="previewPublish">情報確認</button>
    </div>
    <br>
    <div class="one-line">
        <input type="checkbox" v-model="checkSendDto.isConfirmYear" />報告年<br>
        <input type="checkbox" v-model="checkSendDto.isConfirmRepresentName" />代表者名<br>
        <input type="checkbox" v-model="checkSendDto.isConfirmAccountOfiicerName" />会計責任者<br>
        <input type="checkbox" v-model="checkSendDto.isConfirmOfficeAddress" />主たる事務所の住所<br>
        <input type="checkbox" v-model="checkSendDto.isConfirmOrganizationKbn" />政治団体区分<br>
        <input type="checkbox" v-model="checkSendDto.isConfirmHasOtherOrg" />政治資金管理団体の有無<br>
    </div>
    <br>
    <div class="one-line">
        政治資金収支報告書オンライン提出(総務省)に使うユーザ名とパスワードを入力してください<br>
        ※ユーザ名とパスワードはこの収支報告書作成サイトでは保存されません。(自動入力できる場合はブラウザのパスワード保存機能が動作している)
    </div>
    <br>
    <div class="left-area">ユーザ名</div>
    <div class="right-area"><input type="text" v-model="checkSendDto.userNameSubmissionOrg" /></div>
    <div class="left-area">パスワード</div>
    <div class="right-area"><input type="password" v-model="checkSendDto.userPasswordSubmissionOrg" /><br></div>
    <br>
    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onExecute" class="footer-button">保存</button>
    </div>
</template>
<style scoped></style>
