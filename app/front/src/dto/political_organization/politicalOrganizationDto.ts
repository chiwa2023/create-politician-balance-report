export default interface PoliticalOrganizationInterface {
    /** 政治団体Id */
    politicalOrganizationId: number;

    /** 政治団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治団体名称 */
    politicalOrganizationName: string;

    // eslint-disable-next-line semi
}

export default class PoliticalOrganizationDto implements PoliticalOrganizationInterface {

    /** 政治団体d */
    politicalOrganizationId: number;

    /** 政治団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治団体名称 */
    politicalOrganizationName: string;


    /**
     * コンストラクタ
     * @param impl インターフェイス実装
     */
    constructor(impl?: PoliticalOrganizationInterface) {

        const initString: string = "";
        const initNumber: number = 0;

        if (impl !== undefined) {
            this.politicalOrganizationId = impl.politicalOrganizationId;
            this.politicalOrganizationCode = impl.politicalOrganizationCode;
            this.politicalOrganizationName = impl.politicalOrganizationName;
        }
        else {
            this.politicalOrganizationId = initNumber;
            this.politicalOrganizationCode = initNumber;
            this.politicalOrganizationName = initString;
        }
    }
}