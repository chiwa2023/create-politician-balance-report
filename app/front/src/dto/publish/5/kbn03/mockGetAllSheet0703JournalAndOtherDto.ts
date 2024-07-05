import { AllSheet0703JournalAndOtherDto } from "./allSheet0703JournalAndOtherDto";
import Row070300JournalAndOtherDto from "./row070300JournalAndOtherDto";
import Sheet070300JournalAndOtherDto from "./sheet070300JournalAndOtherDto";

export default function mockGetAllSheet0703JournalAndOtherDto(): AllSheet0703JournalAndOtherDto {

    //1行目
    const row1: Row070300JournalAndOtherDto = new Row070300JournalAndOtherDto();
    row1.ichirenNo = 1;
    row1.jigyoNoShurui = "機関誌1";
    row1.kingaku = 1;
    row1.biko = "備考1";

    //2行目
    const row2: Row070300JournalAndOtherDto = new Row070300JournalAndOtherDto();
    row2.ichirenNo = 2;
    row2.jigyoNoShurui = "機関誌2";
    row2.kingaku = 2;
    row2.biko = "備考2";

    //シート
    const sheet070300JournalAndOtherDto: Sheet070300JournalAndOtherDto = new Sheet070300JournalAndOtherDto();

    //シートに行追加
    sheet070300JournalAndOtherDto.list.push(row1);
    sheet070300JournalAndOtherDto.list.push(row2);

    //全シート
    const allSheet0703JournalAndOtherDto: AllSheet0703JournalAndOtherDto = new AllSheet0703JournalAndOtherDto();

    //全シートにシート
    allSheet0703JournalAndOtherDto.sheet070300JournalAndOtherDto = sheet070300JournalAndOtherDto;

    return allSheet0703JournalAndOtherDto;
}