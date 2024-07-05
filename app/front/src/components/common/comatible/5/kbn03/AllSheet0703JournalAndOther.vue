<script setup lang="ts">
import { computed, WritableComputedRef } from "vue";
import { AllSheet0703JournalAndOtherDto } from "../../../../../dto/publish/5/kbn03/allSheet0703JournalAndOtherDto";

//props
const props = defineProps<{ sheedDto: AllSheet0703JournalAndOtherDto }>();

//computed
const allSheet0703JournalAndOther: WritableComputedRef<AllSheet0703JournalAndOtherDto> = computed(() => props.sheedDto,
);

//合計金額
const totalKingaku = computed(() => {
    let total: number = 0;
    for (const dto of allSheet0703JournalAndOther.value.sheet070300JournalAndOtherDto.list) {
        total = total + dto.kingaku;
    }
    return total;
});

</script>
<template>
    <div class="one-line">
        <h3>機関誌発行とその他の事業</h3>
        <table>
            <tr>
                <th style="width: 5%;">連番</th>
                <th style="width: 25%;">事業の種類</th>
                <th style="width: 25%;">金額</th>
                <th style="width: 15%;">備考</th>
            </tr>
            <tr v-for="row in allSheet0703JournalAndOther.sheet070300JournalAndOtherDto.list" :key="row.ichirenNo">
                <td class="text-right-align">{{ row.ichirenNo }}</td>
                <td>{{ row.jigyoNoShurui }}</td>
                <td class="text-right-align">{{ row.kingaku }}</td>
                <td>{{ row.biko }}</td>
            </tr>
            <tr>
                <th colspan="2" class="text-right-align">合計金額</th>
                <th class="text-right-align">{{ totalKingaku }}</th>
                <th>&nbsp;</th>
            </tr>
        </table>
    </div>
    <div class="clear-both" />
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
