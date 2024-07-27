import { StartManagePoliticalOrganizationDto } from "../../../../dto/start_manage_political_organization/startManagePoliticalOrganizationDto";


export default function mockGetStartMagaePoliticalOrganization(code: string): StartManagePoliticalOrganizationDto {

    //TODO 事前に保存したcodeから登録しようとする情報を呼び出してdtoを作成する
    const dto: StartManagePoliticalOrganizationDto = new StartManagePoliticalOrganizationDto();

    if (code !== "") {
        /** 政治団体 */
        dto.politicalOrganizationId = 3;
        dto.politicalOrganizationCode = 1;
        dto.politicalOrganizationName = "ちゃらんぽらん政治団体";

        /** 責任者 */
        dto.personManagerDto.firstName = "代表者";
        dto.personManagerDto.firstNameKana = "だいひょうしゃ";
        dto.personManagerDto.lastName = "太郎";
        dto.personManagerDto.lastNameKana = "たろう";
        dto.personManagerDto.postalcode1 = "987";
        dto.personManagerDto.postalcode2 = "6543";
        dto.personManagerDto.tel1 = "012";
        dto.personManagerDto.tel2 = "3456";
        dto.personManagerDto.tel3 = "xxxx";
        dto.personManagerDto.addressPostal = "宮崎県架空市実在町";
        dto.personManagerDto.addressBlock = "1967番地";
        dto.personManagerDto.addressBuilding = "八角形ビル";
        dto.personManagerDto.birtday = "1994-02-21";

        dto.roleOrganizationKbn = 1;
        dto.roleOrganizationKbnText = "代表者";

        /** 承認該否 */
        dto.isAcceptDelegate = false;
        dto.isAcceptAccountManager = true;
        dto.isAcceptAccountManagerSupport = false;
    }

    return dto;
}