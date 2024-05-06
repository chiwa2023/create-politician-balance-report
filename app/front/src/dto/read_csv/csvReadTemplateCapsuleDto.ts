import AbstactCapsuleDto from "../abstactCapsuleDto";

export default class CsvReadTemplateCapsuleDto extends AbstactCapsuleDto {

    /** csv読み取り列数 */
    arrayNumber: number;

    constructor() {
        super();
        this.arrayNumber = 0;
    }
}