export default interface PersonWorkerInterface {

    /** 作業者Id */
    personWorkerId: number;
    /** 作業者同一識別コード */
    personWorkerCode: number;
    /** 作業者名称 */
    personWorkerName: string;

    /** 姓名の姓 */
    firstName: string;
    /** 姓名の姓ふりがな */
    firstNameKana: string;
    /** 姓名の名 */
    lastName: string;
    /** 姓名の名かな */
    lastNameKana: string;

    /** 電話番号市外局番 */
    tel1: string;
    /** 電話番号局番 */
    tel2: string;
    /** 電話番号番号 */
    tel3: string;

}

export default class PersonWorkerDto implements PersonWorkerInterface {

    /** 作業者Id */
    personWorkerId: number;
    /** 作業者同一識別コード */
    personWorkerCode: number;
    /** 作業者名称 */
    personWorkerName: string;

    /** 姓名の姓 */
    firstName: string;
    /** 姓名の姓ふりがな */
    firstNameKana: string;
    /** 姓名の名 */
    lastName: string;
    /** 姓名の名かな */
    lastNameKana: string;

    /** 電話番号市外局番 */
    tel1: string;
    /** 電話番号局番 */
    tel2: string;
    /** 電話番号番号 */
    tel3: string;

    constructor(impl?: PersonWorkerInterface) {
        const initString: string = "";
        const initNumber: number = 0;
        if (impl !== undefined) {
            this.personWorkerId = impl.personWorkerId;
            this.personWorkerCode = impl.personWorkerCode;
            this.personWorkerName = impl.personWorkerName;
            this.firstName = impl.firstName;
            this.firstNameKana = impl.firstNameKana;
            this.lastName = impl.lastName;
            this.lastNameKana = impl.lastNameKana;
            this.tel1 = impl.tel1;
            this.tel2 = initString;
            this.tel3 = initString;
        } else {
            this.personWorkerId = initNumber;
            this.personWorkerCode = initNumber;
            this.personWorkerName = initString;
            this.firstName = initString;
            this.firstNameKana = initString;
            this.lastName = initString;
            this.lastNameKana = initString;
            this.tel1 = initString;
            this.tel2 = initString;
            this.tel3 = initString;
        }
    }

}