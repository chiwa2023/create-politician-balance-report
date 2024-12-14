import ContinueBuissinessInterface from "../../../../dto/continue_buissiness_dto/continueBuissinessDto";
import ContinueBuissinessDto from "../../../../dto/continue_buissiness_dto/continueBuissinessDto";
import { DepositType } from "../../../../dto/zengin/depositType";

export default function mockGetContinueBuissinessDto():ContinueBuissinessInterface{

    const dto:ContinueBuissinessInterface = new ContinueBuissinessDto();

    // 実際には入力しなければならない(値入力確認用)
    dto.houkokuNen = 2023;
    dto.buissinessName = "陰謀論本買取事業";
    dto.digest = "陰謀論の書籍を高価買取し、必要な注釈をしおりでつけて古書販売店に卸す";

    // 銀行口座
    dto.financialOrgAccaount.finacialOrgId = 423;
    dto.financialOrgAccaount.finacialOrgCode = 420;
    dto.financialOrgAccaount.zenginFinacialOrgCode = "9797";
    dto.financialOrgAccaount.finacialOrgName = "高利銀行";
    dto.financialOrgAccaount.zenginFinacialBranchCode = "137";
    dto.financialOrgAccaount.finacialBranchName = "バリケード設置支店";

    dto.financialOrgAccaount.typeAccount = DepositType.ORDINALY;
    dto.financialOrgAccaount.accountNumber ="01234";
    dto.financialOrgAccaount.accountMeiginin ="メイギニン　タロウ";

    return dto;
}