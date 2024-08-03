import InputAddressDto from "../Input_address/inputAddressDto";
import PersonManagerInterface from "../person_manager/personManager";
import PersonManagerDto from "../person_manager/personManager";
import PersonWorkerInterface from "../person_worker/personWorkerDto";
import PersonWorkerDto from "../person_worker/personWorkerDto";



export default class AddPoliticianOrgnizationDto {

    // 選挙管理委員会
    /** 提出選挙管理委員会Id */
    electionComitteeId: number;
    /** 提出選挙管理委員会同一識別コード */
    electionComitteeCode: number;
    /** 提出選挙管理委員会名称 */
    electionComitteeName: string;

    /** 住所情報受け取り */
    inputAddressDto: InputAddressDto;

    // 政治団体属性
    /** 新設政治団体名称　*/
    politicalOrgnozationName: string;
    /** 新設政治団体名称かな　*/
    politicalOrgnozationNameKana: string;
    /** 設立年月日　*/
    foundingNengappi: string;
    /** 申請日　*/
    applicationNengappi: string;
    /** 団体区分 */
    organizationKbn: string;
    /** 主たる活動地域 */
    activityArea: string;
    /**  課税優遇あり */
    hasTaxBenefits: boolean;
    /**  支部あり */
    hasBranch: boolean;

    // 政治団体属性(国会議員)
    /** 国会議員条項(代表者が現職または候補者) */
    isKokkaiGiinHonninKouhosha: boolean;
    /** 国会議員条項(後援・支援) */
    isKokkaiGiinSuisen: boolean;
    /** 衆議院・参議院の別 */
    selectedCountryParliament: string;
    /** 国会議員の本人または候補者の姓名 */
    kokkaGinName: string;
    /** 国会議員の本人または候補者の姓名ふりがな */
    kokkaGinNameKana: string;

    // 政治団体属性(資金管理団体)
    /** 資金管理団体指定 */
    isFundsManageOrg: boolean;
    /** 資金管理団体 現職候補者の別 */
    selectParliamentOrCandidate: string;
    /** 資金管理団体 届出者 */
    fundsManageOrgDelegateName: string;
    /** 資金管理団体 役職 */
    parliamentName: string;

    // 提出後の管理選管
    /** 受領先Id */
    acceptOrgnizationId: number;
    /** 受領先同一識別コード */
    acceptOrgnizationCode: number;
    /** 受領先名称 */
    acceptOrgnizationName: string;

    // 組織内責任者
    /** 代表者 */
    personManagerDelegate: PersonManagerInterface;
    /** 会計責任者 */
    personManagerAccountManager: PersonManagerInterface;
    /** 会計職務代行者 */
    personManagerAccountSupport: PersonManagerInterface;

    // 組織内作業者
    /** 事務事務担当者2 */
    personWorkser2: PersonWorkerInterface;
    /** 事務事務担当者3 */
    personWorkser3: PersonWorkerInterface;

    //それぞれの選任年月日
    /**  選任年月日(代表者) */
    appointmentNengappiDelegate: string;
    /**  選任年月日(会計責任者) */
    appointmentNengappiAccountManager: string;
    /**  選任年月日(会計責任者職務代行者) */
    appointmentNengappiAccountManagerSupport: string;
    /**  選任年月日(作業者2) */
    appointmentNengappiWorker2: string;
    /**  選任年月日(作業者3) */
    appointmentNengappiWorker3: string;

    //規約追加情報
    /** 設立の目的 */
    orgnozationPurpose: string;
    /** 法定以外の役職 */
    irregularPosts: string;
    /** 会費支払い期間 */
    paymentCycleKbn: string;
    /** 会費実額 */
    membershipFee: number;
    /** 追加条文 */
    addArticleContent: string;
    /** 事業内容列挙 */
    businessText: string;

    constructor() {
        const INIT_STRING: string = "";
        const INIT_NUMBER: number = 0;
        const INIT_DATE: string = "1980-01-01";
        const INIT_BOOLEAN: boolean = false;


        //提出選挙管理委員会
        this.electionComitteeId = INIT_NUMBER
        this.electionComitteeCode = INIT_NUMBER
        this.electionComitteeName = INIT_STRING

        //格納／収納先
        this.acceptOrgnizationId = INIT_NUMBER;
        this.acceptOrgnizationCode = INIT_NUMBER;
        this.acceptOrgnizationName = INIT_STRING;

        this.organizationKbn = INIT_STRING;
        this.activityArea = INIT_STRING;
        this.foundingNengappi = INIT_DATE;
        this.applicationNengappi = INIT_DATE;
        this.politicalOrgnozationName = INIT_STRING;
        this.politicalOrgnozationNameKana = INIT_STRING;
        this.orgnozationPurpose = INIT_STRING;
        this.irregularPosts = INIT_STRING;
        this.paymentCycleKbn = INIT_STRING;
        this.membershipFee = INIT_NUMBER;
        this.addArticleContent = INIT_STRING;
        this.businessText = INIT_STRING;

        this.isKokkaiGiinHonninKouhosha = INIT_BOOLEAN;
        this.isKokkaiGiinSuisen = INIT_BOOLEAN;
        this.selectedCountryParliament = INIT_STRING;
        this.kokkaGinName = INIT_STRING;
        this.kokkaGinNameKana = INIT_STRING;
        this.isFundsManageOrg = INIT_BOOLEAN;
        this.selectParliamentOrCandidate = INIT_STRING;
        this.fundsManageOrgDelegateName = INIT_STRING;
        this.parliamentName = INIT_STRING;

        this.hasTaxBenefits = INIT_BOOLEAN;
        this.hasBranch = INIT_BOOLEAN;

        //選任年月日
        this.appointmentNengappiDelegate = INIT_STRING;
        this.appointmentNengappiAccountManager = INIT_STRING;
        this.appointmentNengappiAccountManagerSupport = INIT_STRING;
        this.appointmentNengappiWorker2 = INIT_STRING;
        this.appointmentNengappiWorker3 = INIT_STRING;

        //住所
        this.inputAddressDto = new InputAddressDto();
        // 責任者
        this.personManagerDelegate = new PersonManagerDto();
        this.personManagerAccountManager = new PersonManagerDto();
        this.personManagerAccountSupport = new PersonManagerDto();
        // 作業者
        this.personWorkser2 = new PersonWorkerDto();
        this.personWorkser3 = new PersonWorkerDto();


    }

}