<script setup lang="ts">
import { Ref, ref } from "vue";
import AuditOpinionIncomeDto from "../../dto/audit_opinion/auditOpinionIncomeDto";
import ShowMeetingAdjustIncome from "../common/show_meeting_adjust_income/ShowMeetingAdjustIncome.vue";
import EditIncome from "../common/edit_income/EditIncome.vue";

//収支項目
const incomeCode: Ref<number> = ref(227);
const incomeItemName: Ref<string> = ref("寄付 政治団体三郎");

//最終編集候補
const editBalancesheetIncome: Ref<AuditOpinionIncomeDto> = ref(new AuditOpinionIncomeDto());
editBalancesheetIncome.value.isUseYoushikiKbn = true;
editBalancesheetIncome.value.isUseYoushikiEdaKbn = true;
editBalancesheetIncome.value.isUseMediation = true;
editBalancesheetIncome.value.isUseItemName = true;
editBalancesheetIncome.value.isUseAddress = true;
editBalancesheetIncome.value.isUseOrgName = true;
editBalancesheetIncome.value.isUseBiko = true;
editBalancesheetIncome.value.isUseBequest = true;
editBalancesheetIncome.value.isUsePrimeListedOrForeign = true;
editBalancesheetIncome.value.isUsePartyName = true;
editBalancesheetIncome.value.isUsePartyDate = true;
editBalancesheetIncome.value.isUseCreditTax = true;


editBalancesheetIncome.value.attentionItemName = "項目名称";
editBalancesheetIncome.value.attentionAddress = "住所入力";
editBalancesheetIncome.value.attentionOrgName = "代表者氏名";

/**
 * 選択された意見付記データを編集対象に設定する
 * @param data 参照するデータ
 */
function recieveAuditOpinionIncomeInterface(data: AuditOpinionIncomeDto) {
    editBalancesheetIncome.value = data;
}

/** キャンセル */
function onCancel() {
    alert("キャンセル");
}
/** 保存 */
function onSave() {
    alert("保存");
}
</script>
<template>
    <h1>収支報告書収入意見付記全体照会</h1>
    <div class="left-area">収支項目の指定</div>
    <div class="right-area"><input type="number" v-model="incomeCode"> <input type="text" v-model="incomeItemName"
            class="leftMargin" disabled="true"><button class="leftMargin" disabled="true">収入項目を検索</button></div>
    <!-- ※TODO 収支報告書収入項目検索コンポーネントが完成した時点で入力を非活性にする-->

    <!-- 意見付記全体参照-->
    <div class="one-line" style="width:96%">
        <ShowMeetingAdjustIncome :incomeCode="incomeCode" @sendAuditOpinionIncomeInterface="recieveAuditOpinionIncomeInterface"></ShowMeetingAdjustIncome>
    </div>

    <!-- 収入項目編集入力 -->
    <div class="one-line">
        <EditIncome :incomeDto="editBalancesheetIncome"></EditIncome>
    </div>

    <div class="footer">
        <button @click="onCancel">キャンセル</button>
        <button @click="onSave">保存</button>
    </div>

</template>
<style scoped></style>
