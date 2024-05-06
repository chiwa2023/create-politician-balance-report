export default class CsvReadTemplateEntity {

    /** CSV読取り仕様同一識別コード */
    csvReadTemplateCode: number;

    /** CSV読取り仕様名称 */
    csvReadTemplateName: string;

    /** 指定配列内容 */
    arrayText: string;

    /** 金融機関名称 */
    financialOrgName: string;

    /** 配列桁数 */
    arrayNumber: number;

    /** 金融機関区分 */
    financialOrgKbn: number;

    /** 金融機関同一識別コード */
    financialOrgCode: number;

    /** 更新時間 */
    updateTime: Date;

    /** 最新区分 */
    saishinKbn: number;

    /** テーブル全文検索カラム */
    tableAllSearchText: string;

    /** CSV読取り仕様Id */
    csvReadTemplateId: number;

    /** 金融機関Id */
    financialOrgId: number;

    /** ヘッダの有無 */
    hasHeader: boolean;

    /** ログインユーザId */
    loginUserId: number;

    /** ログインユーザ同一識別コード */
    loginUserCode: number;

    /** ログインユーザ氏名 */
    loginUserName: string;


    constructor() {
        this.csvReadTemplateCode = 0;
        this.csvReadTemplateName = "";
        this.arrayText = "";
        this.financialOrgName = "";
        this.arrayNumber = 0;
        this.financialOrgKbn = 0;
        this.financialOrgCode = 0;
        this.updateTime = new Date();
        this.saishinKbn = 0;
        this.tableAllSearchText = "";
        this.csvReadTemplateId = 0;
        this.financialOrgId = 0;
        this.hasHeader = false;
        this.loginUserId = 0;
        this.loginUserCode = 0;
        this.loginUserName = "";

    }

}