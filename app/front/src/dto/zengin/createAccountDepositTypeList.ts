import SelectOptionInterface from "../selectOptionDto";
import SelectOptionDto from "../selectOptionDto";
import getDepositTypeText from "./getDepositTypeText";

export default function createAccountDepositTypeList(listType:string[]):SelectOptionInterface[]{

    const list:SelectOptionInterface[] = [];
    for(const num of listType){
        list.push(createDto(num));
    }
    
    return list;
}


function createDto(value:string):SelectOptionInterface{
 
    const dto:SelectOptionInterface = new SelectOptionDto();
    dto.value = value;
    dto.text = getDepositTypeText(value);

    return dto;
}