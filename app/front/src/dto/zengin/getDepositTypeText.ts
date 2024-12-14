import { DepositType } from "./depositType";

export default function getDepositTypeText(selectedType: string): string {

    switch (selectedType) {

        // 1:普通預金 
        case DepositType.ORDINALY:
            return "普通預金";

        //  2:当座預金 
        case DepositType.CURRENT:
            return "当座預金";

        //  3：納税準備預金 
        case DepositType.TAX_RESERVE:
            return "納税準備預金";

        //  4:貯蓄預金 
        case DepositType.SAVING:
            return "貯蓄預金";

        //  5：通知預金 
        case DepositType.NOTICE:
            return "通知預金";

        // ：定期預金 
        case DepositType.FIXED:
            return "定期預金";

        //  7：積立定期預金 
        case DepositType.ACCUMULATED_FIXED:
            return "積立定期預金";

        //  8：定期積金 
        case DepositType.REGULAR:
            return "定期積金";

        //  9：その他 
        case DepositType.OTHER:
            return "その他";



    }

    return "";
}