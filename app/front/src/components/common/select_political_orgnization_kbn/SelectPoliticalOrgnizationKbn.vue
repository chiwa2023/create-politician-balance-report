<script setup lang="ts">
import { Ref, ref, watch } from "vue";
import SelectPoliticalOrganizationKbnDto from "../../../dto/select_political_organization_kbn/SelectPoliticalOrganizationKbn";
import PoliticalPartyInterface from "../../../dto/political_party/politicalPartyDto";
import SearchPoliticalParty from "../../common/search_political_party/SearchPoliticalParty.vue";
import PoliticalOrganizationInterface from "../../../dto/political_organization/politicalOrganizationDto";
import SearchPoliticalOrganization from "../search_political_organization/SearchPoliticalOrganization.vue";
import SearchParliamentMember from "../search_parliament_member/SearchParliamentMember.vue";
import SearchParliamentOrganization from "../search_parliament_organization/SearchParliamentOrganization.vue";
import SearchPoliticianAll from "../search_politician_all/SearchPoliticianAll.vue";
import SearchElectionDistrict from "../search_election_district/SearchElectionDistrict.vue";
import ElectionDistrictInterface from "../../../dto/election_district/electionDistictDto";
import ParliamentMemberInterface from "../../../dto/parliament_member/parliamentMember";
import ParliamentOrganizationInterface from "../../../dto/parliament_organization/parliamentOrganization";
import PoliticianAllInterface from "../../../dto/politician_all/politicianAllDto";
import SearchPoliticalOrganizationCapsuleDto from "../../../dto/political_organization/searchPoliticalOrganizationCapsuleDto";
import inputSelectDisplayBold from "../../../util/display/inputSelectDisplayBold";

//emits
const emits = defineEmits(["sendCancelSelectPoliticalOrganizationKbn", "sendSelectPoliticalOrganizationKbnInterface"]);

//選択肢
const selectedOrganizationKbn: Ref<string> = ref("0");

/** 伝送Dto */
const editDto: Ref<SelectPoliticalOrganizationKbnDto> = ref(new SelectPoliticalOrganizationKbnDto());

//Q1.政党要件を満たす政党である
const isParty: Ref<boolean> = ref(false);

//Q2.(各議員でなく、政党への唯一の資金提供窓口である)政治資金団体である
const isPartyManageFunds: Ref<boolean> = ref(false);

//Q3.政党要件を満たす政党の支部である
const isPartyBranch: Ref<boolean> = ref(false);

//Q4.代表者は国会議員の現職である
const isCountryParliament: Ref<boolean> = ref(false);

//Q5.代表者は国会議員の候補者である
const isCountryParliamentCandidate: Ref<boolean> = ref(false);

//Q6.国会議員の現職または候補者を後援または推薦している
const isCountryParliamentSupport: Ref<boolean> = ref(false);

//Q7.代表者は地方の首長または地方議会議員の現職である
const isLocalityParliament: Ref<boolean> = ref(false);

//Q8.代表者は地方の首長または地方議会議員の現職である
const isLocalityParliamentCandidate: Ref<boolean> = ref(false);

//Q9.地方の首長または地方議会議員の現職または候補者を後援または推薦している
const isLocalityParliamentSupport: Ref<boolean> = ref(false);

//Q10.パーティの収益(の一部)が政治活動に使われ、かつ収入が10,000,000円である団体である
const isSpecialPartyOrgnization: Ref<boolean> = ref(false);

//Q11.議員の後援・推薦はしていないが、政治的主張活動を継続的に行っている
const isPurposeOrganization: Ref<boolean> = ref(false);

//Q12.政治団体の支部である
const isOrganizationBranch: Ref<boolean> = ref(false);

const isKokkaiGiin: Ref<boolean> = ref(false);


watch(selectedOrganizationKbn, () => {
    switch (selectedOrganizationKbn.value) {

        //Q1.政党要件を満たす政党である
        case "1":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isParty.value = true;

            isKokkaiGiin.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;
        //Q2.(各議員でなく、政党への唯一の資金提供窓口である)政治資金団体である
        case "2":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isPartyManageFunds.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q3.政党要件を満たす政党の支部である
        case "3":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isPartyBranch.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q4.代表者は国会議員の現職である
        case "4":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isCountryParliament.value = true;

            isKokkaiGiin.value = true;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q5.代表者は国会議員の候補者である
        case "5":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isCountryParliamentCandidate.value = true;

            isKokkaiGiin.value = true;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q6.国会議員の現職または候補者を後援または推薦している
        case "6":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isCountryParliamentSupport.value = true;

            isKokkaiGiin.value = true;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q7.代表者は地方の首長または地方議会議員の現職である
        case "7":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isLocalityParliament.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q8.代表者は地方の首長または地方議会議員の現職である
        case "8":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isLocalityParliamentCandidate.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q9.地方の首長または地方議会議員の現職または候補者を後援または推薦している
        case "9":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isLocalityParliamentSupport.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q10.パーティの収益(の一部)が政治活動に使われ、かつ収入が10,000,000円である団体である
        case "10":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isSpecialPartyOrgnization.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isPurposeOrganization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q11.議員の後援・推薦はしていないが、政治的主張活動を継続的に行っている
        case "11":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isPurposeOrganization.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isOrganizationBranch.value = false;
            break;

        //Q12.政治団体の支部である
        case "12":
            editDto.value = new SelectPoliticalOrganizationKbnDto();
            editDto.value.organizationKbn = selectedOrganizationKbn.value;
            isOrganizationBranch.value = true;

            isKokkaiGiin.value = false;
            isParty.value = false;
            isPartyManageFunds.value = false;
            isPartyBranch.value = false;
            isCountryParliament.value = false;
            isCountryParliamentCandidate.value = false;
            isCountryParliamentSupport.value = false;
            isLocalityParliament.value = false;
            isLocalityParliamentCandidate.value = false;
            isLocalityParliamentSupport.value = false;
            isSpecialPartyOrgnization.value = false;
            isPurposeOrganization.value = false;
            break;
    }
});

//政党表示フラグ
const isVisibleSearchPoliticalParty: Ref<boolean> = ref(false);

/**
 * 政党検索コンポーネント表示
 */
function onSearchPoliticalParty() {
    isVisibleSearchPoliticalParty.value = true;
}

/**
 * 政党検索キャンセル
 */
function recieveCancelSearchPoliticalParty() {
    //非表示
    isVisibleSearchPoliticalParty.value = false;
}

/**
 * 政党検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPoliticalPartyInterface(sendDto: PoliticalPartyInterface) {

    editDto.value.politicalPartyId = sendDto.politicalPartyId;
    editDto.value.politicalPartyCode = sendDto.politicalPartyCode;
    editDto.value.politicalPartyName = sendDto.politicalPartyName;

    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.politicalPartyAlternativeText = "";
    editDto.value.isNotFindPoliticalParty = false;

    //非表示
    isVisibleSearchPoliticalParty.value = false;
}


//政治団体表示フラグ
const isVisibleSearchPoliticalOrganization: Ref<boolean> = ref(false);
const searchPoliticalOrganizationCapsuleDto: SearchPoliticalOrganizationCapsuleDto = new SearchPoliticalOrganizationCapsuleDto();

/**
 * 政治団体検索コンポーネント表示
 */
function onSearchPoliticalOrganization() {
    isVisibleSearchPoliticalOrganization.value = true;
}

/**
 * 政治団体検索キャンセル
 */
function recieveCancelSearchPoliticalOrganization() {
    //非表示
    isVisibleSearchPoliticalOrganization.value = false;
}

/**
 * 政治団体検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPoliticalOrganizationInterface(sendDto: PoliticalOrganizationInterface) {

    editDto.value.politicalOrganizationId = sendDto.politicalOrganizationId;
    editDto.value.politicalOrganizationCode = sendDto.politicalOrganizationCode;
    editDto.value.politicalOrganizationName = sendDto.politicalOrganizationName;

    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.politicalOrganizationAlternativeText = "";
    editDto.value.isNotFindPoliticalOrganization = false;

    //非表示
    isVisibleSearchPoliticalOrganization.value = false;
}

//議会選挙区表示フラグ
const isVisibleSearchElectionDistrict: Ref<boolean> = ref(false);

/**
 * 議会選挙区検索コンポーネント表示
 */
function onSearchElectionDistrict() {
    isVisibleSearchElectionDistrict.value = true;
}

/**
 * 議会選挙区検索キャンセル
 */
function recieveCancelSearchElectionDistrict() {
    //非表示
    isVisibleSearchElectionDistrict.value = false;
}

/**
 * 議会選挙区検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchElectionDistrictInterface(sendDto: ElectionDistrictInterface) {

    editDto.value.electionDistrictId = sendDto.electionDistrictId;
    editDto.value.electionDistrictCode = sendDto.electionDistrictCode;
    editDto.value.electionDistrictName = sendDto.electionDistrictName;

    editDto.value.parliamentOrganizationId = sendDto.parliamentOrganizationId;
    editDto.value.parliamentOrganizationCode = sendDto.parliamentOrganizationCode;
    editDto.value.parliamentOrganizationName = sendDto.parliamentOrganizationName;

    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.electionDistrictAlternativeText = "";
    editDto.value.isNotFindElectionDistrict = false;

    //非表示
    isVisibleSearchElectionDistrict.value = false;
}

//議員表示フラグ
const isVisibleSearchParliamentMember: Ref<boolean> = ref(false);

/**
 * 議員検索コンポーネント表示
 */
function onSearchParliamentMember() {
    isVisibleSearchParliamentMember.value = true;
}

/**
 * 議員検索キャンセル
 */
function recieveCancelSearchParliamentMember() {
    //非表示
    isVisibleSearchParliamentMember.value = false;
}

/**
 * 議員検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchParliamentMemberInterface(sendDto: ParliamentMemberInterface) {

    editDto.value.parliamentMemberId = sendDto.parliamentMemberId;
    editDto.value.parliamentMemberCode = sendDto.parliamentMemberCode;
    editDto.value.parliamentMemberName = sendDto.parliamentMemberName;
    editDto.value.parliamentMemberNameKana = sendDto.parliamentMemberNameKana;
    //議員には議会情報も議会選挙区情報も付属しています
    editDto.value.parliamentOrganizationId = sendDto.parliamentOrganizationId;
    editDto.value.parliamentOrganizationCode = sendDto.parliamentOrganizationCode;
    editDto.value.parliamentOrganizationName = sendDto.parliamentOrganizationName;
    editDto.value.electionDistrictId = sendDto.electionDistrictId;
    editDto.value.electionDistrictCode = sendDto.electionDistrictCode;
    editDto.value.electionDistrictName = sendDto.electionDistrictName;


    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.parliamentMemberAlternativeText = "";
    editDto.value.isNotFindParliamentMember = false;

    //非表示
    isVisibleSearchParliamentMember.value = false;
}

//議会表示フラグ
const isVisibleSearchParliamentOrganization: Ref<boolean> = ref(false);

/**
 * 議会検索コンポーネント表示
 */
function onSearchParliamentOrganization() {
    isVisibleSearchParliamentOrganization.value = true;
}

/**
 * 議会検索キャンセル
 */
function recieveCancelSearchParliamentOrganization() {
    //非表示
    isVisibleSearchParliamentOrganization.value = false;
}

/**
 * 議会検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchParliamentOrganizationInterface(sendDto: ParliamentOrganizationInterface) {

    editDto.value.parliamentOrganizationId = sendDto.parliamentOrganizationId;
    editDto.value.parliamentOrganizationCode = sendDto.parliamentOrganizationCode;
    editDto.value.parliamentOrganizationName = sendDto.parliamentOrganizationName;

    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.parliamentOrganizationAlternativeText = "";
    editDto.value.isNotFindParliamentOrganization = false;

    //非表示
    isVisibleSearchParliamentOrganization.value = false;
}

//政治家表示フラグ
const isVisibleSearchPoliticianAll: Ref<boolean> = ref(false);

/**
 * 政治家検索コンポーネント表示
 */
function onSearchPoliticianAll() {
    isVisibleSearchPoliticianAll.value = true;
}

/**
 * 政治家検索キャンセル
 */
function recieveCancelSearchPoliticianAll() {
    //非表示
    isVisibleSearchPoliticianAll.value = false;
}

/**
 * 政治家検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPoliticianAllInterface(sendDto: PoliticianAllInterface) {

    editDto.value.politicianAllId = sendDto.politicianAllId;
    editDto.value.politicianAllCode = sendDto.politicianAllCode;
    editDto.value.politicianAllName = sendDto.politicianAllName;
    editDto.value.politicianAllNameKana = sendDto.politicianAllNameKana;
    //政治家(過去立候補者)には議会情報も議会選挙区情報も付属しています
    editDto.value.parliamentOrganizationId = sendDto.parliamentOrganizationId;
    editDto.value.parliamentOrganizationCode = sendDto.parliamentOrganizationCode;
    editDto.value.parliamentOrganizationName = sendDto.parliamentOrganizationName;
    editDto.value.electionDistrictId = sendDto.electionDistrictId;
    editDto.value.electionDistrictCode = sendDto.electionDistrictCode;
    editDto.value.electionDistrictName = sendDto.electionDistrictName;

    //指定出来たら未指定機能は不要なので確実に初期化する
    editDto.value.politicianAllAlternativeText = "";
    editDto.value.isNotFindPoliticianAll = false;


    //非表示
    isVisibleSearchPoliticianAll.value = false;
}

/** キャンセル */
function onCancel() {
    emits("sendCancelSelectPoliticalOrganizationKbn");
}

/** 保存 */
function onSave() {
    emits("sendSelectPoliticalOrganizationKbnInterface", editDto.value);
}
</script>
<template>

    <h2>政党区分入力補助</h2>

    Q1.<input type="radio" v-model="selectedOrganizationKbn" value="1"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '1')">政党要件を満たす政党である</span><br>
    <span v-show="isParty">
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q2.<input type="radio" v-model="selectedOrganizationKbn" value="2"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '2')">(各議員でなく、政党への唯一の資金提供窓口である)政治資金団体である</span><br>
    <span v-show="isPartyManageFunds">
        <input type="number" v-model="editDto.politicalPartyCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicalPartyName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticalParty">政党検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticalParty"> 政党を見つけられない<input type="text"
            v-model="editDto.politicalPartyAlternativeText" :disabled="!editDto.isNotFindPoliticalParty"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q3.<input type="radio" v-model="selectedOrganizationKbn" value="3"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '3')">政党要件を満たす政党の支部である</span><br>
    <span v-show="isPartyBranch">
        <input type="number" v-model="editDto.politicalPartyCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicalPartyName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticalParty">政党検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticalParty"> 政党を見つけられない<input type="text"
            v-model="editDto.politicalPartyAlternativeText" :disabled="!editDto.isNotFindPoliticalParty"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q4.<input type="radio" v-model="selectedOrganizationKbn" value="4"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '4')">代表者は国会議員の現職である</span><br>
    <span v-show="isCountryParliament">
        <input type="number" v-model="editDto.parliamentMemberCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentMemberName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentMember">議員検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentMember">議員を見つけられない<input type="text"
            v-model="editDto.parliamentMemberAlternativeText" :disabled="!editDto.isNotFindParliamentMember"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="checkbox" v-model="editDto.isFundsManageOrg">現職が1団体だけ保持できる資金管理団体である<br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q5.<input type="radio" v-model="selectedOrganizationKbn" value="5"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '5')">代表者は国会議員の候補者である</span><br>
    <span v-show="isCountryParliamentCandidate">
        <input type="number" v-model="editDto.politicianAllCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicianAllName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticianAll">過去立候補者検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticianAll"> 候補者を見つけられない<input type="text"
            v-model="editDto.politicianAllAlternativeText" :disabled="!editDto.isNotFindPoliticianAll"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="checkbox" v-model="editDto.isFundsManageOrg">候補者が1団体だけ保持できる資金管理団体である<br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q6.<input type="radio" v-model="selectedOrganizationKbn" value="6"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '6')">国会議員の現職または候補者を後援または推薦している</span><br>
    <span v-show="isCountryParliamentSupport">
        <input type="number" v-model="editDto.politicianAllCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicianAllName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticianAll">過去立候補者検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticianAll"> 候補者を見つけられない<input type="text"
            v-model="editDto.politicianAllAlternativeText" :disabled="!editDto.isNotFindPoliticianAll"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q7.<input type="radio" v-model="selectedOrganizationKbn" value="7"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '7')">代表者は地方の首長または地方議会議員の現職である</span><br>
    <span v-show="isLocalityParliament">
        <input type="number" v-model="editDto.parliamentMemberCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentMemberName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentMember">議員検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentMember">議員を見つけられない<input type="text"
            v-model="editDto.parliamentMemberAlternativeText" :disabled="!editDto.isNotFindParliamentMember"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="checkbox" v-model="editDto.isFundsManageOrg">現職が1団体だけ保持できる資金管理団体である<br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q8.<input type="radio" v-model="selectedOrganizationKbn" value="8"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '8')">代表者は地方の首長または地方議会議員の候補者である</span><br>
    <span v-show="isLocalityParliamentCandidate">
        <input type="number" v-model="editDto.politicianAllCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicianAllName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticianAll">過去立候補者検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticianAll"> 候補者を見つけられない<input type="text"
            v-model="editDto.politicianAllAlternativeText" :disabled="!editDto.isNotFindPoliticianAll"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="checkbox" v-model="editDto.isFundsManageOrg">候補者が1団体だけ保持できる資金管理団体である<br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q9.<input type="radio" v-model="selectedOrganizationKbn" value="9"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '9')">地方の首長または地方議会議員の現職または候補者を後援または推薦している</span><br>
    <span v-show="isLocalityParliamentSupport">
        <input type="number" v-model="editDto.politicianAllCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicianAllName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticianAll">過去立候補者検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticianAll"> 候補者を見つけられない<input type="text"
            v-model="editDto.politicianAllAlternativeText" :disabled="!editDto.isNotFindPoliticianAll"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.electionDistrictCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionDistrictName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionDistrict">選挙区検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindElectionDistrict">選挙区を見つけられない<input type="text"
            v-model="editDto.electionDistrictAlternativeText" :disabled="!editDto.isNotFindElectionDistrict"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <input type="number" v-model="editDto.parliamentOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.parliamentOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchParliamentOrganization">議会検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindParliamentOrganization">議会を見つけられない<input type="text"
            v-model="editDto.parliamentOrganizationAlternativeText" :disabled="!editDto.isNotFindParliamentOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q10.<input type="radio" v-model="selectedOrganizationKbn"
        value="10"><span
        :class="inputSelectDisplayBold(selectedOrganizationKbn === '10')">パーティの収益(の一部)が政治活動に使われ、かつ収入が10,000,000円以上である団体である</span><br>
    <span v-show="isSpecialPartyOrgnization">
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q11.<input type="radio" v-model="selectedOrganizationKbn" value="11"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '11')">議員の後援・推薦はしていないが、政治的主張活動を継続的に行っている</span><br>
    <span v-show="isPurposeOrganization">
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    Q12.<input type="radio" v-model="selectedOrganizationKbn" value="12"><span
    :class="inputSelectDisplayBold(selectedOrganizationKbn === '12')">政治団体の支部である</span><br>
    <span v-show="isOrganizationBranch">
        <input type="number" v-model="editDto.politicalOrganizationCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.politicalOrganizationName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchPoliticalOrganization">政治団体検索</button><br>
        <input type="checkbox" v-model="editDto.isNotFindPoliticalOrganization"> 政治団体を見つけられない<input type="text"
            v-model="editDto.politicalOrganizationAlternativeText" :disabled="!editDto.isNotFindPoliticalOrganization"
            class="left-space name-input" placeholder="検索できないときだけ使う"><br>
        <button @click="onSave">政治団体区分決定</button><br>
    </span>

    <!-- 政党検索コンポーネント -->
    <div v-if="isVisibleSearchPoliticalParty" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchPoliticalParty">
        <div class="overComponentLayer2">
            <SearchPoliticalParty :is-editable="false" ;
                @send-cancel-search-political-party="recieveCancelSearchPoliticalParty"
                @send-political-party-interface="recieveSearchPoliticalPartyInterface">
            </SearchPoliticalParty>
        </div>
    </div>

    <!-- 議員検索コンポーネント -->
    <div v-if="isVisibleSearchParliamentMember" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchParliamentMember">
        <div class="overComponentLayer2">
            <SearchParliamentMember :is-editable="false" :is-kokkai-giin="isKokkaiGiin"
                @send-cancel-search-parliament-member="recieveCancelSearchParliamentMember"
                @send-parliament-member-interface="recieveSearchParliamentMemberInterface">
            </SearchParliamentMember>
        </div>
    </div>

    <!-- 政治家検索コンポーネント -->
    <div v-if="isVisibleSearchPoliticianAll" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchPoliticianAll">
        <div class="overComponentLayer2">
            <SearchPoliticianAll :is-editable="false" :is-kokkai-giin="isKokkaiGiin"
                @send-cancel-search-politician-all="recieveCancelSearchPoliticianAll"
                @send-politician-all-interface="recieveSearchPoliticianAllInterface">
            </SearchPoliticianAll>
        </div>
    </div>

    <!-- 議会検索コンポーネント -->
    <div v-if="isVisibleSearchParliamentOrganization" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchParliamentOrganization">
        <div class="overComponentLayer2">
            <SearchParliamentOrganization :is-editable="false" ;
                @send-cancel-search-parliament-organization="recieveCancelSearchParliamentOrganization"
                @send-parliament-organization-interface="recieveSearchParliamentOrganizationInterface">
            </SearchParliamentOrganization>
        </div>
    </div>

    <!-- 選挙区検索コンポーネント -->
    <div v-if="isVisibleSearchElectionDistrict" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchElectionDistrict">
        <div class="overComponentLayer2">
            <SearchElectionDistrict :is-editable="false" ;
                @send-cancel-search-election-district="recieveCancelSearchElectionDistrict"
                @send-election-district-interface="recieveSearchElectionDistrictInterface">
            </SearchElectionDistrict>
        </div>
    </div>

    <!-- 政治団体検索コンポーネント -->
    <div v-if="isVisibleSearchPoliticalOrganization" class="overBackgroundLayer2"></div>
    <div v-if="isVisibleSearchPoliticalOrganization">
        <div class="overComponentLayer2">
            <SearchPoliticalOrganization :is-editable="false" :search-dto="searchPoliticalOrganizationCapsuleDto"
                @send-cancel-search-political-organization="recieveCancelSearchPoliticalOrganization"
                @send-political-organization-interface="recieveSearchPoliticalOrganizationInterface">
            </SearchPoliticalOrganization>
        </div>
    </div>

    <div class="footer">
        <button @click="onCancel">キャンセル</button>
    </div>

</template>
<style scoped></style>
