<script setup lang="ts">
import { Ref, ref, toRaw } from 'vue';
import AddressBlockDto from '../../dto/addressBlockDto';
import AddressPostalcodeDto from '../../dto/addressPostalcodeDto';
import PostalAddressBlockInterface from '../../dto/postalAddressBlockDto';

//郵便番号情報
const addressPostalcode: Ref<AddressPostalcodeDto> = ref(new AddressPostalcodeDto());

//番地住所リスト
const listBlock: Ref<AddressBlockDto[]> = ref([]);
const listBlockBack: Ref<AddressBlockDto[]> = ref([]);

const selected: Ref<string> = ref("");
const building: Ref<string> = ref("");

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

                //フィルタ条件は初期化
                choume.value = 0;
                prc1.value = 0;
                prc2.value = 0;
                prc3.value = 0;
            })
            .catch((error) => { alert(error); });

        isListPrepared = true;
    }
    else {
        isListPrepared = false;
    }
}

const choume: Ref<number> = ref(0);
const prc1: Ref<number> = ref(0);
const prc2: Ref<number> = ref(0);
const prc3: Ref<number> = ref(0);

function filterList() {
    if (isListPrepared) {
        listBlock.value = listBlockBack.value
            .filter(dto => { if (choume.value === 0) { return true }; return dto.choume === choume.value; })
            .filter(dto => { if (prc1.value === 0) { return true }; return dto.prc1 === prc1.value; })
            .filter(dto => { if (prc2.value === 0) { return true }; return dto.prc2 === prc2.value; })
            .filter(dto => { if (prc3.value === 0) { return true }; return dto.prc3 === prc3.value; });
        //常に最善を入力されたと仮定し、1行目を選択する
        selected.value = listBlock.value[0].value;
    }
}

</script>
<template>
    <h1>番地入力補助(実装例2)</h1>
    <div class="left-area">郵便番号</div>
    <div class="right-area"><input type="number" v-model="addressPostalcode.postalcode" @input="loadList"
            placeholder="郵便番号" /></div>
    <div stye="clear:both;"></div>
    <div class="left-area">住所</div>
    <div class="right-area"><input type="text" v-model="addressPostalcode.addressName" disabled="true"
            style="width: 75%;" /></div>
    <div stye="clear:both;"></div>
    <div class="left-area">番地入力</div>
    <div class="right-area">
        <span v-show="addressPostalcode.isChoume"><input type="number" style="width:10%" @input="filterList"
                v-model="choume" />丁目</span>
        <span v-show="addressPostalcode.isPrc1"><input type="number" style="width:10%" @input="filterList"
                v-model="prc1" />番地</span>
        <span v-show="addressPostalcode.isPrc2"><input type="number" style="width:10%" @input="filterList"
                v-model="prc2" /></span>
        <span v-show="addressPostalcode.isPrc3">の<input type="number" style="width:10%" @input="filterList"
                v-model="prc3" /></span><br>
        <select v-model="selected">
            <option v-for="dto in listBlock" :value="dto.value">{{ dto.text }}</option>
        </select>
    </div>
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