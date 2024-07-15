export default interface ElectionDistrictInterface {
    /** 議会選挙区Id */
    electionDistrictnId: number;

    /** 議会選挙区同一識別コード */
    electionDistrictCode: number;

    /** 議会選挙区会名称 */
    electionDistrictName: string;

    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    // eslint-disable-next-line semi
}

export default class ElectionDistrictDto implements ElectionDistrictInterface {
    /** 議会選挙区Id */
    electionDistrictId: number;

    /** 議会選挙区同一識別コード */
    electionDistrictCode: number;

    /** 議会選挙区名称 */
    electionDistrictName: string;

    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    /**
     * コンストラクタ
     * @param impl インターフェイス実装 
     */
    constructor(impl?: ElectionDistrictInterface) {

        const initString: string = "";
        const initNumber: number = 0;

        if (impl !== undefined) {
            this.electionDistrictId = impl.electionDistrictId;
            this.electionDistrictCode = impl.electionDistrictCode;
            this.electionDistrictName = impl.electionDistrictName;
            this.parliamentOrganizationId = impl.parliamentOrganizationId;
            this.parliamentOrganizationCode = impl.parliamentOrganizationCode;
            this.parliamentOrganizationName = impl.parliamentOrganizationName;

        } else {
            this.electionDistrictId = initNumber;
            this.electionDistrictCode = initNumber;
            this.electionDistrictName = initString;
            this.parliamentOrganizationId = initNumber;
            this.parliamentOrganizationCode = initNumber;
            this.parliamentOrganizationName = initString;

        }
    }
}