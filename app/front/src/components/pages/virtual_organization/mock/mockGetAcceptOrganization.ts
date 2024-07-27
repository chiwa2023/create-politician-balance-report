import AcceptOrganizationDto from "../../../../dto/virtual_organization/acceptOrganizationDto";

export default function mockGetAcceptOrganization(code: string) {

    const dto: AcceptOrganizationDto = new AcceptOrganizationDto();

    //仮想政治団体(システム側の管理だけで必要)
    dto.virtualOrganizationId = 1;
    dto.virtualOrganizationCode = 1;
    dto.virtualOrganizationName = "仮想政治団体1";//←ユーザさんに存在を知らせる(命名してもらう)必要はゼロ

    //申請者情報
    dto.personPropose.firstName = "代表者";
    dto.personPropose.firstNameKana = "だいひょうしゃ" ;
    dto.personPropose.lastName = "太郎" ;
    dto.personPropose.lastNameKana = "たろう" ;
    dto.personPropose.tel1 = "090" ;
    dto.personPropose.tel2 = "0090" ;
    dto.personPropose.tel3 = "xxxx" ;
    dto.personPropose.mailAddress  = "hoge@hogehoge.net";

    //実際には表示しない他の属性も取得して問題なし
    dto.personAccept.mailAddress= code + "_abc@hogehoge.net" ;

    return dto;


}