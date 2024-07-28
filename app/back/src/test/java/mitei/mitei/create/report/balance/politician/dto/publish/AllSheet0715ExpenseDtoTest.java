package mitei.mitei.create.report.balance.politician.dto.publish; // NOPMD

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import mitei.mitei.create.report.balance.politician.constants.GetCurrentResourcePath;

/**
 * AllSheet0715ExpenseDto単体テスト
 */
class AllSheet0715ExpenseDtoTest {
 // CHECKSTYLE:OFF

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0715ExpenseDto allSheet0715ExpenseDto = new AllSheet0715ExpenseDto();

        /**
         * その1
         */
        AllSheetKbn071501Dto allSheetKbn071501Dto = new AllSheetKbn071501Dto();

        Sheet071501OrganizationalActivityExpensesDto sheet1 = new Sheet071501OrganizationalActivityExpensesDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("");
        sheet1.setHimoku("費目");

        Row071415OrdinaryExpensesDto row1 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 支出の目的 */
        row1.setMokuteki("目的");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/12/1"); // NOPMD
        /// ** 支出の相手先名称 */
        row1.setName("支出の相手先名称"); // NOPMD
        /// ** 支出の相手先住所 */
        row1.setJusho("東京都千代田区"); // NOPMD
        /// ** 備考 */
        row1.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row1.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row1.setFlgKouufukin(1);

        sheet1.getList().add(row1);

        allSheetKbn071501Dto.getList().add(sheet1);

        /**
         * その2
         */
        AllSheetKbn071502Dto allSheetKbn071502Dto = new AllSheetKbn071502Dto();

        Sheet071502ElectionRelatedExpensesDto sheet2 = new Sheet071502ElectionRelatedExpensesDto();
        sheet2.setPageTotal(30000L);
        sheet2.setSonotaTotal("");
        sheet2.setHimoku("費目");

        Row071415OrdinaryExpensesDto row2 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row2.setIchirenNo(1);
        /// ** 支出の目的 */
        row2.setMokuteki("目的");
        /// ** 金額 */
        row2.setKingaku(30000L);
        /// ** 発生日 */
        row2.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row2.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row2.setJusho("東京都千代田区");
        /// ** 備考 */
        row2.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row2.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row2.setFlgKouufukin(1);

        sheet2.getList().add(row2);

        allSheetKbn071502Dto.getList().add(sheet2);

        /**
         * その3
         */
        AllSheetKbn071503Dto allSheetKbn071503Dto = new AllSheetKbn071503Dto();

        Sheet071503MagazinePublicationExpensesDto sheet3 = new Sheet071503MagazinePublicationExpensesDto();
        sheet3.setPageTotal(30000L);
        sheet3.setSonotaTotal("");
        sheet3.setHimoku("費目");

        Row071415OrdinaryExpensesDto row3 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row3.setIchirenNo(1);
        /// ** 支出の目的 */
        row3.setMokuteki("目的");
        /// ** 金額 */
        row3.setKingaku(30000L);
        /// ** 発生日 */
        row3.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row3.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row3.setJusho("東京都千代田区");
        /// ** 備考 */
        row3.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row3.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row3.setFlgKouufukin(1);

        sheet3.getList().add(row3);

        allSheetKbn071503Dto.getList().add(sheet3);

        /**
         * その4
         */
        AllSheetKbn071504Dto allSheetKbn071504Dto = new AllSheetKbn071504Dto();

        Sheet071504AdvertisingExpensesDto sheet4 = new Sheet071504AdvertisingExpensesDto();
        sheet4.setPageTotal(30000L);
        sheet4.setSonotaTotal("");
        sheet4.setHimoku("費目");

        Row071415OrdinaryExpensesDto row4 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row4.setIchirenNo(1);
        /// ** 支出の目的 */
        row4.setMokuteki("目的");
        /// ** 金額 */
        row4.setKingaku(30000L);
        /// ** 発生日 */
        row4.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row4.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row4.setJusho("東京都千代田区");
        /// ** 備考 */
        row4.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row4.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row4.setFlgKouufukin(1);

        sheet4.getList().add(row4);

        allSheetKbn071504Dto.getList().add(sheet4);

        /**
         * その5
         */
        AllSheetKbn071505Dto allSheetKbn071505Dto = new AllSheetKbn071505Dto();

        Sheet071505PartyHostingFeeDto sheet5 = new Sheet071505PartyHostingFeeDto();
        sheet5.setPageTotal(30000L);
        sheet5.setSonotaTotal("");
        sheet5.setHimoku("費目");

        Row071415OrdinaryExpensesDto row5 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row5.setIchirenNo(1);
        /// ** 支出の目的 */
        row5.setMokuteki("目的");
        /// ** 金額 */
        row5.setKingaku(30000L);
        /// ** 発生日 */
        row5.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row5.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row5.setJusho("東京都千代田区");
        /// ** 備考 */
        row5.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row5.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row5.setFlgKouufukin(1);

        sheet5.getList().add(row5);

        allSheetKbn071505Dto.getList().add(sheet5);

        /**
         * その6
         */
        AllSheetKbn071506Dto allSheetKbn071506Dto = new AllSheetKbn071506Dto();

        Sheet071506OtherBusinessExpensesDto sheet6 = new Sheet071506OtherBusinessExpensesDto();
        sheet6.setPageTotal(30000L);
        sheet6.setSonotaTotal("");
        sheet6.setHimoku("費目");

        Row071415OrdinaryExpensesDto row6 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row6.setIchirenNo(1);
        /// ** 支出の目的 */
        row6.setMokuteki("目的");
        /// ** 金額 */
        row6.setKingaku(30000L);
        /// ** 発生日 */
        row6.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row6.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row6.setJusho("東京都千代田区");
        /// ** 備考 */
        row6.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row6.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row6.setFlgKouufukin(1);

        sheet6.getList().add(row6);

        allSheetKbn071506Dto.getList().add(sheet6);

        /**
         * その7
         */
        AllSheetKbn071507Dto allSheetKbn071507Dto = new AllSheetKbn071507Dto();

        Sheet071507ResearchExpensesDto sheet7 = new Sheet071507ResearchExpensesDto();
        sheet7.setPageTotal(30000L);
        sheet7.setSonotaTotal("");
        sheet7.setHimoku("費目");

        Row071415OrdinaryExpensesDto row7 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row7.setIchirenNo(1);
        /// ** 支出の目的 */
        row7.setMokuteki("目的");
        /// ** 金額 */
        row7.setKingaku(30000L);
        /// ** 発生日 */
        row7.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row7.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row7.setJusho("東京都千代田区");
        /// ** 備考 */
        row7.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row7.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row7.setFlgKouufukin(1);

        sheet7.getList().add(row7);

        allSheetKbn071507Dto.getList().add(sheet7);

        /**
         * その8
         */
        AllSheetKbn071508Dto allSheetKbn071508Dto = new AllSheetKbn071508Dto();

        Sheet071508DonationsGrantsDto sheet8 = new Sheet071508DonationsGrantsDto();
        sheet8.setPageTotal(30000L);
        sheet8.setSonotaTotal("");
        sheet8.setHimoku("費目");

        Row071415OrdinaryExpensesDto row8 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row8.setIchirenNo(1);
        /// ** 支出の目的 */
        row8.setMokuteki("目的");
        /// ** 金額 */
        row8.setKingaku(30000L);
        /// ** 発生日 */
        row8.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row8.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row8.setJusho("東京都千代田区");
        /// ** 備考 */
        row8.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row8.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row8.setFlgKouufukin(1);

        sheet8.getList().add(row8);

        allSheetKbn071508Dto.getList().add(sheet8);

        /**
         * その9
         */
        AllSheetKbn071509Dto allSheetKbn071509Dto = new AllSheetKbn071509Dto();

        Sheet071509OtherExpensesDto sheet9 = new Sheet071509OtherExpensesDto();
        sheet9.setPageTotal(30000L);
        sheet9.setSonotaTotal("");
        sheet9.setHimoku("費目");

        Row071415OrdinaryExpensesDto row9 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row9.setIchirenNo(1);
        /// ** 支出の目的 */
        row9.setMokuteki("目的");
        /// ** 金額 */
        row9.setKingaku(30000L);
        /// ** 発生日 */
        row9.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row9.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row9.setJusho("東京都千代田区");
        /// ** 備考 */
        row9.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row9.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row9.setFlgKouufukin(1);

        sheet9.getList().add(row9);

        allSheetKbn071509Dto.getList().add(sheet9);

        allSheet0715ExpenseDto.setAllSheetKbn071501Dto(allSheetKbn071501Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071502Dto(allSheetKbn071502Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071503Dto(allSheetKbn071503Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071504Dto(allSheetKbn071504Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071505Dto(allSheetKbn071505Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071506Dto(allSheetKbn071506Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071507Dto(allSheetKbn071507Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071508Dto(allSheetKbn071508Dto);
        allSheet0715ExpenseDto.setAllSheetKbn071509Dto(allSheetKbn071509Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0715ExpenseDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0715.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
