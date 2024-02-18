import getCsvReadItem from "../components/read_fin_institution_csv/getCsvReadItem";
import SelectOptionInterface from "./selectOptionDto";

export default interface SelectOptionsArrayInterface{
    selectedOption:string;
    options:SelectOptionInterface[];
}

export default class SelectOptionsArrayDto implements SelectOptionsArrayInterface{

    selectedOption:string;
    
    options:SelectOptionInterface[];

    constructor(){
        this.selectedOption = "";
        this.options = getCsvReadItem();
    }
}