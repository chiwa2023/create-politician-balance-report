export default interface PersonWorkerInterface {

    /** 作業者Id */
    personWorkerId: number;
    /** 作業者同一識別コード */
    personWorkerCode: number;
    /** 作業者名称 */
    personWorkerName: string;

    /** 組織内役割区分 */
    userKbn: number;
    /** 組織内役割区分 */
    roleKbn: number;

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

    /** メールアドレス */
    mailAddress: string;

}

export default class PersonWorkerDto implements PersonWorkerInterface {

    /** 作業者Id */
    personWorkerId: number;
    /** 作業者同一識別コード */
    personWorkerCode: number;
    /** 作業者名称 */
    personWorkerName: string;

    /** 組織内役割区分 */
    roleKbn: number;
    /** 組織内役割区分 */
    userKbn: number;

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

    /** メールアドレス */
    mailAddress: string;

    constructor(impl?: PersonWorkerInterface) {
        const initString: string = "";
        const initNumber: number = 0;
        if (impl !== undefined) {
            this.personWorkerId = impl.personWorkerId;
            this.personWorkerCode = impl.personWorkerCode;
            this.personWorkerName = impl.personWorkerName;
            this.userKbn = impl.userKbn;
            this.roleKbn = impl.roleKbn;
            this.firstName = impl.firstName;
            this.firstNameKana = impl.firstNameKana;
            this.lastName = impl.lastName;
            this.lastNameKana = impl.lastNameKana;
            this.middleName = impl.middleName;
            this.middleNameKana = impl.middleNameKana;
            this.tel1 = impl.tel1;
            this.tel2 = impl.tel2;
            this.tel3 = impl.tel3;
            this.mailAddress = impl.mailAddress;
        } else {
            this.personWorkerId = initNumber;
            this.personWorkerCode = initNumber;
            this.personWorkerName = initString;
            this.userKbn = initNumber;
            this.roleKbn = initNumber;
            this.firstName = initString;
            this.firstNameKana = initString;
            this.lastName = initString;
            this.lastNameKana = initString;
            this.middleName = initString;
            this.middleNameKana = initString;
            this.tel1 = initString;
            this.tel2 = initString;
            this.tel3 = initString;
            this.mailAddress = initString;
        }
    }

}