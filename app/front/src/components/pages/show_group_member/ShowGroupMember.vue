<script setup lang="ts">
import { Ref, ref } from "vue";
import PersonWorkerInterface from '../../../dto/person_worker/personWorkerDto';
import PersonWorkerDto from '../../../dto/person_worker/personWorkerDto';
import PersonWorker from "../../common/person_worker/PersonWorker.vue";
import SearchPersonWorker from "../../common/search_person_worker/SearchPersonWorker.vue";

//編集Dto
const editDto: Ref<PersonWorkerInterface> = ref(new PersonWorkerDto());

/**
 * 作業者検索キャンセル
 */
function recieveCancelSearchPersonWorker() {
    //非表示
    //isVisibleSearchPersonWorker.value = false;
}

/**
 * 作業者検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPersonWorkerInterface(sendDto: PersonWorkerInterface, index: number) {
    if (index === 1) {
        editDto.value = sendDto;
    }
}

function onClose() {
    alert("閉じる");
}
</script>
<template>
    <h1>同じグループのメンバーを一覧する</h1>
    <SearchPersonWorker :is-editable="true" :call-index="1"
        @send-cancel-search-person-worker="recieveCancelSearchPersonWorker"
        @send-person-worker-interface="recieveSearchPersonWorkerInterface"></SearchPersonWorker>
    <div class="clear-both"></div>

    <h3>選択されたデータを照会する</h3>

    <div class="left-area">
        メールアドレス
    </div>
    <div class="right-area">
        <input type="email" v-model="editDto.mailAddress" disabled="true">
    </div>
    <div class="clear-both"></div>
    <PersonWorker :edit-dto="editDto" :is-editable="true" :is-in-parts="false"></PersonWorker>
    <div class="clear-both"></div>

    <div class="footer">
        <button @click="onClose" class="footer-button">閉じる</button>
    </div>

</template>
<style scoped>
table {
    border-style: solid;
    border-width: 1px;
}

td {
    border-style: solid;
    border-width: 1px;
}

th {
    border-style: solid;
    border-width: 1px;
}
</style>
