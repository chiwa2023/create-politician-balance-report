/**
 * 口座種別
 */
export const DepositType = {

    /** 1:普通預金 */
    ORDINALY: "1",

    /** 2:当座預金 */
    CURRENT: "2",

    /** 3：納税準備預金 */
    TAX_RESERVE: "3",

    /** 4:貯蓄預金 */
    SAVING: "4",

    /** 5：通知預金 */
    NOTICE: "5",

    /** 6：定期預金 */
    FIXED: "6",

    /** 7：積立定期預金 */
    ACCUMULATED_FIXED: "7",

    /** 8：定期積金 */
    REGULAR: "9",

    /** 9：その他 */
    OTHER: "9",

} as const 