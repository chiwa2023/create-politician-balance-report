<script setup lang="ts">
import { computed, Ref, ref, WritableComputedRef } from "vue";
import RealEstateDto from "../../../dto/balancesheet_estate/realEstateDto";

//props
const props = defineProps<{ realEstateList: RealEstateDto[] }>();

//編集Dto
const editDto: Ref<RealEstateDto> = ref(new RealEstateDto());

const isEditable: Ref<boolean> = ref(true);

/** 表示行 */
const list: WritableComputedRef<RealEstateDto[]> = computed(
    () => props.realEstateList,
);

/** ラジオボタン選択 */
const selectedRow: Ref<number> = ref(0);

/**  
 * 選択行を通知する
 * @param rowId その行のDtoのId
 */
function onSelectChange(rowId: number) {
    if (true === isEditable.value) {
        editDto.value = list.value.filter((dto) => dto.balancesheetRealEstateId == rowId)[0];
    }
}


/**  
 * 削除ボタンを押下された行を削除する
 * @param rowId その行のDtoのId
 */
function deleteRow(rowId: number) {
    const newList: RealEstateDto[] = list.value.filter((dto) => dto.balancesheetRealEstateId != rowId);
    list.value = newList;
}
/**  
 * 最終行のあとに行追加を行う
 */
function addRow() {
    let maxId = 0;
    for (const dto of list.value) {
        if (maxId < dto.balancesheetRealEstateId) {
            maxId = dto.balancesheetRealEstateId;
        }
    }
    const addDto: RealEstateDto = new RealEstateDto();
    addDto.balancesheetRealEstateId = maxId + 1;
    list.value.push(addDto);
}

//所持目的が団体事務所
const isMyOffice: Ref<boolean> = ref(false);
const isMyOfficeText: string = "団体事務所である";
function onPurposeAll() {
    //団体事務所であるにチェックされたら語句を追加
    if (isMyOffice.value) {
        if (editDto.value.purposeAll.indexOf(isMyOfficeText) === -1) {
            editDto.value.purposeAll = editDto.value.purposeAll + " " + isMyOfficeText;
        }
    } else {
        editDto.value.purposeAll = editDto.value.purposeAll.replace(" " + isMyOfficeText, "");
        editDto.value.purposeAll = editDto.value.purposeAll.replace(isMyOfficeText, "");
    }
}

//使用者が団体職員
const relationSub: Ref<string> = ref("");
const myOfficeWorker: string = "当該団体の職員である";
const otherWorker: string = "職員ではない";

function onRelation() {
    switch (relationSub.value) {
        //反対側を削除し追加
        case myOfficeWorker:
            editDto.value.userRelation = editDto.value.userRelation.replace(otherWorker, "");
            editDto.value.userRelation = editDto.value.userRelation + myOfficeWorker;
            break;
        //反対側を削除し追加
        case otherWorker:
            editDto.value.userRelation = editDto.value.userRelation.replace(myOfficeWorker, "");
            editDto.value.userRelation = editDto.value.userRelation + otherWorker;
            break;
        //どちらにも該当しなければ両方削除
        default:
            editDto.value.userRelation = editDto.value.userRelation.replace(myOfficeWorker, "");
            editDto.value.userRelation = editDto.value.userRelation.replace(otherWorker, "");
            break;

    }

}

</script>
<template>
    <h3>不動産入力</h3>
    <table>
        <tr>
            <th style="width:6%;">&nbsp;</th>
            <th style="width:15%;">同一データ確認</th>
            <th style="width:15%;">コード</th>
            <th>資産枝区分</th>
            <th>摘要</th>
            <th>用途</th>
            <th>使用者との関係</th>
            <th>使用者ごとの用途</th>
            <th>利用面積</th>
            <th>対価の面積</th>
            <th v-if="isEditable" style="width:9%;">&nbsp;</th>
        </tr>

        <tr v-for="searchedDto in list" :key="searchedDto.balancesheetRealEstateId">
            <td style="text-align: center;"><input type="radio" id="searchedDto.balancesheetRealEstateId"
                    :value="searchedDto.balancesheetRealEstateId" v-model="selectedRow"
                    @click="onSelectChange(searchedDto.balancesheetRealEstateId)" /></td>
            <td><input type="checkbox" v-model="searchedDto.isSameData">前年と同一</td>
            <td style="text-align: right;">{{ searchedDto.balancesheetRealEstateCode }}</td>
            <td style="text-align: right;">
                <select v-model="searchedDto.yoshikiEdaKbn" disabled="true">
                    <option value="ア">ア：土地</option>
                    <option value="イ">イ:建物</option>
                    <option value="ウ">ウ:地上権または借地権 </option>
                </select>
            </td>

            <td style="text-align: right;">{{ searchedDto.itemName }}</td>
            <td style="text-align: right;">{{ searchedDto.purposeAll }}</td>
            <td style="text-align: right;">{{ searchedDto.userRelation }}</td>
            <td style="text-align: right;">{{ searchedDto.userPerpose }}</td>
            <td style="text-align: right;">{{ searchedDto.userArea }}</td>
            <td style="text-align: right;">{{ searchedDto.userAmount }}</td>
            <td v-if="isEditable" style="text-align: center;"><button
                    @click="deleteRow(searchedDto.balancesheetRealEstateId)">削除</button></td>
        </tr>
    </table>
    <button v-if="isEditable" @click="addRow">新規行追加</button>

    <br> &nbsp;

    <h3>選択したデータを編集</h3>
    <div class="left-area">様式枝区分項目</div>
    <div class="right-area">
        <select v-model="editDto.yoshikiEdaKbn">
            <option value="ア">ア：土地</option>
            <option value="イ">イ:建物</option>
            <option value="ウ">ウ:地上権または借地権 </option>
        </select>
    </div>
    <div class="both-clear"></div>

    <div class="left-area">摘要</div>
    <div class="right-area"><input type="text" v-model="editDto.itemName" /></div>
    <div class="both-clear"></div>

    <div class="left-area">用途</div>
    <div class="right-area">
        <input type="text" v-model="editDto.purposeAll" />
        <input type="checkbox" v-model="isMyOffice" class="left-space" @change="onPurposeAll" />{{ isMyOfficeText }}
    </div>
    <div class="both-clear"></div>

    <div class="left-area">使用者と代表者の関係</div>
    <div class="right-area">
        <input type="text" v-model="editDto.userRelation" /><br>
        <input type="radio" class="left-space" :value="myOfficeWorker" v-model="relationSub" @change="onRelation">{{
            myOfficeWorker }}
        <input type="radio" class="left-space" :value="otherWorker" v-model="relationSub" @change="onRelation">{{
            otherWorker }}
        <input type="radio" class="left-space" value="" v-model="relationSub" @change="onRelation">その他
    </div>
    <div class="both-clear"></div>

    <div class="left-area">使用者ごとの用途</div>
    <div class="right-area"><input type="text" v-model="editDto.userPerpose" /></div>
    <div class="both-clear"></div>

    <div class="left-area">使用者ごとの使用面積</div>
    <div class="right-area"><input type="text" v-model="editDto.userArea" /></div>
    <div class="both-clear"></div>

    <div class="left-area">使用者ごとの対価の価額</div>
    <div class="right-area"><input type="text" v-model="editDto.userAmount" /></div>
    <div class="both-clear"></div>

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
