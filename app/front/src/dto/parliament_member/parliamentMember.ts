export default interface ParliamentMemberInterface {
    /** 議員Id */
    parliamentMemberId: number;

    /** 議員同一識別コード */
    parliamentMemberCode: number;

    /** 議員名称 */
    parliamentMemberName: string;

        /** 議員名称かな */
        parliamentMemberNameKana: string;

    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    /** 議会選挙区Id */
    electionDistrictId: number;

    /** 議会選挙区同一識別コード */
    electionDistrictCode: number;

    /** 議会選挙区名称 */
    electionDistrictName: string;

    // eslint-disable-next-line semi
}

export default class ParliamentMemberDto implements ParliamentMemberInterface {
    /** 議員Id */
    parliamentMemberId: number;

    /** 議員同一識別コード */
    parliamentMemberCode: number;

    /** 議員名称 */
    parliamentMemberName: string;

        /** 議員名称かな */
        parliamentMemberNameKana: string;

    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    /** 議会選挙区Id */
    electionDistrictId: number;

    /** 議会選挙区同一識別コード */
    electionDistrictCode: number;

    /** 議会選挙区名称 */
    electionDistrictName: string;

    /**
     * コンストラクタ
     * @param impl インターフェイス実装 
     */
    constructor(impl?: ParliamentMemberInterface) {

        const initString: string = "";
        const initNumber: number = 0;

        if (impl !== undefined) {
            this.parliamentMemberId = impl.parliamentMemberId;
            this.parliamentMemberCode = impl.parliamentMemberCode;
            this.parliamentMemberName = impl.parliamentMemberName;
            this.parliamentMemberNameKana = impl.parliamentMemberNameKana;
            this.parliamentOrganizationId = impl.parliamentOrganizationId;
            this.parliamentOrganizationCode = impl.parliamentOrganizationCode;
            this.parliamentOrganizationName = impl.parliamentOrganizationName;
            this.electionDistrictId = impl.electionDistrictId;
            this.electionDistrictCode = impl.electionDistrictCode;
            this.electionDistrictName = impl.electionDistrictName;
        } else {
            this.parliamentMemberId = initNumber;
            this.parliamentMemberCode = initNumber;
            this.parliamentMemberName = initString;
            this.parliamentMemberNameKana = initString;
            this.parliamentOrganizationId = initNumber;
            this.parliamentOrganizationCode = initNumber;
            this.parliamentOrganizationName = initString;
            this.electionDistrictId = initNumber;
            this.electionDistrictCode = initNumber;
            this.electionDistrictName = initString;
        }
    }
}