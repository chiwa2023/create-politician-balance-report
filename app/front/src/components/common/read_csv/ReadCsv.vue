<script setup lang="ts">
import { ref, Ref } from "vue";
import CsvCellInterface from "../../../dto/read_csv/csvCell";
import mockCsvData from "./mock/mockCsvData";

//props,emit
const emits = defineEmits(["sendGeneralCsvDataInterface"]);

//文字コード
const selectedCharCode = ref("UTF-8");

//ファイル指定ダイアログ
const selectFileInput: Ref<HTMLInputElement | undefined> = ref<HTMLInputElement>();
/**
 * ファイル選択ダイアログを表示する
 */
function onReadButton() {
    if (selectFileInput.value !== undefined) {
        selectFileInput.value.click();
    }
}
//読み取りCSVデータ
const readData: Ref<[CsvCellInterface[]]> = ref([[]]);
/**
 * 指定されたファイルを読み込む
 */
function readTextFile() {
    //ファイルの読み取り
    if (selectFileInput.value !== null) {
        if (selectFileInput.value !== undefined) {
            if (selectFileInput.value.files !== null) {
                //alert(selectFileInput.value.files[0].name);
                const file = selectFileInput.value.files[0];
                const reader = new FileReader();
                reader.readAsText(file,selectedCharCode.value);
                reader.onload = () => {
                    alert(reader.result);
                    if (reader.result !== null) {
                        //必要な情報がそろったので親へデータを渡す
                        readData.value = mockCsvData();
                        emits("sendGeneralCsvDataInterface", readData.value);
                    }
                };
            }
        }
    }
}
</script>
<template>
    <div class="left-area">
        読取りファイルの指定
    </div>
    <div class="right-area">
        <input ref="selectFileInput" type="file" accept=".csv" @change="readTextFile" style="display:none;">
        <button @click="onReadButton">ファイルを指定して読み取り</button>
        文字が読めない場合
        <select v-model="selectedCharCode">
            <option value="UTF-8">UTF-8</option>
            <option value="Shift_JIS">Shift_JIS(Windows)</option>
        </select>
        
        <br>
    </div>
</template>
<style scoped></style>
