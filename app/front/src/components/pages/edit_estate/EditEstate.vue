<script setup lang="ts">
import { Ref, ref } from "vue";
import SearchBalancesheetEstate from '../../common/search_balancesheet_estate/SearchBalancesheetEstate.vue';
import SsearchBalancesheetEstateCapsuleDto from "../../../dto/balancesheet_estate/searchBalancesheetEstateCapsuleDto";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import createCheckTransactionDto from "../../../dto/common_check/createCheckTransactionDto";
import BalancesheetEstateInterface from "../../../dto/balancesheet_estate/balancesheetEstateDto";
import BalancesheetEstateDto from "../../../dto/balancesheet_estate/balancesheetEstateDto";
import InputRealesate from "../../common/input_realestate/InputRealesate.vue";

//編集用Dto
const editDto: Ref<BalancesheetEstateInterface> = ref(new BalancesheetEstateDto());

//収支報告書資産検索表示フラグ
//const isVisibleSearchBalancesheetEstate: Ref<boolean> = ref(false);
const searchBalancesheetEstateCapsuleDto: Ref<SsearchBalancesheetEstateCapsuleDto> = ref(new SsearchBalancesheetEstateCapsuleDto());
searchBalancesheetEstateCapsuleDto.value.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
searchBalancesheetEstateCapsuleDto.value.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
searchBalancesheetEstateCapsuleDto.value.checkTransactionDto = createCheckTransactionDto(false);//追加を許容

///**
//*収支報告書資産検索コンポーネント表示
//*/
//function onSearchBalancesheetEstate() {
//    isVisibleSearchBalancesheetEstate.value = true;
//}

/**
 * 収支報告書資産検索キャンセル
 */
function recieveCancelSearchBalancesheetEstate() {
    //    //非表示
    //    isVisibleSearchBalancesheetEstate.value = false;
}

/**
 * 収支報告書資産検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchBalancesheetEstateInterface(sendDto: BalancesheetEstateInterface) {

    editDto.value = sendDto;

    //非表示
    //isVisibleSearchBalancesheetEstate.value = false;
}

function onCancel(){
    alert("キャンセル");
}

function onSave(){
    alert("保存");
}

</script>
<template>
    <h1>収支報告書資産入力</h1>

    <!-- 収支報告書資産検索埋め込み-->
    <SearchBalancesheetEstate :search-dto="searchBalancesheetEstateCapsuleDto"
        @send-cancel-search-balancesheet-estate="recieveCancelSearchBalancesheetEstate"
        @send-balancesheet-estate-interface="recieveSearchBalancesheetEstateInterface">
    </SearchBalancesheetEstate>

    <br />&nbsp;
    
    <h3>選択したデータを編集</h3>
    <div class="left-area">様式枝区分項目</div>
    <div class="right-area">
        <select v-model="editDto.yoshikiEdaKbn">
            <option value="ア">ア：土地</option>
            <option value="イ">イ:建物</option>
            <option value="ウ">ウ:地上権または借地権 </option>
            <option value="エ">エ:取得価額が100万円を超える動産</option>
            <option value="オ">オ:普通または当座でない預金(貯金)</option>
            <option value="カ">カ:金銭信託</option>
            <option value="キ">キ:有価証券</option>
            <option value="ク">ク:出資による権利</option>
            <option value="ケ">ケ:相手先ごとに残高100万円を超える貸付</option>
            <option value="コ">コ:100万円を超える敷金</option>
            <option value="サ">サ:100万円を超える施設利用の権利 </option>
            <option value="シ">シ:相手先ごとに100万円を超える借入金</option>
        </select>
    </div>
    <div class="both-clear"></div>

    <div class="left-area">摘要</div>
    <div class="right-area"><input type="text" v-model="editDto.itemName" /></div>
    <div class="both-clear"></div>

    <div class="left-area">金額</div>
    <div class="right-area"><input type="text" v-model="editDto.amount" /></div>
    <div class="both-clear"></div>

    <div class="left-area">年月日</div>
    <div class="right-area"><input type="date" v-model="editDto.accrualDate" /></div>
    <div class="both-clear"></div>

    <div class="left-area">備考</div>
    <div class="right-area"><input type="text" v-model="editDto.biko" /></div>
    <div class="both-clear"></div>

    <div class="left-area">前年確認</div>
    <div class="right-area"><input type="checkbox" v-model="editDto.isSameData" />前年とまったく同一野データであることを確認しました</div>
    <div class="both-clear"></div>

    <!-- 収支報告書資産不動産 -->
    <InputRealesate :real-estate-list="editDto.listRealEstate"></InputRealesate>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

</template>
<style scoped></style>
