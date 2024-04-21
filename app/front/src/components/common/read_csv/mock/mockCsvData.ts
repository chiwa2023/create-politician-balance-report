import CsvCellInterface from "../../../../dto/read_csv/csvCell";
import CsvCellDto from "../../../../dto/read_csv/csvCell";

/**
 * csvダミーデータ
 * @returns 二次元Csvセルデータ
 */
export default function mockCsvData(): [CsvCellInterface[]] {

    //年月日,お引出し,お預入れ,お取り扱い内容,残高,メモ,ラベル

    const list1: CsvCellInterface[] = [];
    list1.push(createDto("年月日"));
    list1.push(createDto("お引出し"));
    list1.push(createDto("お預入れ"));
    list1.push(createDto("お取り扱い内容"));
    list1.push(createDto("残高"));
    list1.push(createDto("メモ"));
    list1.push(createDto("ラベル"));

    const list2: CsvCellInterface[] = [];
    list2.push(createDto("2022-12-01"));
    list2.push(createDto(""));
    list2.push(createDto("40000"));
    list2.push(createDto("ﾌﾘｺﾐﾆｭｳｷﾝ ｼｴﾝｼｬﾊﾅｺ"));
    list2.push(createDto("99999"));
    list2.push(createDto("メモ1"));
    list2.push(createDto("ラベル1"));

    const list3: CsvCellInterface[] = [];
    list3.push(createDto("2022-12-01"));
    list3.push(createDto("60000"));
    list3.push(createDto(""));
    list3.push(createDto("ﾌﾘｺﾐ ﾁﾎｳｷﾞｲﾝ1"));
    list3.push(createDto("99999"));
    list3.push(createDto("メモ2"));
    list3.push(createDto("ラベル2"));

    const listAll: [CsvCellInterface[]] = [[]];
    listAll.splice(0);

    listAll.push(list1);
    listAll.push(list2);
    listAll.push(list3);

    return listAll;
}

/**
 * csvセル生成
 * @param data セルデータ
 * @returns CsvCellDto
 */
function createDto(data: string) {
    const csvCell: CsvCellDto = new CsvCellDto();
    csvCell.data = data;

    return csvCell;
}