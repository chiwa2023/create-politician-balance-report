import PersonWorkerInterface from "../../../../dto/person_worker/personWorkerDto";
import PersonWorkerDto from "../../../../dto/person_worker/personWorkerDto";

/**
 * 選挙管理委員会mockリストを返却する
 * @returns リスト
 */
export default function mockGetPersonWorker(): PersonWorkerInterface[] {
    const list: PersonWorkerInterface[] = [];

    list.push(createDto(1));
    list.push(createDto(2));
    list.push(createDto(3));
    list.push(createDto(4));

    return list;
}

/**
 * 行を生成する
 * @param index 発生index
 * @returns Dto
 */
function createDto(index: number): PersonWorkerInterface {

    const dto: PersonWorkerInterface = new PersonWorkerDto();

    dto.firstName = "作業者姓" + index;
    dto.firstNameKana = "作業者姓かな" + index;
    dto.lastName = "作業者姓名" + index;
    dto.lastNameKana = "作業者名かな" + index;

    if(index%2 === 1){
        dto.roleKbn = 1;
    }else{
        dto.roleKbn = 22;
    }
    
    dto.tel1 = "00" + index;
    dto.tel2 = "001" + index;
    dto.tel3 = "002" + index;
    dto.personWorkerId = index + 30;
    dto.personWorkerCode = index;
    dto.personWorkerName = dto.firstName + "　" + dto.lastName;

    dto.mailAddress = index+"_abc@hohoge.net";

    return dto;
}