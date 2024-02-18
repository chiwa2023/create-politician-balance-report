<script setup lang="ts">
import { ref, Ref, watch, onBeforeMount } from 'vue';
import BalancesheetIncomeDto from '../../dto/balancesheetIncomeDto';
import BalancesheetOutcomeDto from '../../dto/balancesheetOutcomeDto';
import mockIncomeDeepCopy from '../read_fin_institution_csv/mock/mockIncomeDeepCopy';
import mockOutcomeDeepCopy from '../read_fin_institution_csv/mock/mockOutcomeDeepCopy';
import getOrdinaryExpensesEdaKbn from '../../dto/balancesheet/getOrdinaryExpensesEdaKbn';
import getPoliticalExpensesEdaKbn from '../../dto/balancesheet/getPoliticalExpensesEdaKbn';

//props
const props = defineProps<{ listIncome: BalancesheetIncomeDto[], listOutcome: BalancesheetOutcomeDto[] }>();

//収支報告書収入リスト
const listBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const backupBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);
const editBalancesheetIncome: Ref<BalancesheetIncomeDto[]> = ref([]);

//収支報告書支出リスト
const listBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);
const backupBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);
const editBalancesheetOutcome: Ref<BalancesheetOutcomeDto[]> = ref([]);

//この方式でないとpropsデータの表示設定ができない
onBeforeMount(() => {
    listBalancesheetIncome.value = props.listIncome;
    listBalancesheetOutcome.value = props.listOutcome;

    //バックアップと編集比較用データ保存
    const maxLineOutcome = listBalancesheetOutcome.value.length;
    editBalancesheetOutcome.value.splice(0);
    backupBalancesheetOutcome.value.splice(0);
    for (let index = 0; index < maxLineOutcome; index++) {
        backupBalancesheetOutcome.value.push(mockOutcomeDeepCopy(listBalancesheetOutcome.value[index]));
        editBalancesheetOutcome.value.push(mockOutcomeDeepCopy(listBalancesheetOutcome.value[index]));
    }

    //props直後の表示変更
    //for (let index = 0; index < maxLineIncome; index++) {
    //    judgeIncomeReportKbn(index, listBalancesheetIncome.value[index].reportKbn);
    //    changeIncomeYoshikiKbnState(index, listBalancesheetIncome.value[index].yoshikiKbn);
    //}
    //for (let index = 0; index < maxLineOutcome; index++) {
    //    judgeOutcomeReportKbn(index, listBalancesheetOutcome.value[index].reportKbn);
    //    changeOutcomeYoshikiKbnState(index, listBalancesheetOutcome.value[index].yoshikiKbn);
    //}
});


/* 収入の変更を検知する */
watch(listBalancesheetIncome, () => {
    alert("変更検知収入");
    const maxLine = listBalancesheetIncome.value.length;
    if(maxLine !== backupBalancesheetIncome.value.length){
        createBakupAndEditDataIncome();
    }

    let dtoOld;
    let dtoNew;
    for (let index = 0; index < maxLine; index++) {
        dtoNew = listBalancesheetIncome.value[index];
        dtoOld = editBalancesheetIncome.value[index];

        //編集不可部分を編集したがっていたが、やっぱり編集しないことにする場合、バックアップデータで値を戻す
        if (dtoOld.isEditAutoInput && !dtoNew.isEditAutoInput) {
            listBalancesheetIncome.value[index].accrualDate = backupBalancesheetIncome.value[index].accrualDate;
            listBalancesheetIncome.value[index].amount = backupBalancesheetIncome.value[index].amount;
        }

        //仕訳大項目を変更した場合枝分類と表示項目が変化する
        if (dtoOld.yoshikiKbn !== dtoNew.yoshikiKbn) {
            changeIncomeYoshikiKbnState(index, dtoNew.yoshikiKbn);
        }
        //様式仕分け小項目
        if (dtoOld.yoshikiEdaKbn !== dtoNew.yoshikiEdaKbn) {
            //様式その7
            if (dtoNew.yoshikiEdaKbn === "1" && dtoNew.yoshikiKbn === "7") {
                //税額控除を入力をオープンにします
                listBalancesheetIncome.value[index].isUseCreditTax = true;
                listBalancesheetIncome.value[index].attentionCreditTax = "寄付金控除";
            }
            else {
                //税額控除を入力をクローズします
                listBalancesheetIncome.value[index].isUseCreditTax = false;
            }
        }
        //収支報告区分を変更すると表示項目が変化する
        if (dtoOld.reportKbn !== dtoNew.reportKbn) {
            judgeIncomeReportKbn(index, dtoNew.reportKbn);
        }
    }

    //次の編集に備えて現値を保持
    editBalancesheetIncome.value.splice(0);
    for (let index = 0; index < maxLine; index++) {
        editBalancesheetIncome.value.push(mockIncomeDeepCopy(listBalancesheetIncome.value[index]));
    }

},
    { deep: true }
);


/* 支出の変更を検知する */
watch(listBalancesheetOutcome, () => {
    alert("変更検知支出");
    const maxLine = listBalancesheetOutcome.value.length;

    let dtoOld;
    let dtoNew;
    for (let index = 0; index < maxLine; index++) {
        dtoNew = listBalancesheetOutcome.value[index];
        dtoOld = editBalancesheetOutcome.value[index];

        //編集不可部分を編集したがっていたが、やっぱり編集しないことにする場合、バックアップデータで値を戻す
//        if (dtoOld.isEditAutoInput && !dtoNew.isEditAutoInput) {
//            listBalancesheetOutcome.value[index].accrualDate = backupBalancesheetOutcome.value[index].accrualDate;
//            listBalancesheetOutcome.value[index].amount = backupBalancesheetOutcome.value[index].amount;
//        }

//        //仕訳大項目を変更した場合枝分類と表示項目が変化する
//        if (dtoOld.yoshikiKbn !== dtoNew.yoshikiKbn) {
//            changeOutcomeYoshikiKbnState(index, dtoNew.yoshikiKbn);
//        }

        //収支報告区分を変更すると表示項目が変化する
        //if (dtoOld.reportKbn !== dtoNew.reportKbn) {
            //judgeOutcomeReportKbn(index, dtoNew.reportKbn);
        //}

    }
    //次の編集に備えて現値を保持
    editBalancesheetOutcome.value.splice(0);
    for (let index = 0; index < maxLine; index++) {
        editBalancesheetOutcome.value.push(mockOutcomeDeepCopy(listBalancesheetOutcome.value[index]));
    }
},
    { deep: true }
);

function createBakupAndEditDataIncome(){
    const maxLineIncome = listBalancesheetIncome.value.length;
    editBalancesheetIncome.value.splice(0);
    backupBalancesheetIncome.value.splice(0);
    for (let index = 0; index < maxLineIncome; index++) {
        backupBalancesheetIncome.value.push(mockIncomeDeepCopy(listBalancesheetIncome.value[index]));
        editBalancesheetIncome.value.push(mockIncomeDeepCopy(listBalancesheetIncome.value[index]));
    }
}




/* 収入データの報告区分の挙動を設定する */
function judgeIncomeReportKbn(index: number, reportKbn: number) {
    switch (reportKbn) {
        //報告対象
        case 1:
            //収支報告するのですべての入力フォームを開きます
            if (openInputIncomeForm(index)) {
                //過去データが残っていない可能性があるのでその他チェックの実施が必要
            }
            break;
        //生活費
        case 20:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputIncomeForm(index);
            break;
        //政治活動
        case 11:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputIncomeForm(index);
            break;
    }
}

/* 支出データの報告区分の挙動を設定する */
function judgeOutcomeReportKbn(index: number, reportKbn: number) {

    switch (reportKbn) {
        //報告対象
        case 1:
            //収支報告するのですべての入力フォームを開きます
            if (openInputOutcomeForm(index)) {
                //過去データが残っていない可能性があるのでその他チェックの実施が必要
            }
            break;
        //生活費
        case 20:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputOutcomeForm(index);
            break;
        //政治活動
        case 11:
            //収支報告しないのですべての入力フォームを閉じます
            closeInputOutcomeForm(index);
            break;
    }
}

/* 収入様式区分の値が変更になったら修正 */
function changeIncomeYoshikiKbnState(index: number, yoshikiKbn: string) {
    listBalancesheetIncome.value[index].isUseMediation = false;
    switch (yoshikiKbn) {
        case "3":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            listBalancesheetIncome.value[index].isUseOrgName = false;
            //団体住所は不要です
            listBalancesheetIncome.value[index].isUseAddress = false;
            //項目は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "事業の種類";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "4":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            listBalancesheetIncome.value[index].isUseOrgName = false;
            //団体住所は不要です
            listBalancesheetIncome.value[index].isUseAddress = false;
            //項目は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "借入した相手";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;
        case "5":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "本部または支部名称";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "本部または支部住所";
            //項目は不要です
            listBalancesheetIncome.value[index].isUseItemName = false;
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "6":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            listBalancesheetIncome.value[index].isUseOrgName = false;
            //団体住所は不要です
            listBalancesheetIncome.value[index].isUseAddress = false;
            //項目は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "収入の摘要";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "7":
            //枝区分は必要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = true;
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "寄付者自身または団体の住所";
            //項目は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "寄付者の個人氏名または団体名称";
            //寄付金控除は不要です
            //listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "8":
            //枝区分は必要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = true;
            //あっせん項目は期間の記載が必要となります
            listBalancesheetIncome.value[index].isUseMediation = true;
            listBalancesheetIncome.value[index].attentionMediation = "寄付をあっせんした期間";
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "寄付あっせん者自身または団体の住所";
            //概要は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "寄付あっせん者の個人氏名または団体名称";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "9":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は不要です
            listBalancesheetIncome.value[index].isUseOrgName = false;
            //団体住所は不要です
            listBalancesheetIncome.value[index].isUseAddress = false;
            //項目は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "政党匿名寄付を受けた場所";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "10":
            //枝区分は不要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "パーティ名称";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "パーティ開催場所住所";
            //概要は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "対価を支払った人数";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は不要です
            listBalancesheetIncome.value[index].isUsePartyName = false;
            //パーティ日付は不要です
            listBalancesheetIncome.value[index].isUsePartyDate = false;
            break;

        case "11":
            //枝区分は必要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = true;
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "個人または団体住所";
            //概要は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "費用を支払った氏名";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は必要です
            listBalancesheetIncome.value[index].isUsePartyName = true;
            listBalancesheetIncome.value[index].attentionPartyName = "開催したパーティ名称";
            //パーティ日付は必要です
            listBalancesheetIncome.value[index].isUsePartyDate = true;
            listBalancesheetIncome.value[index].attentionPartyDate = "パーティ開催日";
            break;

        case "12":
            //枝区分は必要です
            listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = true;
            //あっせん項目は期間の記載が必要となります
            listBalancesheetIncome.value[index].isUseMediation = true;
            listBalancesheetIncome.value[index].attentionMediation = "寄付をあっせんした期間";
            //団体名称は必要です
            listBalancesheetIncome.value[index].isUseOrgName = true;
            listBalancesheetIncome.value[index].attentionOrgName = "団体の場合は代表者名、個人の場合は職業";
            //団体住所は必要です
            listBalancesheetIncome.value[index].isUseAddress = true;
            listBalancesheetIncome.value[index].attentionAddress = "個人または団体住所";
            //概要は必要です
            listBalancesheetIncome.value[index].isUseItemName = true;
            listBalancesheetIncome.value[index].attentionItemName = "費用を支払った氏名";
            //寄付金控除は不要です
            listBalancesheetIncome.value[index].isUseCreditTax = false;
            //パーティ名称は必要です
            listBalancesheetIncome.value[index].isUsePartyName = true;
            listBalancesheetIncome.value[index].attentionPartyName = "開催したパーティ名称";
            //パーティ日付は必要です
            listBalancesheetIncome.value[index].isUsePartyDate = true;
            listBalancesheetIncome.value[index].attentionPartyDate = "パーティ開催日";
            break;
    }
};

/* 支出様式区分変更時の処理 */
function changeOutcomeYoshikiKbnState(index: number, yoshikiKbn: string) {

    switch (yoshikiKbn) {
        case "14":
            listBalancesheetOutcome.value[index].isUseYoshikiEdaKbn = true;
            listBalancesheetOutcome.value[index].yoshikiEdaKbnOptions = getOrdinaryExpensesEdaKbn();
            break;

        case "15":
            listBalancesheetOutcome.value[index].isUseYoshikiEdaKbn = true;
            listBalancesheetOutcome.value[index].yoshikiEdaKbnOptions = getPoliticalExpensesEdaKbn();
            break;

        case "16":
            listBalancesheetOutcome.value[index].isUseYoshikiEdaKbn = false;
            break;
    }
}

//収入収支報告しないので不要な入力フォームを閉じます
function closeInputIncomeForm(index: number) {
    //様式区分を非表示にします
    listBalancesheetIncome.value[index].isUseYoshikiKbn = false;
    //様式区分枝項目を非表示にします
    listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = false;
    //あっせん期間部分を非表示にします
    listBalancesheetIncome.value[index].isUseMediation = false;
    //団体名称を非表示にします
    listBalancesheetIncome.value[index].isUseOrgName = false;
    //項目名を非表示にします
    listBalancesheetIncome.value[index].isUseItemName = false;
    //団体住所を非表示にします
    listBalancesheetIncome.value[index].isUseAddress = false;
    //備考を非表示にします
    listBalancesheetIncome.value[index].isUseBiko = false;
    //寄付金控除を非表示にします
    listBalancesheetIncome.value[index].isUseCreditTax = false;
    //パーティ名称は非表示にします
    listBalancesheetIncome.value[index].isUsePartyName = false;
    //パーティ日付を非表示にします
    listBalancesheetIncome.value[index].isUsePartyDate = false;
}

//収入収支報告するのでとりあえずすべての入力フォームをあけます
function openInputIncomeForm(index: number): boolean {
    //様式区分を表示します;
    listBalancesheetIncome.value[index].isUseYoshikiKbn = true;
    //様式区分枝項目を表示します
    listBalancesheetIncome.value[index].isUseYoshikiEdaKbn = true;
    //あっせん期間を表示します
    listBalancesheetIncome.value[index].isUseMediation = true;
    //組織名称を表示します
    listBalancesheetIncome.value[index].isUseOrgName = true;
    //項目部分を表示します
    listBalancesheetIncome.value[index].isUseItemName = true;
    //団体住所部分を表示します
    listBalancesheetIncome.value[index].isUseAddress = true;
    //備考部分を表示ます
    listBalancesheetIncome.value[index].isUseBiko = true;
    //寄付金控除を表示します
    listBalancesheetIncome.value[index].isUseCreditTax = true;
    //パーティ名称を表示します
    listBalancesheetIncome.value[index].isUsePartyName = true;
    //パーティ日付を表示ます
    listBalancesheetIncome.value[index].isUsePartyDate = true;

    return true;
}


//支出の収支報告しないので不要な入力フォームを閉じます
function closeInputOutcomeForm(index: number) {
    //様式区分を非表示にします
    listBalancesheetOutcome.value[index].isUseYoshikiKbn = false;
    //様式区分枝項目を非表示にします
    listBalancesheetOutcome.value[index].isUseYoshikiEdaKbn = false;
    //団体名称を非表示にします
    listBalancesheetOutcome.value[index].isUseOrgName = false;
    //項目名を非表示にします
    listBalancesheetOutcome.value[index].isUseItemName = false;
    //団体住所を非表示にします
    listBalancesheetOutcome.value[index].isUseAddress = false;
    //備考を非表示にします
    listBalancesheetOutcome.value[index].isUseBiko = false;
    //寄付金控除を非表示にします
    listBalancesheetOutcome.value[index].isUseCollectRecipt = false;
    listBalancesheetOutcome.value[index].isUseRelatedGrants = false;
    //パーティ名称は非表示にします
    listBalancesheetOutcome.value[index].isUseCategorizedGroup = false;
    //パーティ日付を非表示にします
    listBalancesheetOutcome.value[index].isUseItemName = false;
}

//支出の収支報告するのでとりあえずすべての入力フォームをあけます
function openInputOutcomeForm(index: number): boolean {
    //様式区分を表示します;
    listBalancesheetOutcome.value[index].isUseYoshikiKbn = true;
    //様式区分枝項目を表示します
    listBalancesheetOutcome.value[index].isUseYoshikiEdaKbn = true;
    //組織名称を表示します
    listBalancesheetOutcome.value[index].isUseOrgName = true;
    //項目部分を表示します
    listBalancesheetOutcome.value[index].isUseItemName = true;
    //団体住所部分を表示します
    listBalancesheetOutcome.value[index].isUseAddress = true;
    //備考部分を表示ます
    listBalancesheetOutcome.value[index].isUseBiko = true;
    //寄付金控除を表示します
    listBalancesheetOutcome.value[index].isUseRelatedGrants = true;
    listBalancesheetOutcome.value[index].isUseCollectRecipt = true;
    //パーティ名称を表示します
    listBalancesheetOutcome.value[index].isUseCategorizedGroup = true;
    //パーティ日付を表示します
    listBalancesheetOutcome.value[index].isUseItemName = true;

    return true;
}

</script>
<template>
    <div class="one-line" style="overflow: scroll;">
        <h3>収入の部</h3>
        <table style="overflow: scroll;white-space: nowrap;">
            <tr>
                <th>参照摘要</th>
                <th>発生日</th>
                <th>金額</th>
                <th>*報告対象</th>
                <th>*仕訳大項目</th>
                <th>*仕訳小項目</th>
                <th>*項目</th>
                <th>*項目(氏名/職業)</th>
                <th>*項目(住所)</th>
                <th>*あっせんで集めた期間</th>
                <th>*政治資金パーティ名称</th>
                <th>*パーティ開催日</th>
                <th>*備考</th>
                <th>*寄付金控除</th>
                <th>+仕訳意見付記</th>
                <th>+前例と異なる処理</th>
                <th>+自動入力編集</th>
            </tr>
            <tr v-for="(incomeItem) in listBalancesheetIncome">
                <td><input type="text" v-model="incomeItem.referDigest" :disabled="true"></td>
                <td><input type="date" v-model="incomeItem.accrualDate" :disabled="!incomeItem.isEditAutoInput"></td>
                <td><input type="number" v-model="incomeItem.amount" :disabled="!incomeItem.isEditAutoInput"></td>
                <td><input type="radio" v-model="incomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
                        v-model="incomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio"
                        v-model="incomeItem.reportKbn" :value="11">報告対象外政治関連(廃止予定)</td>
                <td>
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
                <td>
                    <div v-show="incomeItem.isUseYoshikiEdaKbn"><select v-model="incomeItem.yoshikiEdaKbn">
                            <option value="1">個人</option>
                            <option value="2">法人その他の団体</option>
                            <option value="3">政治団体</option>
                        </select></div>
                </td>

                <td>
                    <div v-show="incomeItem.isUseItemName">{{ incomeItem.attentionItemName }}：<br><input type="text"
                            v-model="incomeItem.itemName">
                    </div>
                </td>
                <td>
                    <div v-show="incomeItem.isUseOrgName">{{ incomeItem.attentionOrgName }}：<br><input type="text"
                            v-model="incomeItem.shimeiOrgnizationName"></div>
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
                    <div v-show="incomeItem.isUseBiko"><input type="text" v-model="incomeItem.biko"></div>
                </td>
                <td>
                    <div v-show="incomeItem.isUseCreditTax">寄付金控除：<br><input type="checkbox"
                            v-model="incomeItem.isCreditTax">寄付金(税額)控除</div>
                </td>
                <td><textarea v-model="incomeItem.note"></textarea></td>
                <td><input type="checkbox" v-model="incomeItem.isDifferPrecedent">前例と異なる処理</td>
                <td><input type="checkbox" v-model="incomeItem.isEditAutoInput">入力できない部分を<br>入力可能にする</td>
            </tr>
        </table>
        *…収支報告書に記載される項目。+…このソフトウェア独自項目
    </div>
    <div class="one-line" style="overflow: scroll;">
        <h3>支出の部</h3>
        <table style="overflow: scroll;white-space: nowrap;">
            <tr>
                <th>参照摘要</th>
                <th>発生日</th>
                <th>金額</th>
                <th>*報告対象</th>
                <th>*仕訳大項目</th>
                <th>*仕訳小項目</th>
                <th>*小分類</th>
                <th>*支出の目的</th>
                <th>*個人氏名/団体名称</th>
                <th>*住所</th>
                <th>*備考</th>
                <th>*領収書を徴しがたかった</th>
                <th>*交付金に係る支出</th>
                <th>+仕訳意見付記</th>
                <th>+前例と異なる処理</th>
                <th>+自動入力編集</th>
            </tr>

            <tr v-for="(outcomeItem) in listBalancesheetOutcome">
                <td><input type="text" v-model="outcomeItem.referDigest" :disabled="true"></td>
                <td><input type="date" v-model="outcomeItem.accrualDate" :disabled="!outcomeItem.isEditAutoInput"></td>
                <td><input type="number" v-model="outcomeItem.amount" :disabled="!outcomeItem.isEditAutoInput"></td>
                <td><input type="radio" v-model="outcomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
                        v-model="outcomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio"
                        v-model="outcomeItem.reportKbn" :value="11">報告対象外政治関連(廃止予定)</td>
                <td>
                    <div v-show="outcomeItem.isUseYoshikiKbn"><select v-model="outcomeItem.yoshikiKbn">
                            <option value="14">14.人件費を除く経常収支</option>
                            <option value="15">15.政治活動費</option>
                            <option value="16">16.本部／支部交付金に係る支出</option>
                        </select></div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseYoshikiEdaKbn">

                        <select v-model="outcomeItem.yoshikiEdaKbn">
                            <option v-for="option in outcomeItem.yoshikiEdaKbnOptions" v-bind:value="option.value"
                                v-bind:key="option.value">
                                {{ option.text }}
                            </option>
                        </select>

                    </div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseCategorizedGroup">小分類：<br><input type="text"
                            v-model="outcomeItem.categorizeGroup"></div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseItemName">支出の適用：<br><input type="text" v-model="outcomeItem.itemName">
                    </div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseOrgName">支出を受けた者の氏名(団体名称)：<br><input type="text"
                            v-model="outcomeItem.shimeiOrgnizationName"></div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseAddress">支出を受けた者の住所：<br><input type="text"
                            v-model="outcomeItem.orgnizationAddress"></div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseBiko"><input type="text" v-model="outcomeItem.biko"></div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseCollectRecipt">
                        <select v-model="outcomeItem.notCollectReciptKbn">
                            <option value=""></option>
                            <option value="15">15.支出の明細書を作成</option>
                            <option value="16">16.振込み明細書に係る支出目的書を作成</option>
                        </select>
                    </div>
                </td>
                <td>
                    <div v-show="outcomeItem.isUseRelatedGrants">交付金に係る支出：<br><input type="checkbox"
                            v-model="outcomeItem.isExpendituresRelatedGrants">交付金に係る支出</div>
                </td>
                <td><textarea v-model="outcomeItem.note"></textarea></td>
                <td><input type="checkbox" v-model="outcomeItem.isDifferPrecedent">前例と異なる処理</td>
                <td><input type="checkbox" v-model="outcomeItem.isEditAutoInput">入力できない部分を<br>入力可能にする</td>
            </tr>
        </table>
        *…収支報告書に記載される項目。+…このソフトウェア独自項目
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
