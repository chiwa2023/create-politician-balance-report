package mitei.mitei.create.report.balance.politician.logic.balancesheet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mitei.mitei.create.report.balance.politician.dto.balancesheet.CsvTradingRowConstants;
import mitei.mitei.create.report.balance.politician.dto.read_csv.CsvCellDto;
import mitei.mitei.create.report.balance.politician.entity.BalancesheetOutcome2025Entity;

/**
 * CreateBalancesheetOutcomeByCsvLogic単体テスト
 */
class CreateBalancesheetOutcomeByCsvLogicTest {
    // CHECKSTYLE:OFF

    @Test
    @Tag("TableTruncate")
    void testPractice() { // NOPMD

        CreateBalancesheetOutcomeByCsvLogic createBalancesheetOutcomeByCsvLogic = new CreateBalancesheetOutcomeByCsvLogic();
        
        String[] listPointer = new String[1];
        listPointer[0] = String.valueOf(CsvTradingRowConstants.NO_POINT);
        
        List<CsvCellDto> list = new ArrayList<>();
        CsvCellDto cellDto = new CsvCellDto();
        cellDto.setData("1234");
        list.add(cellDto);
    
        //null許容しません
        assertThrows(IllegalArgumentException.class, () ->  createBalancesheetOutcomeByCsvLogic.practice(list,null));
        assertThrows(IllegalArgumentException.class, () ->  createBalancesheetOutcomeByCsvLogic.practice(null,listPointer));
        
        //空リストを許容しません
        assertThrows(IllegalArgumentException.class, () ->  createBalancesheetOutcomeByCsvLogic.practice(list, new String[0]));
        assertThrows(IllegalArgumentException.class, () ->  createBalancesheetOutcomeByCsvLogic.practice(new ArrayList<>(), listPointer));

        //両方揃っていればとりあえずエラーとしません
        assertDoesNotThrow( () ->  createBalancesheetOutcomeByCsvLogic.practice(list,listPointer));
        
        //日付を指定したら発生日に値がセットされます
        int year = 2022;
        int month = 12;
        int day = 27;
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(year+"/"+month + "/" + day),this.createPointer(CsvTradingRowConstants.ACCURAL_DATE)).getAccrualDate()).isEqualTo(LocalDate.of(year, month, day));

        //収入をセットしたらEntityに何も反映されません
        Long amountIncome = 1431928L;
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(String.valueOf(amountIncome)),this.createPointer(CsvTradingRowConstants.INCOME_AMOUNT)).getAmount()).isEqualTo(0L);

        //支出をセットしたらと取引金額にセットされます
        Long amountOutcome = 987435L;
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(String.valueOf(amountOutcome)),this.createPointer(CsvTradingRowConstants.OUTCOME_AMOUNT)).getAmount()).isEqualTo(amountOutcome);
        
        //増減兼用をセットしたらEntityにマイナスの値はEntityにセットされ、プラスはセットされません
        Long amountPlus = 2187465L;
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(String.valueOf(amountPlus)),this.createPointer(CsvTradingRowConstants.AMOUNT_IN_OUT)).getAmount()).isEqualTo(0L);
        Long amountMinus = -9832655L;
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(String.valueOf(amountMinus)),this.createPointer(CsvTradingRowConstants.AMOUNT_IN_OUT)).getAmount()).isEqualTo(amountMinus);
        
        //摘要をセットしたらEntityに参照がセットされます
        String digestText = "ﾌﾘｺﾐ セイジダンタイ ｻﾌﾞﾛｳ";
        assertThat(createBalancesheetOutcomeByCsvLogic.practice(this.createCell(digestText),this.createPointer(CsvTradingRowConstants.DIGEST)).getReferDigest()).isEqualTo(digestText);

        //指定なしをセットしたらEntityには設定されません
        String noContentText = "1234";
        BalancesheetOutcome2025Entity outcomeEntity1 = createBalancesheetOutcomeByCsvLogic.practice(this.createCell(noContentText),this.createPointer(CsvTradingRowConstants.NO_POINT));
        //日付も取引金額も参照も初期値
        assertThat(outcomeEntity1.getAccrualDate()).isEqualTo(LocalDate.of(1980, 1, 1));
        assertThat(outcomeEntity1.getAmount()).isEqualTo(0L);
        assertThat(outcomeEntity1.getReferDigest()).isEqualTo("");

        //わけのわからない値を入れられても何もしません(というか・・・そもそも訳の分からない列指定をさせません)
        String otherText = "1234";
        BalancesheetOutcome2025Entity outcomeEntity2 = createBalancesheetOutcomeByCsvLogic.practice(this.createCell(otherText),this.createPointer(52374));
        //日付も取引金額も参照も初期値
        assertThat(outcomeEntity2.getAccrualDate()).isEqualTo(LocalDate.of(1980, 1, 1));
        assertThat(outcomeEntity2.getAmount()).isEqualTo(0L);
        assertThat(outcomeEntity2.getReferDigest()).isEqualTo("");

        //取引金額に数字以外を指定したら例外で処理を中断する必要があります
        String dirtyNumber = "あかさたな";
        assertThrows(NumberFormatException.class,() -> createBalancesheetOutcomeByCsvLogic.practice(this.createCell(dirtyNumber),this.createPointer(CsvTradingRowConstants.OUTCOME_AMOUNT)).getAmount());
        assertThrows(NumberFormatException.class,() -> createBalancesheetOutcomeByCsvLogic.practice(this.createCell(dirtyNumber),this.createPointer(CsvTradingRowConstants.AMOUNT_IN_OUT)).getAmount());

        //日付に変換不能な文字列が指定されたら例外で処理を中断する必要があります
        String dirtyDate = "はまやらわ";
        assertThrows(DateTimeParseException.class,() -> createBalancesheetOutcomeByCsvLogic.practice(this.createCell(dirtyDate),this.createPointer(CsvTradingRowConstants.ACCURAL_DATE)).getAccrualDate());
        
        //日付、金額、参照すべてを入れても混線しません
        List<CsvCellDto> listAll = new ArrayList<>();
        CsvCellDto cellDto1 = new CsvCellDto();
        cellDto1.setData(String.valueOf(amountOutcome));
        CsvCellDto cellDto2 = new CsvCellDto();
        cellDto2.setData(year+"/"+month + "/" + day);
        CsvCellDto cellDto3 = new CsvCellDto();
        cellDto3.setData("ほにゃらら");
        CsvCellDto cellDto4 = new CsvCellDto();
        cellDto4.setData(digestText);
        listAll.add(cellDto1);
        listAll.add(cellDto2);
        listAll.add(cellDto3);
        listAll.add(cellDto4);
        
        String[] pointerAll = new String[4];
        pointerAll[0] = String.valueOf(CsvTradingRowConstants.OUTCOME_AMOUNT);
        pointerAll[1] = String.valueOf(CsvTradingRowConstants.ACCURAL_DATE);
        pointerAll[2] = String.valueOf(CsvTradingRowConstants.NO_POINT);
        pointerAll[3] = String.valueOf(CsvTradingRowConstants.DIGEST);
        
        BalancesheetOutcome2025Entity outcomeEntity3 = createBalancesheetOutcomeByCsvLogic.practice(listAll,pointerAll);

        assertThat(outcomeEntity3.getAccrualDate()).isEqualTo(LocalDate.of(year, month, day));
        assertThat(outcomeEntity3.getAmount()).isEqualTo(amountOutcome);
        assertThat(outcomeEntity3.getReferDigest()).isEqualTo(digestText);

        //発生日を2回以上指定するようなことも別ロジックで排除するのでテストしません(仮にあった場合は最終値が回答)
    }

    private List<CsvCellDto> createCell(final String data){

        List<CsvCellDto> list = new ArrayList<>();
        CsvCellDto cellDto = new CsvCellDto();
        cellDto.setData(data);
        list.add(cellDto);

        return list;
    }

    private String[] createPointer(final Integer data){

        String[] listPointer = new String[1];
        listPointer[0] = String.valueOf(data);

        return listPointer;
    }

}
