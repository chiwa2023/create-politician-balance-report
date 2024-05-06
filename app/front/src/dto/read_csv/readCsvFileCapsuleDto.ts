import AbstactCapsuleDto from "../abstactCapsuleDto";

export default class ReadCsvFileCapsuleDto extends AbstactCapsuleDto {

    /** ファイル名 */
    fileName: string;

    /** ファイル内容文字列 */
    fileContent: string;

    constructor() {
        super();
        this.fileName = "";
        this.fileContent = "";
    }

}