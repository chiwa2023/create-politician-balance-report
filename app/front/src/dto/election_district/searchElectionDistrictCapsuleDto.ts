import AbstactCapsuleDto from "../abstactCapsuleDto";

export default class SearchElectionDistrictCapsuleDto extends AbstactCapsuleDto{

    /** 検索語 */    
    searchWords:string;

    constructor(){
        super();
        this.searchWords = "";
    }
}