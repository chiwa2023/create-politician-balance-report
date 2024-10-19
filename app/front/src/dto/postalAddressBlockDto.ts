import AddressBlockDto from "./addressBlockDto";
import AddressPostalcodeDto from "./addressPostalcodeDto";


export default interface PostalAddressBlockInterface {

    /** 番地情報リスト */
    listBlock: AddressBlockDto[];

    /** 郵便番号リスト */
    listPostalcode: AddressPostalcodeDto[];

}

export default class PostalAddressBlockDto implements PostalAddressBlockInterface {

    /** 番地情報リスト */
    listBlock: AddressBlockDto[];

    /** 郵便番号リスト */
    listPostalcode: AddressPostalcodeDto[];

    constructor() {
        this.listBlock = [];
        this.listPostalcode = [];
    }
}