import PoliticalOrganizationInterface from "../../../../dto/political_organization/politicalOrganizationDto";
import PoliticalOrganizationDto from "../../../../dto/political_organization/politicalOrganizationDto";

/**
 * 選挙管理委員会mockリストを返却する
 * @returns リスト
 */
export default function mockGetPoliticalOrganization(): PoliticalOrganizationInterface[] {
    const list: PoliticalOrganizationInterface[] = [];

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
function createDto(index: number): PoliticalOrganizationInterface {

    const dto: PoliticalOrganizationInterface = new PoliticalOrganizationDto();

    dto.politicalOrganizationCode = index;
    dto.politicalOrganizationId = index * 5;
    dto.politicalOrganizationName = "政治団体" + index;

    return dto;
}