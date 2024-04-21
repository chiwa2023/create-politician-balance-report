import SelectOptionInterface from "../selectOptionDto";

/**
 * CSVファイル読み込みのための位置指定Interface
 */
export default interface CsvReadTemplateInterface extends SelectOptionInterface{

    /** csv指定配列  */
    selectOptionsArray:string[];

    /** 金融機関Id  */
    finacialOrgId:number;

    /** 金融機関区分  */
    finacialOrgKbn:number;

    /** 金融機関同一識別コード  */
    finacialOrgCode:number;

    /** 金融機関名称  */
    finacialOrgName:string;

// eslint-disable-next-line semi
}

/**
 * CsvReadTemplateDto Csv読み込み位置Dto
 */
export default class CsvReadTemplateDto implements CsvReadTemplateInterface{
    
    /** オプション項目の値  */
    value: string;
   
    /** オプション項目の表示テキスト  */
    text: string;
    
    /** csv指定配列  */
    selectOptionsArray:string[];

    /** 金融機関Id  */
    finacialOrgId:number;

    /** 金融機関区分  */
    finacialOrgKbn:number;

    /** 金融機関同一識別コード  */
    finacialOrgCode:number;

    /** 金融機関名称  */
    finacialOrgName:string;

    /**
     * Creates an instance of CsvReadTemplateDto.
     */
    constructor(){
        this.value = "";
        this.text = "";
        this.selectOptionsArray = [];
        this.finacialOrgId=0;
        this.finacialOrgKbn=0;
        this.finacialOrgCode=0;
        this.finacialOrgName="";
    }
}