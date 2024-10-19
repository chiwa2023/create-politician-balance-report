import SelectOptionDto from "../selectOptionDto";

export default class TaskPlanSelectOptionDto extends SelectOptionDto {

    /** 政治資金団体Id */
    politicalOrganizationId: number;

    /** 政治資金団体同一識別コード */
    politicalOrganizationCode: number;

    /** 政治資金団体名称 */
    politicalOrganizationName: string;


    constructor() {
        super();

        const INIT_NUMBER = 0;
        const INIT_STRING = "";

        this.politicalOrganizationId = INIT_NUMBER;
        this.politicalOrganizationCode = INIT_NUMBER;
        this.politicalOrganizationName = INIT_STRING;

    }

}