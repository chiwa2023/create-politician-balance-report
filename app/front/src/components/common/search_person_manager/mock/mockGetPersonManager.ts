import PersonManagerInterface from "../../../../dto/person_manager/personManager";
import PersonManagerDto from "../../../../dto/person_manager/personManager"

/**
 * 選挙管理委員会mockリストを返却する
 * @returns リスト
 */
export default function mockGetPersonManager(): PersonManagerInterface[] {
    const list: PersonManagerInterface[] = [];

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
function createDto(index: number): PersonManagerInterface {

    const dto: PersonManagerInterface = new PersonManagerDto();

    dto.firstName = "責任者姓" + index;
    dto.firstNameKana = "責任者姓かな" + index;
    dto.lastName = "責任者姓名" + index;
    dto.lastNameKana = "責任者名かな" + index;
    dto.tel1 = "00" + index;
    dto.tel2 = "001" + index;
    dto.tel3 = "002" + index;

    dto.postalcode1 = "0" + index + "1";
    dto.postalcode2 = "0" + index + "2";

    dto.addressPostal = "山梨県架空市実在町" + index + "丁目";
    dto.addressBlock = index + "番地" + index * 13;
    dto.addressBuilding = "三角ビル" + index + "階";

    dto.birtday = "1987-03-16";

    dto.personManagerId = index + 30;
    dto.personManagerCode = index;
    dto.personManagerName = dto.firstName + "　" + dto.lastName;

    return dto;
}