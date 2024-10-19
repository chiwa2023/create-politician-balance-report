import PoliticalOrganizationSelectOptionDto from "./politicalOrganizationSelectOptionDto";
import TaskPlanSelectOptionDto from "./taskPlanSelectOptionDto";

export default class TaskPlanResultDto {

    /** 未処理タスクリスト */
    listTaskPlanSelect: TaskPlanSelectOptionDto[];

    /** 所属政治団体リスト  */
    listPoliticalOrganizationSelect: PoliticalOrganizationSelectOptionDto[];

    constructor() {
        this.listTaskPlanSelect = [];
        this.listPoliticalOrganizationSelect = [];

    }
}