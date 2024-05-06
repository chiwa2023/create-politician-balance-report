<script setup lang="ts">
import { ref, Ref } from "vue";
import CsvCellInterface from "../../../dto/read_csv/csvCell";
import axios from "axios";
import ReadCsvFileCapsuleDto from "../../../dto/read_csv/readCsvFileCapsuleDto";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import createCheckTransactionDto from "../../../dto/common_check/createCheckTransactionDto";
import SendCsvAndStragedShoshouDto from "../../../dto/read_csv/sendCsvAndStragedShoshouDto";
import showErrorMessage from "../../../dto/common_check/showErrorMessage";

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

//CSV変換結果データ
const sendCsvAndStragedShoshouDto: Ref<SendCsvAndStragedShoshouDto> = ref(new SendCsvAndStragedShoshouDto());

/**
 * 指定されたファイルを読み込む
 */
async function readTextFile() {
    //ファイルの読み取り
    if (selectFileInput.value !== null) {
        if (selectFileInput.value !== undefined) {
            if (selectFileInput.value.files !== null) {
                const file: File = selectFileInput.value.files[0];
                const reader: FileReader = new FileReader();
                reader.readAsText(file, selectedCharCode.value);
                reader.onload = async () => {
                    if (reader.result !== null) {

                        //必要な情報がそろったので親へデータを渡す
                        const readCsvFileCapsuleDto: ReadCsvFileCapsuleDto = new ReadCsvFileCapsuleDto();
                        //セッションストレージ取得
                        readCsvFileCapsuleDto.checkSecurityDto = SessionStorageCommonCheck.getSecurity();
                        readCsvFileCapsuleDto.checkPrivilegeDto = SessionStorageCommonCheck.getPrivilege();
                        //編集可否フラグがある場合は、そのフラグ(の反転した値)を照会フラグに設定する
                        readCsvFileCapsuleDto.checkTransactionDto = createCheckTransactionDto(true);

                        readCsvFileCapsuleDto.fileContent = String(reader.result);
                        readCsvFileCapsuleDto.fileName = file.name;
                        //csvファイルデータからcsv設定データに変換
                        const url = "http://localhost:8080/read-csv-by-file/practice";
                        await axios.post(url, readCsvFileCapsuleDto)
                            .then((response) => {
                                sendCsvAndStragedShoshouDto.value = response.data;
                                readData.value = sendCsvAndStragedShoshouDto.value.listAllCsv;
                                emits("sendGeneralCsvDataInterface", sendCsvAndStragedShoshouDto.value);
                            })
                            .catch((error) => showErrorMessage(error.status));
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
