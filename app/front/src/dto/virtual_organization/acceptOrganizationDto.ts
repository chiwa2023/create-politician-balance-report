import PersonWorkerInterface from "../person_worker/personWorkerDto";
import PersonWorkerDto from "../person_worker/personWorkerDto";
import RecognizeTelephonCodeDto from "../user_account/recognizeTelephonCodeDto";

export default class AcceptOrganizationDto {

    /** 仮想政治団体Id */
    virtualOrganizationId: number;

    /** 仮想政治団体同一識別コード */
    virtualOrganizationCode: number;

    /** 仮想政治団体名称 */
    virtualOrganizationName: string;

    /** 招待者 */
    personPropose: PersonWorkerInterface;

    /** 承認者 */
    personAccept: PersonWorkerInterface;

    /** 電話認識コード */
    recognizeTelephonCodeDto: RecognizeTelephonCodeDto;


    constructor() {
        const INIT_NUMBER = 0;
        const INIT_STRING = "";

        this.virtualOrganizationId = INIT_NUMBER;
        this.virtualOrganizationCode = INIT_NUMBER;
        this.virtualOrganizationName = INIT_STRING;

        this.personPropose = new PersonWorkerDto();
        this.personAccept = new PersonWorkerDto();

        this.recognizeTelephonCodeDto = new RecognizeTelephonCodeDto();

    }

}