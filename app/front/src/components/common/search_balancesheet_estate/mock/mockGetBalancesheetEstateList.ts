import BalancesheetEstateInterface from "../../../../dto/balancesheet_estate/balancesheetEstateDto";
import BalancesheetEstateDto from "../../../../dto/balancesheet_estate/balancesheetEstateDto";
import mockGetRealEstateList from "../../input_realestate/mock/mockGetRealEstateList";

export default function mockGetBalancesheetEstateList():BalancesheetEstateInterface[]{
    const list:BalancesheetEstateInterface[] = [];

    list.push(createDto(1));
    list.push(createDto(2));
    list.push(createDto(3));
    list.push(createDto(4));

    return list;
}

function createDto(index:number):BalancesheetEstateInterface{

    const dto:BalancesheetEstateInterface = new BalancesheetEstateDto();

    dto.balancesheetEstateCode = index;
    dto.balancesheetEstateId = index*10;
    dto.isSameData = false;
    dto.yoshikiKbn = "18";
    dto.yoshikiEdaKbn = "イ";
    dto.itemName = "土地"+index;
    dto.amount = index*10003;
    dto.accrualDate = "2022-09-1"+index;
    dto.biko = "備考"+index;
    dto.listRealEstate = mockGetRealEstateList();
    return dto;
}