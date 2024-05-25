import AddressBlockDto from "./addressBlockDto";
import AddressPostalcodeDto from "./addressPostalcodeDto";

export default class PostalAddressBlockDto {
    
    /** 番地情報リスト */
    listBlock: AddressBlockDto[];

    /** 郵便番号リスト */
    listPostalcode: AddressPostalcodeDto[];

    constructor() {
        this.listBlock = [];
        this.listPostalcode = [];
    }
}