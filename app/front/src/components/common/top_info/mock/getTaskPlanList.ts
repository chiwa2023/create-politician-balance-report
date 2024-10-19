import SelectOptionInterface from "../../../../dto/selectOptionDto";
import SelectOptionDto from "../../../../dto/selectOptionDto";

export default function getTaskPlanList():SelectOptionInterface[]{
    const list:SelectOptionInterface[] =[];

    list.push(createDto("1"));
    list.push(createDto("2"));
    list.push(createDto("3"));

    return list;
}

function createDto(value:string):SelectOptionInterface{
    const dto:SelectOptionDto = new SelectOptionDto();
    dto.value = value;
    dto.text = "タスク"+value;

    return dto;
}