package mitei.mitei.create.report.balance.politician.dto.publish;

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
 * AllSheet0714ConstsDto単体テスト
 */
class AllSheet0714ConstsDtoTest {
    // CHECKSTYLE:OFF MagicNumber

    @Test
    void testConvretXml() throws Exception { // NOPMD

        AllSheet0714ConstsDto allSheet0714ConstsDto = new AllSheet0714ConstsDto();

        // その1
        Sheet071401UtilityCostsDto sheet1 = new Sheet071401UtilityCostsDto();
        sheet1.setPageTotal(30000L);
        sheet1.setSonotaTotal("");

        Row071415OrdinaryExpensesDto row1 = new Row071415OrdinaryExpensesDto();
        /// ** 連番 */
        row1.setIchirenNo(1);
        /// ** 支出の目的 */
        row1.setMokuteki("目的");
        /// ** 金額 */
        row1.setKingaku(30000L);
        /// ** 発生日 */
        row1.setDate("R4/12/1");
        /// ** 支出の相手先名称 */
        row1.setName("支出の相手先名称");
        /// ** 支出の相手先住所 */
        row1.setJusho("東京都千代田区");
        /// ** 備考 */
        row1.setBiko("備考");
        /// ** 領収書を徴しがたかったフラグ */
        row1.setFlgRyoushuusho(0);
        /// ** 交付金に係る支出フラグ */
        row1.setFlgKouufukin(1);

        sheet1.getList().add(row1);

        // その２
        Sheet071402EquipmentCostsDto sheet2 = new Sheet071402EquipmentCostsDto();
        sheet2.setPageTotal(30000L);
        sheet2.setSonotaTotal("");

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

        Sheet071403OfficeExpensesDto sheet3 = new Sheet071403OfficeExpensesDto();
        sheet3.setPageTotal(30000L);
        sheet3.setSonotaTotal("");

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

        // 区分ごとにまとめる
        AllSheetKbn071401Dto allSheetKbn071401Dto = new AllSheetKbn071401Dto();
        allSheetKbn071401Dto.setSheet071401UtilityCostsDto(sheet1);
        AllSheetKbn071402Dto allSheetKbn071402Dto = new AllSheetKbn071402Dto();
        allSheetKbn071402Dto.setSheet071402EquipmentCostsDto(sheet2);
        AllSheetKbn071403Dto allSheetKbn071403Dto = new AllSheetKbn071403Dto();
        allSheetKbn071403Dto.setSheet071403OfficeExpensesDto(sheet3);

        // 区分データを挿入
        allSheet0714ConstsDto.setAllSheetKbn071401Dto(allSheetKbn071401Dto);
        allSheet0714ConstsDto.setAllSheetKbn071402Dto(allSheetKbn071402Dto);
        allSheet0714ConstsDto.setAllSheetKbn071403Dto(allSheetKbn071403Dto);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(Include.ALWAYS);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String xml1 = xmlMapper.writeValueAsString(allSheet0714ConstsDto);

        Path pathAnswer1 = Paths.get(GetCurrentResourcePath.getBackTestResourcePath(),
                "dto/publish/all_sheet_0714.txt");
        String answer1 = Files.readString(pathAnswer1);

        assertThat(xml1).isEqualTo(answer1);

    }

}
