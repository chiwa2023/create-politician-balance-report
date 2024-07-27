import PersonWorkerInterface from "../person_worker/personWorkerDto";

export default interface PersonManagerInterface extends PersonWorkerInterface {

    /** 責任者Id */
    personManagerId: number;
    /** 責任者同一識別コード */
    personManagerCode: number;
    /** 責任者名称 */
    personManagerName: string;

    /** 姓名の姓 */
    firstName: string;
    /** 姓名の姓ふりがな */
    firstNameKana: string;
    /** 姓名の名 */
    lastName: string;
    /** 姓名の名かな */
    lastNameKana: string;
    /** ミドルネーム */
    middleName: string;
    /** ミドルネームふりがな */
    middleNameKana: string;

    /** 電話番号市外局番 */
    tel1: string;
    /** 電話番号局番 */
    tel2: string;
    /** 電話番号番号 */
    tel3: string;

    /** 郵便番号1 */
    postalcode1: string;
    /** 郵便番号2 */
    postalcode2: string;
    /** 住所郵便番号まで1 */
    addressPostal: string;
    /** 住所番地 */
    addressBlock: string;
    /** 住所建物 */
    addressBuilding: string;

    /** 生年月日 */
    birtday: string;

}

export default class PersonManagerDto implements PersonManagerInterface {

    /** 責任者Id */
    personManagerId: number;
    /** 責任者同一識別コード */
    personManagerCode: number;
    /** 責任者名称 */
    personManagerName: string;

    /** 姓名の姓 */
    firstName: string;
    /** 姓名の姓ふりがな */
    firstNameKana: string;
    /** 姓名の名 */
    lastName: string;
    /** 姓名の名かな */
    lastNameKana: string;
    /** ミドルネーム */
    middleName: string;
    /** ミドルネームふりがな */
    middleNameKana: string;

    /** 電話番号市外局番 */
    tel1: string;
    /** 電話番号局番 */
    tel2: string;
    /** 電話番号番号 */
    tel3: string;

    /** 郵便番号1 */
    postalcode1: string;
    /** 郵便番号2 */
    postalcode2: string;
    /** 住所郵便番号まで1 */
    addressPostal: string;
    /** 住所番地 */
    addressBlock: string;
    /** 住所建物 */
    addressBuilding: string;

    /** 生年月日 */
    birtday: string;

    constructor(impl?: PersonManagerInterface) {

        const intString: string = "";
        const initNumber: number = 0;

        if (impl !== undefined) {
            this.personManagerId = impl.personManagerId;
            this.personManagerCode = impl.personManagerCode;
            this.personManagerName = impl.personManagerName;
            this.firstName = impl.firstName;
            this.firstNameKana = impl.firstNameKana;
            this.lastName = impl.lastName;
            this.lastNameKana = impl.lastNameKana;
            this.middleName = impl.lastName;
            this.middleNameKana = impl.lastNameKana;
            this.tel1 = impl.tel1;
            this.tel2 = impl.tel2;
            this.tel3 = impl.tel3;
            this.postalcode1 = impl.postalcode1;
            this.postalcode2 = impl.postalcode2;
            this.addressPostal = impl.addressPostal;
            this.addressBlock = impl.addressBlock;
            this.addressBuilding = impl.addressBuilding;
            this.birtday = impl.birtday;
        }
        else {
            this.personManagerId = initNumber;
            this.personManagerCode = initNumber;
            this.personManagerName = intString;
            this.firstName = intString;
            this.firstNameKana = intString;
            this.lastName = intString;
            this.lastNameKana = intString;
            this.middleName = intString;
            this.middleNameKana = intString;
            this.tel1 = intString;
            this.tel2 = intString;
            this.tel3 = intString;
            this.postalcode1 = intString;
            this.postalcode2 = intString;
            this.addressPostal = intString;
            this.addressBlock = intString;
            this.addressBuilding = intString;
            this.birtday = intString;
        }
    }
}

