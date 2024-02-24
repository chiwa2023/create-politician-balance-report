/**
 * 収支報告書を送信時の最終チェックと接続情報Interface
 *
 * @export
 * @interface CheckSendBalancesheetInterface　収支報告書送信前チェックInterface
 */
export default interface CheckSendBalancesheetInterface {
        /** 政治団体Id */ 
        politicianOrganizationId: number;
        /** 報告年 */
        submisshonYear: number;
        /** 収支報告書発行時刻 */
        publishTimestamp: Date;
        /** 収支報告書発行時刻(表示用) */
        publishTimestampText: string;
        /** 発行XMLパス */
        publishXmlPath: string;
        /** 送信前確認・報告年 */
        isConfirmYear: boolean;
        /** 送信前確認・代表者名 */
        isConfirmRepresentName: boolean;
        /** 送信前確認・会計責任者名 */
        isConfirmAccountOfiicerName: boolean;
        /** 送信前確認・主たる事務所の住所 */
        isConfirmOfficeAddress: boolean;
        /** 送信前確認・政治団体区分 */
        isConfirmOrganizationKbn: boolean;
        /** 送信前確認・政治資金団体の有無 */
        isConfirmHasOtherOrg: boolean;
        /** オンライン提出ユーザ名 */
        userNameSubmissionOrg: string;
        /**オンライン提出パスワード */
        userPasswordSubmissionOrg: string;
}

/**
 * 収支報告書を送信時の最終チェックと接続情報Dto
 *
 * @export
 * @class CheckSendBalancesheetDto
 * @implements {CheckSendBalancesheetInterface}
 */
export default class CheckSendBalancesheetDto implements CheckSendBalancesheetInterface {

        /** 政治団体Id */ 
        politicianOrganizationId: number;
        /** 報告年 */
        submisshonYear: number;
        /** 収支報告書発行時刻 */
        publishTimestamp: Date;
        /** 収支報告書発行時刻(表示用) */
        publishTimestampText: string;
        /** 発行XMLパス */
        publishXmlPath: string;
        /** 送信前確認・報告年 */
        isConfirmYear: boolean;
        /** 送信前確認・代表者名 */
        isConfirmRepresentName: boolean;
        /** 送信前確認・会計責任者名 */
        isConfirmAccountOfiicerName: boolean;
        /** 送信前確認・主たる事務所の住所 */
        isConfirmOfficeAddress: boolean;
        /** 送信前確認・政治団体区分 */
        isConfirmOrganizationKbn: boolean;
        /** 送信前確認・政治資金団体の有無 */
        isConfirmHasOtherOrg: boolean;
        /** オンライン提出ユーザ名 */
        userNameSubmissionOrg: string;
        /**オンライン提出パスワード */
        userPasswordSubmissionOrg: string;

    /**
     * Creates an instance of CheckSendBalancesheetDto.
     * @memberof CheckSendBalancesheetDto
     */
    constructor() {
        this.politicianOrganizationId = 111222333;
        this.submisshonYear = 2022;
        this.publishTimestamp = new Date();
        this.publishTimestampText = "2022-08-08 12:34";
        this.isConfirmYear = false;
        this.isConfirmOrganizationKbn = false;
        this.isConfirmAccountOfiicerName = false;
        this.isConfirmOfficeAddress = false;
        this.isConfirmRepresentName = false;
        this.isConfirmHasOtherOrg = false;
        this.userNameSubmissionOrg = "";
        this.userPasswordSubmissionOrg = "";
        this.publishXmlPath = "";
    }
}