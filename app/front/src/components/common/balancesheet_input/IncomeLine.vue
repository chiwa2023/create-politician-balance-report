<script setup lang="ts">
//import BalancesheetIncomeInterface from '../../../dto/balancesheetIncomeDto';
import BalancesheetIncomeDto from '../../../dto/balancesheetIncomeDto';
import { ref, Ref, onBeforeMount, computed, WritableComputedRef, watch, reactive } from 'vue';

const props = defineProps<{ lineIndex: number, lineDto: BalancesheetIncomeDto }>();
const emit = defineEmits(['aaa'])

//const index = computed({
//    get: () => {return props.lineIndex},
//    set: (value) => emit('changeItem', value)
//    });


let backupAmount = 0;
let backupAccrualDate = "";

const incomeItem = computed(
    () => {
        backupAmount = props.lineDto.amount;
        backupAccrualDate = props.lineDto.accrualDate;
        return props.lineDto
    }
);

//watch(dto, (newValue) => {
//    alert("change"+dto.value.id + "---" + newValue.id);
//});


//const incomeItem = reactive(new BalancesheetIncomeDto());


/** 報告区分を監視 */
watch(() => incomeItem.value.reportKbn, (newValue) => {
    switch (newValue) {
        //報告対象
        case 1:
            //収支報告するのですべての入力フォームを開きます
            if (openInputIncomeForm()) {
                changeIncomeYoshikiKbnState(incomeItem.value.yoshikiEdaKbn);
            }
            break;
        //生活費
        case 20:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputIncomeForm();
            break;
        //政治活動
        case 11:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputIncomeForm();
            break;
    }
});

//収入収支報告しないので不要な入力フォームを閉じます
function closeInputIncomeForm() {
    //様式区分を非表示にします
    incomeItem.value.isUseYoshikiKbn = false;
    //様式区分枝項目を非表示にします
    incomeItem.value.isUseYoshikiEdaKbn = false;
    //あっせん期間部分を非表示にします
    incomeItem.value.isUseMediation = false;
    //団体名称を非表示にします
    incomeItem.value.isUseOrgName = false;
    //項目名を非表示にします
    incomeItem.value.isUseItemName = false;
    //団体住所を非表示にします
    incomeItem.value.isUseAddress = false;
    //備考を非表示にします
    incomeItem.value.isUseBiko = false;
    //寄付金控除を非表示にします
    incomeItem.value.isUseCreditTax = false;
    //パーティ名称は非表示にします
    incomeItem.value.isUsePartyName = false;
    //パーティ日付を非表示にします
    incomeItem.value.isUsePartyDate = false;
}

//収入収支報告するのでとりあえずすべての入力フォームをあけます
function openInputIncomeForm(): boolean {
    //様式区分を表示します;
    incomeItem.value.isUseYoshikiKbn = true;
    //様式区分枝項目を表示します
    incomeItem.value.isUseYoshikiEdaKbn = true;
    //あっせん期間を表示します
    incomeItem.value.isUseMediation = true;
    //組織名称を表示します
    incomeItem.value.isUseOrgName = true;
    //項目部分を表示します
    incomeItem.value.isUseItemName = true;
    //団体住所部分を表示します
    incomeItem.value.isUseAddress = true;
    //備考部分を表示ます
    incomeItem.value.isUseBiko = true;
    //寄付金控除を表示します
    incomeItem.value.isUseCreditTax = true;
    //パーティ名称を表示します
    incomeItem.value.isUsePartyName = true;
    //パーティ日付を表示ます
    incomeItem.value.isUsePartyDate = true;
    return true;
}


//様式区分を監視
watch(() => incomeItem.value.yoshikiKbn, (newValue) => {
    changeIncomeYoshikiKbnState(newValue);
})

/* 収入様式区分の値が変更になったら修正 */
function changeIncomeYoshikiKbnState(yoshikiKbn: string) {
    switch (yoshikiKbn) {
        case "3":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            incomeItem.value.isUseOrgName = false;
            //団体住所は不要です
            incomeItem.value.isUseAddress = false;
            //項目は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "事業の種類";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "4":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            incomeItem.value.isUseOrgName = false;
            //団体住所は不要です
            incomeItem.value.isUseAddress = false;
            //項目は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "借入した相手";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;
        case "5":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "本部または支部名称";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "本部または支部住所";
            //項目は不要です
            incomeItem.value.isUseItemName = false;
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "6":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            incomeItem.value.isUseOrgName = false;
            //団体住所は不要です
            incomeItem.value.isUseAddress = false;
            //項目は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "収入の摘要";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "7":
            //枝区分は必要です
            incomeItem.value.isUseYoshikiEdaKbn = true;
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "寄付者自身または団体の住所";
            //項目は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "寄付者の個人氏名または団体名称";
            //寄付金控除は不要です
            //incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            //様式区分が7の場合は特殊設定を明けに行く            
            changeStateEdaKbn(yoshikiKbn, incomeItem.value.yoshikiEdaKbn);
            break;
        case "8":
            //枝区分は必要です
            incomeItem.value.isUseYoshikiEdaKbn = true;
            //あっせん項目は期間の記載が必要となります
            incomeItem.value.isUseMediation = true;
            incomeItem.value.attentionMediation = "寄付をあっせんした期間";
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "寄付あっせん者自身または団体の住所";
            //概要は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "寄付あっせん者の個人氏名または団体名称";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "9":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            incomeItem.value.isUseOrgName = false;
            //団体住所は不要です
            incomeItem.value.isUseAddress = false;
            //項目は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "政党匿名寄付を受けた場所";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "10":
            //枝区分は不要です
            incomeItem.value.isUseYoshikiEdaKbn = false;
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "パーティ名称";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "パーティ開催場所住所";
            //概要は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "対価を支払った人数";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は不要です
            incomeItem.value.isUsePartyName = false;
            //パーティ日付は不要です
            incomeItem.value.isUsePartyDate = false;
            break;

        case "11":
            //枝区分は必要です
            incomeItem.value.isUseYoshikiEdaKbn = true;
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "個人または団体住所";
            //概要は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "費用を支払った氏名";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は必要です
            incomeItem.value.isUsePartyName = true;
            incomeItem.value.attentionPartyName = "開催したパーティ名称";
            //パーティ日付は必要です
            incomeItem.value.isUsePartyDate = true;
            incomeItem.value.attentionPartyDate = "パーティ開催日";
            break;

        case "12":
            //枝区分は必要です
            incomeItem.value.isUseYoshikiEdaKbn = true;
            //あっせん項目は期間の記載が必要となります
            incomeItem.value.isUseMediation = true;
            incomeItem.value.attentionMediation = "寄付をあっせんした期間";
            //団体名称は必要です
            incomeItem.value.isUseOrgName = true;
            incomeItem.value.attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            incomeItem.value.isUseAddress = true;
            incomeItem.value.attentionAddress = "個人または団体住所";
            //概要は必要です
            incomeItem.value.isUseItemName = true;
            incomeItem.value.attentionItemName = "費用を支払った氏名";
            //寄付金控除は不要です
            incomeItem.value.isUseCreditTax = false;
            //パーティ名称は必要です
            incomeItem.value.isUsePartyName = true;
            incomeItem.value.attentionPartyName = "開催したパーティ名称";
            //パーティ日付は必要です
            incomeItem.value.isUsePartyDate = true;
            incomeItem.value.attentionPartyDate = "パーティ開催日";
            break;
    }
};

/* 収入様式枝区分の値が変更になったら修正 */
function changeStateEdaKbn(yoshikiKbn: string, yoshikiEdaKbn: string) {
    //枝区分によって特殊な動きをするのは様式区分7の場合のみです
    if (yoshikiKbn === "7") {
        switch (yoshikiEdaKbn) {
            case "1":
                //個人寄付の時、遺贈チェックと寄付金控除チェックをオンにします
                incomeItem.value.isUseCreditTax = true;
                incomeItem.value.isUseBequest = true;
                incomeItem.value.isUsePrimeListedOrForeign = false;
                break;
            case "2":
                //法人寄付の時、上場・外資50%チェックをオンにします
                incomeItem.value.isUseCreditTax = false;
                incomeItem.value.isUseBequest = false;
                incomeItem.value.isUsePrimeListedOrForeign = true;
                break;
            case "3":
                //政治団体の場合は特殊なInputをすべて消します。
                incomeItem.value.isUseCreditTax = false;
                incomeItem.value.isUseBequest = false;
                incomeItem.value.isUsePrimeListedOrForeign = false;
                break;
        }
    }
    else {
        //それ以外の場合は特殊なInputをすべて消します。
        incomeItem.value.isUseCreditTax = false;
        incomeItem.value.isUseBequest = false;
        incomeItem.value.isUsePrimeListedOrForeign = false;
    }
}

//様式枝区分を監視
watch(() => incomeItem.value.yoshikiEdaKbn, (newValue) => {
    changeStateEdaKbn(incomeItem.value.yoshikiKbn, newValue);
})

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
})

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

//様式区分を監視
watch(() => incomeItem.value.isEditAutoInput, (newValue) => {
    if (!newValue) {
        emit("aaa");
        incomeItem.value.accrualDate = backupAccrualDate;
        incomeItem.value.amount = backupAmount;
    }
})

</script>
<template>
    <h1>行</h1>
    <div class="one-line" style="overflow: scroll;">

        <table style="overflow: scroll;white-space: nowrap;">
            <tr>
                <td><input type="text" v-model="incomeItem.referDigest" :disabled="true"></td>
                <td><input type="date" v-model="incomeItem.accrualDate" :disabled="!incomeItem.isEditAutoInput"></td>
                <td><input type="number" v-model="incomeItem.amount" :disabled="!incomeItem.isEditAutoInput"></td>
                <td><input type="radio" v-model="incomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
                        v-model="incomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio"
                        v-model="incomeItem.reportKbn" :value="11">報告対象外政治関連(廃止予定)</td>
                <td v-show="incomeItem.isUseYoshikiKbn">
                    <div v-show="incomeItem.isUseYoshikiKbn"><select v-model="incomeItem.yoshikiKbn">
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
                </td>
                <td v-show="incomeItem.isUseYoshikiEdaKbn">
                    <div v-show="incomeItem.isUseYoshikiEdaKbn"><select v-model="incomeItem.yoshikiEdaKbn">
                            <option value="1">1.個人</option>
                            <option value="2">2.法人その他の団体</option>
                            <option value="3">3.政治団体</option>
                        </select></div>
                </td>

                <td v-show="incomeItem.isUseItemName">
                    <div v-show="incomeItem.isUseItemName">{{ incomeItem.attentionItemName }}：<br><input type="text"
                            v-model="incomeItem.itemName">
                    </div>
                </td>
                <td v-show="incomeItem.isUseOrgName">
                    <div v-show="incomeItem.isUseOrgName">{{ incomeItem.attentionOrgName }}：<br><input type="text"
                            v-model="incomeItem.shimeiOrgnizationName"></div>
                </td>
                <td v-show="incomeItem.isUseAddress">
                    <div v-show="incomeItem.isUseAddress">{{ incomeItem.attentionAddress }}：<br><textarea
                            v-model="incomeItem.orgnizationAddress"></textarea>
                    </div>
                </td>
                <td v-show="incomeItem.isUseMediation">
                    <div v-show="incomeItem.isUseMediation">あっせんした期間：<br><input type="date"
                            v-model="incomeItem.mediationStartDate"><br>～<br><input type="date"
                            v-model="incomeItem.mediationEndDate"></div>
                </td>
                <td v-show="incomeItem.isUsePartyName">
                    <div v-show="incomeItem.isUsePartyName">パーティ名称：<br><input type="text"
                            v-model="incomeItem.partyName">
                    </div>
                </td>
                <td v-show="incomeItem.isUsePartyDate">
                    <div v-show="incomeItem.isUsePartyDate">パーティ開催日付：<br><input type="date"
                            v-model="incomeItem.partyDate">
                    </div>
                </td>
                <td v-show="incomeItem.isUseBiko">
                    <div v-show="incomeItem.isUseBiko"><input type="text" v-model="incomeItem.biko">
                        <div v-if="incomeItem.isUseBequest">
                            <input type="checkbox" v-model="incomeItem.isBequest">遺贈
                        </div>
                        <div v-if="incomeItem.isUsePrimeListedOrForeign">
                            <input type="checkbox" v-model="incomeItem.isPrimeListedOrForeign">上場・外資50%超
                        </div>
                    </div>
                </td>
                <td v-show="incomeItem.isUseCreditTax">
                    <div v-show="incomeItem.isUseCreditTax">寄付金控除：<br><input type="checkbox"
                            v-model="incomeItem.isCreditTax">寄付金(税額)控除</div>
                </td>
                <td><textarea v-model="incomeItem.note"></textarea></td>
                <td><input type="checkbox" v-model="incomeItem.isDifferPrecedent">前例と異なる処理</td>
                <td><input type="checkbox" v-model="incomeItem.isEditAutoInput">入力できない部分を<br>入力可能にする</td>
            </tr>
        </table>
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
