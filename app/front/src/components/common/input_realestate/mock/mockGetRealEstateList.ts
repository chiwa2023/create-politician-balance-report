import RealEstateDto from "../../../../dto/balancesheet_estate/realEstateDto"


export default function mockGetRealEstateList(): RealEstateDto[] {

    const list: RealEstateDto[] = [];

    list.push(createDto(1));
    list.push(createDto(2));
    list.push(createDto(3));
    list.push(createDto(4));

    return list;
}

function createDto(index: number): RealEstateDto {

    const dto: RealEstateDto = new RealEstateDto();

    dto.balancesheetRealEstateId = index * 10;
    dto.balancesheetRealEstateCode = index;
    dto.itemName = index + "号ビル";
    dto.yoshikiEdaKbn = "イ";
    dto.purposeAll = "社員寮";
    dto.userRelation = "当該団体社員";
    dto.userPerpose = "住居";
    dto.userArea = index * 100 + index * 0.1;
    dto.userAmount = index * 10000;


    return dto;
}