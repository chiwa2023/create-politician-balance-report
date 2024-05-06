<script setup lang="ts">
import changeIncomeYoushikiKbnState from "../../../dto/balancesheet/changeIncomeYoushikiKbnState";
import changeStateIncomeEdaKbn from "../../../dto/balancesheet/changeStateIncomeEdaKbn";
import BalancesheetIncomeDto from "../../../dto/balancesheetIncomeDto";
import { computed, watch, Ref, ref, WritableComputedRef } from "vue";
import viewPrepareIncome from "../../../dto/balancesheet/viewPrepareIncome";
import CallingItemEntity from "../../../entity/callingItemEntity";
import ShowCallingItem from "../show_calling_item/ShowCallingItem.vue";

const props = defineProps<{ lineIndex: number, lineDto: BalancesheetIncomeDto,listItem:CallingItemEntity[] }>();
const emit = defineEmits(["restoreIncomeReadData"]);

//行Index
const lineIndex = computed(
    () => {
        return props.lineIndex;
    }
);

//行データ
const incomeItem = computed(
    () => {
        return props.lineDto;
    }
);

//候補マップ
const listCallingItem: WritableComputedRef<CallingItemEntity[]> = computed(
    () => props.listItem,
);

/** 報告区分を監視 */
watch(() => incomeItem.value.reportKbn, () => {
    viewPrepareIncome(incomeItem.value);
});

//様式区分を監視
watch(() => incomeItem.value.youshikiKbn, () => {
    changeIncomeYoushikiKbnState(incomeItem.value);
});

//様式枝区分を監視
watch(() => incomeItem.value.youshikiEdaKbn, () => {
    changeStateIncomeEdaKbn(incomeItem.value);
});

//様式区分7,様式枝区分1で遺贈の値が変更された場合、備考に「遺贈」を追加または削除
const bequestText: string = "「遺贈」";
watch(() => incomeItem.value.isBequest, (newValue) => {
    if (newValue) {
        if (incomeItem.value.biko.indexOf(bequestText) == -1) {
            incomeItem.value.biko = incomeItem.value.biko + bequestText;
        }
    }
    else {
        const content = incomeItem.value.biko.replace(bequestText, "");
        incomeItem.value.biko = content;
    }
});

//様式区分7,様式枝区分2で上場・外資50%超の値が変更された場合、備考に「上場・外資50%超」を追加または削除
const primeListedOrForeignText: string = "「上場・外資50%超」";
watch(() => incomeItem.value.isPrimeListedOrForeign, (newValue) => {
    if (newValue) {
        if (incomeItem.value.biko.indexOf(primeListedOrForeignText) == -1) {
            incomeItem.value.biko = incomeItem.value.biko + primeListedOrForeignText;
        }
    }
    else {
        const content = incomeItem.value.biko.replace(primeListedOrForeignText, "");
        incomeItem.value.biko = content;
    }
});

//入力不可能を監視
watch(() => incomeItem.value.isEditAutoInput, (newValue) => {
    if (!newValue) {
        emit("restoreIncomeReadData", lineIndex.value);
    }
});

const isVisibleShowCallingItem: Ref<boolean> = ref(false);
/**
 * 他の呼び出し候補表示コンポーネントを表示する
 */
function showCallinItem() {
    isVisibleShowCallingItem.value = true;
}
/**
 * 他の呼び出し候補表示コンポーネントを非表示にする
 */
function recieveCancelShowCallingItem() {
    isVisibleShowCallingItem.value = false;
}
/**
 * 他の呼び出し候補を選択する
 * @param selectedDto 選択項目
 */
function recieveCallingItemEntity(selectedDto: CallingItemEntity) {
    alert("選択" + selectedDto.youshikiKbn);
    //TODO 選択データを更新するのは追加修正とする
    isVisibleShowCallingItem.value = false;
}
</script>
<template>
    <td><input type="text" v-model="incomeItem.referDigest" :disabled="true"></td>
    <td><input type="date" v-model="incomeItem.accrualDate" :disabled="!incomeItem.isEditAutoInput"></td>
    <td><input type="number" v-model="incomeItem.amount" :disabled="!incomeItem.isEditAutoInput"></td>
    <td><input type="radio" v-model="incomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
            v-model="incomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio" v-model="incomeItem.reportKbn"
            :value="11">報告対象外政治関連(廃止予定)<br><input type="radio" v-model="incomeItem.reportKbn" :value="50">タスク計上(後で確定)
    </td>
    <td>
        <div v-show="incomeItem.isUseYoushikiKbn"><select v-model="incomeItem.youshikiKbn">
                <option value="3">3.機関誌発行その他事業収入</option>
                <option value="4">4.借入金</option>
                <option value="5">5.本部／支部から交付金収入</option>
                <option value="6">6.その他の収入</option>
                <option value="7">7.寄付の内訳</option>
                <option value="8">8.寄付の内訳(あっせん)</option>
                <option value="9">9.政党匿名寄付</option>
                <option value="10" :disabled="false">10.特定パーティの対価に係る収入</option>
                <option value="11">11.政治資金パーティー収入</option>
                <option value="12">12.政治資金パーティ収入(あっせん)</option>
            </select></div>
        <br><button @click="showCallinItem">他の紐づけ候補</button>
    </td>
    <td>
        <div v-show="incomeItem.isUseYoushikiEdaKbn"><select v-model="incomeItem.youshikiEdaKbn">
                <option value="1">1.個人</option>
                <option value="2">2.法人その他の団体</option>
                <option value="3">3.政治団体</option>
            </select></div>
    </td>
    <td>
        <div v-show="incomeItem.isUseItemName">{{ incomeItem.attentionItemName }}：<br><input type="text"
                v-model="incomeItem.itemName">
        </div>
    </td>
    <td>
        <div v-show="incomeItem.isUseOrgName">{{ incomeItem.attentionOrgName }}：<br><input type="text"
                v-model="incomeItem.professionOrgnizationName"></div>
    </td>
    <td>
        <div v-show="incomeItem.isUseAddress">{{ incomeItem.attentionAddress }}：<br><textarea
                v-model="incomeItem.orgnizationAddress"></textarea>
        </div>
    </td>
    <td>
        <div v-show="incomeItem.isUseMediation">あっせんした期間：<br><input type="date"
                v-model="incomeItem.mediationStartDate"><br>～<br><input type="date"
                v-model="incomeItem.mediationEndDate"></div>
    </td>
    <td>
        <div v-show="incomeItem.isUsePartyName">パーティ名称：<br><input type="text" v-model="incomeItem.partyName">
        </div>
    </td>
    <td>
        <div v-show="incomeItem.isUsePartyDate">パーティ開催日付：<br><input type="date" v-model="incomeItem.partyDate">
        </div>
    </td>
    <td>
        <div v-show="incomeItem.isUseBiko"><input type="text" v-model="incomeItem.biko">
            <div v-if="incomeItem.isUseBequest">
                <input type="checkbox" v-model="incomeItem.isBequest">遺贈
            </div>
            <div v-if="incomeItem.isUsePrimeListedOrForeign">
                <input type="checkbox" v-model="incomeItem.isPrimeListedOrForeign">上場・外資50%超
            </div>
        </div>
    </td>
    <td>
        <div v-show="incomeItem.isUseCreditTax">寄付金控除：<br><input type="checkbox"
                v-model="incomeItem.isCreditTax">寄付金(税額)控除</div>
    </td>
    <td><textarea v-model="incomeItem.note"></textarea></td>
    <td><input type="checkbox" v-model="incomeItem.isDifferPrecedent">前例と異なる処理</td>
    <td><input type="checkbox" v-model="incomeItem.isEditAutoInput">入力できない部分を<br>入力可能にする</td>
    <!-- ベースを操作禁止するレイヤ -->
    <div v-if="isVisibleShowCallingItem" class="overBackground"></div>
    <!--上にかぶせるコンポーネント -->
    <div v-if="isVisibleShowCallingItem" class="overComponent">
        <ShowCallingItem :digest="incomeItem.referDigest" :listItem="listCallingItem"
            @sendCancelShowCallingItem="recieveCancelShowCallingItem" @sendCallingItemEntity="recieveCallingItemEntity">
        </ShowCallingItem>
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
