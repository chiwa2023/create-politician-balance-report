<script setup lang="ts">
import { Ref, ref } from "vue";
import SearchElectionCommission from "../../common/search_election_commission/SearchElectionCommission.vue";
import ElectionCommissionLeastInterface from "../../../dto/election_commission/electionCommissionDto";
import UploadFile from "../../common/upload_file/UploadFile.vue";
import SaveStorageResultDto from "../../../dto/storage/saveStorageResultDto";
import NotRegistOrganizaionDto from "../../../dto/start_manage_political_organization/notRegistOrganizaionDto";

//編集用Dto
const editDto: Ref<NotRegistOrganizaionDto> = ref(new NotRegistOrganizaionDto());

//選挙管理委員会表示フラグ
const isVisibleSearchElectionCommision: Ref<boolean> = ref(false);

/**
 * 選挙管理委員会検索コンポーネント表示
 */
function onSearchElectionCommition() {
    isVisibleSearchElectionCommision.value = true;
}

/**
 * 選挙管理委員会検索キャンセル
 */
function recieveCancelSearchElectionCommissionLeast() {
    //非表示
    isVisibleSearchElectionCommision.value = false;
}

/**
 * 選挙管理委員会検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchElectionCommissionLeastInterface(sendDto: ElectionCommissionLeastInterface) {

    editDto.value.electionCommissionLeastDto = sendDto;

    //非表示
    isVisibleSearchElectionCommision.value = false;
}

/** ファイル受信 */
function recieveFileDataInterfacel(saveStorageResultDto: SaveStorageResultDto) {
    alert("受信" + saveStorageResultDto.shoshouId);

    editDto.value.saveStorageResultDto = saveStorageResultDto;
}

/** キャンセル */
function onCancel() {
    alert("キャンセル");
}

/** キャンセル */
function onSave() {
    alert("保存");
    //TODO 以下の処理を行う
    //入力データの保存
    //調査側のタスク登録
}
</script>

<template>
    <h1>未登録既存団体の登録依頼</h1>

    <div class="left-area">
        提出選挙管理委員会
    </div>
    <div class="right-area">
        <input type="number" v-model="editDto.electionCommissionLeastDto.electionCommissionCode" disabled="true"
            class="code-input">
        <input type="text" v-model="editDto.electionCommissionLeastDto.electionCommissionName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchElectionCommition">選挙管理委員会検索</button>
    </div>
    <div class="clear-both"><br></div>


    <div class="left-area">
        政治団体名
    </div>
    <div class="right-area">
        <input type="text" v-model="editDto.politicalOrganizationName" class="name-input">
    </div>
    <div class="clear-both"><br></div>

    <div class="one-line">
        選挙管理委員会でこの政治団体の政治資金収支報告書が開示されていないときは、あわせて内容のわかる電子データを提出してください
    </div>
    <UploadFile @send-file-data-interface="recieveFileDataInterfacel"></UploadFile>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

    <!-- 選挙管理委員会検索コンポーネント -->
    <div v-if="isVisibleSearchElectionCommision" class="overBackground"></div>
    <div v-if="isVisibleSearchElectionCommision">
        <div class="overComponent">
            <SearchElectionCommission :isEditable="false"
                @send-cancel-search-election-commission-least="recieveCancelSearchElectionCommissionLeast"
                @send-election-commission-least-interface="recieveSearchElectionCommissionLeastInterface">
            </SearchElectionCommission>
        </div>
    </div>


</template>
<style scoped></style>
