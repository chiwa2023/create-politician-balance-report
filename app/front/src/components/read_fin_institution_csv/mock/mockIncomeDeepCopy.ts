import BalancesheetIncomeDto from "../../../dto/balancesheetIncomeDto";

/**  
 * 収支報告書収入データのコピー
 * @param dtoSrc 収支報告書収入データ
 * @returns コピー
 */
export default function mockIncomeDeepCopy(dtoSrc:BalancesheetIncomeDto):BalancesheetIncomeDto{

    const dtoCopy:BalancesheetIncomeDto = new BalancesheetIncomeDto();

    dtoCopy.shoushoId = dtoSrc.shoushoId;
    dtoCopy.shoushoHistroyCode = dtoSrc.shoushoHistroyCode;
    dtoCopy.shoushoKbn = dtoSrc.shoushoKbn;
    dtoCopy.isEditAutoInput = dtoSrc.isEditAutoInput;
    dtoCopy.reportKbn = dtoSrc.reportKbn;
    dtoCopy.yoshikiKbn = dtoSrc.yoshikiKbn;
    dtoCopy.yoshikiEdaKbn = dtoSrc.yoshikiEdaKbn;
    dtoCopy.amount = dtoSrc.amount;
    dtoCopy.accrualDate = dtoSrc.accrualDate;
    dtoCopy.mediationStartDate = dtoSrc.mediationStartDate;
    dtoCopy.mediationEndDate = dtoSrc.mediationEndDate;
    dtoCopy.shimeiOrgnizationName = dtoSrc.shimeiOrgnizationName;
    dtoCopy.itemName = dtoSrc.itemName;
    dtoCopy.orgnizationAddress = dtoSrc.orgnizationAddress;
    dtoCopy.biko = dtoSrc.biko;
    dtoCopy.isCreditTax = dtoSrc.isCreditTax;
    dtoCopy.isBequest = dtoSrc.isBequest;
    dtoCopy.isPrimeListedOrForeign = dtoSrc.isPrimeListedOrForeign;
    dtoCopy.isCreditTax = dtoSrc.isCreditTax;
    dtoCopy.note = dtoSrc.note;
    dtoCopy.isDifferPrecedent = dtoSrc.isDifferPrecedent;
    return dtoCopy;
}