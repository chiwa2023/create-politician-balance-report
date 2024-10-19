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

//await axios.post(url, conditonDto.value)
//    .then((response) => {
//        const resultDto: Ref<TaskPlanResultDto> = ref(new TaskPlanResultDto());
//        resultDto.value = response.data;
//
//        // TODO リストコピー(pushしなくてもよいなら直す)
//        politicalOrganizationList.value = [];
//        for (const dto of resultDto.value.listPoliticalOrganizationSelect) {
//            politicalOrganizationList.value.push(dto);
//        }
//        taskPlanListBackup.value = [];
//        for (const dto of resultDto.value.listTaskPlanSelect) {
//            taskPlanListBackup.value.push(dto);
//        }
//        taskPlanList.value = structuredClone(toRaw(taskPlanListBackup.value));
//
//    })
//    .catch((error) => showErrorMessage(error.response.status));

const method = "POST";
const body = JSON.stringify(conditonDto.value);
const headers = {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
};

fetch(url, { method, headers, body })
    .then(async (response) => {
        const resultDto: Ref<TaskPlanResultDto> = ref(new TaskPlanResultDto());
        resultDto.value = toRaw(await response.json());
        // TODO リストコピー(配列pushしなくてもよいなら直す)
        politicalOrganizationList.value = [];
        for (const dto of resultDto.value.listPoliticalOrganizationSelect) {
            politicalOrganizationList.value.push(dto);
        }
        taskPlanListBackup.value = [];
        for (const dto of resultDto.value.listTaskPlanSelect) {
            taskPlanListBackup.value.push(dto);
        }
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