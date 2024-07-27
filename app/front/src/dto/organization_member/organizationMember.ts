import PersonWorkerInterface from "../../dto/person_worker/personWorkerDto";

export default class OrganizationMember {

    /** 政治団体Id */
    politicalOrganizationId: number;

    /** 政治団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治団体名称 */
    politicalOrganizationName: string;

    /** 仮登録該否 */
    isVirtual: boolean;

    /** 組織メンバー */
    listMember: PersonWorkerInterface[];

    constructor() {
        const INIT_NUMBER = 0;
        const INIT_STRING = "";
        const INIT_BOOLEAN = false;

        this.politicalOrganizationId = INIT_NUMBER;
        this.politicalOrganizationCode = INIT_NUMBER;
        this.politicalOrganizationName = INIT_STRING;
        this.isVirtual = INIT_BOOLEAN;

        this.listMember = [];
    }
}