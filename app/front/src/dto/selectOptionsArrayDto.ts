import getCsvReadItem from "../components/read_fin_institution_csv/getCsvReadItem";
import SelectOptionInterface from "./selectOptionDto";

/**
 * 配列内で選択肢を設定るするためのInterface
 */
export default interface SelectOptionsArrayInterface{
    selectedOption:string;
    options:SelectOptionInterface[];
// eslint-disable-next-line semi
}

/**
 * 配列内で選択肢を設定るするためのDto
 */
export default class SelectOptionsArrayDto implements SelectOptionsArrayInterface{

    selectedOption:string;
    
    options:SelectOptionInterface[];

    constructor(){
        this.selectedOption = "";
        this.options = getCsvReadItem();
    }
}