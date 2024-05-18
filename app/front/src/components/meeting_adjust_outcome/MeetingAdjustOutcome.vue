<script setup lang="ts">
import { Ref, ref } from "vue";
import AuditOpinionOutcomeDto from "../../dto/audit_opinion/auditOpinionOutcomeDto";
import ShowMeetingAdjustOutcome from "../common/show_meeting_adjust_outcome/ShowMeetingAdjustOutcome.vue";
import EditOutcome from "../common/edit_outcome/EditOutcome.vue";

//支出項目
const outcomeCode: Ref<number> = ref(227);
const outcomeItemName: Ref<string> = ref("寄付 政治団体三郎");

//最終編集候補
const editBalancesheetOutcome: Ref<AuditOpinionOutcomeDto> = ref(new AuditOpinionOutcomeDto());

/**
 * 選択された意見付記データを編集対象に設定する
 * @param data 参照するデータ
 */
function recieveAuditOpinionOutcomeInterface(data: AuditOpinionOutcomeDto) {
    editBalancesheetOutcome.value = data;
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
    <h1>収支報告書支出意見付記全体照会</h1>
    <div class="left-area">収支項目の指定</div>
    <div class="right-area"><input type="number" v-model="outcomeCode"> <input type="text" v-model="outcomeItemName"
            class="leftMargin" disabled="true"><button class="leftMargin" disabled="true">収入項目を検索</button></div>
    <!-- ※TODO 収支報告書支出項目検索コンポーネントが完成した時点で入力を非活性にする-->

    <!-- 意見付記全体参照-->
    <div class="one-line" style="width:96%">
        <ShowMeetingAdjustOutcome :outcomeCode="outcomeCode" @sendAuditOpinionOutcomeInterface="recieveAuditOpinionOutcomeInterface"></ShowMeetingAdjustOutcome>
    </div>

    <!-- 収入項目編集入力 -->
    <div class="one-line">
        <EditOutcome :outcomeDto="editBalancesheetOutcome"></EditOutcome>
    </div>

    <div class="footer">
        <button @click="onCancel">キャンセル</button>
        <button @click="onSave">保存</button>
    </div>

</template>
<style scoped></style>
