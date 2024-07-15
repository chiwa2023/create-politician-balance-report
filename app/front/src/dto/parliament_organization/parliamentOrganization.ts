export default interface ParliamentOrganizationInterface {
    /** 議会Id */
    parliamentOrganizationId: number;

    /** 議会同一識別コード */
    parliamentOrganizationCode: number;

    /** 議会名称 */
    parliamentOrganizationName: string;

    // eslint-disable-next-line semi
}

export default class ParliamentOrganizationDto implements ParliamentOrganizationInterface {

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
    constructor(impl?: ParliamentOrganizationInterface) {

        const initString: string = "";
        const initNumber: number = 0;

        if (impl !== undefined) {
            this.parliamentOrganizationId = impl.parliamentOrganizationId;
            this.parliamentOrganizationCode = impl.parliamentOrganizationCode;
            this.parliamentOrganizationName = impl.parliamentOrganizationName;

        } else {
            this.parliamentOrganizationId = initNumber;
            this.parliamentOrganizationCode = initNumber;
            this.parliamentOrganizationName = initString;
        }
    }
}