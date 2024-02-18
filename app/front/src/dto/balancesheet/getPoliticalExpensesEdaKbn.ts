import SelectOptionInterface from "../selectOptionDto";
import SelectOptionDto from "../selectOptionDto";

export default function getPoliticalExpensesEdaKbn(): SelectOptionInterface[] {
    const list: SelectOptionDto[] = [];
    list.splice(0);

    list.push(createDto("1", "1.組織活動費"));
    list.push(createDto("2", "2.選挙関係費"));
    list.push(createDto("3", "3.機関紙発行事業費"));
    list.push(createDto("4", "4.宣伝事業費"));
    list.push(createDto("5", "5.政治資金パーティー開催事業費"));
    list.push(createDto("6", "6.その他の事業費"));
    list.push(createDto("7", "7.調査研究費"));
    list.push(createDto("8", "8.寄付交付金"));
    list.push(createDto("9", "9.その他の経費"));

    return list;
}

function createDto(value: string, text: string): SelectOptionDto {

    const dto: SelectOptionDto = new SelectOptionDto();
    dto.value = value;
    dto.text = text;

    return dto;
}