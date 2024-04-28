<script setup lang="ts">
import { ref, Ref } from "vue";
import SearchVariousFinancialPay from "./common/search_various_financial_pay/SearchVariousFinancialPay.vue";
import VariousFinancialPayInterface from "../dto/financial/vairousFinancialPayDto";

const financialOrgCode: Ref<number> = ref(0);
const financialOrgName: Ref<string> = ref("");

const isVisibleSearchVariousFinancialPay: Ref<boolean> = ref(false);
/**
 * 各種Pay検索コンポーネントを表示する
 */
function showSearchVariousFinancialPay() {
    isVisibleSearchVariousFinancialPay.value = true;
}
/**
 * 各種Pay検索コンポーネントを非表示にする
 */
function recieveCancelSearchVariousFinancialPay() {
    isVisibleSearchVariousFinancialPay.value = false;
}

/**
 * 各種Pay検索コンポーネントから選択されたデータを受け取り非表示にする
 * @param slectedDto 選択された各種PayDto
 */
function recieveVariousFinancialPayInterface(slectedDto:VariousFinancialPayInterface) {
    //受信内容を複写
    financialOrgCode.value = slectedDto.variousFinancialPayCode;
    financialOrgName.value = slectedDto.variousFinancialPayName;
   
    //コンポーネント非表示
    isVisibleSearchVariousFinancialPay.value = false;
}
</script>
<template>
    <h1>コンポーネントをページと関係なく作成するための台紙</h1>
    <hr>
    <div class="left-area">
                金融機関(各種Pay／全銀)
            </div>
            <div class="right-area">
                <input type="number" v-model="financialOrgCode" disabled="false" style="margin-right: 2%;">
                <input type="text" v-model="financialOrgName" disabled="false" style="margin-right: 2%;">
                <button style="margin-right: 2%;" @click="showSearchVariousFinancialPay">各種Pay検索</button>
                <!--
                <button style="margin-right: 2%;" @click="showSearchZenginFinancialOrg">全銀金融機関検索</button>
                -->
            </div>

            <hr>

    <!-- 各種Pay機関検索コンポーネント -->
    <div v-if="isVisibleSearchVariousFinancialPay">
        <SearchVariousFinancialPay :isEditable="false"  @sendCancelSearchVariousFinancialPay="recieveCancelSearchVariousFinancialPay"  @sendVariousFinancialPayInterface="recieveVariousFinancialPayInterface"></SearchVariousFinancialPay>
    </div>

</template>
<style scoped></style>
