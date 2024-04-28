import VariousFinancialPayInterface from "../../../../dto/financial/vairousFinancialPayDto";
import VariousFinancialPayDto from "../../../../dto/financial/vairousFinancialPayDto";

/**
 * 各種PayのMockデータ配列を取得する
 * @returns 生成配列
 */
export default function mockGetVariousFainacialPay():VariousFinancialPayInterface[]{

    const list:VariousFinancialPayInterface[] = [];

    list.push(createDto(1,"各種Pay1"));
    list.push(createDto(2,"各種Pay2"));
    list.push(createDto(3,"各種Pay3"));
    list.push(createDto(4,"各種Pay4"));

    return list;
}

/**
 * 各種Pay項目を生成する
 * @param id id
 * @param name 名称
 * @returns 各種PayDto
 */
function createDto(id:number,name:string):VariousFinancialPayInterface{

    const dto:VariousFinancialPayInterface = new VariousFinancialPayDto();
    dto.variousFinancialPayId = id;
    dto.variousFinancialPayCode = id;
    dto.variousFinancialPayName = name;

    return dto;
}