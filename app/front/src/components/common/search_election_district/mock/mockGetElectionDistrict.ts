import ElectionDistrictInterface from "../../../../dto/election_district/electionDistictDto";
import ElectionDistrictDto from "../../../../dto/election_district/electionDistictDto";

/**
 * 議会選挙区mockリストを返却する
 * @returns リスト
 */
export default function mockGetElectionDistrict(): ElectionDistrictInterface[] {
    const list: ElectionDistrictInterface[] = [];

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
function createDto(index: number): ElectionDistrictInterface {

    const dto: ElectionDistrictInterface = new ElectionDistrictDto();

    dto.electionDistrictCode = index;
    dto.electionDistrictId = index * 5;
    dto.electionDistrictName = "議会選挙区" + index;

    dto.parliamentOrganizationCode = index;
    dto.parliamentOrganizationId = index * 5;
    dto.parliamentOrganizationName = "議会" + index;

    return dto;
}