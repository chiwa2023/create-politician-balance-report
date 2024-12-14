<script setup lang="ts">
import { computed, WritableComputedRef} from "vue";
import FinacialOrgAccountInterface from "../../../dto/bank_account/finacialOrgAccountDto";
import SelectOptionInterface from "../../../dto/selectOptionDto";

//propsとemit
const props = defineProps<{ accountDto: FinacialOrgAccountInterface, listType: SelectOptionInterface[] }>();

//口座情報
const finacialOrgAccountDto: WritableComputedRef<FinacialOrgAccountInterface> = computed(
    () => props.accountDto,
);

//口座種別リスト
const listTypeAccount: WritableComputedRef<SelectOptionInterface[]> = computed(
    () => props.listType,
);

// 金融機関口座Dto
//const finacialOrgAccountDto: Ref<FinacialOrgAccountInterface> = ref(mockGetFinancialAccountDto());
// 金融機関口座種別リスト(普通・当座・仮でその他を選択できる)
//const listTypeView: string[] = [];
//listTypeView.push(DepositType.REGULAR);
//listTypeView.push(DepositType.CURRENT);
//listTypeView.push(DepositType.OTHER);
//const listTypeAccount: SelectOptionInterface[] = createAccountDepositTypeList(listTypeView);

</script>
<template>
    <div class="one-line">
        金融機関情報入力
    </div>

    <div class="left-area">
        金融機関
    </div>
    <div class="right-area">
        <input type="text" v-model="finacialOrgAccountDto.zenginFinacialOrgCode" class="code-input" disabled="true">
        <input type="text" v-model="finacialOrgAccountDto.finacialOrgName" class="left-space code-name">
        <button class="left-space">検索</button>
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        店舗
    </div>
    <div class="right-area">
        <input type="text" v-model="finacialOrgAccountDto.zenginFinacialBranchCode" class="code-input" disabled="true">
        <input type="text" v-model="finacialOrgAccountDto.finacialBranchName" class="left-space code-name">
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        口座種別
    </div>
    <div class="right-area">
        <select v-model="finacialOrgAccountDto.typeAccount">
            <option v-for="selectionDto in listTypeAccount" :key="selectionDto.value"> {{ selectionDto.text }}</option>
        </select>
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        口座番号
    </div>
    <div class="right-area">
        <input type="text" v-model="finacialOrgAccountDto.accountNumber" class="left-space code-name">
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        口座名義人(カナ)
    </div>
    <div class="right-area">
        <input type="text" v-model="finacialOrgAccountDto.accountMeiginin" class="left-space code-name">
    </div>
    <div class="clear-both"></div>


</template>
<style scoped></style>
