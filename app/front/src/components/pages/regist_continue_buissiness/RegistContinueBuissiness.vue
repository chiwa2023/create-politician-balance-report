<script setup lang="ts">
import { computed, ref, Ref } from "vue";
import ContinueBuissinessInterface from "../../../dto/continue_buissiness_dto/continueBuissinessDto";
import SelectOptionInterface from "../../../dto/selectOptionDto";
import { DepositType } from "../../../dto/zengin/depositType";
import createAccountDepositTypeList from "../../../dto/zengin/createAccountDepositTypeList";
import mockGetContinueBuissinessDto from "./mock/mockGetContinueBuissinessDto";
import FinancialAccountInput from "../../common/financial_account_input/FinancialAccountInput.vue";

// 金融機関口座種別リスト(普通・当座・仮でその他を選択できる)
const listTypeView: string[] = [];
listTypeView.push(DepositType.REGULAR);
listTypeView.push(DepositType.CURRENT);
listTypeView.push(DepositType.OTHER);
const listTypeAccount: SelectOptionInterface[] = createAccountDepositTypeList(listTypeView);

// 継続事業Dto
const continueBuissinessDto: Ref<ContinueBuissinessInterface> = ref(mockGetContinueBuissinessDto());

const buissinessAllName = computed(
    () => {return continueBuissinessDto.value.buissinessName +"【" + continueBuissinessDto.value.houkokuNen + "】"} 
);


/** キャンセル */
function onCancel() {
    alert("キャンセル");
}

/** キャンセル */
function onSave() {
    alert("保存" + continueBuissinessDto.value.financialOrgAccaount.accountNumber);
}
</script>
<template>
    <h1>(継続)事業登録</h1>

    <div class="one-line">
        収支報告書作成時に表示される情報
    </div>
    <div class="left-area">
        事業コード
    </div>
    <div class="right-area">
        <input type="text" class="code-input" disabled="true">
        <input type="text" v-model="continueBuissinessDto.houkokuNen" class="left-space code-input" disabled="true">
    </div>
    <div class="clear-both"></div>
    <div class="left-area">
        事業名称
    </div>
    <div class="right-area">
        <input type="text" v-model="buissinessAllName" class="name-input" disabled="true"><br>
        継続提出年が自動的に付加されます
    </div>
    <div class="clear-both"></div>
    <div class="one-line">
        入力内容
    </div>
    <div class="left-area">
        事業名称
    </div>
    <div class="right-area">
        <input type="text" v-model="continueBuissinessDto.buissinessName" class="name-input">
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        摘要
    </div>
    <div class="right-area">
        <textarea v-model="continueBuissinessDto.digest"></textarea>
    </div>
    <div class="clear-both"></div>

    <!-- 金融機関口座入力 -->
    <FinancialAccountInput :account-dto="continueBuissinessDto.financialOrgAccaount" :list-type="listTypeAccount"></FinancialAccountInput>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

</template>
<style scoped></style>
