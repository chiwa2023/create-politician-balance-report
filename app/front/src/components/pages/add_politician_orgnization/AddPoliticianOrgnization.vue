<script setup lang="ts">
import { computed, Ref, ref, WritableComputedRef } from "vue";
import PersonManager from "../../common/person_managaer/PersonManager.vue";
import PersonWorker from "../../common/person_worker/PersonWorker.vue";
import SearchElectionCommission from "../../common/search_election_commission/SearchElectionCommission.vue";
import SelectPoliticalOrgnizationKbn from "../../common/select_political_orgnization_kbn/SelectPoliticalOrgnizationKbn.vue";
import SearchPersonManager from "../../common/search_person_manager/SearchPersonManager.vue";
import SearchPersonWorker from "../../common/search_person_worker/SearchPersonWorker.vue";
import ElectionCommissionLeastInterface from "../../../dto/election_commission/electionCommissionDto";
import InputAddress from "../../common/input_address/InputAddress.vue";
import ViewInputAddress from "../../common/input_address/ViewInputAddress.vue";
import InputAddressDto from "../../../dto/Input_address/inputAddressDto";
import convertAddressText from "../../../dto/Input_address/convertAddressText";
import PersonManagerInterface from "../../../dto/person_manager/personManager";
import PersonWorkerInterface from "../../../dto/person_worker/personWorkerDto";
import SelectPoliticalOrganizationKbnDto from "../../../dto/select_political_organization_kbn/SelectPoliticalOrganizationKbn";
import inputSelectDisplayBold from "../../../util/display/inputSelectDisplayBold";
import AddPoliticianOrgnizationDto from "../../../dto/add_politician_orgnization/addPoliticianOrgnizationDto";

//編集用Dto
const editDto: Ref<AddPoliticianOrgnizationDto> = ref(new AddPoliticianOrgnizationDto());

/** 一括入力未使用 */
const isUseInput: Ref<boolean> = ref(true);

///** 団体区分 */
//const organizationKbn: Ref<string> = ref("0");

///** 主たる活動地域 */
//const activityArea: Ref<string> = ref("2");

/** 国会議員条項(代表者が現職または候補者) */
//const isKokkaiGiinHonninKouhosha: Ref<boolean> = ref(false);
/** 国会議員条項(後援・支援) */
//const isKokkaiGiinSuisen: Ref<boolean> = ref(false);

/** 衆議院・参議院の別 */
//const selectedCountryParliament: Ref<string> = ref("0");//未選択
/** 国会議員の本人または候補者の姓名 */
//const kokkaGinName: Ref<string> = ref("");//入力なし
/** 国会議員の本人または候補者の姓名ふりがな */
//const kokkaGinNameKana: Ref<string> = ref("");//入力なし


/** 提出先(総務省)固定値 */
const soumushouId: number = 1;
const soumushouCode: number = 1;
const soumushouName: string = "総務省(総務大臣)";

/* 受領先は活動地域に完全に連動 */
/** 受領先Id */
const acceptOrgnizationId: WritableComputedRef<number> = computed(() => {
    if (editDto.value.activityArea === "1") { return soumushouId }
    else { return editDto.value.electionComitteeId }
});
/** 受領先同一識別コード */
const acceptOrgnizationCode: WritableComputedRef<number> = computed(() => {
    if (editDto.value.activityArea === "1") {
        return soumushouCode
    }
    else { return editDto.value.electionComitteeCode }
});
/** 受領先名称 */
const acceptOrgnizationName: WritableComputedRef<string> = computed(() => {
    if (editDto.value.activityArea === "1") {
        return soumushouName
    }
    else { return editDto.value.electionComitteeName }
});

/** 資金管理団体指定 */
//const isFundsManageOrg: Ref<boolean> = ref(false);

/** 資金管理団体 現職候補者の別 */
//const selectParliamentOrCandidate: Ref<string> = ref("0");

/** 資金管理団体 届出者 */
//const fundsManageOrgDelegateName: Ref<string> = ref("");
/** 資金管理団体 役職 */
//const parliamentName: Ref<string> = ref("");


//選挙管理委員会表示フラグ
const isVisibleSearchElectionCommision: Ref<boolean> = ref(false);
///** 提出選挙管理委員会Id */
//const electionComitteeId: Ref<number> = ref(0);
///** 提出選挙管理委員会同一識別コード */
//const electionComitteeCode: Ref<number> = ref(0);
///** 提出選挙管理委員会名称 */
//const electionComitteeName: Ref<string> = ref("");

/**
 * 選挙管理委員会検索コンポーネント表示
 */
function onSearchElectionCommition() {
    isVisibleSearchElectionCommision.value = true;
}

/**
 * 選挙管理委員会検索キャンセル
 */
function recieveCancelSearchElectionCommissionLeast() {
    //非表示
    isVisibleSearchElectionCommision.value = false;
}

/**
 * 選挙管理委員会検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchElectionCommissionLeastInterface(sendDto: ElectionCommissionLeastInterface) {

    editDto.value.electionComitteeId = sendDto.electionCommissionId;
    editDto.value.electionComitteeCode = sendDto.electionCommissionCode;
    editDto.value.electionComitteeName = sendDto.electionCommissionName;

    //非表示
    isVisibleSearchElectionCommision.value = false;
}



//住所入力表示フラグ
const isVisibleInputAddress: Ref<boolean> = ref(false);

///** 住所情報受け取り */
//const inputAddressDto: Ref<InputAddressDto> = ref(new InputAddressDto());

/** 署名住所 */
const signatureAddress: Ref<string> = ref("");

/** 署名代表者名 */
const signatureDelegateName: WritableComputedRef<string> = computed(() => {
    return editDto.value.personManagerDelegate.firstName + "　" + editDto.value.personManagerDelegate.middleName + "　" + editDto.value.personManagerDelegate.lastName
});
/** 主たる事務所の住所 */
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
    editDto.value.inputAddressDto = sendDto;

    //署名欄にコピーする
    signatureAddress.value = convertAddressText(editDto.value.inputAddressDto);

    //非表示
    isVisibleInputAddress.value = false;
}


//責任者入力表示フラグ
const isVisibleSearchPersonManager: Ref<boolean> = ref(false);
const callManagerIndex: Ref<number> = ref(0);

/**
 * 責任者検索コンポーネント表示
 */
function onSearchPersonManager(callIndex: number) {
    callManagerIndex.value = callIndex;
    isVisibleSearchPersonManager.value = true;
}

/**
 * 責任者検索キャンセル
 */
function recieveCancelSearchPersonManager() {
    //非表示
    isVisibleSearchPersonManager.value = false;
}

/**
 * 責任者検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPersonManagerInterface(sendDto: PersonManagerInterface, index: number) {

    switch (index) {
        case 1:
            editDto.value.personManagerDelegate = sendDto;

            break;
        case 2:
            editDto.value.personManagerAccountManager = sendDto;
            break;
        case 3:
            editDto.value.personManagerAccountSupport = sendDto;
            break;
    }

    //非表示
    isVisibleSearchPersonManager.value = false;
}





//作業者入力表示フラグ
const isVisibleSearchPersonWorker: Ref<boolean> = ref(false);
const callWorkerIndex: Ref<number> = ref(0);

/**
 * 作業者検索コンポーネント表示
 */
function onSearchPersonWorker(callIndex: number) {
    callWorkerIndex.value = callIndex;
    isVisibleSearchPersonWorker.value = true;
}

/**
 * 作業者検索キャンセル
 */
function recieveCancelSearchPersonWorker() {
    //非表示
    isVisibleSearchPersonWorker.value = false;
}

/**
 * 作業者検索選択
 * @param sendDto 選択Dto
 */
function recieveSearchPersonWorkerInterface(sendDto: PersonWorkerInterface, index: number) {

    switch (index) {
        case 1:
            editDto.value.personWorkser2 = sendDto;
            break;
        case 2:
            editDto.value.personWorkser3 = sendDto;
            break;
    }

    //非表示
    isVisibleSearchPersonWorker.value = false;
}

//政治団体区分指定コンポーネント表示フラグ
const isVisibleSelectPoliticalOrgnizationKbn: Ref<boolean> = ref(false);
const selectPoliticalOrganizationKbnDto: Ref<SelectPoliticalOrganizationKbnDto> = ref(new SelectPoliticalOrganizationKbnDto());

/**
 * 政治団体区分指定コンポーネント表示
 */
function onSelectPoliticalOrgnizationKbn() {
    isVisibleSelectPoliticalOrgnizationKbn.value = true;
}

/**
 * 政治団体区分指定検索キャンセル
 */
function recieveCancelSelectPoliticalOrgnizationKbn() {
    //非表示
    isVisibleSelectPoliticalOrgnizationKbn.value = false;
}

/**
 * 政治団体区分指定検索選択
 * @param sendDto 選択Dto
 */
function recieveSelectPoliticalOrgnizationKbnInterface(sendDto: SelectPoliticalOrganizationKbnDto) {
    //仮ですべて保持する TODO 永続化・提出方法が決定次第修正する
    selectPoliticalOrganizationKbnDto.value = sendDto;

    switch (sendDto.organizationKbn) {
        //Q1.政党要件を満たす政党である
        case "1":
            editDto.value.organizationKbn = "1";//政党
            //国会議員が5人以上なので活動地域は2か所以上(総務省提出)
            editDto.value.activityArea = "1";

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = "法の基準を満たす政党としての政治活動";
            break;

        //Q2.(各議員でなく、政党への唯一の資金提供窓口である)政治資金団体である
        case "2":
            editDto.value.organizationKbn = "3";//政治資金団体
            //国会議員が5人以上なので活動地域は2か所以上(総務省提出)
            editDto.value.activityArea = "1";

            // TODO 政党の関係を保存し、他に政治資金団体を設置していないかという妥当性をチェックする

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = "政党の唯一の資金窓口である政治資金管理活動";
            break;

        //Q3.政党要件を満たす政党の支部である
        case "3":
            editDto.value.organizationKbn = "2";//政党支部
            // TODO 政党の関係を保存する
            //政党支部は総務省提出・掲載ではなかった
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";
            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = "政党支部としての政治活動";
            break;

        //Q4.代表者は国会議員の現職である
        case "4":
            editDto.value.organizationKbn = "5";//その他の政治団体

            //国会議員現職または候補者が代表者
            editDto.value.isKokkaiGiinHonninKouhosha = true;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.selectParliamentOrCandidate = "1";//現職

            //活動地域は国会議員が含まれていると活動地域が２か所以上(総務省提出となります)
            editDto.value.activityArea = "1";

            //入力内容によって切り替え
            let giinName4: string = "";
            if (sendDto.isNotFindParliamentMember) {
                //議員名に編集があった場合
                giinName4 = sendDto.parliamentMemberAlternativeText;
            } else {
                //議員名に編集がない場合
                giinName4 = sendDto.parliamentMemberName;
            }

            let gikaiName4: string = "";
            if (sendDto.isNotFindParliamentOrganization) {
                //議会名に編集があった場合
                gikaiName4 = sendDto.parliamentOrganizationAlternativeText;

            } else {
                //議会名に編集がない場合
                gikaiName4 = sendDto.parliamentOrganizationName;

            }

            // TODO 議会が手入力修正された場合、衆議院／参議院の別の入力を受け付ける必要がある
            // TODO 議員名が手入力修正されていた場合、姓名ふりがなの入力を受け付ける必要がある

            //入力によって切り替え
            editDto.value.selectedCountryParliament = String(sendDto.parliamentOrganizationId);//TODO 衆議院と参議院は固定値になるようセット
            editDto.value.kokkaGinName = giinName4;
            editDto.value.kokkaGinNameKana = sendDto.parliamentMemberNameKana;
            editDto.value.isFundsManageOrg = sendDto.isFundsManageOrg;

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName4 + "の政治活動";

            //資金管理団体指定のある時だけ入力窓を埋める
            if (editDto.value.isFundsManageOrg) {
                editDto.value.fundsManageOrgDelegateName = giinName4;
                editDto.value.parliamentName = gikaiName4;
                editDto.value.orgnozationPurpose = giinName4 + "が唯一保持する資金管理団体としての活動";
            }
            break;

        //Q5.代表者は国会議員の候補者である
        case "5":
            editDto.value.organizationKbn = "5";//その他の政治団体

            //国会議員現職または候補者が代表者
            editDto.value.isKokkaiGiinHonninKouhosha = true;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.selectParliamentOrCandidate = "2";//候補者

            //活動地域は国会議員が含まれていると活動地域が２か所以上(総務省提出となります)
            editDto.value.activityArea = "1";

            //入力によって切り替え
            let giinName5: string = "";
            if (sendDto.isNotFindPoliticianAll) {
                //政治家に編集があった場合
                giinName5 = sendDto.politicianAllAlternativeText;
            } else {
                //政治家に編集がない場合
                giinName5 = sendDto.politicianAllName;
            }

            let gikaiName5: string = "";
            if (sendDto.isNotFindParliamentOrganization) {
                //議会名に編集があった場合
                gikaiName5 = sendDto.parliamentOrganizationAlternativeText;

            } else {
                //議会名に編集がない場合
                gikaiName5 = sendDto.parliamentOrganizationName;
            }

            // TODO 議会が手入力修正された場合、衆議院／参議院の別の入力を受け付ける必要がある
            // TODO 議員名が手入力修正されていた場合、姓名ふりがなの入力を受け付ける必要がある

            editDto.value.selectedCountryParliament = String(sendDto.parliamentOrganizationId);//TODO 衆議院と参議院は固定値になるようセット
            editDto.value.kokkaGinName = giinName5;
            editDto.value.kokkaGinNameKana = sendDto.politicianAllNameKana;
            editDto.value.isFundsManageOrg = sendDto.isFundsManageOrg;

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName5 + "の政治活動";

            //資金管理団体指定のある時だけ入力窓を埋める
            if (editDto.value.isFundsManageOrg) {
                editDto.value.fundsManageOrgDelegateName = giinName5;
                editDto.value.parliamentName = gikaiName5;
                editDto.value.orgnozationPurpose = giinName5 + "が唯一保持する資金管理団体としての活動";
            }

            break;

        //Q6.国会議員の現職または候補者を後援または推薦している
        case "6":
            editDto.value.organizationKbn = "5";//その他の政治団体

            //国会議員を推薦・支援している
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = true;

            //支援する団体は県選管提出でOK
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            //入力によって切り替え
            let giinName6: string = "";
            if (sendDto.isNotFindPoliticianAll) {
                //政治家名に編集があった場合
                giinName6 = sendDto.politicianAllAlternativeText;
            } else {
                //政治家名に編集がない場合
                giinName6 = sendDto.politicianAllName;
            }

            //let gikaiName6: string = "";
            //if (sendDto.isNotFindParliamentOrganization) {
            //    //議会名に編集があった場合
            //    gikaiName6 = sendDto.parliamentOrganizationAlternativeText;
            //} else {
            //    //議会名に編集がない場合
            //    gikaiName6 = sendDto.parliamentOrganizationName;
            //}

            // TODO 議会が手入力修正された場合、衆議院／参議院の別の入力を受け付ける必要がある
            // TODO 議員名が手入力修正されていた場合、姓名ふりがなの入力を受け付ける必要がある

            editDto.value.selectedCountryParliament = String(sendDto.parliamentOrganizationId);//TODO 衆議院と参議院は固定値になるようセット
            editDto.value.kokkaGinName = giinName6;
            editDto.value.kokkaGinNameKana = sendDto.politicianAllNameKana;

            // 資金管理団体指定初期化
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName6 + "を推薦・後援する政治活動";

            break;

        //Q7.代表者は地方の首長または地方議会議員の現職である
        case "7":
            editDto.value.organizationKbn = "5";//その他の政治団体

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            editDto.value.selectedCountryParliament = "0";//衆議院・参議院いずれでもない
            editDto.value.kokkaGinName = "";//国会議員ではない
            editDto.value.kokkaGinNameKana = "";//国会議員ではない
            editDto.value.selectParliamentOrCandidate = "1";//現職

            //入力内容によって切り替え
            let giinName7: string = "";

            if (sendDto.isNotFindParliamentMember) {
                //議員名に編集があった場合
                giinName7 = sendDto.parliamentMemberAlternativeText;
            } else {
                //議員名に編集がない場合
                giinName7 = sendDto.parliamentMemberName;
            }

            let gikaiName7: string = "";
            if (sendDto.isNotFindParliamentOrganization) {
                //議会名に編集があった場合
                gikaiName7 = sendDto.parliamentOrganizationAlternativeText;

            } else {
                //議会名に編集がない場合
                gikaiName7 = sendDto.parliamentOrganizationName;

            }
            // TODO 議員名が手入力修正されていた場合、姓名ふりがなの入力を受け付ける必要がある

            // 資金管理団体指定
            editDto.value.isFundsManageOrg = sendDto.isFundsManageOrg;

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName7 + "の政治活動";

            //資金管理団体指定のある時だけ入力窓を埋める
            if (editDto.value.isFundsManageOrg) {
                editDto.value.fundsManageOrgDelegateName = giinName7;
                editDto.value.parliamentName = gikaiName7;
                editDto.value.orgnozationPurpose = giinName7 + "が唯一保持する資金管理団体としての活動";
            }
            break;

        //Q8.代表者は地方の首長または地方議会議員の候補者である
        case "8":
            editDto.value.organizationKbn = "5";//その他の政治団体

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            editDto.value.selectedCountryParliament = "0";//参議院でも衆議院でもない
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            editDto.value.selectParliamentOrCandidate = "2";//候補者

            //入力によって切り替え
            let giinName8: string = "";
            if (sendDto.isNotFindPoliticianAll) {
                //政治家名に編集があった場合
                giinName8 = sendDto.politicianAllAlternativeText;
            } else {
                //政治家名に編集がない場合
                giinName8 = sendDto.politicianAllName;
            }

            let gikaiName8: string = "";
            if (sendDto.isNotFindParliamentOrganization) {
                //議会名に編集があった場合
                gikaiName8 = sendDto.parliamentOrganizationAlternativeText;

            } else {
                //議会名に編集がない場合
                gikaiName8 = sendDto.parliamentOrganizationName;
            }
            // TODO 議員名が手入力修正されていた場合、姓名ふりがなの入力を受け付ける必要がある

            // 資金管理団体指定
            editDto.value.isFundsManageOrg = sendDto.isFundsManageOrg;

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName8 + "の政治活動";

            //資金管理団体指定のある時だけ入力窓を埋める
            if (editDto.value.isFundsManageOrg) {
                editDto.value.fundsManageOrgDelegateName = giinName8;
                editDto.value.parliamentName = gikaiName8;
                editDto.value.orgnozationPurpose = giinName8 + "が唯一保持する資金管理団体としての活動";
            }

            break;

        //Q9.地方の首長または地方議会議員の現職または候補者を後援または推薦している
        case "9":
            editDto.value.organizationKbn = "5";//その他の政治団体

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            //入力によって切り替え
            let giinName9: string = "";
            if (sendDto.isNotFindPoliticianAll) {
                //政治家名に編集があった場合
                giinName9 = sendDto.politicianAllAlternativeText;
            } else {
                //政治家名に編集がない場合
                giinName9 = sendDto.politicianAllName;
            }

            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = giinName9 + "を推薦・後援する政治活動";

            break;

        //Q10.パーティの収益(の一部)が政治活動に使われ、かつ収入が10,000,000円である団体である
        case "10":
            editDto.value.organizationKbn = "4";//18条の2第1項団体

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";

            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = "政治活動に寄付を行っているかつ収支が法律の規定以上に大きいパーティの開催";
            break;

        //Q11.議員の後援・推薦はしていないが、政治的主張活動を継続的に行っている
        case "11":
            editDto.value.organizationKbn = "5";//その他の政治団体

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";
            // 政党の設立目的
            disablePurposeEdit.value = false;
            editDto.value.orgnozationPurpose = "";//初期化
            break;

        //Q12.政治団体の支部である
        case "12":
            editDto.value.organizationKbn = "6";//その他の政治団体の支部

            /* 設定しない項目を初期化 */
            editDto.value.isKokkaiGiinHonninKouhosha = false;
            editDto.value.isKokkaiGiinSuisen = false;
            editDto.value.activityArea = "2";
            //総務省に提出しないときは選択済選挙管理委員会にする
            acceptOrgnizationId.value = editDto.value.electionComitteeId;
            acceptOrgnizationCode.value = editDto.value.electionComitteeCode;
            acceptOrgnizationName.value = editDto.value.electionComitteeName;

            editDto.value.selectedCountryParliament = "0";
            editDto.value.kokkaGinName = "";
            editDto.value.kokkaGinNameKana = "";
            // 資金管理団体指定
            editDto.value.isFundsManageOrg = false;
            editDto.value.selectParliamentOrCandidate = "0";
            editDto.value.fundsManageOrgDelegateName = "";
            editDto.value.parliamentName = "";
            // 政党の設立目的
            disablePurposeEdit.value = true;//編集させません
            editDto.value.orgnozationPurpose = "政治団体支部としての政治活動";
            break;
    }

    //非表示
    isVisibleSelectPoliticalOrgnizationKbn.value = false;
}

/** キャンセル */
function onCancel() {
    alert("キャンセル");
}

///** 代表者 */
//const personManagerDelegate: Ref<PersonManagerInterface> = ref(new PersonManagerDto);

///** 会計責任者 */
//const personManagerAccountManager: Ref<PersonManagerInterface> = ref(new PersonManagerDto);

///** 会計職務代行者 */
//const personManagerAccountSupport: Ref<PersonManagerInterface> = ref(new PersonManagerDto);


///** 事務事務担当者2 */
//const personWorkser2: Ref<PersonWorkerInterface> = ref(new PersonWorkerDto);
///** 事務事務担当者3 */
//const personWorkser3: Ref<PersonWorkerInterface> = ref(new PersonWorkerDto);

////設立年月日
//const foundingNengappi: Ref<string> = ref("1980-01-01");

////新設政治団体名称
//const politicalOrgnozationName: Ref<string> = ref("");


//政治団体の目的編集フラグ
const disablePurposeEdit: Ref<boolean> = ref(true);

//機関誌発行
const hasBusinessOrgPublish: Ref<boolean> = ref(false);
// 広報活動
const hasBusinessPubRelation: Ref<boolean> = ref(false);
// パーティ開催
const hasBusinessHeldParty: Ref<boolean> = ref(false);
// 寄付のお願い
const hasBusinessPromoteDonation: Ref<boolean> = ref(false);

const hasBusinessOrgPublishText = "機関誌発行事業";
const hasBusinessPubRelationText = "広報事業";
const hasBusinessHeldPartyText = "政治団体への寄付をするパーティ開催";
const hasBusinessPromoteDonationText = "寄付を集める行為";

const businessTextOther: Ref<string> = ref("");


//政治団体の事業
const businessTextSelect = computed(() => {
    let tempText: string = "";
    if (tempText === undefined) {
        tempText = "";
    }

    //チェックされ、かつキーワードが入っていなかったら追加
    if (hasBusinessOrgPublish.value) {
        tempText = tempText + hasBusinessOrgPublishText + ",";
    }

    if (hasBusinessPubRelation.value) {
        tempText = tempText + hasBusinessPubRelationText + ",";
    }

    if (hasBusinessHeldParty.value) {
        tempText = tempText + hasBusinessHeldPartyText + ",";
    }
    if (hasBusinessPromoteDonation.value) {
        tempText = tempText + hasBusinessPromoteDonationText + ",";
    }
    return tempText;
});


/** 保存 */
function onSave() {
    alert("保存");
    //computedしている変数
    editDto.value.acceptOrgnizationId = acceptOrgnizationId.value;
    editDto.value.acceptOrgnizationCode = acceptOrgnizationCode.value;
    editDto.value.acceptOrgnizationName = acceptOrgnizationName.value;
    editDto.value.businessText = businessTextSelect.value + businessTextOther.value;

    //入力チェックを行う
    //(1)政党要件を満たす政党がチェックされた場合
    //a.政党名がデータべース政党名と同一でないこと(新規)

    //(2)政党支部がチェックされた場合
    //a.政党が保存政党から選択されていること
    //b.政党支部名が保存政党支部名と同一でないこと(新規)

    //(3)政治資金規正法第18条の2第1項の規定による政治団体→特定パーティを行う団体

    //(4)その他団体

    //(5)その他団体の支部
}

</script>
<template>
    <h1>政治団体設立届</h1>

    <!-- 政治団体 -->

    <div class="left-area">
        提出選挙管理委員会
    </div>
    <div class="right-area">
        <input type="number" v-model="editDto.electionComitteeCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.electionComitteeName" disabled="true" class="left-space name-input">
        <button class="left-space" @click="onSearchElectionCommition">選挙管理委員会検索</button>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        申請日
    </div>
    <div class="right-area">
        <input type="date" v-model="editDto.applicationNengappi">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        政治団体名称ふりがな
    </div>
    <div class="right-area">
        <input type="text" v-model="editDto.politicalOrgnozationNameKana" class="name-input" placeholder="政治団体ふりがな"><br>
    </div>
    <div class="clear-both"></div>

    <div class="left-area">
        政治団体の名称
    </div>
    <div class="right-area">
        <input type="text" v-model="editDto.politicalOrgnozationName" class="name-input" placeholder="政治団体名称">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        政治団体の住所(署名)
    </div>
    <div class="right-area">
        <button @click="onInputAddress">設定</button><br>
        <textarea v-model="signatureAddress" disabled="true"></textarea>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        代表者名(署名)
    </div>
    <div class="right-area">
        <input type="text" v-model="signatureDelegateName" disabled="true" class="name-input"><button
            @click="onSearchPersonManager(1)" class="left-space">設定</button>
    </div>
    <div class="clear-both"><br></div>

    <hr>
    <!-- 所属者登録 -->
    <div class="left-area">
        代表者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" v-model="editDto.personManagerDelegate.personManagerCode" disabled="true"
            class="code-input">
        <input type="text" v-model="editDto.personManagerDelegate.personManagerName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(1)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerDelegate" :is-editable="false" :is-in-parts="true">
        </PersonManager>
        <div class="left-area-in">
            選任年月日
        </div>
        <div>
            <input type="date" v-model="editDto.appointmentNengappiDelegate" class="name-input">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        会計責任者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" v-model="editDto.personManagerAccountManager.personManagerCode" disabled="true"
            class="code-input">
        <input type="text" v-model="editDto.personManagerAccountManager.personManagerName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(2)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerAccountManager" :is-editable="false" :is-in-parts="true">
        </PersonManager>
        <div class="left-area-in">
            選任年月日
        </div>
        <div>
            <input type="date" v-model="editDto.appointmentNengappiAccountManager" class="name-input">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        会計責任者の職務代行者
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" v-model="editDto.personManagerAccountSupport.personManagerCode" disabled="true"
            class="code-input">
        <input type="text" v-model="editDto.personManagerAccountSupport.personManagerName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchPersonManager(3)">ユーザ検索</button><br>
        <PersonManager :edit-dto="editDto.personManagerAccountSupport" :is-editable="false" :is-in-parts="true">
        </PersonManager>
        <div class="left-area-in">
            選任年月日
        </div>
        <div>
            <input type="date" v-model="editDto.appointmentNengappiAccountManagerSupport" class="name-input">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (任意)事務担当者2
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" v-model="editDto.personWorkser2.personWorkerCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.personWorkser2.personWorkerName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchPersonWorker(1)">ユーザ検索</button><br>
        <PersonWorker :edit-dto="editDto.personWorkser2" :is-editable="false" :is-in-parts="true"></PersonWorker>
        <div class="left-area-in">
            選任年月日
        </div>
        <div>
            <input type="date" v-model="editDto.appointmentNengappiWorker2" class="name-input">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (任意)事務担当者3
    </div>
    <div class="right-area">
        <div class="left-area-in">
            ユーザ
        </div>
        <input type="number" v-model="editDto.personWorkser3.personWorkerCode" disabled="true" class="code-input">
        <input type="text" v-model="editDto.personWorkser3.personWorkerName" disabled="true"
            class="left-space name-input">
        <button class="left-space" @click="onSearchPersonWorker(2)">ユーザ検索</button><br>
        <PersonWorker :edit-dto="editDto.personWorkser3" :is-editable="false" :is-in-parts="true"></PersonWorker>
        <div class="left-area-in">
            選任年月日
        </div>
        <div>
            <input type="date" v-model="editDto.appointmentNengappiWorker3" class="name-input">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        主たる事務所の所在地
    </div>
    <div class="right-area">
        <button @click="onInputAddress">住所入力</button><br>
        <ViewInputAddress :edit-dto="editDto.inputAddressDto"></ViewInputAddress>
    </div>
    <div class="clear-both"><br></div>

    <hr>

    <!-- 団体の区分・特性-->
    <div class="left-area">
        目的
    </div>
    <div class="right-area">
        別紙のとおり<button>設定</button>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        組織年月日
    </div>
    <div class="right-area">
        <input v-model="editDto.foundingNengappi" type="date">
        <br>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        政治団体の区分
    </div>
    <div class="right-area">
        <button @click="onSelectPoliticalOrgnizationKbn">政治団体区分関係一括処理(推奨)</button> <input type="checkbox"
            class="left-space " v-model="isUseInput">一括処理を使用しない<br>
        <input type="radio" v-model="editDto.organizationKbn" :value="1" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '1')">政党要件を満たす政党</span><br>
        <input type="radio" v-model="editDto.organizationKbn" :value="2" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '2')">政党の支部</span><br>
        <input type="radio" v-model="editDto.organizationKbn" :value="3" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '3')">政治資金団体</span><br>
        <input type="radio" v-model="editDto.organizationKbn" :value="4" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '4')">政治資金規正法第18条の2第1項の規定による政治団体</span><br>
        <input type="radio" v-model="editDto.organizationKbn" :value="5" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '5')">その他の政治団体</span><br>
        <input type="radio" v-model="editDto.organizationKbn" :value="6" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.organizationKbn === '6')">その他の政治団体の支部</span><br>
        <input type="checkbox" v-model="editDto.isKokkaiGiinHonninKouhosha" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.isKokkaiGiinHonninKouhosha)">政治資金規正法第19条の7第1項第1号に係る国会議員関係政治団体</span><br>
        <input type="checkbox" v-model="editDto.isKokkaiGiinSuisen" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.isKokkaiGiinSuisen)">政治資金規正法第19条の7第1項第2号に係る国会議員関係政治団体</span><br>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        主たる活動地域
    </div>
    <div class="right-area">
        <input type="radio" :disabled="isUseInput" v-model="editDto.activityArea" :value="1"><span
            :class="inputSelectDisplayBold(editDto.activityArea === '1')">2以上の地域で活動する団体</span><br>
        <input type="radio" :disabled="isUseInput" v-model="editDto.activityArea" :value="2"><span
            :class="inputSelectDisplayBold(editDto.activityArea === '2')">同一の都道府県(提出選挙管理委員会管区内)
        </span>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        収納・管理先
    </div>
    <div class="right-area">
        <input type="number" v-model="acceptOrgnizationCode" disabled="true" class="code-input">
        <input type="text" v-model="acceptOrgnizationName" disabled="true" class="left-space name-input">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        国会議員関係団体
    </div>
    <div class="right-area">
        <input type="radio" :disabled="isUseInput" :value="1" v-model="editDto.selectedCountryParliament"><span
            :class="inputSelectDisplayBold(editDto.selectedCountryParliament === '1')">衆議院</span><input type="radio"
            disabled="true" :value="2" v-model="editDto.selectedCountryParliament" class="left-space"><span
            :class="inputSelectDisplayBold(editDto.selectedCountryParliament === '2')">参議院</span><br>
        <input type="text" v-model="editDto.kokkaGinNameKana" placeholder="国会議員姓名ふりがな" :disabled="isUseInput"><br>
        <input type="text" v-model="editDto.kokkaGinName" placeholder="国会議員姓名" :disabled="isUseInput">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        資金管理団体
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="editDto.isFundsManageOrg" :disabled="isUseInput"><span
            :class="inputSelectDisplayBold(editDto.isFundsManageOrg)">資金管理団体である</span><br>
        <input type="radio" v-model="editDto.selectParliamentOrCandidate" :disabled="isUseInput" :value="1"><span
            :class="inputSelectDisplayBold(editDto.selectParliamentOrCandidate === '1')">現職</span>
        <input type="radio" v-model="editDto.selectParliamentOrCandidate" :disabled="isUseInput" :value="2"
            class="left-space"><span
            :class="inputSelectDisplayBold(editDto.selectParliamentOrCandidate === '2')">候補者</span><br>

        <div class="left-area-in">
            公職の種類
        </div>
        <div>
            <input type="text" v-model="editDto.parliamentName" :disabled="isUseInput">
        </div>

        <div class="left-area-in">
            届出者姓名
        </div>
        <div>
            <input type="text" v-model="editDto.fundsManageOrgDelegateName" :disabled="isUseInput">
        </div>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        課税上の優遇措置の適用の有無
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="editDto.hasTaxBenefits">適用あり
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        支部の有無
    </div>
    <div class="right-area">
        <input type="checkbox" v-model="editDto.hasBranch">支部あり
    </div>
    <div class="clear-both"><br></div>

    <hr>
    <h2>(必要な規約)</h2>

    <div class="left-area">
        文書タイトル
    </div>
    <div class="right-area">
        {{ editDto.politicalOrgnozationName }} 政治団体規約
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        名称及び所在地
    </div>
    <div class="right-area">
        第１条：本会は、&nbsp; {{ editDto.politicalOrgnozationName }}&nbsp;と称し、主たる事務所を下記住所ににおく。<br>
        {{ signatureAddress }}
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        目的
    </div>
    <div class="right-area">
        第２条：本会は、<input type="text" v-model="editDto.orgnozationPurpose"
            :disabled="disablePurposeEdit">を本来の目的とし、あわせて会員相互の親睦を深めることを目的
        とする。
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        事業
    </div>
    <div class="right-area">
        第３条：本会は、前条の目的を達成するため次の事業を行う。<br>
        <input type="text" v-model="businessTextSelect" style="width: 75%;"><br>
        <div class="left-area-in">
            ↑入力補助↑
        </div>
        <div class="right-area">
            <input type="checkbox" v-model="hasBusinessOrgPublish" class="left-space">機関誌発行事業
            <input type="checkbox" v-model="hasBusinessPubRelation" class="left-space">広報事業
            <input type="checkbox" v-model="hasBusinessHeldParty" class="left-space">政治団体への寄付をするパーティ開催
            <input type="checkbox" v-model="hasBusinessPromoteDonation" class="left-space">寄付を集める行為
        </div>
         <input type="text" v-model="businessTextOther" style="width: 75%;" placeholder="その他の事業をフリーで入力">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        会員
    </div>
    <div class="right-area">
        第４条：本会は、第２条の目的に賛同し、入会の意思(書面・電磁記録)を提出した者をもって会員とする。
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        役員
    </div>
    <div class="right-area">
        第５条：本会に次の役員をおく。<br>
        代表者・会計責任者・会計職務代行者<input type="text" v-model="editDto.irregularPosts">
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (役員の選出及び任期)
    </div>
    <div class="right-area">
        第６条：
        <ol>
            <li>役員は、総会において選出する。</li>
            <li>役員の任期は１年とする。ただし、再任を妨げない。</li>
        </ol>

    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (会議)
    </div>
    <div class="right-area">
        第７条：
        <ol>
            <li>会長は、毎年１回の通常総会、その他必要に応じて臨時総会を招集する。</li>
            <li>会長は、必要に応じ役員会を招集する。</li>
        </ol>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (経費)
    </div>
    <div class="right-area">
        第８条：本会の経費は、会費&nbsp;<select v-model="editDto.paymentCycleKbn">
            <option>1年</option>
            <option>1か月</option>
            <option>半年</option>
            <option>なし</option>
        </select><input type="number" v-model="editDto.membershipFee" class="left-space input-number">、寄附金その他の収入をもって当てる。
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (会計年度及び会計監査)
    </div>
    <div class="right-area">
        第９条：
        <ol>
            <li>本会の会計年度は、毎年１月１日から１２月３１日までとする。</li>
            <li>会計責任者は、本会の経理につき年１回監事による監査を受け、その監査意見書を付して総会に報告する。</li>
        </ol>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (規約の改廃)
    </div>
    <div class="right-area">
        第10条：本規約の改廃は、総会において決定する。
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (補則)
    </div>
    <div class="right-area">
        第11条：本規約に定めのない事項については、役員会で決定する。
        <textarea v-model="editDto.addArticleContent" placeholder="あればその他追加条文をフリーで入力"></textarea>
    </div>
    <div class="clear-both"><br></div>

    <div class="left-area">
        (附則)
    </div>
    <div class="right-area">
        第11条：本規約は、{{ editDto.foundingNengappi }}より実施する。
    </div>
    <div class="clear-both"><br></div>

    <!-- 選挙管理委員会検索コンポーネント -->
    <div v-if="isVisibleSearchElectionCommision" class="overBackground"></div>
    <div v-if="isVisibleSearchElectionCommision">
        <div class="overComponent">
            <SearchElectionCommission :isEditable="false"
                @send-cancel-search-election-commission-least="recieveCancelSearchElectionCommissionLeast"
                @send-election-commission-least-interface="recieveSearchElectionCommissionLeastInterface">
            </SearchElectionCommission>

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

    <!-- 責任者検索コンポーネント -->
    <div v-if="isVisibleSearchPersonManager" class="overBackground"></div>
    <div v-if="isVisibleSearchPersonManager">
        <div class="overComponent">
            <SearchPersonManager :isEditable="false" :call-index="callManagerIndex"
                @send-cancel-search-person-manager="recieveCancelSearchPersonManager"
                @send-person-manager-interface="recieveSearchPersonManagerInterface">
            </SearchPersonManager>
        </div>
    </div>

    <!-- 担当者検索コンポーネント -->
    <div v-if="isVisibleSearchPersonWorker" class="overBackground"></div>
    <div v-if="isVisibleSearchPersonWorker">
        <div class="overComponent">
            <SearchPersonWorker :isEditable="false" :call-index="callWorkerIndex"
                @send-cancel-search-person-worker="recieveCancelSearchPersonWorker"
                @send-person-worker-interface="recieveSearchPersonWorkerInterface">
            </SearchPersonWorker>
        </div>
    </div>

    <!-- 政治団体区分指定コンポーネント -->
    <div v-if="isVisibleSelectPoliticalOrgnizationKbn" class="overBackground"></div>
    <div v-if="isVisibleSelectPoliticalOrgnizationKbn">
        <div class="overComponent">
            <SelectPoliticalOrgnizationKbn
                @send-cancel-select-political-organization-kbn="recieveCancelSelectPoliticalOrgnizationKbn"
                @send-select-political-organization-kbn-interface="recieveSelectPoliticalOrgnizationKbnInterface">
            </SelectPoliticalOrgnizationKbn>
        </div>
    </div>

    <hr>

    <div class="footer">
        <button @click="onCancel" class="footer-button">キャンセル</button>
        <button @click="onSave" class="footer-button">保存</button>
    </div>

</template>

<style scoped></style>
