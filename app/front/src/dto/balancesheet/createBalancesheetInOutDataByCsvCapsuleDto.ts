import AbstactCapsuleDto from "../abstactCapsuleDto";
import CsvCellInterface from "../read_csv/csvCell";
import SaveStorageResultDto from "../storage/saveStorageResultDto";

/**
 * 政治資金収支報告書収入・支出項目リスト作成カプセルDto
 */
export default class CreateBalancesheetInOutDataByCsvCapsuleDto extends AbstactCapsuleDto{

    ///** csvデータにヘッダの有無*/
    //hasHeader: boolean;

    /** 書証情報*/
    saveStorageResultDto: SaveStorageResultDto;

    /** csv読み取り結びつけ情報 */
    listPointer: string[];

    /** csv読み取りデータ */
    listCsvData: [CsvCellInterface[]];

    constructor() {
        super();
        //this.hasHeader = true;
        this.saveStorageResultDto = new SaveStorageResultDto();
        this.listCsvData = [[]];
        this.listPointer = [];
    }
}