import PoliticalOrganizationInterface from "../../../../dto/political_organization/politicalOrganizationDto";
import RelationPersonInterface from "../../../../dto/relation/relationPersonDto";
import RelationPersonDto from "../../../../dto/relation/relationPersonDto";
import { ThisApplication } from "../../../../dto/thisApplication";


export default function mockGetRelationPerson(sendDto: PoliticalOrganizationInterface): RelationPersonInterface[] {

    const list: RelationPersonInterface[] = [];

    list.push(createDto(sendDto,1));
    list.push(createDto(sendDto,2));
    list.push(createDto(sendDto,3));
    list.push(createDto(sendDto,4));
    list.push(createDto(sendDto,5));
    list.push(createDto(sendDto,6));
    list.push(createDto(sendDto,7));

    return list
}


function createDto(sendDto: PoliticalOrganizationInterface,num:number ): RelationPersonInterface {


    const dto: RelationPersonInterface = new RelationPersonDto();

            const INIT_NUMBER: number = 0;
            const INIT_STRING: string = "";
    
            dto.inquireId = INIT_STRING; // 回答で使用
            dto.nationalityAnswerKbn = INIT_STRING; // 回答で使用
            dto.nationalityAnswerKbnText = INIT_STRING; // 回答で使用
    
            dto.applicationComonCode = ThisApplication.code;
            dto.applicationName = ThisApplication.name;
    
            dto.relationPersonId = num;
            dto.relationPersonCode = num*10;
            dto.politicalOrganizationId = sendDto.politicalOrganizationId;
            dto.politicalOrganizationCode = sendDto.politicalOrganizationCode;
            dto.politicalOrganizationName  = sendDto.politicalOrganizationName;
            dto.isSearch = false;
            
            dto.firstName = "会計責任者";
            dto.firstNameKana = "かいけいせきにんしゃ";
            dto.lastName = "正夫"+num;
            dto.lastNameKana = "まさお";
            dto.middleName = "ジョージ";
            dto.middleNameKana = "じょーじ";
            dto.tel1 = "000";
            dto.tel2 = "111";
            dto.tel3 = "xxxx";
            dto.postalcode1 = "012";
            dto.postalcode2 = "34yy";
            dto.addressPostal = "東京都千代田区霞が関";
            dto.addressBlock = "９９９番地";
            dto.addressBuilding = "三角ビル";

            // 表示用に結合
            dto.nameAll = dto.firstName + "　" + dto.middleName + dto.lastName;
            dto.addressAll = dto.addressPostal + dto.addressBlock + "　" + dto.addressBuilding;
   
            dto.lgCode = "123456";
            dto.machiazaId = "1234567";
            dto.blkId = "123";
            dto.rsdtId = "123";
            dto.kanrenshaCode = "aaa-bbb-ccc"+num; // 共通APIが運営されている前提(本格運営ならこの項目しか不要、あとは整合性を見るくらい)
    
    return dto;

}