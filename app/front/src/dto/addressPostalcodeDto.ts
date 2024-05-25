export default class AddressPostalcodeDto {

    /** 郵便番号 */
    postalcode: string;

    /** 郵便番号住所 */
    addressName: string;

    /** 丁目表記有無 */
    isChoume: boolean;

    /** 番地表記有無1 */
    isPrc1: boolean;

    /** 番地表記有無2 */
    isPrc2: boolean;

    /** 番地表記有無3 */
    isPrc3: boolean;


    constructor(){
     /** 郵便番号 */
     this.postalcode="";

     /** 郵便番号住所 */
     this.addressName="";
 
     /** 丁目表記有無 */
     this.isChoume=true;
 
     /** 番地表記有無1 */
     this.isPrc1=true;
 
     /** 番地表記有無2 */
     this.isPrc2=true;
 
     /** 番地表記有無3 */
     this.isPrc3=true;
    }
}