<script setup lang="ts">
import { Ref, ref, toRaw } from "vue";
import CheckPrivilegeDto from '../../../dto/common_check/checkPrivilegeDto';
import SessionStorageCommonCheck from '../../../dto/common_check/sessionStorageCommonCheck';
import TaskPlanSearchConditonCapsuleDto from "../../../dto/task_plan/taskPlanSearchConditonCapsuleDto";
import createCheckTransactionDto from "../../../dto/common_check/createCheckTransactionDto";
import TaskPlanResultDto from "../../../dto/task_plan/taskPlanResultDto";
import getPoliticalOrganizationList from "./mock/getPoliticalOrganizationList";
import PoliticalOrganizationSelectOptionDto from "../../../dto/task_plan/politicalOrganizationSelectOptionDto";
import TaskPlanSelectOptionDto from "../../../dto/task_plan/taskPlanSelectOptionDto";
import TaskPlanResultInterface from "../../../dto/task_plan/taskPlanResultDto";

// 政治団体Selectボタン
const politicalOrganizationList: Ref<PoliticalOrganizationSelectOptionDto[]> = ref(getPoliticalOrganizationList());
const selectedPoliticalOrganization: Ref<string> = ref("");

// タスクSelectボタン
const taskPlanListBackup: Ref<TaskPlanSelectOptionDto[]> = ref([]);
const taskPlanList: Ref<TaskPlanSelectOptionDto[]> = ref(taskPlanListBackup.value);
const selectedTaskPlan: Ref<string> = ref("");

// 検索条件
const conditonDto: Ref<TaskPlanSearchConditonCapsuleDto> = ref(new TaskPlanSearchConditonCapsuleDto())

conditonDto.value.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
conditonDto.value.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
conditonDto.value.checkTransactionDto = createCheckTransactionDto(true);
// テストデータに合わせて強制変更
conditonDto.value.checkPrivilegeDto.loginUserCode = 890;

// ログイン情報
const privilegeDto: CheckPrivilegeDto = conditonDto.value.checkPrivilegeDto;

// 未処理タスク取得を行う
const url = "http://localhost:8080/get-task-plan";
const method = "POST";
const body = JSON.stringify(conditonDto.value);
const headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
};

fetch(url, { method, headers, body })
    .then(async (response) => {
        const resultDto: Ref<TaskPlanResultInterface> = ref(new TaskPlanResultDto());
        resultDto.value = await response.json();
        politicalOrganizationList.value = resultDto.value.listPoliticalOrganizationSelect;
        taskPlanListBackup.value = resultDto.value.listTaskPlanSelect;
        taskPlanList.value = structuredClone(toRaw(taskPlanListBackup.value));
   })
    .catch((error) => {alert(error);});

function onMenu() {
    alert("Menu未実装");
}

/**
 * 政治団体選択変更時
 */
function onPoliticalOrganization() {
    taskPlanList.value = taskPlanListBackup.value.filter(
        (dto) => { return String(dto.politicalOrganizationCode) === selectedPoliticalOrganization.value });
        // 権限Dtoに現在編集中の政治団体を追加
}

/**
 * 予定変更時
 */
function onTaskPlan() {
    // TODO 選択されたタスクの遷移パスに遷移する、に書き直し
    alert("遷移" + selectedTaskPlan.value);
}

</script>
<template>
    <button @click="onMenu">Menu(未定)</button>

    <span class="left-space">{{ privilegeDto.loginUserName }} ({{ privilegeDto.loginUserCode }})</span>

    <span class="left-space">政治団体</span>
    <select v-model="selectedPoliticalOrganization" @change="onPoliticalOrganization">
        <option v-for="dto in politicalOrganizationList" :key="dto.value" :value="dto.value">{{ dto.text }}</option>
    </select>

    <span class="left-space">タスク</span>
    <select v-model="selectedTaskPlan" @change="onTaskPlan">
        <option v-for="dto in taskPlanList" :key="dto.value">{{ dto.text }}</option>
    </select>

    <hr>
</template>
<style scoped></style>