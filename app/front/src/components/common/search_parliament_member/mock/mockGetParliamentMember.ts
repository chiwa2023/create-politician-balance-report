import ParliamentMemberInterface from "../../../../dto/parliament_member/parliamentMember";
import ParliamentMemberDto from "../../../../dto/parliament_member/parliamentMember";

/**
 * 議員mockリストを返却する
 * @returns リスト
 */
export default function mockGetElectionCommissionLeast(isKokkaiGiin: boolean): ParliamentMemberInterface[] {
    const list: ParliamentMemberInterface[] = [];

    list.push(createDto(1, isKokkaiGiin));
    list.push(createDto(2, isKokkaiGiin));
    list.push(createDto(3, isKokkaiGiin));
    list.push(createDto(4, isKokkaiGiin));

    return list;
}

/**
 * 行を生成する
 * @param index 発生index
 * @returns Dto
 */
function createDto(index: number, isKokkaiGiin: boolean): ParliamentMemberInterface {
    const dto: ParliamentMemberInterface = new ParliamentMemberDto();

    dto.parliamentMemberCode = index;
    dto.parliamentMemberId = index * 5;
    dto.parliamentMemberName = "議員　太郎" + index;
    dto.parliamentMemberNameKana = "ぎいん　たろう" + index;
    if (isKokkaiGiin) {
        dto.parliamentOrganizationId = index % 2 + 1;//仮で奇数…衆議院、偶数参議院
    } else {
        dto.parliamentOrganizationId = index * 5;
    }
    dto.parliamentOrganizationCode = index;
    dto.parliamentOrganizationName = "議会" + index;
    dto.electionDistrictCode = index;
    dto.electionDistrictId = index * 5;
    dto.electionDistrictName = "議会選挙区" + index;

    return dto;
}