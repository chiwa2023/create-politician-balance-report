import SelectOptionInterface from "../selectOptionDto";

/**
 * CSVファイル読み込みのための位置指定Interface
 */
export default interface CsvReadTemplateInterface extends SelectOptionInterface{
    selectOptionsArray:string[];
// eslint-disable-next-line semi
}

/**
 * CsvReadTemplateDto Csv読み込み位置Dto
 */
export default class CsvReadTemplateDto implements CsvReadTemplateInterface{
    
    value: string;
    
    text: string;
    
    selectOptionsArray:string[];

    constructor(){
        this.value = "";
        this.text = "";
        this.selectOptionsArray = [];
    }
}