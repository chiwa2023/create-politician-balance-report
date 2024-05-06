/**
 * CSVファイル読み込みのための位置指定Interface
 */
export default interface ProposeCsvReadTemplateInterface {

    /** csvテンプレートId  */
    csvReadTemplateId: number;

    /** csvテンプレート同一識別コード  */
    csvReadTemplateCode: number;

    /** csvテンプレート名称  */
    csvReadTemplateName: string;

    /** csv指定配列  */
    arrayText: string;

    /** csv項目数  */
    arrayNumber: number;

    /** 金融機関区分  */
    financialOrgKbn: number;

    /** 金融機関Id  */
    financialOrgId: number;


    /** 金融機関同一識別コード  */
    financialOrgCode: number;

    /** 金融機関名称  */
    financialOrgName: string;

    // eslint-disable-next-line semi
}

/**
 * CsvReadTemplateDto Csv読み込み位置Dto
 */
export default class ProposeCsvReadTemplateDto implements ProposeCsvReadTemplateInterface {

    /** csvテンプレートId  */
    csvReadTemplateId: number;

    /** csvテンプレート同一識別コード  */
    csvReadTemplateCode: number;

    /** csvテンプレート名称  */
    csvReadTemplateName: string;

    /** csv指定配列  */
    arrayText: string;

    /** csv項目数  */
    arrayNumber: number;

    /** 金融機関Id  */
    financialOrgId: number;

    /** 金融機関区分  */
    financialOrgKbn: number;

    /** 金融機関同一識別コード  */
    financialOrgCode: number;

    /** 金融機関名称  */
    financialOrgName: string;

    /**
     * Creates an instance of CsvReadTemplateDto.
     */
    constructor() {
        this.csvReadTemplateId = 0;
        this.csvReadTemplateCode = 0;
        this.csvReadTemplateName = "";
        this.arrayText = "";
        this.arrayNumber = 0;
        this.financialOrgId = 0;
        this.financialOrgKbn = 0;
        this.financialOrgCode = 0;
        this.financialOrgName = "";
    }
}