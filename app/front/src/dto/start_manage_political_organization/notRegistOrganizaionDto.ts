import ElectionCommissionLeastInterface from "../election_commission/electionCommissionDto";
import ElectionCommissionLeastDto from "../election_commission/electionCommissionDto";
import SaveStorageResultDto from "../storage/saveStorageResultDto";

export default interface NotRegistOrganizaionInterface {

        /** 選挙管理委員会最小限情報 */
        electionCommissionLeastDto: ElectionCommissionLeastInterface;

        /** 書証情報 */
        saveStorageResultDto: SaveStorageResultDto;
    
        /** 政治団体名称 */
        politicalOrganizationName: string;
    
}

export default class NotRegistOrganizaionDto implements NotRegistOrganizaionInterface {

    /** 選挙管理委員会最小限情報 */
    electionCommissionLeastDto: ElectionCommissionLeastInterface;

    /** 書証情報 */
    saveStorageResultDto: SaveStorageResultDto;

    /** 政治団体名称 */
    politicalOrganizationName: string;

    constructor() {

        this.electionCommissionLeastDto = new ElectionCommissionLeastDto;
        this.saveStorageResultDto = new SaveStorageResultDto();
        this.politicalOrganizationName = "";

    }

}
