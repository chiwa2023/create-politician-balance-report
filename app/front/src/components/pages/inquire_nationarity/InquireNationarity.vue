<script setup lang="ts">
import { Ref, ref, toRaw } from "vue";
import RelationPersonInterface from '../../../dto/relation/relationPersonDto';
import RelationPersonDto from '../../../dto/relation/relationPersonDto';
import mockGetInquirePesron from "./mock/mockGetInquirePesron";
import getRandomString from "../../../dto/getRandomString";
import getUnixTimeString from "../../../dto/getUnixTimeString";
import SessionStorageCommonCheck from "../../../dto/common_check/sessionStorageCommonCheck";
import CheckPrivilegeDto from "../../../dto/common_check/checkPrivilegeDto";
import SearchRelationPerson from "../../common/serach_relation_person/SearchRelationPerson.vue";
import SearchRelationPersonCapsuleInterface from "../../../dto/relation/searchRelationPersonCapsuleDto";
import SearchRelationPersonCapsuleDto from "../../../dto/relation/searchRelationPersonCapsuleDto";
import InputAddressDto from "../../../dto/Input_address/inputAddressDto";
import InputAddress from "../../common/input_address/InputAddress.vue";

//　入力分のmockデータ
const inquirePesonDto: Ref<RelationPersonInterface> = ref(mockGetInquirePesron());

//　問い合わせ関連者リスト
const listInquireGroup: Ref<RelationPersonInterface[]> = ref([]);

//　問い合わせ関連者回答リスト
const listInquireAnswer: Ref<RelationPersonInterface[]> = ref([]);

// 政治団体情報取得用
const checkPrivilegeDto: CheckPrivilegeDto = SessionStorageCommonCheck.getPrivilege();


//関連者表示フラグ
const isVisibleSearchRelationPerson: Ref<boolean> = ref(false);
const searchRelationPersonCapsuleDto: SearchRelationPersonCapsuleInterface = new SearchRelationPersonCapsuleDto();

/**
 * 関連者体検索コンポーネント表示
 */
function onSearchRelationPerson() {
    isVisibleSearchRelationPerson.value = true;
}

/**
 * 関連者検索キャンセル
 */
function recieveCancelSearchRelationPerson() {
    //非表示
    isVisibleSearchRelationPerson.value = false;
}

/**
 * 関連者検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchRelationPersonInterface(sendDto: RelationPersonInterface) {

    if (listInquireGroup.value.length >= 5) {
        alert("一度に問い合わせ出来る人数を超えています");
        return;
    }

    sendDto.inquireId = getUnixTimeString() + "-" + getRandomString();

    listInquireGroup.value.push(sendDto);

    //非表示
    isVisibleSearchRelationPerson.value = false;
}


//住所入力表示フラグ
const isVisibleInputAddress: Ref<boolean> = ref(false);

/** 住所 */
/**
 * 住所入力コンポーネント表示
 */
 function onInputAddress() {
    isVisibleInputAddress.value = true;
}

/**
 * 住所入力キャンセル
 */
function recieveCancelInputAddress() {
    //非表示
    isVisibleInputAddress.value = false;
}

/**
 * 住所入力選択
 * @param sendDto 選択Dto
 */
function recieveInputAddressInterface(sendDto: InputAddressDto) {
    //いったん親で保存(viewする)
    inquirePesonDto.value.addressPostal = sendDto.addressPostal;
    inquirePesonDto.value.addressBlock = sendDto.addressBlock;
    inquirePesonDto.value.addressBuilding = sendDto.addressBuilding;
    inquirePesonDto.value.tel1 = sendDto.tel1;
    inquirePesonDto.value.tel2 = sendDto.tel3;
    inquirePesonDto.value.tel3 = sendDto.tel3;
    inquirePesonDto.value.postalcode1 = sendDto.postalcode1;
    inquirePesonDto.value.postalcode2 = sendDto.postalcode2;
    inquirePesonDto.value.lgCode = sendDto.lgCode;
    inquirePesonDto.value.machiazaId = sendDto.machiazaId;
    inquirePesonDto.value.blkId = sendDto.blkId;
    inquirePesonDto.value.rsdtId = sendDto.rsdtId;

    //非表示
    isVisibleInputAddress.value = false;
}


function onAddList() {
    if (listInquireGroup.value.length >= 5) {
        alert("一度に問い合わせ出来る人数を超えています");
        return;
    }
    // リスト追加
    inquirePesonDto.value.nameAll = inquirePesonDto.value.firstName + "　" + inquirePesonDto.value.middleName + inquirePesonDto.value.lastName;
    inquirePesonDto.value.addressAll = inquirePesonDto.value.addressPostal + inquirePesonDto.value.addressBlock + " " + inquirePesonDto.value.addressBuilding;

    listInquireGroup.value.push(structuredClone(toRaw(inquirePesonDto.value)));
    inquirePesonDto.value = new RelationPersonDto();
    inquirePesonDto.value.inquireId = getUnixTimeString() + "-" + getRandomString();
    inquirePesonDto.value.politicalOrganizationId = checkPrivilegeDto.politicalOrganizationId;
    inquirePesonDto.value.politicalOrganizationCode = checkPrivilegeDto.politicalOrganizationCode;
    inquirePesonDto.value.politicalOrganizationName = checkPrivilegeDto.politicalOrganizationName;
}

function onRemoveList(id: string) {
    listInquireGroup.value = listInquireGroup.value.filter((e1) => e1.inquireId != id);
}

function onCancel() {
    alert("キャンセル");
}

function onSave() {

    // API接続時には不要な回答リスト初期処理
    listInquireAnswer.value.splice(0);

    // 外部APIに国籍情報問い合わせ
    //    const url = "http://localhost:9080/listup-party-usage-charset/normal";
    //    const method = "POST";
    //    const body = JSON.stringify(listInquireGroup.value);
    //    const headers = {
    //        'Accept': 'application/json',
    //        'Content-Type': 'application/json'
    //    };
    //    fetch(url, { method, headers, body })
    //        .then(async (response) => {
    //            listInquireAnswer.value = await response.json();
    //        })
    //        .catch((error) => { alert(error); });
    //}

    let counter: number = 1;
    for (const dto of listInquireGroup.value) {

        switch (counter % 3) {
            case 0:
                dto.nationalityAnswerKbn = "1";
                dto.nationalityAnswerKbnText = "日本国籍保持";
                break;

            case 1:
                dto.nationalityAnswerKbn = "2";
                dto.nationalityAnswerKbnText = "外国人籍";
                break;

            case 2:
                dto.nationalityAnswerKbn = "3";
                dto.nationalityAnswerKbnText = "基礎情報不備";
                break;

            default:
                break;
        }

        listInquireAnswer.value.push(dto);
        counter++;
    }

}
</script>
<template>
    <h1>国籍問い合わせ</h1>

    <div class="one-line">
        問い合わせしたい関連者を入力
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        登録済関連者から選択
    </div>
    <div class="right-area">
        <select disabled="true">
            <option>会計責任者 花子(1234-5678-9012)</option>
            <option>事務代行者 英雄(2345-6789-0123)</option>
        </select> 
        <button class="left-space" disabled="true">選択された関連者を編集</button>
        <button @click="onSearchRelationPerson" class="left-space">検索</button>
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        関連者コード
    </div>
    <div class="right-area">
        <input type="text" v-model="inquirePesonDto.kanrenshaCode" class="name-input" placeholder="関連者同一識別コード">
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        姓名
    </div>
    <div class="right-area">
        <input type="text" v-model="inquirePesonDto.firstName" class="name-input" placeholder="姓">
        <input type="text" v-model="inquirePesonDto.lastName" class="left-space name-input" placeholder="名">
        <input type="text" v-model="inquirePesonDto.middleName" class="left-space name-input" placeholder="ミドルネーム">
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        郵便番号
    </div>
    <div class="right-area">
        <input type="text" v-model="inquirePesonDto.postalcode1" class="code-input">-
        <input type="text" v-model="inquirePesonDto.postalcode2" class="code-input">
        <button @click="onInputAddress" class="left-space">住所編集</button>
     </div>

    <div class="left-area">
        住所
    </div>
    <div class="right-area">
        <textarea v-model="inquirePesonDto.addressPostal"></textarea> <br>
        <textarea v-model="inquirePesonDto.addressBlock"></textarea><br>
        <textarea v-model="inquirePesonDto.addressBuilding"></textarea><br>
        <span class="left-spacce">地方公共団体コード:</span> <input type="text" v-model="inquirePesonDto.lgCode"
            class="code-input" disabled="true">
        <span class="left-spacce"> 町字ID:</span><input type="text" v-model="inquirePesonDto.machiazaId"
            class="code-input" disabled="true">
        <span class="left-spacce">街区ID:</span><input type="text" v-model="inquirePesonDto.blkId" class="code-input"
            disabled="true">
        <span class="left-spacce">住居ID:</span><input type="text" v-model="inquirePesonDto.rsdtId" class="code-input"
            disabled="true">
    </div>

    <div class="left-area">
        電話番号
    </div>
    <div class="right-area">
        <input type="text" v-model="inquirePesonDto.tel1" class="code-input">-
        <input type="text" v-model="inquirePesonDto.tel2" class="code-input">-
        <input type="text" v-model="inquirePesonDto.tel3" class="code-input">
    </div>

    <div class="left-area">
        問い合わせ
    </div>
    <div class="right-area">
        <button @click="onAddList">問い合わせリストに入れる</button>
    </div>
    <div class="clear-both"><br></div>

    <div class="one-line">
        問い合わせをしたい関連者(仮で5人まで)<br>
        <table>
            <tr>
                <th>名前</th>
                <th>郵便番号</th>
                <th>住所</th>
                <th>電話番号</th>
                <th>　　　　</th>
            </tr>
            <tr v-for="personDto in listInquireGroup" :key="personDto.inquireId">
                <td>
                    {{ personDto.kanrenshaCode }}<br>
                    {{ personDto.firstName }} {{ personDto.middleName }} {{ personDto.lastName }}
                </td>
                <td>
                    {{ personDto.postalcode1 }}-{{ personDto.postalcode2 }}
                </td>
                <td>
                    {{ personDto.lgCode }} -{{ personDto.machiazaId }}-{{ personDto.blkId }} -{{
                        personDto.rsdtId }}<br>
                    {{ personDto.addressPostal }} {{ personDto.addressBlock }} {{
                        personDto.addressBuilding }}
                </td>
                <td>
                    {{ personDto.tel1 }}-{{ personDto.tel2 }}-{{ personDto.tel3 }}
                </td>
                <td>
                    <button @click="onRemoveList(personDto.inquireId)">削除</button>
                </td>

            </tr>
        </table>
    </div>
    <div class="clear-both"><br></div>




    <div class="one-line" v-show="listInquireAnswer.length > 0">
        問い合わせを回答<br>
        <table>
            <tr>
                <th>問い合わせ回答</th>
                <th>名前</th>
                <th>郵便番号</th>
                <th>住所</th>
                <th>電話番号</th>
            </tr>
            <tr v-for="personDto in listInquireAnswer" :key="personDto.inquireId">
                <td>
                    {{ personDto.nationalityAnswerKbn }}<br>
                    {{ personDto.nationalityAnswerKbnText }}
                </td>
                <td>
                    {{ personDto.kanrenshaCode }}<br>
                    {{ personDto.firstName }} {{ personDto.middleName }} {{ personDto.lastName }}
                </td>
                <td>
                    {{ personDto.postalcode1 }}-{{ personDto.postalcode2 }}
                </td>
                <td>
                    {{ personDto.lgCode }} -{{ personDto.machiazaId }}-{{ personDto.blkId }} -{{
                        personDto.rsdtId }}<br>
                    {{ personDto.addressPostal }} {{ personDto.addressBlock }} {{
                        personDto.addressBuilding }}
                </td>
                <td>
                    {{ personDto.tel1 }}-{{ personDto.tel2 }}-{{ personDto.tel3 }}
                </td>
            </tr>
        </table>
    </div>
    <div class="clear-both"><br></div>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">送信</button>
    </div>

    <!-- 関連者検索コンポーネント -->
    <div v-if="isVisibleSearchRelationPerson" class="overBackground"></div>
    <div v-if="isVisibleSearchRelationPerson">
        <div class="overComponent">
            <SearchRelationPerson :is-editable="false" :search-dto="searchRelationPersonCapsuleDto"
                @send-cancel-search-relation-person="recieveCancelSearchRelationPerson"
                @send-relation-person-interface="recieveSearchRelationPersonInterface">
            </SearchRelationPerson>
        </div>
    </div>

    <!-- 住所入力コンポーネント -->
    <div v-if="isVisibleInputAddress" class="overBackground"></div>
    <div v-if="isVisibleInputAddress">
        <div class="overComponent">
            <InputAddress @send-cancel-input-address="recieveCancelInputAddress"
                @send-input-address-interface="recieveInputAddressInterface">
            </InputAddress>
        </div>
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
