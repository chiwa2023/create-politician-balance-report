import ParliamentOrganizationInterface from "../../../../dto/parliament_organization/parliamentOrganization";
import ParliamentOrganizationDto from "../../../../dto/parliament_organization/parliamentOrganization";

/**
 * 議会mockリストを返却する
 * @returns リスト
 */
export default function mockGeParliamentOrganization(): ParliamentOrganizationInterface[] {
    const list: ParliamentOrganizationInterface[] = [];

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
function createDto(index: number): ParliamentOrganizationInterface {

    const dto: ParliamentOrganizationInterface = new ParliamentOrganizationDto();

    dto.parliamentOrganizationCode = index;
    dto.parliamentOrganizationId = index * 5;
    dto.parliamentOrganizationName = "議会" + index;

    return dto;
}