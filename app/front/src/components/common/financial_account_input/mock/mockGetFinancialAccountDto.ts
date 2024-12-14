import FinacialOrgAccountInterface from "../../../../dto/bank_account/finacialOrgAccountDto";
import FinacialOrgAccountDto from "../../../../dto/bank_account/finacialOrgAccountDto";
import { DepositType } from "../../../../dto/zengin/depositType";

export default function mockGetFinancialAccountDto(): FinacialOrgAccountInterface {

    const dto: FinacialOrgAccountInterface = new FinacialOrgAccountDto();

    // 実際には入力しなければならない(値入力確認用)
    dto.finacialOrgId = 423;
    dto.finacialOrgCode = 420;
    dto.zenginFinacialOrgCode = "9797";
    dto.finacialOrgName = "高利銀行";
    dto.zenginFinacialBranchCode = "137";
    dto.finacialBranchName = "バリケード設置支店";

    dto.typeAccount = DepositType.ORDINALY;
    dto.accountNumber = "01234";
    dto.accountMeiginin = "メイギニン　タロウ";

    return dto;
}