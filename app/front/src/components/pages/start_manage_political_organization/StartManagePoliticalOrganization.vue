<script setup lang="ts">
import { Ref, ref } from "vue";

import PoliticalOrganizationInterface from '../../../dto/political_organization/politicalOrganizationDto';
import SearchPoliticalOrganizationCapsuleDto from "../../../dto/political_organization/searchPoliticalOrganizationCapsuleDto";
import { StartManagePoliticalOrganizationDto } from "../../../dto/start_manage_political_organization/startManagePoliticalOrganizationDto";
import SearchPoliticalOrganization from "../../common/search_political_organization/SearchPoliticalOrganization.vue";
import SearchPersonManager from "../../common/search_person_manager/SearchPersonManager.vue";
import PersonManagerInterface from "../../../dto/person_manager/personManager";
import PersonManager from "../../common/person_managaer/PersonManager.vue";

//編集Dto
const editDto: Ref<StartManagePoliticalOrganizationDto> = ref(new StartManagePoliticalOrganizationDto());

//政治団体表示フラグ
const isVisibleSearchPoliticalOrganization: Ref<boolean> = ref(false);
const searchPoliticalOrganizationCapsuleDto: SearchPoliticalOrganizationCapsuleDto = new SearchPoliticalOrganizationCapsuleDto();

/**
 * 政治団体検索コンポーネント表示
 */
function onSearchPoliticalOrganization() {
    isVisibleSearchPoliticalOrganization.value = true;
}

/**
 * 政治団体検索キャンセル
 */
function recieveCancelSearchPoliticalOrganization() {
    //非表示
    isVisibleSearchPoliticalOrganization.value = false;
}

/**
 * 政治団体検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPoliticalOrganizationInterface(sendDto: PoliticalOrganizationInterface) {

    editDto.value.politicalOrganizationId = sendDto.politicalOrganizationId;
    editDto.value.politicalOrganizationCode = sendDto.politicalOrganizationCode;
    editDto.value.politicalOrganizationName = sendDto.politicalOrganizationName;

    //非表示
    isVisibleSearchPoliticalOrganization.value = false;
}

//責任者入力表示フラグ
const isVisibleSearchPersonManager: Ref<boolean> = ref(false);
const callManagerIndex: Ref<number> = ref(0);

/**
 * 責任者検索コンポーネント表示
 */
function onSearchPersonManager(callIndex: number) {
    callManagerIndex.value = callIndex;
    isVisibleSearchPersonManager.value = true;
}

/**
 * 責任者検索キャンセル
 */
function recieveCancelSearchPersonManager() {
    //非表示
    isVisibleSearchPersonManager.value = false;
}

/**
 * 責任者検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPersonManagerInterface(sendDto: PersonManagerInterface, index: number) {

    switch (index) {
        case 1:
            editDto.value.personManagerDelegate = sendDto;
            break;
        case 2:
            editDto.value.personManagerAccountManager = sendDto;
            break;
        case 3:
            editDto.value.personManagerAccountManagerSupport = sendDto;
            break;
    }

    //非表示
    isVisibleSearchPersonManager.value = false;
}


/** キャンセル  */
function onCancel() {
    alert("キャンセル");
}

/** 保存  */
function onSave() {
    alert("保存");

    //TODO 保存時には以下の処理を行う
    // 責任者(代表者・会計責任者・会計職務代行者)の名前が最新の届け出と一致している確認する
    // 責任者(代表者・会計責任者・会計職務代行者)の電話番号が最新の届け出と一致している確認する
    // 責任者(代表者・会計責任者・会計職務代行者)の電話番号に２要素認証のためのキーを送付する
}

</script>
<template>
    <h1>既存政治団体をこのソフトウェアでの管理を開始する</h1>

    まだ選挙管理委員会に設立の申請をしていない場合は<RouterLink to="/add_politician_orgnization">政治団体設立届</RouterLink>を提出してください<br>

    <!-- 政治団体 -->
    <h3>管理する政治団体を選択する</h3>
    <div class="left-area">
        政治団体
    </div>
    <div class="right-area">
        <input type="number" v-model="editDto.politicalOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicalOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticalOrganization">政治団体検索</button><br>
    </div>
    <div class="clear-both"><br></div>

    まだすでに選挙管理員会に１回以上収支報告書を提出してるが、政治団体を探せない場合は<RouterLink to="/propose_not_regist_organization">既存団体登録</RouterLink>
    を依頼してください<br>

    <h3>政治団体の届出をした責任者を指定する</h3>
    <!-- 所属者登録 -->
    <div class="left-area">
        代表者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" disabled="true" class="code-input">
        <input type="text" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(1)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerDelegate" :is-editable="false" :is-in-parts="true">
        </PersonManager>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        会計責任者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" disabled="true" class="code-input">
        <input type="text" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(2)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerAccountManager" :is-editable="false" :is-in-parts="true">
        </PersonManager>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        会計責任者の職務代行者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" disabled="true" class="code-input">
        <input type="text" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(3)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerAccountManagerSupport" :is-editable="false" :is-in-parts="true">
        </PersonManager>
    </div>
    <div class="clear-both"><br></div>

    <div class="footer">
        <button @click="onCancel">キャンセル</button>
        <button @click="onSave">保存</button>
    </div>

    <!-- 責任者検索コンポーネント -->
    <div v-if="isVisibleSearchPersonManager" class="overBackground"></div>
    <div v-if="isVisibleSearchPersonManager">
        <div class="overComponent">
            <SearchPersonManager :isEditable="false" :call-index="callManagerIndex"
                @send-cancel-search-person-manager="recieveCancelSearchPersonManager"
                @send-person-manager-interface="recieveSearchPersonManagerInterface">
            </SearchPersonManager>
        </div>
    </div>

    <!-- 政治団体検索コンポーネント -->
    <div v-if="isVisibleSearchPoliticalOrganization" class="overBackground"></div>
    <div v-if="isVisibleSearchPoliticalOrganization">
        <div class="overComponent">
            <SearchPoliticalOrganization :is-editable="false" :search-dto="searchPoliticalOrganizationCapsuleDto"
                @send-cancel-search-political-organization="recieveCancelSearchPoliticalOrganization"
                @send-political-organization-interface="recieveSearchPoliticalOrganizationInterface">
            </SearchPoliticalOrganization>
        </div>
    </div>

</template>
<style scoped></style>
