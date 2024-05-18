import CallingItemEntity from "../../entity/callingItemEntity";

export default class CallingItemDto extends CallingItemEntity{

    /** 書証読み取り行 */
    readLine:number;

    constructor(){
        super();
        this.readLine = 0;
    }
}