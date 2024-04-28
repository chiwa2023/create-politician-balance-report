import CsvReadTemplateInterface from "../../../../dto/read_csv/csvReadTemplate";
import CsvReadTemplateDto from "../../../../dto/read_csv/csvReadTemplate";

/**
 * Csv読み取り仕様を項目で取り出す
 * @param columnSize 読み取られたCSVの列数
 * @returns 読取り仕様テンプレート
 */
export default function mockReadTemplate(columnSize:number):CsvReadTemplateInterface[]{
    const listOptions:CsvReadTemplateInterface[] = []; 

    if(columnSize>0){
        listOptions.push(createDto("首都圏市民信用金庫(個人用)",1));
        listOptions.push(createDto("還元pay",2));
        listOptions.push(createDto("関西市民信用金庫(個人用)",3));
        listOptions.push(createDto("2次元バーコード専用pay",4));
    }
    else{
        listOptions.push(createDto("関西市民信用金庫(個人用)",5));
        listOptions.push(createDto("2次元バーコード専用pay",6));
    }

    listOptions.push(createDto("選択解除",0));

    return listOptions;
}

/**
 * テンプレート項目を生成する
 * @param text 表示名
 * @param dummy 適当な数字
 * @returns 表示項目
 */
function createDto(text:string,dummy:number):CsvReadTemplateInterface{
    const selectOptionDto:CsvReadTemplateInterface = new CsvReadTemplateDto();
    
    selectOptionDto.value = text;
    selectOptionDto.text = text;
    selectOptionDto.arrayText = "15,1,2,16,0,0,0";
    selectOptionDto.financialOrgKbn = 1;
    selectOptionDto.financialOrgId = 4000+dummy;
    selectOptionDto.financialOrgCode = 123*dummy;
    selectOptionDto.financialOrgName = text;

    return selectOptionDto;
}