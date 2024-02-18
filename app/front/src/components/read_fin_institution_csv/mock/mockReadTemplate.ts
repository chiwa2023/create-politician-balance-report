import CsvReadTemplateInterface from "../../../dto/read_csv/csvReadTemplate";
import CsvReadTemplateDto from "../../../dto/read_csv/csvReadTemplate";

export default function mockReadTemplate(columnSize:number):CsvReadTemplateInterface[]{
    const listOptions:CsvReadTemplateInterface[] = []; 

    if(columnSize>0){
        listOptions.push(createDto("首都圏市民信用金庫(個人用)"));
        listOptions.push(createDto("還元pay"));
        listOptions.push(createDto("関西市民信用金庫(個人用)"));
        listOptions.push(createDto("2次元バーコード専用pay"));
    }
    else{
        listOptions.push(createDto("関西市民信用金庫(個人用)"));
        listOptions.push(createDto("2次元バーコード専用pay"));
    }

    listOptions.push(createDto("選択解除"));

    return listOptions;
}

function createDto(text:string):CsvReadTemplateInterface{
    const selectOptionDto:CsvReadTemplateInterface = new CsvReadTemplateDto();
    
    selectOptionDto.value = text;
    selectOptionDto.text = text;
    selectOptionDto.selectOptionsArray = ["15","1","2","16","0","0","0"];
    return selectOptionDto;
}