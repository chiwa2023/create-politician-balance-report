import CheckPrivilegeDto from "../common_check/checkPrivilegeDto";
import CheckSecurityDto from "../common_check/checkSecurityDto";
import CheckTransactionDto from "../common_check/checkTransactionDto";

export default class TaskPlanSearchConditonCapsuleDto {

    /** 権限確認Dto  */
    checkPrivilegeDto: CheckPrivilegeDto;

    /** セキュリティ確認Dto  */
    checkSecurityDto: CheckSecurityDto;

    /** 排他確認Dto  */
    checkTransactionDto: CheckTransactionDto;

    constructor() {

        this.checkPrivilegeDto = new CheckPrivilegeDto;
        this.checkSecurityDto = new CheckSecurityDto;
        this.checkTransactionDto = new CheckTransactionDto;

    }

}