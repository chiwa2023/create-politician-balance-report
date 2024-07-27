<script setup lang="ts">
import { Ref, ref } from "vue";
import SaveStorageResultDto from "../../../dto/storage/saveStorageResultDto";

//props,emit
const emits = defineEmits(["sendFileDataInterface"]);

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
const fileName:Ref<string> = ref("");
function sendFile() {
    if (selectFileInput.value !== null) {
        if (selectFileInput.value !== undefined) {
            if (selectFileInput.value.files !== null) {
                const file: File = selectFileInput.value.files[0];
                fileName.value = file.name;
                const saveStorageResultDto:SaveStorageResultDto = new SaveStorageResultDto(); 
                saveStorageResultDto.shoshouId = "12345-oiuyt";
                saveStorageResultDto.shoshouCode = 321;

                emits("sendFileDataInterface", saveStorageResultDto);
            }
        }
    }
}
</script>
<template>
    <div class="left-area">
        アップロードファイルの指定
    </div>
    <div class="right-area">
        {{ fileName  }}<input ref="selectFileInput" type="file" accept=".*" @change="sendFile" style="display:none;">
        <button @click="onReadButton">ファイルを指定して読み取り</button>
    </div>
    <div class="clear-both"></div>

</template>
<style scoped></style>
