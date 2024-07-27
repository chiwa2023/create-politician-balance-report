import PersonManagerInterface from "../person_manager/personManager";
import PersonManagerDto from "../person_manager/personManager";
import RecognizeTelephonCodeDto from "../user_account/recognizeTelephonCodeDto";

class StartManagePoliticalOrganizationDto {

    /** 政治団体Id */
    politicalOrganizationId: number;

    /** 政治団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治団体名称 */
    politicalOrganizationName: string;

    /** ログイン中の責任者 */
    personManagerDto: PersonManagerInterface;

    /** ログイン中の責任者政治団体内役割区分 */
    roleOrganizationKbn: number;

    /** ログイン中の責任者政治団体内役割区分表示 */
    roleOrganizationKbnText: string;

    /** 代表者承認該否 */
    isAcceptDelegate: boolean;

    /** 会計責任者承認該否 */
    isAcceptAccountManager: boolean;

    /** 会計責任者職務代行者承認該否 */
    isAcceptAccountManagerSupport: boolean;

    /** 電話認識コード */
    recognizeTelephonCodeDto: RecognizeTelephonCodeDto;

    /** 責任者(代表者) */
    personManagerDelegate: PersonManagerInterface;

    /** 責任者(代表者) */
    personManagerAccountManager: PersonManagerInterface;

    /** 責任者(代表者) */
    personManagerAccountManagerSupport: PersonManagerInterface;

    constructor() {
        const initString: string = "";
        const initNumber: number = 0;
        const initBoolean: boolean = false;

        //TODO Interfaceとセットにする
        this.politicalOrganizationId = initNumber;
        this.politicalOrganizationCode = initNumber;
        this.politicalOrganizationName = initString;
        this.personManagerDto = new PersonManagerDto();
        this.roleOrganizationKbn = initNumber;
        this.roleOrganizationKbnText = initString;
        this.isAcceptDelegate = initBoolean;
        this.isAcceptAccountManager = initBoolean;
        this.isAcceptAccountManagerSupport = initBoolean;
        this.recognizeTelephonCodeDto = new RecognizeTelephonCodeDto();
        this.personManagerDelegate = new PersonManagerDto();
        this.personManagerAccountManager = new PersonManagerDto();
        this.personManagerAccountManagerSupport = new PersonManagerDto();
    }
}

export { StartManagePoliticalOrganizationDto }