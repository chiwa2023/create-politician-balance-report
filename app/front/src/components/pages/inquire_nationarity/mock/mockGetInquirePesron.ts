import getRandomString from "../../../../dto/getRandomString";
import getUnixTimeString from "../../../../dto/getUnixTimeString";
import RelationPersonInterface from "../../../../dto/relation/relationPersonDto";
import RelationPersonDto from "../../../../dto/relation/relationPersonDto";

export default function mockGetInquirePesron():RelationPersonInterface{

    const dto:RelationPersonInterface = new RelationPersonDto();
    dto.kanrenshaCode = "1234-5678-9012";
    dto.firstNameKana = "だいひょうしゃ";
    dto.firstName = "代表者";
    dto.lastNameKana = "たろう";
    dto.lastName = "太郎";
    dto.middleNameKana = "みかえる";
    dto.middleName = "ミカエル";
    dto.addressPostal = "東京都千代田区霞が関";
    dto.addressBlock = "９９９丁目３号";
    dto.addressBuilding = "三角ビル";
    dto.postalcode1 = "111";
    dto.postalcode2 = "2223";
    dto.tel1 = "000";
    dto.tel2 = "1111";
    dto.tel3 = "2222";
    dto.inquireId =  getUnixTimeString() + "-" +getRandomString();

    return dto;
}