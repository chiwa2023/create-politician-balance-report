import PoliticalOrganizationSelectOptionDto from "./politicalOrganizationSelectOptionDto";
import TaskPlanSelectOptionDto from "./taskPlanSelectOptionDto";

export default interface TaskPlanResultInterface {

        /** 未処理タスクリスト */
        listTaskPlanSelect: TaskPlanSelectOptionDto[];

        /** 所属政治団体リスト  */
        listPoliticalOrganizationSelect: PoliticalOrganizationSelectOptionDto[];
    
}

export default class TaskPlanResultDto implements TaskPlanResultInterface{

    /** 未処理タスクリスト */
    listTaskPlanSelect: TaskPlanSelectOptionDto[];

    /** 所属政治団体リスト  */
    listPoliticalOrganizationSelect: PoliticalOrganizationSelectOptionDto[];

    constructor() {
        this.listTaskPlanSelect = [];
        this.listPoliticalOrganizationSelect = [];

    }
}