import BalancesheetOutcomeDto from "../../../dto/balancesheetOutcomeDto";

export default function mockOutcomeDeepCopy(dtoSrc:BalancesheetOutcomeDto):BalancesheetOutcomeDto{

    const dtoCopy:BalancesheetOutcomeDto = new BalancesheetOutcomeDto();
    
    dtoCopy.shoushoId = dtoSrc.shoushoId;
    dtoCopy.shoushoHistroyCode = dtoSrc.shoushoHistroyCode;
    dtoCopy.shoushoKbn = dtoSrc.shoushoKbn;
    dtoCopy.isEditAutoInput = dtoSrc.isEditAutoInput;
    dtoCopy.reportKbn = dtoSrc.reportKbn;
    dtoCopy.yoshikiKbn = dtoSrc.yoshikiKbn;
    dtoCopy.yoshikiEdaKbn = dtoSrc.yoshikiEdaKbn;
    dtoCopy.amount = dtoSrc.amount;
    dtoCopy.accrualDate = dtoSrc.accrualDate;
    dtoCopy.shimeiOrgnizationName = dtoSrc.shimeiOrgnizationName;
    dtoCopy.itemName = dtoSrc.itemName;
    dtoCopy.orgnizationAddress = dtoSrc.orgnizationAddress;
    dtoCopy.biko = dtoSrc.biko;
    dtoCopy.categorizeGroup = dtoSrc.categorizeGroup;
    dtoCopy.note = dtoSrc.note;
    dtoCopy.isDifferPrecedent = dtoSrc.isDifferPrecedent;
    dtoCopy.notCollectReciptKbn = dtoSrc.notCollectReciptKbn;
    dtoCopy.isExpendituresRelatedGrants = dtoSrc.isExpendituresRelatedGrants;

    return dtoCopy;
}