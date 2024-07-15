export default interface ElectionCommissionLeastInterface {
    /** 選挙管理委員会Id */
    electionCommissionId: number;

    /** 選挙管理委員会同一識別コード */
    electionCommissionCode: number;

    /** 選挙管理委員会名称 */
    electionCommissionName: string;

    // eslint-disable-next-line semi
}

export default class ElectionCommissionLeastDto implements ElectionCommissionLeastInterface {
    /** 選挙管理委員会Id */
    electionCommissionId: number;

    /** 選挙管理委員会同一識別コード */
    electionCommissionCode: number;

    /** 選挙管理委員会名称 */
    electionCommissionName: string;

    constructor() {
        this.electionCommissionId = 0;
        this.electionCommissionCode = 0;
        this.electionCommissionName = "";
    }
}