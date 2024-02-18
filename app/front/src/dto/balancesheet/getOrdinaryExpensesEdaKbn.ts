import SelectOptionInterface from "../selectOptionDto";
import SelectOptionDto from "../selectOptionDto";

export default function getOrdinaryExpensesEdaKbn(): SelectOptionInterface[] {
    const list: SelectOptionDto[] = [];
    list.splice(0);
    list.push(createDto("2", "2.光熱水費"));
    list.push(createDto("3", "3.備品・消耗品費"));
    list.push(createDto("4", "4.事務所費"));

    return list;
}

function createDto(value: string, text: string): SelectOptionDto {

    const dto: SelectOptionDto = new SelectOptionDto();
    dto.value = value;
    dto.text = text;

    return dto;
}