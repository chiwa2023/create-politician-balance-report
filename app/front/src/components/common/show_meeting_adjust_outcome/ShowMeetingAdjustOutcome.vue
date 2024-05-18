<script setup lang="ts">
import { Ref, onBeforeMount, ref, watch } from "vue";
import AuditOpinionOutcomeDto from "../../../dto/audit_opinion/auditOpinionOutcomeDto";
import ReportKbnConstants from "../../../dto/balancesheet/reportKbnConstants";

//props,emits
const props = defineProps<{ outcomeCode: number }>();
const emit = defineEmits(["sendAuditOpinionOutcomeInterface"]);

/** 意見付記リスト  */
const listAudit: Ref<AuditOpinionOutcomeDto[]> = ref([]);

onBeforeMount(() => {

    //初期値でなければリスト生成
    if (props.outcomeCode !== 0) {
        listAudit.value.splice(0);
        listAudit.value.push(createAuditDto(true, 1357));
        listAudit.value.push(createAuditDto(false, 246));
    }

});

/**
 * 日付を標準書式に変換する
 * @param date 日付
 * @returns フォーマット書式日付
 */
function getTimestampText(date: Date): string {
    return date.toLocaleString("ja-JP");
}

/**ラジオボタン選択を監視 */
const selectedData: Ref<number> = ref(0);
watch(() => selectedData.value, () => {
    //PrimaryIdをKeyにしているので、1件だけに絞られることが保証されている
    const selectedDto: AuditOpinionOutcomeDto = listAudit.value.filter((dto) => dto.auditOpinionId == selectedData.value)[0];
    emit("sendAuditOpinionOutcomeInterface", selectedDto);
});

/**
 * 意見付記を作成する
 * @param isInvest 調査側フラグ
 * @param id id
 * @returns 意見付記Dto
 */
function createAuditDto(isInvest: boolean, id: number): AuditOpinionOutcomeDto {

    const dto: AuditOpinionOutcomeDto = new AuditOpinionOutcomeDto();

    dto.updateTime = new Date();
    dto.loginUserName = "政治家　三郎";
    dto.loginUserRole = "代表者";
    dto.isDifferPrecedent = true;
    dto.isCreatedItemByInvest = isInvest;
    dto.auditAgreeItemText = "独自意見を表明";
    dto.note = "意見付記サンプル";
    dto.auditOpinionId = id;
    dto.reportKbn = ReportKbnConstants.PUBLISH_REPORT;
    dto.youshikiKbn = 14;
    dto.youshikiEdaKbn = 2;

    return dto;
}

</script>
<template>
    <h3>意見付記履歴</h3>
    <div v-for="auditOpinionOutcomeDto in listAudit" :key="auditOpinionOutcomeDto.auditOpinionId">
        <div style="margin-bottom: 2%;">
            <!-- 作成側表示領域 -->
            <div v-if="!auditOpinionOutcomeDto.isCreatedItemByInvest"
                style="float:left;border-width: 1px;border-style: solid;width:60%;padding:1%">
                <input type="radio" v-model="selectedData" :value="auditOpinionOutcomeDto.auditOpinionId" />データ表示 <span
                    style="margin-right:2%;">( {{
                        getTimestampText(auditOpinionOutcomeDto.updateTime) }})入力</span><br>
                {{ auditOpinionOutcomeDto.loginUserName }}({{ auditOpinionOutcomeDto.loginUserRole }})<br>
                <input type="checkbox" v-model="auditOpinionOutcomeDto.isDifferPrecedent" disabled="true" />前例と異なる処理<br>
                <textarea v-model="auditOpinionOutcomeDto.note" disabled="true" style="width:90%"></textarea>
            </div>

            <!-- 調査側表示領域 -->
            <div v-if="auditOpinionOutcomeDto.isCreatedItemByInvest"
                style="float:right;border-width: 1px;border-style: solid;width:60%;padding:1%">
                <input type="radio" v-model="selectedData" :value="auditOpinionOutcomeDto.auditOpinionId" />データ表示 <span
                    style="margin-right:2%;">( {{
                        getTimestampText(auditOpinionOutcomeDto.updateTime) }})入力</span><br>
                {{ auditOpinionOutcomeDto.loginUserName }}({{ auditOpinionOutcomeDto.loginUserRole }})<br>
                {{ auditOpinionOutcomeDto.auditAgreeItemText }}<br>
                <input type="checkbox" v-model="auditOpinionOutcomeDto.isDifferPrecedent" disabled="true" />前例と異なる処理<br>
                <textarea v-model="auditOpinionOutcomeDto.note" disabled="true" style="width:90%"></textarea>
            </div>
            <div style="clear: both;"></div>
        </div>
    </div>
</template>
<style scoped></style>
