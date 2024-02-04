package mitei.mitei.create.report.balance.politician.publish.validate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.publish.AllSheet0703JournalAndOtherDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Row070300JournalAndOtherDto;
import mitei.mitei.create.report.balance.politician.dto.publish.Sheet070300JournalAndOtherDto;

/**
 * Validate070300AllSheetLogic単体テスト
 */
class Validate070300AllSheetLogicTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void test() throws Exception {

        Validate070300AllSheetLogic validate070300AllSheetLogic = new Validate070300AllSheetLogic();

        assertThrows(BalanceReportRequiredInputException.class, () -> validate070300AllSheetLogic.practice(null),
                "引数がnull");

        AllSheet0703JournalAndOtherDto allSheetDto = new AllSheet0703JournalAndOtherDto();
        assertThrows(BalanceReportRequiredInputException.class, () -> validate070300AllSheetLogic.practice(allSheetDto),
                "0703シートがnull");

        Sheet070300JournalAndOtherDto sheet0703 = new Sheet070300JournalAndOtherDto();
        allSheetDto.setSheet070300JournalAndOtherDto(sheet0703);

        // リスト0・正常
        assertThat(validate070300AllSheetLogic.practice(allSheetDto))
                .isEqualTo(MakeUmuInputTextLogic.NASHI_INPUT_DATA_FLUG);

        // リスト0・小計に0でない値が入っていて例外
        sheet0703.setPageTotal(999L);
        assertThrows(BalanceReportDoesNotMatchSumException.class,
                () -> validate070300AllSheetLogic.practice(allSheetDto), "ページ計が0でない");

        // リスト1以上
        Row070300JournalAndOtherDto row1 = new Row070300JournalAndOtherDto();
        row1.setIchirenNo(1);
        row1.setJigyoNoShurui("事業の種類1");
        row1.setKingaku(300L);
        sheet0703.getList().add(row1);
        sheet0703.setPageTotal(300L);
        assertThat(validate070300AllSheetLogic.practice(allSheetDto))
                .isEqualTo(MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG);

        // リスト1以上・ページ計が差し引き0になっても正常
        Row070300JournalAndOtherDto row2 = new Row070300JournalAndOtherDto();
        row2.setIchirenNo(2);
        row2.setJigyoNoShurui("事業の種類2");
        row2.setKingaku(-300L);
        sheet0703.getList().add(row2);
        sheet0703.setPageTotal(0L);
        assertThat(validate070300AllSheetLogic.practice(allSheetDto))
                .isEqualTo(MakeUmuInputTextLogic.ARI_INPUT_DATA_FLUG);

        // リストにデータが存在・小計に合計でない値が入っていて例外
        sheet0703.setPageTotal(999L);
        assertThrows(BalanceReportDoesNotMatchSumException.class,
                () -> validate070300AllSheetLogic.practice(allSheetDto), "ページ計が一致していない");

        // 連番が不正
        sheet0703.setPageTotal(0L);
        Row070300JournalAndOtherDto row3 = new Row070300JournalAndOtherDto();
        row3.setIchirenNo(99);
        row3.setKingaku(0L);
        sheet0703.getList().add(row3);
        assertThrows(BalanceReportIchirenNoNotOrderException.class,
                () -> validate070300AllSheetLogic.practice(allSheetDto), "連番が不正");

        // 備考以外が未入力でが不正
        sheet0703.getList().get(2).setIchirenNo(3);
        assertThrows(BalanceReportRequiredInputException.class, () -> validate070300AllSheetLogic.practice(allSheetDto),
                "備考以外が未入力");

    }

}
