import SelectOptionInterface from "../selectOptionDto"

export default interface CsvReadTemplateInterface extends SelectOptionInterface{
    selectOptionsArray:string[];
}

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