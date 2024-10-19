<script setup lang="ts">
import { Ref, ref, toRaw } from 'vue';
import AddressPostalcodeDto from '../../dto/addressPostalcodeDto';
import AddressBlockDto from '../../dto/addressBlockDto';
import PostalAddressBlockInterface from '../../dto/postalAddressBlockDto';

//郵便番号情報
const addressPostalcode: Ref<AddressPostalcodeDto> = ref(new AddressPostalcodeDto());

//番地住所リスト
const listBlock: Ref<AddressBlockDto[]> = ref([]);
const listBlockBack: Ref<AddressBlockDto[]> = ref([]);

const selected: Ref<string> = ref("");
const building: Ref<string> = ref("");

//const postalcode: Ref<string> = ref("");

const filterCondition: Ref<string> = ref("");

let isListPrepared = false;
async function loadList() {
    if (String(addressPostalcode.value.postalcode).length === 7) {

        //郵便番号から
        const url = "http://localhost:8080/zz-address/example2?postalCode=" + addressPostalcode.value.postalcode;
        const method = "GET";
        //const body = JSON.stringify(conditonDto.value);
        const headers = {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        };

        fetch(url, { method, headers })
            .then(async (response) => {

                //データを取得
                const resultDto: PostalAddressBlockInterface = await response.json();

                //TODO ほとんどが1件だけ取得できるので、その想定であるが、複数に仕様変更の可能性もある
                addressPostalcode.value = resultDto.listPostalcode[0];
                listBlock.value = resultDto.listBlock;

                //バックアップが必要
                listBlockBack.value = structuredClone(toRaw(listBlock.value));

                //フィルタ条件を初期化
                filterCondition.value = "";

            })
            .catch((error) => { alert(error); });

        isListPrepared = true;
    }
    else {
        isListPrepared = false;
    }
}

function filterList() {
    if (isListPrepared) {
        listBlock.value = listBlockBack.value.filter(dto => { if ("" === filterCondition.value) { return true; } return dto.text.startsWith(filterCondition.value) });
        selected.value = listBlock.value[0].value;
    }
}

//function getPoastalcodeInfo() {
//    addressPostalcode.value.addressName = "熊本県";
//}

//function createListMock() {
//    listBlock.value.push(createOption("1番地", 0, 1, 0, 0));
//    listBlock.value.push(createOption("11番地", 0, 11, 0, 0));
//    listBlock.value.push(createOption("21番地", 0, 21, 0, 0));
//    listBlock.value.push(createOption("2番地", 0, 2, 0, 0));
//}

//function createOption(text: string, chome: number, prc1: number, prc2: number, prc3: number): AddressBlockDto {
//    const dto: AddressBlockDto = new AddressBlockDto();
//    dto.value = text;
//    dto.text = text;
//    dto.choume = chome;
//    dto.prc1 = prc1;
//    dto.prc2 = prc2;
//    dto.prc3 = prc3;
//    return dto;
//}
</script>
<template>
    <h1>番地入力補助(実装例1)</h1>

    <div class="left-area">郵便番号</div>
    <div class="right-area"><input type="number" v-model="addressPostalcode.postalcode" @input="loadList"
            placeholder="広島県神石郡または熊本県熊本市中央区の郵便番号"></div>
    <div stye="clear:both;"></div>

    <div class="left-area">住所</div>
    <div class="right-area"><input type="text" v-model="addressPostalcode.addressName" disabled="true"
            style="width: 75%;" /></div>
    <div stye="clear:both;"></div>

    <div class="left-area">番地</div>
    <div class="right-area"><select v-model="selected">
            <option v-for="dto in listBlock" :value="dto.value">{{ dto.text }}</option>
        </select><input type="text" v-model="filterCondition" @input="filterList" placeholder="丁目・番地など"
            style="margin-left:2%;"></div>
    <div stye="clear:both;"></div>

    <div class="left-area">建物</div>
    <div class="right-area"><input type="text" v-model="building" /></div>
    <div stye="clear:both;"></div>

    <div class="left-area">&nbsp;</div>
    <div class="right-area">
        <cite style="font-size: smaller;">
            【地番データ権利・出典表示】<br>
            「アドレス・ベース・レジストリ(地番マスター データセット)」（デジタル庁）を独自に加工して作成<br>
            「登記所備付データ」(法務省)を独自に加工して作成<br>
            <a href="address_block_quote.html" target="_blank">取得地番一覧(リンク)表示</a>
        </cite>
    </div>
    <div stye="clear:both;"></div>

    <div class="left-area">新規地番申請</div>
    <div class="right-area"><button>地番が選択肢にないので利用申請</button> </div>
    <div stye="clear:both;"></div>

</template>
<style scoped></style>