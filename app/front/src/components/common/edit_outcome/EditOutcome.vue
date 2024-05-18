<script setup lang="ts">
import { computed, WritableComputedRef,watch } from "vue";
import BalancesheetOutcomeDto from "../../../dto/balancesheetOutcomeDto";
import viewPrepareOutcome from "../../../dto/balancesheet/viewPrepareOutcome";
import changeOutcomeYoushikiKbnState from "../../../dto/balancesheet/changeOutcomeYoushikiKbnState";


//表示・編集対象
const props = defineProps<{ outcomeDto: BalancesheetOutcomeDto }>();
const outcomeItem: WritableComputedRef<BalancesheetOutcomeDto> = computed(
    () => {
        return props.outcomeDto;
    }
);

/** 全体を監視 */
watch(() => outcomeItem.value, () => {
    viewPrepareOutcome(outcomeItem.value);
});

/** 報告区分を監視 */
watch(() => outcomeItem.value.reportKbn, () => {
    viewPrepareOutcome(outcomeItem.value);
});

/** 様式区分を監視 */
watch(() => outcomeItem.value.youshikiKbn, () => {
    changeOutcomeYoushikiKbnState(outcomeItem.value);
});
</script>
<template>
    <h3>支出項目の編集</h3>
    <div class="left-area">自動入力編集</div>
    <div class="right-area">
        <input type="checkbox" v-model="outcomeItem.isEditAutoInput">入力できない部分を入力可能にする
    </div>

    <!-- TODO 書証参照は仕様が決定次第修正する
    <div class="left-area">書証タイプ</div>
    <div class="right-area">
        <input type="checkbox" v-model="outcomeItem.isEditAutoInput">入力できない部分を入力可能にする
    </div>
    -->

    <div class="left-area">収支報告区分</div>
    <div class="right-area">
        <input type="radio" v-model="outcomeItem.reportKbn" :value="1">報告対象<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="20">報告対象外(生活費)<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="11">報告対象外政治関連(廃止予定)<br><input type="radio"
            v-model="outcomeItem.reportKbn" :value="50">タスク計上(後で確定)
    </div>

    <div v-show="outcomeItem.isUseYoushikiKbn">
        <div class="left-area">様式区分</div>
        <div class="right-area">
            <select v-model="outcomeItem.youshikiKbn">
                <option value="14">14.人件費を除く経常収支</option>
                <option value="15">15.政治活動費</option>
                <option value="16">16.本部／支部交付金に係る支出</option>
            </select>
        </div>
    </div>

    <div v-show="outcomeItem.isUseYoushikiEdaKbn">
        <div class="left-area">様式枝区分項目</div>
        <div class="right-area">
            <select v-model="outcomeItem.youshikiEdaKbn">
                <option v-for="option in outcomeItem.youshikiEdaKbnOptions" v-bind:value="option.value"
                    v-bind:key="option.value">
                    {{ option.text }}
                </option>
            </select>
        </div>
    </div>

    <div class="left-area">発生日</div>
    <div class="right-area">
        <input type="date" v-model="outcomeItem.accrualDate" :disabled="!outcomeItem.isEditAutoInput">
    </div>

    <div class="left-area">取引金額</div>
    <div class="right-area">
        <input type="number" v-model="outcomeItem.amount" :disabled="!outcomeItem.isEditAutoInput">
    </div>

    <div v-show="outcomeItem.isUseCategorizedGroup">
        <div class="left-area">小分類</div>
        <div class="right-area">
            <input type="text" v-model="outcomeItem.categorizeGroup">
        </div>
    </div>

    <div v-show="outcomeItem.isUseItemName">
        <div class="left-area">支出の適用</div>
        <div class="right-area">
            <input type="text" v-model="outcomeItem.itemName">
        </div>
    </div>

    <div v-show="outcomeItem.isUseItemName">
        <div class="left-area">支出を受けた者の住所</div>
        <div class="right-area">
            <input type="text" v-model="outcomeItem.orgnizationAddress">
        </div>
    </div>

    <div v-show="outcomeItem.isUseItemName">
        <div class="left-area">支出を受けた者</div>
        <div class="right-area">
            <input type="text" v-model="outcomeItem.professionOrgnizationName">
        </div>
    </div>

    <div v-show="outcomeItem.isUseBiko">
        <div class="left-area">備考</div>
        <div class="right-area">
            <input type="text" v-model="outcomeItem.biko">
        </div>
    </div>

    <div v-show="outcomeItem.isUseCollectRecipt">
        <div class="left-area">領収書を徴しがたかった</div>
        <div class="right-area">
            <select v-model="outcomeItem.notCollectReciptKbn">
                <option value=""></option>
                <option value="1">1.支出明細書作成</option>
                <option value="2">2.支出目的書(振込明細)を作成</option>
            </select>
        </div>
    </div>

    <div v-show="outcomeItem.isUseRelatedGrants">
        <div class="left-area">交付金に係る支出</div>
        <div class="right-area">
            <input type="checkbox" v-model="outcomeItem.isExpendituresRelatedGrants">交付金に係る支出
        </div>
    </div>

    <div class="left-area">意見付記</div>
    <div class="right-area">
        <textarea v-model="outcomeItem.note"></textarea>
    </div>

    <div class="left-area">前例と異なる処理</div>
    <div class="right-area">
        <input type="checkbox" v-model="outcomeItem.isDifferPrecedent">前例と異なる処理
    </div>

    <!-- TODO 保全書証参照は仕様が決定次第修正する -->
    <div class="left-area">保全した書証</div>
    <div class="right-area">
        <button disabled="true">書証を参照する</button>
    </div>


</template>
<style scoped></style>
