/**
 *csvのセルを表すInterface
 *
 * @export
 * @interface CsvCellInterface
 */
export default interface CsvCellInterface {
    /**
     *cellのデータ。
     *
     * @type {string}
     * @memberof CsvCellInterface
     */
    data: string;
}

/**
 *csvのセルを表すDto
 *
 * @export
 * @class CsvCellDto
 * @implements {CsvCellInterface}
 */
export default class CsvCellDto implements CsvCellInterface{

    /**
     *cellのデータ。
     *
     * @type {string}
     * @memberof CsvCellDto
     */
    data: string;

    /**
     * Creates an instance of CsvCellDto.
     * @memberof CsvCellDto
     */
    constructor(){
        this.data = "";
    }
}
