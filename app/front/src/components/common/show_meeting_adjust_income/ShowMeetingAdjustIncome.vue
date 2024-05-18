<script setup lang="ts">
import { Ref, onBeforeMount, ref, watch } from "vue";
import AuditOpinionIncomeDto from "../../../dto/audit_opinion/auditOpinionIncomeDto";
import ReportKbnConstants from "../../../dto/balancesheet/reportKbnConstants";

//props,emits
const props = defineProps<{ incomeCode: number }>();
const emit = defineEmits(["sendAuditOpinionIncomeInterface"]);

onBeforeMount(() => {

    //初期値でなければリスト生成
    if (props.incomeCode !== 0) {
        listAudit.value.splice(0);
        listAudit.value.push(createAuditDto(true, 1357));
        listAudit.value.push(createAuditDto(false, 246));
    }

});

/** 意見付記リスト  */
const listAudit: Ref<AuditOpinionIncomeDto[]> = ref([]);

watch(() => props.incomeCode, () => {
    //初期値でなければリスト生成
    if (props.incomeCode !== 0) {
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
    const selectedDto: AuditOpinionIncomeDto = listAudit.value.filter((dto) => dto.auditOpinionId == selectedData.value)[0];
    emit("sendAuditOpinionIncomeInterface", selectedDto);
});

/**
 * 意見付記を作成する
 * @param isInvest 調査側フラグ
 * @param id id
 * @returns 意見付記Dto
 */
function createAuditDto(isInvest: boolean, id: number): AuditOpinionIncomeDto {

    const dto: AuditOpinionIncomeDto = new AuditOpinionIncomeDto();

    dto.updateTime = new Date();
    dto.loginUserName = "政治家　三郎";
    dto.loginUserRole = "代表者";
    dto.isDifferPrecedent = true;
    dto.isCreatedItemByInvest = isInvest;
    dto.auditAgreeItemText = "独自意見を表明";
    dto.note = "意見付記サンプル";
    dto.auditOpinionId = id;

    dto.reportKbn = ReportKbnConstants.PLAN_TASK;
    dto.youshikiKbn = 7;
    dto.youshikiEdaKbn = 1;

    return dto;
}

</script>
<template>
    <h3>意見付記履歴</h3>
    <div v-for="auditOpinionIncomeDto in listAudit" :key="auditOpinionIncomeDto.auditOpinionId">
        <div style="margin-bottom: 2%;">
            <!-- 作成側表示領域 -->
            <div v-if="!auditOpinionIncomeDto.isCreatedItemByInvest"
                style="float:left;border-width: 1px;border-style: solid;width:60%;padding:1%">
                <input type="radio" v-model="selectedData" :value="auditOpinionIncomeDto.auditOpinionId" />データ表示 <span
                    style="margin-right:2%;">( {{
                        getTimestampText(auditOpinionIncomeDto.updateTime) }})入力</span><br>
                {{ auditOpinionIncomeDto.loginUserName }}({{ auditOpinionIncomeDto.loginUserRole }})<br>
                <input type="checkbox" v-model="auditOpinionIncomeDto.isDifferPrecedent" disabled="true" />前例と異なる処理<br>
                <textarea v-model="auditOpinionIncomeDto.note" disabled="true" style="width:90%"></textarea>
            </div>

            <!-- 調査側表示領域 -->
            <div v-if="auditOpinionIncomeDto.isCreatedItemByInvest"
                style="float:right;border-width: 1px;border-style: solid;width:60%;padding:1%">
                <input type="radio" v-model="selectedData" :value="auditOpinionIncomeDto.auditOpinionId" />データ表示 <span
                    style="margin-right:2%;">( {{
                        getTimestampText(auditOpinionIncomeDto.updateTime) }})入力</span><br>
                {{ auditOpinionIncomeDto.loginUserName }}({{ auditOpinionIncomeDto.loginUserRole }})<br>
                {{ auditOpinionIncomeDto.auditAgreeItemText }}<br>
                <input type="checkbox" v-model="auditOpinionIncomeDto.isDifferPrecedent" disabled="true" />前例と異なる処理<br>
                <textarea v-model="auditOpinionIncomeDto.note" disabled="true" style="width:90%"></textarea>
            </div>
            <div style="clear: both;"></div>
        </div>
    </div>

</template>
<style scoped></style>
