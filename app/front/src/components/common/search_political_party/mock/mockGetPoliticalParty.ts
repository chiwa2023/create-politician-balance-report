import PoliticalPartyInterface from "../../../../dto/political_party/politicalPartyDto";
import PoliticalPartyDto from "../../../../dto/political_party/politicalPartyDto";

/**
 * 選挙管理委員会mockリストを返却する
 * @returns リスト
 */
export default function mockGetPoliticalParty():PoliticalPartyInterface[]{
    const list:PoliticalPartyInterface[] = [];

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
function createDto(index:number):PoliticalPartyInterface{
    
    const dto:PoliticalPartyInterface = new PoliticalPartyDto();
    
    dto.politicalPartyCode = index;
    dto.politicalPartyId = index*5;
    dto.politicalPartyName = "政党"+index;

    return dto;
}