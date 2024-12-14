/**
 * 権限情報を格納する
 * TODO 仕様が決定次第修正する
 */
export default class CheckPrivilegeDto {

    /** 他機能確認用Mock強制例外発生フラグ */
    isRaiseExcception: boolean;

    /** 他機能確認用Mock判定結果 */
    isResult: boolean;

    /** ログインユーザId */
    loginUserId: number;

    /** ログインユーザ同一識別コード */
    loginUserCode: number;

    /** ログインユーザ氏名 */
    loginUserName: string;


    politicalOrganizationId:number;
    politicalOrganizationCode:number;
    politicalOrganizationName:string;

    constructor() {
        const INIT_NUMBER: number = 0;
        const INIT_STRING: string = "";

        //newしただけでは落ちる値を設定
        this.isRaiseExcception = true;
        this.isResult = false;

        this.loginUserId =INIT_NUMBER;
        this.loginUserCode =INIT_NUMBER;
        this.loginUserName =INIT_STRING;

        this.politicalOrganizationId=INIT_NUMBER;
        this.politicalOrganizationCode=INIT_NUMBER;
        this.politicalOrganizationName =INIT_STRING;
    
    }

}