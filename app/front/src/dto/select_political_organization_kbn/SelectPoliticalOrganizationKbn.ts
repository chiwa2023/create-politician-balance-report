
/**
 * 政治団体区分選択情報Dto
 */
export default class SelectPoliticalOrganizationKbnDto {

    /** 政治団体代替指定 */
    organizationKbn: string;

    /** 資金管理団体指定 */
    isFundsManageOrg: boolean;

    /** 政治団体Id */
    politicalOrganizationId: number;

    /** 政治団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治団体名称 */
    politicalOrganizationName: string;

    /** 政治団体検索不能 */
    isNotFindPoliticalOrganization: boolean;

    /** 政治団体代替指定 */
    politicalOrganizationAlternativeText: string;

    /** 政党Id */
    politicalPartyId: number;

    /** 政党同一識別コード */
    politicalPartyCode: number;

    /** 政党名称 */
    politicalPartyName: string;

    /** 政党検索不能 */
    isNotFindPoliticalParty: boolean;

    /** 政党代替指定 */
    politicalPartyAlternativeText: string;

    /** 議員Id */
    parliamentMemberId: number;

    /** 議員同一識別コード */
    parliamentMemberCode: number;

    /** 議員名称 */
    parliamentMemberName: string;

    /** 議員名称かな */
    parliamentMemberNameKana: string;

    /** 議員検索不能 */
    isNotFindParliamentMember: boolean;

    /** 議員代替指定 */
    parliamentMemberAlternativeText: string;

    /** 政治家Id */
    politicianAllId: number;

    /** 政治家同一識別コード */
    politicianAllCode: number;

    /** 政治家名称 */
    politicianAllName: string;

    /** 政治家名称 */
    politicianAllNameKana: string;

    /** 政治家検索不能 */
    isNotFindPoliticianAll: boolean;

    /** 政治家代替指定 */
    politicianAllAlternativeText: string;

    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    /** 議会検索不能 */
    isNotFindParliamentOrganization: boolean;

    /** 議会代替指定 */
    parliamentOrganizationAlternativeText: string;

    /** 議会選挙区Id */
    electionDistrictId: number;

    /** 議会選挙区同一識別コード */
    electionDistrictCode: number;

    /** 議会選挙区代替指定 */
    electionDistrictName: string;

    /** 議会選挙区検索不能 */
    isNotFindElectionDistrict: boolean;

    /** 議会選挙区代替指定 */
    electionDistrictAlternativeText: string;



    /**
     * コンストラクタ
     */
    constructor() {
        const initString: string = "";
        const initNumber: number = 0;
        const initBoolean: boolean = false;

        this.organizationKbn = initString;
        this.isFundsManageOrg = initBoolean;
        this.politicalOrganizationId = initNumber;
        this.politicalOrganizationCode = initNumber;
        this.politicalOrganizationName = initString;
        this.politicalPartyId = initNumber;
        this.politicalPartyCode = initNumber;
        this.politicalPartyName = initString;
        this.parliamentMemberId = initNumber;
        this.parliamentMemberCode = initNumber;
        this.parliamentMemberName = initString;
        this.parliamentMemberNameKana = initString;
        this.politicianAllId = initNumber;
        this.politicianAllCode = initNumber;
        this.politicianAllName = initString;
        this.politicianAllNameKana = initString;
        this.parliamentOrganizationId = initNumber;
        this.parliamentOrganizationCode = initNumber;
        this.parliamentOrganizationName = initString;
        this.electionDistrictId = initNumber;
        this.electionDistrictCode = initNumber;
        this.electionDistrictName = initString;
        this.isNotFindPoliticalOrganization = initBoolean;
        this.politicalOrganizationAlternativeText = initString;
        this.isNotFindPoliticalParty = initBoolean;
        this.politicalPartyAlternativeText = initString;
        this.isNotFindParliamentMember = initBoolean;
        this.parliamentMemberAlternativeText = initString;
        this.isNotFindPoliticianAll = initBoolean;
        this.politicianAllAlternativeText = initString;
        this.isNotFindParliamentOrganization = initBoolean;
        this.parliamentOrganizationAlternativeText = initString;
        this.isNotFindElectionDistrict = initBoolean;
        this.electionDistrictAlternativeText = initString;
    }
}