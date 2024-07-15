import AbstactCapsuleDto from "../abstactCapsuleDto";

export default class SearchPersonWorkerCapsuleDto extends AbstactCapsuleDto{

    /** 検索語 */    
    searchWords:string;

    constructor(){
        super();
        this.searchWords = "";
    }
}